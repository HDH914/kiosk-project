package com.HDH.kiosk.dto.menu;

import com.HDH.kiosk.domain.Menu;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddMenuReqDto {
    private int id;
    private int categoryId;
    private String menuName;
    private int price;
    private String menuImg;
    private String memo;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Menu toAddMenu(){
        return Menu.builder()
                .id(id)
                .category_id(categoryId)
                .menu_name(menuName)
                .price(price)
                .menu_img(menuImg)
                .memo(memo)
                .create_date(createDate)
                .update_date(updateDate)
                .build();
    }
}
