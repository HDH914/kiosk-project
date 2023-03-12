package com.HDH.kiosk.repository.payment;

import com.HDH.kiosk.domain.OrderReadyList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentRepository {
    public void orderReadyList(OrderReadyList orderReadyList) throws Exception;
}
