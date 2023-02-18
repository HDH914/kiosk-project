package com.HDH.kiosk.dto.menu;

import com.HDH.kiosk.domain.MenuImage;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Data
public class MenuListRespDto {
    private int id;
    private int categoryId;
    private String categoryName;
    private String menuName;
    private int price;
    private MenuImage menuImg;
    private String memo;
    private int menuTotalCount;
}
