package Controller;

import Model.DTO.CustomerInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Customer {

    ObservableList<CustomerInfoDto> customerInfoArray= FXCollections.observableArrayList(
            new CustomerInfoDto("C001", "Mr.", "John Smith", "1985-03-14", 65000.00, "123 Elm Street", "New York", "NY", "10001"),
            new CustomerInfoDto("C002", "Ms.", "Sarah Johnson", "1990-07-22", 72000.00, "456 Pine Avenue", "Los Angeles", "CA", "90012"),
            new CustomerInfoDto("C003", "Dr.", "Michael Lee", "1978-11-03", 95000.00, "789 Oak Road", "Chicago", "IL", "60616"),
            new CustomerInfoDto("C004", "Mrs.", "Emily Davis", "1992-02-09", 58000.00, "321 Maple Lane", "Houston", "TX", "77002"),
            new CustomerInfoDto("C005", "Mr.", "Robert Wilson", "1980-09-30", 87000.00, "654 Birch Street", "Seattle", "WA", "98101")
    );

    @FXML
    void btnAdd(ActionEvent event) {
        String custId=txtCustId.getText();
        String title=txtTitle.getText();
        String name=txtName.getText();
        String dob=txtDOB.getValue().toString();
        double salary= Double.parseDouble(txtSalary.getText());
        String address=txtAddress.getText();
        String city=txtCity.getText();
        String province= (String) txtProvince.getValue();
        String postalCode=txtPostalCode.getText();

        CustomerInfoDto customerInfo=new CustomerInfoDto(custId,title,name,dob,salary,address,city,province,postalCode);
        customerInfoArray.add(customerInfo);


    }

    @FXML
    void btnEmployeeManage(ActionEvent event) {

    }

    @FXML
    void btnItemManage(ActionEvent event) {

    }

    @FXML
    void btnSupplierManage(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }

    @FXML
    private TableColumn<?, ?> col_address;

    @FXML
    private TableColumn<?, ?> col_city;

    @FXML
    private TableColumn<?, ?> col_cust_id;

    @FXML
    private TableColumn<?, ?> col_dob;

    @FXML
    private TableColumn<?, ?> col_name;

    @FXML
    private TableColumn<?, ?> col_postal_code;

    @FXML
    private TableColumn<?, ?> col_province;

    @FXML
    private TableColumn<?, ?> col_salary;

    @FXML
    private TableColumn<?, ?> col_title;

    @FXML
    private TableView<CustomerInfoDto> tblCustomer;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCustId;

    @FXML
    private DatePicker txtDOB;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private ChoiceBox<String> txtProvince;

    @FXML
    public void initialize() {
        txtProvince.getItems().addAll(
                "Central",
                "Eastern",
                "Northern",
                "North Central",
                "North Western",
                "Sabaragamuwa",
                "Southern",
                "Uva",
                "Western"
        );

        // Optional: set default value
        txtProvince.setValue("Western");
    }

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

}
