const menuList = document.querySelector(".menu-list");

// menuList.onclick = () => {
//     menuList.innerHTML = `

//     `
// }

loadMenuListRequest();
function loadMenuListRequest() {
    let responseData = null;
    $.ajax({
        async: false,
        type: "get",
        url: "/api/menu/menulist",
        dataTypr: "json",
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

