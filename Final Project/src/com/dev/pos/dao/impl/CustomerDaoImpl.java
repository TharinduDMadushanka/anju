package com.dev.pos.dao.impl;

import com.dev.pos.dao.custom.CustomerDao;
import com.dev.pos.db.DBConnection;
import com.dev.pos.dto.CustomerDTO;
import com.dev.pos.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO customer VALUES(?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getEmail());
        preparedStatement.setString(2, customer.getName());
        preparedStatement.setString(3, customer.getContact());
        preparedStatement.setDouble(4, customer.getSalary());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE customer SET name = ?, contact = ?, salary = ? WHERE email = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getContact());
        preparedStatement.setDouble(3, customer.getSalary());
        preparedStatement.setString(4, customer.getEmail());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String email) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM customer WHERE email = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public Customer find(String email) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer WHERE email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return new Customer(
                    resultSet.getString("email"),
                    resultSet.getString("name"),
                    resultSet.getString("contact"),
                    resultSet.getDouble("salary")
            );
        }
        return null;
    }

    @Override
    public List<Customer> findAll() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Customer> customerList = new ArrayList<>();

        while (resultSet.next()) {
            customerList.add(
                    new Customer(
                            resultSet.getString("email"),
                            resultSet.getString("name"),
                            resultSet.getString("contact"),
                            resultSet.getDouble("salary")
                    ));
        }
        return customerList;
    }

    @Override
    public List<Customer> search(String value) throws SQLException, ClassNotFoundException {
        value = "%" + value + "%";

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer WHERE email LIKE ? || name LIKE ? || contact LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, value);
        preparedStatement.setString(2, value);
        preparedStatement.setString(3, value);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<Customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
            customerList.add(new Customer(
                    resultSet.getString("email"),
                    resultSet.getString("name"),
                    resultSet.getString("contact"),
                    resultSet.getDouble("salary")

            ));
        }
        return customerList;
    }
}
