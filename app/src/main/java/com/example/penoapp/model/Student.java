package com.example.penoapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Student {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("no")
    @Expose
    private Integer no;
    @SerializedName("lecAndStudents")
    @Expose
    private Object lecAndStudents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Object getLecAndStudents() {
        return lecAndStudents;
    }

    public void setLecAndStudents(Object lecAndStudents) {
        this.lecAndStudents = lecAndStudents;
    }

}