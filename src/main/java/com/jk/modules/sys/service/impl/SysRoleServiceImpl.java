package com.jk.modules.sys.service.impl;

import java.util.List;
import java.util.Map;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.common.entity.R;
import com.jk.common.utils.CommonUtils;
import com.jk.modules.sys.entity.SysRoleEntity;
import com.jk.modules.sys.manager.SysRoleManager;
import com.jk.modules.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统角色
 *
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleManager sysRoleManager;

	@Override
	public Page<SysRoleEntity> listRole(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysRoleEntity> page = new Page<>(query);
		sysRoleManager.listRole(page, query);
		return page;
	}

	@Override
	public R saveRole(SysRoleEntity role) {
		int count = sysRoleManager.saveRole(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getRoleById(Long id) {
		SysRoleEntity role = sysRoleManager.getRoleById(id);
		return CommonUtils.msg(role);
	}

	@Override
	public R updateRole(SysRoleEntity role) {
		int count = sysRoleManager.updateRole(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = sysRoleManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R listRole() {
		List<SysRoleEntity> roleList = sysRoleManager.listRole();
		return CommonUtils.msgNotCheckNull(roleList);
	}

	@Override
	public R updateRoleOptAuthorization(SysRoleEntity role) {
		int count = sysRoleManager.updateRoleOptAuthorization(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R updateRoleDataAuthorization(SysRoleEntity role) {
		int count = sysRoleManager.updateRoleDataAuthorization(role);
		return CommonUtils.msg(count);
	}
	
}
