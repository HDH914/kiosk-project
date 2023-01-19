package com.HDH.kiosk.repository.admin;

import com.HDH.kiosk.domain.User2;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRepository {
    public int save(User2 user2);

}
