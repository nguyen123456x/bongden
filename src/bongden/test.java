/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DLC
 */
public class test { 
private Connection con;
    private Statement st;
    private ResultSet rs;
    public void button(){
    try {
            connection c = new connection();
            Connection connect = c.dbConnect();
            st=con.createStatement();
            rs=st.executeQuery("SELECT*FROM`nguoivan`");
            while (rs.next()) {
                String id=rs.getString("id");
                String tennv=rs.getString("tenNv");
                String sodt=rs.getString(String.valueOf("soDt"));
                String sonhan=rs.getString(String.valueOf("soNhan"));
                System.out.println(sodt+sonhan+tennv);
            }

        } catch (Exception e) {
            System.out.println("loi cai lon me maay " + e);
        }
    }
}
