package book;
import java.util.*;
import java.io.*;

public class DictionaryApplication extends DictionaryManagement{
    public DictionaryApplication(){}
    public DictionaryApplication (String path) {
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] sepa = line.split("\t");
                Word word = new Word(sepa[0], sepa[1]);;
                mydic.extra(word);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
