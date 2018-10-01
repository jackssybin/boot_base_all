package com.jk.modules.base.manager.impl;

import java.util.List;

import com.jk.common.entity.Query;
import com.jk.common.utils.CommonUtils;
import com.jk.modules.base.dao.SysAreaMapper;
import com.jk.modules.base.entity.SysAreaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jk.modules.base.manager.SysAreaManager;

/**
 * 行政区域
 *
 */
@Component("sysAreaManager")
public class SysAreaManagerImpl implements SysAreaManager {

	@Autowired
	private SysAreaMapper sysAreaMapper;
	
	@Override
	public List<SysAreaEntity> listAreaByParentCode(Query query) {
		return sysAreaMapper.listAreaByParentCode(query);
	}

	@Override
	public int saveArea(SysAreaEntity area) {
		return sysAreaMapper.save(area);
	}

	@Override
	public SysAreaEntity getAreaById(Long areaId) {
		return sysAreaMapper.getObjectById(areaId);
	}

	@Override
	public int updateArea(SysAreaEntity area) {
		return sysAreaMapper.update(area);
	}

	@Override
	public int batchRemoveArea(Long[] id) {
		return sysAreaMapper.batchRemove(id);
	}
	
	@Override
	public boolean hasChildren(Long[] id) {
		for(Long typeId : id) {
			int count = sysAreaMapper.countAreaChildren(typeId);
			if(CommonUtils.isIntThanZero(count)) {
				return true;
			}
		}
		return false;
	}
	
}
