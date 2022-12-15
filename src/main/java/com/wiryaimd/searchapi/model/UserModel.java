package com.wiryaimd.searchapi.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Entity
@Table(name = "tb_users")
public class UserModel implements UserDetails {

    private @Id @GeneratedValue(strategy = GenerationType.UUID) UUID id;
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private List<RoleModel> roleList;

    public UserModel() {
    }

    public UserModel(UUID id, String username, String password, List<RoleModel> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleList = roles;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleList.stream().map(new Function<RoleModel, SimpleGrantedAuthority>() {
            @Override
            public SimpleGrantedAuthority apply(RoleModel roleModel) {
                return roleModel.getRole();
            }
        }).toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
