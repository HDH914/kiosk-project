const menuList = document.querySelector(".menu-list");
const searchInput = document.querySelector(".search-input");
const searchButton = document.querySelector(".search-button");
const logout = document.querySelector(".logout-icon");
let searchValue = "";
let page = 1;

loadMenuListRequest(searchValue, page);

searchInput.onkeyup = () => {
    if (window.event.keyCode === 13) {
        searchButton.click();
    }
}

searchButton.onclick = () => {
    searchValue = searchInput.value;
    loadMenuListRequest(searchValue);
}

function loadMenuListRequest(searchValue, page) {
    let responseData = null;

    $.ajax({
        async: false,
        type: "get",
        url: "/api/menu/menulist",
        data: {
            "searchValue": searchValue,
            "page": page
        },
        dataType: "json",
        success: (response) => {
            responseData = response.data;
            loadMenuList(responseData);
            loadPageNumberButtons(responseData[0].menuTotalCount);
        },
        error: (error) => {
            console.log(error);
        }

    })
}

function loadMenuList(responseData) {
    const menuList = document.querySelector(".menu");
    menuList.innerHTML = "";

    responseData.forEach((data) => {
        menuList.innerHTML += `
            <tr class="menu-list">
                <td class="id">${data.id}</td>
                <td class="menu-image">
                    <img  src="/image/menu/${data.menuImg.temp_name}" alt="menu-image">
                </td>
                <td class="menu-category">${data.categoryName}</td>
                <td class="menu-name">${data.menuName}</td>
                <td class="menu-price">${data.price}<span>원</span></td>
                <td class="memo">${data.memo}</td>
                <td class="menu-button buttons">
                    <a class="modification-button" href="/admin/modification/${data.id}">수정</a>
                    <a class="delete-button" href="">삭제</a>
                </td>
            </tr>
            `;
    });
}

///////////////////////////////////////////////////////////////////////////////////////////////////
function loadPageNumberButtons(menuTotalCount) {
    const pageButtons = document.querySelector(".page-buttons");
    let maxPage = (menuTotalCount % 10 == 0) ? menuTotalCount / 10 : Math.floor(menuTotalCount / 10) + 1;
    let minPage = 1;
    let startIndex = page % 5 == 0 ? page - 4 : page - (page % 5) + 1;
    let endIndex = startIndex + 4 <= maxPage ? startIndex + 4 : maxPage;

    pageButtons.innerHTML = "";

    console.log(`
    page = ${page}
    totalCount = ${menuTotalCount}
    maxPage = ${maxPage}
    startIndex = ${startIndex}
    endIndex = ${endIndex}
    `);

    if (page != 1) {
        pageButtons.innerHTML = `
            <a href="javascript:void(0)">
                <li>
                    &#60;
                </li>
            </a>    
        `;
    }
    for (let i = startIndex; i <= endIndex; i++) {
        if (i == page) {
            pageButtons.innerHTML += `
           <a href="javascript:void(0)"><li class="page-button selected">${i}</li></a>
        `;
        } else {
            pageButtons.innerHTML += `
           <a href="javascript:void(0)"><li class="page-button">${i}</li></a>
        `;
        }
    }

    if (page != maxPage) {
        pageButtons.innerHTML += `
            <a href="javascript:void(0)">
                <li>
                    &#62;
                </li>
            </a>
        `;
    }

    let pageButton = pageButtons.querySelectorAll("li");  // NodeList
    pageButton.forEach(pageNum => {
        pageNum.onclick = () => {
            if (pageNum == "<") {
                --page;
            } else if (pageNum == ">") {
                ++page;
            } else {
                page = pageNum;
            }
            console.log("페이지 버튼 클릭");
            loadMenuListRequest(page);
        }
    })

}
///////////////////////////////////////////////////////////////////////////////////////////////////
logout.onclick = () => {
    let msg = null;
    msg = confirm("로그아웃 하시겠습니까?");
    if (msg) {
        alert("로그아웃 되었습니다.");
        location.href = "/main";
    }
}