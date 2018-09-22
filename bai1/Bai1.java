package bai1;
import java.util.Scanner;

public class Bai1 {
  
    public static int ucln(int a , int b){
        int so = 0 ;
        for(int i = 1 ; i < a || i < b ; i++)
        {
            if(a%i ==0 && b%i == 0)
                so = i;
        }
        return so;
    }
    public static int fibonaxi(int[] a, int n){
        a[0] = 0;
        a[1] =1;
        for ( int i = 2 ; i<=n ;i++){
            a[i] = a[i-1] +a[i-2];
        } 
        return a[n];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a , b , n ;
        a = input.nextInt();
        b = input.nextInt();
        System.out.println("uoc chung lon nhat la: "+ucln(a,b));
        n = input.nextInt();
        int[] c = new int[n+1];
        System.out.println("so fibonaxi thu n la: " + fibonaxi(c,n));
    }
    
}
