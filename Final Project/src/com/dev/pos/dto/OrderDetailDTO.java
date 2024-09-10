package com.dev.pos.dto;

import java.util.Date;
import java.util.List;

public class OrderDetailDTO {

    private int code; // product code
    private Date issueDate;
    private double totalCost;
    private String customerEmail;
    private double discount;
    private String usrEmail;

    private List<ItemDetailDTO> dtoList;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int code, Date issueDate, double totalCost, String customerEmail, double discount, String usrEmail, List<ItemDetailDTO> dtoList) {
        this.code = code;
        this.issueDate = issueDate;
        this.totalCost = totalCost;
        this.customerEmail = customerEmail;
        this.discount = discount;
        this.usrEmail = usrEmail;
        this.dtoList = dtoList;
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

    public List<ItemDetailDTO> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<ItemDetailDTO> dtoList) {
        this.dtoList = dtoList;
    }
}
