package com.shiro.pojo;

import com.shiro.dao.UserMapper;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author misterWei
 * @create 2018年09月30号:20点01分
 * @mailbox mynameisweiyan@gmail.com
 */
public class UsersRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//获取当前登陆人名称
        String userName = (String) super.getAvailablePrincipal(principalCollection);
        System.out.println(userName + "-----------asdasdasd");
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        System.out.println("验证当前Subject时获取到token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        User one = userMapper.findOne(token.getUsername());
        String user = this.getName();
        if (one != null) {
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(one.getName(), one.getPassword(), user);
            return authcInfo;
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
      //String algorithmName, Object source, Object salt, int hashIterations
        String algorithmName ="MD5";
        Object source ="123456";
        int hashIterations = 1024; //经过多少次计算
        //加盐值                                  //一般都是以用户名作为盐之的
        ByteSource admin = ByteSource.Util.bytes("manager");

        Object salt = null;
        Object simpleHash = new SimpleHash(algorithmName, source,admin, hashIterations);
        System.out.println(simpleHash);
    }



}
