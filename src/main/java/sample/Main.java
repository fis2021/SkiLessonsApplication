package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import sample.services.FileSistemService;
import sample.services.UserService;

import java.nio.file.Files;
import java.nio.file.Path;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initDirectory();
        UserService.initDatabase();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("login.fxml"));
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("Ski Lessons Application");
       primaryStage.setScene(new Scene(root, 600, 450));
       // primaryStage.setScene(new Scene(root, 1127, 680));
        primaryStage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSistemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
