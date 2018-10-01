package com.jk.modules.sys.service;

import java.util.Map;

import com.jk.common.entity.Page;
import com.jk.common.entity.R;
import com.jk.modules.sys.entity.SysRoleEntity;

/**
 * 系统角色
 *
 */
public interface SysRoleService {

	Page<SysRoleEntity> listRole(Map<String, Object> params);
	
	R saveRole(SysRoleEntity role);
	
	R getRoleById(Long id);
	
	R updateRole(SysRoleEntity role);
	
	R batchRemove(Long[] id);
	
	R listRole();
	
	R updateRoleOptAuthorization(SysRoleEntity role);
	
	R updateRoleDataAuthorization(SysRoleEntity role);
	
}
