package com.jk.modules.quartz.service;

import java.util.Map;

import com.jk.common.entity.Page;
import com.jk.common.entity.R;
import com.jk.modules.quartz.entity.QuartzJobEntity;

/**
 * 定时任务
 *
 */
public interface QuartzJobService {
	
	Page<QuartzJobEntity> list(Map<String, Object> params);
	
	R saveQuartzJob(QuartzJobEntity job);
	
	R getQuartzJobById(Long jobId);
	
	R updateQuartzJob(QuartzJobEntity job);
	
	R batchRemoveQuartzJob(Long[] id);
	
	R run(Long[] id);
	
	R pause(Long[] id);
	
	R resume(Long[] id);
	
}
