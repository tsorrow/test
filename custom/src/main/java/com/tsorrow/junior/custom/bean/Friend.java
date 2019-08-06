package com.tsorrow.junior.custom.bean;

public class Friend {
    public String phone;
    public String relation;
    public String value;
    public boolean admit_circle;

    public Friend() {
        phone = "";
        relation = "";
        value = "";
        admit_circle = true;
    }

    public Friend(String phone) {
        this.phone = phone;
        this.relation = "其他";
        this.value = "";
        this.admit_circle = true;
    }
}
