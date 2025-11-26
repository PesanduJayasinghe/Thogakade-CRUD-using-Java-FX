package Controller.Customer;

import Model.DTO.CustomerInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CustomerInfoControl implements Initializable {

    ObservableList<CustomerInfoDto> customerInfoArray= FXCollections.observableArrayList( );
    CustomerController customerController=new CustomerController();

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

        customerController.addCustomerDetails(custId,title,name,dob,salary,address,city,province,postalCode);

        loadCustomerDetails();
        clearFields();

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
    void btnUpdate(ActionEvent event){

        String custId=txtCustId.getText();
        String title=txtTitle.getText();
        String name=txtName.getText();
        String dob=txtDOB.getValue().toString();
        double salary= Double.parseDouble(txtSalary.getText());
        String address=txtAddress.getText();
        String city=txtCity.getText();
        String province= (String) txtProvince.getValue();
        String postalCode=txtPostalCode.getText();

        customerController.updateCustomerDetails(custId,title,name,dob,salary,address,city,province,postalCode);

        loadCustomerDetails();
        clearFields();
    }

    @FXML
    void btnDelete(ActionEvent event) {
        customerController.deleteCustomerDetails(txtCustId.getText());
        loadCustomerDetails();
        clearFields();
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
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

    @Override @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_cust_id.setCellValueFactory(new PropertyValueFactory<>("custId"));
        col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        col_city.setCellValueFactory(new PropertyValueFactory<>("city"));
        col_province.setCellValueFactory(new PropertyValueFactory<>("province"));
        col_postal_code.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        loadCustomerDetails();

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observableValue, customerInfoDto, t1) -> {
            if (t1 != null) {
                txtCustId.setText(t1.getCustId());
                txtTitle.setText(t1.getTitle());
                txtName.setText(t1.getName());
                txtDOB.setValue(LocalDate.parse(t1.getDob()));
                txtSalary.setText(String.valueOf(t1.getSalary()));
                txtAddress.setText(t1.getAddress());
                txtCity.setText(t1.getCity());
                txtProvince.setValue(t1.getProvince());
                txtPostalCode.setText(t1.getPostalCode());
            }

        });

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
        //default value
        txtProvince.setValue("Province");


    }

    private void loadCustomerDetails() {

        customerInfoArray.clear(); // Assuming you have a List<CustomerDTO> named customerDTOs

        tblCustomer.setItems(customerController.loadCustomerDetails());
    }

    public void clearFields(){
        txtCustId.clear();
        txtTitle.clear();
        txtName.clear();
        txtSalary.clear();
        txtDOB.setValue(null);
        txtAddress.clear();
        txtCity.clear();
        txtPostalCode.clear();
        txtProvince.setValue(null);
    }

}
