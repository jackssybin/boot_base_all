package com.jk.modules.quartz.manager;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.quartz.entity.QuartzJobLogEntity;

/**
 * 定时任务日志
 *
 */
public interface QuartzJobLogManager {

	List<QuartzJobLogEntity> listForPage(Page<QuartzJobLogEntity> page, Query query);
	
	int saveQuartzJobLog(QuartzJobLogEntity log);
	
	int batchRemove(Long[] id);
	
	int batchRemoveAll();
	
}
