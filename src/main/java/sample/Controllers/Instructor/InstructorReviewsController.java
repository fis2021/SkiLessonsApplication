package sample.Controllers.Instructor;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import org.w3c.dom.Text;
import sample.services.UserService;
import sample.users.User;

import javax.validation.constraints.Null;
import java.io.IOException;

public class InstructorReviewsController {


    @FXML
    private TextField nume;
    @FXML
    private Label eroare;
    @FXML
     private ListView list =new ListView<String>();
    private ObservableList<String> items = FXCollections.observableArrayList();


    @FXML
    public void CheckButtonOnAction(ActionEvent event) throws IOException{
        String n=nume.getText();
        items.add(UserService.returnsReviews(n));

            list.setItems(items);


    }
}
