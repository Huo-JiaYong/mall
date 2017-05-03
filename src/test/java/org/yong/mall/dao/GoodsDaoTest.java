package org.yong.mall.dao;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.yong.mall.BasicTest;
import org.yong.mall.entity.GoodsInfo;

public class GoodsDaoTest extends BasicTest {

    @Autowired
    GoodsDao dao;
    
    @Test
    public void testListGoods() {
        int offset = 0;
        int limit = 10;
        List<GoodsInfo> listGoods = dao.listGoods(offset, limit);
        for (int i = 0,size = listGoods.size(); i < size; i++) {
            System.out.println(listGoods.get(i).toString());
        }
    }
    
    @Test
    public void testGetGoodsById() {
        long id = 1000L;
        GoodsInfo info = dao.getGoodsById(id);
        System.out.println(info.toString());
    }
    
    @Test
    public void testSaveGoods() {
        GoodsInfo info = new GoodsInfo();
        info.setName("上古神器 GTX 980ti");
        info.setTitle("祖传980，玩不动的游戏还没有出来呢");
        info.setPrice(1999F);
        info.setNumber(100);
        info.setIntroduce("不是我吹牛逼的话，上一代的最吊神器，你还想咋的");
        dao.saveGoods(info);
        System.out.println("success");
    }
    
    @Test
    public void testRemoveGoods(){
        dao.removeGoods(1004L);
        System.out.println("remove success");
    }
    
    @Test
    public void testUpdateGoods(){
        GoodsInfo info = new GoodsInfo();
        info.setId(1005);
        info.setName("update - 上古神器 GTX 980ti");
        info.setTitle("update - 祖传980，玩不动的游戏还没有出来呢");
        dao.updateGoods(info);
        System.out.println("update success");
    }
}

