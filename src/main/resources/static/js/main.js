
const home = document.querySelector(".home");
const season = document.querySelector(".season");
const coffee = document.querySelector(".coffee");
const beverage = document.querySelector(".beverage");
const tea = document.querySelector(".tea");
const desert = document.querySelector(".desert");
const menus = document.querySelector(".menus");
const deleteButton = document.querySelector(".delete-icon");


loadMenuList();
cl();

function loadMenuList() {
    let responseData = null;
    $.ajax({
        async: false,
        type: "get",
        url: "/api/menu/menulist",
        // dataType: "jspn",
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
                    <div class="menu-price">${data.price}<span>원</span></div>
                </li>
                `
            }
        });
    }
}

// 홈버튼
home.onclick = () => {
    location.href = "/";
}

deleteButton.onclick = () => {
    let msg = null;
    msg = confirm("메뉴를 취소하시겠습니까?");
    if (msg) {
        // 메뉴 삭제
    }
}

function cl() {
    let menu = document.querySelectorAll(".menu");
    let menuList = new Array();

    console.log("메뉴")
    console.log(menu)


    menu.forEach((menu) => {
        menuList.push(menu);
    })
    console.log("메뉴 리스트")
    console.log(menuList)
    // console.log("메뉴 벨류")
    // console.log(menu.value)
    // console.log("메뉴 리스트 벨류")
    // console.log(menuList.value)
    // console.log("메뉴리스트 1번 벨류")
    // console.log(menuList[0].value)

    menu.onclick = () => {
        console.log("cl-2")
        alert("메뉴 선택됨.")
        // menuList.push(menu.values);
        // console.log(menuList);

        // 클릭을 하면 클릭한 메뉴를 리스트에 담고 그 리스트 정보들을
        // 뿌린다.
        // const menuList = document.querySelector(".menu-list");

        // menuList.innerHTML = `

        // `
    }
}



