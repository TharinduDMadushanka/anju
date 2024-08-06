package com.dev.pos.controller;

import com.dev.pos.dao.DatabaseAccessCode;
import com.dev.pos.dto.CustomerDTO;
import com.dev.pos.dto.TM.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class CustomerFormController {
    public AnchorPane context;
    public TextField txtEmail;
    public TextField txtName;
    public TextField txtContact;
    public TextField txtSalary;
    public Button btnSave;
    public TextField txtSearch;
    public TableView<CustomerTm> tblCustomer;
    public TableColumn<CustomerTm,Integer> colNo;
    public TableColumn<CustomerTm,String> colName;
    public TableColumn<CustomerTm,String>  colEmail;
    public TableColumn<CustomerTm,String>  colContact;
    public TableColumn<CustomerTm,Double>  colSalary;
    public TableColumn<CustomerTm,Button>  colDelete;


    String searchText="";

    public void initialize() {

        colNo.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("button"));

        loadCustomer(searchText);

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchText = newValue;
            loadCustomer(searchText);

        });

        // Listen for table

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });

    }


    public void btnBacktoHome(ActionEvent actionEvent) throws IOException {
        setUI("DashboardForm");
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        CustomerDTO dto = new CustomerDTO(
                txtEmail.getText(),
                txtName.getText(),
                txtContact.getText(),
                Double.parseDouble(txtSalary.getText())
        );

        if (btnSave.getText().equalsIgnoreCase("Save Customer")) {
            CustomerDTO customer = DatabaseAccessCode.findCustomer(txtEmail.getText());

            if (customer != null) {
                new Alert(Alert.AlertType.WARNING, "Customer is already saved!").show();
            } else {
                boolean isSaved = DatabaseAccessCode.createCustomer(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.INFORMATION, "Customer has been saved!").show();
                    clearFields();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Customer could not be saved!").show();
                }
            }
        }else {
            boolean isUpdated = DatabaseAccessCode.updateCustomer(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.INFORMATION, "Customer has been updated!").show();
                txtEmail.setEditable(true);
                btnSave.setText("Save Customer");
                clearFields();
                loadCustomer(searchText);
            }
        }
    }

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/" + location + ".fxml"))));
        stage.show();
        stage.centerOnScreen();
    }

    private void clearFields() {
        txtEmail.clear();
        txtName.clear();
        txtContact.clear();
        txtSalary.clear();
    }

    private void loadCustomer(String searchText) {
        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

        try {
            int counter=1;
            for (CustomerDTO dto : DatabaseAccessCode.searchCustomer(searchText)) {
                Button button = new Button("Delete");
                CustomerTm customerTm = new CustomerTm(
                        counter,
                        dto.getEmail(),
                        dto.getName(),
                        dto.getContact(),
                        dto.getSalary(),
                        button
                );
                counter++;
                obList.add(customerTm);

                //Customer Delete
                button.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are you sure..!", ButtonType.NO,ButtonType.YES);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {
                        try {
                            boolean isDeleted = DatabaseAccessCode.deleteCustomer(dto.getEmail());
                            if (isDeleted) {
                                new Alert(Alert.AlertType.INFORMATION, "Customer has been deleted!").show();
                                loadCustomer(searchText);
                                clearFields();
                                btnSave.setText("Save Customer");
                            }else {
                                new Alert(Alert.AlertType.ERROR, "Customer could not be deleted!").show();
                            }
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });

            }

            tblCustomer.setItems(obList);

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    private void setData(CustomerTm newValue) {
        txtEmail.setEditable(false);
        btnSave.setText("Update Customer");

        txtName.setText(newValue.getName());
        txtContact.setText(newValue.getContact());
        txtSalary.setText(String.valueOf(newValue.getSalary()));
        txtEmail.setText(newValue.getEmail());
    }

}
