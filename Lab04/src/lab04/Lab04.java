package lab04;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab04 {
    public static int max(int a, int b){
        return Math.max(a, b);
    }
    
    public static int minArray(int[] a, int size){
        int min = 0;
        for(int i = 1; i< size; i++){
            min = Math.min(a[i],a[i-1]);
        }
        return min;
    }
    
    public static double BMI(double weigh, double high){
        double bmi = weigh / ( high * high);
        DecimalFormat df = new DecimalFormat("0.00");
        bmi = Double.parseDouble(df.format(bmi));
        return bmi;
    }
    
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int s1, s2;
          s1 = sc.nextInt();
          s2 = sc.nextInt();
          int max = max(s1,s2);
          System.out.println("Max la:" + max);
          
          int size = sc.nextInt();
          int[] arr = new int[size];
          for(int i=0; i<size; i++)
              arr[i] = sc.nextInt();
          int min = minArray(arr,size);
          System.out.println("Min la:" + min);
          
          double weigh = sc.nextDouble();
          double high = sc.nextDouble();
          double bmi =  BMI(weigh,high);
          if(bmi < 18.5)
             System.out.println("Thieu can");
          if(bmi >= 18.5 && bmi <= 24.99)
            System.out.println("Binh thuong");
          if(bmi >=23 && bmi <=24.99)
            System.out.println("Thua can");
          if(bmi > 25)
            System.out.println("Beo phi");
    }
    
}
