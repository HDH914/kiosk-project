const loginForm = document.querySelector(".login-form");
const loginButton = document.querySelector(".login-button");

loginButton.onclick = () => {
    loginForm.subnit();
    console.log("폼 전송 완료");
}