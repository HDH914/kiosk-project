// -Validation

const signupInput = document.querySelectorAll(".signup-input");    // 회원가입 정보
const signupButton = document.querySelector(".signup-button");    // 회원가입 버튼

for (let i = 0; i < signupInput.length; i++) {
    signupInput[i].onkeyup = () => {
        if (window.event.keyCode === 13) {
            if (i != 4) {
                signupInput[i + 1].focus();
            } else {
                signupButton.click();
            }
        }
    }
}

signupButton.onclick = () => {
    // 회원가입시 인풋 정보
    let signupInfo = {
        userid: signupInput[0].value,
        password: signupInput[1].value,
        adminNumber: signupInput[2].value
    }

    console.log(signupInfo);


    $.ajax({
        async: false,
        type: "post",
        url: "/api/admin/signup",
        contentType: "application/json",
        data: JSON.stringify(signupInfo),
        dataType: "json",
        success: (response) => {
            alert("회원가입 완료.");
            location.replace("/");
            console.log(response.data);
        },
        error: (error) => {
            console.log(error);
            console.log("전송 실패");
        }
    });
}