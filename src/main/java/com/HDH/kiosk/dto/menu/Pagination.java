package com.HDH.kiosk.dto.menu;

import lombok.Data;

@Data
public class Pagination {
    private int totalDataCount;     // 전체 데이터 수
    private int totalPageCount; // 게시판 화면에 보여질 페이지 번호의 개수
    private int startPage;          // 첫 페이지 번호
    private int endPage;            // 끝 페이지 번호
    private int limitStart;         // Limit 시작 위치
    private boolean prev;           // 이전 페이지
    private boolean next;           // 다음 페이지

    public Pagination(int totalDataCount, SearchDto params){
        if (totalDataCount > 0){
            this.totalDataCount = totalDataCount;
        }
    }
    private void calculation(SearchDto parmas){
        // 전체 페이지수 계산
        totalPageCount = ((totalDataCount - 1) / parmas.getRecodeSize()) + 1;

        // 현재 페이지 번호가 젠체 페이지 수보다 큰 경우, 현재 페이지 번호에 천체 페이지 수 저장
        if(parmas.getPage() > totalPageCount){
            parmas.setPage(totalPageCount);
        }

        // 첫 페이지 번호 계산
        startPage = ((parmas.getPage() - 1 ) / parmas.getPageSize()) * parmas.getPageSize() + 1;

        // 끝 페이지 번호 계산
        endPage = startPage + parmas.getPageSize() - 1;

        // 끝 페이지가 전체 페이지 수보다 큰 경우, 끝 페이지 전체 페이지 수 저장
        if(endPage > totalPageCount){
            endPage = totalPageCount;
        }

        // Limit 시작 위치 계산
        limitStart = (parmas.getPage() - 1) * parmas.getRecodeSize();

        // 이전 페이지 존재 여부
        prev = startPage != 1;

        // 다음 페이지 존재 여부
        next = (endPage * parmas.getRecodeSize()) < totalDataCount;


    }
}
