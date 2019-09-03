/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;

/**
 *
 * @author DLC
 */
public class dhpro {
    public Date tgBd,tgHt;
    public IntegerProperty kehoach,id;
    public StringProperty tenDh;
    public dhpro(int id, int kehoach, String tenDh, Date tgBd, Date tgHt) {
        this.id = new SimpleIntegerProperty(id);
        this.kehoach = new SimpleIntegerProperty(kehoach);
        this.tgBd= tgBd;
        this.tgHt=tgHt;
        this.tenDh= new SimpleStringProperty(tenDh);
    }

    public Date getTgBd() {
        return tgBd;
    }

    public void setTgBd(Date tgBd) {
        this.tgBd = tgBd;
    }

    public Date getTgHt() {
        return tgHt;
    }

    public void setTgHt(Date tgHt) {
        this.tgHt = tgHt;
    }

    public IntegerProperty KeHoachProperty() {
        return kehoach;
    }

    public void setKehoach(IntegerProperty kehoach) {
        this.kehoach = kehoach;
    }
    public int getKehoach(){
    return kehoach.get();
    }

    public IntegerProperty IdProperty() {
        return id;
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }
     public int getId(){
    return id.get();
    }

    public StringProperty TenDhProperty() {
        return tenDh;
    }

    public void setTenDh(StringProperty tenDh) {
        this.tenDh = tenDh;
    }
     public String getTenDh(){
    return tenDh.get();
    }
}
