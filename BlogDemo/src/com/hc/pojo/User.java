package com.hc.pojo;

public class User {
    private int id;
    private String uname;
    private String pwd;
    private String telenum;
    private String sex;
    private String birth;

    public User(int id, String uname, String pwd, String telenum, String sex, String birth) {
        this.id = id;
        this.uname = uname;
        this.pwd = pwd;
        this.telenum = telenum;
        this.sex = sex;
        this.birth = birth;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTelenum() {
        return telenum;
    }

    public void setTelenum(String telenum) {
        this.telenum = telenum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
