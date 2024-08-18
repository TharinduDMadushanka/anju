package com.dev.pos.dao;

import com.dev.pos.Enum.DaoType;
import com.dev.pos.dao.custom.CustomerDao;
import com.dev.pos.dao.custom.ProductDao;
import com.dev.pos.dao.custom.UserDao;
import com.dev.pos.dao.impl.CustomerDaoImpl;
import com.dev.pos.dao.impl.ProductDaoImpl;
import com.dev.pos.dao.impl.UserDaoImpl;
import com.dev.pos.db.DBConnection;
import com.dev.pos.dto.CustomerDTO;
import com.dev.pos.dto.ProductDto;
import com.dev.pos.dto.UserDTO;
import com.dev.pos.entity.Customer;
import com.dev.pos.entity.Product;
import com.dev.pos.entity.User;
import com.dev.pos.util.security.PasswordManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccessCode {
/**
    CustomerDao customerDao = new CustomerDaoImpl();
    UserDao userDao = new UserDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
*/

    CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoType.CUSTOMER);
    ProductDao productDao = (ProductDao) DaoFactory.getInstance().getDao(DaoType.PRODUCT);
    UserDao userDao = (UserDao) DaoFactory.getInstance().getDao(DaoType.USER);

    //-------------- User start---------

    public boolean createUser(UserDTO userDTO) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "INSERT INTO user VALUES(?,?)";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, userDTO.getEmail());
//        preparedStatement.setString(2, PasswordManager.encrypt(userDTO.getPassword()));
//
//        return preparedStatement.executeUpdate() > 0;
        return userDao.save(new User(
                userDTO.getEmail(),
                userDTO.getPassword()
        ));
    }

    public UserDTO findUser(String email) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM user WHERE email = ?";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, email);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        if (resultSet.next()) {
//            return new UserDTO(
//                    resultSet.getString(1),
//                    resultSet.getString(2)
//            );
//        }
//        return null;
        User user = userDao.find(email);
        if (user != null) {
            return new UserDTO(
                    user.getEmail(),
                    user.getPassword()
            );
        }
        return null;
    }

    //-------------- User end---------

    //-------------- Customer start---------

    public boolean createCustomer(CustomerDTO customerDTO) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "INSERT INTO customer VALUES(?,?,?,?)";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, customerDTO.getEmail());
//        preparedStatement.setString(2, customerDTO.getName());
//        preparedStatement.setString(3, customerDTO.getContact());
//        preparedStatement.setDouble(4, customerDTO.getSalary());
//
//        return preparedStatement.executeUpdate() > 0;
        return customerDao.save(new Customer(
                customerDTO.getEmail(),
                customerDTO.getName(),
                customerDTO.getContact(),
                customerDTO.getSalary()
        ));
    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "UPDATE customer SET name = ?, contact = ?, salary = ? WHERE email = ?";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, customerDTO.getName());
