package com.jk.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jk.modules.sys.entity.SysMenuEntity;

/**
 * 系统菜单dao
 *
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {
	
	List<SysMenuEntity> listParentId(Long parentId);
	
	List<SysMenuEntity> listNotButton();
	
	List<String> listUserPerms(Long userId);
	
	int countMenuChildren(Long parentId);

}
