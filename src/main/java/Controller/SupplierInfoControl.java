package Controller;

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
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234")) {

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO suppliers VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setObject(1, txtSupId.getText());
            ps.setObject(2, txtName.getText());
            ps.setObject(3, txtCompanyName.getText());
            ps.setObject(4, txtAddress.getText());
            ps.setObject(5, txtCity.getText());
            ps.setObject(6, txtProvince.getValue());
            ps.setObject(7, txtPostalCode.getText());
            ps.setObject(8, txtPhone.getText());
            ps.setObject(9, txtEMail.getText());

            ps.executeUpdate();
            loadSupplierDetails();
            clearFields();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234")) {

            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE suppliers SET name=?, companyName=?, address=?, city=?, province=?, postalCode=?, phone=?, email=? WHERE supplierId=?"
            );

            ps.setObject(1, txtName.getText());
            ps.setObject(2, txtCompanyName.getText());
            ps.setObject(3, txtAddress.getText());
            ps.setObject(4, txtCity.getText());
            ps.setObject(5, txtProvince.getValue());
            ps.setObject(6, txtPostalCode.getText());
            ps.setObject(7, txtPhone.getText());
            ps.setObject(8, txtEMail.getText());
            ps.setObject(9, txtSupId.getText());

            ps.executeUpdate();
            loadSupplierDetails();
            clearFields();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDelete(ActionEvent event) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234")) {

            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM suppliers WHERE supplierId=?"
            );
            ps.setObject(1, txtSupId.getText());
            ps.executeUpdate();

            loadSupplierDetails();
            clearFields();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234")) {

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM suppliers");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                supplierInfoArray.add(new SupplierInfoDto(
                        rs.getString("supplierId"),
                        rs.getString("name"),
                        rs.getString("companyName"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("province"),
                        rs.getString("postalCode"),
                        rs.getString("phone"),
                        rs.getString("email")
                ));
            }
            tblSupplier.setItems(supplierInfoArray);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
