package org.yong.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.yong.mall.entity.GoodsInfo;

public interface GoodsDao {

	/**
	 * 根据偏移量查询所有商品
	 * 
	 * @param offset
	 *            起始位置
	 * @param limit
	 *            查询数量
	 */
	List<GoodsInfo> listGoods(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 根据id查询商品信息
	 * @param id
	 * @return
	 */
	GoodsInfo getGoodsById(@Param("id")long id);
	
	/**
	 * 新增商品信息
	 * @param goodsInfo
	 */
	void saveGoods(GoodsInfo goodsInfo);
	
	/**
	 * 根据id删除商品
	 * @param id
	 */
	void removeGoods(@Param("id")long id);
	
	/**
	 * 修改商品信息
	 * @param goodsInfo
	 */
	void updateGoods(GoodsInfo goodsInfo);
}
