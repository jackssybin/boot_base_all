package com.jk.modules.generator.manager.impl;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.generator.manager.SysGeneratorManager;
import com.jk.modules.generator.dao.SysGeneratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jk.modules.generator.entity.ColumnEntity;
import com.jk.modules.generator.entity.TableEntity;

/**
 * 代码生成器
 *
 */
@Component("sysGeneratorManager")
public class SysGeneratorManagerImpl implements SysGeneratorManager {

	@Autowired
	private SysGeneratorMapper sysGeneratorMapper;
	
	@Override
	public void listTable(Page<TableEntity> page, Query query) {
		sysGeneratorMapper.listTable(page, query);
	}

	@Override
	public TableEntity getTableByName(String tableName) {
		return sysGeneratorMapper.getTableByName(tableName);
	}

	@Override
	public List<ColumnEntity> listColumn(String tableName) {
		return sysGeneratorMapper.listColumn(tableName);
	}

}
