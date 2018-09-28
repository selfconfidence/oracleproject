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
@Table(name = "u_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "u_id")
    private Long uId;
    @Column(name = "u_name",length = 20)
    private String uName;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles = new HashSet<Role>();

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
