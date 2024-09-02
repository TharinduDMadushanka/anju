package com.dev.pos.controller;

import com.dev.pos.Enum.BoType;
import com.dev.pos.bo.BoFactory;
import com.dev.pos.bo.custom.BatchBo;
import com.dev.pos.bo.custom.CustomerBo;
import com.dev.pos.dto.CustomerDTO;
import com.dev.pos.dto.ProductDetailJoinDTO;
import com.dev.pos.dto.TM.CartTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

public class PlaceOrderFormController {


    @FXML
    private TableView<CartTm> tblOrder;

    @FXML
    private TableColumn<CartTm, String> colBarcode;

    @FXML
    private TableColumn<CartTm, Button> colDelete;

    @FXML
    private TableColumn<CartTm, Double> colDescription;

    @FXML
    private TableColumn<CartTm, Double> colDiscount;

    @FXML
    private TableColumn<CartTm, Integer> colQty;

    @FXML
    private TableColumn<CartTm, Double> colSellingPrice;

    @FXML
    private TableColumn<CartTm, Double> colShowPrice;

    @FXML
    private TableColumn<CartTm, Double> colTotal;

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


    CustomerBo customerBo = BoFactory.getInstance().getBo(BoType.CUSTOMER);
    BatchBo batchBo = BoFactory.getInstance().getBo(BoType.BATCH);

    public void initialize() {

        colBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colSellingPrice.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        colShowPrice.setCellValueFactory(new PropertyValueFactory<>("showPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("button"));

    }


    @FXML
    void btnAddNewCustomer(ActionEvent event) throws IOException {
        setUI("CustomerForm", true);
    }

    @FXML
    void btnAddNewProduct(ActionEvent event) throws IOException {
        setUI("ProductMainForm", true);
    }

    @FXML
    void btnBacktoHome(ActionEvent event) throws IOException {
        setUI("DashboardForm", false);
    }

    @FXML
    void btnCompleteOrder(ActionEvent event) {

    }

    private void setUI(String location, boolean state) throws IOException {

        Stage stage = null;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml")));

        if (state) {
            stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        } else {
            stage = (Stage) context.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        }

    }

    public void searchCustomerOnAction(ActionEvent actionEvent) {

        try {

            CustomerDTO dto = customerBo.findCustomer(txtEmail.getText().trim());

            if (dto != null) {
                txtName.setText(dto.getName());
                txtContact.setText(dto.getContact());
                txtSalery.setText(String.valueOf(dto.getSalary()));
                fetchLoyaltyCardData(txtEmail.getText().trim());
                txtBarcode.requestFocus();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Customer Not Found..!").show();
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void fetchLoyaltyCardData(String email) {
        hyperLoyaltyDetails.setVisible(true);
        hyperLoyaltyDetails.setText("+ New Loyalty Details");
    }

    public void loadProductOnAction(ActionEvent actionEvent) {

        try {

            ProductDetailJoinDTO joinDto = batchBo.findProductJoinDetail(txtBarcode.getText().trim());

            if (joinDto != null) {
                txtDescription.setText(joinDto.getDescription());
                txtDiscount.setText(String.valueOf(0));
                txtSellingPrice.setText(String.valueOf(joinDto.getBatchDTO().getSellingPrice()));
                txtShowPrice.setText(String.valueOf(joinDto.getBatchDTO().getShowPrice()));
                txtBuyingPrice.setText(String.valueOf(joinDto.getBatchDTO().getBuyingPrice()));
                txtQtyOnHand.setText(String.valueOf(joinDto.getBatchDTO().getQtyOnHand()));
                txtQty.requestFocus();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Product Not Found..!").show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    ObservableList<CartTm> obbList = FXCollections.observableArrayList();

    public void addToCartOnAction(ActionEvent actionEvent) {

        int qty = Integer.parseInt(txtQty.getText());
        double sellingPrice = Double.parseDouble(txtSellingPrice.getText());
        double total = qty * sellingPrice;


        CartTm selectedItem = isExist(txtBarcode.getText().trim());

        if (selectedItem == null) {
            Button button = new Button("Remove");

            if (Integer.parseInt(txtQtyOnHand.getText()) > qty) {


                CartTm tm = new CartTm(
                        txtBarcode.getText(),
                        txtDescription.getText(),
                        sellingPrice,
                        Double.parseDouble(txtDiscount.getText()),
                        Double.parseDouble(txtShowPrice.getText()),
                        qty,
                        total,
                        button
                );

                obbList.add(tm);
                tblOrder.setItems(obbList);
                clearFields();
                txtBarcode.requestFocus();
                setTotal();

                button.setOnAction(event -> {
                    obbList.remove(tm);
                    tblOrder.refresh();
                    setTotal();
                });

            } else {
                new Alert(Alert.AlertType.WARNING, "Quantity Exceeded..!").show();
            }
        } else {
            selectedItem.setQty(qty + selectedItem.getQty());
            selectedItem.setTotal(total + selectedItem.getTotal());
            tblOrder.refresh();
            clearFields();
            txtBarcode.requestFocus();
            setTotal();
        }


    }

    private CartTm isExist(String code) {

        for (CartTm tm : obbList) {
            if (tm.getBarcode().equals(code)) {
                return tm;
            }
        }
        return null;
    }

    private void clearFields() {
        txtBarcode.clear();
        txtDescription.clear();
        txtDiscount.clear();
        txtSellingPrice.clear();
        txtShowPrice.clear();
        txtBuyingPrice.clear();
        txtQtyOnHand.clear();
        txtQty.clear();
    }

    private void setTotal() {

        double total = 0;
        for (CartTm tm : obbList) {
            total += tm.getTotal();
        }
        lblTotal.setText(String.valueOf(total+" /="));
    }

}
