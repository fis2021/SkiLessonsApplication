package sample.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class LoginController {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;

    public void loginButtonOnAction(ActionEvent event){
        String username=usernameTextField.getText();
        String password=passwordField.getText();
        loginMessageLabel.setVisible(true);
        if(username!=null && password!=null){
            validateLogin();
        }
        else{
            loginMessageLabel.setText("Please enter your username and password!");

        }
    }

    @FXML
    public void cancelButtonOnAction(ActionEvent event){
        loginMessageLabel.setVisible(true);
        Stage stage=(Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        loginMessageLabel.setVisible(true);
        DatabaseConnection connectNow= new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();

        String verifyLogin="SELECT count(1) FROM user_account WHERE username = '"+ usernameTextField + "' AND password ='" + passwordField.getText() + "'";

        try{
            Statement statement=connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1)==1){
                    loginMessageLabel.setText("Login Succesfully!");

                }else{
                    loginMessageLabel.setText("Invalid login.Please try again!");

                }
            }

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
