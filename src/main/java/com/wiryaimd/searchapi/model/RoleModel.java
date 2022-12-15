package com.wiryaimd.searchapi.model;

import jakarta.persistence.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Entity
@Table(name = "tb_roles")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private SimpleGrantedAuthority role;

    @ManyToMany(mappedBy = "roleList")
    private List<UserModel> userList;

    public RoleModel() {
    }

    public RoleModel(SimpleGrantedAuthority role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public SimpleGrantedAuthority getRole() {
        return role;
    }

    public List<UserModel> getUserList() {
        return userList;
    }
}
