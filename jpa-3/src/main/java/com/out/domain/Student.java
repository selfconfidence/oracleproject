package com.out.domain;

import javax.persistence.*;

/**
 * @author misterWei
 * @create 2018年09月23号:20点29分
 * @mailbox mynameisweiyan@gmail.com
 */
//声明映射关系
@javax.persistence.Entity
@Table(name = "s_student")
public class Student {
    //配置主键 以及其它字段名称
    @Id//主键生成策略
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "s_id" )
    private Long sid;
    @Column(name = "s_name",length = 20)
    private String sname;
    @Column(name = "s_gender",length = 1)
    private Integer gender;
    @Column(name="s_age",length = 3)
    private Integer age;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    //多对一操作
    @ManyToOne(targetEntity = Teacher.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id",referencedColumnName = "t_id")
    private Teacher teacher;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Column(name="s_grade",length = 10)
    private  String grade;


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


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", grade=" + grade +
                '}';
    }

}
