package bai2;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          
          Ps s1 = new Ps() ;
          double a , b ;
          a = input.nextInt() ;
          b = input.nextInt() ;
          s1.setTu(a);
          s1.setMau(b);
          
          Ps s2 = new Ps() ;
          double c , d ;
          c = input.nextInt() ;
          d = input.nextInt() ;
          s1.setTu(c);
          s1.setMau(d);
          
          String pheptinh;
          pheptinh = input.next();
          switch (pheptinh){
              case "+":
                  System.out.println("gia tri la:" + s1.cong(s2));
                  break;
              case "-":
                  System.out.println("gia tri la:" + s1.tru(s2));
                  break; 
              case "*":
                  System.out.println("gia tri la:" + s1.nhan(s2));
                  break; 
              case "/":
                  System.out.println("gia tri la:" + s1.chia(s2));
                  break; 
              case "sosanh":
                  System.out.println("gia tri la:" + s1.equals(s2));
                  break;
          }
    }
    
}
