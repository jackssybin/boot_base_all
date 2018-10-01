package com.jk.modules.quartz.dao;

import com.jk.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.jk.modules.quartz.entity.QuartzJobEntity;


/**
 * 定时任务
 *
 */
@Mapper
public interface QuartzJobMapper extends BaseMapper<QuartzJobEntity> {

}
