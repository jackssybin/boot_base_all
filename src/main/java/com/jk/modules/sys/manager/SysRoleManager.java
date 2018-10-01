package com.jk.modules.sys.manager;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.sys.entity.SysRoleEntity;

/**
 * 系统角色
 *
 */
public interface SysRoleManager {

	List<SysRoleEntity> listRole(Page<SysRoleEntity> page, Query search);
	
	int saveRole(SysRoleEntity role);
	
	SysRoleEntity getRoleById(Long id);
	
	int updateRole(SysRoleEntity role);
	
	int batchRemove(Long[] id);
	
	List<SysRoleEntity> listRole();
	
	int updateRoleOptAuthorization(SysRoleEntity role);

	int updateRoleDataAuthorization(SysRoleEntity role);
	
}
