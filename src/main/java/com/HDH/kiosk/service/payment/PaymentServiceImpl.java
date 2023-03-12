package com.HDH.kiosk.service.payment;

import com.HDH.kiosk.dto.payment.OrderReadyDto;
import com.HDH.kiosk.repository.payment.PaymentRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    @Override
    public void orderReadyList(OrderReadyDto orderReadyDto) throws Exception {


        paymentRepository.orderReadyList(orderReadyDto.orderReady());
        log.info("서비스: " + orderReadyDto);
    }
}
