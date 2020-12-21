/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOChamCong;
import static GUI.pnlnhanvien.countCC;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author KMB1604
 */
public class DAOChamCong {
    
    
    
    
      public static ResultSet LayLichSuChamCong(String idnguoidung, int trang) {

        String query = "SELECT * FROM chamcong where idnguoidung = '" + idnguoidung + "' ORDER BY idchamcong DESC limit "+trang+",7";
        ResultSet rs = DBConection.GetData(query);
        return rs;

    }
     public static ResultSet CountChamCong(int idnguoidung) {
        try {
         String query = "Select count(*) from chamcong where idnguoidung = '" + idnguoidung + "'";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
                countCC = rs.getInt(1);
            }
            System.out.println(countCC);
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
       public static ResultSet LayThongTinCaChamCong(int idnguoidung) {

        String query = "SELECT chamcong.socachamcong,nguoidung.tennguoidung FROM `chamcong` INNER JOIN nguoidung on nguoidung.idnguoidung = chamcong.idnguoidung WHERE ngaychamcong = CURDATE() and nguoidung.idnguoidung = '"+idnguoidung+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;

    }
      
      
       public static ResultSet KiemTraNgayChamCong(String ngaychamcong, int idnguoidung) {

        String query = "SELECT ngaychamcong FROM chamcong where ngaychamcong = '" + ngaychamcong + "' and idnguoidung = '" + idnguoidung + "'";
        ResultSet rs = DBConection.GetData(query);
           System.out.println(query);
        return rs;

    }
      
      
      public static int ThemChamCong(DTOChamCong chamcong) {
          
                  Date currenTime = new Date();
                Date d = new Date();
        int year = d.getYear();
        int month = d.getMonth();
        int day = d.getDay();
    Calendar calendar = new GregorianCalendar(year, month, day);
         int numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        String cauTruyVan = "INSERT INTO `chamcong`( `idnguoidung`, `ngaychamcong`, `socachamcong`, `tongsocachamcong`, `songaytrongthang`) VALUES('"+chamcong.getIdnguoidung()+"','"+chamcong.getNgaychamcong()+"','0','0','"+numberOfDays+"');";
      
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
      
      
      
      
       public static int SuaChamCong(DTOChamCong chamcong) {
        String cauTruyVan = "UPDATE `chamcong`"
                + " SET "
                + "`socachamcong`='"+chamcong.getSocachamcong()+"',"
                + "`tongsocachamcong`='"+chamcong.getTongsocachamcong()+"'"           
                + "WHERE `idnguoidung`='"+chamcong.getIdnguoidung()+"' and `ngaychamcong`= CURDATE()";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
       
       
       
}
