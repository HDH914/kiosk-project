const home = document.querySelector(".home");
// const totalMenu = document.querySelector(".total-menu");
const season = document.querySelector(".season");
const coffee = document.querySelector(".coffee");
const beverage = document.querySelector(".beverage");
const tea = document.querySelector(".tea");
const desert = document.querySelector(".desert");





loadMenuList();
function loadMenuList() {
    let responseData = null;
    $.ajax({
        async: false,
        type: "get",
        url: "/api/menu/menulist",
        // dataType: "jspn",
        success: (response) => {
            responseData = response.data;
            console.log("불러오기 성공")
            console.log(responseData)
            loadMenu(responseData);
        },
        error: (error) => {
            console.log("불러오기 실패")
            console.log(error)
        }
    })
}

function loadMenu(responseData) {
    const menus = document.querySelector(".menus");
    let categoryId = ${ data.categoryId };

    menus.innerHTML = "";
    responseData.forEach((data) => {
        menus.innerHTML += `
        <li class="menu">
            <input class="menu-id" type="text" value="${data.id}">
            <input class="menu-category" type="text" value="${data.categoryId}">
            <div>
                <img src="/image/menu/${data.menuImg.temp_name}" alt="">
            </div>
            <div class="menu-name">${data.menuName}</div>
            <div class="menu-price">${data.price}<span>원</span></div>
        </li>
        `
    });

    if ()
}

home.onclick = () => {
    location.href = "/";
}

// totalMenu.onclick = () => {

// }

function clickSeason() {
    season.onclick = () => {

    }
}

function clickoffee() {
    coffee.onclick = () => {

    }
}

function clickBeverage() {
    beverage.onclick = () => {

    }
}

function clickTea() {
    tea.onclick = () => {

    }
}

function clickDesert() {
    desert.onclick = () => {

    }
}

