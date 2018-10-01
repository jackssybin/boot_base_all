package com.jk.modules.quartz.dao;

import com.jk.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.jk.modules.quartz.entity.QuartzJobLogEntity;

/**
 * 定时任务日志
 *
 */
@Mapper
public interface QuartzJobLogMapper extends BaseMapper<QuartzJobLogEntity> {

	int batchRemoveAll();
	
}
