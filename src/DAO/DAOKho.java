/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOKho;
import DTO.DTOPhieuNhap;
import static GUI.pnlsanpham.countKho;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DAOKho {
     public static ResultSet LayTenSP(int MaSP) {
        String query = "SELECT * FROM sanpham where idsanpham =  '" + MaSP + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
       public static ResultSet LaySoPhieuNhap(int MaPN) {
        String query = "SELECT * FROM phieunhap where idphieunhap =  '" + MaPN + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayKho(String TuKhoa, int trang){
        String query = "Select * from kho where idkho like '%"+TuKhoa+"%' or idsanpham like '%"+TuKhoa+"%' or idphieunhap like '%"+TuKhoa+"%' or trangthai like '%"+TuKhoa+"%' limit "+trang+",13";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
     public static ResultSet LayKhoLoc(String MaPN, String TrangThai,int Trang){
        String query = "Select * from kho where idphieunhap like '%"+MaPN+"%' and trangthai like '%"+TrangThai+"%' limit "+Trang+",13";
        ResultSet rs = DAO.DBConection.GetData(query);
         System.out.println(query);
        return rs;
    }
      public static ResultSet CountKho() {
        try {
         String query = "Select count(*) from kho";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
                countKho = rs.getInt(1);
            }
            System.out.println(countKho);
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
        public static int ThemKho(DTOKho k) {
        String query = "INSERT INTO `kho`(`idsanpham`, `idphieunhap`, `tonkho`, `hangdangve`, `trangthai`)"
                + " VALUES "
                + "('"+k.getIDSanPham()+"',"
                + "'"+k.getIDPhieuNhap()+"',"
                + "'"+k.getTonKho()+"',"
                + "'"+k.getHangDangVe()+"',"
                + "'"+k.getTrangThai()+"')";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
        
    }
         public static int SuaHangDangVeKho(DTOKho k) {
        String query = "UPDATE `kho` SET `tonkho`='"+k.getTonKho()+"' ,`hangdangve`='"+k.getHangDangVe()+"', `trangthai`='"+k.getTrangThai()+"' WHERE `idsanpham`='"+k.getIDSanPham()+"'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
        
    }
        
         public static ResultSet GetKhoTheoIDSP(int MaSP) {

        String query = "SELECT * FROM kho where idsanpham = '" + MaSP + "' ";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
         public static int SuaTonKho(DTOKho kh) {
        String query = "UPDATE `kho` SET `tonkho`='"+kh.getTonKho()+"',`hangdangve`='"+kh.getHangDangVe()+"' WHERE `idsanpham`='"+kh.getIDSanPham()+"'";
         System.out.println(query);
       return DBConection.ExcuteTruyVan(query);
    }
}
