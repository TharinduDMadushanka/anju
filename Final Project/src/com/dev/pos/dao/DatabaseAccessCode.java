package com.dev.pos.dao;

import com.dev.pos.db.DBConnection;
import com.dev.pos.dto.CustomerDTO;
import com.dev.pos.dto.ProductDto;
import com.dev.pos.dto.UserDTO;
import com.dev.pos.util.security.PasswordManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccessCode {

    //-------------- User start---------

    public static boolean createUser(UserDTO userDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO user VALUES(?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, userDTO.getEmail());
        preparedStatement.setString(2, PasswordManager.encrypt(userDTO.getPassword()));

        return preparedStatement.executeUpdate() > 0;
    }

    public static UserDTO findUser(String email) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user WHERE email = ?";

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

    public static boolean createCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO customer VALUES(?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customerDTO.getEmail());
        preparedStatement.setString(2, customerDTO.getName());
        preparedStatement.setString(3, customerDTO.getContact());
        preparedStatement.setDouble(4, customerDTO.getSalary());

        return preparedStatement.executeUpdate() > 0;
    }

    public static boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE customer SET name = ?, contact = ?, salary = ? WHERE email = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customerDTO.getName());
        preparedStatement.setString(2, customerDTO.getContact());
        preparedStatement.setDouble(3, customerDTO.getSalary());
        preparedStatement.setString(4, customerDTO.getEmail());

        return preparedStatement.executeUpdate() > 0;
    }

    public static boolean deleteCustomer(String email) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM customer WHERE email = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);

        return preparedStatement.executeUpdate() > 0;
    }

    public static CustomerDTO findCustomer(String email) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer WHERE email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return new CustomerDTO(
                    resultSet.getString("email"),
                    resultSet.getString("name"),
                    resultSet.getString("contact"),
                    resultSet.getDouble("salary")
            );
        }
        return null;
    }

    public static List<CustomerDTO> findAllCustomer() throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<CustomerDTO> customerDTOList = new ArrayList<>();

        while (resultSet.next()) {
            customerDTOList.add(
                    new CustomerDTO(
                            resultSet.getString("email"),
                            resultSet.getString("name"),
                            resultSet.getString("contact"),
                            resultSet.getDouble("salary")
                    ));
        }
        return customerDTOList;
    }

    public static List<CustomerDTO> searchCustomer(String searchText) throws SQLException, ClassNotFoundException {

        searchText = "%" + searchText + "%";

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer WHERE email LIKE ? || name LIKE ? || contact LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, searchText);
        preparedStatement.setString(2, searchText);
        preparedStatement.setString(3, searchText);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        while (resultSet.next()) {
            customerDTOList.add(new CustomerDTO(
                    resultSet.getString("email"),
                    resultSet.getString("name"),
                    resultSet.getString("contact"),
                    resultSet.getDouble("salary")

            ));
        }
        return customerDTOList;
    }

    //-------------- Customer end---------

    //-------------- Product Start---------

    public static int getLastProductId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT code FROM  product ORDER BY code DESC LIMIT 1";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("code") + 1;
        }
        return 1;
    }

    public static boolean saveProduct(ProductDto productDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO product VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, productDto.getCode());
        preparedStatement.setString(2, productDto.getDescription());

        return preparedStatement.executeUpdate() > 0;
    }

    public static boolean updateProduct(ProductDto productDto) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE  product SET description = ? WHERE code = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, productDto.getDescription());
        preparedStatement.setInt(2, productDto.getCode());

        return preparedStatement.executeUpdate() > 0;
    }

    public static boolean deleteProduct(int code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM product WHERE code =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, code);

        return preparedStatement.executeUpdate() > 0;
    }

    public static ProductDto findProduct(int code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM product WHERE code = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, code);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new ProductDto(
                    resultSet.getInt("code"),
                    resultSet.getString("description")
            );
        }
        return null;
    }

    public static List<ProductDto> findAllProduct() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM product";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<ProductDto> productDTOList = new ArrayList<>();
        while (resultSet.next()) {
            productDTOList.add(new ProductDto(
                    resultSet.getInt("code"),
                    resultSet.getString("description")
            ));
        }
        return productDTOList;
    }

    public static List<ProductDto> searchProduct(String searchText) throws SQLException, ClassNotFoundException {
        searchText = "%" + searchText + "%";

        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM product WHERE description LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, searchText);

        ResultSet resultSet = preparedStatement.executeQuery();
        List<ProductDto> productDtoList = new ArrayList<>();
        while (resultSet.next()) {
            productDtoList.add(new ProductDto(
                    resultSet.getInt(1),
                    resultSet.getString(2)
            ));
        }
        return productDtoList;

    }

    //-------------- Product  end---------
}
