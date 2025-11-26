package Controller.Item;

import Model.DTO.ItemInfoDto;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class ItemController implements ItemService{

    @Override
    public void addItemInfo(String itemCode,String description,String category,int qtyOnHand,double unitPrice){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO items VALUES (?, ?, ?, ?, ?)");
            ps.setObject(1, itemCode);
            ps.setObject(2, description);
            ps.setObject(3, category);
            ps.setObject(4, qtyOnHand);
            ps.setObject(5, unitPrice);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateItemInfo(String itemCode,String description,String category,int qtyOnHand,double unitPrice){
        try  {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE items SET description=?, category=?, qtyOnHand=?, unitPrice=? WHERE itemCode=?"
            );
            ps.setObject(1, description);
            ps.setObject(2, category);
            ps.setObject(3, qtyOnHand);
            ps.setObject(4, unitPrice);
            ps.setObject(5, itemCode);
            ps.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteItemInfo(String itemCode){
        try {
            Connection connection =DBConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(
                    "DELETE FROM items WHERE itemCode=?"
            );
            ps.setObject(1, itemCode );
            ps.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<ItemInfoDto> loadItemTable(){

        ObservableList<ItemInfoDto> itemInfoArray = FXCollections.observableArrayList();

        try {
            Connection connection =DBConnection.getInstance().getConnection();
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



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return itemInfoArray;
    }
}
