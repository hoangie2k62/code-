package book;
import java.util.*;

public class DictionaryCommandline {
    Scanner sc = new Scanner(System.in);
    DictionaryManagement myManager = new DictionaryManagement(); 
    
    public void showAllWords(ArrayList<Word> mydic) {   // in ArrayList ra man hinh
        System.out.println("No 	| English 		| Vietnamese");
        for(int i=0; i < mydic.size(); i++){
            System.out.print(i+1);
            System.out.print("\t| " +mydic.get(i).getWord_target());
            System.out.println("		| " +mydic.get(i).getWord_explain());
        }
    }
    public void dictionaryBasic() {   // lan 1.
        showAllWords(myManager.insertFromCommandline());
    }
    public void dictionaryAdvanced(){ // lan 2.
        ArrayList<Word> workBook = myManager.insertFromFile();
        myManager.dictionaryLookup(workBook);
        showAllWords(workBook);
    }
    public void dictionarySearcher(){   // tra cuu bang tu khoa!
        ArrayList<Word> workBook = myManager.insertFromFile();
        System.out.print("Nhap tu khoa tim kiem: ");
        String regex = sc.next();
        System.out.print("Danh sach cac tu vung bat dau = ("+regex+") la:");
        for(int i=0; i<workBook.size(); i++){
            if(workBook.get(i).getWord_target().indexOf(regex) == 0)
            {
                System.out.print(workBook.get(i).getWord_target()+",");
            }
        }
        System.out.println();
    } 
}
