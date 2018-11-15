package com.jk.druid;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

	private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();
	/**
	 * Set dynamic DynamicDataSource to Application Context
	 *
	 * @return
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceContextHolder.getDataSourceKey();
	}

}