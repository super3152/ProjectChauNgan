/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.DAOHoaDon;
import DAO.DAOPhieuNhap;
import DTO.DTOHoaDon;
import DTO.DTOKho;
import DTO.DTOPhieuNhap;
import DTO.DTOSanPham;
import DTO.MyCombobox;
import GUI.ThongBaoCanhBao;
import GUI.pnlChitietphieunhap;
import GUI.pnlthemphieunhap;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class BLLPhieuNhap {

    public static void HienThiPhieuNhap(JTable tbl, String TuKhoa, int trang) {
        ResultSet rs = DAO.DAOPhieuNhap.LayPhieuNhap(TuKhoa,trang);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[10];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idphieunhap");
                obj[1] = rs.getString("sophieunhap");
                int MaNCC = rs.getInt("idnhacungcap");
                ResultSet rsNcc = DAO.DAOPhieuNhap.LayTenNCC(MaNCC);
                if (rsNcc.next()) {
                    obj[2] = rsNcc.getString("tennhacungcap");
                }
                obj[3] = ChuyenDoi.GetNgay(rs.getDate("ngaynhap"));
                obj[4] = ChuyenDoi.DinhDangTien(rs.getDouble("thanhtien"));
                obj[5] = ChuyenDoi.DinhDangTien(rs.getDouble("congno"));
                
               int tt = rs.getInt("trangthai");
                String TrangThai = String.valueOf(tt);
                if (TrangThai.equals("0")) {
                    obj[6] = "Đang Giao Dịch";
                }else {
                    obj[6] = "Hoàn Thành";
                }
                int nk = rs.getInt("nhapkho");
                String NhapKho = String.valueOf(nk);
                if (NhapKho.equals("0")) {
                    obj[7] = "Chờ Nhập Hàng";
                } else {
                    obj[7] = "Đã Nhập Hàng";
                }
                 int ttoan = rs.getInt("thanhtoan");
                String ThanhToan = String.valueOf(ttoan);
                if (ThanhToan.equals("0")) {
                    obj[8] = "Chưa Thanh Toán";
                } else if (ThanhToan.equals("1")) {
                    obj[8] = "Đã Thanh Toán";
                } else {
                    obj[8] = "Đang Nợ";
                }
                int MaND = rs.getInt("idnguoidung");
                ResultSet rsND = DAO.DAOPhieuNhap.LayTenND(MaND);
                if (rsND.next()) {
                    obj[9] = rsND.getString("tennguoidung");
                }
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng phiếu nhập", "Thông báo");
        }

    }
        public static void HienThiPhieuNhapLoc(JTable tbl,String MaNhanVien, String NhaCungCap, String HinhThucNhap, String TrangT,String CongNo, int Trang) {
        ResultSet rs = DAO.DAOPhieuNhap.LayPhieuNhapLoc(MaNhanVien, NhaCungCap, HinhThucNhap, TrangT, CongNo, Trang);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[10];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idphieunhap");
                obj[1] = rs.getString("sophieunhap");
                int MaNCC = rs.getInt("idnhacungcap");
                ResultSet rsNcc = DAO.DAOPhieuNhap.LayTenNCC(MaNCC);
                if (rsNcc.next()) {
                    obj[2] = rsNcc.getString("tennhacungcap");
                }
                obj[3] = ChuyenDoi.GetNgay(rs.getDate("ngaynhap"));
                obj[4] = ChuyenDoi.DinhDangTien(rs.getDouble("thanhtien"));
                obj[5] = ChuyenDoi.DinhDangTien(rs.getDouble("congno"));
                
               int tt = rs.getInt("trangthai");
                String TrangThai = String.valueOf(tt);
                if (TrangThai.equals("0")) {
                    obj[6] = "Đang Giao Dịch";
                }else {
                    obj[6] = "Hoàn Thành";
                }
                int nk = rs.getInt("nhapkho");
                String NhapKho = String.valueOf(nk);
                if (NhapKho.equals("0")) {
                    obj[7] = "Chờ Nhập Hàng";
                } else {
                    obj[7] = "Đã Nhập Hàng";
                }
                 int ttoan = rs.getInt("thanhtoan");
                String ThanhToan = String.valueOf(ttoan);
                if (ThanhToan.equals("0")) {
                    obj[8] = "Chưa Thanh Toán";
                } else if (ThanhToan.equals("1")) {
                    obj[8] = "Đã Thanh Toán";
                } else {
                    obj[8] = "Đang Nợ";
                }
                int MaND = rs.getInt("idnguoidung");
                ResultSet rsND = DAO.DAOPhieuNhap.LayTenND(MaND);
                if (rsND.next()) {
                    obj[9] = rsND.getString("tennguoidung");
                }
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng phiếu nhập", "Thông báo");
        }

    }
 public static void DoDuLieuVaoCBBTenNguoiDungPN(JComboBox cbb) {
        try {
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            ResultSet rs = DAO.DAOPhieuNhap.LayPhieuNhapLocNguoiDung();

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

    public static void DoDuLieuVaoCBBTenNhaCungCapPN(JComboBox cbb) {
        try {
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            ResultSet rs = DAO.DAOPhieuNhap.LayPhieuNhapLocNhaCungCap();
            
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
    public static void HienThiChiTietPhieuNhap(JTable tbl, int MaPhieuNhap) {
          pnlthemphieunhap.tblChitietphieunhap.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        ResultSet rs = DAO.DAOChiTietPhieuNhap.LayCTPNTheoMaPN(MaPhieuNhap);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[10];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idsanpham");
                int MaSP = rs.getInt("idsanpham");
                ResultSet rsMSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsMSP.next()) {
                    obj[2] = rsMSP.getString("masanpham");
                }
               ResultSet rsTSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsTSP.next()) {
                    obj[3] = rsTSP.getString("tensanpham");
                }
                 ResultSet rsSSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsSSP.next()) {                
                int MaSize = rsSSP.getInt("idsizesanpham");
                
                ResultSet rsMSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
                if (rsMSSP.next()) {
                    obj[4] = rsMSSP.getString("tensize");
                }
                }
                
                 ResultSet rsMMSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsMMSP.next()) {  
                int MaMau = rsMMSP.getInt("idmausanpham");
                ResultSet rsIDMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
                if (rsIDMSP.next()) {
                    obj[5] = rsIDMSP.getString("tenmausanpham");
                }
                }
                obj[6] = rs.getInt("soluong");
                obj[7] = ChuyenDoi.DinhDangTien(rs.getDouble("gianhap"));
                 ResultSet rsDVT = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsDVT.next()) {
                    obj[8] = rsDVT.getString("donvitinh");
                }
                obj[9] = ChuyenDoi.DinhDangTien(rs.getDouble("thanhtien"));
                 ResultSet rsASP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsASP.next()) {
                
                JLabel lb = new JLabel();

                ImageIcon imageIcon = new ImageIcon(new ImageIcon(rsASP.getBytes("anhsanpham")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                lb.setIcon(imageIcon);
                obj[1] = lb;
                }
                tbModel.addRow(obj);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng hóa đơn", "Thông báo");
        }

    }
      public static void HienThiChiTietThongTinPhieuNhap(JTable tbl, int MaPhieuNhap) {
          pnlChitietphieunhap.tblChitietphieunhap.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        ResultSet rs = DAO.DAOChiTietPhieuNhap.LayCTPNTheoMaPN(MaPhieuNhap);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[10];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idchitietphieunhap");
                int MaSP = rs.getInt("idsanpham");
                ResultSet rsMSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsMSP.next()) {
                    obj[2] = rsMSP.getString("masanpham");
                }
               ResultSet rsTSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsTSP.next()) {
                    obj[3] = rsTSP.getString("tensanpham");
                }
                 ResultSet rsSSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsSSP.next()) {                
                int MaSize = rsSSP.getInt("idsizesanpham");
                
                ResultSet rsMSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
                if (rsMSSP.next()) {
                    obj[4] = rsMSSP.getString("tensize");
                }
                }
                
                 ResultSet rsMMSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsMMSP.next()) {  
                int MaMau = rsMMSP.getInt("idmausanpham");
                ResultSet rsIDMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
                if (rsIDMSP.next()) {
                    obj[5] = rsIDMSP.getString("tenmausanpham");
                }
                }
                obj[6] = rs.getInt("soluong");
                obj[7] = ChuyenDoi.DinhDangTien(rs.getDouble("gianhap"));
                 ResultSet rsDVT = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsDVT.next()) {
                    obj[8] = rsDVT.getString("donvitinh");
                }
                obj[9] = ChuyenDoi.DinhDangTien(rs.getDouble("thanhtien"));
                 ResultSet rsASP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsASP.next()) {
                
                JLabel lb = new JLabel();

                ImageIcon imageIcon = new ImageIcon(new ImageIcon(rsASP.getBytes("anhsanpham")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                lb.setIcon(imageIcon);
                obj[1] = lb;
                }
                tbModel.addRow(obj);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng hóa đơn", "Thông báo");
        }

    }

    public static DTO.DTOPhieuNhap GetMaPN(int MaPN) {
        try {
            ResultSet rs = DAO.DAOPhieuNhap.LayPhieuNhapTheoID(MaPN);
            if (rs.next()) {
                DTOPhieuNhap pn = new DTOPhieuNhap();
                pn.setIDPhieuNhap(rs.getInt("idphieunhap"));
                pn.setIDNhaCungCap(rs.getInt("idnhacungcap"));
                pn.setIDNguoiDung(rs.getInt("idnguoidung"));
                pn.setSoPhieuNhap(rs.getString("sophieunhap"));
                pn.setNgayNhap(ChuyenDoi.DinhDangNgay(rs.getDate("ngaynhap")));
                pn.setThanhTien(rs.getDouble("thanhtien"));
                pn.setHinhThucThanhToan(rs.getString("hinhthucthanhtoan"));
                pn.setTrangThai(rs.getInt("trangthai"));
                pn.setNhapKho(rs.getInt("nhapkho"));
                pn.setThanhToan(rs.getInt("thanhtoan"));
                pn.setCongNo(rs.getDouble("congno"));
                pn.setTag(rs.getString("tag"));
                pn.setGhiChu(rs.getString("ghichu"));
                return pn;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng phiếu nhập", "Thông báo");
        }
        return null;
    }

    public static String TaoMaPhieuNhap() {
        String MaPhieuNhap;

        DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDhhmmss");

        Date d = new Date();

        MaPhieuNhap = "PN" + dateFormat.format(d);

        return MaPhieuNhap;
    }

    public static void DoDuLieuVaoCBBNhaCungCap(JComboBox cbb) {
        try {
            ResultSet rs;
            rs = DAO.DAOPhieuNhap.LayNhaCungCap();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tennhacungcap"),
                        rs.getInt("idnhacungcap"));
                cbbModel.addElement(mb);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu nhà cung cấp", "Thông báo");
        }

    }

    public static void SetCBBNhaCungCap(JComboBox cbb, int MaNCC) {
        try {
            ResultSet rs = DAO.DAONhaCungCap.LayNCCTheoMa(MaNCC);

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tennhacungcap"),
                        rs.getInt("idnhacungcap"));

                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {

            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu nhà cung cấp", "Thông báo");
        }
    }


    public static double NhapSanPhamVaoPhieuNhap(JTable tb, DTOSanPham sp, int SoLuong) {
         pnlthemphieunhap.tblChitietphieunhap.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
        Object obj[] = new Object[10];
        try {
        obj[0] = sp.getIDSanPham();
        obj[2] = sp.getMaSanPham();
        obj[3] = sp.getTenSanPham();
        int MaSize = sp.getIDSize();
            ResultSet rsSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
            if (rsSSP.next()) {
                obj[4] = rsSSP.getString("tensize");
            }
            int MaMau = sp.getIDMauSanPham();
            ResultSet rsMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
            if (rsMSP.next()) {
                obj[5] = rsMSP.getString("tenmausanpham");
            }
        int Soluong = 1;
        obj[6] = Soluong;
        obj[7] = BLL.ChuyenDoi.DinhDangTien(sp.getGiaNhap());
        double thanhTien = sp.getGiaNhap() * Soluong;
        obj[8] = sp.getDonViTinh();
        obj[9] = BLL.ChuyenDoi.DinhDangTien(thanhTien);
         JLabel lb = new JLabel();

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(sp.getAnhSanPham()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        lb.setIcon(imageIcon);
        obj[1] = lb;
        tableModel.addRow(obj);
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu chi tiết bán hàng", "Thông báo");
        }
        double tongTien = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(i, 9).toString());
            tongTien = tongTien + tien;
        }
        return tongTien;

    }
     public static double NhapSanPhamVaoPhieuNhapTrung(JTable tb, DTOSanPham sp, int SoLuong) {
         pnlthemphieunhap.tblChitietphieunhap.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
        Object obj[] = new Object[10];
        try {
        obj[0] = sp.getIDSanPham();
        obj[2] = sp.getMaSanPham();
        obj[3] = sp.getTenSanPham();
        int MaSize = sp.getIDSize();
            ResultSet rsSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
            if (rsSSP.next()) {
                obj[4] = rsSSP.getString("tensize");
            }
            int MaMau = sp.getIDMauSanPham();
            ResultSet rsMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
            if (rsMSP.next()) {
                obj[5] = rsMSP.getString("tenmausanpham");
            }
        int SoLuongMoi = SoLuong + 1;
            obj[6] = SoLuongMoi;
        obj[7] = BLL.ChuyenDoi.DinhDangTien(sp.getGiaNhap());
        double thanhTien = sp.getGiaNhap() * SoLuongMoi;
        obj[8] = sp.getDonViTinh();
        obj[9] = BLL.ChuyenDoi.DinhDangTien(thanhTien);
         JLabel lb = new JLabel();

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(sp.getAnhSanPham()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        lb.setIcon(imageIcon);
        obj[1] = lb;
        tableModel.addRow(obj);
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu chi tiết bán hàng", "Thông báo");
        }
        double tongTien = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(i, 9).toString());
            tongTien = tongTien + tien;
        }
        return tongTien;

    }
     public static double NhapSanPhamRiSizeVaoPhieuNhap(JTable tb, String TenSp,int SizeSP) {
         pnlthemphieunhap.tblChitietphieunhap.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
          ResultSet rs = DAO.DAOSanPham.LaySanPhamTheoTenSPSize(TenSp,SizeSP);
        DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
        Object obj[] = new Object[10];
        try {
               while (rs.next()) {
        obj[0] = rs.getInt("idsanpham");
        obj[2] = rs.getString("masanpham");
        obj[3] = rs.getString("tensanpham");
        int MaSize = rs.getInt("idsizesanpham");
            ResultSet rsSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
            if (rsSSP.next()) {
                obj[4] = rsSSP.getString("tensize");
            }
            int MaMau = rs.getInt("idmausanpham");
            ResultSet rsMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
            if (rsMSP.next()) {
                obj[5] = rsMSP.getString("tenmausanpham");
            }
        int Soluong = 1;
        obj[6] = Soluong;
        obj[7] = BLL.ChuyenDoi.DinhDangTien(rs.getDouble("gianhap"));
        double thanhTien = rs.getDouble("gianhap") * Soluong;
        obj[8] = rs.getString("donvitinh");
        obj[9] = BLL.ChuyenDoi.DinhDangTien(thanhTien);
         JLabel lb = new JLabel();

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(rs.getBytes("anhsanpham")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        lb.setIcon(imageIcon);
        obj[1] = lb;
        tableModel.addRow(obj);
               }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu chi tiết bán hàng", "Thông báo");
        }
        double tongTien = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(i, 9).toString());
            tongTien = tongTien + tien;
        }
        return tongTien;

    }
      public static double NhapSanPhamRiMauVaoPhieuNhap(JTable tb, String TenSp,int MauSP) {
         pnlthemphieunhap.tblChitietphieunhap.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
          ResultSet rs = DAO.DAOSanPham.LaySanPhamTheoTenSPMau(TenSp,MauSP);
        DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
        Object obj[] = new Object[10];
        try {
               while (rs.next()) {
        obj[0] = rs.getInt("idsanpham");
        obj[2] = rs.getString("masanpham");
        obj[3] = rs.getString("tensanpham");
        int MaSize = rs.getInt("idsizesanpham");
            ResultSet rsSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
            if (rsSSP.next()) {
                obj[4] = rsSSP.getString("tensize");
            }
            int MaMau = rs.getInt("idmausanpham");
            ResultSet rsMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
            if (rsMSP.next()) {
                obj[5] = rsMSP.getString("tenmausanpham");
            }
        int Soluong = 1;
        obj[6] = Soluong;
        obj[7] = BLL.ChuyenDoi.DinhDangTien(rs.getDouble("gianhap"));
        double thanhTien = rs.getDouble("gianhap") * Soluong;
        obj[8] = rs.getString("donvitinh");
        obj[9] = BLL.ChuyenDoi.DinhDangTien(thanhTien);
         JLabel lb = new JLabel();

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(rs.getBytes("anhsanpham")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        lb.setIcon(imageIcon);
        obj[1] = lb;
        tableModel.addRow(obj);
               }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu chi tiết bán hàng", "Thông báo");
        }
        double tongTien = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(i, 9).toString());
            tongTien = tongTien + tien;
        }
        return tongTien;

    }

    public static double SuaSanPhamVaoPhieuNhap(JTable tb, DTOSanPham sp, int SoLuong, double GiaNhap) {
         pnlthemphieunhap.tblChitietphieunhap.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
        Object obj[] = new Object[10];
        try {
        obj[0] = sp.getIDSanPham();
        obj[2] = sp.getMaSanPham();
        obj[3] = sp.getTenSanPham();
          int MaSize = sp.getIDSize();
            ResultSet rsSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
            if (rsSSP.next()) {
                obj[4] = rsSSP.getString("tensize");
            }
            int MaMau = sp.getIDMauSanPham();
            ResultSet rsMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
            if (rsMSP.next()) {
                obj[5] = rsMSP.getString("tenmausanpham");
            }
        obj[6] = SoLuong;
        obj[7] = BLL.ChuyenDoi.DinhDangTien((GiaNhap));
        double ThanhTien = GiaNhap * SoLuong;
        obj[8] = sp.getDonViTinh();
        obj[9] = BLL.ChuyenDoi.DinhDangTien(ThanhTien);
         JLabel lb = new JLabel();

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(sp.getAnhSanPham()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        lb.setIcon(imageIcon);
        obj[1] = lb;
        tableModel.addRow(obj);
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu chi tiết bán hàng", "Thông báo");
        }
        double tongTien = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(i, 9).toString());
            tongTien = tien;
        }
        return tongTien;
    }

    public static void ThemPhieuNhap(DTOPhieuNhap PN) {
        DAO.DAOPhieuNhap.ThemPhieNhap(PN);
    }
     public static void ThemIDPhieuNhap(DTOPhieuNhap PN) {
        DAO.DAOPhieuNhap.ThemIDPhieuNhap(PN);
    }

    public static int LayMaPhieuNhapString(String TenPN) {
        try {
            ResultSet rs = DAOPhieuNhap.GetByTenPN(TenPN);

            if (rs.next()) {
                return rs.getInt("idphieunhap");
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi Lấy Mã Phiếu Nhập !", "Thông Báo !");
        }
        return 0;
    }

    public static void ThemChiTietPhieuNhap(DTO.DTOChiTietPhieuNhap ctpn) {
        DAO.DAOChiTietPhieuNhap.ThemChiTietPhieuNhap(ctpn);
    }

    public static void SuaTonKhoGia(DTOKho kh) {
        DAO.DAOPhieuNhap.SuaTonKhoGia(kh);
    }
    
    public static void SuaPhieuNhap(DTOPhieuNhap pn) {
        DAO.DAOPhieuNhap.SuaPhieuNhap(pn);
    }

    public static void SuaNhapKhoPN(DTOPhieuNhap pn) {
        DAO.DAOPhieuNhap.SuaNhapKhoPN(pn);
    }

    public static void SuaTonKhoSP(DTOSanPham sp) {
        DAO.DAOPhieuNhap.SuaTonKhoSP(sp);
    }

    public static void SuaThanhToanPN(DTOPhieuNhap pn) {
        DAO.DAOPhieuNhap.SuaThanhToanPN(pn);
    }
    public static void TraNoPhieuNhap(DTOPhieuNhap pn) {
        DAO.DAOPhieuNhap.TraNoPhieuNhap(pn);
    }

}
