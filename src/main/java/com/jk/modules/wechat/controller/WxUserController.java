package com.jk.modules.wechat.controller;

import java.util.Date;
import java.util.Map;

import com.jk.common.annotation.SysLog;
import com.jk.common.entity.Page;
import com.jk.common.entity.R;
import com.jk.common.utils.CommonUtils;
import com.jk.modules.wechat.entity.WxUserEntity;
import com.jk.modules.wechat.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员信息
 *
 * @author Mr.Xue
 * @email Vision¡¢Team@163.com
 * @url www.visionteam.com
 * @date 2018年1月02日 上午11:25:10
 */
@RestController
@RequestMapping("/sys/vip")
public class WxUserController extends AbstractController {
	
	@Autowired
	private WxUserService wxUserService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@SysLog("浏览会员信息-pc")
	@RequestMapping("/list")
	public Page<WxUserEntity> list(@RequestBody Map<String, Object> params) {
		return wxUserService.listWxUser(params);
	}
		
	/**
	 * 新增
	 * @param wxUser
	 * @return
	 */
	@SysLog("新增会员信息-pc")
	@RequestMapping("/save")
	public R save(@RequestBody WxUserEntity wxUser, String province, String city, String district) {
//		根据账号查询显示该用户存在否
		WxUserEntity u = wxUserService.getByUserAccount(wxUser.getAccount());
		if(u!=null) {
			return CommonUtils.msg(0);
		}else {
			wxUser.setPortrait("../../images/avatar.png");//默认头像
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			wxUser.setInTime(new Date());
			wxUser.setGrade(1);//等级
			wxUser.setOnline(0);//在线方式-不在线
			wxUser.setProvince(province);
			wxUser.setCity(city);
			wxUser.setArea(district);
			return wxUserService.saveWxUser(wxUser);
		}
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return wxUserService.getWxUserById(id);
	}

	/**
	 * 修改
	 * @param wxUser
	 * @return
	 */
	@SysLog("修改会员信息-pc")
	@RequestMapping("/update")
	public R update(@RequestBody WxUserEntity wxUser) {
		return wxUserService.updateWxUser(wxUser);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除会员信息-pc")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return wxUserService.batchRemove(id);
	}
	
}
