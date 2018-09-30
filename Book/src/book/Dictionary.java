package book;
import java.util.ArrayList;

public class Dictionary {
    ArrayList<Word> myList = new ArrayList<Word>();
    public void extra(Word word){
        myList.add(word);
    }
    public ArrayList taken(){
        return myList;
    }
}
