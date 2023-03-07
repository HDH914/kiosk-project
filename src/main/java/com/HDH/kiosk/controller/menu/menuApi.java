package com.HDH.kiosk.controller.menu;

import com.HDH.kiosk.dto.CMRespDto;
import com.HDH.kiosk.dto.menu.AddMenuReqDto;
import com.HDH.kiosk.dto.menu.SearchDto;
import com.HDH.kiosk.dto.menu.UpdateMenuDto;
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

    // 메뉴 추가
    @PostMapping("/add")
    public ResponseEntity<?> addMenu(AddMenuReqDto addMenuReqDto) throws Exception {
        menuService.addMenu(addMenuReqDto);
        log.info("메뉴 이미지 컨트롤라: " + addMenuReqDto.getMenuImg());

        return ResponseEntity.ok().body(new CMRespDto<>(1,"메뉴 등록", true));
    }

    // 메인페이지 메뉴 리스트 불러오기
    @GetMapping("/menulist")
    public ResponseEntity<?> getMainMenulist() throws Exception {
        return ResponseEntity.ok().body(new CMRespDto<>(1,"메뉴 불러오기", menuService.loadMainMenuList()));
    }

    // 어드민페이지 메뉴 리스트 불러오기

    // 기존
//    @GetMapping("/admin/menulist")
//    public ResponseEntity<?> getMenulist(@RequestParam @Nullable int page, @RequestParam @Nullable String category, @RequestParam @Nullable String searchValue) throws Exception {
//        return ResponseEntity.ok().body(new CMRespDto<>(1,"메뉴 불러오기", menuService.loadMenuList(page, category, searchValue)));
//    }

    // 두번째
    @GetMapping("/admin/menulist")
    public ResponseEntity<?> getMenulist(@RequestParam @Nullable Integer page, @RequestParam @Nullable String category, @RequestParam @Nullable String searchValue) throws Exception {
        log.info("page: " + page);
        int startIndex = (page != null && page > 0) ? (page - 1) * 15 : 0;
        log.info("startIndex: " + startIndex);
        return ResponseEntity.ok().body(new CMRespDto<>(1,"메뉴 불러오기", menuService.loadMenuList(startIndex, category, searchValue)));
    }

    // 메뉴 수정페이지
    @GetMapping("/admin/modification/{id}")
    public ResponseEntity<?> getMenuInfo(@PathVariable int id) throws Exception {
        log.info("메뉴 Id: " + id);
        return ResponseEntity.ok().body(new CMRespDto<>(1,"메뉴 정보", menuService.loadMenuInfo(id)));
    }

    // 메뉴 수정하기
    @PutMapping("/admin/modification/update/{id}")
    public ResponseEntity<?> updateMenu(@PathVariable int id, AddMenuReqDto addMenuReqDto) throws Exception {
        menuService.updateMenu(addMenuReqDto);
        return ResponseEntity.ok().body(new CMRespDto<>(1,"업데이트 완료", true));
    }
}
