package book;

public class Book {
    public static void main(String[] args) {
        DictionaryCommandline myWork = new DictionaryCommandline ();
        myWork.dictionaryBasic();
        myWork.dictionaryAdvanced();
        myWork.dictionarySearcher();
        DictionaryManagement mydirec = new DictionaryManagement();
        mydirec.dictionaryExportToFile();
    } 
}
