package com.jk.modules.sys.manager.impl;

import java.util.List;

import com.jk.common.utils.CommonUtils;
import com.jk.modules.sys.dao.SysOrgMapper;
import com.jk.modules.sys.dao.SysRoleOrgMapper;
import com.jk.modules.sys.entity.SysOrgEntity;
import com.jk.modules.sys.manager.SysOrgManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 组织架构
 *
 */
@Component("sysOrgManager")
public class SysOrgManagerImpl implements SysOrgManager {

	@Autowired
	private SysOrgMapper sysOrgMapper;
	
	@Autowired
	private SysRoleOrgMapper sysRoleOrgMapper;
	
	@Override
	public List<SysOrgEntity> listOrg() {
		return sysOrgMapper.list();
	}
	@Override
	public List<SysOrgEntity> listOrg1() {
		return sysOrgMapper.list1();
	}

	@Override
	public int saveOrg(SysOrgEntity org) {
		return sysOrgMapper.save(org);
	}

	@Override
	public SysOrgEntity getOrg(Long orgId) {
		return sysOrgMapper.getObjectById(orgId);
	}

	@Override
	public int updateOrg(SysOrgEntity org) {
		return sysOrgMapper.update(org);
	}

	@Override
	public int bactchRemoveOrg(Long[] id) {
		int count = sysOrgMapper.batchRemove(id);
		sysRoleOrgMapper.batchRemoveByOrgId(id);
		return count;
	}

	@Override
	public boolean hasChildren(Long[] id) {
		for(Long parentId : id) {
			int count = sysOrgMapper.countOrgChildren(parentId);
			if(CommonUtils.isIntThanZero(count)) {
				return true;
			}
		}
		return false;
	}

}
