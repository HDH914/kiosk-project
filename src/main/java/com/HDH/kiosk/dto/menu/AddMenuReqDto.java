package com.HDH.kiosk.dto.menu;

import com.HDH.kiosk.domain.Menu;
import com.HDH.kiosk.domain.MenuImage;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AddMenuReqDto {
    MenuImage menuImage;
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
                .menu_img(menuImage.getMenu_img())
                .memo(memo)
                .create_date(createDate)
                .update_date(updateDate)
                .build();
    }
}
