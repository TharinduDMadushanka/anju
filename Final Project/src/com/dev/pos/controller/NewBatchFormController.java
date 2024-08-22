package com.dev.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class NewBatchFormController {

    @FXML
    private Button btnSave;

    @FXML
    private AnchorPane context;

    @FXML
    private ToggleGroup discount;

    @FXML
    private ImageView imgQR;

    @FXML
    private RadioButton rdNo;

    @FXML
    private RadioButton rdYes;

    @FXML
    private TextField txtBuyingPrice;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtProductCode;

    @FXML
    private TextField txtQTy;

    @FXML
    private TextField txtSellingPrice;

    @FXML
    private TextField txtShowPrice;

    public void initialize() {
        setQRcode();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    private void setQRcode() {

    }

}
