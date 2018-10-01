package com.jk.modules.base.manager;

import java.util.List;

import com.jk.common.entity.Query;
import com.jk.modules.base.entity.SysAreaEntity;

/**
 * 行政区域
 *
 */
public interface SysAreaManager {

	List<SysAreaEntity> listAreaByParentCode(Query query);
	
	int saveArea(SysAreaEntity area);
	
	SysAreaEntity getAreaById(Long areaId);
	
	int updateArea(SysAreaEntity area);
	
	int batchRemoveArea(Long[] id);
	
	boolean hasChildren(Long[] id);
	
}
