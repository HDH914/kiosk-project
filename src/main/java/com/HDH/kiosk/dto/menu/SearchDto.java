package com.HDH.kiosk.dto.menu;

import lombok.Data;

@Data
public class SearchDto {
    private int page;           // 현재 페이지 번호
    private int recodeSize;     // 페이지당 출력할 게시글 갯수
    private int pageSize;       // 화면에 출력할 페이지 갯수
    private String keyword;     // 검색 키워드
    private String searchType;  // 검색 유형
    private Pagination pagination;
    public SearchDto(){
        this.page = 1;
        this.recodeSize = 10;
        this.pageSize = 5;
    }

}
