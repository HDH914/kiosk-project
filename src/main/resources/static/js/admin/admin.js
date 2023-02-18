const menuList = document.querySelector(".menu-list");
const searchInput = document.querySelector(".search-input");
const searchButton = document.querySelector(".search-button");
const logout = document.querySelector(".logout-icon");
const categorySelectInput = document.querySelector(".search-category .category-input");
let page = 1;
let category = "6";
let searchValue = "";


loadMenuListRequest(searchValue);

searchInput.onkeyup = () => {
    if (window.event.keyCode === 13) {
        searchButton.click();
    }
}

searchButton.onclick = () => {
    searchValue = searchInput.value;
    loadMenuListRequest(searchValue);
}

function loadMenuListRequest(searchValue) {
    let responseData = null;

    $.ajax({
        async: false,
        type: "get",
        url: "/api/menu/menulist",
        data: {
            "page": page,
            "category": category,
            "searchValue": searchValue

        },
        dataType: "json",
        success: (response) => {
            responseData = response.data;

            if (responseData.length != 0) {
                loadMenuList(responseData);
                loadPageNumberButtons(responseData[0].menuTotalCount);
            }
            // else {
            //     console.log(responseData)
            //     alert("해당 카테고리의 상품이 없습니다.");
            //     // location.reload();
            // }
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

// 카테고리
categorySelectInput.onchange = () => {
    page = 1;
    category = categorySelectInput.value;
    console.log(category);
    loadMenuListRequest();
}

// 페이징 처리
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

    for (let i = 0; i < pageButton.length; i++) {
        pageButton[i].onclick = () => {
            let pageNum = pageButton[i].textContent;
            if (pageNum == "<") {
                --page;
            } else if (pageNum == ">") {
                ++page;
            } else {
                page = pageNum;
            }
            console.log(page);
            loadMenuListRequest();
        }
    }

    // pageButton.forEach(pageNum => {
    //     pageNum.onclick = () => {
    //         // let pageNum = pageButton.textContent;
    //         if (pageNum == "<") {
    //             --page;
    //         } else if (pageNum == ">") {
    //             ++page;
    //         } else {
    //             page = pageNum;
    //         }
    //         // loadMenuListRequest();
    //     }
    // })

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