package lab06;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Triangle extends Shape{
    private IntegerProperty canhA = new SimpleIntegerProperty();
    private IntegerProperty canhB = new SimpleIntegerProperty();
    private IntegerProperty canhC = new SimpleIntegerProperty();

    public IntegerProperty canhAProperty() {
        return canhA;
    }

    public void setCanhA(int canhA) {
        this.canhA.setValue(canhA);
    }
    
    public int getCanhA(){
        return canhA.get();
    }
    public IntegerProperty canhBProperty() {
        return canhB;
    }

    public void setCanhB(int canhB) {
        this.canhB.setValue(canhB);
    }
    
    public int getCanhB(){
        return canhB.get();
    }
    public IntegerProperty canhCProperty() {
        return canhC;
    }

    public void setCanhC(int canhC) {
        this.canhC.setValue(canhC);
    }
    
    public int getCanhC(){
        return canhC.get();
    }
    
    public Triangle(){}
    public Triangle(int a, int b, int c){
        this.canhA.setValue(a);
        this.canhB.setValue(b);
        this.canhC.setValue(c);
    }
    public String toString(){
        return "Triangle";
    }
}
