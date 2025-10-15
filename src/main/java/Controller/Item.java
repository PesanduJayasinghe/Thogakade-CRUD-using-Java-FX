package Controller;

import Model.DTO.ItemInfoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Item implements Initializable {

    ObservableList<ItemInfoDto> itemInfoArray=FXCollections.observableArrayList(
            new ItemInfoDto("I001", "Basmathi Rice 5kg", "Groceries", 120, 1650.00),
            new ItemInfoDto("I002", "Nescafe 100g", "Beverages", 80, 950.00),
            new ItemInfoDto("I003", "Sunlight Soap 120g", "Household", 200, 180.00),
            new ItemInfoDto("I004", "Maliban Marie 400g", "Snacks", 150, 420.00),
            new ItemInfoDto("I005", "Anchor Milk Powder 1kg", "Dairy", 90, 1250.00)
    );

    @FXML
    void btnAdd(ActionEvent event) {
        String itemCode=txtItemCode.getText();
        String description=txtDescription.getText();
        String category=txtCategory.getText();
        int qtyOnHand= Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice= Double.parseDouble(txtUnitPrice.getText());

        ItemInfoDto itemInfo=new ItemInfoDto(itemCode,description,category,qtyOnHand,unitPrice);
        itemInfoArray.add(itemInfo);

    }

    @FXML
    void btnCustomerManage(ActionEvent event) {

    }

    @FXML
    void btnDelete(ActionEvent event) {
        ItemInfoDto selectedInfo=tblItem.getSelectionModel().getSelectedItem();
        itemInfoArray.remove(selectedInfo);
        tblItem.refresh();
    }

    @FXML
    void btnEmployeeManage(ActionEvent event) {

    }

    @FXML
    void btnSupplierManage(ActionEvent event) {

    }

    @FXML
    void btnUpdate(ActionEvent event) {
        ItemInfoDto itemInfo=tblItem.getSelectionModel().getSelectedItem();

        itemInfo.setItemCode(txtItemCode.getText());
        itemInfo.setCategory(txtCategory.getText());
        itemInfo.setDescription(txtDescription.getText());
        itemInfo.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
        itemInfo.setQtyOnHand(Integer.parseInt(txtQtyOnHand.getText()));

        tblItem.refresh();
    }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_item_code.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_category.setCellValueFactory(new PropertyValueFactory<>("category"));
        col_qty_on_hand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        col_unit_price.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tblItem.setItems(itemInfoArray);

        tblItem.getSelectionModel().selectedItemProperty().addListener((observableValue, itemInfoDto, t1) -> {

            if(t1!=null){
                txtItemCode.setText(t1.getItemCode());
                txtDescription.setText(t1.getDescription());
                txtCategory.setText(t1.getCategory());
                txtQtyOnHand.setText(String.valueOf(t1.getQtyOnHand()));
                txtUnitPrice.setText(String.valueOf(t1.getUnitPrice()));
            }
        });
    }
}
