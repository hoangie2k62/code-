package book;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeleteController implements Initializable {
    private DictionaryCommandline command = new DictionaryCommandline();
    @FXML
    private TextField tEng = new TextField();
    @FXML
    private Button bDelete = new Button();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public String getEng(){
        return tEng.getText().trim();
    }
    
    
}
