/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTOLuong;
import DTO.DTONguoidung;
import DTO.DTOPhatLuong;
import DTO.DTOSize;
import GUI.ThongBaoCanhBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class BLLPhatLuong {
    public static void Hienthiphatluong(JTable tbl){
        ResultSet rs = DAO.DAOPhatLuong.Layphatluong();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
           tbModel.setRowCount(0);
        Object obj[] = new Object[11];
        try {
            while(rs.next()){
                obj[0]= rs.getInt("idphatluong");
                int MaNhanien = rs.getInt("idnguoidung");
                ResultSet rsnv = DAO.DAOPhatLuong.LayMaNhanVien(MaNhanien);
                if (rsnv.next()) {
                     obj[1]= rsnv.getString("tennguoidung");
                }
                
                obj[2]= rs.getInt("thangphatluong")+" - "+rs.getInt("namphatluong"); 
                 
                int MaLuong = rs.getInt("idluong");
                ResultSet rsluong = DAO.DAOPhatLuong.Layluong(MaLuong);
                if (rsluong.next()) {
                    obj[3]= ChuyenDoi.DinhDangTien(rsluong.getDouble("mucluong"));
                }
                
                
                obj[4]=ChuyenDoi.DinhDangNgay(rs.getDate("ngayphat"));
                obj[5] = rs.getInt("socadilam");
                obj[6]= rs.getInt("socanghi");
                obj[7]=ChuyenDoi.DinhDangTien(rs.getDouble("tienthuong"));
                obj[8] = ChuyenDoi.DinhDangTien(rs.getDouble("tienphat"));
                obj[9]= ChuyenDoi.DinhDangTien(rs.getDouble("tongluong"));
                obj[10]= rs.getString("ghichu");
              tbModel.addRow(obj);
            }
        } catch (SQLException e) {
                ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng phát lương", "Thông báo");
                System.out.println(e);
        }
    }
    
    
     public static void ThemLuong(DTOLuong Luong) {
        DAO.DAOPhatLuong.ThemLuong(Luong);
    }

    public static boolean KiemTraThemLuong(Double TienLuong, String mota) {
        if (TienLuong == null) {
            ThongBaoCanhBao.ThongBao("Tiền lương không được bỏ trống!"
                    + "\nVui lòng nhập lại tiền lương! ", "Thông báo");
            return false;
        }
        return true;
    }
    
    
      public static void CheckPhatLuong(JTable tbl, int idnhanvien, int thang, int nam){
        ResultSet rs = DAO.DAONguoiDung.LayNhanVienCBBDaPhat(idnhanvien, thang, nam);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
           tbModel.setRowCount(0);
        Object obj[] = new Object[1];
        try {
            while(rs.next()){
                obj[0]= rs.getInt(1);
              tbModel.addRow(obj);
            }
        } catch (SQLException e) {
                ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng phát lương", "Thông báo");
                System.out.println(e);
        }
    }
      
     
    
}
