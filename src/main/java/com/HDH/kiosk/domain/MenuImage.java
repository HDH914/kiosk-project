package com.HDH.kiosk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuImage {
    private int id;
    private int menu_id;

    private String origin_name;
    private String temp_name;

    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
