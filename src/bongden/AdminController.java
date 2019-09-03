/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;

import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author DLC
 */
public class AdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtTt;
    @FXML
    private TextField txtTsdt;
    @FXML
    private TextField txtTn;
     @FXML
    private TextField txtTk;
    private TextField txtMk;
    @FXML
    private TextField txtId;
    private PasswordField psMkc;
    private PasswordField psMkm;
    @FXML
    private TableView<User> tabShow;
    @FXML
    public TableColumn<User, Integer> colId;
    @FXML
    public TableColumn<User, String> colTenNv;
    @FXML
    public TableColumn<User, String> colTk;
    @FXML
    public TableColumn<User, String> colMk;
    @FXML
    public TableColumn<User, Integer> colSodt;
    @FXML
    public TableColumn<User, Integer> colSoNhan;
    private PasswordField psNl;
    @FXML
    private Label lblTt;
    @FXML
    private Label lblTen;
    private Label lblTt1;
    @FXML
    private Label lblSdt;
    @FXML
    private Label lblSn;
    private Connection con;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    public ObservableList<User> data;
    @FXML
    private Label lblTen1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connection c = new connection();
        Connection connect = c.dbConnect();
        data = FXCollections.observableArrayList();
        setCelltable();
        loadData();
        setCellValueFromTable();
    }

    @FXML
    public void ThemnvClick() {
        connection c = new connection();
        Connection connect = c.dbConnect();

        try {
            String sql = "INSERT INTO `nguoivan`(`tenNv`, `soDt`, `soNhan`,`tenTk`,`matKhau`) VALUES ('" + txtTt.getText() + "','" + txtTsdt.getText() + "','" + txtTn.getText() + "','" + txtTk.getText() + "','" + txtMk.getText() + "')";
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

    public void setCelltable() {
        try {
            colId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
            colTenNv.setCellValueFactory(new PropertyValueFactory<User, String>("tenNv"));
            colSodt.setCellValueFactory(new PropertyValueFactory<User, Integer>("soDt"));
            colSoNhan.setCellValueFactory(new PropertyValueFactory<User, Integer>("soNhan"));
            colTk.setCellValueFactory(new PropertyValueFactory<User, String>("tenTk"));
            colMk.setCellValueFactory(new PropertyValueFactory<User, String>("matKhau"));
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
            rs = st.executeQuery("SELECT*FROM`nguoivan`");
            while (rs.next()) {
                int id = rs.getInt("idNv");
                int sodt = rs.getInt("soDt");
                int sonhan = rs.getInt("soNhan");
                String tennv = rs.getString("tenNv");
                String tentk=rs.getString("tenTk");
                String  matkhau=rs.getString("matKhau");
                data.add(new User(id, sodt, sonhan, tennv, tentk, matkhau));
            }

        } catch (Exception e) {
            System.out.println("loi" + e);
        }
        tabShow.setItems(data);

    }

    public void deleteData(ActionEvent event) {
        String sql = "DELETE FROM `nguoivan` WHERE idNv='" + txtId.getText() + "'";
        try {
            connection c = new connection();
            Connection connect = c.dbConnect();
            st = connect.createStatement();
            st.executeUpdate(sql);
            lblTt.setText("Xóa thành công");
            loadData();
            clearTxt();

        } catch (Exception e) {
        }

    }

    @FXML
    public void updateData(ActionEvent event) {
        try {
            connection c = new connection();
            Connection connect = c.dbConnect();
            String sql = "UPDATE `nguoivan` SET tenNv='" + txtTt.getText() + "', soDt='" + txtTsdt.getText() + "',soNhan='" + txtTn.getText() + "',tenTk='" + txtTk.getText() + "',matKhau='" + txtMk.getText() + "'WHERE idNv='" + txtId.getText() + "'";
            st = connect.createStatement();
            st.executeUpdate(sql);
            if (st.executeUpdate(sql) == 1) {
                lblTt.setText("Sửa thành công");
                setCelltable();
                loadData();
            }
        } catch (Exception e) {
            System.out.println("error 223" + e);
        }

    }

    public void setCellValueFromTable() {
        tabShow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                User us = tabShow.getItems().get(tabShow.getSelectionModel().getSelectedIndex());
                txtTt.setText(us.getTenNv());
                txtTsdt.setText(String.valueOf(us.getSoDt()));
                txtTn.setText(String.valueOf(us.getSoNhan()));
                txtId.setText(String.valueOf(us.getId()));
                txtTk.setText(us.getTenTk());
                txtMk.setText(us.getMatKhau());
            }

        });

    }

    @FXML
    public void clearTxt() {
        txtTn.clear();
        txtTsdt.clear();
        txtId.clear();
        txtTt.clear();
        txtMk.clear();
        txtTk.clear();

    }
     public void clearPass() {
        psMkc.clear();
        psMkm.clear();
        psNl.clear();

    }

    public void changePass() {
        connection c = new connection();
        Connection connect = c.dbConnect();
        
        String mkc=psMkc.getText();
        String mkm=psMkm.getText();
        String nl=psNl.getText();
        try {
            st=connect.createStatement();
             if(mkm.equals(nl)){
                 st.executeUpdate("UPDATE `admin` SET mKhau='" + psMkm.getText() + "'WHERE idAd=?");
                 lblTt1.setText("Đổi mật khẩu thành công");
        }

        } catch (Exception e) {
            System.out.println("error12412"+e);
        }
       
    }
}
