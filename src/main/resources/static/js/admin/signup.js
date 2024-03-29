const signupForm = document.querySelector("form");
const signupInput = document.querySelectorAll(".signup-input");    // 회원가입 정보
const signupButton = document.querySelector(".signup-button");    // 회원가입 버튼

// enter키로 클릭하기
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
        username: signupInput[0].value,
        password: signupInput[1].value,
        storeNumber: signupInput[3].value
    }

    if (signupInput[1].value != signupInput[2].value) {
        alert("비밀번호가 일치하지 않습니다.");
    } else if (signupInput[1].value == signupInput[2].value) {
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
            },
            error: (error) => {
                console.log(error);
                console.log("회원가입 실패")
                ValidationError(error.responseJSON.data);
            }
        });
    }
}

function ValidationError(error) {
    const errorMsg = document.querySelectorAll(".error-msg");
    let errorMap = new Map(Object.entries(error));
    console.log(errorMap)
    errorMsg[0].textContent = errorMap.get("username");
    errorMsg[1].textContent = errorMap.get("password");
    errorMsg[2].textContent = errorMap.get("storeNumber");
}