// -Validation


const signupInput = document.querySelectorAll(".signup-input");    // 회원가입 정보
const signupButton = document.querySelector(".signup-button");    // 회원가입 버튼

signupButton.onclick = () => {
    // 회원가입시 인풋 정보
    let signupInfo = {
        userid: signupInput[0].value,
        password: signupInput[1].value,
        passwordCheck: signupInput[2].value,
        adminNumber: signupInput[3].value
    }

    $.ajax({
        async: false,
        type: "post",
        url: "/api/admin/signup",
        contentType: "application/json",
        data: JSON.stringify(signupInfo),
        dataType: "json",
        success: (response) => {
            console.log(response.data);
            alert("회원가입 완료!");
            location.replace("/login");
        },
        error: (error) => {
            console.log(error);
        }

    })
}