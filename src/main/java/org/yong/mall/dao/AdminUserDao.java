package org.yong.mall.dao;

import org.apache.ibatis.annotations.Param;
import org.yong.mall.entity.AdminUserInfo;

public interface AdminUserDao {

    /**
     * 用户登录
     * @param phone
     * @param password
     */
    AdminUserInfo login(@Param("phone")long phone,@Param("password")String password);
}
