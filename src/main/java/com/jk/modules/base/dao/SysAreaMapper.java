package com.jk.modules.base.dao;

import java.util.List;

import com.jk.common.entity.Query;
import com.jk.modules.sys.dao.BaseMapper;
import com.jk.modules.base.entity.SysAreaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 行政区域
 *
 */
@Mapper
public interface SysAreaMapper extends BaseMapper<SysAreaEntity> {

	List<SysAreaEntity> listAreaByParentCode(Query query);
	
	int countAreaChildren(Long areaId);
	
}
