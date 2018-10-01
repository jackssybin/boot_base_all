package com.jk.modules.base.service;

import java.util.List;

import com.jk.common.entity.R;
import com.jk.modules.base.entity.SysMacroEntity;

/**
 * 通用字典
 *
 */
public interface SysMacroService {

	List<SysMacroEntity> listMacro();
	
	List<SysMacroEntity> listNotMacro();
	
	R saveMacro(SysMacroEntity macro);
	
	R getObjectById(Long id);
	
	R updateMacro(SysMacroEntity macro);
	
	R batchRemove(Long[] id);
	
}
