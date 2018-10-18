package book;
import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> myList = new ArrayList<Word>();
    
    public void extra(Word word){
        myList.add(word);
    }
    public void extra(int i, Word word){
        myList.add(i, word);
    }
    
    public void remove(int i){
       myList.remove(i);
    }
    
    public void remove(Word word){
       myList.remove(word);
    }
    public int size(){
       return myList.size(); 
    }
    
    public Word get(int i){
        return myList.get(i);
    }
    
    public ArrayList<Word> taken(){
        return myList;
    }
    
    public String getEng(int pos){
       return myList.get(pos).getWord_target();
    }
    
    public String getViet(int pos){
       return myList.get(pos).getWord_explain();
    }
}