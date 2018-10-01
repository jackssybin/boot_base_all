package com.jk.modules.test.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.test.dao.SysTestMapper;
import com.jk.modules.test.entity.SysTestEntity;
import com.jk.modules.test.manager.SysTestManager;

/**
 * 系统用户测试
 *
 * @author jackssy
 * @email 27208461@qq.com
 * @url www.baidu.com
 * @date 2018年9月28日 下午3:39:36
 */
@Component("sysTestManager")
public class SysTestManagerImpl implements SysTestManager {

	@Autowired
	private SysTestMapper sysTestMapper;
	

	@Override
	public List<SysTestEntity> listSysTest(Page<SysTestEntity> page, Query search) {
		return sysTestMapper.listForPage(page, search);
	}

	@Override
	public int saveSysTest(SysTestEntity sysTest) {
		return sysTestMapper.save(sysTest);
	}

	@Override
	public SysTestEntity getSysTestById(Long id) {
		SysTestEntity sysTest = sysTestMapper.getObjectById(id);
		return sysTest;
	}

	@Override
	public int updateSysTest(SysTestEntity sysTest) {
		return sysTestMapper.update(sysTest);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = sysTestMapper.batchRemove(id);
		return count;
	}
	
}
