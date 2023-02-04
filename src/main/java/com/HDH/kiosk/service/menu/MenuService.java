package com.HDH.kiosk.service.menu;

import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import com.HDH.kiosk.dto.menu.MenuListRespDto;

import java.util.List;

public interface MenuService {
    public boolean addMenu(AddMenuReqDto addMenuReqDto) throws Exception;

    public List<MenuListRespDto> loadMenuList(String searchValue) throws Exception;

    public MenuListRespDto loadMenuInfo(int id) throws Exception;

    public boolean updateMenu(AddMenuReqDto addMenuReqDto) throws Exception;



}
