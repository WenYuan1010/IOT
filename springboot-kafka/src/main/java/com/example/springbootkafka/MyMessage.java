package com.example.springbootkafka;

import java.util.Date;

public class MyMessage {
    private long id;
    private String msg;
    private Date sendTime;

    public void setId(long id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
