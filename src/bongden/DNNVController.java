/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;

import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DLC
 *
 */
public class DNNVController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    public TextField txtTk;
    @FXML
    public PasswordField psMk;
    @FXML
    public Label lblTt;
    private Connection con;
    private Statement st;
    private ResultSet rs;

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
            String querry = "SELECT `tenNv`, `soDt`, `soNhan` FROM `nguoivan` WHERE tenTk='" + user + "' AND matKhau='" + pass + "'";
            st = connect.createStatement();
            rs = st.executeQuery(querry);
            if (rs.next()) {
                System.out.println("1");
                String tenNv = rs.getString(("tenNv"));
                String soDt = rs.getString(("soDt"));
                String soNhan = rs.getString(("soNhan"));
                FXMLLoader loader= new FXMLLoader();
                loader.setLocation(getClass().getResource("main.fxml"));
                try {
                    loader.load();
                } catch (Exception e) {
                    System.out.println("error loader"+e);
                }
                MainController mc= loader.getController();
                mc.getUser(tenNv, soDt, soNhan);
                System.out.println("bongden.DNNVController.dangNhap()222");
                Parent p = loader.getRoot();
                Stage a= new Stage();
                a.setScene(new Scene(p));
                a.show();

            } else {
                lblTt.setText("Sai tên đăng nhập hoặc mật khẩu");
            }

        } catch (Exception e) {
            System.out.println("erw1" +e);
        }
    }
}
