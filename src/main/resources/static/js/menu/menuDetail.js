const saveButton = document.querySelector(".save-button");
const menuInput = document.querySelectorAll(".menu-input");
const category = document.querySelector(".category");
const memo = document.querySelector(".menu-memo");
let imageInput = document.querySelector(".image-input");



saveButton.onclick = () => {
    addMenu();
    addMenuImage();
}

// 메뉴 정보
function addMenu() {
    let menuData = {
        menuName: menuInput[0].value,
        category: category.value,
        price: menuInput[1].value,
        memo: memo.value
    }

    console.log(menuData);

    $.ajax({
        async: false,
        type: "post",
        url: "/api/menu/add",
        data: menuData,
        success: (response) => {
            alert("전송 성공");
            console.log(response.data);
        },
        error: (error) => {
            alert("전송 실패");
            console.log(error);
        }
    });
}

// 메뉴 이미지
function addMenuImage() {
    let imageFile = document.querySelector(".image-form");
    let formData = new FormData(imageFile);

    console.log(formData);

    $.ajax({
        async: false,
        type: "post",
        url: "/api/menu/add/image",
        data: formData,
        contentType: false,
        processData: false,
        dataType: "json",
        enctype: "multipart/form-data",
        success: (response) => {
            alert("사진 전송 성공");
        },
        error: (error) => {
            alert("사진 등록 실패");
            console.log(error);
        }
    });

}