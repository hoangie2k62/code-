package bai2;
public class Ps {
    private double tu = 2;
    private double mau = 2;

    public double getTu() {
        return tu;
    }

    public void setTu(double tu) {
        this.tu = tu;
    }

    public double getMau() {
        return mau;
    }

    public void setMau(double mau) {
        this.mau = mau;
    }
    public Ps(){}
    public Ps(double a , double b ){
        this.tu = a;
        this.mau = b;
    }
    public Ps(Ps a){
        this(a.tu,a.mau);
    }
    public double soTP(){
        return tu/mau;
    }
    
    public double cong(Ps b){
        return  this.soTP()+b.soTP();
    }
    
    public double tru(Ps b){
        return  this.soTP()- b.soTP();
    }
    
    public double nhan(Ps b){
        return  this.soTP() * b.soTP();
    }
    
    public double chia(Ps b){
        return  this.soTP() / b.soTP();
    }
    public boolean equals(Ps b){
        return  this.soTP()> b.soTP();
    }
}
