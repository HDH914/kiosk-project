package com.HDH.kiosk.controller.menu;

import com.HDH.kiosk.dto.CMRespDto;
import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import com.HDH.kiosk.service.menu.MenuService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Null;

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
    public ResponseEntity<?> getMenulist(@RequestParam @Nullable String searchValue) throws Exception {

        return ResponseEntity.ok().body(new CMRespDto<>(1,"메뉴 불러오기", menuService.loadMenuList(searchValue)));
    }

    @GetMapping("/admin/modification/{id}")
    public ResponseEntity<?> getMenuInfo(@PathVariable int id) throws Exception {
        log.info("메뉴 Id: " + id);
        return ResponseEntity.ok().body(new CMRespDto<>(1,"메뉴 정보", menuService.loadMenuInfo(id)));
    }
}
