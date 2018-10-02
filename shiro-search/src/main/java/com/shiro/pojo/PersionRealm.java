package com.shiro.pojo;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

/**
 * @author misterWei
 * @create 2018年09月30号:20点01分
 * @mailbox mynameisweiyan@gmail.com
 */
@SuppressWarnings("all")
public class PersionRealm extends AuthenticatingRealm {

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        if ("1".equals(username)){
            throw    new UnknownAccountException("没有账户信息!");
        }
        if ("2".equals(username)){
            throw   new ExcessiveAttemptsException("密码输入错误!");
        }
        //principal 当前登陆用户名称
        Object principal = username;
        //credentials 密码
        Object credentials= null;
        if ("admins".equals(username)){
            credentials= "e237009dc21d238a0964cf7aa70b4c59a5a355b9";
        }
        if ("managers".equals(username)){
            credentials= "642f08d73527091259646512451e718196702bb2";
        }

        //realmName当前Realm名称
        String realmName = getName();

        //盐值的加密 使用 这是用来Shiro内部审核的,
        ByteSource bytes = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(principal,credentials,bytes ,realmName);
        return simpleAuthenticationInfo;
    }

    public static void main(String[] args) {
        String algorithmName ="SHA1";
        Object source ="123456";
        int hashIterations = 1024; //经过多少次计算
        //加盐值                                  //一般都是以用户名作为盐之的
        ByteSource admin = ByteSource.Util.bytes("admins");

        Object salt = null;
        Object simpleHash = new SimpleHash(algorithmName, source,admin, hashIterations);
        System.out.println(simpleHash);
    }

}
