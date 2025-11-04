package Controller.Supplier;

import Model.DTO.SupplierInfoDto;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class SupplierController implements SupplierService {

    @Override
    public void addSupplierInfo(String supplierId,String name,String companyName,String address,String city,String province,String postalCode,String phone,String email){
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO suppliers VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            ps.setObject(1, supplierId);
            ps.setObject(2, name);
            ps.setObject(3, companyName);
            ps.setObject(4, address);
            ps.setObject(5, city);
            ps.setObject(6, province);
            ps.setObject(7, postalCode);
            ps.setObject(8, phone);
            ps.setObject(9, email);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteSuppierInfo(String supplierId){
        try {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "DELETE FROM suppliers WHERE supplierId=?"
            );
            ps.setObject(1, supplierId );
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSupplierInfo(String supplierId,String name,String companyName,String address,String city,String province,String postalCode,String phone,String email){
        try  {
            Connection conn = DBConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE suppliers SET name=?, companyName=?, address=?, city=?, province=?, postalCode=?, phone=?, email=? WHERE supplierId=?"
            );

            ps.setObject(1, name);
            ps.setObject(2, companyName);
            ps.setObject(3, address);
            ps.setObject(4, city);
            ps.setObject(5, province);
            ps.setObject(6, postalCode);
            ps.setObject(7, phone);
            ps.setObject(8, email);
            ps.setObject(9, supplierId);

            ps.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ObservableList<SupplierInfoDto> loadSupplierTable(){

        ObservableList<SupplierInfoDto> supplierInfoArray= FXCollections.observableArrayList();

        try  {
            Connection conn = DBConnection.getInstance().getConnection();
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


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return supplierInfoArray;
    }

}
