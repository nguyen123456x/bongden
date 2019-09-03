/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;

import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author DLC
 */
public class DhController implements Initializable {

    @FXML
    private Label lblTen;
    @FXML
    private TextField txtTdh;
    @FXML
    private Label lblSdt;
    @FXML
    private Label lblSn;
    @FXML
    private TextField txtKh;
    @FXML
    private Label lblTt;
    @FXML
    private TableView<dhpro> tabShow;
    @FXML
    private TableColumn<dhpro, Integer> colId;
    @FXML
    private TableColumn<dhpro, String> colTdh;
    @FXML
    private TableColumn<dhpro, Integer> colKh;
    @FXML
    private TableColumn<dhpro, LocalDate> colBd;
    @FXML
    private TableColumn<dhpro, LocalDate> colHt;
    @FXML
    private TextField txtId;
    @FXML
    private Label lblTen1;
    @FXML
    private DatePicker dBd;
    @FXML
    private DatePicker dHt;
    private Connection con;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    public ObservableList<dhpro> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connection c = new connection();
        Connection connect = c.dbConnect();
        data = FXCollections.observableArrayList();
        setCelltable();
        loadData();
        setCellValueFromTable();
    }

    @FXML
    private void ThemnvClick(ActionEvent event) {
        connection c = new connection();
        Connection connect = c.dbConnect();
        try {
            LocalDate a = dBd.getValue();
            LocalDate b = dHt.getValue();

            String sql = "INSERT INTO `donhang`(`idDh`, `tenDh`, `keHoach`,`tgBatdau`,`tgHoanthanh`) VALUES ('" + txtId.getText() + "','" + txtTdh.getText() + "','" + txtKh.getText() + "','" + a + "','" + b + "')";
            st = connect.createStatement();
            st.executeUpdate(sql);
            lblTt.setText("Thêm thành công");
            System.out.println("ag");
            setCelltable();
            loadData();

        } catch (Exception e) {
            lblTt.setText("Nhập đầy đủ thông tin");
            System.out.println("error " + e);

        }

    }

    public DatePicker getdBd() {
        return dBd;
    }

    public void setdBd(DatePicker dBd) {
        this.dBd = dBd;
    }

    public DatePicker getdHt() {
        return dHt;
    }

    public void setdHt(DatePicker dHt) {
        this.dHt = dHt;
    }

    @FXML
    private void clearTxt(ActionEvent event) {
    }

    @FXML
    private void deleteData(ActionEvent event) {
        Date a = new Date(2015, 10, 2);
        Date b = new Date(2015, 12, 2);
        int id = 7;
        String tendh = "XJ5K";
        int keh = 50000;
        connection c = new connection();
        Connection connect = c.dbConnect();
        try {

            String sql = "INSERT INTO `donhang`(`idDh`, `tenDh`, `keHoach`,`tgBatdau`,`tgHoanthanh`) VALUES ('" + id + "','" + tendh + "','" + keh + "','" + a + "','" + b + "')";
            st = connect.createStatement();
            st.executeUpdate(sql);
            lblTt.setText("Thêm thành công");
            System.out.println("ag");
            setCelltable();
            loadData();

        } catch (Exception e) {
            lblTt.setText("Nhập đầy đủ thông tin");
            System.out.println("error " + e);

        }

    }

    @FXML
    private void updateData(ActionEvent event) {

    }

    public void setCelltable() {

        try {
            colId.setCellValueFactory(new PropertyValueFactory<dhpro, Integer>("id"));
            colTdh.setCellValueFactory(new PropertyValueFactory<dhpro, String>("tenDh"));
            colKh.setCellValueFactory(new PropertyValueFactory<dhpro, Integer>("kehoach"));
            colBd.setCellValueFactory(new PropertyValueFactory<dhpro, LocalDate>("tgBd"));
            colHt.setCellValueFactory(new PropertyValueFactory<dhpro, LocalDate>("tgHt"));
            tabShow.setItems(data);
        } catch (Exception e) {

            System.out.println("loi1256" + e);
        }
    }

    public void loadData() {
        data.clear();
        try {
            connection c = new connection();
            Connection connect = c.dbConnect();
            st = connect.createStatement();
            rs = st.executeQuery("SELECT *FROM`donhang`");
            while (rs.next()) {
                int id = rs.getInt("idDh");
                String tenDh = rs.getString("tenDh");
                int keHoach = rs.getInt("keHoach");
                Date tgBd = rs.getDate("tgBatdau");
                Date tgHt = rs.getDate("tgHoanthanh");
                data.add(new dhpro(id, keHoach, tenDh, tgBd, tgHt));
            }

        } catch (Exception e) {
            System.out.println("loi" + e);
        }
        tabShow.setItems(data);

    }

    public void setCellValueFromTable() {
        tabShow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                dhpro us = tabShow.getItems().get(tabShow.getSelectionModel().getSelectedIndex());
                txtTdh.setText(us.getTenDh());
                txtId.setText(String.valueOf(us.getId()));
                txtKh.setText(String.valueOf(us.getKehoach()));
                ((TextField) dBd.getEditor()).setText(String.valueOf(us.getTgBd()));
                ((TextField) dHt.getEditor()).setText(String.valueOf(us.getTgHt()));
            }
        });
    }

}
