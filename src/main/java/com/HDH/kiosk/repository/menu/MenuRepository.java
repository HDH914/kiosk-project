package com.HDH.kiosk.repository.menu;

import com.HDH.kiosk.domain.Menu;
import com.HDH.kiosk.domain.MenuList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuRepository {
    public int addMenu(Menu menu);

    public List<MenuList> loadMenuList(String searchValue) throws Exception;

    public MenuList loadMenuInfo (int id) throws Exception;

    public int updateMenu(Menu menu) throws Exception;
}
