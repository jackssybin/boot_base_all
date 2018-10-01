package com.jk.modules.quartz.manager;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.quartz.entity.QuartzJobEntity;

/**
 * 定时任务
 *
 */
public interface QuartzJobManager {

	List<QuartzJobEntity> listForPage(Page<QuartzJobEntity> page, Query query);
	
	List<QuartzJobEntity> listNormalJob();
	
	int saveQuartzJob(QuartzJobEntity job);
	
	QuartzJobEntity getQuartzJobById(Long jobId);
	
	int updateQuartzJob(QuartzJobEntity job);
	
	int batchRemoveQuartzJob(Long[] id);
	
	int batchUpdate(Long[] jobId, Integer status);
	
}
