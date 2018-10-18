package book;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class AddController implements Initializable {
    private int lines = 1;
    private DictionaryCommandline command = new DictionaryCommandline();
    @FXML
    private TextField textEng = new TextField();
    @FXML
    private TextArea textViet = new TextArea();
    @FXML
    private Button bAdd = new Button();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
 
    public Word getWord(){
        return new Word(textEng.getText().trim(), textViet.getText().trim());
    }
    
    @FXML
    private void keyEng(KeyEvent key){
        if(key.getCode().equals(KeyCode.DOWN)){
            textViet.requestFocus();
        }
    }
    
    @FXML
    private void keyViet(KeyEvent key){
        System.out.println(key.getCode());
        if(key.getCode().equals(KeyCode.ENTER))
                lines++;
        if(key.getCode().equals(KeyCode.UP)){
           if(lines == 1){
              textEng.requestFocus();
              textEng.selectAll();
           }
           else
               lines--;
        }
    }
}
