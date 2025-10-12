package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    Stage stage=new Stage();
    @FXML
    void btnLogin(ActionEvent event) {

        String username="Admin";
        int pw=1234;

        if (txtUserName.getText().equalsIgnoreCase(username) && Integer.parseInt(txtPassword.getText()) == pw) {
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/management_form.fxml"))));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);

            alert.setContentText("Incorrect Username or Password");
            alert.setTitle("Login error");
            alert.showAndWait();

            txtUserName.clear();
            txtPassword.clear();
        }
    }

}
