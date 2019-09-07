/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;

import java.time.LocalTime;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author DLC
 */
public class spProperty {

    public IntegerProperty idSp, diem1, diem2, diem3, diem4, diem5, tgra11;
    public DoubleProperty loi1, loi2, loi3, loi4, loi5;
    public StringProperty tt1, tt2, tt3, tt4, tt5;
    public LocalTime tgra1, tgra2, tgra3, tgra4, tgra5;

    public spProperty(int idSp, int diem1, int diem2, int diem3, int diem4, int diem5, double loi1, double loi2, double loi3, double loi4, double loi5, String tt1,
            String tt2, String tt3, String tt4, String tt5, LocalTime tgra1, LocalTime tgra2, LocalTime tgra3, LocalTime tgra4, LocalTime tgra5) {
        this.idSp = new SimpleIntegerProperty(idSp);
        this.diem1 = new SimpleIntegerProperty(diem1);
        this.diem2 = new SimpleIntegerProperty(diem2);
        this.diem3 = new SimpleIntegerProperty(diem3);
        this.diem4 = new SimpleIntegerProperty(diem4);
        this.diem5 = new SimpleIntegerProperty(diem5);
        this.loi1 = new SimpleDoubleProperty(loi1);
        this.loi2 = new SimpleDoubleProperty(loi2);
        this.loi3 = new SimpleDoubleProperty(loi3);
        this.loi4 = new SimpleDoubleProperty(loi4);
        this.loi5 = new SimpleDoubleProperty(loi5);
        this.tt1 = new SimpleStringProperty(tt1);
        this.tt2 = new SimpleStringProperty(tt2);
        this.tt3 = new SimpleStringProperty(tt3);
        this.tt4 = new SimpleStringProperty(tt4);
        this.tt5 = new SimpleStringProperty(tt5);
        this.tgra1 = tgra1;
        this.tgra2 = tgra2;
        this.tgra3 = tgra3;
        this.tgra4 = tgra4;
        this.tgra5 = tgra5;
    }
    public spProperty(double loi1,int tgra11){
        this.loi1=new SimpleDoubleProperty(loi1);
        this.tgra1=tgra1;
    
    
    }

    public LocalTime getTgra1() {
        return tgra1;
    }

    public void setTgra1(LocalTime tgra1) {
        this.tgra1 = tgra1;
    }

    public LocalTime getTgra2() {
        return tgra2;
    }

    public void setTgra2(LocalTime tgra2) {
        this.tgra2 = tgra2;
    }

    public LocalTime getTgra3() {
        return tgra3;
    }

    public void setTgra3(LocalTime tgra3) {
        this.tgra3 = tgra3;
    }

    public LocalTime getTgra4() {
        return tgra4;
    }

    public void setTgra4(LocalTime tgra4) {
        this.tgra4 = tgra4;
    }

    public LocalTime getTgra5() {
        return tgra5;
    }

    public void setTgra5(LocalTime tgra5) {
        this.tgra5 = tgra5;
    }

    public IntegerProperty idSpIntegerProperty() {
        return idSp;
    }

    public void setIdSp(IntegerProperty idSp) {
        this.idSp = idSp;
    }

    public int getIdSp() {
        return idSp.get();
    }

       public IntegerProperty tgRa11IntegerProperty() {
        return tgra11;
    }

    public void setTgra11(IntegerProperty tgra11) {
        this.tgra11 = tgra11;
    }

    public int getTgra11() {
        return tgra11.get();
    }
    public IntegerProperty diem1Property() {
        return diem1;
    }

    public void setDiem1(IntegerProperty diem1) {
        this.diem1 = diem1;
    }

    public int getDiem1() {
        return diem1.get();
    }

    public IntegerProperty diem2Property() {
        return diem2;
    }

    public void setDiem2(IntegerProperty diem2) {
        this.diem2 = diem2;
    }

    public int getDiem2() {
        return diem2.get();
    }

    public IntegerProperty diem3Property() {
        return diem3;
    }

    public void setDiem3(IntegerProperty diem3) {
        this.diem3 = diem3;
    }

    public int getDiem3() {
        return diem3.get();
    }

    public IntegerProperty diem4Property() {
        return diem4;
    }

    public void setDiem4(IntegerProperty diem4) {
        this.diem4 = diem4;
    }

    public int getDiem4() {
        return diem4.get();
    }

    public IntegerProperty diem5Property() {
        return diem5;
    }

    public void setDiem5(IntegerProperty diem5) {
        this.diem5 = diem5;
    }

    public int getDiem5() {
        return diem5.get();
    }

    public DoubleProperty loi1Property() {
        return loi1;
    }

    public void setLoi1(DoubleProperty loi1) {
        this.loi1 = loi1;
    }

    public double getLoi1() {
        return loi1.get();
    }

    public DoubleProperty loi2Property() {
        return loi2;
    }

    public void setLoi2(DoubleProperty loi2) {
        this.loi2 = loi2;
    }

    public double getLoi2() {
        return loi2.get();
    }

    public DoubleProperty loi3Property() {
        return loi3;
    }

    public void setLoi3(DoubleProperty loi3) {
        this.loi3 = loi3;
    }

    public double getLoi3() {
        return loi3.get();
    }

    public DoubleProperty loi4Property() {
        return loi4;
    }

    public void setLoi4(DoubleProperty loi4) {
        this.loi4 = loi4;
    }

    public double getLoi4() {
        return loi4.get();
    }

    public DoubleProperty loi5Property() {
        return loi5;
    }

    public void setLoi5(DoubleProperty loi5) {
        this.loi5 = loi5;
    }

    public double getLoi5() {
        return loi5.get();
    }
     public StringProperty tt1Property() {
        return tt1;
    }

    public void setTt1(StringProperty tt1) {
        this.tt1 = tt1;
    }

    public String getTt1() {
        return tt1.get();
    }
    public StringProperty tt2Property() {
        return tt2;
    }

    public void setTt2(StringProperty tt2) {
        this.tt2 = tt2;
    }

    public String getTt2() {
        return tt2.get();
    }
    public StringProperty tt3Property() {
        return tt3;
    }

    public void setTt3(StringProperty tt3) {
        this.tt3= tt3;
    }

    public String getTt3() {
        return tt3.get();
    }
    public StringProperty tt4Property() {
        return tt4;
    }

    public void setTt4(StringProperty tt4) {
        this.tt4 = tt4;
    }

    public String getTt4() {
        return tt4.get();
    }
    public StringProperty tt5Property() {
        return tt5;
    }

    public void setTt5(StringProperty tt5) {
        this.tt5 = tt5;
    }

    public String getTt5() {
        return tt5.get();
    }
}
