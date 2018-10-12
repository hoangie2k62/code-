package book;
import java.util.*;
import java.io.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class DictionaryManagement {
    protected Scanner sc  = new Scanner(System.in);
    protected String eng;
    protected String viet;
    protected Dictionary mydic = new Dictionary();
    protected int pos = -1;
    
    public void insertFromCommandline() {  // lan 1.
        System.out.print("So luong tu vung la: ");
        int n = sc.nextInt();
        eng = sc.nextLine();
        
        for(int i=0; i<n; i++){
            eng = sc.nextLine();
            viet = sc.nextLine();
            Word word = new Word(eng,viet);
            mydic.extra(word);
        }
    }
    
    public void insertFromFile(){   // lan 2.
        File file = new File("dictionaries.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] sepa = line.trim().split("\t");
                Word word = new Word(sepa[0].trim(),sepa[1].trim());
                mydic.extra(word);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Word> taken(){
        return mydic.taken();
    }
    
    public ArrayList<Word>  dictionayProperty(){
        return mydic.taken();
    }
    public String dictionaryLookup(String myWord){   // tra cuu tu bang dong lenh
        for(int i=0; i< mydic.size(); i++){
            if(myWord.equals(mydic.get(i).getWord_target())){
                return mydic.get(i).getWord_explain();
            }
        }
        return " ";
    }
    
    public int lookup(String myWord){
        for(int i=0; i< mydic.size(); i++){
            if(myWord.equals(mydic.get(i).getWord_target())){
                return i;
            }
        }
        return -1;
    }

    
    public void add(String inanh, String inviet){
        Word word = new Word(inanh.trim(), inviet.trim());
        mydic.extra(word);
        dictionaryExportToFile();
    }
    
    public void delete(String inanh){
        pos = lookup(inanh.trim());
        mydic.remove(pos);
        dictionaryExportToFile();
    }
    
    public void edit(String inanh, String inanh2, String inviet){
        Word word = new Word(inanh2.trim(), inviet.trim());
        pos = lookup(inanh);
        mydic.remove(pos);
        mydic.extra(pos, word);
        dictionaryExportToFile();
    }
    
    public void outputLabel(Label label, String text){
        viet = dictionaryLookup(text.trim());
        if(viet.equals(" ")){
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setTitle("Dictionary");
          alert.setHeaderText("Notification");
          alert.setContentText("Tu ban tim kiem khong co trong tu dien");
          alert.show();
        }
        label.setText(viet);
    }
    
    public void dictionaryExportToFile(){    // xuat du lieu tu dien hien tai ra file.
        File file = new File("dictionaries.txt");
        try{
            PrintWriter pw = new PrintWriter(file);
            for(int i = 0; i < mydic.size(); i++){
                pw.print(mydic.get(i).getWord_target()+"\t");
                pw.println(mydic.get(i).getWord_explain());
            }
            pw.close();  // nho dong lai neu khong file se bi xoa het!
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
