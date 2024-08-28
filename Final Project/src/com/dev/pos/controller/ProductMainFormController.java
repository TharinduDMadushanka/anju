package com.dev.pos.controller;

import com.dev.pos.Enum.BoType;
import com.dev.pos.bo.BoFactory;
import com.dev.pos.bo.custom.BatchBo;
import com.dev.pos.bo.custom.ProductBo;
import com.dev.pos.dao.DatabaseAccessCode;
import com.dev.pos.dto.ProductDto;
import com.dev.pos.dto.TM.ProductTm;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

public class ProductMainFormController {
    public AnchorPane context;
    public TextField txtProductCode;
    public TextField txtProductDescription;
    public Button btnSave;
    public TextField txtSearch;

    public TableView<ProductTm> tblProduct;
    public TableColumn<ProductTm,Integer> colProductId;
    public TableColumn<ProductTm,String> colDescription;
    public TableColumn<ProductTm,Button> colShowMore;
    public TableColumn<ProductTm,Button> colDelete;

    public TextField txtSelectedProductCode;

    public TableView tblProductMain;
    public TableColumn colNo;
    public TableColumn colQty;
    public TableColumn colBuyPrice;
    public TableColumn colDiscount;
    public TableColumn colShowPrice;
    public TableColumn colSellPrice;
    public TableColumn colMainDelete;

    public TextField txtSelectedDescription;
    @FXML
    private Button btnNewBatch;

    ProductBo productBo = BoFactory.getInstance().getBo(BoType.PRODUCT);
    BatchBo batchBo = BoFactory.getInstance().getBo(BoType.BATCH);

    String searchText = "";

    public void initialize() {
        loadProductId();

        colProductId.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colShowMore.setCellValueFactory(new PropertyValueFactory<>("showMoreBtn"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));

        loadAllProduct(searchText);

        tblProduct.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });
    }

    public void btnBacktoHome(ActionEvent actionEvent) throws IOException {
        setUI("DashboardForm");
    }

    public void btnAddNewProductOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        try {

            if(btnSave.getText().equalsIgnoreCase("Save Product")) {
                boolean isSaved = productBo.saveProduct(new ProductDto(
                        Integer.parseInt(txtProductCode.getText()),
                        txtProductDescription.getText()
                ));

                if(isSaved) {
                    new Alert(Alert.AlertType.INFORMATION,"Product saved successfully").show();
                    loadAllProduct(searchText);
                    loadProductId();
                    clear();
                }else {
                    new Alert(Alert.AlertType.ERROR,"Something wrong in save..!").show();
                }
            }else {

                boolean updated = productBo.updateProduct(new ProductDto(
                        Integer.parseInt(txtProductCode.getText()),
                        txtProductDescription.getText()
                ));

                if(updated) {
                    new Alert(Alert.AlertType.INFORMATION,"Product updated successfully").show();
                    loadAllProduct(searchText);
                    loadProductId();
                    clear();
                    btnSave.setText("Save Product");
                }else {
                    new Alert(Alert.AlertType.ERROR,"Something wrong in update..!").show();
                }

            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void btnNewBatchOnAction(ActionEvent actionEvent) throws IOException {


        if (txtSelectedProductCode.getText().trim().length() > 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/NewBatchForm.fxml"));
            Parent parent = fxmlLoader.load();
            NewBatchFormController controller = fxmlLoader.getController();
            Stage stage = new Stage();
            controller.setProductCode(
                    Integer.parseInt(txtSelectedProductCode.getText()),
                    txtSelectedDescription.getText(),
                    stage
            );
//            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();
            stage.centerOnScreen();
        }else {
            new Alert(Alert.AlertType.WARNING,"Please select valid product..!").show();
        }

    }

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.show();
        stage.centerOnScreen();
    }

    private void loadProductId() {

        try {
            txtProductCode.setText(String.valueOf(productBo.getLastProductId()));
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void loadAllProduct(String searchText){

        ObservableList<ProductTm> oblist = FXCollections.observableArrayList();

        try{
            for (ProductDto p : productBo.findAllProduct()){
                Button showMore = new Button("Show More");
                Button delete = new Button("Delete");
                ProductTm productTm = new ProductTm(
                        p.getCode(),
                        p.getDescription(),
                        showMore,
                        delete
                );
                oblist.add(productTm);
            }
            tblProduct.setItems(oblist);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setData(ProductTm newValue) {
        btnNewBatch.setDisable(false);
        btnSave.setText("Update Product");
        txtProductCode.setText(String.valueOf(newValue.getCode()));
        txtSelectedProductCode.setText(String.valueOf(newValue.getCode()));
        txtProductDescription.setText(newValue.getDescription());
        txtSelectedDescription.setText(newValue.getDescription());
    }

    private void clear(){
        txtProductDescription.clear();
        txtSelectedProductCode.clear();
        txtSelectedDescription.clear();
    }

    private void loadBatchData(int code){



    }

}
