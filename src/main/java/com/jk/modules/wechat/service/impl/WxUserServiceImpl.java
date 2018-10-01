package com.jk.modules.wechat.service.impl;

import java.util.Map;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.common.entity.R;
import com.jk.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jk.modules.wechat.entity.WxUserEntity;
import com.jk.modules.wechat.manager.WxUserManager;
import com.jk.modules.wechat.service.WxUserService;

/**
 * InnoDB free: 7168 kB
 *
 * @author Mr.Xue
 * @email Vision¡¢Team@163.com
 * @url www.visionteam.com
 * @date 2018年1月02日 上午11:25:10
 */
@Service("wxUserService")
public class WxUserServiceImpl implements WxUserService {

	@Autowired
	private WxUserManager wxUserManager;

	@Override
	public Page<WxUserEntity> listWxUser(Map<String, Object> params) {
		Query query = new Query(params);
		Page<WxUserEntity> page = new Page<>(query);
		wxUserManager.listWxUser(page, query);
		return page;
	}

	@Override
	public R saveWxUser(WxUserEntity role) {
		int count = wxUserManager.saveWxUser(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getWxUserById(Long id) {
		WxUserEntity wxUser = wxUserManager.getWxUserById(id);
		return CommonUtils.msg(wxUser);
	}

	@Override
	public R updateWxUser(WxUserEntity wxUser) {
		int count = wxUserManager.updateWxUser(wxUser);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = wxUserManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public WxUserEntity getByUserAccount(String account){return wxUserManager.getByUserAccount(account);}
}
