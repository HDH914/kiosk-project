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
public class User {
    private int id;
    private String admin_id;
    private String password;
    private int store_number;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
