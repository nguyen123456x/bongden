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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author DLC
 */
public class DoiMkController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private PasswordField psMkc;
    @FXML
    private PasswordField psMkm;
    @FXML
    private PasswordField psNl;
    @FXML
    private Label lblTt1;
    @FXML
    private ComboBox cbTen;
      private Connection con;
    private Statement st;
    private ResultSet rs;
    private ResultSet rs1;
    final ObservableList option=FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connection c = new connection();
        Connection connect = c.dbConnect();
            fillCombobox();
    }    
       public void clearPass() {
        psMkc.clear();
        psMkm.clear();
        psNl.clear();

    }

    public void changePass() {
        connection c = new connection();
        Connection connect = c.dbConnect();

        String mkc = psMkc.getText();
        String mkm = psMkm.getText();
        String nl = psNl.getText();
        try {
            st = connect.createStatement();
            if (mkm.equals(nl)) {
                st.executeUpdate("UPDATE `admin` SET mKhau='" + psMkm.getText() + "'WHERE tenTk='" + cbTen.getSelectionModel().getSelectedItem().toString() + "'");
                lblTt1.setText("Đổi mật khẩu thành công");
            }else{
              lblTt1.setText("nhập mật khẩu mới không trùng nhau");
            }

        } catch (Exception e) {
            System.out.println("error12412" + e);
        }

    }
    public void fillCombobox(){
         connection c = new connection();
        Connection connect = c.dbConnect();
        String querry="SELECT tenTk FROM `admin`";
        try {
            st=connect.createStatement();
            rs=st.executeQuery(querry);
            while (rs.next()) {                
                option.add(rs.getString("tenTk"));
            }
        } catch (Exception e) {
            System.out.println("error combo"+ e);
        }
        cbTen.setItems(option);
    
    }
}
