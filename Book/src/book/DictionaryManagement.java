package book;
import java.util.*;
import java.io.*;

public class DictionaryManagement {
    Scanner sc  = new Scanner(System.in);
    private String eng;
    private String viet;
    
    public ArrayList insertFromCommandline() {  // lan 1.
        Dictionary mydic = new Dictionary();
        System.out.print("So luong tu vung la: ");
        int n = sc.nextInt();
        eng = sc.nextLine();
        
        for(int i=0; i<n; i++){
            eng = sc.nextLine();
            viet = sc.nextLine();
            Word word = new Word(eng,viet);
            mydic.extra(word);
        }
        return mydic.taken();
    }
    public ArrayList insertFromFile(){   // lan 2.
        Dictionary mydic2 = new Dictionary();
        File file = new File("dictionaries.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] sepa = line.split("\t");
                Word word = new Word(sepa[0],sepa[1]);
                mydic2.extra(word);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mydic2.taken();
    }
    
    public void dictionaryLookup(ArrayList<Word> list){   // tra cuu tu bang dong lenh
        System.out.print("Tu ban muon tra la: ");
        String wordFind = sc.nextLine();
        for(int i=0; i<list.size(); i++){
            if(wordFind.equals(list.get(i).getWord_target())){
                System.out.print("Tu ban can tim la: ");
                System.out.println(list.get(i).getWord_explain());
                break; //tranh truong hop hai tu eng trung nhau
            }
        }
    }
    public int dictionaryLookup(ArrayList<Word> list, String myWord){  // tim vi tri can xoa hoac sua
        for(int i=0; i<list.size(); i++){
            if(myWord.equals(list.get(i).getWord_target())){
                return i;
            }
        }
        return -1;
    }
    public ArrayList replaceDic(){   // phuong thuc them,xoa,sua doi tuong trong ArrayList
        ArrayList<Word> list = insertFromFile();
        System.out.print("Ban muon lam gi(plus: them; remove: xoa; repair: sua): ");
        String iWant = sc.nextLine();
        Word c;
        int pos = 0;
        switch (iWant){
            case "plus":
               System.out.print("Ban muon them tu nao la: ");
               eng = sc.nextLine();
               viet = sc.nextLine();
               c = new Word(eng,viet);
               list.add(c);
               break;
            case "remove":
                System.out.print("Tu ban muon xoa la: ");
                eng = sc.nextLine();
                pos = dictionaryLookup(list,eng);
                if(pos == -1)
                    System.out.println("Tu ban muon xoa khong ton tai!");
                else
                {
                    list.remove(pos);
                }
                break;
            case "repair":
                System.out.print("Tu ban muon sua la: ");
                eng = sc.nextLine();
                pos = dictionaryLookup(list,eng);
                if(pos == -1)
                    System.out.println("Tu ban muon sua khong ton tai!");
                else
                {
                    System.out.print("Ban muon sua tu thanh: ");
                    eng = sc.nextLine();
                    viet = list.get(pos).getWord_explain();
                    c = new Word(eng,viet);
                    list.remove(pos);
                    list.add(pos,c);
                }
                break;
        } 
        return list;
    }
    public void dictionaryExportToFile(){    // xuat du lieu tu dien hien tai ra file.
        ArrayList<Word> list = replaceDic();
        int len = list.size();
        File file = new File("dictionaries.txt");
        try{
            PrintWriter pw = new PrintWriter(file);
            for(int i = 0; i < len; i++){
                pw.print(list.get(i).getWord_target()+"\t");
                pw.println(list.get(i).getWord_explain());
            }
            pw.close();  // nho dong lai neu khong file se bi xoa het!
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
