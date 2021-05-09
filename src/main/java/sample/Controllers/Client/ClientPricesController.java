package sample.Controllers.Client;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import sample.services.UserService;

import java.io.IOException;

public class ClientPricesController {
    @FXML
    ListView<String> list1=new ListView<String>();
    @FXML
    ListView<String> list2=new ListView<String>();
    private ObservableList<String> items_list1 = FXCollections.observableArrayList();
    private ObservableList<String> items_list2 = FXCollections.observableArrayList();

    @FXML
    public void checkButtonOnAction(ActionEvent event)throws IOException{
        UserService.getInstructors(items_list1);
        UserService.getPrices(items_list2);
        list1.setItems(items_list1);
        list2.setItems(items_list2);
    }

}