//        preparedStatement.setString(2, customerDTO.getContact());
//        preparedStatement.setDouble(3, customerDTO.getSalary());
//        preparedStatement.setString(4, customerDTO.getEmail());
//
//        return preparedStatement.executeUpdate() > 0;
        return customerDao.update(new Customer(
                customerDTO.getEmail(),
                customerDTO.getName(),
                customerDTO.getContact(),
                customerDTO.getSalary()
        ));
    }

    public boolean deleteCustomer(String email) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "DELETE FROM customer WHERE email = ?";
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, email);
//
//        return preparedStatement.executeUpdate() > 0;
        return customerDao.delete(email);
    }

    public CustomerDTO findCustomer(String email) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM customer WHERE email = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, email);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        if (resultSet.next()) {
//            return new CustomerDTO(
//                    resultSet.getString("email"),
//                    resultSet.getString("name"),
//                    resultSet.getString("contact"),
//                    resultSet.getDouble("salary")
//            );
//        }
//        return null;
        Customer customer = customerDao.find(email);
        if (customer != null) {
            return new CustomerDTO(
                    customer.getEmail(),
                    customer.getName(),
                    customer.getContact(),
                    customer.getSalary()
            );
        }
        return null;
    }

    public List<CustomerDTO> findAllCustomer() throws Exception {

//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM customer";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        List<CustomerDTO> customerDTOList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            customerDTOList.add(
//                    new CustomerDTO(
//                            resultSet.getString("email"),
//                            resultSet.getString("name"),
//                            resultSet.getString("contact"),
//                            resultSet.getDouble("salary")
//                    ));
//        }
//        return customerDTOList;
        List<Customer> allCustomers = customerDao.findAll();
        List<CustomerDTO> customerDTOs = new ArrayList<>();
        for (Customer c : allCustomers) {
            customerDTOs.add(new CustomerDTO(
                    c.getEmail(),
                    c.getName(),
                    c.getContact(),
                    c.getSalary()
            ));
        }
        return customerDTOs;
    }

    public List<CustomerDTO> searchCustomer(String searchText) throws Exception {

//        searchText = "%" + searchText + "%";
//
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM customer WHERE email LIKE ? || name LIKE ? || contact LIKE ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, searchText);
//        preparedStatement.setString(2, searchText);
//        preparedStatement.setString(3, searchText);
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        List<CustomerDTO> customerDTOList = new ArrayList<>();
//        while (resultSet.next()) {
//            customerDTOList.add(new CustomerDTO(
//                    resultSet.getString("email"),
//                    resultSet.getString("name"),
//                    resultSet.getString("contact"),
//                    resultSet.getDouble("salary")
//
//            ));
//        }
//        return customerDTOList;

        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer c : customerDao.search(searchText)) {
            customerDTOList.add(new CustomerDTO(
                    c.getEmail(),
                    c.getName(),
                    c.getContact(),
                    c.getSalary()
            ));
        }
        return customerDTOList;
    }

    //-------------- Customer end---------

    //-------------- Product Start---------

    public int getLastProductId() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "SELECT code FROM  product ORDER BY code DESC LIMIT 1";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        if (resultSet.next()) {
//            return resultSet.getInt("code") + 1;
//        }
//        return 1;
        return productDao.getLastProductId();
    }

    public boolean saveProduct(ProductDto productDto) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "INSERT INTO product VALUES(?,?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, productDto.getCode());
//        preparedStatement.setString(2, productDto.getDescription());
//
//        return preparedStatement.executeUpdate() > 0;
        return productDao.save(new Product(
                productDto.getCode(),
                productDto.getDescription()
        ));
    }

    public boolean updateProduct(ProductDto productDto) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "UPDATE  product SET description = ? WHERE code = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, productDto.getDescription());
//        preparedStatement.setInt(2, productDto.getCode());
//
//        return preparedStatement.executeUpdate() > 0;
        return productDao.update(new Product(
                productDto.getCode(),
                productDto.getDescription()
        ));
    }

    public boolean deleteProduct(int code) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "DELETE FROM product WHERE code =?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, code);
//
//        return preparedStatement.executeUpdate() > 0;
        return productDao.delete(code);
    }

    public ProductDto findProduct(int code) throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM product WHERE code = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, code);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        if (resultSet.next()) {
//            return new ProductDto(
//                    resultSet.getInt("code"),
//                    resultSet.getString("description")
//            );
//        }
//        return null;
        Product product = productDao.find(code);
        if (product != null) {
            return new ProductDto(
                    product.getCode(),
                    product.getDescription()
            );
        }
        return null;
    }

    public List<ProductDto> findAllProduct() throws Exception {
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM product";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        List<ProductDto> productDTOList = new ArrayList<>();
//        while (resultSet.next()) {
//            productDTOList.add(new ProductDto(
//                    resultSet.getInt("code"),
//                    resultSet.getString("description")
//            ));
//        }
//        return productDTOList;
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product p : productDao.findAll()) {
            productDtoList.add(new ProductDto(
                    p.getCode(),
                    p.getDescription()
            ));
        }
        return productDtoList;
    }

    public List<ProductDto> searchProduct(String searchText) throws SQLException, ClassNotFoundException {
//        searchText = "%" + searchText + "%";
//
//        Connection connection = DBConnection.getInstance().getConnection();
//        String sql = "SELECT * FROM product WHERE description LIKE ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//        preparedStatement.setString(1, searchText);
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//        List<ProductDto> productDtoList = new ArrayList<>();
//
//        while (resultSet.next()) {
//            productDtoList.add(new ProductDto(
//                    resultSet.getInt(1),
//                    resultSet.getString(2)
//            ));
//        }
//        return productDtoList;
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product p : productDao.searchByDescription(searchText)) {
            productDtoList.add(new ProductDto(
                    p.getCode(),
                    p.getDescription()
            ));
        }
        return productDtoList;
    }

    //-------------- Product  end---------
}
