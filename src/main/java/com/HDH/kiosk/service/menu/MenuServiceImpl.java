package com.HDH.kiosk.service.menu;

import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import com.HDH.kiosk.dto.menu.MenuImageDto;
import com.HDH.kiosk.repository.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
    private final MenuRepository menuRepository;

    @Value("${file.path")
    private String filePath;


//    @Override
//    public void addMenu(AddMenuReqDto addMenuReqDto) throws Exception{
//        int menuId = addMenuReqDto.getId();
//        log.info("메뉴ID: " + menuId);
//
//        menuRepository.addMenu(addMenuReqDto.toAddMenu());
//    }
//
//    @Override
//    public void addImage(MenuImageDto menuImageDto, MultipartFile file) throws Exception {
//        String originName = file.getOriginalFilename();
//        String extension = originName.substring(originName.lastIndexOf("."));
//        String tempName = UUID.randomUUID().toString() + extension;
//
//        Path uploadPath = Paths.get(filePath + "/menu/" + tempName);
//        menuImageDto.setMenuImg(tempName);
//
//        log.info("파일 이름: " + menuImageDto.getMenuImg());
//
//        // 파일 경로
//        File f = new File(filePath + "/menu");
//
//        if (!f.exists()) {
//            f.mkdirs();
//        }
//        try{
//            Files.write(uploadPath, file.getBytes());
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    @Override
    public void test(AddMenuReqDto addMenuReqDto, MenuImageDto menuImageDto, MultipartFile file) throws Exception {
        String originName = file.getOriginalFilename();
        String extension = originName.substring(originName.lastIndexOf("."));
        String tempName = UUID.randomUUID().toString() + extension;
        int menuId = addMenuReqDto.getId();
        log.info("메뉴ID: " + menuId);

        Path uploadPath = Paths.get(filePath + "/menu/" + tempName);
        addMenuReqDto.setMenuImg(menuImageDto.getMenuImg());

        log.info("파일 이름: " + addMenuReqDto.getMenuImg());

        // 파일 경로
        File f = new File(filePath + "/menu");
        if (!f.exists()) {
            f.mkdirs();
        }
        try{
            Files.write(uploadPath, file.getBytes());
        } catch (Exception e){
            e.printStackTrace();
        }
        menuRepository.addMenu(addMenuReqDto.toAddMenu());
    }
}
