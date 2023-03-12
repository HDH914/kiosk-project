package com.HDH.kiosk.service.payment;

import com.HDH.kiosk.dto.payment.OrderReadyDto;
import org.springframework.stereotype.Service;


public interface PaymentService {

    public void orderReadyList(OrderReadyDto orderReadyDto) throws Exception;
}
