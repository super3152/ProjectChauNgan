/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOLuong;
import static GUI.pnlnhanvien.cbbNam;
import static GUI.pnlnhanvien.cbbThang;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DAOPhatLuong {
    public static ResultSet Layphatluong(){
        String query= "SELECT * FROM phatluong";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;       
    }
        public static ResultSet LayMaNhanVien(int MaNhanVien) {
        String query = "SELECT * FROM nguoidung where idnguoidung =  '" + MaNhanVien + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
        public static ResultSet Layluong(int MaLuong){
            String query = "SELECT * FROM luong where idluong = '"+MaLuong+"'";
            ResultSet rs = DAO.DBConection.GetData(query);
            return rs;
        }
        public static ResultSet LayPhatLuongTheoID(int MaPhatLuong){
            String query = "SELECT * FROM phatluong where idphatluong = '"+MaPhatLuong+"'";
            ResultSet rs = DAO.DBConection.GetData(query);
            return rs;
        }
         public static int PhatLuong(DTO.DTOPhatLuong pl) {
              int thang =  Integer.parseInt(cbbThang.getSelectedItem().toString());
            int nam =  Integer.parseInt(cbbNam.getSelectedItem().toString());
        String cauTruyVan = "INSERT INTO `phatluong`"
                + "(`idnguoidung`, `idluong`, `ngayphat`, `socadilam`, `socanghi`, `tienthuong`, `tienphat`, `tongluong`, `ghichu`,`trangthai`,`thangphatluong`,`namphatluong`)"
                + " VALUES "
                + "('"+pl.getMaNV()+"',"
                + "'"+pl.getMaLuong()+"',"
                + "'"+pl.getNgayPhat()+"',"
                + "'"+pl.getSoCaDiLam()+"',"
                + "'"+pl.getSoCaNghi()+"',"
                + "'"+pl.getTienThuong()+"',"
                + "'"+pl.getTienPhat()+"',"
                + "'"+pl.getTongLuong()+"',"
                + "'"+pl.getGhiChu()+"',"
                
                 + "'1',"
                 + "'"+thang+"',"
                + "'"+nam+"')";
        System.out.println(cauTruyVan);
         return  DBConection.ExcuteTruyVan(cauTruyVan);
       
    }
         
         
         public static int XoaLuong(int IDLuong) {
        String query = "DELETE FROM `luong` WHERE `idluong` = '" + IDLuong + "'";
        int kq = DBConection.ExcuteTruyVan(query);
        return kq;
    }
          public static ResultSet HienThiLuong() {
        String query = "SELECT * FROM `luong`";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayLuong(String maluong) {
        String query = "SELECT * FROM `luong` WHERE `idluong` like '%" + maluong + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayLuongTheoID(String maluong) {
        String query = "SELECT * FROM `luong` WHERE `idluong` = '" + maluong + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      public static int ThemLuong(DTOLuong luong) {
        String cauTruyVan = "INSERT INTO `luong`(`mucluong`,`mota`) VALUES ('"+luong.getTienluong()+"','"+luong.getMoTa()+"')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
         
         
}
