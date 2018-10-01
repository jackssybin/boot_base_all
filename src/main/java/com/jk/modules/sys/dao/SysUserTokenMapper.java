package com.jk.modules.sys.dao;

import com.jk.modules.sys.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户token
 *
 */
@Mapper
public interface SysUserTokenMapper extends BaseMapper<SysUserTokenEntity> {

	SysUserTokenEntity getByToken(String token);
	
	SysUserTokenEntity getByUserId(Long userId);
	
}
