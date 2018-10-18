package book;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class DictionaryCommandline implements Initializable {
    private Scanner sc = new Scanner(System.in);
    private DictionaryApplication  mydic =  new DictionaryApplication(); 
    private Parent pAdd, pDelete, pEdit;
    private ObservableList<Word> dictionaries;
    @FXML
      private TextField text1 = new TextField();
    @FXML
      private Label broad = new Label();
    @FXML
      private ListView<Word> list = new  ListView<Word>();
    @FXML
      private AnchorPane root;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dictionaries = FXCollections.observableArrayList(mydic.taken());
        list.setItems(dictionaries);
        list.getSelectionModel().selectIndices(0);
        list.getSelectionModel().selectedItemProperty().addListener((observable, olsVal, newVal)->{
            mydic.outputLabel(broad, newVal.getWord_target());
        });
    }
  
    public void inFor(String action, int pos){
        Alert notify = new Alert(Alert.AlertType.INFORMATION);
        notify.setTitle(action + "Dictionary");
        notify.setHeaderText("Notification");
        if(pos == 2)
            notify.setContentText("Ban da " + action + " word thanh cong");
        else
            notify.setContentText("Ban da " + action +" word that bai");
        notify.show();
    }
    
    
    // ham them Word 
    @FXML
    private void extra(ActionEvent event) throws IOException {
        Dialog<Word> dialog = new Dialog<Word>();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Add.fxml"));
        pAdd = loader.load();
        AddController controller = loader.getController();
        ButtonType add = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(add, ButtonType.CANCEL);
        dialog.getDialogPane().setContent(pAdd);
        dialog.setResultConverter(button ->{
            if(button == add)
                return controller.getWord();
            return null;
        });
        Optional<Word> result = dialog.showAndWait();
        result.ifPresent(value ->{
             if(mydic.lookup(value.getWord_target()) == -1){
                mydic.add(value.getWord_target(), value.getWord_explain());
                dictionaries.add(value);
                inFor("them", 2); 
             }else
               inFor("them",3);
        });        
    }
    
    // ham xoa word
    @FXML
    private void remove(ActionEvent event) throws IOException {
        Dialog<String> dialog = new Dialog<String>();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Delete2.fxml"));
        pDelete = loader.load();
        DeleteController controller = loader.getController();
        ButtonType delete = new ButtonType("Delete", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(delete, ButtonType.CANCEL);
        dialog.getDialogPane().setContent(pDelete);
        dialog.setResultConverter(button ->{
            if(button == delete)
                return controller.getEng();
            return null;
        });
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(value ->{
            int pos = mydic.lookup(value);
            if(pos !=-1){
                mydic.delete(pos);
                dictionaries.remove(pos);
                inFor("xoa", 2);
            }else
              inFor("xoa", 3);
        });
    }
    
    // ham sua Word
    @FXML
    private void repair(ActionEvent event) throws IOException {
        Dialog<String[]> dialog = new Dialog<String[]>();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Edit.fxml"));
        pEdit = loader.load();
        EditController controller = loader.getController();
        ButtonType edit = new ButtonType("Edit", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(edit, ButtonType.CANCEL);
        dialog.getDialogPane().setContent(pEdit);
        dialog.setResultConverter(button ->{
            if(button == edit)
                return controller.getWord();
            return null;
        });
        Optional<String[]> result = dialog.showAndWait();
        result.ifPresent(value ->{
            int pos = mydic.lookup(value[0]);
            if(pos !=-1)
            {
                mydic.edit(value[0], value[1], value[2]);
                dictionaries.remove(pos);
                dictionaries.add(pos,new Word(value[1], value[2]));
                inFor("sua", 2);
            }else
               inFor("sua", 3);
            
        });
    }
    
    @FXML
    private void find(ActionEvent event){
        mydic.outputLabel(broad, text1.getText().trim());
        text1.selectAll();
    }
    
    @FXML
    private void getText(KeyEvent key){
        if(key.getCode().equals(KeyCode.ENTER)){
           mydic.outputLabel(broad, text1.getText().trim());
           text1.selectAll();
        }
    }
    
    @FXML
    private void close(ActionEvent event){
         Platform.exit();
         System.exit(0);
    }
}
