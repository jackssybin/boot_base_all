package com.jk.modules.sys.manager;

import java.util.List;
import java.util.Set;

import com.jk.common.entity.Page;
import com.jk.common.entity.Query;
import com.jk.modules.sys.entity.SysUserEntity;
import com.jk.modules.sys.entity.SysUserTokenEntity;

/**
 * 系统用户
 *
 */
public interface SysUserManager {

	SysUserEntity getByUserName(String username);
	
	List<SysUserEntity> listUser(Page<SysUserEntity> page, Query search);
	
	int saveUser(SysUserEntity user);
	
	SysUserEntity getById(Long userId);
	
	int updateUser(SysUserEntity user);
	
	int batchRemove(Long[] id);
	
	Set<String> listUserPerms(Long userId);
	
	Set<String> listUserRoles(Long userId);
	
	int updatePswdByUser(Query query);
	
	int updateUserEnable(Long[] id);
	
	int updateUserDisable(Long[] id);
	
	int updatePswd(SysUserEntity user);
	
	SysUserEntity getUserById(Long userId);
	
	SysUserTokenEntity getByToken(String token);
	
	SysUserTokenEntity saveUserToken(Long userId);
	
	int updateUserToken(Long userId);
	
}
