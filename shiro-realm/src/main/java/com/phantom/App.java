package com.phantom;

import com.phantom.realm.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Hello world!
 * 自定义realm shiro并不会维护数据，数据需要传递给shiro相应接口，shiro对数据进行校验
 */
public class App 
{
    public static void main( String[] args )
    {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(new UserRealm());
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken("张三","1111"));
            if (subject.isAuthenticated()) {
                System.out.println("验证通过");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("验证失败");
        }
    }
}
