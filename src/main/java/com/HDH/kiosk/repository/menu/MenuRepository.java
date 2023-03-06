package com.HDH.kiosk.repository.menu;

import com.HDH.kiosk.domain.Menu;
import com.HDH.kiosk.domain.MenuImage;
import com.HDH.kiosk.domain.MenuList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuRepository {
    public int addMenu(Menu menu);
    public int addMenuImg(MenuImage menuImage) throws Exception;

    public List<MenuList> loadMainMenuList() throws Exception;
    public List<MenuList> loadMenuList(Map<String, Object> map) throws Exception;

    public MenuList loadMenuInfo (int id) throws Exception;

    public int updateMenu(Menu menu) throws Exception;


//    Map<Object, Object> loadMenuList(int offset, int limit, String category, String searchValue);
}
