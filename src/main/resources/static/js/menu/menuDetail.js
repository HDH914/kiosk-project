const saveButton = document.querySelector(".save-button");
const imageinput = document.querySelector(".image-input");
const menuInput = document.querySelectorAll(".menu-input");
const memo = document.querySelector(".menu-memo");

saveButton.onclick = () => {
    let menuData = {
        menuImg: imageinput,
        menuName: menuInput[0].ariaValue,
        category: menuInput[1].ariaValue,
        price: menuInput[2].ariaValue,
        memo: memo
    }

    console.log(menuData);

    $.ajax({
        async: false,
        type: "post",
        url: "",
        data: menuData,
        success: (response) => {
            alert("전송 성공");

        },
        error: (error) => {
            alert("전송 실패");
            console.log(error);
        }

    })
}