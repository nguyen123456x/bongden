/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author DLC
 */
class User {

    private final StringProperty tenNv;
    private final IntegerProperty id, soNhan, soDt;

    public User(int id, int soDt, int soNhan, String tenNv) {
        this.id = new SimpleIntegerProperty(id);
        this.soDt = new SimpleIntegerProperty(soDt);
        this.soNhan = new SimpleIntegerProperty(soNhan);
        this.tenNv = new SimpleStringProperty(tenNv);
    }

    public StringProperty TenNvProperty() {
        return tenNv;
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public IntegerProperty SoNhanProperty() {
        return soNhan;
    }

    public IntegerProperty SoDtProperty() {
        return soDt;
    }

    public String getTenNv(){
        return tenNv.get();
    
    }
    public int getId(){
        return id.get();
    }
     public int getSoDt(){
        return soDt.get();
    }
      public int getSoNhan(){
        return soNhan.get();
    }
    public void setTenNv(String v) {
        tenNv.setValue(v);
    }

    public void setId(String v) {
        tenNv.setValue(v);
    }

    public void setSoNhan(String v) {
        tenNv.setValue(v);
    }

    public void setSoDt(String v) {
        tenNv.setValue(v);
    }
    
}