package com.HDH.kiosk.service.menu;

import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import com.HDH.kiosk.dto.menu.MenuImageDto;
import org.springframework.web.multipart.MultipartFile;

public interface MenuService {
//    public void addMenu(AddMenuReqDto addMenuReqDto) throws Exception;

//    public void addImage(MenuImageDto menuImageDto, MultipartFile file) throws Exception;

    public void test(AddMenuReqDto addMenuReqDto, MenuImageDto menuImageDto, MultipartFile file)throws Exception;


}
