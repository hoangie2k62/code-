package book;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Add extends Application {
    private DictionaryApplication dict = new DictionaryApplication("dictionaries.txt");
    
    @Override
    public void start(Stage stage) {
        try{
            Parent aRoot = FXMLLoader.load(getClass().getResource("Add.fxml"));
            Scene aScene = new Scene(aRoot);
            aScene.getStylesheets().add(getClass().getResource("Addstyle.css").toExternalForm());
            stage.setTitle("Add Dictionary");
            stage.setScene(aScene);
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
