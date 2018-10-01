package com.jk.modules.sys.service;

import java.util.Map;

import com.jk.common.entity.Page;
import com.jk.common.entity.R;
import com.jk.modules.sys.entity.SysLogEntity;

/**
 * 系统日志
 *
 */
public interface SysLogService {

	Page<SysLogEntity> listLog(Map<String, Object> params);
	
	R batchRemove(Long[] id);
	
	R batchRemoveAll();
	
}
