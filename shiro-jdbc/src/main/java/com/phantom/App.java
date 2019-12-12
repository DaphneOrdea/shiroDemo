package com.phantom;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

/**
 * Hello world!
 */
public class App 
{
    private static final Logger log = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {

        //创建默认的安全管理器
//



        //编程式定义,生效
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        JdbcRealm jdbcRealm = new JdbcRealm();
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/shiro?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false");
        jdbcRealm.setDataSource(druidDataSource);
        defaultSecurityManager.setRealm(jdbcRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken("张三","12s345"));
            if (subject.isAuthenticated()){
                System.out.println("验证通过");
            }
        } catch (AuthenticationException e) {
//            e.printStackTrace();
            log.error("验证失败");
            System.out.println("验证失败");
        }
    }
}
