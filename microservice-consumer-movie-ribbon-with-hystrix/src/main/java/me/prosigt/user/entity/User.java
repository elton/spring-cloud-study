package me.prosigt.user.entity;

/**
 * Created by elton on 2017/2/6.
 * 用户实体类
 */

public class User {
    private Long id;
    private String username;
    private Integer age;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}