/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BLL.ChuyenDoi;
import DTO.DTOPhieuThuChi;
import GUI.pnlhanghoa;
import GUI.pnlthongke;
import static GUI.pnlthongke.countThuChi;
import java.sql.ResultSet;

/**
 *
 * @author KMB1604
 */
public class DAOThuChi {
    public static int TaoPhieuThuChiNV(DTOPhieuThuChi ptc) {
        String cauTruyVan = "INSERT INTO `ThuChi`( `mathuchi`,`idnguoidung`, `loaiphieu`,`hangmucthuchi`, tongtien, ghichu)"
                + " VALUES ("
                + "'" + ptc.getMaThuChi() + "',"
                  + "'" + ptc.getIDNguoiDung()+ "',"
              
                + "'" + ptc.getLoaiPhieu() + "',"
                + "'" + ptc.getHangMucThuChi() + "',"
                + "'" + ptc.getTongTien() + "',"
                + "'" + ptc.getGhiChu() + "')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
    
     public static int TaoPhieuThuChiKH(DTOPhieuThuChi ptc) {
        String cauTruyVan = "INSERT INTO `ThuChi`( `mathuchi`, `idkhachhang`,`loaiphieu`,`hangmucthuchi`, tongtien, ghichu)"
                + " VALUES ("
                + "'" + ptc.getMaThuChi() + "',"
                 
                + "'" + ptc.getIDKhachHang() + "',"
                 
                + "'" + ptc.getLoaiPhieu() + "',"
                + "'" + ptc.getHangMucThuChi() + "',"
                + "'" + ptc.getTongTien() + "',"
                + "'" + ptc.getGhiChu() + "')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
     
      public static int TaoPhieuThuChiNCC(DTOPhieuThuChi ptc) {
        String cauTruyVan = "INSERT INTO `ThuChi`( `mathuchi`,`idnhacungcap`,`loaiphieu`,`hangmucthuchi`, tongtien, ghichu)"
                + " VALUES ("
                + "'" + ptc.getMaThuChi() + "',"
               
                  + "'" + ptc.getIDNhaCungCap()+ "',"
                + "'" + ptc.getLoaiPhieu() + "',"
                + "'" + ptc.getHangMucThuChi() + "',"
                + "'" + ptc.getTongTien() + "',"
                + "'" + ptc.getGhiChu() + "')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
        public static ResultSet LayPhieuThuChi(String TuKhoa, int trang){
          String query = "select * from ThuChi"
                  + " where `mathuchi` like '%" + TuKhoa + "%' or `idnhacungcap` like '%" + TuKhoa + "%' or `idkhachhang` like '%" + TuKhoa + "%' or `idnguoidung` like '%" + TuKhoa + "%'"
                  + "or `loaiphieu` like '%" + TuKhoa + "%' or `hangmucthuchi` like '%" + TuKhoa + "%'or `tongtien` like '%" + TuKhoa + "%' order by ngaytao DESC limit "+trang+",9 ";
          ResultSet rs = DAO.DBConection.GetData(query);
          return rs;
      }
          public static ResultSet LayPhieuThuChiHomNay(String TuKhoa, int trang){
          String query = "select * from ThuChi"
                  + " where DATE(ngaytao) = DATE(CURRENT_DATE()) AND (`mathuchi` like '%" + TuKhoa + "%' or `idnhacungcap` like '%" + TuKhoa + "%' or `idkhachhang` like '%" + TuKhoa + "%' or `idnguoidung` like '%" + TuKhoa + "%'"
                  + "or `loaiphieu` like '%" + TuKhoa + "%' or `hangmucthuchi` like '%" + TuKhoa + "%'or `tongtien` like '%" + TuKhoa + "%') order by ngaytao DESC limit "+trang+",9 ";
          ResultSet rs = DAO.DBConection.GetData(query);
          return rs;
      }
     public static ResultSet LayPhieuThuChiHangMuc(){
          String query = "select * from ThuChi";
          ResultSet rs = DAO.DBConection.GetData(query);
          return rs;
      }
       public static ResultSet CountThuChi() {
        try {
         String query = "Select count(*) from ThuChi";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
                countThuChi = rs.getInt(1);
            }
            System.out.println(countThuChi + "thuchi");
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
       public static ResultSet CountThuChiHomNay() {
        try {
         String query = "Select count(*) from ThuChi WHERE DATE(ngaytao) = DATE(CURRENT_DATE())";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
                countThuChi = rs.getInt(1);
            }
            System.out.println(countThuChi + "thuchi");
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
       
       
       public static ResultSet TongThu() {
        try {
         String query = "SELECT Sum(tongtien) FROM `ThuChi` WHERE loaiphieu = 'Phiếu Thu'";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
             
                pnlthongke.thu = rs.getDouble(1);
            }
            System.out.println(countThuChi + "thuchi");
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
       
       public static ResultSet TongChi() {
        try {
        String query = "SELECT Sum(tongtien) FROM `ThuChi` WHERE loaiphieu = 'Phiếu Chi'";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
                   pnlthongke.chi = rs.getDouble(1);
            }
            System.out.println(countThuChi + "thuchi");
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
     
       
       
          public static ResultSet TongThuHomNay() {
        try {
         String query = "SELECT SUM(tongtien) FROM ThuChi WHERE DATE(ngaytao) = DATE(CURRENT_DATE()) AND loaiphieu = 'Phiếu Thu'";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
             
                pnlthongke.thuhomnay = rs.getDouble(1);
            }
          
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
       
       public static ResultSet TongChiHomNay() {
        try {
        String query = "SELECT SUM(tongtien) FROM ThuChi WHERE DATE(ngaytao) = DATE(CURRENT_DATE()) AND loaiphieu = 'Phiếu Chi'";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
                   pnlthongke.chihomnay = rs.getDouble(1);
            }
           
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
       
     
     public static ResultSet LayPhieuThuChiLoc(String IDNCC, String IDKH, String IDNV, String LoaiPhieuu, String HangMuc){
          String query = "select * from ThuChi where "+IDNCC+""+IDKH+""+IDNV+" loaiphieu like '%"+LoaiPhieuu+"%' and hangmucthuchi like '%"+HangMuc+"%'";
          ResultSet rs = DAO.DBConection.GetData(query);
          System.out.println(query);
          return rs;
      }
      public static ResultSet LayThuChiLocNguoiDung() {
        String query = "Select DISTINCT idnguoidung from ThuChi";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
      public static ResultSet LayThuChiLocKhachHang() {
        String query = "Select DISTINCT idkhachhang from ThuChi";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }    
    
      
      
        public static ResultSet LayThuChiLocNhaCungCap() {
        String query = "Select DISTINCT idnhacungcap from ThuChi";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }


    
}
