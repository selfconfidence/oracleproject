package com.springbootmybatis.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author misterWei
 * @create 2018年09月27号:19点54分
 * @mailbox mynameisweiyan@gmail.com
 */
@Entity
@Table(name = "s_student")
public class Student implements Serializable{

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private  Long sid;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    private  String sname;

}
