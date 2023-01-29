package com.HDH.kiosk.service.menu;

import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import org.springframework.web.multipart.MultipartFile;

public interface MenuService {
    public void addMenu(AddMenuReqDto addMenuReqDto) throws Exception;

    public void addImage(AddMenuReqDto addMenuReqDto, MultipartFile file) throws Exception;
}
