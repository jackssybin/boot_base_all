package com.jk.modules.survery.manager;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.survery.entity.BzSurveyDirectoryEntity;

/**
 * 
 *
 * @author jackssy
 * @email 27208461@qq.com
 * @url www.baidu.com
 * @date 2018年9月21日 下午10:14:24
 */
public interface BzSurveyDirectoryManager {

	List<BzSurveyDirectoryEntity> listBzSurveyDirectory(Page<BzSurveyDirectoryEntity> page, Query search);
	
	int saveBzSurveyDirectory(BzSurveyDirectoryEntity bzSurveyDirectory);
	
	BzSurveyDirectoryEntity getBzSurveyDirectoryById(Long id);
	
	int updateBzSurveyDirectory(BzSurveyDirectoryEntity bzSurveyDirectory);
	
	int batchRemove(Long[] id);
	
}
