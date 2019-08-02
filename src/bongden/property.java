/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.*;

/**
 *
 * @author DLC
 */
public class property {
    private DoubleProperty keHoach;
    private DoubleProperty thoiGian;
    private DoubleProperty hopCach;

    public double getKeHoach() {
        if(keHoach!= null)
        return keHoach.get();
        return 0;
    }

    public double getThoiGian() {
        if(thoiGian!= null)
        return thoiGian.get();
        return 0;
    }

    public double getHopCach() {
        if(hopCach!= null)
        return hopCach.get();
        return 0;
    }

    public final void setKeHoach(double keHoach) {
        this.keHoachProperty().set(keHoach);
    }
    public final DoubleProperty keHoachProperty(){
        if (keHoach==null){
        keHoach=new SimpleDoubleProperty(0);
        }
        return keHoach;
    }
     public final DoubleProperty thoiGianProperty(){
        if (thoiGian==null){
        thoiGian=new SimpleDoubleProperty(0);
        }
        return thoiGian;
    }
     public final DoubleProperty hopCachProperty(){
        if (hopCach==null){
        hopCach=new SimpleDoubleProperty(0);
        }
        return hopCach;
    }
    public void setThoiGian(double thoiGian) {
        this.thoiGianProperty().set(thoiGian);
    }

    public void setHopCach(double hopCach) {
        this.hopCachProperty().set(hopCach);
    }
    
}
