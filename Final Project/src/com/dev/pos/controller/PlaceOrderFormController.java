package com.dev.pos.controller;

import com.dev.pos.Enum.BoType;
import com.dev.pos.bo.BoFactory;
import com.dev.pos.bo.custom.BatchBo;
import com.dev.pos.bo.custom.CustomerBo;
import com.dev.pos.dto.CustomerDTO;
import com.dev.pos.dto.ProductDetailJoinDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

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


    CustomerBo customerBo = BoFactory.getInstance().getBo(BoType.CUSTOMER);
    BatchBo batchBo = BoFactory.getInstance().getBo(BoType.BATCH);


    @FXML
    void btnAddNewCustomer(ActionEvent event) throws IOException {
        setUI("CustomerForm",true);
    }

    @FXML
    void btnAddNewProduct(ActionEvent event) throws IOException {
        setUI("ProductMainForm",true);
    }

    @FXML
    void btnBacktoHome(ActionEvent event) throws IOException {
        setUI("DashboardForm",false);
    }

    @FXML
    void btnCompleteOrder(ActionEvent event) {

    }

    private void setUI(String location, boolean state) throws IOException {

        Stage stage = null;
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml")));

        if (state){
            stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        }else {
            stage = (Stage) context.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
        }

    }

    public void searchCustomerOnAction(ActionEvent actionEvent) {

        try {

            CustomerDTO dto = customerBo.findCustomer(txtEmail.getText().trim());

            if (dto !=null){
                txtName.setText(dto.getName());
                txtContact.setText(dto.getContact());
                txtSalery.setText(String.valueOf(dto.getSalary()));
                fetchLoyaltyCardData(txtEmail.getText().trim());
                txtBarcode.requestFocus();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Customer Not Found..!").show();
            }

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void fetchLoyaltyCardData(String email){
        hyperLoyaltyDetails.setVisible(true);
        hyperLoyaltyDetails.setText("+ New Loyalty Details");
    }

    public void loadProductOnAction(ActionEvent actionEvent) {

        try {

            ProductDetailJoinDTO joinDto = batchBo.findProductJoinDetail(txtBarcode.getText().trim());

            if (joinDto != null){
                txtDescription.setText(joinDto.getDescription());
                txtDiscount.setText(String.valueOf(0));
                txtSellingPrice.setText(String.valueOf(joinDto.getBatchDTO().getSellingPrice()));
                txtShowPrice.setText(String.valueOf(joinDto.getBatchDTO().getShowPrice()));
                txtBuyingPrice.setText(String.valueOf(joinDto.getBatchDTO().getBuyingPrice()));
                txtQtyOnHand.setText(String.valueOf(joinDto.getBatchDTO().getQtyOnHand()));
                txtQty.requestFocus();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Product Not Found..!").show();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
