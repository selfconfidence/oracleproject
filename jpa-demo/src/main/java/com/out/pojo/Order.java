package com.out.pojo;

import javax.persistence.*;

/**
 * @author misterWei
 * @create 2018年09月20号:15点54分
 * @mailbox weiyan980522@outlook.com
 */
@Entity//声明一个实体类
@Table(name = "o_order")//指定数据库表
public class Order {

    //主键生成策略:
    //IDENTITY   自动增长:  mysql数据库比较适合
    //AUTO       程序自定义: 由程序去判断采用什么策略
    //SEQUENCE   序列化   : Oracle比较适合
    //TABLE      使用一个特定的数据库表格来保存主键
    @Id//指定主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Column  与hibernate注解开发原理相似
    @Column(name = "id")
    private Integer id;
    @Column(name = "meths")
    private String meths;

    @Column(name = "price")
    private Double price;

    @Column(name = "c_id")
    private Integer cId;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", meths='" + meths + '\'' +
                ", price=" + price +
                ", cId=" + cId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMeths() {
        return meths;
    }

    public void setMeths(String meths) {
        this.meths = meths;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
}
