package com.jk.modules.quartz.service;

import java.util.Map;

import com.jk.common.entity.Page;
import com.jk.common.entity.R;
import com.jk.modules.quartz.entity.QuartzJobLogEntity;

/**
 * 定时任务日志
 *
 */
public interface QuartzJobLogService {

	Page<QuartzJobLogEntity> listForPage(Map<String, Object> params);
	
	R batchRemove(Long[] id);
	
	R batchRemoveAll();
	
}
