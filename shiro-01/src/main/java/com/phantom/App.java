package com.phantom;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 *  Hello world!
 *  shiro 的流程配置
 */
public class App 
{
    public static void main( String[] args )
    {
        //创建默认的securityManager（安全管理器）
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //创建Ini 域。读取shiro.ini文件
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        //读取域
        defaultSecurityManager.setRealm(iniRealm);
        //将securityManager对象设置到运行环境中
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //通过SecurityUtils获取主体subject(主体)
        Subject subject = SecurityUtils.getSubject();
        //这里的username和password表示用户登陆时的账户密码，而非域里面查找的username和password。Token(凭证)
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("DaphneOrdea", "yyn");
        try {
            //进行用户身份认证
            subject.login(usernamePasswordToken);
            //验证用户是否验证成功。Authenticated(认证)
            if (subject.isAuthenticated()) {
                System.out.println("用户登陆成功");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("用户名或密码认证失败");
        }
    }
}
