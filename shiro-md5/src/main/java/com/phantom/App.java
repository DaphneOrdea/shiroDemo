package com.phantom;


import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Hello world!
 * 使用MD5散列加密算法
 */
public class App 
{
    public static void main( String[] args )
    {
        //使用MD5加密算法
        Md5Hash md5Hash = new Md5Hash("1111");
        System.out.println("加盐前 = " + md5Hash.toString());
        //加盐
        md5Hash = new Md5Hash("1111","张三");
        System.out.println("加盐后 = " + md5Hash.toString());

    }
}
