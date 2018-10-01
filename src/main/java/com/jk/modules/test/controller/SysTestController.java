package com.jk.modules.test.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jk.common.annotation.SysLog;
import com.jk.modules.sys.controller.AbstractController;
import com.jk.common.entity.Page;
import com.jk.common.entity.R;
import com.jk.modules.test.entity.SysTestEntity;
import com.jk.modules.test.service.SysTestService;

/**
 * 系统用户测试
 *
 * @author jackssy
 * @email 27208461@qq.com
 * @url www.baidu.com
 * @date 2018年9月28日 下午3:39:36
 */
@RestController
@RequestMapping("/sys/test")
public class SysTestController extends AbstractController {
	
	@Autowired
	private SysTestService sysTestService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<SysTestEntity> list(@RequestBody Map<String, Object> params) {
		return sysTestService.listSysTest(params);
	}
		
	/**
	 * 新增
	 * @param sysTest
	 * @return
	 */
	@SysLog("新增系统用户测试")
	@RequestMapping("/save")
	public R save(@RequestBody SysTestEntity sysTest) {
		return sysTestService.saveSysTest(sysTest);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return sysTestService.getSysTestById(id);
	}
	
	/**
	 * 修改
	 * @param sysTest
	 * @return
	 */
	@SysLog("修改系统用户测试")
	@RequestMapping("/update")
	public R update(@RequestBody SysTestEntity sysTest) {
		return sysTestService.updateSysTest(sysTest);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除系统用户测试")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return sysTestService.batchRemove(id);
	}
	
}
