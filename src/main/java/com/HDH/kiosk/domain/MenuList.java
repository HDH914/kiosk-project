package com.HDH.kiosk.domain;

import com.HDH.kiosk.dto.menu.MenuListRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuList {
    private int id;
    private int category_id;
    private String category_name;
    private String menu_name;
    private int price;
    private String menu_img;
    private String memo;

    public MenuListRespDto toLoadMenu(){
        return MenuListRespDto.builder()
                .id(id)
                .categoryId(category_id)
                .categoryName(category_name)
                .menuName(menu_name)
                .price(price)
                .menuImg(menu_img)
                .memo(memo)
                .build();
    }
}