package com.jk.modules.quartz.service.impl;

import java.util.Map;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.common.entity.R;
import com.jk.common.utils.CommonUtils;
import com.jk.modules.quartz.service.QuartzJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.modules.quartz.entity.QuartzJobLogEntity;
import com.jk.modules.quartz.manager.QuartzJobLogManager;

/**
 * 定时任务日志
 *
 */
@Service("quartzJobLogService")
public class QuartzJobLogServiceImpl implements QuartzJobLogService {

	@Autowired
	private QuartzJobLogManager quartzJobLogManager;
	
	@Override
	public Page<QuartzJobLogEntity> listForPage(Map<String, Object> params) {
		Query query = new Query(params);
		Page<QuartzJobLogEntity> page = new Page<>(query);
		quartzJobLogManager.listForPage(page, query);
		return page;
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = quartzJobLogManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R batchRemoveAll() {
		int count = quartzJobLogManager.batchRemoveAll();
		return CommonUtils.msg(count);
	}


}
