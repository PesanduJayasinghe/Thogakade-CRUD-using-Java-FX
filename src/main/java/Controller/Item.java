package Controller;

import Model.DTO.ItemInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Item {

    ObservableList<ItemInfoDto> itemInfoArray=FXCollections.observableArrayList(
            new ItemInfoDto("I001", "Basmathi Rice 5kg", "Groceries", 120, 1650.00),
            new ItemInfoDto("I002", "Nescafe 100g", "Beverages", 80, 950.00),
            new ItemInfoDto("I003", "Sunlight Soap 120g", "Household", 200, 180.00),
            new ItemInfoDto("I004", "Maliban Marie 400g", "Snacks", 150, 420.00),
            new ItemInfoDto("I005", "Anchor Milk Powder 1kg", "Dairy", 90, 1250.00)
    );

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnCustomerManage;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEmployeeManage;

    @FXML
    private Button btnSupplierManage;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> col_category;

    @FXML
    private TableColumn<?, ?> col_description;

    @FXML
    private TableColumn<?, ?> col_item_code;

    @FXML
    private TableColumn<?, ?> col_qty_on_hand;

    @FXML
    private TableColumn<?, ?> col_unit_price;

    @FXML
    private TableView<ItemInfoDto> tblItem;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

}
