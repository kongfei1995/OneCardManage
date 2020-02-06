package com.cardsys.model;

import java.util.Date;

public class CardInfo {
    private Integer id;

    private String cardno;

    private String oldcardno;

    private String cardname;

    private String cardpwd;

    private Integer userid;

    private String username;

    private String carprice;

    private String remark;

    private String state;

    private Date addtime;

    private String invalidmsg;

    private Date invalidtime;

    private Date allocatetime;

    private String allocatemsg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getOldcardno() {
        return oldcardno;
    }

    public void setOldcardno(String oldcardno) {
        this.oldcardno = oldcardno == null ? null : oldcardno.trim();
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname == null ? null : cardname.trim();
    }

    public String getCardpwd() {
        return cardpwd;
    }

    public void setCardpwd(String cardpwd) {
        this.cardpwd = cardpwd == null ? null : cardpwd.trim();
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

    public String getCarprice() {
        return carprice;
    }

    public void setCarprice(String carprice) {
        this.carprice = carprice == null ? null : carprice.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getInvalidmsg() {
        return invalidmsg;
    }

    public void setInvalidmsg(String invalidmsg) {
        this.invalidmsg = invalidmsg == null ? null : invalidmsg.trim();
    }

    public Date getInvalidtime() {
        return invalidtime;
    }

    public void setInvalidtime(Date invalidtime) {
        this.invalidtime = invalidtime;
    }

    public Date getAllocatetime() {
        return allocatetime;
    }

    public void setAllocatetime(Date allocatetime) {
        this.allocatetime = allocatetime;
    }

    public String getAllocatemsg() {
        return allocatemsg;
    }

    public void setAllocatemsg(String allocatemsg) {
        this.allocatemsg = allocatemsg == null ? null : allocatemsg.trim();
    }
}