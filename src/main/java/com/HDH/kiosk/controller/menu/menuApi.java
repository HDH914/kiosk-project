package com.HDH.kiosk.controller.menu;

import com.HDH.kiosk.dto.CMRespDto;
import com.HDH.kiosk.dto.menu.AddMenuReqDto;
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
    public ResponseEntity<?> addMenu(AddMenuReqDto addMenuReqDto) throws Exception {
        // MultipartFile 변수명은 name값과 같게해야함.
//        menuService.addMenu(addMenuReqDto);
        log.info("제품명: " + addMenuReqDto.getMenuName());
        log.info("카테고리: " + addMenuReqDto.getCategoryId());
        log.info("가격: " + addMenuReqDto.getPrice());
        log.info("비고: " + addMenuReqDto.getMemo());
        return ResponseEntity.ok().body(new CMRespDto<>(1,"메뉴 등록", addMenuReqDto));
    }

    @PostMapping("/add/image")
    public ResponseEntity<?> addImage(AddMenuReqDto addMenuReqDto, MultipartFile file)throws Exception {
//        menuService.addImage(addMenuReqDto,file);
        log.info("파일 이름: " + file.getOriginalFilename());
        return ResponseEntity.ok().body(new CMRespDto<>(1,"이미지 등록", file));
    }

}
