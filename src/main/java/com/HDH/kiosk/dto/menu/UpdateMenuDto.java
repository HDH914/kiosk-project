package com.HDH.kiosk.dto.menu;

import com.HDH.kiosk.domain.Menu;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateMenuDto {
    private int categoryId;
    private String menuName;
    private int price;
    private String menuImg;
    private String memo;
    private LocalDateTime updateDate;


}
