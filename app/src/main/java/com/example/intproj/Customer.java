package com.example.intproj;

public class Customer {
    private String Fname;
    private String Lname;
    private String Email;
    private String Password;
    private String Cpassword;

    public Customer() {
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getCpassword() {
        return Cpassword;
    }

    public void setCpassword(String cpassword) {
        Cpassword = cpassword;
    }
}
