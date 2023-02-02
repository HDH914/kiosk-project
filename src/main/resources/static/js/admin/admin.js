const menuList = document.querySelector(".menu-list");
const searchInput = document.querySelector(".search-input");
const searchButton = document.querySelector(".search-button");
let searchValue = "";

searchInput.onkeyup = () => {
    if (window.event.keyCode === 13) {
        searchButton.click();
    }
}

searchButton.onclick = () => {
    alert("클릭됨");
    searchValue = searchInput.value;
    loadMenuListRequest(searchValue);
}



function loadMenuListRequest() {
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
            alert("불러오기 성공");
            console.log("메뉴 데이터");
            console.log(responseData);
        },
        error: (error) => {
            console.log(error);
        }

    })
}

