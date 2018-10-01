package com.jk.modules.sys.service;

import java.util.List;

import com.jk.common.entity.R;
import com.jk.modules.sys.entity.SysOrgEntity;

/**
 * 组织机构
 *
 */
public interface SysOrgService {

	List<SysOrgEntity> listOrg();

	List<SysOrgEntity> listOrg1();

	List<SysOrgEntity> listOrgTree();
	
	R saveOrg(SysOrgEntity org);
	
	R getOrg(Long orgId);
	
	R updateOrg(SysOrgEntity org);
	
	R bactchRemoveOrg(Long[] id);
	
}
