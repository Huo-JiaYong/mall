package org.yong.mall.service;

import java.util.List;

import org.yong.mall.entity.AdminUserInfo;
import org.yong.mall.entity.Authority;

public interface AuthorityService {

    /**
     * 获取用户所有权限
     * @param info
     * @return
     */
    List<Authority> listAuthorityWithUser(AdminUserInfo info);
    
    /**
     * 判断用户是否有指定权限
     * @param info 用户信息
     * @param authName 权限名称
     * @return
     */
    boolean checkUserAuthority(AdminUserInfo info, String authName);
}
