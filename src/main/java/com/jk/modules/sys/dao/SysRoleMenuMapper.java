package com.jk.modules.sys.dao;

import java.util.List;

import com.jk.modules.sys.entity.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统角色与菜单关系
 *
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {

	int batchRemoveByMenuId(Long[] id);
	
	int batchRemoveByRoleId(Long[] id);
	
	List<Long> listMenuId(Long id);
	
}
