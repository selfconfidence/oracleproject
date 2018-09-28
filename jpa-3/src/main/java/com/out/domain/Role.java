package com.out.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author misterWei
 * @create 2018年09月26号:19点01分
 * @mailbox mynameisweiyan@gmail.com
 */
@Entity
@Table(name = "r_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "r_id")
    private Long rId;
    @Column(name = "r_name",length = 20)
    private String rName;
    @ManyToMany(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinTable(name = "u_r_table",joinColumns = @JoinColumn(name = "r_u_id",referencedColumnName = "r_id"),
    inverseJoinColumns = @JoinColumn(name = "u_r_id",referencedColumnName = "u_id"))
    private Set<User> users = new HashSet<User>();

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
