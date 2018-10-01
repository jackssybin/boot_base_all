package com.jk.modules.survery.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jk.common.annotation.SysLog;
import com.jk.modules.sys.controller.AbstractController;
import com.jk.common.entity.Page;
import com.jk.common.entity.R;
import com.jk.modules.survery.entity.BzSurveyDirectoryEntity;
import com.jk.modules.survery.service.BzSurveyDirectoryService;



/**
 * 
 *
 * @author jackssy
 * @email 27208461@qq.com
 * @url www.baidu.com
 * @date 2018年9月21日 下午10:14:24
 */
@RestController
@RequestMapping("/base/survery")
public class BzSurveyDirectoryController extends AbstractController {
	
	@Autowired
	private BzSurveyDirectoryService bzSurveyDirectoryService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BzSurveyDirectoryEntity> list(@RequestBody Map<String, Object> params) {
		return bzSurveyDirectoryService.listBzSurveyDirectory(params);
	}
		
	/**
	 * 新增
	 * @param bzSurveyDirectory
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody BzSurveyDirectoryEntity bzSurveyDirectory) {
		return bzSurveyDirectoryService.saveBzSurveyDirectory(bzSurveyDirectory);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return bzSurveyDirectoryService.getBzSurveyDirectoryById(id);
	}
	
	/**
	 * 修改
	 * @param bzSurveyDirectory
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody BzSurveyDirectoryEntity bzSurveyDirectory) {
		return bzSurveyDirectoryService.updateBzSurveyDirectory(bzSurveyDirectory);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return bzSurveyDirectoryService.batchRemove(id);
	}
	
}
