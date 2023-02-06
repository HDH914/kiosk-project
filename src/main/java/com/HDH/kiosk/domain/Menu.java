package com.HDH.kiosk.domain;

import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import com.HDH.kiosk.dto.menu.MenuListRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile menu_img;
    private String memo;
    private LocalDateTime create_date;
    private LocalDateTime update_date;

//    public MenuListRespDto getMenuList(){
//        return MenuListRespDto.builder()
//                .id(id)
//                .categoryId(category_id)
//                .menuName(menu_name)
//                .price(price)
//                .menuImg(menu_img)
//                .memo(memo)
//                .build();
//
//
//    }
}
