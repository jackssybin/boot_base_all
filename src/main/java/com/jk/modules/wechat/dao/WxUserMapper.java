package com.jk.modules.wechat.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jk.modules.wechat.entity.WxUserEntity;

/**
 * InnoDB free: 7168 kB
 *
 * @author Mr.Xue
 * @email Vision¡¢Team@163.com
 * @url www.visionteam.com
 * @date 2018年1月02日 上午11:25:10
 */
@Mapper
public interface WxUserMapper extends BaseMapper<WxUserEntity> {
	WxUserEntity getByUserAccount(String account);
}
