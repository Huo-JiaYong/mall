package org.yong.mall.dao;

import java.util.List;

import org.yong.mall.entity.Authority;

public interface AuthorityDao {

    /**
     * 获取用户的权限
     * 
     * @param userId
     * @return
     */
    List<Authority> listAuthorityWithUser(long userId);
}
