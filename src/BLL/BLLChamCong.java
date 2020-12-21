/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTOChamCong;
import GUI.ThongBaoCanhBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KMB1604
 */
public class BLLChamCong {
    
     public static void HienThiLichSuChamCong(JTable tbl, String idnguoidung, int trang) {
        ResultSet rs = DAO.DAOChamCong.LayLichSuChamCong(idnguoidung,trang);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        
        Object obj[] = new Object[5];
        try {
             while (rs.next()) {
                obj[0] = tbModel.getRowCount() + 1;
                obj[1] = rs.getInt("idchamcong");
                int MaND = rs.getInt("idnguoidung");
                ResultSet rsND = DAO.DAONguoiDung.LayNguoiDungTheoMa(MaND);
                if (rsND.next()) {
                    obj[2] = rsND.getString("tennguoidung");
                }
                obj[3] = ChuyenDoi.DinhDangNgay(rs.getDate("ngaychamcong"));
                  int socadilam = rs.getInt("socachamcong");
                   if (socadilam == 1) {
                     obj[4] = "Ca sáng";
                 }else if(socadilam == 2){
                      obj[4] = "Ca chiều";
                 }else if(socadilam == 3){
                      obj[4] = "Ca tối";
                 }else if(socadilam == 4){
                      obj[4] = "Ca sáng, Ca chiều";
                 }else if(socadilam == 5){
                      obj[4] = "Ca chiều, Ca tối";
                 }else if(socadilam == 6){
                      obj[4] = "Ca sáng, Ca tối";
                 }else if(socadilam == 7){
                        obj[4] = "Cả ngày";
                 }else{
                       
                         obj[4] = "Vắng";
                         }
                   
                   
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng lịch sử chấm công", "Thông báo");
        }

    }
      
      
    public static void ThemChamCong(DTOChamCong cc) {
        DAO.DAOChamCong.ThemChamCong(cc);
    }
        public static boolean KiemTraThemChamCong(int idnguoidung, String ngaychamcong) {
    return true;
    }
        
         public static void SuaChamCong(DTOChamCong cc) {
        DAO.DAOChamCong.SuaChamCong(cc);
    }
          public static boolean KiemTraSuaChamCong(int socachamcong, int tongsocachamcong, int idnguoidung) {
    return true;
    }
          
            public static void CheckNgayChamCong(JTable tbl, String ngaychamcong,int idnguoidung) {
        ResultSet rs = DAO.DAOChamCong.KiemTraNgayChamCong(ngaychamcong, idnguoidung);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
       tbModel.setRowCount(0);
        
        Object obj[] = new Object[1];
        try {
             while (rs.next()) {
             
                obj[0] = rs.getString(1);
               
                   
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
             
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu", "Thông báo");
        }

    }
            
            
            
            
          
            
            
            
            
             public static DTO.DTOChamCong GetCC(Integer MaCC) {
        try {
            ResultSet rs = DAO.DAOChamCong.LayThongTinCaChamCong(MaCC);
            if (rs.next()) {
                DTOChamCong cc = new DTOChamCong();
                cc.setSocachamcong(rs.getInt(1));
                 cc.setTennguoidung(rs.getString(2));
               

                return cc;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng chấm công", "Thông báo");
        }
        return null;
    }
          
}
