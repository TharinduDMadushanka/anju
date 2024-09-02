package com.dev.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class PlaceOrderFormController {


    @FXML
    private TableView<?> tblOrder;

    @FXML
    private TableColumn<?, ?> colBarcode;

    @FXML
    private TableColumn<?, ?> colDelete;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colDiscount;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colSellingPrice;

    @FXML
    private TableColumn<?, ?> colShowPrice;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private AnchorPane context;

    @FXML
    private Hyperlink hyperLoyaltyDetails;

    @FXML
    private Label lblMembership;

    @FXML
    private Label lblTotal;

    @FXML
    private ToggleGroup qrMode;

    @FXML
    private RadioButton rbnAuotoMode;

    @FXML
    private RadioButton rbnManualMode;

    @FXML
    private TextField txtBarcode;

    @FXML
    private TextField txtBuyingPrice;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtDiscount;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtSalery;

    @FXML
    private TextField txtSellingPrice;

    @FXML
    private TextField txtShowPrice;

    @FXML
    void btnAddNewCustomer(ActionEvent event) {

    }

    @FXML
    void btnAddNewProduct(ActionEvent event) {

    }

    @FXML
    void btnBacktoHome(ActionEvent event) {

    }

    @FXML
    void btnCompleteOrder(ActionEvent event) {

    }

}
