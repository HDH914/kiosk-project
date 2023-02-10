const menuList = document.querySelector(".menu-list");
const searchInput = document.querySelector(".search-input");
const searchButton = document.querySelector(".search-button");
const logout = document.querySelector(".logout-icon");
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
            "searchValue": searchValue
        },
        dataType: "json",
        success: (response) => {
            responseData = response.data;
            loadMenuList(responseData);
        },
        error: (error) => {
            console.log(error);
        }

    })
}

function loadMenuList(responseData) {
    const menuList = document.querySelector(".menu");
    console.log(responseData)
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

logout.onclick = () => {
    let msg = null;
    msg = confirm("로그아웃 하시겠습니까?");
    if (msg) {
        alert("로그아웃 되었습니다.");
        location.href = "/main";
    }
}