package com.jk.druid;

/**
 * 增加多数据源
 *
 */
public enum DataSourceContext {
	
    DEFAULT("default");

    private String name;

    DataSourceContext(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
