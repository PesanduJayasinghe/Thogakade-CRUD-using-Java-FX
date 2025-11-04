package Controller.Supplier;

import Model.DTO.SupplierInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SupplierInfoControl implements Initializable {

    ObservableList<SupplierInfoDto> supplierInfoArray = FXCollections.observableArrayList();
    SupplierController supplierController=new SupplierController();

    @FXML
    private TableView<SupplierInfoDto> tblSupplier;

    @FXML
    private TableColumn<?, ?> col_supplier_id, col_name, col_company_name, col_address, col_city, col_province, col_postal_code, col_phone, col_email;

    @FXML
    private TextField txtSupId, txtName, txtCompanyName, txtAddress, txtCity, txtPostalCode, txtPhone, txtEMail;

    @FXML
    private ChoiceBox<String> txtProvince;



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

        supplierController.addSupplierInfo(supplierId,name,companyName,address,city,province,postalCode,phone,email);

        loadSupplierDetails();
        clearFields();

    }

    @FXML
    void btnUpdate(ActionEvent event) {

        String supplierId=txtSupId.getText();
        String name=txtName.getText();
        String companyName=txtCompanyName.getText();
        String address=txtAddress.getText();
        String city=txtCity.getText();
        String province=txtProvince.getValue();
        String postalCode=txtPostalCode.getText();
        String phone=txtPhone.getText();
        String email=txtEMail.getText();

        supplierController.updateSupplierInfo(supplierId,name,companyName,address,city,province,postalCode,phone,email);

        loadSupplierDetails();
        clearFields();
    }

    @FXML
    void btnDelete(ActionEvent event) {
        supplierController.deleteSuppierInfo(txtSupId.getText());
        loadSupplierDetails();
        clearFields();

    }

    @FXML
    void btnCustomerManage(ActionEvent event) {}
    @FXML
    void btnEmployeeManage(ActionEvent event) {}
    @FXML
    void btnItemManage(ActionEvent event) {}



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_supplier_id.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_company_name.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_city.setCellValueFactory(new PropertyValueFactory<>("city"));
        col_province.setCellValueFactory(new PropertyValueFactory<>("province"));
        col_postal_code.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));

        txtProvince.getItems().addAll(
                "Central", "Eastern", "Northern", "North Central", "North Western",
                "Sabaragamuwa", "Southern", "Uva", "Western"
        );
        txtProvince.setValue("Western");

        loadSupplierDetails();

        tblSupplier.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtSupId.setText(newVal.getSupplierId());
                txtName.setText(newVal.getName());
                txtCompanyName.setText(newVal.getCompanyName());
                txtAddress.setText(newVal.getAddress());
                txtCity.setText(newVal.getCity());
                txtProvince.setValue(newVal.getProvince());
                txtPostalCode.setText(newVal.getPostalCode());
                txtPhone.setText(newVal.getPhone());
                txtEMail.setText(newVal.getEmail());
            }
        });
    }

    private void loadSupplierDetails() {
        supplierInfoArray.clear();

        tblSupplier.setItems(supplierController.loadSupplierTable());
    }

    private void clearFields() {
        txtSupId.clear();
        txtName.clear();
        txtCompanyName.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.setValue("Western");
        txtPostalCode.clear();
        txtPhone.clear();
        txtEMail.clear();
    }
}
