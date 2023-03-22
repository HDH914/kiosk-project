package com.HDH.kiosk.controller.payment;

import com.HDH.kiosk.dto.CMRespDto;
import com.HDH.kiosk.dto.payment.OrderListDto;
import com.HDH.kiosk.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/payment")
@RequiredArgsConstructor
@RestController
public class PaymentApi {
    private final PaymentService paymentService;

    // 주문한 메뉴 리스트 저장
    @PostMapping("/order")
    public ResponseEntity<?> orderReadyList(@RequestBody OrderListDto orderListDto) throws Exception {
        paymentService.orderList(orderListDto);
        log.info("컨트롤러: " + orderListDto);
        return ResponseEntity.ok().body(new CMRespDto<>(1, "전송 완료", orderListDto.getTotalPrice()));
    }
}
