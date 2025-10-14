package Controller;

import Model.DTO.SupplierInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Supplier {

    ObservableList<SupplierInfoDto> supplierInfoArray= FXCollections.observableArrayList(
            new SupplierInfoDto("S001", "Ruwan Perera", "Lanka Traders", "45 Main Street", "Colombo", "Western", "00100", "071-2345678", "info@lankatraders.lk"),
            new SupplierInfoDto("S002", "Nadeesha Silva", "Sunrise Distributors", "12 Temple Road", "Kandy", "Central", "20000", "071-3456789", "sales@sunrise.lk"),
            new SupplierInfoDto("S003", "Kamal Fernando", "Evergreen Supplies", "78 Galle Road", "Matara", "Southern", "81000", "071-4567890", "contact@evergreen.lk"),
            new SupplierInfoDto("S004", "Thilini Jayawardena", "Highland Imports", "23 Lake View", "Kurunegala", "North Western", "60000", "071-5678901", "support@highland.lk"),
            new SupplierInfoDto("S005", "Ashan Ranasinghe", "Royal Foods", "56 Beach Road", "Negombo", "Western", "11500", "071-6789012", "royalfoods@gmail.com")

    );

    @FXML
    private Button btnCustomerManage;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEmployeeManage;

    @FXML
    private Button btnItemManage;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> col_address;

    @FXML
    private TableColumn<?, ?> col_city;

    @FXML
    private TableColumn<?, ?> col_company_name;

    @FXML
    private TableColumn<?, ?> col_email;

    @FXML
    private TableColumn<?, ?> col_name;

    @FXML
    private TableColumn<?, ?> col_phone;

    @FXML
    private TableColumn<?, ?> col_postal_code;

    @FXML
    private TableColumn<?, ?> col_province;

    @FXML
    private TableColumn<?, ?> col_supplier_id;

    @FXML
    private TableView<SupplierInfoDto> tblEmployee;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtEMail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private ComboBox<?> txtProvince;

    @FXML
    private TextField txtSupId;

    @FXML
    void btnAdd(ActionEvent event) {

    }

}
