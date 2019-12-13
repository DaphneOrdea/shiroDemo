package com.phantom.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;

/**
 * @author : phantom
 * @desc : AuthorizingRealm(授权领域) 自定义Realm
 * @create : 2019/12/13 16:41
 */
public class UserRealm extends AuthorizingRealm {


    //授权信息 PrincipalCollection(主要收集)
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        ArrayList<String> strings = new ArrayList<>();
        //权限集合，模拟数据库操作
        strings.add("user:add");
        strings.add("user:delete");
        strings.add("user:update");
        strings.add("user:select");
        //授权认证器
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //将权限列表添加进授权信息中
        info.addStringPermissions(strings);
        return info;
    }

    //认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取认证信息
        String userName = authenticationToken.getPrincipal().toString();
        //这里的密码模拟，实际从数据库获取，以及用户姓名
        String pwd = "aaa";
        //身份验证器
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,pwd,getName());

        return info;
    }


    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
