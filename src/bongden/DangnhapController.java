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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DLC
 */
public class DangnhapController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtTk;
    @FXML
    private PasswordField psMk;
    @FXML
    private Button btnDangnhap;
    @FXML
    private Button btnDoiMk;
    @FXML
    private Label lblTrangthai;
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ResultSet rs1;

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void dangNhap() {
        connection c = new connection();
        Connection connect = c.dbConnect();
        String user;
        String pass;
        try {
            user = txtTk.getText();
            pass = psMk.getText();
            String querry = "SELECT* FROM `admin` WHERE tenTk='" + user + "' AND mKhau='" + pass + "'";
            st = connect.createStatement();
            rs = st.executeQuery(querry);
            if (rs.next()) {
                System.out.println("1");
                Stage a = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
                Scene scene = new Scene(root);
                String css = bongden.Bongden.class.getResource("app.css").toExternalForm();
                scene.getStylesheets().add(css);
                a.setScene(scene);
                a.show();

            } else {
                lblTrangthai.setText("Sai tên đăng nhập hoặc mật khẩu");
            }
           
        } catch (Exception e) {
            System.out.println("error " + e);
        }

    }
}
