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
    private Connection con;
    private Statement st;
    private ResultSet rs;
   // final property a=new property();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       

}
    
        public void insertData(ActionEvent event) throws SQLException{
            if(rs==null||!rs.next()){
        try {
            connection c= new connection();
            Connection connect=c.dbConnect();
          //  String querry="INSERT INTO `bongden1`(`soLenh`, `soLo`, `donHang`, `keHoach`, `sLvao`, `sLhoanthanh`, `loiVtu`, `tiLeloi`) VALUES ('142412','ACJEM2H','KHSX','24124','5553','2777','0.2','0.1')";
           // st=connect.createStatement();
          //  st.executeQuery(querry);
            String querry1="SELECT* FROM `bongden1`";
            st=connect.createStatement();
            rs=st.executeQuery(querry1);
            if(rs.next()){
                String soLenh= rs.getString(String.valueOf("soLenh"));
                String soLo= rs.getString(("soLo"));
                String donHang= rs.getString(("donHang"));
                String keHoach= rs.getString(String.valueOf("keHoach"));
                String sLvao= rs.getString(String.valueOf("sLvao"));
                String sLhoanthanh= rs.getString(String.valueOf("sLhoanthanh"));
                String loiVtu= rs.getString(String.valueOf("loiVtu"));
                String tiLeloi= rs.getString(String.valueOf("tiLeloi"));
                int keH=rs.getInt("keHoach");
                int sLht=rs.getInt("sLhoanthanh");
                double tiLe=rs.getDouble("tiLeloi");
                lblSolenh.setText(soLenh);
                lblSolo.setText(soLo);
                lblDonhang.setText(donHang);
                lblKehoach.setText(keHoach);
                lblLoivtu.setText(loiVtu);
                lblSlvao.setText(sLvao);
                lblSlhoanthanh.setText(sLhoanthanh);
                lblTileloi.setText(tiLeloi);
                  ObservableList<PieChart.Data> list2=FXCollections.observableArrayList(
         new PieChart.Data("Kế hoạch",sLht ),
         new PieChart.Data("Còn lại", keH-sLht)
        );
        pieKehoach.setData(list2);
       
        for(final PieChart.Data data : pieKehoach.getData()){
        data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
        Tooltip.install(data.getNode(), new Tooltip(data.getName()+" "+data.getPieValue()));
        }
    });
}
                  ObservableList<PieChart.Data> list3=FXCollections.observableArrayList(
         new PieChart.Data("Hợp cách",100-tiLe ),
         new PieChart.Data("Còn lại", tiLe)
        );
        pieHopcach.setData(list3);
       
        for(final PieChart.Data data : pieHopcach.getData()){
        data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
        Tooltip.install(data.getNode(), new Tooltip(data.getName()+" "+data.getPieValue()));
        }
    });
}
            }
        } catch (Exception e) {
            System.out.println("error123"+e);
        }
        ObservableList<PieChart.Data> list=FXCollections.observableArrayList(
         new PieChart.Data("k1 lắp ráp ", 18),
         new PieChart.Data("k2 thử sáng 1", 152)
        );
        pieTyle.setData(list);
       
        for(final PieChart.Data data : pieTyle.getData()){
        data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
        Tooltip.install(data.getNode(), new Tooltip(data.getName()+" "+data.getPieValue()));
        }
    });
}
        ObservableList<PieChart.Data> list1=FXCollections.observableArrayList(
         new PieChart.Data("Lỗi vật tư ", 60),
         new PieChart.Data("Lỗi máy", 163)
        );
        pieThongtin.setData(list1);
       
        for(final PieChart.Data data : pieThongtin.getData()){
        data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
        Tooltip.install(data.getNode(), new Tooltip(data.getName()+" "+data.getPieValue()));
        }
    });
}
    }
            else{
             String soLenh= rs.getString(String.valueOf("soLenh"));
                String soLo= rs.getString(("soLo"));
                String donHang= rs.getString(("donHang"));
                String keHoach= rs.getString(String.valueOf("keHoach"));
                String sLvao= rs.getString(String.valueOf("sLvao"));
                String sLhoanthanh= rs.getString(String.valueOf("sLhoanthanh"));
                String loiVtu= rs.getString(String.valueOf("loiVtu"));
                String tiLeloi= rs.getString(String.valueOf("tiLeloi"));
                int keH=rs.getInt("keHoach");
                int sLht=rs.getInt("sLhoanthanh");
                double tiLe=rs.getDouble("tiLeloi");
                lblSolenh.setText(soLenh);
                lblSolo.setText(soLo);
                lblDonhang.setText(donHang);
                lblKehoach.setText(keHoach);
                lblLoivtu.setText(loiVtu);
                lblSlvao.setText(sLvao);
                lblSlhoanthanh.setText(sLhoanthanh);
                lblTileloi.setText(tiLeloi);
                          ObservableList<PieChart.Data> list2=FXCollections.observableArrayList(
         new PieChart.Data("Kế hoạch",sLht ),
         new PieChart.Data("Còn lại", keH-sLht)
        );
        pieKehoach.setData(list2);
       
        for(final PieChart.Data data : pieKehoach.getData()){
        data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
        Tooltip.install(data.getNode(), new Tooltip(data.getName()+" "+data.getPieValue()));
        }
    });
}
        
        ObservableList<PieChart.Data> list=FXCollections.observableArrayList(
         new PieChart.Data("k1 lắp ráp ", 18),
         new PieChart.Data("k2 thử sáng 1", 152)
        );
        pieTyle.setData(list);
       
        for(final PieChart.Data data : pieTyle.getData()){
        data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
        Tooltip.install(data.getNode(), new Tooltip(data.getName()+" "+data.getPieValue()));
        }
    });
}
        ObservableList<PieChart.Data> list1=FXCollections.observableArrayList(
         new PieChart.Data("Lỗi vật tư ", 60),
         new PieChart.Data("Lỗi máy", 163)
        );
        pieThongtin.setData(list1);
       
        for(final PieChart.Data data : pieThongtin.getData()){
        data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
        Tooltip.install(data.getNode(), new Tooltip(data.getName()+" "+data.getPieValue()));
        }
    });
}
            ObservableList<PieChart.Data> list3=FXCollections.observableArrayList(
         new PieChart.Data("Hợp cách",100-tiLe ),
         new PieChart.Data("Còn lại", tiLe)
        );
        pieHopcach.setData(list3);
       
        for(final PieChart.Data data : pieHopcach.getData()){
        data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
        Tooltip.install(data.getNode(), new Tooltip(data.getName()+" "+data.getPieValue()));
        }
    });
}
            }
        }
}