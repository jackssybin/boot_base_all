package com.jk.modules.generator.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.generator.entity.ColumnEntity;
import com.jk.modules.generator.entity.GeneratorParamEntity;
import com.jk.modules.generator.entity.TableEntity;
import com.jk.modules.generator.manager.SysGeneratorManager;
import com.jk.modules.generator.utils.GenUtils;
import com.jk.modules.generator.service.SysGeneratorService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 代码生成器
 *
 */
@Service("sysGeneratorService")
public class SysGeneratorServiceImpl implements SysGeneratorService {

	@Autowired
	private SysGeneratorManager sysGeneratorManager;
	
	@Override
	public Page<TableEntity> listTable(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TableEntity> page = new Page<>(query);
		sysGeneratorManager.listTable(page, query);
		return page;
	}

	@Override
	public byte[] generator(GeneratorParamEntity params) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(out);
		for(String table : params.getTables()) {
			TableEntity tableEntity = sysGeneratorManager.getTableByName(table);
			List<ColumnEntity> columns = sysGeneratorManager.listColumn(table);
			GenUtils.generatorCode(tableEntity, columns, params, zip);
		}
		IOUtils.closeQuietly(zip);
		return out.toByteArray();
	}

}
