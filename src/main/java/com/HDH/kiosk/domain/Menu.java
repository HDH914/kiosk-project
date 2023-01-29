package com.HDH.kiosk.domain;

import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Menu {
    private int id;
    private int category_id;
    private String menu_name;
    private int price;
    private String menu_img;
    private String memo;
    private LocalDateTime create_date;
    private LocalDateTime update_date;


}
