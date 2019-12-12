package com.phantom;


import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

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
        //加盐,使用一个唯一标识,这里使用用户名
        md5Hash = new Md5Hash("1111","张三");
        System.out.println("加盐后 = " + md5Hash.toString());
        //迭代次数，加盐次数
        md5Hash = new Md5Hash("1111","张三",2);
        System.out.println("加盐后(2次) = " + md5Hash.toString());
        SimpleHash hash = new SimpleHash("MD5","1111","张三",2);
        System.out.println("SimpleHash加盐后，两次 = " + hash.toString());

    }
}
