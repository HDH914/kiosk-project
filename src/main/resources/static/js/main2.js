
const home = document.querySelector(".home");
const season = document.querySelector(".season");
const coffee = document.querySelector(".coffee");
const beverage = document.querySelector(".beverage");
const tea = document.querySelector(".tea");
const desert = document.querySelector(".desert");
const menus = document.querySelector(".menus");
const menuListArea = document.querySelector(".menu-list");
const totalPriceAmount = document.querySelector(".total-price-amount");
const deleteButton = document.querySelector(".delete-button");



loadMenuList();
menuClick();

function loadMenuList() {
    let responseData = null;
    $.ajax({
        async: false,
        type: "get",
        url: "/api/menu/menulist",
        // dataType: "json",
        success: (response) => {
            responseData = response.data;
            console.log(responseData);
            clickSeason(responseData);
            clickoffee(responseData);
            clickBeverage(responseData);
            clickTea(responseData);
            clickDesert(responseData);
            season.click();
        },
        error: (error) => {
            console.log("불러오기 실패");
            console.log(error)
        }
    })
}

function clickSeason(responseData) {
    season.onclick = () => {
        menus.innerHTML = "";
        responseData.forEach((data) => {
            if (data.categoryId == 1) {
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
            }
        });
    }
}

function clickoffee(responseData) {
    coffee.onclick = () => {
        menus.innerHTML = "";
        responseData.forEach((data) => {
            if (data.categoryId == 2) {
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
            }
        });
    }
}

function clickBeverage(responseData) {
    beverage.onclick = () => {
        menus.innerHTML = "";
        responseData.forEach((data) => {
            if (data.categoryId == 3) {
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
            }
        });
    }
}

function clickTea(responseData) {
    tea.onclick = () => {
        menus.innerHTML = "";
        responseData.forEach((data) => {
            if (data.categoryId == 4) {
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
            }
        });
    }
}

function clickDesert(responseData) {
    desert.onclick = () => {
        menus.innerHTML = "";
        responseData.forEach((data) => {
            if (data.categoryId == 5) {
                menus.innerHTML += `
                <li class="menu" name="menu">
                    <input class="menu-id" type="text" value="${data.id}">
                    <input class="menu-category" type="text" value="${data.categoryId}">
                    <div>
                        <img src="/image/menu/${data.menuImg.temp_name}" alt="">
                    </div>
                    <div class="menu-name">${data.menuName}</div>
                    <div class="menu-name">${data.price}<span>원</span></div>
                </li>
                `
            }
        });
    }
}

function menuClick() {
    const deleteIcon = document.querySelectorAll(".delete-icon")
    let menu = menus.querySelectorAll(".menu");
    let menuList = {};

    menuListArea.innerHTML = "";

    menu.forEach((selectedMenu) => {
        selectedMenu.onclick = () => {
            let name = selectedMenu.querySelector(".menu-name").innerText;
            let price = selectedMenu.querySelector(".menu-price").innerText;

            if (menuList.hasOwnProperty(name)) {
                menuList[name].count++;
            } else {
                menuList[name] = {
                    count: 1,
                    price: parseInt(price),
                };
            }
            console.log(menuList)
            menuListArea.innerHTML += `
                <div class="menu-info">
                <div class="selected-menu-name">
                    <span>${name}</span>
                </div>
                <div class="menu-count">
                    <span>1개</span>
                </div>
                <div class="price">
                    <span>${menuList[name].price}원</span>
                </div>
                <div class="delete-menu">
                    <i class="far fa-trash-alt delete-icon"></i>
                </div>
                </div>
            `;
            // <span>${menuList[name].price * menuList[name].count}원</span>

            let totalPrice = Object.values(menuList).reduce(
                (acc, item) => acc + item.count * item.price,
                0
            );
            totalPriceAmount.innerHTML = `${totalPrice}<span>원</span>`;

            // 해당 메뉴 삭제
            deleteIcon.onclick = () => {
                console.log("삭제 아이콘 클릭");
                menuListArea.innerHTML = "";
            };
            // 전체 메뉴 삭제
            deleteButton.onclick = () => {
                let msg = null;
                msg = confirm("메뉴를 취소하시겠습니까?");
                if (msg) {
                    menuListArea.innerHTML = "";
                    menuList = {};
                    totalPriceAmount.innerText = "0원";
                }
            }
        }
    })
}



// 홈버튼
home.onclick = () => {
    location.href = "/";
}

