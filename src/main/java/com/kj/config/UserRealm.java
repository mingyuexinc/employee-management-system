package com.kj.config;

import com.kj.pojo.User;
import com.kj.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userServiceImpl;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        User user = (User) principalCollection.getPrimaryPrincipal();  // 拿到当前角色

        info.addStringPermission(user.getPerms());  // 授予角色其对应的权限

        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;  // 转换为正确的token格式

        // 根据用户名查询密码
        User user = userServiceImpl.queryUserByName(userToken.getUsername());

        if(user == null){
            return null;  // 抛出异常 UnknownAccountException
        }

        // 密码判断 可以加密(MD5加密  MD5颜值加密:再加上用户名密码)
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
