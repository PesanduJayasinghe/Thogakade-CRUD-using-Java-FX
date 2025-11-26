package Controller.Customer;

import Model.DTO.CustomerInfoDto;
import javafx.collections.ObservableList;

public interface CustomerService {

    void addCustomerDetails(String custId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode);

    void deleteCustomerDetails(String custId);

    void updateCustomerDetails(String custId, String title, String name, String dob, double salary, String address, String city, String province, String postalCode);

    ObservableList<CustomerInfoDto> loadCustomerDetails();



}
