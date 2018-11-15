package com.jk.common.annotation;

import java.lang.annotation.*;

/**
 * 数据源注解
 * @author zcl<yczclcn@163.com>
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicDataSource {

    String value() default "";

}

