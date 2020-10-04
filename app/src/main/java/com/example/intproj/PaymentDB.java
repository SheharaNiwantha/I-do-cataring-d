package com.example.intproj;

public class PaymentDB {
    private String cNumber;
    private String cvv;
    private String pNumber;

    //Constructors, Getters and Setters
    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public PaymentDB() {
    }
}
