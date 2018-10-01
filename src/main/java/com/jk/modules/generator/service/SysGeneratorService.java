package com.jk.modules.generator.service;

import java.util.Map;

import com.jk.common.entity.Page;
import com.jk.modules.generator.entity.GeneratorParamEntity;
import com.jk.modules.generator.entity.TableEntity;

/**
 * 代码生成器
 *
 */
public interface SysGeneratorService {

	Page<TableEntity> listTable(Map<String, Object> params);
	
	byte[] generator(GeneratorParamEntity params);
	
}
