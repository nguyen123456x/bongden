/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DLC
 */
public class ChooserController implements Initializable {

    @FXML
    private Button btnVao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void btnClick() throws IOException {
        Stage a = new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene= new Scene(root);
        String css=bongden.Bongden.class.getResource("app.css").toExternalForm();
        scene.getStylesheets().add(css);
        a.setScene(scene);
        a.show();
        
        
    }
    public void btnClick1() throws IOException {
        Stage a = new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("dangnhap.fxml"));
        Scene scene= new Scene(root);
        String css=bongden.Bongden.class.getResource("app.css").toExternalForm();
        scene.getStylesheets().add(css);
        a.setScene(scene);
        a.show();
        
    }
}
