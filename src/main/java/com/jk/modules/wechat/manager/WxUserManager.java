package com.jk.modules.wechat.manager;

import java.util.List;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.wechat.entity.WxUserEntity;

/**
 * InnoDB free: 7168 kB
 *
 * @author Mr.Xue
 * @email Vision¡¢Team@163.com
 * @url www.visionteam.com
 * @date 2018年1月02日 上午11:25:10
 */
public interface WxUserManager {

	List<WxUserEntity> listWxUser(Page<WxUserEntity> page, Query search);
	
	int saveWxUser(WxUserEntity wxUser);
	
	WxUserEntity getWxUserById(Long id);
	
	int updateWxUser(WxUserEntity wxUser);
	
	int batchRemove(Long[] id);

	WxUserEntity getByUserAccount(String account);
	
}
