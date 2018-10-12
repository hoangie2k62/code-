package book;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DictionaryCommandline implements Initializable {
    Scanner sc = new Scanner(System.in);
    DictionaryApplication  mydic =  new DictionaryApplication("dictionaries.txt"); 
    private Stage sAdd = new Stage();
    private Stage sDelete = new Stage();
    private Stage sEdit = new Stage();
    private ObservableList<Word> dictionarys;
    @FXML
      private TextField text1 = new TextField();
    @FXML
      private Label broad = new Label();
    @FXML
      private ListView<Word> list = new  ListView<Word>();
    @FXML
      private ListView<String> list1 = new  ListView<String>();
    
    public void showAllWords(ArrayList<Word> list) {   // in ArrayList ra man hinh
        System.out.println("No 	| English 		| Vietnamese");
        for(int i=0; i < list.size(); i++){
            System.out.print(i+1);
            System.out.print("\t| " +list.get(i).getWord_target());
            System.out.println("		| " +list.get(i).getWord_explain());
        }
    }
    
    public void dictionaryBasic() {   // lan 1.
        showAllWords(mydic.taken());
    }
    
    public void dictionaryAdvanced(){ // lan 2.
        System.out.print("tu ban muon tim kiem la:");
        String wordFind = sc.nextLine();
        mydic.dictionaryLookup(wordFind);
        showAllWords(mydic.taken());
    }
    
    public void dictionarySearcher(){   // tra cuu bang tu khoa!
        
    } 
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        dictionarys = FXCollections.observableArrayList(mydic.taken());
        list.setItems(dictionarys);
        list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Word>() {
            @Override
            public void changed(ObservableValue<? extends Word> observable, Word oldValue, Word newValue) {
                mydic.outputLabel(broad, newValue.getWord_target());
            }
        });
    }
    
    
    @FXML
    private void extra(ActionEvent event) {
        Add add = new Add();
        add.start(sAdd);
    }
    
    @FXML
    private void remove(ActionEvent event) {
        Delete delete = new Delete();
        delete.start(sDelete);
    }

    @FXML
    private void repair(ActionEvent event) {
        Edit edit = new Edit();
        edit.start(sEdit);
    }
    
    @FXML
    private void find(ActionEvent event){
        mydic.outputLabel(broad, text1.getText());
    }
    
}
