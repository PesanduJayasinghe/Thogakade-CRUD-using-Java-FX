package Controller;

import Model.DTO.CustomerInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class CustomerController {

    public void addCustomerDetails(String custId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode){
        try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234");
        PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)");

        preparedStatement.setObject(1,custId);
        preparedStatement.setObject(2,title);
        preparedStatement.setObject(3,name);
        preparedStatement.setObject(4,dob);
        preparedStatement.setObject(5,salary);
        preparedStatement.setObject(6,address);
        preparedStatement.setObject(7,city);
        preparedStatement.setObject(8,province);
        preparedStatement.setObject(9,postalCode);

        preparedStatement.execute();


    } catch (
    SQLException e) {
        throw new RuntimeException(e);
    }

    }

    public void deleteCustomerDetails(String custId){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234");
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM customer WHERE custId=?");

            preparedStatement.setObject(1,custId);

            preparedStatement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCustomerDetails(String custId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234");
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE customer SET title=?, name=?, dob=?, salary=?, address=?, city=?, province=?, postalCode=? WHERE custId=?");

            preparedStatement.setObject(1,title);
            preparedStatement.setObject(2,name);
            preparedStatement.setObject(3,dob);
            preparedStatement.setObject(4,salary);
            preparedStatement.setObject(5, address);
            preparedStatement.setObject(6, city);
            preparedStatement.setObject(7, province);
            preparedStatement.setObject(8, postalCode);
            preparedStatement.setObject(9, custId);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ObservableList<CustomerInfoDto> loadCustomerDetails(){

        ObservableList<CustomerInfoDto> customerInfoArray= FXCollections.observableArrayList( );


        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234"
            );

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CustomerInfoDto customerDTO = new CustomerInfoDto(
                        resultSet.getString("custId"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.getString("dob"),        // You can also use resultSet.getDate("dob") if DTO uses java.sql.Date
                        resultSet.getDouble("salary"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postalCode")
                );
                customerInfoArray.add(customerDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return customerInfoArray;
    }
}
