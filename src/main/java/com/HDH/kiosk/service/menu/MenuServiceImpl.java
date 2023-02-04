package com.HDH.kiosk.service.menu;

import com.HDH.kiosk.domain.MenuList;
import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import com.HDH.kiosk.dto.menu.MenuListRespDto;
import com.HDH.kiosk.repository.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    @Value("${file.path}")
    private String filePath;
    @Override
    public boolean addMenu(AddMenuReqDto addMenuReqDto) throws Exception {
        String originName = addMenuReqDto.getMenuImg();
        String extension = originName.substring(originName.lastIndexOf("."));
        String tempName = UUID.randomUUID().toString() + extension;

        Path uploadPath = Paths.get(filePath + "/menu/" + tempName);

        addMenuReqDto.setMenuImg(tempName);
        File f = new File(filePath + "/menu");

        try{
            Files.write(uploadPath, addMenuReqDto.getMenuImg().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        menuRepository.addMenu(addMenuReqDto.toAddMenu());

        return true;
    }

    @Override
    public List<MenuListRespDto> loadMenuList(String searchValue) throws Exception {
        List<MenuListRespDto> list = new ArrayList<MenuListRespDto>();
        menuRepository.loadMenuList(searchValue).forEach(MenuList -> {
            list.add(MenuList.toLoadMenu());
        });
        return list;
    }

    // 수정 페이지 메뉴 정보 불러오기
    @Override
    public MenuListRespDto loadMenuInfo(int id) throws Exception {
        MenuListRespDto menuInfo = menuRepository.loadMenuInfo(id).toLoadMenu();
        return menuInfo;
    }

    // 제품 수정
    @Override
    public boolean updateMenu(AddMenuReqDto addMenuReqDto) throws Exception {
        menuRepository.updateMenu(addMenuReqDto.toAddMenu());
        log.info("아이디: "  + addMenuReqDto.toAddMenu().getId());
        log.info("상품명: " + addMenuReqDto.toAddMenu().getMenu_name());
        log.info("가격: " + addMenuReqDto.toAddMenu().getPrice());
        log.info("제품 이미지: " +  addMenuReqDto.toAddMenu().getMenu_img());
        log.info("메모: " +  addMenuReqDto.toAddMenu().getMemo());

        return true;
    }

}

