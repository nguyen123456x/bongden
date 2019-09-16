/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
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
import java.sql.Date;
import java.sql.ResultSetMetaData;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import static javax.swing.UIManager.getInt;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

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
    private TextField txtTgbd;
    @FXML
    private TextField txtTght;
    @FXML
    private TextField txtBq1;
    @FXML
    private TextField txtBq2;
    @FXML
    private TextField txtTd;
    @FXML
    private TextField txtTc;
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
    private ComboBox cbDh;
    @FXML
    private Button btnStop;
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
    private Label lbl1;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl4;
    @FXML
    private Label lbl5;
    @FXML
    private Label lblTgchay;
    @FXML
    private Label lblTgdung;
    @FXML
    private ProgressIndicator progthoiGian;
    @FXML
    private ProgressIndicator proghopCach;
    @FXML
    private ComboBox dh;
    @FXML
    private BarChart<String, Double> barbieudo;
    public ObservableList<dhpro> data;
    public ObservableList<spProperty> sp;
    public static int sec = 0;
    public static int min = 0;
    public static int hour = 0;
    public static int mil = 0;
    public static int sec1 = 0;
    public static int min1 = 0;
    public static int hour1 = 0;
    public static int mil1 = 0;
    public Timeline timeline;
    public static boolean state = true;
    public static boolean state1 = true;
    final ObservableList option = FXCollections.observableArrayList();

    private Connection con;
    private Statement st;
    private ResultSet rs;

    // final property a=new property();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connection c = new connection();
        Connection connect = c.dbConnect();
        data = FXCollections.observableArrayList();
        fillCombobox();

        cbDh.setOnAction(e -> {
            try {
                st = connect.createStatement();
                rs = st.executeQuery("SELECT *FROM`donhang` WHERE `tenDh`='" + cbDh.getSelectionModel().getSelectedItem() + "'");
                if (rs.next()) {
                    lblDonhang.setText(rs.getString("tenDh"));
                    lblKehoach.setText(String.valueOf(rs.getInt("keHoach")));
                    txtTgbd.setText(rs.getString("tgBatdau"));
                    txtTght.setText(rs.getString("tgHoanthanh"));
                    String tgbd = rs.getString("tgBatdau");
                    String tght = rs.getString("tgHoanthanh");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date1 = LocalDate.parse(tgbd, formatter);
                    LocalDate date2 = LocalDate.parse(tght, formatter);
                    long elapsedDays = ChronoUnit.DAYS.between(date1, date2);
                    ObservableList<PieChart.Data> list3 = FXCollections.observableArrayList(
                            new PieChart.Data("Hạn", elapsedDays),
                            new PieChart.Data("Tiến độ", elapsedDays - date1.getDayOfMonth())
                    );
                    pieThoigian.setData(list3);
                    for (final PieChart.Data data : pieThoigian.getData()) {
                        data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                Tooltip.install(data.getNode(), new Tooltip(data.getName() + " " + data.getPieValue()));
                            }
                        });
                    }
                    barbieudo.getData().clear();
                    pieHopcach.getData().clear();
                    pieKehoach.getData().clear();
                    pieThongtin.getData().clear();
                    pieTyle.getData().clear();
                }

            } catch (Exception a) {
                System.out.println("error combo" + a);
            }
        });
    }

    public void getUser(String tenNv, String soDt, String soNhan) {
        this.lblTen.setText(tenNv);
        this.lblSodt.setText(soDt);
        this.lblSon.setText(soNhan);

    }

    public void btnst() {
        connection c = new connection();
        Connection connect = c.dbConnect();
    }

    public void getdata() throws SQLException {
        connection c = new connection();
        Connection connect = c.dbConnect();
        lblSolenh.setText("15920");
        lblSolo.setText("1800958298A");
        lblSlvao.setText("1000");
        lblLoivtu.setText("0.5");
        txtBq1.setText("869.61");
        txtBq2.setText("1092");
        txtTd.setText("8071");
        start();

        double tiLe = 2.5;
        double a = 0;
        double b = 0;
        int i = 0;
        try {
            String sql1 = "SELECT* FROM `sanpham`";
            st = connect.createStatement();
            rs = st.executeQuery(sql1);
            while (rs.next()) {
                int id = rs.getInt("idSp");
                int diem1, diem2, diem3, diem4, diem5;
                double loi1, loi2, loi3, loi4, loi5;
                String tt1, tt2, tt3, tt4, tt5;
                LocalTime tgra1, tgra2, tgra3, tgra4, tgra5;
                tgra1 = LocalTime.now();
                loi1 = getloi();
                a = a + loi1;
                diem1 = getDiem(loi1, lbl1);
                tt1 = getTT(diem1);
                Thread.sleep(500);
                tgra2 = LocalTime.now();
                loi2 = getloi();
                b = b + loi2;
                diem2 = getDiem(loi2, lbl2);
                tt2 = getTT(diem2);
                Thread.sleep(500);
                tgra3 = LocalTime.now();
                loi3 = getloi();
                diem3 = getDiem(loi3, lbl3);
                tt3 = getTT(diem3);
                Thread.sleep(500);
                tgra4 = LocalTime.now();
                loi4 = getloi();
                diem4 = getDiem(loi4, lbl4);
                tt4 = getTT(diem4);
                Thread.sleep(500);
                tgra5 = LocalTime.now();
                loi5 = getloi();
                diem5 = getDiem(loi5, lbl5);
                tt5 = getTT(diem5);
                txtTc.setText(String.valueOf(diem1 + diem2 + diem3 + diem4 + diem5));
                String sql = "UPDATE  `sanpham` SET `tgRa1`='" + tgra1 + "', `loi1`='" + loi1 + "', `diem1`='" + diem1 + "', `trangThai1`='" + tt1 + "', `tgRa2`='" + tgra2 + "', `loi2`='" + loi2 + "', `diem2`='" + diem2 + "', `trangThai2`='" + tt2 + "'"
                        + ", `tgRa3`='" + tgra3 + "', `loi3`='" + loi3 + "', `diem3`='" + diem3 + "', `trangThai3`='" + tt3 + "', `tgRa4`='" + tgra4 + "', `loi4`='" + loi4 + "', `diem4`='" + diem4 + "', `trangThai4`='" + tt4 + "', `tgRa5`='" + tgra5 + "', `loi5`='" + loi5 + "', `diem5`='" + diem5 + "', `trangThai5`='" + tt5 + "' WHERE `idSp`='" + id + "'";
                st = connect.createStatement();
                st.executeUpdate(sql);
                i++;
                System.out.println("ag");}
                XYChart.Series<String, Double> series1 = new XYChart.Series<>();
                XYChart.Series<String, Double> series3 = new XYChart.Series<>();
                XYChart.Series<String, Double> series2 = new XYChart.Series<>();
                XYChart.Series<String, Double> series4 = new XYChart.Series<>();
                XYChart.Series<String, Double> series5 = new XYChart.Series<>();
                try {
                    String sql2 = "SELECT `loi1`,`tgRa1`,`loi2`,`tgRa2`,`loi3`,`tgRa3`,`loi4`,`tgRa4`,`loi5`,`tgRa5` FROM `sanpham`";
                    st = connect.createStatement();
                    rs = st.executeQuery(sql2);
                    while (rs.next()) {
                       double loi1 = rs.getDouble("loi1");
                        String tght1 = rs.getString("tgRa1");
                       double loi2 = rs.getDouble("loi2");
                        String tght2 = rs.getString("tgRa2");
                      double  loi3 = rs.getDouble("loi3");
                        String tght3 = rs.getString("tgRa3");
                      double  loi4 = rs.getDouble("loi4");
                        String tght4 = rs.getString("tgRa4");
                     double   loi5 = rs.getDouble("loi5");
                        String tght5 = rs.getString("tgRa5");
                        series1.getData().add(new XYChart.Data<>(tght1, loi1));
                        series2.getData().add(new XYChart.Data<>(tght2, loi2));
                        series3.getData().add(new XYChart.Data<>(tght3, loi3));
                        series4.getData().add(new XYChart.Data<>(tght4, loi4));
                        series5.getData().add(new XYChart.Data<>(tght5, loi5));
                        System.out.println("bongden.MainController.getChartData()");
                    }
                    barbieudo.getData().addAll(series1, series2, series3, series4, series5);
                }catch (Exception e) {
                }
            
            lblSlhoanthanh.setText(String.valueOf(i));
            double d = (a + b);
            ObservableList<PieChart.Data> list4 = FXCollections.observableArrayList(
                    new PieChart.Data("k1 lắp ráp ", a / d),
                    new PieChart.Data("k2 thử sáng 1", b / d)
            );
            pieTyle.setData(list4);
            for (final PieChart.Data data : pieTyle.getData()) {
                data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Tooltip.install(data.getNode(), new Tooltip(data.getName() + " " + data.getPieValue()));
                    }
                });
            }
            ObservableList<PieChart.Data> list2 = FXCollections.observableArrayList(
                    new PieChart.Data("Kế hoạch", Integer.valueOf(lblKehoach.getText())),
                    new PieChart.Data("Hoàn thành",i)
            );
            pieKehoach.setData(list2);

            for (final PieChart.Data data : pieKehoach.getData()) {
                data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Tooltip.install(data.getNode(), new Tooltip(data.getName() + " " + data.getPieValue()));
                    }
                });
            }
            lblTileloi.setText(String.valueOf(tiLe));
            ObservableList<PieChart.Data> list3 = FXCollections.observableArrayList(
                    new PieChart.Data("Hợp cách", 100 - tiLe),
                    new PieChart.Data("Còn lại", tiLe)
            );
            pieHopcach.setData(list3);

            for (final PieChart.Data data : pieHopcach.getData()) {
                data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Tooltip.install(data.getNode(), new Tooltip(data.getName() + " " + data.getPieValue()));
                    }
                });
            }
            ObservableList<PieChart.Data> list1 = FXCollections.observableArrayList(
                    new PieChart.Data("Lỗi vật tư ", 1),
                    new PieChart.Data("Lỗi máy", 199)
            );
            pieThongtin.setData(list1);
            for (final PieChart.Data data : pieThongtin.getData()) {
                data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Tooltip.install(data.getNode(), new Tooltip(data.getName() + " " + data.getPieValue()));
                    }
                });
            }

        } catch (Exception e) {
            System.out.println("error " + e);
        }
    }

    public void cancelQ() {
        try {
            if (st != null && !st.isClosed()) {
                st.cancel();

            }
            System.out.println("dong thanh cong");
        } catch (Exception e) {
            System.out.println("eq" + e);
        }

    }
