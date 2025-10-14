package Controller;

import Model.DTO.CustomerInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Customer {

    ObservableList<CustomerInfoDto> customerInfoArray= FXCollections.observableArrayList(
            new CustomerInfoDto("C001", "Mr.", "John Smith", "1985-03-14", 65000.00, "123 Elm Street", "New York", "NY", "10001"),
            new CustomerInfoDto("C002", "Ms.", "Sarah Johnson", "1990-07-22", 72000.00, "456 Pine Avenue", "Los Angeles", "CA", "90012"),
            new CustomerInfoDto("C003", "Dr.", "Michael Lee", "1978-11-03", 95000.00, "789 Oak Road", "Chicago", "IL", "60616"),
            new CustomerInfoDto("C004", "Mrs.", "Emily Davis", "1992-02-09", 58000.00, "321 Maple Lane", "Houston", "TX", "77002"),
            new CustomerInfoDto("C005", "Mr.", "Robert Wilson", "1980-09-30", 87000.00, "654 Birch Street", "Seattle", "WA", "98101")
    );

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEmployeeManage;

    @FXML
    private Button btnItemManage;

    @FXML
    private Button btnSupplierManage;

    @FXML
    private Button btnUpdate;

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
    private ChoiceBox<?> txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

}
