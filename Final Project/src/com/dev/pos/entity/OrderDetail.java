package com.dev.pos.entity;

import java.util.Date;

public class OrderDetail implements SuperEntity {

    private int code; // product code
    private Date issueDate;
    private double totalCost;
    private String customerEmail;
    private double discount;
    private String usrEmail;

    public OrderDetail() {
    }

    public OrderDetail(int code, Date issueDate, double totalCost, String customerEmail, double discount, String usrEmail) {
        this.code = code;
        this.issueDate = issueDate;
        this.totalCost = totalCost;
        this.customerEmail = customerEmail;
        this.discount = discount;
        this.usrEmail = usrEmail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }
}
