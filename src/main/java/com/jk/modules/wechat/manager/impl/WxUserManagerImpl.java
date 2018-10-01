package com.jk.modules.wechat.manager.impl;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.wechat.dao.WxUserMapper;
import com.jk.modules.wechat.manager.WxUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jk.modules.wechat.entity.WxUserEntity;

/**
 * InnoDB free: 7168 kB
 *
 * @author Mr.Xue
 * @email Vision¡¢Team@163.com
 * @url www.visionteam.com
 * @date 2018年1月02日 上午11:25:10
 */
@Component("wxUserManager")
public class WxUserManagerImpl implements WxUserManager {

	@Autowired
	private WxUserMapper wxUserMapper;
	

	@Override
	public List<WxUserEntity> listWxUser(Page<WxUserEntity> page, Query search) {
		return wxUserMapper.listForPage(page, search);
	}

	@Override
	public int saveWxUser(WxUserEntity wxUser) {
		return wxUserMapper.save(wxUser);
	}

	@Override
	public WxUserEntity getWxUserById(Long id) {
		WxUserEntity wxUser = wxUserMapper.getObjectById(id);
		return wxUser;
	}

	@Override
	public int updateWxUser(WxUserEntity wxUser) {
		return wxUserMapper.update(wxUser);
	}

	@Override
	public int batchRemove(Long[] id) {
		int count = wxUserMapper.batchRemove(id);
		return count;
	}

//		根据账户查询用户信息
	public WxUserEntity getByUserAccount(String account){return wxUserMapper.getByUserAccount(account);}
}
