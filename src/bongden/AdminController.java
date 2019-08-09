/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TextField txtSt;
    @FXML
    private TextField txtSsdt;
    @FXML
    private TextField txtSn;
    @FXML
    private PasswordField psMkc;
    @FXML
    private PasswordField psMkm;
    @FXML
    private TableView<User> tabShow;
    @FXML
    private TableColumn<User, Integer> colId;
    @FXML
    private TableColumn<User, String> colTenNv;
    @FXML
    private TableColumn<User, Integer> colSodt;
    @FXML
    private TableColumn<User, Integer> colSoNhan;
    @FXML
    private PasswordField psNl;
    @FXML
    private Label lblTt;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ObservableList<User> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connection c = new connection();
        Connection connect = c.dbConnect();
        data = FXCollections.observableArrayList();
        setCelltable();
        loadData();
    }

    public void ThemnvClick() {
        connection c = new connection();
        Connection connect = c.dbConnect();

        try {
            if (txtTt.getText() == " " || txtTsdt.getText() == " " || txtTn.getText() == " ") {
                lblTt.setText("Vui lòng điền đủ thông tin");
            } else {
                String sql = "INSERT INTO `nguoivan`(`tenNv`, `soDt`, `soNhan`) VALUES ('" + txtTt.getText() + "','" + txtTsdt.getText() + "','" + txtTn.getText() + "')";
                st = connect.createStatement();
                st.executeUpdate(sql);
                lblTt.setText("Thêm thành công");
                System.out.println("ag");
            }

        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }

    private void setCelltable() {

        colId.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
        colTenNv.setCellValueFactory(new PropertyValueFactory<User, String>("tenNv"));
        colSodt.setCellValueFactory(new PropertyValueFactory<User, Integer>("soDt"));
        colSoNhan.setCellValueFactory(new PropertyValueFactory<User, Integer>("soNhan"));
        tabShow.setItems(null);
        tabShow.setItems(data);

    }

    private void loadData() {

        try {
            connection c = new connection();
            Connection connect = c.dbConnect();
            st=connect.createStatement();
            rs=st.executeQuery("SELECT*FROM`nguoivan`");
            while (rs.next()) {
                int id=rs.getInt("id");
                int sodt=rs.getInt("soDt");
                int sonhan=rs.getInt("soNhan");
                String tennv=rs.getString("tenNv");
                data.add(new User(id, sodt, sonhan, tennv));
            }

        } catch (Exception e) {
            System.out.println("loi" + e);
        }
        tabShow.setItems(data);

    }
}
