const menuList = document.querySelector(".menu-list");
const searchInput = document.querySelector(".search-input");
const searchButton = document.querySelector(".search-button");
const logout = document.querySelector(".logout-icon");
const categorySelectInput = document.querySelector(".search-category .category-input");
let page = 1;
let category = "6";
let searchValue = "";

searchInput.addEventListener("keyup", (event) => {
    if (event.keyCode === 13) {
        searchButton.click();
    }
});

searchButton.addEventListener("click", () => {
    searchValue = searchInput.value;
    loadMenuListRequest(searchValue);
});

function loadMenuListRequest(searchValue) {
    fetch(`/api/menu/menulist?page=${page}&category=${category}&searchValue=${searchValue}`)
        .then((response) => response.json())
        .then((responseData) => {
            if (responseData.length !== 0) {
                loadMenuList(responseData);
                loadPageNumberButtons(responseData[0].menuTotalCount);
            } else {
                console.log(responseData);
                alert("해당 카테고리의 상품이 없습니다.");
                // location.reload();
            }
        })
        .catch((error) => {
            console.log(error);
        });
}

function loadMenuList(responseData) {
    const menuList = document.querySelector(".menu");
    menuList.innerHTML = "";

    responseData.forEach((data) => {
        const row = document.createElement("tr");
        row.classList.add("menu-list");

        const idCell = document.createElement("td");
        idCell.classList.add("id");
        idCell.textContent = data.id;
        row.appendChild(idCell);

        const imageCell = document.createElement("td");
        imageCell.classList.add("menu-image");
        const image = document.createElement("img");
        image.src = `/image/menu/${data.menuImg.temp_name}`;
        image.alt = "menu-image";
        imageCell.appendChild(image);
        row.appendChild(imageCell);

    })
}
