package com.jk.common.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD,ElementType.TYPE,ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourcePackage {
    String value() default "";
}
