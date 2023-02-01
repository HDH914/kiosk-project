package com.HDH.kiosk.service.menu;

import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import com.HDH.kiosk.repository.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    @Value("${file.path")
    private String filePath;


    @Override
    public boolean addMenu(AddMenuReqDto addMenuReqDto) throws Exception {
        String originName = addMenuReqDto.getMenuImg();
        String extension = originName.substring(originName.lastIndexOf("."));
        String tempName = UUID.randomUUID().toString() + extension;


        Path uploadPath = Paths.get(filePath + "/menu/" + tempName);

        addMenuReqDto.setMenuImg(tempName);
        log.info("이미지 이름: " + addMenuReqDto.getMenuImg());
        File f = new File(filePath + "/menu");

        try{
            Files.write(uploadPath, addMenuReqDto.getMenuImg().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        menuRepository.addMenu(addMenuReqDto.toAddMenu());

        return true;
    }

}

