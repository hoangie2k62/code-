package book;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Book extends Application {
    public  static boolean mo = true;
    
    @Override
    public void start(Stage stage) {
        try{  
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("Addstyle.css").toExternalForm());
        stage.setTitle("Dictionary");
        stage.setScene(scene);
        stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
   
    public static void main (String[] args) {
        
        launch(args);
    }
}    
