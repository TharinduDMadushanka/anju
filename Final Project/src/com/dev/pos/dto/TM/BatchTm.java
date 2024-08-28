package com.dev.pos.dto.TM;

import javafx.scene.control.Button;

public class BatchTm {

    private String code;
    private int qty;
    private double byingPrice;
    private boolean discount;
    private double showPrice;
    private double sellingPrice;
    private Button button;

    public BatchTm() {
    }

    public BatchTm(String code, int qty, double byingPrice, boolean discount, double showPrice, double sellingPrice, Button button) {
        this.code = code;
        this.qty = qty;
        this.byingPrice = byingPrice;
        this.discount = discount;
        this.showPrice = showPrice;
        this.sellingPrice = sellingPrice;
        this.button = button;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getByingPrice() {
        return byingPrice;
    }

    public void setByingPrice(double byingPrice) {
        this.byingPrice = byingPrice;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public double getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(double showPrice) {
        this.showPrice = showPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
