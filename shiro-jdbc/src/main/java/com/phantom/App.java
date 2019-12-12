package com.phantom;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

import javax.sql.DataSource;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    {
        //创建默认的安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        securityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("DaphneOrdea","yyn");
        try {
            subject.login(usernamePasswordToken);
            if (subject.isAuthenticated()){
                System.out.println("验证通过");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}
