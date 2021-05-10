package sample.Controllers.Instructor;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Parent;

//import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Objects;

import sample.services.UserService;
import sample.users.User;


public class InstructorInfoController {

    @FXML
    private Button save;
    @FXML
    private Label price;
    @FXML
    private Label mountain;
    @FXML
    private Label description;
    @FXML
    private TextField pricetext;
    @FXML
    private TextField mountaintext;
    @FXML
    private TextField descriptiontext;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Text savedf;



    @FXML
    public void saveButtonOnAction(ActionEvent event) throws IOException{
        String p=pricetext.getText();
        String m=mountaintext.getText();
        String d=descriptiontext.getText();
        String name=username.getText();
        String pass=password.getText();
        if(UserService.modifyUserInfo(name,pass,p,d,m)==1)
        {
            savedf.setText("INFO SAVED");
        }
        else{
            savedf.setText("Something went wrong!");
        }


    }
}
