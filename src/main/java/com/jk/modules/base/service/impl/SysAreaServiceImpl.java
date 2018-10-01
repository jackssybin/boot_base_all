package com.jk.modules.base.service.impl;

import java.util.List;
import java.util.Map;

import com.jk.common.constant.MsgConstant;
import com.jk.common.entity.Query;
import com.jk.common.entity.R;
import com.jk.common.utils.CommonUtils;
import com.jk.modules.base.entity.SysAreaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.modules.base.manager.SysAreaManager;
import com.jk.modules.base.service.SysAreaService;

/**
 * 行政区域
 *
 */
@Service("sysAreaService")
public class SysAreaServiceImpl implements SysAreaService {

	@Autowired
	private SysAreaManager sysAreaManager;
	
	@Override
	public List<SysAreaEntity> listAreaByParentCode(String areaCode) {
		Query query = new Query();
		query.put("parentCode", areaCode);
		List<SysAreaEntity> areas = sysAreaManager.listAreaByParentCode(query);
		for(SysAreaEntity area : areas) {
			area.checkParent();
		}
		return areas;
	}

	@Override
	public R saveArea(SysAreaEntity area) {
		int count = sysAreaManager.saveArea(area);
		return CommonUtils.msg(count);
	}

	@Override
	public R getAreaById(Long areaId) {
		SysAreaEntity area = sysAreaManager.getAreaById(areaId);
		area.checkParentName();
		return CommonUtils.msg(area);
	}

	@Override
	public R updateArea(SysAreaEntity area) {
		int count = sysAreaManager.updateArea(area);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemoveArea(Long[] id) {
		boolean children = sysAreaManager.hasChildren(id);
		if(children) {
			return R.error(MsgConstant.MSG_HAS_CHILD);
		}
		int count = sysAreaManager.batchRemoveArea(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R listAreaByParentCode(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysAreaEntity> areas = sysAreaManager.listAreaByParentCode(query);
		return CommonUtils.msg(areas);
	}

}
