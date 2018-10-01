package com.jk.modules.quartz.manager.impl;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.quartz.dao.QuartzJobLogMapper;
import com.jk.modules.quartz.entity.QuartzJobLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jk.modules.quartz.manager.QuartzJobLogManager;

/**
 * 定时任务日志
 *
 */
@Component("quartzJobLogManager")
public class QuartzJobLogManagerImpl implements QuartzJobLogManager {

	@Autowired
	private QuartzJobLogMapper quartzLobLogMapper;
	
	@Override
	public List<QuartzJobLogEntity> listForPage(Page<QuartzJobLogEntity> page, Query query) {
		return quartzLobLogMapper.listForPage(page, query);
	}

	@Override
	public int saveQuartzJobLog(QuartzJobLogEntity log) {
		return quartzLobLogMapper.save(log);
	}

	@Override
	public int batchRemove(Long[] id) {
		return quartzLobLogMapper.batchRemove(id);
	}

	@Override
	public int batchRemoveAll() {
		return quartzLobLogMapper.batchRemoveAll();
	}

}
