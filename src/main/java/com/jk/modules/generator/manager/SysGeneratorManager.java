package com.jk.modules.generator.manager;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.generator.entity.ColumnEntity;
import com.jk.modules.generator.entity.TableEntity;

/**
 * 代码生成器
 *
 */
public interface SysGeneratorManager {

	void listTable(Page<TableEntity> page, Query query);
	
	TableEntity getTableByName(String tableName);
	
	List<ColumnEntity> listColumn(String tableName);
	
}
