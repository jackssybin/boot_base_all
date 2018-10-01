package com.jk.modules.sys.dao;

import java.util.List;

import com.jk.common.entity.Query;
import com.jk.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户dao
 *
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

	SysUserEntity getByUserName(String username);
	
	List<Long> listAllMenuId(Long userId);
	
	List<Long> listAllOrgId(Long userId);
	
	int updatePswdByUser(Query query);
	
	int updateUserStatus(Query query);
	
	int updatePswd(SysUserEntity user);
	
}
