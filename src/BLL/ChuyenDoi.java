/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import GUI.ThongBaoCanhBao;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class ChuyenDoi {
    static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    //Hàm chuyển String -> Date
    public static Date GetDate(String ngay){
        try {
           return df.parse(ngay); 
        } catch (ParseException e) {
            
        }
        return null;
    }
    
     static DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
    //Hàm chuyển String -> Date
    public static Date GetDate2(String ngay){
        try {
           return df2.parse(ngay); 
        } catch (ParseException e) {
            
        }
        return null;
    }
    
    
    //Hàm chuyển Date --> String
    public static String GetNgay(Date date){
        return df.format(date);
    }
    
     public static String GetNgay2(Date date2){
        return df2.format(date2);
    }
    
    
    
    public static String DinhDangTien(double so){
        return NumberFormat.getNumberInstance().format(so);
    }
    public static double ChuyenSangSo(String tien){
        try {
            return NumberFormat.getNumberInstance().parse(tien).doubleValue();
        } catch (ParseException ex) {
            
            return 0;
        }
    }
    public static String doubleToString(double so){
        return NumberFormat.getNumberInstance().format(so);
    }
    public static double ChuyenTien(String tien){
        try {
            return NumberFormat.getNumberInstance().parse(tien).doubleValue();
        } catch (ParseException ex) {
            if (tien.equals("")) {
                tien = "0";
            }
        }
        return 0 ;
    }
     public static int ChuyenSo(String so){
        try {
            return NumberFormat.getNumberInstance().parse(so).intValue();
        } catch (ParseException ex) {
            if (so.equals("")) {
                so = "0";
            }
        }
        return 0 ;
    }
     public static String DinhDangSo(int so){
        return NumberFormat.getNumberInstance().format(so);
    }
    public static String DinhDangNgay(Date date) {
        return df.format(date);
    }
}

