package com.phantom.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author : phantom
 * @desc : 自定义realm的实现
 * doGetAuthorizationInfo 获取授权信息
 * doGetAuthenticationInfo 获取认证信息
 * @create : 2019/12/12 16:57
 */
public class UserRealm  extends AuthorizingRealm {

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    //获取认证信息(从数据库中取数据,真正匹配验证的是shiro),完成身份认证，并且返回认证信息
    //如果身份认证失败返回 null
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户输入的用户名
        String username = (String)token.getPrincipal();//获取身份信息
        System.out.println("username = " + username);
        //根据用户名到数据库查询密码信息--模拟
        //假使模拟从数据库获取的密码为1111
        String pwd = "1111";
        //SimpleAuthenticationInfo(简单身份验证)这里模拟的数据，这个身份验证的数据需从数据库查出来的，username,pwd
        String name = getName();
        System.out.println("name = " + name);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,pwd,getName());
        return info;
    }

    //获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
