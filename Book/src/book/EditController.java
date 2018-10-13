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
    private DictionaryApplication dict = new DictionaryApplication("dictionaries.txt");
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
            if(!newVal.trim().isEmpty()){
                dict.outputText(tViet, tEdit1.getText());
            }
            else
               bEdit.setDisable(true);
        });
        
        tEdit2.textProperty().addListener((obsesrvable, oldVal, newVal)->{
            if(!newVal.trim().isEmpty())
                bEdit.setDisable(tViet.getText().trim().isEmpty());
            else
               bEdit.setDisable(true);
        });
    }    
    @FXML
    public void edit(ActionEvent event){
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
    }
}
