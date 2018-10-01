package com.jk.modules.survery.manager.impl;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jk.modules.survery.dao.BzSurveyDirectoryMapper;
import com.jk.modules.survery.entity.BzSurveyDirectoryEntity;
import com.jk.modules.survery.manager.BzSurveyDirectoryManager;

/**
 * 
 *
 * @author jackssy
 * @email 27208461@qq.com
 * @url www.baidu.com
 * @date 2018年9月21日 下午10:14:24
 */
@Component("bzSurveyDirectoryManager")
public class BzSurveyDirectoryManagerImpl implements BzSurveyDirectoryManager {

	@Autowired
	private BzSurveyDirectoryMapper bzSurveyDirectoryMapper;
	

	@Override
	public List<BzSurveyDirectoryEntity> listBzSurveyDirectory(Page<BzSurveyDirectoryEntity> page, Query search) {
		return bzSurveyDirectoryMapper.listForPage(page, search);
	}

	@Override
	public int saveBzSurveyDirectory(BzSurveyDirectoryEntity bzSurveyDirectory) {
		return bzSurveyDirectoryMapper.save(bzSurveyDirectory);
	}

	@Override
	public BzSurveyDirectoryEntity getBzSurveyDirectoryById(Long id) {
		BzSurveyDirectoryEntity bzSurveyDirectory = bzSurveyDirectoryMapper.getObjectById(id);
		return bzSurveyDirectory;
	}

	@Override
	public int updateBzSurveyDirectory(BzSurveyDirectoryEntity bzSurveyDirectory) {
		return bzSurveyDirectoryMapper.update(bzSurveyDirectory);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = bzSurveyDirectoryMapper.batchRemove(id);
		return count;
	}
	
}
