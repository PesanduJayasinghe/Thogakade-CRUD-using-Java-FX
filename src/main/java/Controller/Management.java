package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Management {

    Stage stage=new Stage();

    @FXML
    void btnCustomerManagement(ActionEvent event) throws IOException {
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/customer_form.fxml"))));
        stage.show();
    }

    @FXML
    void btnEmployeeManagement(ActionEvent event) throws IOException {
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/employee_form.fxml"))));
        stage.show();
    }

    @FXML
    void btnItemManagement(ActionEvent event) throws IOException {
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/item_form.fxml"))));
        stage.show();
    }

    @FXML
    void btnSupplierManagement(ActionEvent event) throws IOException {
        stage.close();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/supplier_form.fxml"))));
        stage.show();
    }

    @FXML
    void btnLogOut(ActionEvent event) throws IOException {
        stage.close();

        Stage stage2=new Stage();
        stage2.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/login_form.fxml"))));
        stage2.show();
    }
}
