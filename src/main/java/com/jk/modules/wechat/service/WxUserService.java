package com.jk.modules.wechat.service;

import java.util.Map;

import com.jk.common.entity.Page;
import com.jk.common.entity.R;
import com.jk.modules.wechat.entity.WxUserEntity;

/**
 * InnoDB free: 7168 kB
 *
 * @author Mr.Xue
 * @email Vision¡¢Team@163.com
 * @url www.visionteam.com
 * @date 2018年1月02日 上午11:25:10
 */
public interface WxUserService {

	Page<WxUserEntity> listWxUser(Map<String, Object> params);
	
	R saveWxUser(WxUserEntity wxUser);
	
	R getWxUserById(Long id);
	
	R updateWxUser(WxUserEntity wxUser);
	
	R batchRemove(Long[] id);

	WxUserEntity getByUserAccount(String username);
}
