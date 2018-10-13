package book;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Edit extends Application {
    private DictionaryApplication dict = new DictionaryApplication("dictionaries.txt");
    
    @Override
    public void start(Stage stage) {
        try{
            Parent eRoot = FXMLLoader.load(getClass().getResource("Edit.fxml"));
            Scene sEdit = new Scene(eRoot);
            sEdit.getStylesheets().add(getClass().getResource("Addstyle.css").toExternalForm());
            stage.setTitle("Edit Dictionary");
            stage.setScene(sEdit);
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
