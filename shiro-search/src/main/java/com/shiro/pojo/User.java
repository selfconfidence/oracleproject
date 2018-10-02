package com.shiro.pojo;

import java.io.Serializable;

/**
 * @author misterWei
 * @create 2018年10月01号:00点35分
 * @mailbox mynameisweiyan@gmail.com
 */
public class User implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String account;
    private String name;
    private String password;
}
