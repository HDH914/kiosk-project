const saveButton = document.querySelector(".save-button");
const cancelButton = document.querySelector(".cancel-button");
const category = document.querySelector(".category");
const memo = document.querySelector(".menu-memo");

let imageForm = document.querySelector(".image-form");
let imageInput = document.querySelector(".image-input");
let imageFile = new Array();

imageInput.onchange = () => {
    const imageForm = new FormData(document.querySelector(".image-form"));
    let changeFlag = false;

    imageForm.forEach((value) => {
        if (value.size != 0) {
            imageFile.push(value);
            console.log(imageFile);
            changeFlag = true;
        }
    });
    if (changeFlag) {
        // imagePreview();
        console.log("미리보기 실행");
    }
}

function imagePreview() {
    const image = document.querySelector(".image");

    image.innerHTML = "";

    const reader = new FileReader();

    reader.onload = (e) => {
        image.innerHTML = `
         <img class="product-img" src="${e.target.result}">
        `
    };


}


// 메뉴 추가
saveButton.onclick = () => {
    const menuInput = document.querySelectorAll(".menu-input");

    let formData = new FormData();

    formData.append("menuName", menuInput[0].value);
    formData.append("categoryId", menuInput[1].value);
    formData.append("price", menuInput[2].value);
    formData.append("memo", menuInput[3].value);

    imageFile.forEach((imageFile) => {
        formData.append("menuImg", imageFile);
    });

    formData.forEach((value, key) => {
        console.log(key);
        console.log(value);
        console.log();
    });
    if (menuInput[1].value == 0) {
        alert("카테고리를 선택해주세요.");
    } else {
        requestaAddMenu(formData);
    }
}

// 메뉴 데이터 전송
function requestaAddMenu(formData) {

    $.ajax({
        async: false,
        type: "post",
        url: "/api/menu/add",
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        data: formData,
        dataType: "json",
        success: (response) => {
            alert("등록 성공");
            location.reload();
        },
        error: (error) => {
            alert("등록 실패");
        }
    });

}

// 취소 버튼
cancelButton.onclick = () => {
    let msg = null;
    msg = confirm("정말로 취소하시겠습니까?");

    if (msg) {
        location.href = "/admin";
    }
}