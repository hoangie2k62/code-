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
import javafx.stage.Stage;


public class Edit extends Application {
    private DictionaryApplication dict = new DictionaryApplication("dictionaries.txt");
    
    @Override
    public void start(Stage stage) {
        GridPane gEdit = new GridPane();
        Label label = new Label("Edit Dictionary");
        TextField tEdit1 = new TextField();
        tEdit1.setPromptText("Nhap tu can thay the tai day.....");
        TextField tEdit2 = new TextField();
        tEdit2.setPromptText("Nhap tu thay the tai day.....");
        TextField tViet = new TextField();
        tViet.setPromptText("Nhap nghia tieng viet o day....");
        tViet.setMinHeight(100);
        tViet.setMinWidth(250);
        tViet.setAlignment(Pos.TOP_LEFT);
        Button edit = new Button("Edit");
        edit.setDisable(true);
        tEdit1.textProperty().addListener(event ->{
           if(!tEdit1.getText().trim().isEmpty())
           {
              edit.setDisable(tEdit2.getText().trim().isEmpty());   
           }
           else
               edit.setDisable(true);
        });
        tEdit2.textProperty().addListener(event ->{
           if(!tEdit2.getText().trim().isEmpty())
           {
              edit.setDisable(tEdit1.getText().trim().isEmpty());   
           }
           else
               edit.setDisable(true);
        });
        edit.setOnAction(event ->{
            Alert aEdit = new Alert(Alert.AlertType.CONFIRMATION);
            aEdit.setHeaderText("Notification");
            aEdit.setContentText("Ban co muon sua tu nay?");
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
            aEdit.getButtonTypes().setAll(yes, no);
            Optional<ButtonType> result = aEdit.showAndWait();
            if(result.get() == yes){
               Alert adver = new Alert(Alert.AlertType.INFORMATION);
               adver.setHeaderText("Notification"); 
               if(dict.lookup(tEdit1.getText()) != -1){
                   dict.edit(tEdit1.getText(),tEdit2.getText(), tViet.getText());
                   adver.setContentText("Ban da sua tu thanh cong");
               }
               else
                   adver.setContentText("Tu can sua khong co trong tu dien");
               adver.show();
            }   
        });
        gEdit.add(label,1,0);
        gEdit.add(new Label("Tu can thay the: "),0,1);
        gEdit.add(tEdit1,1,1);
        gEdit.add(new Label("Tu thay the: "),0,2);
        gEdit.add(tEdit2,1,2);
        gEdit.add(new Label("Vietnamese: "), 0, 3);
        gEdit.add(tViet, 1, 3);
        gEdit.add(edit,1,4);
        gEdit.setHgap(10);
        gEdit.setVgap(10);
        gEdit.setAlignment(Pos.CENTER);
        Scene sEdit = new Scene(gEdit, 400, 300);
        stage.setTitle("Edit Word");
        stage.setScene(sEdit);
        stage.show();
    }
}
