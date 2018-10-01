package com.jk.modules.test.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.common.entity.R;
import com.jk.common.utils.CommonUtils;
import com.jk.modules.test.entity.SysTestEntity;
import com.jk.modules.test.manager.SysTestManager;
import com.jk.modules.test.service.SysTestService;

/**
 * 系统用户测试
 *
 * @author jackssy
 * @email 27208461@qq.com
 * @url www.baidu.com
 * @date 2018年9月28日 下午3:39:36
 */
@Service("sysTestService")
public class SysTestServiceImpl implements SysTestService {

	@Autowired
	private SysTestManager sysTestManager;

	@Override
	public Page<SysTestEntity> listSysTest(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysTestEntity> page = new Page<>(query);
		sysTestManager.listSysTest(page, query);
		return page;
	}

	@Override
	public R saveSysTest(SysTestEntity role) {
		int count = sysTestManager.saveSysTest(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getSysTestById(Long id) {
		SysTestEntity sysTest = sysTestManager.getSysTestById(id);
		return CommonUtils.msg(sysTest);
	}

	@Override
	public R updateSysTest(SysTestEntity sysTest) {
		int count = sysTestManager.updateSysTest(sysTest);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = sysTestManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
