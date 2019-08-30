/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import static javax.swing.UIManager.getInt;

/**
 * FXML Controller class
 *
 * @author DLC
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label lblTen;
    @FXML
    private Label lblSolenh;
    @FXML
    private Label lblSolo;
    @FXML
    private Label lblDonhang;
    @FXML
    private Label lblKehoach;
    @FXML
    private Label lblSlvao;
    @FXML
    private Label lblSlhoanthanh;
    @FXML
    private Label lblLoivtu;
    @FXML
    private Label lblTileloi;
    @FXML
    private Label lblSodt;
    @FXML
    private Label lblSon;
    @FXML
    private PieChart pieTyle;
    @FXML
    private PieChart pieThongtin;
    @FXML
    private PieChart pieKehoach;
    @FXML
    private PieChart pieThoigian;
    @FXML
    private PieChart pieHopcach;
    @FXML
    private ProgressIndicator progthoiGian;
    @FXML
    private ProgressIndicator proghopCach;
    @FXML
    private AnchorPane pane;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    // final property a=new property();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
    public void getUser(String tenNv,String soDt,String soNhan){
        this.lblTen.setText(tenNv);
        this.lblSodt.setText(soDt);
      this.  lblSon.setText(soNhan);
    
    }
}
