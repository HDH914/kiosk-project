package com.HDH.kiosk.controller.menu;

import com.HDH.kiosk.dto.CMRespDto;
import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import com.HDH.kiosk.dto.menu.MenuImageDto;
import com.HDH.kiosk.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequestMapping("/api/menu")
@RestController
@RequiredArgsConstructor
public class menuApi {
    private final MenuService menuService;

    @PostMapping("/add")
    public ResponseEntity<?> addMenu(AddMenuReqDto addMenuReqDto, MenuImageDto menuImageDto, MultipartFile file) throws Exception {
        // MultipartFile 변수명은 name값과 같게해야함.
        menuService.test(addMenuReqDto, menuImageDto, file);

        return ResponseEntity.ok().body(new CMRespDto<>(1,"메뉴 등록", addMenuReqDto));
    }

    @PostMapping("/add/image")
    public ResponseEntity<?> addImage(AddMenuReqDto addMenuReqDto, MenuImageDto menuImageDto, MultipartFile file)throws Exception {
        menuService.test(addMenuReqDto, menuImageDto,file);
        log.info("파일 이름: " + file.getOriginalFilename());
        return ResponseEntity.ok().body(new CMRespDto<>(1,"이미지 등록", true));
    }

}
