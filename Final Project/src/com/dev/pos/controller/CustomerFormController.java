package com.dev.pos.controller;

import com.dev.pos.dao.DatabaseAccessCode;
import com.dev.pos.dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerFormController {
    public AnchorPane context;
    public TextField txtEmail;
    public TextField txtName;
    public TextField txtContact;
    public TextField txtSalary;
    public Button btnSave;
    public TextField txtSearch;
    public TableView tblCustomer;
    public TableColumn colNo;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colContact;
    public TableColumn colSalary;
    public TableColumn colDelete;

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
            if (customer.getEmail().equalsIgnoreCase(txtEmail.getText())) {
                new Alert(Alert.AlertType.WARNING, "Customer is already saved.!").show();
            } else {
                boolean isSaved = DatabaseAccessCode.createCustomer(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.INFORMATION, "Customer has been saved.!").show();
                    clearFields();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Customer could not be saved.!").show();

                }
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

}
