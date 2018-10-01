package com.jk.modules.generator.dao;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.generator.entity.ColumnEntity;
import com.jk.modules.generator.entity.TableEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 代码生成器
 *
 */
@Mapper
public interface SysGeneratorMapper {

	List<TableEntity> listTable(Page<TableEntity> page, Query query);
	
	TableEntity getTableByName(String tableName);
	
	List<ColumnEntity> listColumn(String tableName);
	
}
