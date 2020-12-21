/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTOPhieuThuChi;
import GUI.ThongBaoCanhBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KMB1604
 */
public class BLLThuChi {
      public static void ThemThuChiNV(DTOPhieuThuChi tc) {
        DAO.DAOThuChi.TaoPhieuThuChiNV(tc);
    }
      
       public static void ThemThuChiKH(DTOPhieuThuChi tc) {
        DAO.DAOThuChi.TaoPhieuThuChiKH(tc);
    }
       
        public static void ThemThuChiNCC(DTOPhieuThuChi tc) {
        DAO.DAOThuChi.TaoPhieuThuChiNCC(tc);
    }
      
        public static boolean KiemTraThuChiNV(String MaThuChi, int idnv, String LoaiPhieu,  String HangMuc, Double Tongtien, String GhiChu) {
       
        return true;
    }
           public static boolean KiemTraThuChiKH(String MaThuChi, int idkh, String LoaiPhieu, String HangMuc, Double Tongtien, String GhiChu) {
       
        return true;
    }
              public static boolean KiemTraThuChiNCC(String MaThuChi, int idncc, String LoaiPhieu,  String HangMuc, Double Tongtien, String GhiChu) {
       
        return true;
    }
              
    public static void HienThiPhieuThuChi(JTable tbl, String TuKhoa, int trang) {

        ResultSet rs = DAO.DAOThuChi.LayPhieuThuChi(TuKhoa,trang);

        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[9];
        try {
            while (rs.next()) {
                obj[0] = rs.getString("mathuchi");
                int MaNCC = rs.getInt("idnhacungcap");
    
                if (MaNCC != 0) {
                    ResultSet rsNcc = DAO.DAOPhieuNhap.LayTenNCC(MaNCC);
                    if (rsNcc.next()) {
                        obj[1] = rsNcc.getString("tennhacungcap");
                    }
                } else {
                    obj[1] = "Trống";
                }

                int MaKH = rs.getInt("idkhachhang");
                if (MaKH != 0) {
                    ResultSet rsKH = DAO.DAOPhieuNhap.LayTenKH(MaKH);
                    if (rsKH.next()) {
                        obj[2] = rsKH.getString("tenkhachhang");
                    }
                } else {
                    obj[2] = "Trống";
                }

                int MaND = rs.getInt("idnguoidung");
                if (MaND != 0) {
                    ResultSet rsND = DAO.DAOPhieuNhap.LayTenND(MaND);
                    if (rsND.next()) {
                        obj[3] = rsND.getString("tennguoidung");
                    }
                } else {
                    obj[3] = "Trống";
                }

                String LoaiPhieu = rs.getString("loaiphieu");
                if (LoaiPhieu.equals("Phiếu Thu")) {
                    obj[4] = "<html><body style='color:blue;'>Phiếu Thu</body></html>";
                } else {
                    obj[4] = "<html><body style='color:red;'>Phiếu Chi</body></html>";
                }
                obj[5] = BLL.ChuyenDoi.GetNgay(rs.getDate("ngaytao"));
                obj[6] = rs.getString("hangmucthuchi");
                obj[7] = ChuyenDoi.DinhDangTien(rs.getDouble("tongtien"));
                obj[8] = rs.getString("ghichu");
                tbModel.addRow(obj);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng thu chi", "Thông báo");
        }

    }
    
    public static void HienThiPhieuThuChiHomNay(JTable tbl, String TuKhoa, int trang) {

        ResultSet rs = DAO.DAOThuChi.LayPhieuThuChiHomNay(TuKhoa,trang);

        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[9];
        try {
            while (rs.next()) {
                obj[0] = rs.getString("mathuchi");
                int MaNCC = rs.getInt("idnhacungcap");
    
                if (MaNCC != 0) {
                    ResultSet rsNcc = DAO.DAOPhieuNhap.LayTenNCC(MaNCC);
                    if (rsNcc.next()) {
                        obj[1] = rsNcc.getString("tennhacungcap");
                    }
                } else {
                    obj[1] = "Trống";
                }

                int MaKH = rs.getInt("idkhachhang");
                if (MaKH != 0) {
                    ResultSet rsKH = DAO.DAOPhieuNhap.LayTenKH(MaKH);
                    if (rsKH.next()) {
                        obj[2] = rsKH.getString("tenkhachhang");
                    }
                } else {
                    obj[2] = "Trống";
                }

                int MaND = rs.getInt("idnguoidung");
                if (MaND != 0) {
                    ResultSet rsND = DAO.DAOPhieuNhap.LayTenND(MaND);
                    if (rsND.next()) {
                        obj[3] = rsND.getString("tennguoidung");
                    }
                } else {
                    obj[3] = "Trống";
                }

                String LoaiPhieu = rs.getString("loaiphieu");
                if (LoaiPhieu.equals("Phiếu Thu")) {
                    obj[4] = "<html><body style='color:blue;'>Phiếu Thu</body></html>";
                } else {
                    obj[4] = "<html><body style='color:red;'>Phiếu Chi</body></html>";
                }
                obj[5] = BLL.ChuyenDoi.GetNgay(rs.getDate("ngaytao"));
                obj[6] = rs.getString("hangmucthuchi");
                obj[7] = ChuyenDoi.DinhDangTien(rs.getDouble("tongtien"));
                obj[8] = rs.getString("ghichu");
                tbModel.addRow(obj);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng thu chi", "Thông báo");
        }

    }
     public static void HienThiPhieuThuChiLoc(JTable tbl, String IDNCC, String IDKH, String IDNV, String LoaiPhieuu, String HangMuc) {

        ResultSet rs = DAO.DAOThuChi.LayPhieuThuChiLoc(IDNCC, IDKH, IDNV, LoaiPhieuu,HangMuc);

        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[9];
        try {
            while (rs.next()) {
                obj[0] = rs.getString("mathuchi");
                int MaNCC = rs.getInt("idnhacungcap");
    
                if (MaNCC != 0) {
                    ResultSet rsNcc = DAO.DAOPhieuNhap.LayTenNCC(MaNCC);
                    if (rsNcc.next()) {
                        obj[1] = rsNcc.getString("tennhacungcap");
                    }
                } else {
                    obj[1] = "Trống";
                }

                int MaKH = rs.getInt("idkhachhang");
                if (MaKH != 0) {
                    ResultSet rsKH = DAO.DAOPhieuNhap.LayTenKH(MaKH);
                    if (rsKH.next()) {
                        obj[2] = rsKH.getString("tenkhachhang");
                    }
                } else {
                    obj[2] = "Trống";
                }

                int MaND = rs.getInt("idnguoidung");
                if (MaND != 0) {
                    ResultSet rsND = DAO.DAOPhieuNhap.LayTenND(MaND);
                    if (rsND.next()) {
                        obj[3] = rsND.getString("tennguoidung");
                    }
                } else {
                    obj[3] = "Trống";
                }

                String LoaiPhieu = rs.getString("loaiphieu");
                if (LoaiPhieu.equals("Phiếu Thu")) {
                    obj[4] = "<html><body style='color:blue;'>Phiếu Thu</body></html>";
                } else {
                    obj[4] = "<html><body style='color:red;'>Phiếu Chi</body></html>";
                }
                obj[5] = BLL.ChuyenDoi.GetNgay(rs.getDate("ngaytao"));
                obj[6] = rs.getString("hangmucthuchi");
                obj[7] = ChuyenDoi.DinhDangTien(rs.getDouble("tongtien"));
                obj[8] = rs.getString("ghichu");
                tbModel.addRow(obj);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng thu chi", "Thông báo");
        }

    }

    public static String TaoSoHoaDon() {
        String soHoaDon;

        DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDhhmmss");

        Date d = new Date();

        soHoaDon = "PTC" + dateFormat.format(d);

        return soHoaDon;
    }
     public static void DoCBBHangMuc(JComboBox cbb) {
        try {
             DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            ResultSet rs = DAO.DAOThuChi.LayPhieuThuChiHangMuc();

           
            while (rs.next()) {
                String HangMuc = rs.getString("hangmucthuchi");

                cbbModel.addElement(HangMuc);

            }
        } catch (SQLException ex) {

            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu thu chi!", "Thông báo");
        }
    }
      public static void DoDuLieuVaoCBBTenNguoiDungTC(JComboBox cbb) {
        try {
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            ResultSet rs = DAO.DAOThuChi.LayThuChiLocNguoiDung();

            while (rs.next()) {
                int MaND = rs.getInt("idnguoidung");
                ResultSet rsND = DAO.DAOPhieuNhap.LayTenND(MaND);
                while (rsND.next()) {

                    String TenND = rsND.getString("tennguoidung");
                    cbbModel.addElement(TenND);

                }
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu hóa đơn", "Thông báo");
        }

    }
       public static void DoDuLieuVaoCBBTenKhachHangTC(JComboBox cbb) {
        try {
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            ResultSet rs = DAO.DAOThuChi.LayThuChiLocKhachHang();

            while (rs.next()) {
                int MaKH = rs.getInt("idkhachhang");
                ResultSet rsKH = DAO.DAOPhieuNhap.LayTenKH(MaKH);
                while (rsKH.next()) {

                    String TenKH = rsKH.getString("tenkhachhang");
                    cbbModel.addElement(TenKH);

                }
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu hóa đơn", "Thông báo");
        }

    }

    public static void DoDuLieuVaoCBBTenNhaCungCapTC(JComboBox cbb) {
        try {
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            ResultSet rs = DAO.DAOThuChi.LayThuChiLocNhaCungCap();
            
            while (rs.next()) {
                int MaNCC = rs.getInt("idnhacungcap");
                ResultSet rsKH = DAO.DAOPhieuNhap.LayTenNCC(MaNCC);

                while (rsKH.next()) {

                    String TenKH = rsKH.getString("tennhacungcap");
                    cbbModel.addElement(TenKH);

                }
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu hóa đơn", "Thông báo");
        }

    }

}
