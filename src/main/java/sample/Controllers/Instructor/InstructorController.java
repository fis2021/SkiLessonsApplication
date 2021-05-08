package sample.Controllers.Instructor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import org.w3c.dom.Text;

import java.io.IOException;

public class InstructorController {
    @FXML
    private AnchorPane change;
    @FXML
    private AnchorPane openInstructorInterface;
    @FXML
    private Button modify;
    @FXML
    private Button seeReviews;
    @FXML
    private Button seeLessonRequests;
    @FXML
    private Button goBack;
    @FXML
    private Button logOut;



    @FXML
    public void modifyButtonOnAction(ActionEvent event) throws IOException{
        AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("info_instructor.fxml"));
        change.getChildren().setAll(pane);
    }

    @FXML
    public void seeReviewsButtonOnAction(ActionEvent event) throws IOException{
        AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("seereviews_instructor.fxml"));
        change.getChildren().setAll(pane);

    }

    @FXML
    public void seeLessonRequestsButtonOnAction(ActionEvent event) throws IOException{
        AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("requests_instructor.fxml"));
        change.getChildren().setAll(pane);
    }

    @FXML
    public void goBackButtonOnAction(ActionEvent event) throws IOException{
       AnchorPane pane=FXMLLoader.load(getClass().getClassLoader().getResource("instructorhomepage.fxml"));
        openInstructorInterface.getChildren().setAll(pane);

    }

    @FXML
    public void logOutButtonOnAction(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
        stage = (Stage) logOut.getScene().getWindow();
        root=FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));

        stage.setScene(new Scene(root, 600, 450));
        stage.show();

    }
}
