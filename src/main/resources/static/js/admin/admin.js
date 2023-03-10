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
// 카테고리
categorySelectInput.onchange = () => {
    page = 1;
    category = categorySelectInput.value;
    loadMenuListRequest(searchValue);
}

// 로그아웃
logout.onclick = () => {
    let msg = null;
    msg = confirm("로그아웃 하시겠습니까?");
    if (msg) {
        alert("로그아웃 되었습니다.");
        location.href = "/main";
    }
}

// 메뉴 정보 요청
function loadMenuListRequest(searchValue) {


    $.ajax({
        type: "get",
        url: "/api/menu/admin/menulist",
        data: {
            "page": page,
            "category": category,
            "searchValue": searchValue
        },
        dataType: "json",
        success: (response) => {
            const responseData = response.data;
            if (responseData.length != 0) {
                loadMenuList(responseData);
                loadPageNumberButtons(responseData[0].menuTotalCount);
                modificationMenu(responseData);
                deleteMenu(responseData);
            }
            else {
                noSearchMenu();
            }
        },
        error: (error) => {
            console.log(error);
        }
    })
}

// 메뉴 리스트 띄우기
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
                    <button class="modification-button">수정</button>
                    <button class="delete-button">삭제</button>
                </td>
            </tr>
            `;
    });
}

function noSearchMenu() {
    const noMenuList = document.querySelector(".menu");

    noMenuList.innerHTML = "";

    noMenuList.innerHTML = `
        <div class="no-menu">
            <div class="xmark">
                <i class="fa-sharp fa-solid fa-circle-xmark"></i>
            </div>
            <div class="no-menu-content">
                <h1>검색에 해당되는 결과가 없습니다.</h1>
            </div>
        </div>
    `
}



// 페이징 처리
function loadPageNumberButtons(menuTotalCount) {
    const pageButtons = document.querySelector(".page-buttons");
    let maxPage = (menuTotalCount % 15 == 0) ? menuTotalCount / 15 : Math.floor(menuTotalCount / 15) + 1;
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
           <a href="javascript:void(0)"><li><</li></a>
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
            <a href="javascript:void(0)"><li>></li></a>
        `;
    }

    const pageButton = pageButtons.querySelectorAll("li");  // NodeList

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

            console.log("page => ");
            console.log(page);
            loadMenuListRequest(searchValue);
        }
    }
}

function modificationMenu(responseData) {
    const modificationButtons = document.querySelectorAll(".modification-button");
    modificationButtons.forEach((modificationButton, index) => {
        modificationButton.onclick = () => {
            const data = responseData[index];
            const id = parseInt(data.id);
            location.href = `/admin/modification/${id}`;
        };
    });
}

function deleteMenu(responseData) {
    const deleteButtons = document.querySelectorAll(".delete-button");
    deleteButtons.forEach((deleteButton, index) => {
        deleteButton.onclick = () => {
            const data = responseData[index];
            const id = parseInt(data.id);
            if (confirm("정말 메뉴를 삭제하시겠습니까?")) {
                $.ajax({
                    async: false,
                    type: "delete",
                    url: "/api/menu/admin/delete/" + id,
                    dataType: "json",
                    success: (response) => {
                        alert("메뉴를 삭제하였습니다.");
                        location.reload();
                    },
                    error: (error) => {
                        alert("상품 삭제 실패.");
                        console.log(error);
                    }
                });
            }
        }

    })

}