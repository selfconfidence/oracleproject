package com.shiro.pojo;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

/**
 * @author misterWei
 * @create 2018年09月30号:20点01分
 * @mailbox mynameisweiyan@gmail.com
 */
@SuppressWarnings("all")
public class UserRealm extends AuthorizingRealm {

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
        if ("admin".equals(username)){
             credentials= "038bdaf98f2037b31f1e75b5b4c9b26e";
        }
        if ("manager".equals(username)){
             credentials= "5a177b6b7f7c781b0b7db56706980c8f";
        }

        //realmName当前Realm名称
        String realmName = getName();

        //盐值的加密 使用 这是用来Shiro内部审核的,
        ByteSource bytes = ByteSource.Util.bytes(username);
SimpleAuthenticationInfo simpleAuthenticationInfo =
        new SimpleAuthenticationInfo(principal,credentials,bytes ,realmName);
        return simpleAuthenticationInfo;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户的登陆信息的准操作
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        //利用当前用户的登陆信息,来获取是否有权限(应当去查询数据库)
        Set set = new HashSet();
        set.add("managers");
        System.out.println(primaryPrincipal);
        if ("admins".equals(primaryPrincipal)){
            set.add("admins");
        }
        //返回授权信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(set);
        System.out.println("授权执行了.....");
        return simpleAuthorizationInfo;
    }
}
