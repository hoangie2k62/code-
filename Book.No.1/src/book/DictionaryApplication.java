package book;
import java.util.ArrayList;
import java.io.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class DictionaryApplication {
    private int  pos = -1 ;
    private Dictionary dict = new Dictionary();
    private File file = new File("dictionaries.txt");
    
    public DictionaryApplication(){
        runApplication();
    }
    public void runApplication(){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] sepa = line.split("\t");
                Word word = new Word(sepa[0],sepa[1]);
                dict.extra(word);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Word> taken(){
        return dict.taken();
    }
    
    public String search(String wordFind){
        for(int i=0; i < dict.size(); i++){
            if(dict.getEng(i).equals(wordFind))
                return dict.getViet(i);
        }
        return "";
    }
    
    public int lookup(String myWord){
        for(int i=0; i< dict.size(); i++){
            if(myWord.equals(dict.getEng(i)))
                return i;
        }
        return -1;
    }
    
    public void add(String eng, String viet){
        dict.extra(new Word(eng, viet));
        dictionaryExportToFile();  
    }
    
    public void delete(int vitri){
        dict.remove(vitri);
        dictionaryExportToFile(); 
    }
    
    public void edit(String eng, String eng2, String viet){
        pos = lookup(eng);
        dict.remove(pos);
        dict.extra(pos, new Word(eng2, viet));
        dictionaryExportToFile();
    }
    
    public void outputLabel(Label label, String text){
        text = search(text);
        if(text.isEmpty()){
          label.setText(null);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Dictionary");
          alert.setHeaderText("Notification");
          alert.setContentText("Tu ban tim kiem khong co trong tu dien");
          alert.show();
        } 
        label.setText(text);
    }
    
    public void outputText(TextArea area, String text){
        text = search(text);
        if(text.isEmpty()){
          area.setText(null);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Dictionary");
          alert.setHeaderText("Notification");
          alert.setContentText("Tu ban yeu cau khong co trong tu dien");
          alert.show();
        } 
        area.setText(text);
    }
    
    public void dictionaryExportToFile(){
        try{
            PrintWriter pw = new PrintWriter(file);
            for(int i = 0; i < dict.size(); i++){
                pw.print(dict.get(i).getWord_target()+"\t");
                pw.println(dict.get(i).getWord_explain());
            }
            pw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}