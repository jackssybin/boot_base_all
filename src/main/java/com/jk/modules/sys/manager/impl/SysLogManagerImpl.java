package com.jk.modules.sys.manager.impl;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.sys.dao.SysLogMapper;
import com.jk.modules.sys.entity.SysLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jk.modules.sys.manager.SysLogManager;

/**
 * 系统日志
 *
 */
@Component("sysLogManager")
public class SysLogManagerImpl implements SysLogManager {

	@Autowired
	private SysLogMapper sysLogMapper;
	
	@Override
	public void saveLog(SysLogEntity log) {
		sysLogMapper.save(log);
	}

	@Override
	public List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query) {
		return sysLogMapper.listForPage(page, query);
	}

	@Override
	public int batchRemove(Long[] id) {
		return sysLogMapper.batchRemove(id);
	}

	@Override
	public int batchRemoveAll() {
		return sysLogMapper.batchRemoveAll();
	}

}
