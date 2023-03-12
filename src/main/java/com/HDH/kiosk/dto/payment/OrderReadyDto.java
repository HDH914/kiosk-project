package com.HDH.kiosk.dto.payment;

import com.HDH.kiosk.domain.OrderReadyList;
import lombok.Data;

import java.util.Map;

@Data
public class OrderReadyDto {
    private Map<String, Object> menuList;
    private int totalPrice;

    public OrderReadyList orderReady(){
        return OrderReadyList.builder()
//                .menu_list(menuList)
                .total_price(totalPrice)
                .build();
    }
}
