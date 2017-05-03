package org.yong.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yong.mall.cache.RedisCache;
import org.yong.mall.dao.GoodsDao;
import org.yong.mall.entity.GoodsInfo;
import org.yong.mall.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    RedisCache redis;

    @Autowired
    GoodsDao dao;

    @Override
    public List<GoodsInfo> listGoods(int offset, int limit) {
        String key = RedisCache.CACHENAME + "|listGoods|" + offset + "|" + limit;
        List<GoodsInfo> infos = redis.getListCache(key, GoodsInfo.class);

        if (infos == null) {
            infos = dao.listGoods(offset, limit);
            redis.putListCacheWithExpireTime(key, infos, RedisCache.CACHETIME);
        }

        return infos;
    }

    @Override
    public GoodsInfo getGoodsById(long id) {
        return dao.getGoodsById(id);
    }

    @Override
    public boolean saveGoods(GoodsInfo info) {
        // TODO 是否有新增权限

        dao.saveGoods(info);
        return true;
    }

    @Override
    public boolean removeGoods(long id) {
        // TODO 是否有删除权限

        dao.removeGoods(id);
        removeCache();
        return true;
    }

    @Override
    public boolean updateGoods(GoodsInfo info) {
        // TODO 是否有更新权限

        dao.updateGoods(info);
        removeCache();
        return true;
    }

    @Override
    public void removeCache() {
        redis.deleteCacheWithPattern(RedisCache.CACHENAME + "|listGoods|*");
    }

    
}
