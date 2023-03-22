package com.HDH.kiosk.repository.payment;

import com.HDH.kiosk.domain.OrderList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentRepository {
    public void orderList(OrderList orderList) throws Exception;
}
