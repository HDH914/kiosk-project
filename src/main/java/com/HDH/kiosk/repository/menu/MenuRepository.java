package com.HDH.kiosk.repository.menu;

import com.HDH.kiosk.domain.Menu;
import com.HDH.kiosk.domain.MenuList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuRepository {
    public int addMenu(Menu menu);

    public List<MenuList> loadMenuList(Map<String, Object> map)  throws Exception;

}
