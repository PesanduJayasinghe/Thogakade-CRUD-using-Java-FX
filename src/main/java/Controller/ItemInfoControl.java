package Controller;

import Model.DTO.ItemInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ItemInfoControl implements Initializable {

    ObservableList<ItemInfoDto> itemInfoArray = FXCollections.observableArrayList();

    @FXML
    private TableView<ItemInfoDto> tblItem;

    @FXML
    private TableColumn<?, ?> col_item_code;

    @FXML
    private TableColumn<?, ?> col_description;

    @FXML
    private TableColumn<?, ?> col_category;

    @FXML
    private TableColumn<?, ?> col_qty_on_hand;

    @FXML
    private TableColumn<?, ?> col_unit_price;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;


    // ---------- BUTTON HANDLERS ----------

    @FXML
    void btnAdd(ActionEvent event) {
        String itemCode = txtItemCode.getText();
        String description = txtDescription.getText();
        String category = txtCategory.getText();
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234")) {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO items VALUES (?, ?, ?, ?, ?)");
            ps.setObject(1, itemCode);
            ps.setObject(2, description);
            ps.setObject(3, category);
            ps.setObject(4, qtyOnHand);
            ps.setObject(5, unitPrice);
            ps.executeUpdate();

            loadItemDetails();
            clearFields();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234")) {

            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE items SET description=?, category=?, qtyOnHand=?, unitPrice=? WHERE itemCode=?"
            );
            ps.setObject(1, txtDescription.getText());
            ps.setObject(2, txtCategory.getText());
            ps.setObject(3, Integer.parseInt(txtQtyOnHand.getText()));
            ps.setObject(4, Double.parseDouble(txtUnitPrice.getText()));
            ps.setObject(5, txtItemCode.getText());
            ps.executeUpdate();

            loadItemDetails();
            clearFields();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDelete(ActionEvent event) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234")) {

            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM items WHERE itemCode=?"
            );
            ps.setObject(1, txtItemCode.getText());
            ps.executeUpdate();

            loadItemDetails();
            clearFields();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnCustomerManage(ActionEvent event) {}

    @FXML
    void btnSupplierManage(ActionEvent event) {}

    @FXML
    void btnEmployeeManage(ActionEvent event) {}



    // ---------- INITIALIZATION ----------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_item_code.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_category.setCellValueFactory(new PropertyValueFactory<>("category"));
        col_qty_on_hand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        col_unit_price.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        loadItemDetails();

        tblItem.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                txtItemCode.setText(newValue.getItemCode());
                txtDescription.setText(newValue.getDescription());
                txtCategory.setText(newValue.getCategory());
                txtQtyOnHand.setText(String.valueOf(newValue.getQtyOnHand()));
                txtUnitPrice.setText(String.valueOf(newValue.getUnitPrice()));
            }
        });
    }


    // ---------- HELPER METHODS ----------

    private void loadItemDetails() {
        itemInfoArray.clear();

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/thogakade_FX", "root", "1234")) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM items");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                itemInfoArray.add(new ItemInfoDto(
                        rs.getString("itemCode"),
                        rs.getString("description"),
                        rs.getString("category"),
                        rs.getInt("qtyOnHand"),
                        rs.getDouble("unitPrice")
                ));
            }

            tblItem.setItems(itemInfoArray);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void clearFields() {
        txtItemCode.clear();
        txtDescription.clear();
        txtCategory.clear();
        txtQtyOnHand.clear();
        txtUnitPrice.clear();
    }
}
