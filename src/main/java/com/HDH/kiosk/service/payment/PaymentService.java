package com.HDH.kiosk.service.payment;

import com.HDH.kiosk.dto.payment.OrderListDto;


public interface PaymentService {

    public void orderList(OrderListDto orderListDto) throws Exception;
}
