/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOKhachHang;
import DTO.DTOLoaiKhachHang;
import DTO.DTONguoidung;
import GUI.pnlnhanvien;
import static GUI.pnlnhanvien.countNV;
import static GUI.pnlnhanvien.countnv;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DAONguoiDung {
     public static ResultSet LayNhanVienCBB() {
        String query = "SELECT * FROM nguoidung where quyen = 0";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      public static ResultSet LayNhanVienCBBDaPhat(int idnguoidung, int thangphatluong, int namphatluong) {
        String query = "SELECT trangthai FROM `phatluong` WHERE  idnguoidung = '"+idnguoidung+"' and thangphatluong = '"+thangphatluong+"' and namphatluong = '"+namphatluong+"'";
        ResultSet rs = DBConection.GetData(query);
          System.out.println(query);
        return rs;
    }

    public static ResultSet LayMucLuongCBB() {
        String query = "SELECT * FROM luong";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
 public static ResultSet LayNguoiDungLoc(String GioiTinh, String Quyen, String TrangThai, int Trang){

        String query = "SELECT * FROM nguoidung where gioitinh like '%"+GioiTinh+"%' and quyen like '%"+Quyen+"%' and trangthai like '%"+TrangThai+"%'  limit "+Trang+",13";
        ResultSet rs = DBConection.GetData(query);
        System.out.println(query);
        return rs;
    }
    public static ResultSet LayMaLuongCBB(int MaLuong) {

        String query = "SELECT * FROM luong where idluong = '" + MaLuong + "' ";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet DangNhap(String TenDangNhap) {

        String query = "SELECT * FROM `nguoidung` WHERE `tendangnhap` = '" + TenDangNhap + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ArrayList<DTONguoidung> GetChucVu() {
        ResultSet rs;
        ArrayList<DTONguoidung> chucvu = null;
        String cauTruyVan = "select DISTINCT  quyen from nguoidung";
        rs = DBConection.GetData(cauTruyVan);
        chucvu = new ArrayList<DTONguoidung>();
        try {
            while (rs.next()) {
                DTONguoidung nd = new DTONguoidung(rs.getInt("quyen"));
                chucvu.add(nd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOLoaiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chucvu;

    }

    public static ResultSet LayNguoiDungTheoChucVu(int ChucVu) {

        String query = "SELECT * FROM nguoidung where quyen = '" + ChucVu + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;

    }

    public static ResultSet LayNguoiDung(String TuKhoa, int trang) {

        String query = "SELECT * FROM nguoidung where tennguoidung like '%" + TuKhoa + "%' or ngaysinh like '%" + TuKhoa + "%' or ngayvaolam like '%" + TuKhoa + "%' or cmnd like '%" + TuKhoa + "%' or tendangnhap like '%" + TuKhoa + "%' limit "+trang+",13";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayNguoiDungTheoMa(int MaND) {

        String query = "SELECT * FROM nguoidung where idnguoidung = '"+MaND+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayTenNguoiDung(String TenNguoiDung) {

        String query = "SELECT * FROM nguoidung where tennguoidung =  '" + TenNguoiDung + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LaySDTNguoiDung(String SoDienThoai) {

        String query = "SELECT * FROM nguoidung where sodienthoai =  '" + SoDienThoai + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayEmailNguoiDung(String Email) {

        String query = "SELECT * FROM nguoidung where email =  '" + Email + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
     public static ResultSet LayCMNDNguoiDung(String CMND) {

        String query = "SELECT * FROM nguoidung where cmnd =  '" + CMND + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayMaLuong(int MaLuong) {

        String query = "SELECT * FROM luong where idluong =  '" + MaLuong + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }


    public static int ThemNguoiDung(DTONguoidung nd) {
        String cauTruyVan = "INSERT INTO `nguoidung`(`idluong`, `tennguoidung`, `sodienthoai`, `email`, `gioitinh`, `ngaysinh`, `ngayvaolam`, `diachi`, `cmnd`, `tendangnhap`,"
                + " `matkhau`, `anhdaidien`, `quyen`, `trangthai`, `mota`)"
                + " VALUES "
                + "('" + nd.getIdLuong() + "',"
                + "'" + nd.getTenNguoiDung() + "',"
                + "'" + nd.getSoDienThoai() + "',"
                + "'" + nd.getEmail() + "',"
                + "" + nd.getGioiTinh() + ","
                + "'" + nd.getNgaySinh() + "',"
                + "'" + nd.getNgayVaoLam() + "',"
                + "'" + nd.getDiaChi() + "',"
                + "'" + nd.getCMND() + "',"
                + "'" + nd.getTenDangNhap() + "',"
                + "'" + nd.getMatKhau() + "',"
                + "'" + nd.getAnhDaiDien() + "',"
                + "" + nd.getQuyen() + ","
                + "" + nd.getTrangThai()+ ","
                + "'" + nd.getMoTa() + "')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }

    public static int SuaNhanVien(DTONguoidung nd) {
        String cauTruyVan = "UPDATE `nguoidung` SET"
                + " `idluong`='"+nd.getIdLuong()+"',"
                + "`tennguoidung`='"+nd.getTenNguoiDung()+"',"
                + "`sodienthoai`='"+nd.getSoDienThoai()+"',"
                + "`email`='"+nd.getEmail()+"',"
                + "`gioitinh`="+nd.getGioiTinh()+","
                + "`ngaysinh`='"+nd.getNgaySinh()+"',"
                + "`ngayvaolam`='"+nd.getNgayVaoLam()+"',"
                + "`diachi`='"+nd.getDiaChi()+"',"
                + "`cmnd`='"+nd.getCMND()+"',"
                + "`tendangnhap`='"+nd.getTenDangNhap()+"',"
                + "`matkhau`='"+nd.getMatKhau()+"',"
                + "`anhdaidien`='"+nd.getAnhDaiDien()+"',"
                + "`quyen`="+nd.getQuyen()+","
                + "`trangthai`="+nd.getTrangThai()+","
                + "`mota`='"+nd.getMoTa()+"'"
                + "WHERE `idnguoidung`='"+nd.getIdNguoiDung()+"'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }

    public static int XoaNhanVien(Integer MaNhanVien) {
        String cauTruyVan = "DELETE FROM `nguoidung` WHERE idnguoidung = '" + MaNhanVien + "'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);

    }
 public static ResultSet LayNguoiDungChamCongNgay(String ngay) {

        String query = "SELECT nguoidung.idnguoidung, nguoidung.tennguoidung,chamcong.songaytrongthang, chamcong.socachamcong,SUM(chamcong.tongsocachamcong) FROM `chamcong` INNER JOIN nguoidung ON nguoidung.idnguoidung = chamcong.idnguoidung WHERE nguoidung.quyen = 0 and ngaychamcong = '"+ngay+"' GROUP BY chamcong.idnguoidung";
        ResultSet rs = DBConection.GetData(query);
        return rs;

    }
  public static ResultSet LayNguoiDungChamCongThangNam(int thang, int nam) {

        String query = "SELECT nguoidung.idnguoidung, nguoidung.tennguoidung,chamcong.songaytrongthang, chamcong.socachamcong,SUM(chamcong.tongsocachamcong) FROM `chamcong` INNER JOIN nguoidung ON nguoidung.idnguoidung = chamcong.idnguoidung WHERE nguoidung.quyen = 0 and MONTH(ngaychamcong)= '"+thang+"' && YEAR(ngaychamcong)='"+nam+"'  GROUP BY chamcong.idnguoidung";
        ResultSet rs = DBConection.GetData(query);
        return rs;

    }
    
  public static ResultSet CheckLayNguoiDungChamCongThangNam(String ten,int thang, int nam) {
            try {
         String query = "SELECT chamcong.songaytrongthang,SUM(chamcong.tongsocachamcong) FROM `chamcong` INNER JOIN nguoidung ON nguoidung.idnguoidung = chamcong.idnguoidung WHERE nguoidung.quyen = 0 and nguoidung.tennguoidung ='"+ten+"' and MONTH(ngaychamcong)= '"+thang+"' && YEAR(ngaychamcong)='"+nam+"'  GROUP BY chamcong.idnguoidung";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
                pnlnhanvien.txtSocadilam.setText(String.valueOf(rs.getInt(2)));
                pnlnhanvien.txtSocavang.setText(String.valueOf((rs.getInt(1)*3)-rs.getInt(2)));
                pnlnhanvien.txtsongaytrongthang.setText(String.valueOf(rs.getInt(1)));
            }
           
        return rs;
        } catch (Exception e) {
        }
        return null;

    }
   
      public static ResultSet CountNhanVien(String ten, int thang, int nam) {
        try {
         String query = "SELECT phatluong.trangthai FROM `phatluong` INNER JOIN nguoidung on nguoidung.idnguoidung = phatluong.idnguoidung  WHERE nguoidung.tennguoidung = '"+ten+"' and phatluong.namphatluong = '"+nam+"' and phatluong.thangphatluong = '"+thang+"'";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
             if (rs.getInt(1) == 0) {
                  countnv = 0;
             }else{
                  countnv = rs.getInt(1);
             }
               
            }
            
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
      public static ResultSet CountNhanVien() {
        try {
         String query = "Select count(*) from nguoidung";
        ResultSet rs = DBConection.GetData(query);
      
         while (rs.next()) {
                countNV = rs.getInt(1);
            }
            System.out.println(countNV);
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
  
       public static ResultSet LayTenNV(String ten) {
        try {
         String query = "SELECT idnguoidung FROM `nguoidung` WHERE tennguoidung = '"+ten+"'";
        ResultSet rs = DBConection.GetData(query);     
         while (rs.next()) {           
                  pnlnhanvien.idnv = rs.getInt(1);            
            }          
        return rs;
        } catch (Exception e) {
        }
        return null;
      
    }
      
  
}
