package com.HDH.kiosk.repository.admin;

import com.HDH.kiosk.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRepository {
    public int save(User user);
}
