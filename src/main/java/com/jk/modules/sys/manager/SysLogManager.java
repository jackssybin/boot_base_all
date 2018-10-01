package com.jk.modules.sys.manager;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.sys.entity.SysLogEntity;

/**
 * 系统日志
 *
 */
public interface SysLogManager {

	void saveLog(SysLogEntity log);
	
	List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query);
	
	int batchRemove(Long[] id);
	
	int batchRemoveAll();
	
}
