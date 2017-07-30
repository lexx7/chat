package com.lexx7.chat.model.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_account")
public class User {

    public User() {
        super();
    }

    public User(Long id) {
        super();
        this.id = id;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "edit_time")
    private Date editTime;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @Column
    private String color;

    @Column
    private boolean active = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        // FindBug: EI_EXPOSE_REP2
        // java.util.Date is mutable object
        return new Date(createTime.getTime());
    }

    public void setCreateTime(Date createTime) {
        // FindBug: EI_EXPOSE_REP2
        // java.util.Date is mutable object
        this.createTime = new Date(createTime.getTime());
    }

    public Date getEditTime() {
        // FindBug: EI_EXPOSE_REP2
        // java.util.Date is mutable object
        return new Date(editTime.getTime());
    }

    public void setEditTime(Date editTime) {
        // FindBug: EI_EXPOSE_REP2
        // java.util.Date is mutable object
        this.editTime = new Date(editTime.getTime());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
