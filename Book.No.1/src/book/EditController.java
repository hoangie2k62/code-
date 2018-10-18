package book;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class EditController implements Initializable {
    private DictionaryCommandline command = new DictionaryCommandline();
    @FXML
    private TextField tEdit1 = new TextField();
    @FXML
    private TextField tEdit2 = new TextField();
    @FXML
    private TextArea tViet = new TextArea();
    @FXML
    private Button bEdit = new Button();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bEdit.setDisable(true);
        tEdit1.textProperty().addListener((obsesrvable, oldVal, newVal)->{
            
        });
        tEdit2.textProperty().addListener((obsesrvable, oldVal, newVal)->{
            if(!newVal.trim().isEmpty())
                bEdit.setDisable(tViet.getText().trim().isEmpty());
            else
               bEdit.setDisable(true);
        });
        tViet.textProperty().addListener((observable, olVal, newVal)->{
            if(!newVal.trim().isEmpty())
                bEdit.setDisable(tEdit2.getText().trim().isEmpty());
            else
               bEdit.setDisable(true);
        });
    }  
    public String[] getWord(){
        String[]  hoang = {tEdit1.getText().trim(), tEdit2.getText().trim(), tViet.getText().trim()};
        return hoang;
    }
}
