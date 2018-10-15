package lab06;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Square extends Rectangle{
     private DoubleProperty canh = new SimpleDoubleProperty();

    public DoubleProperty canhProperty() {
        return canh;
    }

    public void setCanh(double canh) {
        this.canh.setValue(canh);
    }
     
    public double getCanh(){
        return this.canh.get();
    } 
    
    public Square(){}
    public Square(double canh){
        this.canh.setValue(canh);
    }
    
    public String toString(){
        return "Square";
    }
}
