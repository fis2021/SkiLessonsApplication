package sample.Controllers.Client;
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
import java.io.IOException;


public class ClientInstructorController {

    @FXML
    ListView<String> list=new ListView<String>();

    @FXML
    private TextArea textd;

    @FXML
    private TextArea textp;

    @FXML
    private TextArea textm;


   @FXML
    private ComboBox cb;
    private ObservableList<String> items = FXCollections.observableArrayList();

    @FXML
    public void cbOnAction(ActionEvent event)throws IOException{
        UserService.getInstructors(items);
        cb.getItems().addAll(items);

    }

    @FXML
    public void seeOnAction(ActionEvent event)throws IOException{
        if(cb.getSelectionModel().getSelectedItem()!=null){
            String d=UserService.returnsDescription(cb.getSelectionModel().getSelectedItem().toString());
            String m=UserService.returnsMountain(cb.getSelectionModel().getSelectedItem().toString());
            String p=UserService.returnsPrice(cb.getSelectionModel().getSelectedItem().toString())+" ron";
            textd.setText(d);
            textm.setText(m);
            textp.setText(p);

        }
    }

}
