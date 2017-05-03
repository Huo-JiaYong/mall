package org.yong.mall.service;

import org.yong.mall.entity.AdminUserInfo;

public interface AdminUserService {

    /**
     * 后台用户登录
     * @param phone
     * @param password
     * @return
     */
    AdminUserInfo login(long phone, String password);
}
