package com.cardsys.model;

import java.util.Date;

public class Change {
    private Integer id;

    private String oldcardno;

    private String newcardno;

    private Integer userid;

    private String username;

    private Date operatedate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOldcardno() {
        return oldcardno;
    }

    public void setOldcardno(String oldcardno) {
        this.oldcardno = oldcardno == null ? null : oldcardno.trim();
    }

    public String getNewcardno() {
        return newcardno;
    }

    public void setNewcardno(String newcardno) {
        this.newcardno = newcardno == null ? null : newcardno.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getOperatedate() {
        return operatedate;
    }

    public void setOperatedate(Date operatedate) {
        this.operatedate = operatedate;
    }
}