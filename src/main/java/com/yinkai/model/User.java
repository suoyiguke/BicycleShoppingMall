package com.yinkai.model;

import java.io.Serializable;

public class User  implements Serializable{

    private Integer user_id;
    private Integer schoolId;
    private  String openId;

    private String nickname;

    private String sex;

    private String autograph;

    private Integer headimageId;

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph == null ? null : autograph.trim();
    }

    public Integer getHeadimageId() {
        return headimageId;
    }

    public void setHeadimageId(Integer headimageId) {
        this.headimageId = headimageId;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getOpenId() {
        return openId;
    }

    public User(Integer user_id, String openId,Integer schoolId,  String nickname, String sex, String autograph, Integer headimageId) {
        this.user_id = user_id;
        this.schoolId = schoolId;
        this.openId = openId;
        this.nickname = nickname;
        this.sex = sex;
        this.autograph = autograph;
        this.headimageId = headimageId;
    }
    public User(){};


    public void setOpenId(String openId) {
        this.openId = openId;
    }
}