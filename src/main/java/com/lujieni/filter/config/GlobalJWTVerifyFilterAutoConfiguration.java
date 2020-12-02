package com.lujieni.filter.config;

import com.lujieni.filter.filter.GlobalJWTVerifyGlobalFilter;
import com.lujieni.filter.properties.GlobalJWTConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @Title GlobalJWTVerifyFilterAutoConfiguration
* @Package com.itiaoling.dedication.inner.config 
* @Description 全局登录校验过滤器自动装配
* @author 陈宇霖  
* @date 1/28/19 20:51
* @version V1.0   
*/
@Configuration
@EnableConfigurationProperties(GlobalJWTConfigProperties.class)
/* ConditionalOnProperty:"scorpio.filters.jwt.enabled为true才加载这个类 */
@ConditionalOnProperty(prefix = "scorpio.filters.jwt", name = "enabled")
public class GlobalJWTVerifyFilterAutoConfiguration {

    @Autowired
    private GlobalJWTConfigProperties globalJWTConfigProperties;

    /**
     * 注册 登录校验过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean globalJWTVerifyGlobalFilterRegistration() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        GlobalJWTVerifyGlobalFilter filter = new GlobalJWTVerifyGlobalFilter();
        filter.setGlobalJWTConfigProperties(globalJWTConfigProperties);
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/*");// /*就可以匹配所有,即使是/say/hello这样的
        registrationBean.setOrder(10);// 值越小，Filter越靠前。
        return registrationBean;
    }


}
