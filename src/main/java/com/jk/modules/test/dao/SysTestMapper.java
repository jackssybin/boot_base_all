package com.jk.modules.test.dao;

import org.apache.ibatis.annotations.Mapper;

import com.jk.modules.test.entity.SysTestEntity;
import com.jk.modules.sys.dao.BaseMapper;

/**
 * 系统用户测试
 *
 * @author jackssy
 * @email 27208461@qq.com
 * @url www.baidu.com
 * @date 2018年9月28日 下午3:39:36
 */
@Mapper
public interface SysTestMapper extends BaseMapper<SysTestEntity> {
	
}
