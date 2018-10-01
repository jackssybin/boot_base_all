package com.jk.modules.survery.service.impl;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.common.entity.R;
import com.jk.common.utils.CommonUtils;
import com.jk.modules.survery.entity.BzSurveyDirectoryEntity;
import com.jk.modules.survery.manager.BzSurveyDirectoryManager;
import com.jk.modules.survery.service.BzSurveyDirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 
 *
 * @author jackssy
 * @email 27208461@qq.com
 * @url www.baidu.com
 * @date 2018年9月21日 下午10:14:24
 */
@Service("bzSurveyDirectoryService")
public class BzSurveyDirectoryServiceImpl implements BzSurveyDirectoryService {

	@Autowired
	private BzSurveyDirectoryManager bzSurveyDirectoryManager;

	@Override
	public Page<BzSurveyDirectoryEntity> listBzSurveyDirectory(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BzSurveyDirectoryEntity> page = new Page<>(query);
		bzSurveyDirectoryManager.listBzSurveyDirectory(page, query);
		return page;
	}

	@Override
	public R saveBzSurveyDirectory(BzSurveyDirectoryEntity role) {
		int count = bzSurveyDirectoryManager.saveBzSurveyDirectory(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getBzSurveyDirectoryById(Long id) {
		BzSurveyDirectoryEntity bzSurveyDirectory = bzSurveyDirectoryManager.getBzSurveyDirectoryById(id);
		return CommonUtils.msg(bzSurveyDirectory);
	}

	@Override
	public R updateBzSurveyDirectory(BzSurveyDirectoryEntity bzSurveyDirectory) {
		int count = bzSurveyDirectoryManager.updateBzSurveyDirectory(bzSurveyDirectory);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = bzSurveyDirectoryManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
