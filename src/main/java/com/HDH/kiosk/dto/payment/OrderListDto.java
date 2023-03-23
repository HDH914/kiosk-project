package com.HDH.kiosk.dto.payment;

import com.HDH.kiosk.domain.OrderList;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderListDto {
    private List<MenuDto> orderLists;
    private int totalPrice;

    @Data
    public static class MenuDto{
        private String menuName;
        private int count;
        private int price;
    }
    public List<OrderList> toOrderEntity(int group_id){
        List<OrderList> orderList = new ArrayList<OrderList>();
        for(MenuDto menuDto : orderLists){
            OrderList order = OrderList.builder()
                    .group_id(group_id)
                    .menu_name(menuDto.getMenuName())
                    .count(menuDto.getCount())
                    .price(menuDto.getPrice())
                    .total_price(totalPrice)
                    .build();
            orderList.add(order);
        }
        return orderList;
    }
}
