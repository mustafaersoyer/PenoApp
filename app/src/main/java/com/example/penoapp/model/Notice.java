package com.example.penoapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Notice {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("acaId")
    @Expose
    private Integer acaId;
    @SerializedName("lecAndStudents")
    @Expose
    private Object lecAndStudents;
    @SerializedName("notices")
    @Expose
    private List<Notice_> notices = null;

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

    public Integer getAcaId() {
        return acaId;
    }

    public void setAcaId(Integer acaId) {
        this.acaId = acaId;
    }

    public Object getLecAndStudents() {
        return lecAndStudents;
    }

    public void setLecAndStudents(Object lecAndStudents) {
        this.lecAndStudents = lecAndStudents;
    }

    public List<Notice_> getNotices() {
        return notices;
    }

    public void setNotices(List<Notice_> notices) {
        this.notices = notices;
    }

}
