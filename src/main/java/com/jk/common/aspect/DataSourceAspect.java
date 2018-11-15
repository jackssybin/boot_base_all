package com.jk.common.aspect;


import com.jk.common.annotation.DynamicDataSource;
import com.jk.druid.DynamicDataSourceContextHolder;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 数据源切面处理
 */
@Aspect
@Component
public class DataSourceAspect {

    private static Logger LOG = LoggerFactory.getLogger(DataSourceAspect.class);

    public static String infoDatasorceStartWith="com.jk.modules.bz";//这个根据包路径做区分了

//    @Pointcut("@annotation(com.jk.common.annotation.DynamicDataSource)") 两种形式 根据注解切 或者是根据mapper切
    @Pointcut(value="execution(public * com.jk.modules.*.*.service.*.*(..)) " +
            "|| execution(public * com.jk.modules.*.service.*.*(..)) ")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LOG.info("请求地址: CLASS_METHOD:" + signature.getDeclaringTypeName() + "."
                + signature.getName()+" 参数:");

        DynamicDataSource ds = method.getAnnotation(DynamicDataSource.class);
        if(null!=ds){
            String dataSource = ds.value();
            if (StringUtils.isBlank(dataSource)) {
                DynamicDataSourceContextHolder.useBaseDataSource();
                LOG.debug("set datasource is null, use datasource : {}", dataSource);
            } else {
                DynamicDataSourceContextHolder.setDataSourceKey(dataSource);
                LOG.debug("use datasource : {}", dataSource);
            }
        }else{
            if(signature.getDeclaringTypeName().startsWith(infoDatasorceStartWith)){
                DynamicDataSourceContextHolder.useInfoDataSource();
            }else{
                DynamicDataSourceContextHolder.useBaseDataSource();
            }
        }


        try {
            return point.proceed();
        } finally {
            DynamicDataSourceContextHolder.clearDataSourceKey();
            LOG.debug("clear datasource...");
        }

    }

}
