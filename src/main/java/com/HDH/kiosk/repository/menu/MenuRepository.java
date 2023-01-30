package com.HDH.kiosk.repository.menu;

import com.HDH.kiosk.domain.Menu;
import com.HDH.kiosk.domain.MenuImage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuRepository {
    public int addMenu(Menu menu);

    public int addMenuImage(MenuImage menuImage);
}
