/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bongden;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DLC
 */
public class DateConverter {

    public static Date convert(String date) {
        try {
            SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
            return sp.parse(date);
        } catch (Exception e) {
            return null;
        }
    }
}
