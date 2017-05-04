package org.yong.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yong.mall.cache.RedisCache;
import org.yong.mall.dao.AuthorityDao;
import org.yong.mall.entity.AdminUserInfo;
import org.yong.mall.entity.Authority;
import org.yong.mall.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    RedisCache redis;

    @Autowired
    AuthorityDao dao;

    @Override
    public List<Authority> listAuthorityWithUser(AdminUserInfo info) {
        String key = RedisCache.CACHENAME + "|" + info.getPhone() + "|authority";
        List<Authority> authorities = redis.getListCache(key, Authority.class);
        if (authorities == null || authorities.isEmpty()) {
            authorities = dao.listAuthorityWithUser(info.getId());
            redis.putListCache(key, authorities);
        }

        return authorities;
    }

    @Override
    public boolean checkUserAuthority(AdminUserInfo info, String authName) {
        List<Authority> authorities = listAuthorityWithUser(info);
        long number = authorities.stream().filter(p -> p.getName().equals(authName)).count();
        return number > 0 ? true : false;
    }

}
