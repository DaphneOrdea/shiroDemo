package com.phantom;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
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
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("张三","12345");
        try {
            subject.login(usernamePasswordToken);
            if (subject.isAuthenticated()){
                System.out.println("验证通过");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
//        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
//        JdbcRealm jdbcRealm = new JdbcRealm();
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        druidDataSource.setUsername("root");
//        druidDataSource.setPassword("root");
//        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/shiro?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
//        jdbcRealm.setDataSource(druidDataSource);
//        defaultSecurityManager.setRealm(jdbcRealm);
//        SecurityUtils.setSecurityManager(defaultSecurityManager);
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(new UsernamePasswordToken("张三","12345"));
//            if (subject.isAuthenticated()){
//                System.out.println("验证通过");
//            }
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//        }
    }
}
