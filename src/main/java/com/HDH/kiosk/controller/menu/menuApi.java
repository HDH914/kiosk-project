package com.HDH.kiosk.controller.menu;

import com.HDH.kiosk.dto.CMRespDto;
import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import com.HDH.kiosk.service.menu.MenuService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        log.info("카테고리: " + addMenuReqDto.getCategoryId());
        menuService.addMenu(addMenuReqDto);

        return ResponseEntity.ok().body(new CMRespDto<>(1,"메뉴 등록", true));
    }

    @GetMapping("/menulist")
    public ResponseEntity<?> getMenulist() throws Exception {

        return ResponseEntity.ok().body(new CMRespDto<>(1,"메뉴 불러오기", true));
    }
}
