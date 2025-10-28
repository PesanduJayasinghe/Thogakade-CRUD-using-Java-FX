package Controller;

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
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Customer implements Initializable {

    ObservableList<CustomerInfoDto> customerInfoArray= FXCollections.observableArrayList( );

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

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234");
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)");

            preparedStatement.setObject(1,custId);
            preparedStatement.setObject(2,title);
            preparedStatement.setObject(3,name);
            preparedStatement.setObject(4,dob);
            preparedStatement.setObject(5,salary);
            preparedStatement.setObject(6,address);
            preparedStatement.setObject(7,city);
            preparedStatement.setObject(8,province);
            preparedStatement.setObject(9,postalCode);

            preparedStatement.execute();
            loadCustomerDetails();
            clearFields();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234");
            PreparedStatement preparedStatement=connection.prepareStatement("UPDATE customer SET title=?, name=?, dob=?, salary=?, address=?, city=?, province=?, postalCode=? WHERE custId=?");

            preparedStatement.setObject(1,txtTitle.getText());
            preparedStatement.setObject(2,txtName.getText());
            preparedStatement.setObject(3,txtDOB.getValue().toString());
            preparedStatement.setObject(4,txtSalary.getText());
            preparedStatement.setObject(5, txtAddress.getText());
            preparedStatement.setObject(6, txtCity.getText());
            preparedStatement.setObject(7, txtProvince.getValue());
            preparedStatement.setObject(8, txtPostalCode.getText());
            preparedStatement.setObject(9, txtCustId.getText());

            preparedStatement.execute();
            loadCustomerDetails();
            clearFields();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnDelete(ActionEvent event) {


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234");
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM customer WHERE custId=?");

            preparedStatement.setObject(1,txtCustId.getText());

            preparedStatement.execute();
            loadCustomerDetails();
            clearFields();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234"
            );

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CustomerInfoDto customerDTO = new CustomerInfoDto(
                        resultSet.getString("custId"),
                        resultSet.getString("title"),
                        resultSet.getString("name"),
                        resultSet.getString("dob"),        // You can also use resultSet.getDate("dob") if DTO uses java.sql.Date
                        resultSet.getDouble("salary"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postalCode")
                );
                customerInfoArray.add(customerDTO);
            }
            tblCustomer.setItems(customerInfoArray);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
