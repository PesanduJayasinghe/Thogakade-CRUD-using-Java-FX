package Controller.Supplier;

import Model.DTO.SupplierInfoDto;
import javafx.collections.ObservableList;

public interface SupplierService {

    void addSupplierInfo(String supplierId,String name,String companyName,String address,String city,String province,String postalCode,String phone,String email);

    void deleteSuppierInfo(String supplierId);

    void updateSupplierInfo(String supplierId,String name,String companyName,String address,String city,String province,String postalCode,String phone,String email);

    ObservableList<SupplierInfoDto> loadSupplierTable();
}
