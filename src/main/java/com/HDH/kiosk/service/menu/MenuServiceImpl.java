package com.HDH.kiosk.service.menu;

import com.HDH.kiosk.domain.Menu;
import com.HDH.kiosk.domain.MenuImage;
import com.HDH.kiosk.domain.MenuList;
import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import com.HDH.kiosk.dto.menu.MenuListRespDto;
import com.HDH.kiosk.repository.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    // 메뉴 추가
    @Override
    public boolean addMenu(AddMenuReqDto addMenuReqDto) throws Exception {
       MultipartFile file = addMenuReqDto.getMenuImg();
       MenuImage menuImage = null;

       Menu menu = addMenuReqDto.toAddMenu();
       menuRepository.addMenu(menu);

       if(file != null) {
           int menuId = menu.getId();
           menuImage = getMenuImg(file, menuId);
           menuRepository.addMenuImg(menuImage);
       }
        return true;
    }

    private MenuImage getMenuImg(MultipartFile file, int menuId) throws Exception {

        String originName = file.getOriginalFilename();
        String extension = originName.substring(originName.lastIndexOf("."));
        String tempName = UUID.randomUUID().toString() + extension;

        Path uploadPath = Paths.get(filePath + "/menu/" + tempName);

        File f = new File(filePath + "/menu");

        try {
            Files.write(uploadPath, file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        MenuImage menuImage = MenuImage.builder()
                .menu_id(menuId)
                .origin_name(originName)
                .temp_name(tempName)
                .build();

        return menuImage;
    }

    // 메뉴 리스트 불러오기
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
        log.info("메뉴 이미지: " + menuRepository.loadMenuInfo(id).getMenu_img());
        log.info("이미지 이름: " + menuRepository.loadMenuInfo(id).getMenu_img().getTemp_name());
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

