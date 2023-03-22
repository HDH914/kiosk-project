orderData();
function orderData() {
    let orderData = JSON.parse(localStorage.getItem('orderData'));
    let price = orderData.totalPrice;
    console.log(price)
    // $.ajax({
    //     async: false,
    //     type: "post",
    //     url: "/api/payment/order",
    //     data: JSON.stringify(orderData),
    //     dataType: "json",
    //     contentType: "application/json; charset=utf-8",
    //     success: (response) => {
    //         console.log("정보 전송 성공!")
    //         // 로컬 스토리지에서 orderData 삭제
    //         localStorage.removeItem('orderData');
    //     },
    //     error: (error) => {
    //         alert("오류가 발생하였습니다.")
    //         console.log(error);
    //     }
    // })
    console.log(orderData);
    cardPayment(price);
}

function cardPayment(price) {
    console.log("cardPayment 실행")

    const IMP = window.IMP;

    // 가맹점 식별코드
    IMP.init("가맹점 식별코드");

    IMP.request_pay({
        pg: 'nice',
        /*
          'kakao':카카오페이,
          html5_inicis':이니시스(웹표준결제)
          'nice':나이스페이
          'jtnet':제이티넷
          'uplus':LG유플러스
          'danal':다날
          'payco':페이코
          'syrup':시럽페이
          'paypal':페이팔
          */
        pay_method: 'card',   //card(신용카드), trans(실시간계좌이체), vbank(가상계좌), phone(휴대폰소액결제)
        merchant_uid: 'merchant_' + new Date().getTime(),
        name: '메뉴 결제(테스트)',  // 상품명
        amount: price               // 가격
    }, function (rsp) {
        let result = '';
        if (rsp.success) {
            let msg = '결제가 완료되었습니다.';
            msg += '고유ID : ' + rsp.imp_uid;
            msg += '상점 거래ID : ' + rsp.merchant_uid;
            msg += '결제 금액 : ' + rsp.paid_amount;
            msg += '카드 승인번호 : ' + rsp.apply_num;
            result = '0';
        } else {
            let msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
            result = '1';
        }
        // alert(msg);
    });
}








