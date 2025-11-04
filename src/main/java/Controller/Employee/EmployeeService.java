package Controller.Employee;

import Model.DTO.EmployeeInfoDto;
import javafx.collections.ObservableList;

public interface EmployeeService {

    void addEmployeeDetails(String employeeId, String name, String nic, String dob, String position, double salary, String contactNumber, String address, String joinedDate, String status);

    void deleteEmployeeDetails(String empId);

    void updateEmployeeDetails(String employeeId, String name, String nic, String dob, String position, double salary, String contactNumber, String address, String joinedDate, String status);

    ObservableList<EmployeeInfoDto> loadEmployeeDetails();
}
