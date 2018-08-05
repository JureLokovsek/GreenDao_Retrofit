package com.example.jure_lokovsek.greendao_app.DataBase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User implements Serializable {

    static final long serialVersionUID = 536871008L;

    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private int age;
    @NotNull
    private int power;
    @NotNull
    private int year;

    @Keep
    public User(String name, int age, int power, int year) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.year = year;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    @Generated(hash = 1026721228)
    public User(Long id, @NotNull String name, int age, int power, int year) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.power = power;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
