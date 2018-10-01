package com.jk.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.jk.modules.sys.entity.SysRoleOrgEntity;

/**
 * 角色与机构的关系
 *
 */
@Mapper
public interface SysRoleOrgMapper extends BaseMapper<SysRoleOrgEntity> {

	List<Long> listOrgId(Long roleId);
	
	int batchRemoveByOrgId(Long[] id);
	
	int batchRemoveByRoleId(Long[] id);
	
}
