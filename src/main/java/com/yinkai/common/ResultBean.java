package com.yinkai.common;

import java.io.Serializable;

public class ResultBean implements Serializable {

    private Integer state;
    private String message;
    private Object object;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }


}
