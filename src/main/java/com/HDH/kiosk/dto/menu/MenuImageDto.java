package com.HDH.kiosk.dto.menu;

import com.HDH.kiosk.domain.Menu;
import com.HDH.kiosk.domain.MenuImage;
import lombok.Data;

@Data
public class MenuImageDto {
    private String menuImg;

//  public MenuImage toAddImage(){
//      return MenuImage.builder()
//              .menu_img(menuImg)
//              .build();
//  }
}
