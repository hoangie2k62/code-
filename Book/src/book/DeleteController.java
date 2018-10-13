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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DeleteController implements Initializable {
    private DictionaryApplication dict = new DictionaryApplication("dictionaries.txt");
    @FXML
    private TextField tDelete2 = new TextField();
    @FXML
    private Button bDelete = new Button();
    @FXML
    private AnchorPane pane = new AnchorPane();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bDelete.setDisable(true);
        tDelete2.textProperty().addListener((obsesrvable, oldVal, newVal)->{
            bDelete.setDisable(newVal.trim().isEmpty());
        });
    }    
    
    @FXML
    private void delete(ActionEvent event){
            Alert aDelete = new Alert(Alert.AlertType.CONFIRMATION);
            aDelete.setHeaderText("Notification");
            aDelete.setContentText("Ban co muon xoa tu nay?");
            ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
            aDelete.getButtonTypes().setAll(yes, no);
            Optional<ButtonType> result = aDelete.showAndWait();
            if(result.get() == yes){
               Alert adver = new Alert(Alert.AlertType.INFORMATION);
               adver.setHeaderText("Notification");
               if(dict.lookup(tDelete2.getText()) != -1){
                   dict.delete(tDelete2.getText());
                   adver.setContentText("Ban da xoa tu thanh cong");
               }
               else
                   adver.setContentText("Tu can xoa khong ton tai");
               adver.show();
            }   
        }
    
}
