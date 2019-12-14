package com.phantom;

import com.phantom.realm.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Hello world!
 * 自定义realm实现授权
 */
public class App 
{
    public static void main( String[] args )
    {
        SecurityUtils.setSecurityManager(new DefaultSecurityManager(new UserRealm()));
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("张三","aaa"));
        if(subject.isAuthenticated())
        {
            //校验是否有权限，返回一个boolean数组
            boolean[] permitted = subject.isPermitted("user:add", "user:sa");
            //校验所有权限，所有都有则true，否则false
            boolean permittedAll = subject.isPermittedAll("user:add", "user:sas");
            System.out.println("permittedAll = " + permittedAll);
            for (boolean b : permitted) {
                System.out.println("b = " + b);
            }
        }
    }
}
