/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOHoatDong;
import static GUI.jdlChitiethoatdong.countHoatDong;
import java.sql.ResultSet;

/**
 *
 * @author KMB1604
 */
public class DAOHoatDong {
    
      public static ResultSet LayHoatDong(int trang) {
        String query = "SELECT * FROM `hoatdong` ORDER BY thoigianhoatdong DESC limit "+trang+",13";
        ResultSet rs = DBConection.GetData(query);
          System.out.println(query);
        return rs;
    }
      
       public static ResultSet CountHoatDong() {
        try {
         String query = "Select count(*) from hoatdong";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
                countHoatDong = rs.getInt(1);
            }
            System.out.println(countHoatDong);
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
      
        public static ResultSet LayHoatDong2() {
        String query = "SELECT * FROM `hoatdong` ORDER BY thoigianhoatdong DESC limit 0,13";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    
       public static ResultSet LayLoaiHoatDong(String LoaiHoatDong) {
        String query = "SELECT * FROM `loaihoatdong` WHERE `idloaihoatdong` like '%" + LoaiHoatDong + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      
         public static ResultSet LayNguoiDung(String NguoiDung) {
        String query = "SELECT * FROM `nguoidung` WHERE `idnguoidung` like '%" + NguoiDung + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
       
      
      public static void ThemHoatDong(DTOHoatDong hd) {
        DAO.DAOHoatDong.ThemHoatDong(hd);
    }
      public static int XoaHoatDong(Integer MaHoatDong) {
        String cauTruyVan = "DELETE FROM `hoatdong` WHERE idhoatdong = '"+MaHoatDong+"'";
        System.out.println(cauTruyVan);
       return  DBConection.ExcuteTruyVan(cauTruyVan);
        
    }
}
