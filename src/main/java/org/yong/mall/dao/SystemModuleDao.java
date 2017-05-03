package org.yong.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.yong.mall.entity.SystemModule;

public interface SystemModuleDao {

    /**
     * 根据 userId 获取系统列表
     * @param userId
     * @return
     */
    List<SystemModule> listModuleWithUser(@Param("userId") long userId);
}
