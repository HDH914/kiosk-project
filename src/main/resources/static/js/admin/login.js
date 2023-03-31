const loginInput = document.querySelectorAll(".general-login-input");
const loginButton = document.querySelector(".login-button");

// enter키로 클릭하기
for (let i = 0; i < loginInput.length; i++) {
    loginInput[i].onkeyup = () => {
        if (window.event.keyCode === 13) {
            if (i != 4) {
                loginInput[i + 1].focus();
            } else {
                loginButton.click();
            }
        }
    }
}

loginButton.onclick = () => {
    const loginForm = document.querySelector("form");
    loginForm.submit();
    console.log("폼 전송 완료");
}