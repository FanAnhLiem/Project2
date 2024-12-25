package com._tech.project_1_28tech.repository.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;

//    @OneToMany(mappedBy = "user" , fetch = FetchType.LAZY)
//    private List<UserRoleEntity> userRole = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY) //lấy ít thì EAGER(manytoone và onetoone) còn lấy nhiều LAZY(manytomany và manytoone)
    @JoinTable( name = "user_role",  //tạo một bảng kết nối giữa user vs role
                joinColumns = @JoinColumn(name = "userid", nullable = false), // khóa ngoại đầu tiên tham chiếu đến bảng user
                inverseJoinColumns = @JoinColumn(name = "roleid" , nullable = false)) //khóa ngoai thứ hai tham chiêu đến bảng role
    private List<RoleEntity> roles = new ArrayList<>();

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
