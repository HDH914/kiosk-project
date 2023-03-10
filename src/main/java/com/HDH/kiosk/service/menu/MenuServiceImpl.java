package com.HDH.kiosk.service.menu;

import com.HDH.kiosk.domain.Menu;
import com.HDH.kiosk.domain.MenuImage;
import com.HDH.kiosk.domain.MenuList;
import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import com.HDH.kiosk.dto.menu.MenuListRespDto;
import com.HDH.kiosk.dto.menu.SearchDto;
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
import java.util.*;

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

    // 메인페이지 메뉴 리스트
    @Override
    public List<MenuListRespDto> loadMainMenuList() throws Exception {
        List<MenuListRespDto> list = new ArrayList<MenuListRespDto>();
        menuRepository.loadMainMenuList().forEach(MenuList -> {
            list.add(MenuList.toLoadMenu());
        });
        log.info("메뉴 리스트: " + list);
        return list;
    }

    // 메뉴 리스트 불러오기
    @Override
    public List<MenuListRespDto> loadMenuList(int startIndex, String category, String searchValue) throws Exception {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("startIndex", startIndex);
        paramsMap.put("pageSize", 15);
        paramsMap.put("category", category);
        paramsMap.put("searchValue", searchValue);

        log.info("paramsMap: " + paramsMap);

        List<MenuListRespDto> list = new ArrayList<MenuListRespDto>();
        menuRepository.loadMenuList(paramsMap).forEach(MenuList -> {
            list.add(MenuList.toLoadMenu());
        });
        log.info("메뉴 리스트: " + list);
        return list;
    }

    // 메뉴 이미지
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

    // 제품 삭제
    @Override
    public boolean deleteMenu(int id) throws Exception {
        List<MenuImage> menuImgFiles = menuRepository.getMenuImgList(id);

        if(menuRepository.deleteMenu(id) > 0) {
            menuImgFiles.forEach(menuImgFile -> {
                Path uploadPath = Paths.get(filePath + "/menu/" + menuImgFile.getTemp_name());

                File f = uploadPath.toFile();
                if(f.exists()) {
                    f.delete();
                }
            });
            return true;
        }
        return false;
    }
}

