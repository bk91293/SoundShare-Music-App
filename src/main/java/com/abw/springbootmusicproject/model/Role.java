package com.abw.springbootmusicproject.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
@Table(name="role_table")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue
    @Column(name="role_id")
    private int roleId;
    @Column(name="role_name")
    private String roleName;
    public Role (){

    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return "ROLE_" + roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId == role.roleId && Objects.equals(roleName, role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName);
    }


}
