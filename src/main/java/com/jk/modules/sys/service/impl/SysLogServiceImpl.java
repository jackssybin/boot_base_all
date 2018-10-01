package com.jk.modules.sys.service.impl;

import java.util.Map;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.common.entity.R;
import com.jk.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.modules.sys.entity.SysLogEntity;
import com.jk.modules.sys.manager.SysLogManager;
import com.jk.modules.sys.service.SysLogService;

/**
 * 系统日志
 *
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogManager sysLogManager;
	
	@Override
	public Page<SysLogEntity> listLog(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysLogEntity> page = new Page<>(query);
		sysLogManager.listLog(page, query);
		return page;
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = sysLogManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R batchRemoveAll() {
		int count = sysLogManager.batchRemoveAll();
		return CommonUtils.msg(count);
	}

}
