package book;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Add extends Application {
    private DictionaryApplication dict = new DictionaryApplication("dictionaries.txt");
    
    @Override
    public void start(Stage stage) {
        GridPane gAdd = new GridPane();
        Label label = new Label("Add Dictionary");
        TextField tAdd1 = new TextField();
        tAdd1.setPromptText("Nhap tu tieng anh tai day.....");
        TextField tAdd2 = new TextField();
        tAdd2.setPromptText("Nhap tu tieng viet tai day.....");
        tAdd2.setMinHeight(100);
        tAdd2.setMinWidth(250);
        tAdd2.setAlignment(Pos.TOP_LEFT);
        Button add = new Button("Add");
        add.setDisable(true);
        tAdd1.textProperty().addListener(event ->{
           if(!tAdd1.getText().trim().isEmpty())
           {
              add.setDisable(tAdd2.getText().trim().isEmpty());   
           }
           else
               add.setDisable(true);
        });
        tAdd2.textProperty().addListener(event ->{
           if(!tAdd2.getText().trim().isEmpty())
           {
              add.setDisable(tAdd1.getText().trim().isEmpty());   
           }
           else
               add.setDisable(true);
        });
        add.setOnAction(event ->{
            Alert aAdd = new Alert(Alert.AlertType.CONFIRMATION);
            aAdd.setHeaderText("Notification");
            aAdd.setContentText("Ban co muon them tu nay?");
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
            aAdd.getButtonTypes().setAll(yes, no);
            Optional<ButtonType> result = aAdd.showAndWait();
            if(result.get() == yes){
               Alert adver = new Alert(Alert.AlertType.INFORMATION);
               adver.setHeaderText("Notification");
               if(dict.lookup(tAdd1.getText()) == -1){
                   dict.add(tAdd1.getText(), tAdd2.getText());
                   adver.setContentText("Ban da them tu thanh cong");
               }
               else
                   adver.setContentText("Tu da co trong tu dien");
               adver.show();
            }   
        });
        gAdd.add(label,1,0);
        gAdd.add(new Label("English: "),0,1);
        gAdd.add(tAdd1, 1, 1);
        gAdd.add(new Label("Vietnamese: "),0,2);
        gAdd.add(tAdd2, 1, 2);
        gAdd.add(add,1,4);
        gAdd.setHgap(10);
        gAdd.setVgap(10);
        gAdd.setAlignment(Pos.CENTER);
        Scene sAdd = new Scene(gAdd, 400, 300);
        stage.setTitle("Add Word");
        stage.setScene(sAdd);
        stage.show();
    }
    
}
