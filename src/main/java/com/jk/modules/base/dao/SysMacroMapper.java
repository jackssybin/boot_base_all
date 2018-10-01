package com.jk.modules.base.dao;

import java.util.List;

import com.jk.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.jk.modules.base.entity.SysMacroEntity;


/**
 * 通用字典
 *
 */
@Mapper
public interface SysMacroMapper extends BaseMapper<SysMacroEntity> {

	List<SysMacroEntity> listNotMacro();
	
	int countMacroChildren(Long typeId);
	
}
