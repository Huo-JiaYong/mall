package org.yong.mall.service;

import java.util.List;

import org.yong.mall.entity.GoodsInfo;

public interface GoodsService {

    /**
     * 根据偏移量获取商品集合
     * @param offset 起始值
     * @param limit 终止值
     * @return
     */
    List<GoodsInfo> listGoods(int offset,int limit);
    
    GoodsInfo getGoodsById(long id);
    
    boolean saveGoods(GoodsInfo info);
    
    boolean removeGoods(long id);
    
    boolean updateGoods(GoodsInfo info);
    
    void removeCache();
}
