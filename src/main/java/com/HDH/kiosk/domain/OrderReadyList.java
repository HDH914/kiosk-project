package com.HDH.kiosk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderReadyList {
//    private Map<String, Object> menu_list;
    private int total_price;
}
