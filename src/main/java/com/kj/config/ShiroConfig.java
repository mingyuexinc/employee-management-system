package com.kj.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    // 创建UserRealm对象  创建顺序：1
    @Bean
    public UserRealm getUserRealm(){
        return new UserRealm();
    }

    // 创建DefaultWebSecurityManager对象  创建顺序：2
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Autowired UserRealm userRealm){

        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        // 关联userRealm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    // 创建ShiroFilterFactoryBean对象  创建顺序：3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Autowired DefaultWebSecurityManager getDefaultWebSecurityManager){

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        bean.setSecurityManager(getDefaultWebSecurityManager);
/*
*   authc:必须认证了才能访问
*   perms:必须拥有对某个资源的权限才能访问
*   roles:角色授权拦截器，验证用户是或否拥有角色
* */

        // 拦截请求
        Map<String,String> filterMap = new LinkedHashMap<>();

        // 需要授权,未授权则会跳到相应页面
        filterMap.put("/dep/*","perms[admin]");
        filterMap.put("/emp/**","authc");
        filterMap.put("/loginOut","logout");
        bean.setFilterChainDefinitionMap(filterMap);

        // 设置登录的请求
        bean.setLoginUrl("/");

        // 设置未授权请求
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }
}
