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
public class User {

    public StringProperty tenNv, tenTk, matKhau;
    public IntegerProperty id, soNhan, soDt;

    public User(int id, int soDt, int soNhan, String tenNv, String tenTk, String matKhau) {
        this.id = new SimpleIntegerProperty(id);
        this.soDt = new SimpleIntegerProperty(soDt);
        this.soNhan = new SimpleIntegerProperty(soNhan);
        this.tenNv = new SimpleStringProperty(tenNv);
        this.tenTk = new SimpleStringProperty(tenTk);
        this.matKhau = new SimpleStringProperty(matKhau);
    }

    public StringProperty TenNvProperty() {
        return tenNv;
    }
 public StringProperty TenTkProperty() {
        return tenTk;
    }
  public StringProperty MatKhauProperty() {
        return matKhau;
    }
    public IntegerProperty iDProperty() {
        return id;
    }

    public IntegerProperty SoNhanProperty() {
        return soNhan;
    }

    public IntegerProperty SoDtProperty() {
        return soDt;
    }

    public String getTenNv() {
        return tenNv.get();
    }
     public String getTenTk() {
        return tenTk.get();
    }
      public String getMatKhau() {
        return matKhau.get();
    }
    public int getId() {
        return id.get();
    }

    public int getSoDt() {
        return soDt.get();
    }

    public int getSoNhan() {
        return soNhan.get();
    }

    public void setTenNv(String value) {
        tenNv.set(value);
    }
    public void setTenTk(String value) {
        tenTk.set(value);
    }
    public void setMatKhau(String value) {
        matKhau.set(value);
    }
    public void setSodt(int value) {
        soDt.set(value);
    }

    public void setSoNhanh(int value) {
        soNhan.set(value);
    }

    public void setId(int value) {
        id.set(value);
    }
}
