package Controller;

import Model.DTO.CustomerInfoDto;
import Model.DTO.SupplierInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Supplier {

    ObservableList<SupplierInfoDto> supplierInfoArray= FXCollections.observableArrayList(
            new SupplierInfoDto("S001", "Ruwan Perera", "Lanka Traders", "45 Main Street", "Colombo", "Western", "00100", "071-2345678", "info@lankatraders.lk"),
            new SupplierInfoDto("S002", "Nadeesha Silva", "Sunrise Distributors", "12 Temple Road", "Kandy", "Central", "20000", "071-3456789", "sales@sunrise.lk"),
            new SupplierInfoDto("S003", "Kamal Fernando", "Evergreen Supplies", "78 Galle Road", "Matara", "Southern", "81000", "071-4567890", "contact@evergreen.lk"),
            new SupplierInfoDto("S004", "Thilini Jayawardena", "Highland Imports", "23 Lake View", "Kurunegala", "North Western", "60000", "071-5678901", "support@highland.lk"),
            new SupplierInfoDto("S005", "Ashan Ranasinghe", "Royal Foods", "56 Beach Road", "Negombo", "Western", "11500", "071-6789012", "royalfoods@gmail.com")

    );

    @FXML
    void btnAdd(ActionEvent event) {
        String supplierId=txtSupId.getText();
        String name=txtName.getText();
        String companyName=txtCompanyName.getText();
        String address=txtAddress.getText();
        String city=txtCity.getText();
        String province=txtProvince.getValue();
        String postalCode=txtPostalCode.getText();
        String phone=txtPhone.getText();
        String email=txtEMail.getText();

        SupplierInfoDto supplierInfo=new SupplierInfoDto(supplierId,name,companyName,address,city,province,postalCode,phone,email);
        supplierInfoArray.add(supplierInfo);
    }

    @FXML
    void btnCustomerManage(ActionEvent event) {

    }

    @FXML
    void btnDelete(ActionEvent event) {
        SupplierInfoDto selectedInfo=tblSupplier.getSelectionModel().getSelectedItem();
        supplierInfoArray.remove(selectedInfo);
        tblSupplier.refresh();
    }

    @FXML
    void btnEmployeeManage(ActionEvent event) {

    }

    @FXML
    void btnItemManage(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {
        SupplierInfoDto supplierInfo=tblSupplier.getSelectionModel().getSelectedItem();

        supplierInfo.setSupplierId(txtSupId.getText());
        supplierInfo.setName(txtName.getText());
        supplierInfo.setAddress(txtAddress.getText());
        supplierInfo.setCity(txtCity.getText());
        supplierInfo.setEmail(txtEMail.getText());
        supplierInfo.setPhone(txtPhone.getText());
        supplierInfo.setCompanyName(txtCompanyName.getText());
        supplierInfo.setPostalCode(txtPostalCode.getText());
        supplierInfo.setProvince(txtProvince.getValue());

        tblSupplier.refresh();
    }


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
    private TableView<SupplierInfoDto> tblSupplier;

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
    private TextField txtPhone;

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
    private TextField txtSupId;



}
