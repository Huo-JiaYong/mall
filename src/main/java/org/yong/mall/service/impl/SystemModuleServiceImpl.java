package org.yong.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yong.mall.cache.RedisCache;
import org.yong.mall.dao.SystemModuleDao;
import org.yong.mall.entity.AdminUserInfo;
import org.yong.mall.entity.SystemModule;
import org.yong.mall.service.SystemModuleService;

@Service
public class SystemModuleServiceImpl implements SystemModuleService {

    @Autowired
    RedisCache redis;

    @Autowired
    SystemModuleDao dao;

    @Override
    public List<SystemModule> listModuleWithUser(AdminUserInfo user) {
        String key = RedisCache.CACHENAME + "|" + user.getPhone() + "|module";
        List<SystemModule> modules = redis.getListCache(key, SystemModule.class);
        if (modules == null || modules.isEmpty()) {
            modules = dao.listModuleWithUser(user.getId());
            redis.putListCache(key, modules);
        }
        
        return modules;
    }

}
