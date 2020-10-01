package com.example.intproj;

public class OrderDB {
    private String name;
    private String email;
    private Integer cno;
    private String address;
    private Integer menuNo;
    private Integer numOfPlates;
    private String date;
    private String time;

    public OrderDB() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(Integer menuNo) {
        this.menuNo = menuNo;
    }

    public Integer getNumOfPlates() {
        return numOfPlates;
    }

    public void setNumOfPlates(Integer numOfPlates) {
        this.numOfPlates = numOfPlates;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}