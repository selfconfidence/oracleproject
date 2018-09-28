package com.springbootmybatis.domain;
import java.io.Serializable;
/**
 * @author misterWei
 * @create 2018年09月27号:18点26分
 * @mailbox mynameisweiyan@gmail.com
 */

public class User implements Serializable{
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "User{" +
                "sid='" + sid + '\'' +
                ", sname='" + SName + '\'' +
                '}';
    }


    private String sid;
    private String SName;

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }
}
