package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class Login {

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    private Stage stage = new Stage();

    private final String username = "Admin";
    private final int pw = 1234;


    private void loginMethod() {
        try {
            if (txtUserName.getText().equalsIgnoreCase(username) &&
                    Integer.parseInt(txtPassword.getText()) == pw) {

                Stage currentStage = (Stage) txtUserName.getScene().getWindow();
                currentStage.close();

                Stage stage = new Stage();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/management_form.fxml"))));
                stage.setTitle("Management Panel");
                stage.show();

                //stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/management_form.fxml"))));
                //stage.show();


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Incorrect Username or Password");
                alert.setTitle("Login error");
                alert.showAndWait();

                txtUserName.clear();
                txtPassword.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Password must be numeric");
            alert.showAndWait();
        }

    }

    @FXML
    void btnLogin(ActionEvent event) {
        loginMethod();
    }

    @FXML
    void btnKeyPress(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")) {
            loginMethod();
        }
    }
}
