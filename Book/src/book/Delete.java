package book;

import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Delete extends Application {
    
    @Override
    public void start(Stage stage) {
        try{
            Parent dRoot = FXMLLoader.load(getClass().getResource("Delete2.fxml"));
            Scene dScene = new Scene(dRoot);
            dScene.getStylesheets().add(getClass().getResource("Addstyle.css").toExternalForm());
            stage.setTitle("Delete Dictionary");
            stage.setScene(dScene);
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }    
}
