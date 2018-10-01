package com.jk.modules.sys.manager;

import java.util.List;

import com.jk.modules.sys.entity.SysOrgEntity;

/**
 * 组织机构
 *
 */
public interface SysOrgManager {

	List<SysOrgEntity> listOrg();

	List<SysOrgEntity> listOrg1();

	int saveOrg(SysOrgEntity org);
	
	SysOrgEntity getOrg(Long orgId);
	
	int updateOrg(SysOrgEntity org);
	
	int bactchRemoveOrg(Long[] id);
	
	boolean hasChildren(Long[] id);
	
}
