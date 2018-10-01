package com.jk.modules.test.service;

import java.util.Map;

import com.jk.common.entity.Page;
import com.jk.common.entity.R;
import com.jk.modules.test.entity.SysTestEntity;

/**
 * 系统用户测试
 *
 * @author jackssy
 * @email 27208461@qq.com
 * @url www.baidu.com
 * @date 2018年9月28日 下午3:39:36
 */
public interface SysTestService {

	Page<SysTestEntity> listSysTest(Map<String, Object> params);
	
	R saveSysTest(SysTestEntity sysTest);
	
	R getSysTestById(Long id);
	
	R updateSysTest(SysTestEntity sysTest);
	
	R batchRemove(Long[] id);
	
}
