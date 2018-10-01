package com.jk.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jk.modules.sys.entity.SysRoleEntity;

/**
 * 系统角色
 *
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {
	
	List<String> listUserRoles(Long userId);
	
}
