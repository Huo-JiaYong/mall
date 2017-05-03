package org.yong.mall.service;

import java.util.List;

import org.yong.mall.entity.AdminUserInfo;
import org.yong.mall.entity.SystemModule;

public interface SystemModuleService {

    /**
     * 根据 userId 获取授权模块
     * 
     * @param userId
     * @return
     */
    List<SystemModule> listModuleWithUser(AdminUserInfo user);
}
