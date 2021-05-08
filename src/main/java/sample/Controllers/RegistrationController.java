package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import sample.exceptions.UsernameAlreadyExistsException;
import sample.services.UserService;

import java.io.IOException;

public class RegistrationController {
    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;
    @FXML
    private Button closeButton;
    @FXML
    private Button registerButton;
    @FXML
    private Button goBackButton;
    @FXML
    private AnchorPane gobacktologin;


    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Instructor");
    }

    @FXML
    public void registerButtonOnAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully !");
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }

    @FXML
    public void closeButtonOnAction(ActionEvent event){

        Stage stage=(Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void goBackButtonOnAction(ActionEvent event) throws IOException {
        AnchorPane logpane= FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        gobacktologin.getChildren().setAll(logpane);
    }
    public void onAction(){

    }

}
