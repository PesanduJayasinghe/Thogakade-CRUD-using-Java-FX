package Controller;

import Model.DTO.EmployeeInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Employee {

    ObservableList<EmployeeInfoDto> employeeInfoArray= FXCollections.observableArrayList(
            new EmployeeInfoDto("E001", "Anura Perera", "NIT12345", "1988-04-12", "Manager", 85000.00, "071-1234567", "12 Main Mawatha, Colombo", "2015-06-01", "Sakriya"),
            new EmployeeInfoDto("E002", "Kavindu Jayasinghe", "NIT23456", "1992-09-25", "Software Developer", 72000.00, "071-2345678", "45 Temple Road, Kandy", "2018-03-12", "Sakriya"),
            new EmployeeInfoDto("E003", "Nimali Silva", "NIT34567", "1985-01-30", "HR Officer", 65000.00, "071-3456789", "89 Galle Road, Matara", "2016-09-20", "Nisakriya"),
            new EmployeeInfoDto("E004", "Sampath Fernando", "NIT45678", "1990-07-18", "Accountant", 70000.00, "071-4567890", "23 Lake View, Kurunegala", "2017-11-05", "Sakriya"),
            new EmployeeInfoDto("E005", "Tharushi Ranasinghe", "NIT56789", "1995-12-02", "Graphic Designer", 68000.00, "071-5678901", "56 Beach Road, Negombo", "2020-01-15", "Sakriya")
    );

    @FXML
    private Button btnCustomerManage;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnItemManage;

    @FXML
    private Button btnSupplierManage;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> col_DOB;

    @FXML
    private TableColumn<?, ?> col_NIC;

    @FXML
    private TableColumn<?, ?> col_address;

    @FXML
    private TableColumn<?, ?> col_contact_no;

    @FXML
    private TableColumn<?, ?> col_emp_id;

    @FXML
    private TableColumn<?, ?> col_joined_date;

    @FXML
    private TableColumn<?, ?> col_name;

    @FXML
    private TableColumn<?, ?> col_position;

    @FXML
    private TableColumn<?, ?> col_salary;

    @FXML
    private TableColumn<?, ?> col_status;

    @FXML
    private TableView<EmployeeInfoDto> tblEmployee;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContactNo;

    @FXML
    private DatePicker txtDOB;

    @FXML
    private TextField txtEmpId;

    @FXML
    private DatePicker txtJoinedDate;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtStatus;

    @FXML
    void btnAdd(ActionEvent event) {

    }

}
