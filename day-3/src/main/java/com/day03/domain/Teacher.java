package com.day03.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author misterWei
 * @create 2018年09月26号:12点14分
 * @mailbox mynameisweiyan@gmail.com
 */
@Entity
@Table(name = "t_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "t_id")
    private  Long tid;
    @Column(name = "t_name",length = 20)
    private  String tname;
    @Column(name = "t_age",length = 3)
    private Integer tage;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tage=" + tage +
                ", sex='" + sex + '\'' +
                ", students=" + students +
                '}';
    }

    @Column(name = "t_sex",length = 2)
    private  String sex;
    @OneToMany(mappedBy = "teacher")
    private Set<Student> students =new HashSet<Student>();

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getTage() {
        return tage;
    }

    public void setTage(Integer tage) {
        this.tage = tage;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
