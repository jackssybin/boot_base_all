package com.jk.modules.survery.service;

import java.util.Map;

import com.jk.common.entity.*;
import com.jk.modules.survery.entity.BzSurveyDirectoryEntity;

/**
 * 
 *
 * @author jackssy
 * @email 27208461@qq.com
 * @url www.baidu.com
 * @date 2018年9月21日 下午10:14:24
 */
public interface BzSurveyDirectoryService {

	Page<BzSurveyDirectoryEntity> listBzSurveyDirectory(Map<String, Object> params);
	
	R saveBzSurveyDirectory(BzSurveyDirectoryEntity bzSurveyDirectory);
	
	R getBzSurveyDirectoryById(Long id);
	
	R updateBzSurveyDirectory(BzSurveyDirectoryEntity bzSurveyDirectory);
	
	R batchRemove(Long[] id);
	
}
