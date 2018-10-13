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
import javafx.scene.input.KeyEvent;

public class AddController implements Initializable {
    private DictionaryApplication dict = new DictionaryApplication("dictionaries.txt");
    @FXML
    private TextField textEng = new TextField();
    @FXML
    private TextArea textViet = new TextArea();
    @FXML
    private Button bAdd = new Button();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bAdd.setDisable(true);
        
        textEng.textProperty().addListener((obsesrvable, oldVal, newVal)->{
            if(!newVal.trim().isEmpty())
                bAdd.setDisable(textViet.getText().trim().isEmpty());
            else
               bAdd.setDisable(true);
        });
        
        textViet.textProperty().addListener((obsesrvable, oldVal, newVal)->{
            if(!newVal.trim().isEmpty())
                bAdd.setDisable(textEng.getText().trim().isEmpty());
            else
               bAdd.setDisable(true);
        });
    }
    @FXML
    public void disable(KeyEvent event){
        
    }
    
    @FXML
    public void add(ActionEvent event){
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
               if(dict.lookup(textEng.getText()) == -1){
                   dict.add(textEng.getText(), textViet.getText());
                   adver.setContentText("Ban da them tu thanh cong");
               }
               else
                   adver.setContentText("Tu da co trong tu dien");
               adver.show();
            }   
    }
}
