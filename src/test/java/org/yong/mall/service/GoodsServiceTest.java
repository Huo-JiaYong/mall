package org.yong.mall.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.yong.mall.BasicTest;
import org.yong.mall.entity.GoodsInfo;

public class GoodsServiceTest extends BasicTest {

    @Autowired
    GoodsService service;

    @Test
    public void testListGoods() {
        int offset = 0;
        int limit = 10;
        List<GoodsInfo> infos = service.listGoods(offset, limit);
        for (int i = 0, size = infos.size(); i < size; i++) {
            System.out.println(infos.get(i).toString());
        }
    }

    @Test
    public void testGetGoodsById() {
        long id = 1000L;
        GoodsInfo info = service.getGoodsById(id);
        System.out.println(info.toString());
    }

    @Test
    public void testSaveGoods() {
        
    }

    @Test
    public void testRemoveGoods() {
        
    }

    @Test
    public void testUpdateGoods() {
        
    }

}
