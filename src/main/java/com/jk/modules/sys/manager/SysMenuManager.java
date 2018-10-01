package com.jk.modules.sys.manager;

import java.util.List;

import com.jk.common.entity.Query;
import com.jk.modules.sys.entity.SysMenuEntity;

/**
 * 系统菜单
 *
 */
public interface SysMenuManager {
	
	List<SysMenuEntity> listUserMenu(Long userId);
	
	List<SysMenuEntity> listParentId(Long parentId, List<Long> menuIdList);
	
	List<SysMenuEntity> listMenu(Query search);
	
	List<SysMenuEntity> listNotButton();
	
	int saveMenu(SysMenuEntity menu);

	SysMenuEntity getMenuById(Long id);
	
	int updateMenu(SysMenuEntity menu);
	
	int batchRemove(Long[] id);
	
	boolean hasChildren(Long[] id);
	
}
