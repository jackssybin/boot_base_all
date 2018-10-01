package com.jk.modules.sys.dao;

import com.jk.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志 
 *
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLogEntity> {

	int batchRemoveAll();
	
}
