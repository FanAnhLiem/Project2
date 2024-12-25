package com._tech.project_1_28tech.repository.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "code" , unique = true ,nullable = false)
    private String code;

    @ManyToMany(mappedBy = "roles" , fetch = FetchType.LAZY)
    private List<UserEntity> users = new ArrayList<>();

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    //    @OneToMany(mappedBy = "role" , fetch = FetchType.LAZY)
//    private List<UserRoleEntity> userRole = new ArrayList<>();
//
//    public List<UserRoleEntity> getUserRole() {
//        return userRole;
//    }
//
//    public void setUserRole(List<UserRoleEntity> userRole) {
//        this.userRole = userRole;
//    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
