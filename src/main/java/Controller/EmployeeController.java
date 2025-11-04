package Controller;

import Model.DTO.EmployeeInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class EmployeeController {

    public void addEmployeeDetails(String employeeId, String name, String nic, String dob, String position, double salary, String contactNumber, String address, String joinedDate, String status){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234");
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setObject(1,employeeId);
            preparedStatement.setObject(2,name);
            preparedStatement.setObject(3,nic);
            preparedStatement.setObject(4,dob);
            preparedStatement.setObject(5,position);
            preparedStatement.setObject(6,salary);
            preparedStatement.setObject(7,contactNumber);
            preparedStatement.setObject(8,address);
            preparedStatement.setObject(9,joinedDate);
            preparedStatement.setObject(10,status);


            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEmployeeDetails(String empId){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234");
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM employee WHERE emp_id=?");

            preparedStatement.setObject(1,empId);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEmployeeDetails(String employeeId, String name, String nic, String dob, String position, double salary, String contactNumber, String address, String joinedDate, String status){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234");
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE employee SET name=?, nic=?, dob=?, position=?, salary=?, contactNumber=?, address=?, joinedDate=?, status=? WHERE emp_id=?");

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, nic);
            preparedStatement.setString(3, dob);
            preparedStatement.setString(4, position);
            preparedStatement.setDouble(5, salary);
            preparedStatement.setString(6, contactNumber);
            preparedStatement.setString(7, address);
            preparedStatement.setString(8, joinedDate);
            preparedStatement.setString(9, status);
            preparedStatement.setString(10, employeeId);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<EmployeeInfoDto> loadEmployeeDetails(){

        ObservableList<EmployeeInfoDto> employeeInfoArray= FXCollections.observableArrayList();

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234"
            );

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EmployeeInfoDto employeeDTO = new EmployeeInfoDto(
                        resultSet.getString("emp_Id"),
                        resultSet.getString("name"),
                        resultSet.getString("nic"),
                        resultSet.getString("dob"),
                        resultSet.getString("position"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("contactNumber"),
                        resultSet.getString("address"),
                        resultSet.getString("joinedDate"),
                        resultSet.getString("status")
                );
                employeeInfoArray.add(employeeDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employeeInfoArray;
    }
}
