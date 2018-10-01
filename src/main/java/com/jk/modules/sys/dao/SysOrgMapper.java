package com.jk.modules.sys.dao;

import com.jk.modules.sys.entity.SysOrgEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 组织架构
 *
 */
@Mapper
public interface SysOrgMapper extends BaseMapper<SysOrgEntity> {

	int countOrgChildren(Long parentId);
	
}
