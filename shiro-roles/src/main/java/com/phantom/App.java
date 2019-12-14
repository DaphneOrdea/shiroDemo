package com.phantom;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 * Hello world!
 * 权限授予
 */
public class App {
    public static void main(String[] args) {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(new IniRealm("classpath:shiro-roles.ini"));
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("DaphneOrdea", "yyn"));
        boolean authenticated = subject.isAuthenticated();
        if (authenticated) {
            //检查用户是否有该角色，返回true或false
            boolean roles1 = subject.hasRole("roles");
            System.out.println("roles1 = " + roles1);
            //检查该用户是否有该角色，没有则抛出异常
            subject.checkRole("roles");
            //检测用户是否拥有该权限
            boolean permitted = subject.isPermitted("user:add");
            System.out.println("permitted = " + permitted);
            //检测用户是否有某个权限，没有则抛出异常
            subject.checkPermission("user:dd");
        }
    }
}
