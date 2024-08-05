package com.dev.pos.controller;

import com.dev.pos.db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupFormController {
    public AnchorPane context;
    public TextField txtEmail;
    public PasswordField txtPassword;

    public void btnRegisterOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try{
            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO user VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, txtEmail.getText());
            preparedStatement.setString(2, txtPassword.getText());

            int count = preparedStatement.executeUpdate();
            if(count>0){
                new Alert(Alert.AlertType.INFORMATION,"User has been saved.!").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Something went wrong.!").show();
            }

        }catch (SQLException | ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage().toString()).show();
        }

    }

    public void btnAlreadyHaveOnAction(ActionEvent actionEvent) throws IOException {
        setUI("LoginForm");
    }

    private void setUI(String location) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.show();
        stage.centerOnScreen();
    }
}
