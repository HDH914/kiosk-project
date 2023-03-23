package com.HDH.kiosk.service.payment;

import com.HDH.kiosk.domain.OrderList;
import com.HDH.kiosk.dto.payment.OrderListDto;
import com.HDH.kiosk.repository.payment.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    // 주문 내역 저장
    @Override
    public void orderList(OrderListDto orderListDto) throws Exception {
        int group_id = paymentRepository.getMaxGroupId() + 1;
        List<OrderList> orderList = orderListDto.toOrderEntity(group_id);
        for(OrderList order : orderList) {
            paymentRepository.orderList(order);
        }
    }
}