//String sql = "UPDATE  `sanpham` SET `tgRa1`='" + tgra1 + "', `loi1`='" + loi1 + "', `diem1`, `trangThai1`, `tgRa2`, `loi2`, `diem2`, `trangThai2`, `tgRa3`, `loi3`, `diem3`, `trangThai3`, `tgRa4`, `loi4`, `diem4`, `trangThai4`, `tgRa5`, `loi5`, `diem5`, `trangThai5`) VALUES ( '" + tgra1 + "','" + loi1 + "','" + diem1 + "','" + tt1 + "','" + tgra2 + "','" + loi2 + "','" + diem2 + "','" + tt2 + "','" + tgra3 + "','" + loi3 + "','" + diem3 + "','" + tt3 + "'"
    //       + ",'" + tgra4 + "','" + loi4 + "','" + diem4 + "','" + tt4 + "','" + tgra5 + "','" + loi5 + "','" + diem5 + "','" + tt5 + "')";

    public int getDiem(double a, Label x) {
        int diem;
        if (a > 0 && a <= 0.13) {
            diem = 14;
            x.setTextFill(Color.GREENYELLOW);
        } else if (a > 0.14 && a <= 0.17) {
            diem = 13;
            x.setTextFill(Color.GREENYELLOW);
        } else if (a > 0.18 && a <= 0.22) {
            diem = 12;
            x.setTextFill(Color.GREENYELLOW);
        } else if (a > 0.23 && a <= 0.26) {
            diem = 11;
            x.setTextFill(Color.GREENYELLOW);
        } else if (a > 0.27 && a <= 0.3) {
            diem = 10;
            x.setTextFill(Color.YELLOW);
        } else if (a > 0.32 && a <= 0.32) {
            diem = 9;
            x.setTextFill(Color.YELLOW);
        } else if (a > 0.33 && a <= 0.35) {
            diem = 8;
            x.setTextFill(Color.YELLOW);
        } else if (a > 0.36 && a <= 0.4) {
            diem = 7;
            x.setTextFill(Color.RED);
        } else if (a > 0.41 && a <= 1) {
            diem = 0;
            x.setTextFill(Color.RED);
        } else {
            x.setTextFill(Color.RED);
            return diem = 0;
        }
        return diem;
    }

    public double getloi() {
        return (Math.random()) / 2;
    }

    public String getTT(int diem) {
        String tt;
        if (diem >= 7) {
            return tt = "Dat";
        } else {
            return tt = "Khong dat";
        }

    }

    public void fillCombobox() {
        try {
            connection c = new connection();
            Connection connect = c.dbConnect();
            st = connect.createStatement();
            rs = st.executeQuery("SELECT *FROM`donhang`");
            while (rs.next()) {
                int id = rs.getInt("idDh");
                String tenDh = rs.getString("tenDh");
                int keHoach = rs.getInt("keHoach");
                Date tgbd = rs.getDate("tgBatdau");
                Date tght = rs.getDate("tgHoanthanh");
                data.add(new dhpro(id, keHoach, tenDh, tgbd, tght));
                option.add(rs.getString("tenDh"));
            }
        } catch (Exception e) {
            System.out.println("error combo" + e);
        }
        cbDh.setItems(option);
    }

    public void btnClick2() throws IOException {
        Stage a = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("dh.fxml"));
        Scene scene = new Scene(root);
        String css = bongden.Bongden.class.getResource("app.css").toExternalForm();
        scene.getStylesheets().add(css);
        a.setScene(scene);
        a.show();

    }

    /* public void getChartData() {
        connection c = new connection();
        Connection connect = c.dbConnect();
        XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        XYChart.Series<String, Double> series3 = new XYChart.Series<>();
        XYChart.Series<String, Double> series2 = new XYChart.Series<>();
        XYChart.Series<String, Double> series4 = new XYChart.Series<>();
        XYChart.Series<String, Double> series5 = new XYChart.Series<>();
        try {
            String sql1 = "SELECT `loi1`,`tgRa1`,`loi2`,`tgRa2`,`loi3`,`tgRa3`,`loi4`,`tgRa4`,`loi5`,`tgRa5` FROM `sanpham`";
            st = connect.createStatement();
            rs = st.executeQuery(sql1);
            while (rs.next()) {
                Double loi1 = rs.getDouble("loi1");
                String tght1 = rs.getString("tgRa1");
                Double loi2 = rs.getDouble("loi2");
                String tght2 = rs.getString("tgRa2");
                Double loi3 = rs.getDouble("loi3");
                String tght3 = rs.getString("tgRa3");
                Double loi4 = rs.getDouble("loi4");
                String tght4 = rs.getString("tgRa4");
                Double loi5 = rs.getDouble("loi5");
                String tght5 = rs.getString("tgRa5");

                series1.getData().add(new XYChart.Data<>(tght1, loi1));
                series2.getData().add(new XYChart.Data<>(tght2, loi2));
                series3.getData().add(new XYChart.Data<>(tght3, loi3));
                series4.getData().add(new XYChart.Data<>(tght4, loi4));
                series5.getData().add(new XYChart.Data<>(tght5, loi5));
                System.out.println("bongden.MainController.getChartData()");
            }
            barbieudo.getData().addAll(series1, series2, series3, series4, series5);
        } catch (Exception e) {
        }
    }*/
    public void stop() {
        state = false;
        state1 = true;
        Thread t = new Thread() {

            public void run() {
                for (;;) {
                    if (state1 == true) {
                        try {
                            sleep(1);
                            if (mil1 > 1000) {
                                mil1 = 0;
                                sec1++;
                            }
                            if (sec1 > 60) {
                                sec1 = 0;
                                min1++;
                            }
                            if (min1 > 60) {
                                min1 = 0;
                                hour1++;
                            }
                            mil1++;
                            Platform.runLater(() -> {
                                lblTgdung.setText(hour1 + ":" + min1 + ":" + sec1);
                            }
                            );
                        } catch (Exception e) {
                        }

                    } else {
                        break;
                    }
                }
            }
        };
        t.start();
    }

    public void start() {
        state = true;
        state1 = false;
        Thread t = new Thread() {

            public void run() {
                for (;;) {
                    if (state == true) {
                        try {
                            sleep(1);
                            if (mil > 1000) {
                                mil = 0;
                                sec++;
                            }
                            if (sec > 60) {
                                sec = 0;
                                min++;
                            }
                            if (min > 60) {
                                min = 0;
                                hour++;
                            }
                            mil++;
                            Platform.runLater(() -> {
                                lblTgchay.setText(hour + ":" + min + ":" + sec);
                            }
                            );
                        } catch (Exception e) {
                        }

                    } else {
                        break;
                    }
                }
            }
        };
        t.start();
    }

    public void createCSV() {
        connection c = new connection();
        Connection connect = c.dbConnect();
        try {
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery("Select * from `sanpham`");
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("Excel Sheet");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell((short) 0).setCellValue("idSp");
            rowhead.createCell((short) 1).setCellValue("tgRa1");
            rowhead.createCell((short) 2).setCellValue("loi1");
            rowhead.createCell((short) 3).setCellValue("diem1");
            rowhead.createCell((short) 4).setCellValue("trangThai1");
            rowhead.createCell((short) 5).setCellValue("tgRa2");
            rowhead.createCell((short) 6).setCellValue("loi2");
            rowhead.createCell((short) 7).setCellValue("diem2");
            rowhead.createCell((short) 8).setCellValue("trangThai2");
            rowhead.createCell((short) 9).setCellValue("tgRa3");
            rowhead.createCell((short) 10).setCellValue("loi3");
            rowhead.createCell((short) 11).setCellValue("diem3");
            rowhead.createCell((short) 12).setCellValue("trangThai3");
            rowhead.createCell((short) 13).setCellValue("tgRa4");
            rowhead.createCell((short) 14).setCellValue("loi4");
            rowhead.createCell((short) 15).setCellValue("diem4");
            rowhead.createCell((short) 16).setCellValue("trangThai4");
            rowhead.createCell((short) 17).setCellValue("tgRa5");
            rowhead.createCell((short) 18).setCellValue("loi5");
            rowhead.createCell((short) 19).setCellValue("diem5");
            rowhead.createCell((short) 20).setCellValue("trangThai5");

            int index = 1;
            while (rs.next()) {
                HSSFRow row = sheet.createRow((short) index);
                row.createCell((short) 0).setCellValue(rs.getString("idSp"));
                row.createCell((short) 1).setCellValue(rs.getString("tgRa1"));
                row.createCell((short) 2).setCellValue(rs.getString("loi1"));
                row.createCell((short) 3).setCellValue(rs.getString("diem1"));
                row.createCell((short) 4).setCellValue(rs.getString("trangThai1"));
                row.createCell((short) 5).setCellValue(rs.getString("tgRa2"));
                row.createCell((short) 6).setCellValue(rs.getString("loi2"));
                row.createCell((short) 7).setCellValue(rs.getString("diem2"));
                row.createCell((short) 8).setCellValue(rs.getString("trangThai2"));
                row.createCell((short) 9).setCellValue(rs.getString("tgRa3"));
                row.createCell((short) 10).setCellValue(rs.getString("loi3"));
                row.createCell((short) 11).setCellValue(rs.getString("diem3"));
                row.createCell((short) 12).setCellValue(rs.getString("trangThai3"));
                row.createCell((short) 13).setCellValue(rs.getString("tgRa4"));
                row.createCell((short) 14).setCellValue(rs.getString("loi4"));
                row.createCell((short) 15).setCellValue(rs.getString("diem4"));
                row.createCell((short) 16).setCellValue(rs.getString("trangThai4"));
                row.createCell((short) 17).setCellValue(rs.getString("tgRa5"));
                row.createCell((short) 18).setCellValue(rs.getString("loi5"));
                row.createCell((short) 19).setCellValue(rs.getString("diem5"));
                row.createCell((short) 20).setCellValue(rs.getString("trangThai5"));
                index++;
            }
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\DLC\\Desktop\\sanpham.xls");
            wb.write(fileOut);
            fileOut.close();
            System.out.println("Data is saved in excel file.");
            rs.close();
            connect.close();
        } catch (Exception e) {
        }

    }

}
