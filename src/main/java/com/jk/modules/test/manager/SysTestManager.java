package com.jk.modules.test.manager;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.test.entity.SysTestEntity;

/**
 * 系统用户测试
 *
 * @author jackssy
 * @email 27208461@qq.com
 * @url www.baidu.com
 * @date 2018年9月28日 下午3:39:36
 */
public interface SysTestManager {

	List<SysTestEntity> listSysTest(Page<SysTestEntity> page, Query search);
	
	int saveSysTest(SysTestEntity sysTest);
	
	SysTestEntity getSysTestById(Long id);
	
	int updateSysTest(SysTestEntity sysTest);
	
	int batchRemove(Long[] id);
	
}
