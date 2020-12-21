/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTODonHang;
import DTO.DTOHinhThucGiaoHang;
import static GUI.frmmain.lblTongHoaDon;
import GUI.pnlgiaohang;
import static GUI.pnlgiaohang.countDH;
import java.sql.ResultSet;

/**
 *
 * @author KMB1604
 */
public class DAODonHang {
    public static ResultSet LayDonHang(String TuKhoa, int trang) {

        String query = "SELECT * FROM `hoadon` where loaihoadon = '1' and trangthaihoadon = '1'  ORDER BY ngaytaohoadon DESC limit "+trang+",13";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    
     public static ResultSet LayDonHangDongGoi(String TuKhoa, int trang) {

        String query = "SELECT * FROM `hoadon` where loaihoadon = '1' and trangthaihoadon = '2'  ORDER BY ngaytaohoadon DESC limit "+trang+",13";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
     
      public static ResultSet LayDonHangGiaoHang(String TuKhoa, int trang) {

        String query = "SELECT * FROM `hoadon` where loaihoadon = '1' and trangthaihoadon = '3'  ORDER BY ngaytaohoadon DESC limit "+trang+",13";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
        public static ResultSet CountHoaDonTong() {
        try {
         String query = " SELECT COUNT(*) FROM `hoadon` WHERE loaihoadon = 1 and view = 0";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
                lblTongHoaDon.setText("Bạn có "+rs.getInt(1)+" Đơn hàng mới"); 
                pnlgiaohang.jLabel1.setText("Đơn chưa xem: "+rs.getInt(1)+" Đơn");
            }
           
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
       public static ResultSet LayDonHangHoanThanh(String TuKhoa, int trang) {

        String query = "SELECT * FROM `hoadon` where loaihoadon = '1' and trangthaihoadon = '4'  ORDER BY ngaytaohoadon DESC limit "+trang+",13";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
       
        public static ResultSet LayDonHangHuy(String TuKhoa, int trang) {

        String query = "SELECT * FROM `hoadon` where loaihoadon = '1' and trangthaihoadon = '5'  ORDER BY ngaytaohoadon DESC limit "+trang+",13";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    
       public static ResultSet LayChiHoaDonKhachHang() {

        String query = "SELECT  hoadon.ngaytaohoadon FROM `hoadon` WHERE hoadon.loaihoadon = 1 and  hoadon.view = 0";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    
    
     public static ResultSet CountHoaDon() {
        try {
         String query = "Select count(*) from hoadon where loaihoadon = '1'";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
                countDH = rs.getInt(1);
            }
            System.out.println(countDH);
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
     
     public static int idhd;
      public static ResultSet NumberBill(int id) {
        try {
         String query = "SELECT hinhthucthanhtoan FROM `hoadon` WHERE idhoadon = '"+id+"'";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
                idhd = rs.getInt(1);
            }
            System.out.println(idhd);
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
     
      public static ResultSet LayChiTietDonHang(String TuKhoa) {

        String query = "SELECT * FROM `chitiethoadon`";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    
    
     public static ResultSet LayDonHangTheoMa(int MaDonHang) {

        String query = "SELECT * FROM `hoadon` WHERE idhoadon = '"+MaDonHang+"'";
        ResultSet rs = DBConection.GetData(query);
         System.out.println(query);
          System.out.println(rs);
        return rs;
    }
     
     public static ResultSet LayKhachHang(int MaKhachHang) {
        String query = "SELECT * FROM khachhang where idkhachhang = '"+MaKhachHang+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
     
      public static ResultSet LayKhachHangNotLogin(int MaNonKhachHang) {
        String query = "SELECT * FROM nonkhachhang where idnonkhachhang = '"+MaNonKhachHang+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      
       public static int SuaDonHang(DTODonHang dh) {
        String cauTruyVan = "UPDATE `hoadon`"
                + " SET "
                + "`trangthaihoadon`='"+dh.getTrangthaihoadon()+"'"             
                + "WHERE `idhoadon`='"+dh.getIdhoadon()+"'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
       
       
           public static int SuaDonHangView(DTODonHang dh) {
        String cauTruyVan = "UPDATE `hoadon`"
                + " SET "
                + "`view`='"+dh.getTrangthaihoadon()+"'"             
                + "WHERE `idhoadon`='"+dh.getIdhoadon()+"'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
       
       
       
    public static ResultSet laychitietdonhang(int iddonhang) {

        String query = "SELECT chitiethoadon.idchitiethoadon, sanpham.anhsanpham, sanpham.masanpham, sanpham.tensanpham, sanpham.idsizesanpham, sanpham.idmausanpham, chitiethoadon.soluong, sanpham.giabanle, chitiethoadon.uudai, chitiethoadon.thanhtien FROM `chitiethoadon` INNER JOIN sanpham ON sanpham.idsanpham = chitiethoadon.idsanpham INNER JOIN hoadon ON hoadon.idhoadon = chitiethoadon.idhoadon WHERE hoadon.idhoadon = '"+iddonhang+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }    
       
    
      public static int SuaTienGiaoHang(DTODonHang dh) {
        String cauTruyVan = "UPDATE `hoadon`"
                + " SET "
                + "`idhinhthuc`='"+dh.getHinhthucvanchuyen()+"',"              
                + "`tiengiaohang`='"+dh.getTiengiaohang()+"' "
                + "WHERE `idhoadon`='"+dh.getIdhoadon()+"'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
      
       public static int ThemHinhThuc(DTOHinhThucGiaoHang hinhthuc) {
        String cauTruyVan = "INSERT INTO `hinhthucgiaohang`(`tenhinhthuc`,`mota`) VALUES ('"+hinhthuc.getTenHinhThuc()+"','"+hinhthuc.getMoTa()+"')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }

        public static ResultSet LayHinhThuc(String idHinhThuc) {
        String query = "SELECT * FROM `hinhthucgiaohang` WHERE `idhinhthuc` like '%" + idHinhThuc + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayHinhThucTheoID(int idHinhThuc) {
        String query = "SELECT * FROM `hinhthucgiaohang` WHERE `idhinhthuc` = '" + idHinhThuc + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      public static ResultSet HienThiHinhThuc() {
        String query = "SELECT * FROM `hinhthucgiaohang`";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
       
       
       
       
}
