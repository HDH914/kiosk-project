package com.HDH.kiosk.dto.menu;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MenuListRespDto {
    private int id;
    private int categoryId;
    private String menuName;
    private int price;
    private String menuImg;
    private String memo;
}
