package org.yong.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.yong.mall.dao.AdminUserDao;
import org.yong.mall.entity.AdminUserInfo;
import org.yong.mall.service.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    AdminUserDao dao;

    @Override
    public AdminUserInfo login(long phone, String password) {
        return dao.login(phone, DigestUtils.md5DigestAsHex(password.getBytes()));
    }

}
