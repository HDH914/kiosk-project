const creditCard = document.querySelector(".credit-card");
const cash = document.querySelector(".cash");

// 카드 결제
creditCard.onclick = () => {
    location.href = "/payment/option/card";

}

// 현금 결제
cash.onclick = () => {
    location.href = "/payment/option/cash";
}