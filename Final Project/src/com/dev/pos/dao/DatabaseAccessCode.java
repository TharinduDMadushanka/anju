package com.dev.pos.dao;

import com.dev.pos.db.DBConnection;
import com.dev.pos.dto.UserDTO;
import com.dev.pos.util.security.PasswordManager;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAccessCode {

    //-------------- User start---------

    public static boolean createUser(UserDTO userDTO) throws SQLException, ClassNotFoundException {

            Connection connection = DBConnection.getInstance().getConnection();
            String sql = "INSERT INTO user VALUES(?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userDTO.getEmail());
            preparedStatement.setString(2, PasswordManager.encrypt(userDTO.getPassword()));

            return preparedStatement.executeUpdate()>0;
    }

    public static UserDTO findUser(String email) throws SQLException, ClassNotFoundException {

            Connection connection = DBConnection.getInstance().getConnection();
            String sql= "SELECT * FROM user WHERE email = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new UserDTO(
                        resultSet.getString(1),
                        resultSet.getString(2)
                );
            }
            return null;
    }

    //-------------- User end---------

    //-------------- Customer start---------
}
