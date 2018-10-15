package lab06;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Shape {
    private int pos;
    private StringProperty mau = new SimpleStringProperty();

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public StringProperty mauProperty() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau.setValue(mau);
    }
    
    public String getMau(){
        return this.mau.get();
    }
    public Shape(){}
    public Shape(int pos, String mau){
        this.pos = pos;
        this.mau.setValue(mau);
    }
}
