package Controller;

import Model.DTO.EmployeeInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EmployeeInfoControl implements Initializable  {

    ObservableList<EmployeeInfoDto> employeeInfoArray= FXCollections.observableArrayList();

    @FXML
    void btnAdd(ActionEvent event) {
        String employeeId=txtEmpId.getText();
        String name=txtName.getText();
        String nic=txtNic.getText();
        String dob=txtDOB.getValue().toString();
        String position=txtPosition.getText();
        double salary= Double.parseDouble(txtSalary.getText());
        String contactNumber=txtContactNo.getText();
        String address=txtAddress.getText();
        String joinedDate=txtJoinedDate.getValue().toString();
        String status=txtStatus.getText();

        EmployeeController employeeController=new EmployeeController();
        employeeController.addEmployeeDetails(employeeId,name,nic,dob,position,salary,contactNumber,address,joinedDate,status);


        loadEmployeeDetails();
        clearFields();
    }

    @FXML
    void btnCustomerManage(ActionEvent event) {

    }

    @FXML
    void btnDelete(ActionEvent event) {

        EmployeeController employeeController=new EmployeeController();
        employeeController.deleteEmployeeDetails(txtEmpId.getText());

        loadEmployeeDetails();
        clearFields();
    }

    @FXML
    void btnItemManage(ActionEvent event) {

    }

    @FXML
    void btnSupplierManage(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {
        String employeeId=txtEmpId.getText();
        String name=txtName.getText();
        String nic=txtNic.getText();
        String dob=txtDOB.getValue().toString();
        String position=txtPosition.getText();
        double salary= Double.parseDouble(txtSalary.getText());
        String contactNumber=txtContactNo.getText();
        String address=txtAddress.getText();
        String joinedDate=txtJoinedDate.getValue().toString();
        String status=txtStatus.getText();

        EmployeeController employeeController=new EmployeeController();
        employeeController.updateEmployeeDetails(employeeId,name,nic,dob,position,salary,contactNumber,address,joinedDate,status);

        loadEmployeeDetails();
        clearFields();
    }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        col_emp_id.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_NIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        col_DOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        col_position.setCellValueFactory(new PropertyValueFactory<>("position"));
        col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        col_contact_no.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_joined_date.setCellValueFactory(new PropertyValueFactory<>("joinedDate"));
        col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

        loadEmployeeDetails();

        tblEmployee.getSelectionModel().selectedItemProperty().addListener((observableValue, employeeInfoDto, t1) -> {

            if (t1!=null){
                txtEmpId.setText(t1.getEmployeeId());
                txtName.setText(t1.getName());
                txtNic.setText(t1.getNic());
                txtDOB.setValue(LocalDate.parse(t1.getDob()));
                txtPosition.setText(t1.getPosition());
                txtSalary.setText(String.valueOf(t1.getSalary()));
                txtContactNo.setText(t1.getContactNumber());
                txtAddress.setText(t1.getAddress());
                txtJoinedDate.setValue(LocalDate.parse(t1.getJoinedDate()));
                txtStatus.setText(t1.getStatus());
            }
        });
    }

    private void loadEmployeeDetails() {

        employeeInfoArray.clear(); // Assuming you have a List<CustomerDTO> named customerDTOs

        EmployeeController employeeController=new EmployeeController();

        tblEmployee.setItems(employeeController.loadEmployeeDetails());
    }

    public void clearFields(){

        txtEmpId.clear();
        txtName.clear();
        txtNic.clear();
        txtStatus.clear();
        txtAddress.clear();
        txtStatus.clear();
        txtJoinedDate.setValue(null);
        txtDOB.setValue(null);
        txtPosition.clear();
        txtContactNo.clear();
    }
}
