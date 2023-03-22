package com.HDH.kiosk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderList {
    private String menu_name;
    private int count;
    private int price;
    private int total_price;
}
