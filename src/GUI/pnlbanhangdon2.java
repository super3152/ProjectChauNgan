/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLLHoaDon;
import BLL.BLLSanPham;
import BLL.ChuyenDoi;
import DAO.DAOHoaDon;
import DAO.DAOKhachHang;
import DAO.DAOThuChi;

import DTO.DTOHoaDon;
import DTO.DTOKhachHang;
import DTO.DTOKho;
import DTO.DTOPhieuThuChi;
import DTO.DTOSanPham;
import DTO.MyCombobox;

import static GUI.jdlDanhSachDeTraHang.tblDanhSachTraHang;




import static GUI.pnlhanghoa.lblCountPage;
import static GUI.pnlhanghoa.lblNumberPage;
import static GUI.pnlhanghoa.tblHoaDon;
import static GUI.pnlhanghoa.txtTimKiemHD;
import static GUI.pnlkhachhang.btnLast;
import static GUI.pnlkhachhang.btnNext;

import static GUI.pnlkhachhang.lblCountPagekh;
import static GUI.pnlkhachhang.lblNumberPageKH;

import static GUI.pnlkhachhang.tblkhachhang;
import static GUI.pnlkhachhang.txtTimKiem;
import static GUI.pnlsanpham.btnLastK;
import static GUI.pnlsanpham.btnLastSP;
import static GUI.pnlsanpham.btnNextK;
import static GUI.pnlsanpham.btnNextSP;

import static GUI.pnlsanpham.lblCountPageK;
import static GUI.pnlsanpham.lblCountPageSP;
import static GUI.pnlsanpham.lblNumberPageK;
import static GUI.pnlsanpham.lblNumberPageSP;

import static GUI.pnlsanpham.tblKho;
import static GUI.pnlsanpham.tblSanPham;
import static GUI.pnlsanpham.txtTimKiemKho;
import static GUI.pnlsanpham.txtTimKiemSP;

import static GUI.pnlthongke.lblCountPageTC;
import static GUI.pnlthongke.lblNumberPageTC;

import static GUI.pnlthongke.tblThuChi;

import static GUI.pnlthongke.txtTimKiemTC;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Takemikazuchi
 */
public class pnlbanhangdon2 extends javax.swing.JPanel {

    public static int MaHD;
    public static String SoHoaDon;
    public static int MaHD1;
    public static String SoHoaDon1;
    public static int layidkh;
    public static int countHD, soTrangHD, trangHD = 1;
    public int trangHD1 = 1;
    public static int countKhachHang, soTrangKhachHang, trangKhachHang = 1;
    public int trangKhachHang1 = 1;
    public static int countSP, soTrangSP, trangSP = 1;
    public int trangSP1 = 1;
    public static int countKho, soTrangKho, trangKho = 1;
    public int trangKho1 = 1;
    public static int countThuChi, soTrangThuChi, trangThuChi = 1;
    public static int trangThuChi1 = 1;

    public pnlbanhangdon2() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        }

        initComponents();
        BLLSanPham.HienThiSanPhamBanHang(jTable1, txtTimSP.getText());
       
        jPopupMenu3.add(jPanel9);
        
         
        if (SoHoaDon == null) {
            FillSanPhamHayDung();
            menu.add(panel);
            BLL.BLLKhachHang.DoDuLieuVaoCBBKhachHang(cbbKhachHang);

            BLLSanPham.HienThiSanPhamBanHang(jTable1, txtTimSP.getText());

            cbbSize.removeAllItems();
            cbbSize.addItem("Size");
            cbbMau.removeAllItems();
            cbbMau.addItem("Màu");
            cbbSize.setEnabled(false);
            cbbMau.setEnabled(false);
            NgayGio();
        } else {
            FillSanPhamHayDungAn();
            DTO.DTOHoaDon hd = BLL.BLLHoaDon.GetMaHD(MaHD);
            txtSoHoaDon.setText(SoHoaDon);
            BLL.BLLKhachHang.SetCBBKhachHang(cbbKhachHang, hd.getMaKhachHang());
            txtNgayTao.setText(hd.getNgayTaoHoaDon());
            BLL.BLLHoaDon.DoSanPhamLenLaiHoaDon2(tblChiTietHoaDon, MaHD);
            txtTongTien.setText(ChuyenDoi.DinhDangTien(hd.getTongTien()));
            txtNo.setText(ChuyenDoi.DinhDangTien(hd.getCongNo()));
            System.out.println(hd.getHanTraCongNo());
            if (!hd.getHanTraCongNo().equals("01/01/1000")) {
                txtHanTraNo.setText(hd.getHanTraCongNo());
            } else {
                txtHanTraNo.setText("");
            }

            jdcHanTraCongNo.setDate(ChuyenDoi.GetDate(txtHanTraNo.getText()));

            for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
                double UuDai = 0;
                UuDai = UuDai + ChuyenDoi.ChuyenSangSo(tblChiTietHoaDon.getValueAt(i, 8).toString());
                txtUuDai.setText(ChuyenDoi.DinhDangTien(UuDai));
            }
            btnScanner.setEnabled(false);
            btnChonSP.setEnabled(false);
            txtTimSP.setEnabled(false);
            jPopupMenu3.show(false);
            tblChiTietHoaDon.setEnabled(false);
            cbbSize.setEnabled(false);
            cbbMau.setEnabled(false);
            txtSoHoaDon.setEnabled(false);
            txtNgayTao.setEnabled(false);
            txtUuDai.setEnabled(false);
            txtTongTien.setEnabled(false);
            btnMuaHang.setText("IN HÓA ĐƠN");
            txtThanhToan.setEnabled(false);
           

        }
        
        
       
        
        
        
        

    }

    pnlbanhangdon2(int MaHD, String SoHoaDon) {
        pnlbanhangdon2.MaHD = MaHD;
        pnlbanhangdon2.SoHoaDon = SoHoaDon;
    }

    public void NgayGio() {
        Thread clock;
        clock = new Thread() {
            @Override
            public void run() {
                while (true) {
                    SimpleDateFormat formattime = new SimpleDateFormat("hh:mm:ss");
                    SimpleDateFormat formatday = new SimpleDateFormat("yyyy/MM/dd");
                    Calendar cal = new GregorianCalendar();
                    String time, day;
                    time = formattime.format(cal.getTime());
                    day = formatday.format(cal.getTime());

                    txtNgayTao.setText(day);
                
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.toString());
                    }
                }
            }
        };
        clock.start();

    }

    private void FillSanPhamHayDung() {

        jPanel20.removeAll();

        ArrayList<DTOSanPham> sanpham = DAO.DAOHoaDon.GetSanPhamHayDung();
        ArrayList<Boolean> checkclick = new ArrayList<>();
        JPanel[] pnlBan = new JPanel[sanpham.size()];
        JLabel[] lblImgBan = new JLabel[sanpham.size()];
        JLabel[] lblTenBan = new JLabel[sanpham.size()];
        int i = 0;
        final int fu = i;
        for (i = 0; i < sanpham.size(); i++) {
            checkclick.add(i, false);

            pnlBan[i] = new javax.swing.JPanel();
            lblImgBan[i] = new javax.swing.JLabel();
            lblTenBan[i] = new javax.swing.JLabel();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(sanpham.get(i).getAnhSanPham()).getImage().getScaledInstance(90, 70, Image.SCALE_SMOOTH));
            lblImgBan[i].setIcon(imageIcon);
            lblTenBan[i].setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            lblTenBan[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTenBan[i].setText(sanpham.get(i).getTenSanPham());
            int MaSP = sanpham.get(i).getIDSanPham();

            javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan[i]);
            pnlBan[i].setLayout(pnlBanLayout);
            pnlBanLayout.setHorizontalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblImgBan[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTenBan[i], javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(21, Short.MAX_VALUE))
            );
            pnlBanLayout.setVerticalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblImgBan[i])
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTenBan[i])
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            int j = i;
            pnlBan[j].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSP);
                    for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
                        int MaSPB = (int) tblChiTietHoaDon.getValueAt(i, 0);
                        int SoLuong = (int) tblChiTietHoaDon.getValueAt(i, 6);
                        double UuDai = ChuyenDoi.ChuyenSangSo(tblChiTietHoaDon.getValueAt(i, 8).toString());
                        double TongTien = ChuyenDoi.ChuyenSangSo(tblChiTietHoaDon.getValueAt(i, 9).toString());

                        if (MaSP == MaSPB) {
                            if (sp.getTonKho() == SoLuong) {
                                ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng vui lòng nhập thêm!", "Thông Báo");
                                return;
                            }
                            DefaultTableModel model = (DefaultTableModel) tblChiTietHoaDon.getModel();
                            model.removeRow(i);
                            double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDonTrung(tblChiTietHoaDon, sp, SoLuong, UuDai);
                            double TongTienCu = ChuyenDoi.ChuyenSangSo(txtTongTien.getText());
                            double TongTienTru = TongTienCu - TongTien;
                            double TongTienMoi = TongTienTru + tongTien;
                            txtTongTien.setText(ChuyenDoi.DinhDangTien(TongTienMoi));
                            MyCombobox cbbKH = (MyCombobox) cbbKhachHang.getSelectedItem();
                            int MaKhachHang = (int) cbbKH.Value;
                            DTO.DTOKhachHang khl = BLL.BLLKhachHang.GetMaKH(MaKhachHang);
                            if (khl.getIdLoaiKhachHang() == 1 || khl.getIdLoaiKhachHang() == 2) {
                                txtNo.setText("0");
                                jdcHanTraCongNo.setDate(null);
                                txtHanTraNo.setText("");
                                jdcHanTraCongNo.setEnabled(false);
                            } else if (khl.getIdLoaiKhachHang() == 3) {
                                double Tongtien, TienTra, No;
                                Tongtien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
                                TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
                                No = Tongtien - TienTra;
                                txtNo.setText(BLL.ChuyenDoi.DinhDangTien(No));
                                if (TienTra > Tongtien) {
                                    txtNo.setText("0");
                                }
                                if (txtNo.getText().equals("0")) {
                                    jdcHanTraCongNo.setDate(null);
                                    jdcHanTraCongNo.setEnabled(false);
                                } else {
                                    jdcHanTraCongNo.setEnabled(true);
                                    Date date = new Date();
                                    jdcHanTraCongNo.setDate(date);
                                    txtHanTraNo.setText(ChuyenDoi.DinhDangNgay(jdcHanTraCongNo.getDate()));
                                }

                            }
                            return;
                        }
                    }

                    if (sp.getTonKho() <= 0) {
                        ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng!", "Thông Báo");
                        return;
                    }
                    int SoLuong = 1;
                    double UuDai = 0;

                    double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDon(tblChiTietHoaDon, sp, SoLuong, UuDai);
                    txtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));
                    for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
                        double UuDaiBang = ChuyenDoi.ChuyenSangSo(tblChiTietHoaDon.getValueAt(i, 8).toString());
                        double UuDaiT = ChuyenDoi.ChuyenSangSo(txtUuDai.getText());
                        txtUuDai.setText(ChuyenDoi.DinhDangTien(BLLHoaDon.TinhUuDai));
                    }

                    if (txtSoHoaDon.getText().equals("")) {

                        txtSoHoaDon.setText(BLL.BLLHoaDon.TaoSoHoaDon());

                    }
                    MyCombobox cbbKH = (MyCombobox) cbbKhachHang.getSelectedItem();
                    int MaKhachHang = (int) cbbKH.Value;
                    DTO.DTOKhachHang khl = BLL.BLLKhachHang.GetMaKH(MaKhachHang);
                    if (khl.getIdLoaiKhachHang() == 1 || khl.getIdLoaiKhachHang() == 2) {
                        txtNo.setText("0");
                        jdcHanTraCongNo.setDate(null);
                        txtHanTraNo.setText("");
                        jdcHanTraCongNo.setEnabled(false);
                    } else if (khl.getIdLoaiKhachHang() == 3) {
                        double TongTien, TienTra, No;
                        TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
                        TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
                        No = TongTien - TienTra;
                        txtNo.setText(BLL.ChuyenDoi.DinhDangTien(No));
                        if (TienTra > TongTien) {
                            txtNo.setText("0");
                        }
                        if (txtNo.getText().equals("0")) {
                            jdcHanTraCongNo.setDate(null);
                            jdcHanTraCongNo.setEnabled(false);
                        } else {
                            jdcHanTraCongNo.setEnabled(true);
                            Date date = new Date();
                            jdcHanTraCongNo.setDate(date);
                            txtHanTraNo.setText(ChuyenDoi.DinhDangNgay(jdcHanTraCongNo.getDate()));
                        }

                    }

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    e.getComponent().setBackground(Color.GRAY);

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (checkclick.get(j)) {
                        e.getComponent().setBackground(Color.GRAY);

                    } else {

                        e.getComponent().setBackground(new java.awt.Color(240, 240, 240));
                    }
                }
            });
            jPanel20.add(pnlBan[i]);
        }
        jPanel20.updateUI();
    }

    private void FillSanPhamHayDungAn() {

        jPanel20.removeAll();

        ArrayList<DTOSanPham> sanpham = DAO.DAOHoaDon.GetSanPhamHayDung();
        ArrayList<Boolean> checkclick = new ArrayList<>();
        JPanel[] pnlBan = new JPanel[sanpham.size()];
        JLabel[] lblImgBan = new JLabel[sanpham.size()];
        JLabel[] lblTenBan = new JLabel[sanpham.size()];
        int i = 0;
        final int fu = i;
        for (i = 0; i < sanpham.size(); i++) {
            checkclick.add(i, false);

            pnlBan[i] = new javax.swing.JPanel();
            lblImgBan[i] = new javax.swing.JLabel();
            lblTenBan[i] = new javax.swing.JLabel();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(sanpham.get(i).getAnhSanPham()).getImage().getScaledInstance(90, 70, Image.SCALE_SMOOTH));
            lblImgBan[i].setIcon(imageIcon);
            lblTenBan[i].setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            lblTenBan[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblTenBan[i].setText(sanpham.get(i).getTenSanPham());
            int MaSP = sanpham.get(i).getIDSanPham();

            javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan[i]);
            pnlBan[i].setLayout(pnlBanLayout);
            pnlBanLayout.setHorizontalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblImgBan[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTenBan[i], javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(21, Short.MAX_VALUE))
            );
            pnlBanLayout.setVerticalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblImgBan[i])
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblTenBan[i])
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            int j = i;
            pnlBan[j].addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    e.getComponent().setBackground(Color.GRAY);

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (checkclick.get(j)) {
                        e.getComponent().setBackground(Color.GRAY);

                    } else {

                        e.getComponent().setBackground(new java.awt.Color(240, 240, 240));
                    }
                }
            });
            jPanel20.add(pnlBan[i]);
        }
        jPanel20.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        list = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        menu = new javax.swing.JPopupMenu();
        pnlnennhanvienphutrach1 = new javax.swing.JPanel();
        lblnhomkhachhang6 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        txtHanTraNo = new javax.swing.JTextField();
        pnlnenthemdon = new javax.swing.JPanel();
        txtsodon = new javax.swing.JTextField();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jPanel12 = new javax.swing.JPanel();
        pnlDonHang = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnMuaHang = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        pnlnennhomkhachhang4 = new javax.swing.JPanel();
        lblnhomkhachhang8 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        pnlnennhomkhachhang5 = new javax.swing.JPanel();
        lblnhomkhachhang7 = new javax.swing.JLabel();
        txtSoHoaDon = new javax.swing.JTextField();
        pnlnennhomkhachhang3 = new javax.swing.JPanel();
        lblnhomkhachhang9 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        lblidkh = new javax.swing.JLabel();
        pnlnennhomkhachhang6 = new javax.swing.JPanel();
        lblnhomkhachhang10 = new javax.swing.JLabel();
        txtUuDai = new javax.swing.JTextField();
        pnlnennhomkhachhang7 = new javax.swing.JPanel();
        lblnhomkhachhang11 = new javax.swing.JLabel();
        txtThanhToan = new javax.swing.JTextField();
        pnlnennhomkhachhang8 = new javax.swing.JPanel();
        lblnhomkhachhang12 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        pnlnennhomkhachhang9 = new javax.swing.JPanel();
        lblnhomkhachhang13 = new javax.swing.JLabel();
        txtNo = new javax.swing.JTextField();
        pnlnennhomkhachhang10 = new javax.swing.JPanel();
        lblnhomkhachhang14 = new javax.swing.JLabel();
        jdcHanTraCongNo = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInHoaDon = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        cbbSize = new javax.swing.JComboBox<>();
        cbbMau = new javax.swing.JComboBox<>();
        btnChonSP = new javax.swing.JButton();
        btnScanner = new javax.swing.JButton();
        txtTimSP = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietHoaDon = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        panel.setPreferredSize(new java.awt.Dimension(560, 130));

        list.setBorder(null);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list.setViewportView(jList1);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(list)
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
        );

        pnlnennhanvienphutrach1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhanvienphutrach1.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang6.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang6.setText("Ngày tạo");
        lblnhomkhachhang6.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhanvienphutrach1.add(lblnhomkhachhang6, java.awt.BorderLayout.PAGE_START);

        txtNgayTao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayTaoActionPerformed(evt);
            }
        });
        pnlnennhanvienphutrach1.add(txtNgayTao, java.awt.BorderLayout.CENTER);

        txtHanTraNo.setText("jTextField1");

        pnlnenthemdon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtsodon.setText("jTextField1");

        jMenuItem1.setText("Xóa đơn");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jScrollPane3.setBorder(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tìm kiếm "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
        );

        jPopupMenu3.setFocusable(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(225, 226, 226));
        setPreferredSize(new java.awt.Dimension(980, 619));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(266, 70));

        btnMuaHang.setBackground(new java.awt.Color(255, 255, 255));
        btnMuaHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMuaHang.setForeground(new java.awt.Color(255, 255, 255));
        btnMuaHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/thanhtoan.jpg"))); // NOI18N
        btnMuaHang.setText("THANH TOÁN");
        btnMuaHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btnMuaHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMuaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMuaHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN ĐƠN HÀNG 2");

        pnlnennhomkhachhang4.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang4.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang8.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang8.setText("Tổng tiền");
        lblnhomkhachhang8.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang4.add(lblnhomkhachhang8, java.awt.BorderLayout.PAGE_START);

        txtTongTien.setEditable(false);
        txtTongTien.setText("0");
        pnlnennhomkhachhang4.add(txtTongTien, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang5.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang5.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang7.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang7.setText("Số Hóa Đơn");
        lblnhomkhachhang7.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang5.add(lblnhomkhachhang7, java.awt.BorderLayout.PAGE_START);

        txtSoHoaDon.setEditable(false);
        pnlnennhomkhachhang5.add(txtSoHoaDon, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang3.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang3.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang9.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang9.setText("Khách Hàng");
        lblnhomkhachhang9.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang3.add(lblnhomkhachhang9, java.awt.BorderLayout.PAGE_START);

        cbbKhachHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhachHangItemStateChanged(evt);
            }
        });
        cbbKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhachHangActionPerformed(evt);
            }
        });
        pnlnennhomkhachhang3.add(cbbKhachHang, java.awt.BorderLayout.CENTER);

        lblidkh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblidkh.setForeground(new java.awt.Color(255, 0, 0));
        lblidkh.setText("Loại KH");
        lblidkh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlnennhomkhachhang3.add(lblidkh, java.awt.BorderLayout.LINE_END);

        pnlnennhomkhachhang6.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang6.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang10.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang10.setText("Ưu Đãi");
        lblnhomkhachhang10.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang6.add(lblnhomkhachhang10, java.awt.BorderLayout.PAGE_START);

        txtUuDai.setText("0");
        txtUuDai.setEnabled(false);
        pnlnennhomkhachhang6.add(txtUuDai, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang7.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang7.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang11.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang11.setText("Tiền khách đưa");
        lblnhomkhachhang11.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang7.add(lblnhomkhachhang11, java.awt.BorderLayout.PAGE_START);

        txtThanhToan.setText("0");
        txtThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhToanActionPerformed(evt);
            }
        });
        txtThanhToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtThanhToanKeyReleased(evt);
            }
        });
        pnlnennhomkhachhang7.add(txtThanhToan, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang8.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang8.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang12.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang12.setText("Tiền thừa");
        lblnhomkhachhang12.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang8.add(lblnhomkhachhang12, java.awt.BorderLayout.PAGE_START);

        txtTienThua.setEditable(false);
        txtTienThua.setText("0");
        pnlnennhomkhachhang8.add(txtTienThua, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang9.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang9.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang13.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang13.setText("Nợ");
        lblnhomkhachhang13.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang9.add(lblnhomkhachhang13, java.awt.BorderLayout.PAGE_START);

        txtNo.setText("0");
        txtNo.setEnabled(false);
        pnlnennhomkhachhang9.add(txtNo, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang10.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang10.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang14.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang14.setText("Hạn trả");
        lblnhomkhachhang14.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang10.add(lblnhomkhachhang14, java.awt.BorderLayout.PAGE_START);

        jdcHanTraCongNo.setDateFormatString("dd/MM/yyyy");
        jdcHanTraCongNo.setEnabled(false);
        jdcHanTraCongNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jdcHanTraCongNoKeyReleased(evt);
            }
        });
        pnlnennhomkhachhang10.add(jdcHanTraCongNo, java.awt.BorderLayout.CENTER);

        txtInHoaDon.setColumns(20);
        txtInHoaDon.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtInHoaDon.setRows(5);
        txtInHoaDon.setToolTipText("");
        jScrollPane2.setViewportView(txtInHoaDon);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnennhomkhachhang4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang5, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang6, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang7, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang8, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang9, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(pnlnennhomkhachhang10, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlnennhomkhachhang5, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang6, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang7, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang8, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang9, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang10, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnennhomkhachhang4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setPreferredSize(new java.awt.Dimension(694, 40));

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Size" }));
        cbbSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSizeItemStateChanged(evt);
            }
        });
        cbbSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbSizeMouseClicked(evt);
            }
        });
        cbbSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbbSizeKeyReleased(evt);
            }
        });

        cbbMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Màu" }));
        cbbMau.setToolTipText("");
        cbbMau.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMauItemStateChanged(evt);
            }
        });
        cbbMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauActionPerformed(evt);
            }
        });

        btnChonSP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnChonSP.setForeground(new java.awt.Color(255, 0, 0));
        btnChonSP.setText("Thêm");
        btnChonSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSPActionPerformed(evt);
            }
        });

        btnScanner.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnScanner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/iris_scan_20px.png"))); // NOI18N
        btnScanner.setText("Scanner");
        btnScanner.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnScanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScannerActionPerformed(evt);
            }
        });

        txtTimSP.setText("Gõ để tìm sản phẩm");
        txtTimSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimSPMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtTimSPMouseReleased(evt);
            }
        });
        txtTimSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimSPKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Làm mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnScanner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimSP, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChonSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChonSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnScanner, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbMau)
                            .addComponent(cbbSize))))
                .addContainerGap())
        );

        jPanel3.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ảnh", "Mã SP", "Tên SP", "Size", "Màu", "Số lượng", "Đơn giá", "Ưu đãi", "Thành tiền", "Xóa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChiTietHoaDon.setRowHeight(60);
        tblChiTietHoaDon.setShowVerticalLines(false);
        tblChiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietHoaDonMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblChiTietHoaDonMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblChiTietHoaDon);
        if (tblChiTietHoaDon.getColumnModel().getColumnCount() > 0) {
            tblChiTietHoaDon.getColumnModel().getColumn(0).setMinWidth(0);
            tblChiTietHoaDon.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblChiTietHoaDon.getColumnModel().getColumn(0).setMaxWidth(0);
            tblChiTietHoaDon.getColumnModel().getColumn(1).setMinWidth(50);
            tblChiTietHoaDon.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblChiTietHoaDon.getColumnModel().getColumn(1).setMaxWidth(50);
            tblChiTietHoaDon.getColumnModel().getColumn(4).setMinWidth(50);
            tblChiTietHoaDon.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblChiTietHoaDon.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("  Hay Mua");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel4.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setLayout(new javax.swing.BoxLayout(jPanel20, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel22.setLayout(new java.awt.BorderLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quần Jean");
        jPanel22.add(jLabel6, java.awt.BorderLayout.PAGE_END);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.add(jLabel7, java.awt.BorderLayout.CENTER);

        jPanel22.add(jPanel13, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel1);

        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel23.setLayout(new java.awt.BorderLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Áo Nike");
        jPanel23.add(jLabel8, java.awt.BorderLayout.PAGE_END);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.BorderLayout());

        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel14.add(jLabel9, java.awt.BorderLayout.CENTER);

        jPanel23.add(jPanel14, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel17);

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel24.setLayout(new java.awt.BorderLayout());

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Sản phẩm");
        jPanel24.add(jLabel10, java.awt.BorderLayout.PAGE_END);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel15.add(jLabel11, java.awt.BorderLayout.CENTER);

        jPanel24.add(jPanel15, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel18);

        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel25.setLayout(new java.awt.BorderLayout());

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Sản phẩm");
        jPanel25.add(jLabel12, java.awt.BorderLayout.PAGE_END);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setLayout(new java.awt.BorderLayout());

        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel26.add(jLabel13, java.awt.BorderLayout.CENTER);

        jPanel25.add(jPanel26, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel19);

        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel27.setLayout(new java.awt.BorderLayout());

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Sản phẩm");
        jPanel27.add(jLabel14, java.awt.BorderLayout.PAGE_END);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel28.add(jLabel15, java.awt.BorderLayout.CENTER);

        jPanel27.add(jPanel28, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel21);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel29.setLayout(new java.awt.BorderLayout());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Sản phẩm");
        jPanel29.add(jLabel16, java.awt.BorderLayout.PAGE_END);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setLayout(new java.awt.BorderLayout());

        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel30.add(jLabel17, java.awt.BorderLayout.CENTER);

        jPanel29.add(jPanel30, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
        );

        jPanel20.add(jPanel10);

        jPanel4.add(jPanel20, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlDonHangLayout = new javax.swing.GroupLayout(pnlDonHang);
        pnlDonHang.setLayout(pnlDonHangLayout);
        pnlDonHangLayout.setHorizontalGroup(
            pnlDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDonHangLayout.createSequentialGroup()
                .addGroup(pnlDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDonHangLayout.setVerticalGroup(
            pnlDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDonHangLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDonHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlDonHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnMuaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMuaHangActionPerformed
        if (btnMuaHang.getText().equals("IN HÓA ĐƠN")) {
            BillHoaDon();
            int ketquasaukhibam = JOptionPane.showConfirmDialog(new JFrame(),
                    "Bạn Có Muốn In Hóa Đơn Không ?", //thông báo
                    "Thông Báo !", //tiêu đề
                    JOptionPane.YES_NO_OPTION, //lựa chọn
                    JOptionPane.ERROR_MESSAGE); // icon

            if (ketquasaukhibam == JOptionPane.YES_OPTION) {
                printRecord(txtInHoaDon);
                txtInHoaDon.setText("");
            }
            return;
        }

        int dongDuocChon = tblChiTietHoaDon.getRowCount();
        if (dongDuocChon == 0) {
            ThongBaoCanhBao.ThongBao("Bạn chưa có sản phẩm không thể thanh toán !", "Thông Báo !");
            return;
        }
        DTO.DTOKhachHang khl = BLL.BLLKhachHang.GetTenKH(cbbKhachHang.getSelectedItem().toString());
        if (khl.getIdLoaiKhachHang() == 1 || khl.getIdLoaiKhachHang() == 2) {
            if (BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText()) < BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText())) {
                ThongBaoCanhBao.ThongBao("Khách chưa trả đủ tiền !", "Thông Báo !");
                return;
            }
        }
        if (txtSoHoaDon.getText() != null) {
            String SoHoaDon;
            int MaNV;
            int MaKhachHang;
            int TinhTrang;
            int TraHang;
            double TongTien;

            SoHoaDon = txtSoHoaDon.getText();
            String NgayTaoHD = txtNgayTao.getText();
            MaNV = BLL.BLLHoaDon.LayMaNhanVienString(BLL.BLLlogin.nguoidung.getTenNguoiDung());
            TinhTrang = 0;
            TraHang = 0;
            TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());

            MyCombobox cbbKH = (MyCombobox) cbbKhachHang.getSelectedItem();
            MaKhachHang = (int) cbbKH.Value;
            double CongNo = 0;
            String HanTraCongNo = "1000-01-01";

            DTOHoaDon HD = new DTOHoaDon(SoHoaDon, NgayTaoHD, MaNV, TinhTrang, TongTien, MaKhachHang, TraHang, CongNo, HanTraCongNo);

            BLL.BLLHoaDon.ThemHoaDon(HD);
            DTO.DTOKhachHang lkh = BLL.BLLKhachHang.GetMaKH(MaKhachHang);
            double TongTienHangBang = lkh.getTongTienHang();
            double TongTienHang = TongTienHangBang + TongTien;
            DTO.DTOKhachHang skh = new DTO.DTOKhachHang(MaKhachHang, NgayTaoHD, TongTienHang);

            BLL.BLLKhachHang.SuaHoaDonKhachHang(skh);
            int MaLoaiKhachHang;
            DTO.DTOKhachHang lkhs = BLL.BLLKhachHang.GetMaKH(MaKhachHang);
            double TongTienHangBangSau = lkhs.getTongTienHang();
            if (lkhs.getIdLoaiKhachHang() == 1 && !lkhs.getTenKhachHang().equals("Khách Vãng Lai")) {
                if (TongTienHangBangSau >= 1000000) {
                    MaLoaiKhachHang = 2;
                    DTOKhachHang lkh2 = new DTOKhachHang(MaKhachHang, MaLoaiKhachHang);
                    BLL.BLLKhachHang.SuaLoaiKhachHang(lkh2);
                }
            }
            if (lkhs.getIdLoaiKhachHang() == 2) {
                if (TongTienHangBangSau >= 5000000) {
                    MaLoaiKhachHang = 3;
                    DTOKhachHang lkh3 = new DTOKhachHang(MaKhachHang, MaLoaiKhachHang);
                    BLL.BLLKhachHang.SuaLoaiKhachHang(lkh3);
                }
            }

            ThongBaoCanhBao.ThongBao("Đặt hàng thành công !", "Thông Báo !");
            BillHoaDon();

            int MaHD = BLL.BLLHoaDon.LayMaHoaDonString(SoHoaDon);
            for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {

                int MaSP = Integer.parseInt(tblChiTietHoaDon.getValueAt(i, 0).toString());
                int SoLuong = Integer.parseInt(tblChiTietHoaDon.getValueAt(i, 6).toString());
                double ChietKhau = BLL.ChuyenDoi.ChuyenTien(tblChiTietHoaDon.getValueAt(i, 8).toString());
                double ThanhTien = BLL.ChuyenDoi.ChuyenTien(tblChiTietHoaDon.getValueAt(i, 9).toString());
                String GhiChu = "Mới";
                DTO.DTOChiTietHoaDon cthd = new DTO.DTOChiTietHoaDon(MaHD, MaSP, SoLuong, ThanhTien, ChietKhau, GhiChu);
                BLL.BLLHoaDon.ThemChiTietHoaDon(cthd);

                DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSP);

                int SoLuongTrongBang = sp.getTonKho();
                int SoLuongSauKhiDatHang = SoLuongTrongBang - SoLuong;

                DTOSanPham spp = new DTOSanPham(MaSP, SoLuongSauKhiDatHang);
                BLL.BLLHoaDon.SuaSoLuongChoSP(spp);
                DTO.DTOKho kh = BLL.BLLKho.GetKhoTheoIDSP(MaSP);
                int HangDangVe = kh.getHangDangVe();
                DTOKho stkh = new DTOKho(MaSP, SoLuongSauKhiDatHang, HangDangVe);

                BLL.BLLHoaDon.SuaTonKhoTrongKho(stkh);
            }
        }
        MyCombobox cbbKH = (MyCombobox) cbbKhachHang.getSelectedItem();
        int MaKhachHang = (int) cbbKH.Value;
        DTO.DTOKhachHang lkh = BLL.BLLKhachHang.GetMaKH(MaKhachHang);
        double CongNoBang = lkh.getCongNo();
        double CongNo = ChuyenDoi.ChuyenSangSo(txtNo.getText());
        double CongNoSua = CongNoBang + CongNo;

        String SoHoaDon = txtSoHoaDon.getText();
        if (khl.getIdLoaiKhachHang() == 1 || khl.getIdLoaiKhachHang() == 2) {
            int TinhTrang = 1;
            DTOHoaDon HD = new DTOHoaDon(SoHoaDon, TinhTrang);
            BLL.BLLHoaDon.SuaTrangThaiHoaDon(HD);
        }
        if (khl.getIdLoaiKhachHang() == 3) {
            if (txtNo.getText().equals("0")) {
                int TinhTrang = 1;
                DTOHoaDon HD = new DTOHoaDon(SoHoaDon, TinhTrang);
                BLL.BLLHoaDon.SuaTrangThaiHoaDon(HD);
            } else {
                int TinhTrang = 2;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                String HanTraCongNo = sdf.format(jdcHanTraCongNo.getDate());
                DTOHoaDon HD = new DTOHoaDon(SoHoaDon, TinhTrang, CongNo, HanTraCongNo);
                BLL.BLLHoaDon.SuaTrangThaiHanNoHoaDon(HD);
                DTO.DTOKhachHang skh = new DTO.DTOKhachHang(MaKhachHang, CongNoSua);
                BLL.BLLKhachHang.SuaNoTraHangKhachHang(skh);
            }

        }
        String MaThuChi = BLL.BLLThuChi.TaoSoHoaDon();
        String LoaiPhieu = "Phiếu Thu";
        String HangMucThuChi = "Bán Hàng";
        double TongTien;
        double TongTienHang = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
        double TienThanhToan = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
        if (TienThanhToan >= TongTienHang) {
            TongTien = TongTienHang;
        } else {
            TongTien = TienThanhToan;
        }
        String GhiChu = "Thu Hóa Đơn " + SoHoaDon + "";
        DTOPhieuThuChi ptc = new DTOPhieuThuChi(MaThuChi, MaKhachHang, LoaiPhieu, HangMucThuChi, TongTien, GhiChu);
        BLL.BLLThuChi.ThemThuChiKH(ptc);

        DefaultTableModel dtm = (DefaultTableModel) tblChiTietHoaDon.getModel();
        dtm.setRowCount(0);
        int ketquasaukhibam = JOptionPane.showConfirmDialog(new JFrame(),
                "Bạn Có Muốn In Hóa Đơn Không ?", //thông báo
                "Thông Báo !", //tiêu đề
                JOptionPane.YES_NO_OPTION, //lựa chọn
                JOptionPane.ERROR_MESSAGE); // icon

        if (ketquasaukhibam == JOptionPane.YES_OPTION) {

            printRecord(txtInHoaDon);
            txtInHoaDon.setText("");
        }
        txtTimSP.setText("Gõ để tìm sản phẩm");
        txtInHoaDon.setText("");
        txtSoHoaDon.setText("");
        txtUuDai.setText("0");
        txtThanhToan.setText("0");
        txtTienThua.setText("0");
        txtNo.setText("0");
        jdcHanTraCongNo.setDate(null);
        txtHanTraNo.setText("");
        txtTongTien.setText("0");
        cbbSize.removeAllItems();
        cbbSize.addItem("Size");
        cbbMau.removeAllItems();
        cbbMau.addItem("Màu");
        cbbSize.setEnabled(false);
        cbbMau.setEnabled(false);
        DefaultTableModel tbModel = (DefaultTableModel) tblChiTietHoaDon.getModel();
        tbModel.setRowCount(0);
        DAOHoaDon.CountHoaDon();

        if (countHD % 13 == 0) {
            soTrangHD = countHD / 13;
        } else {
            soTrangHD = countHD / 13 + 1;
        }
        BLL.BLLHoaDon.HienThiHoaDon(tblHoaDon, txtTimKiemHD.getText(), 0);
        lblCountPage.setText(trangHD1 + "/" + soTrangHD + "");
        lblNumberPage.setText(trangHD1 + "");

        DAO.DAOKhachHang.CountKhachHang();

        if (countKhachHang % 13 == 0) {
            soTrangKhachHang = countKhachHang / 13;
            System.out.println("1");
        } else {
            if (countKhachHang < 13) {
                soTrangKhachHang = 1;
                btnLast.setEnabled(false);
                btnNext.setEnabled(false);
                System.out.println("2");
            } else {
                soTrangKhachHang = countKhachHang / 13 + 1;
                System.out.println("3");
            }

        }

        txtTimKiem.setText("");
        BLL.BLLKhachHang.HienThiKhachHang(tblkhachhang, txtTimKiem.getText(), 0);
        lblCountPagekh.setText(trangKhachHang1 + "/" + soTrangKhachHang + "");
        lblNumberPageKH.setText(trangKhachHang1 + "");

        DAO.DAOSanPham.CountSanPham();
        if (countSP % 10 == 0) {
            soTrangSP = countSP / 10;
        } else {
            soTrangSP = countSP / 10 + 1;
        }

        BLL.BLLSanPham.HienThiSanPham(tblSanPham, 0, txtTimKiemSP.getText());
        lblCountPageSP.setText(trangSP1 + "/" + soTrangSP + "");
        lblNumberPageSP.setText(trangSP1 + "");
        if (trangSP1 == soTrangSP) {
            btnLastSP.setEnabled(false);
            btnNextSP.setEnabled(false);
        }
        DAO.DAOKho.CountKho();
        if (countKho % 13 == 0) {
            soTrangKho = countKho / 13;
        } else {
            if (countKho < 13) {
                soTrangKho = 1;
                btnLastK.setEnabled(false);
                btnNextK.setEnabled(false);
            } else {
                soTrangKho = countKho / 13 + 1;
            }

        }
        BLL.BLLKho.HienThiKho(tblKho, txtTimKiemKho.getText(), 0);
        lblCountPageK.setText(trangKho1 + "/" + soTrangKho + "");
        lblNumberPageK.setText(trangKho1 + "");
        
        DAOThuChi.CountThuChi();
                 if (countThuChi % 9 == 0) {
            soTrangThuChi = countThuChi / 9;
        } else {
            soTrangThuChi = countThuChi / 9 + 1;
        }
           BLL.BLLThuChi.HienThiPhieuThuChi(tblThuChi, txtTimKiemTC.getText(),0);
        lblCountPageTC.setText(trangThuChi1 +"/"+ soTrangThuChi+"");
        lblNumberPageTC.setText(trangThuChi1+"");

        BLL.BLLTraHang.HienThiHoaDonTheoTraHang(tblDanhSachTraHang);
    }//GEN-LAST:event_btnMuaHangActionPerformed

    private void tblChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietHoaDonMouseClicked
        if (SoHoaDon == null) {
            if (evt.getClickCount() == 2) {
                int dongDuocChon = tblChiTietHoaDon.getSelectedRow();
                double ThanhTien = BLL.ChuyenDoi.ChuyenTien(tblChiTietHoaDon.getValueAt(dongDuocChon, 9).toString());
                double TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
                TongTien = TongTien - ThanhTien;
                double UuDai = BLL.ChuyenDoi.ChuyenTien(tblChiTietHoaDon.getValueAt(dongDuocChon, 8).toString());
                double TongUuDai = BLL.ChuyenDoi.ChuyenTien(txtUuDai.getText());
                TongUuDai = TongUuDai - UuDai;

                txtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(TongTien));
                txtUuDai.setText(BLL.ChuyenDoi.DinhDangTien(TongUuDai));

                jdlChinhSanPhamHoaDon jdlCTHD = new jdlChinhSanPhamHoaDon(new javax.swing.JFrame(), true);
                jdlCTHD.setVisible(true);
                try {

                    DefaultTableModel tbModel = (DefaultTableModel) tblChiTietHoaDon.getModel();
                    tbModel.removeRow(dongDuocChon);

                } catch (Exception e) {
                }

            }
        }


    }//GEN-LAST:event_tblChiTietHoaDonMouseClicked
    public static int so = 1;

    private void btnChonSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSPActionPerformed

        if (cbbSize.getSelectedItem().equals("Size")) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn size sản phẩm để mua hàng", "Thông Báo");
            return;
        }
        if (cbbMau.getSelectedItem().equals("Màu")) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn màu sản phẩm để mua hàng", "Thông Báo");
            return;
        }
        int column = 0;
        int row = pnlbanhangdon2.jTable1.getSelectedRow();
        String value = pnlbanhangdon2.jTable1.getModel().getValueAt(row, column).toString();
        MyCombobox mbs = (MyCombobox) cbbSize.getSelectedItem();
        int MaSize = Integer.parseInt(mbs.Value.toString());
        MyCombobox mbm = (MyCombobox) cbbMau.getSelectedItem();
        int MaMau = Integer.parseInt(mbm.Value.toString());
        int MaSP = BLL.BLLSanPham.LayMaSanPhamString(value, MaSize, MaMau);
        DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSP);
        for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
            int MaSPB = (int) tblChiTietHoaDon.getValueAt(i, 0);

            int SoLuong = (int) tblChiTietHoaDon.getValueAt(i, 6);
            double UuDai = ChuyenDoi.ChuyenSangSo(tblChiTietHoaDon.getValueAt(i, 8).toString());
            double TongTien = ChuyenDoi.ChuyenSangSo(tblChiTietHoaDon.getValueAt(i, 9).toString());

            if (MaSP == MaSPB) {
                if (sp.getTonKho() == SoLuong) {
                    ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng vui lòng nhập thêm!", "Thông Báo");
                    return;
                }
                DefaultTableModel model = (DefaultTableModel) tblChiTietHoaDon.getModel();
                model.removeRow(i);
                double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDonTrungdon2(tblChiTietHoaDon, sp, SoLuong, UuDai);
                double TongTienCu = ChuyenDoi.ChuyenSangSo(txtTongTien.getText());
                double TongTienTru = TongTienCu - TongTien;
                double TongTienMoi = TongTienTru + tongTien;
                txtTongTien.setText(ChuyenDoi.DinhDangTien(TongTienMoi));
                cbbSize.setEnabled(false);
                cbbMau.setEnabled(false);
                cbbSize.removeAllItems();
                cbbSize.addItem("Size");
                cbbMau.removeAllItems();
                cbbMau.addItem("Màu");
                txtTimSP.setText("Gõ để tìm sản phẩm");
                MyCombobox cbbKH = (MyCombobox) cbbKhachHang.getSelectedItem();
                int MaKhachHang = (int) cbbKH.Value;
                DTO.DTOKhachHang khl = BLL.BLLKhachHang.GetMaKH(MaKhachHang);
                if (khl.getIdLoaiKhachHang() == 1 || khl.getIdLoaiKhachHang() == 2) {
                    txtNo.setText("0");
                    jdcHanTraCongNo.setDate(null);
                    txtHanTraNo.setText("");
                    jdcHanTraCongNo.setEnabled(false);
                } else if (khl.getIdLoaiKhachHang() == 3) {
                    double Tongtien, TienTra, No;
                    Tongtien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
                    TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
                    No = Tongtien - TienTra;
                    txtNo.setText(BLL.ChuyenDoi.DinhDangTien(No));
                    if (TienTra > Tongtien) {
                        txtNo.setText("0");
                    }
                    if (txtNo.getText().equals("0")) {
                        jdcHanTraCongNo.setDate(null);
                        jdcHanTraCongNo.setEnabled(false);
                    } else {
                        jdcHanTraCongNo.setEnabled(true);
                        Date date = new Date();
                        jdcHanTraCongNo.setDate(date);
                        txtHanTraNo.setText(ChuyenDoi.DinhDangNgay(jdcHanTraCongNo.getDate()));
                    }

                }
                return;
            }
        }

        if (sp.getTonKho() <= 0) {
            ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng!", "Thông Báo");
            return;
        }
        int SoLuong = 1;
        double UuDai = 0;

        double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDondon2(tblChiTietHoaDon, sp, SoLuong, UuDai);
        txtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));
        for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
            txtUuDai.setText(ChuyenDoi.DinhDangTien(BLLHoaDon.TinhUuDai));
        }

        if (txtSoHoaDon.getText().equals("")) {

            txtSoHoaDon.setText(BLL.BLLHoaDon.TaoSoHoaDon());

        }
        cbbSize.setEnabled(false);
        cbbMau.setEnabled(false);
        cbbSize.removeAllItems();
        cbbSize.addItem("Size");
        cbbMau.removeAllItems();
        cbbMau.addItem("Màu");
        txtTimSP.setText("Gõ để tìm sản phẩm");
        MyCombobox cbbKH = (MyCombobox) cbbKhachHang.getSelectedItem();
        int MaKhachHang = (int) cbbKH.Value;
        DTO.DTOKhachHang khl = BLL.BLLKhachHang.GetMaKH(MaKhachHang);
        if (khl.getIdLoaiKhachHang() == 1 || khl.getIdLoaiKhachHang() == 2) {
            txtNo.setText("0");
            jdcHanTraCongNo.setDate(null);
            txtHanTraNo.setText("");
            jdcHanTraCongNo.setEnabled(false);
        } else if (khl.getIdLoaiKhachHang() == 3) {
            double TongTien, TienTra, No;
            TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
            TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
            No = TongTien - TienTra;
            txtNo.setText(BLL.ChuyenDoi.DinhDangTien(No));
            if (TienTra > TongTien) {
                txtNo.setText("0");
            }
            if (txtNo.getText().equals("0")) {
                jdcHanTraCongNo.setDate(null);
                jdcHanTraCongNo.setEnabled(false);
            } else {
                jdcHanTraCongNo.setEnabled(true);
                Date date = new Date();
                jdcHanTraCongNo.setDate(date);
                txtHanTraNo.setText(ChuyenDoi.DinhDangNgay(jdcHanTraCongNo.getDate()));
            }

        }


    }//GEN-LAST:event_btnChonSPActionPerformed

    private void cbbSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbSizeMouseClicked

    }//GEN-LAST:event_cbbSizeMouseClicked

    private void cbbSizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbSizeKeyReleased

    }//GEN-LAST:event_cbbSizeKeyReleased

    private void cbbMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauActionPerformed

    }//GEN-LAST:event_cbbMauActionPerformed

    private void btnScannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScannerActionPerformed
        GUI.jdlCameraScanners pnl = new GUI.jdlCameraScanners(new javax.swing.JFrame(), true);
        pnl.setVisible(true);
    }//GEN-LAST:event_btnScannerActionPerformed

    private void txtThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhToanActionPerformed

    private void txtNgayTaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayTaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayTaoActionPerformed

    private void cbbKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhachHangActionPerformed
        MyCombobox cbbKH = (MyCombobox) cbbKhachHang.getSelectedItem();
        int MaKhachHang = (int) cbbKH.Value;
        DTO.DTOKhachHang khl = BLL.BLLKhachHang.GetMaKH(MaKhachHang);
        if (khl.getIdLoaiKhachHang() == 1 || khl.getIdLoaiKhachHang() == 2) {
            txtNo.setText("0");
            jdcHanTraCongNo.setDate(null);
            txtHanTraNo.setText("");
            jdcHanTraCongNo.setEnabled(false);

        } else if (khl.getIdLoaiKhachHang()
                == 3) {
            double TongTien, TienTra, No;
            TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
            TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
            No = TongTien - TienTra;
            txtNo.setText(BLL.ChuyenDoi.DinhDangTien(No));
            if (TienTra > TongTien) {
                txtNo.setText("0");
            }
            if (txtNo.getText().equals("0")) {
                jdcHanTraCongNo.setDate(null);
                jdcHanTraCongNo.setEnabled(false);
            } else {
                jdcHanTraCongNo.setEnabled(true);
                Date date = new Date();
                jdcHanTraCongNo.setDate(date);
                txtHanTraNo.setText(ChuyenDoi.DinhDangNgay(jdcHanTraCongNo.getDate()));
            }

        }


    }//GEN-LAST:event_cbbKhachHangActionPerformed
    public void BillHoaDon() {

        String TongTien = txtTongTien.getText();
        String KhachHang = cbbKhachHang.getSelectedItem().toString();
        String SoHoaDon = txtSoHoaDon.getText();
        String NgayTao = txtNgayTao.getText();
        String NhanVien = BLL.BLLlogin.nguoidung.getTenNguoiDung();
        String TienKhachTra = txtThanhToan.getText();
        String TienThua = txtTienThua.getText();
        String No = txtNo.getText();
        String HanTraNo = txtHanTraNo.getText();

        txtInHoaDon.setText(txtInHoaDon.getText() + "                                 SHOP QUẦN ÁO CHÂU NGÂN                         \n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "                            70 Bà Triệu - TP. Buôn Ma Thuột                        \n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "                                     ĐT: 0905 28 51 51                      \n");

        txtInHoaDon.setText(txtInHoaDon.getText() + "                                           __________                    \n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "                                  HÓA ĐƠN THANH TOÁN                       \n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "\n");

        txtInHoaDon.setText(txtInHoaDon.getText() + "Số Hóa Đơn : " + SoHoaDon + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "Ngày :" + NgayTao + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "Khách Hàng : " + KhachHang + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "Nhân Viên : " + NhanVien + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "____________________________________________________\n");
        //Heading
        txtInHoaDon.setText(txtInHoaDon.getText() + "Sản Phẩm" + "\t" + "SL" + "\t" + "Giá" + "\t" + "Ưu Đãi" + "\t" + "Tổng" + "\n");

        for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
            String TenSP = tblChiTietHoaDon.getValueAt(i, 3).toString();
            String Size = tblChiTietHoaDon.getValueAt(i, 4).toString();
            String Mau = tblChiTietHoaDon.getValueAt(i, 5).toString();
            int SoLuong = (int) tblChiTietHoaDon.getValueAt(i, 6);
            String Gia = tblChiTietHoaDon.getValueAt(i, 7).toString();
            String UuDai = tblChiTietHoaDon.getValueAt(i, 8).toString();
            String ThanhTien = tblChiTietHoaDon.getValueAt(i, 9).toString();
            txtInHoaDon.setText(txtInHoaDon.getText() + "------------------------------------------------------------------------------\n");
            txtInHoaDon.setText(txtInHoaDon.getText() + addReturns(TenSP, 14) + "" + "\t" + SoLuong + "\t" + Gia + "\t" + UuDai + "\t" + ThanhTien + "\n");
            txtInHoaDon.setText(txtInHoaDon.getText() + Size + "-" + Mau + "\n");

        }
        txtInHoaDon.setText(txtInHoaDon.getText() + "____________________________________________________\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "Thành Tiền : " + TongTien + " VNĐ" + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "Tiền Khách Trả : " + TienKhachTra + " VNĐ" + "\n");
        if (!txtTienThua.getText().equals("0")) {
            txtInHoaDon.setText(txtInHoaDon.getText() + "Tiền Thừa : " + TienThua + " VNĐ" + "\n");
        }
        if (!txtNo.getText().equals("0")) {
            txtInHoaDon.setText(txtInHoaDon.getText() + "Tiền Nợ : " + No + " VNĐ" + "\n");
            txtInHoaDon.setText(txtInHoaDon.getText() + "Hạn Trả Nợ : " + HanTraNo + "\n");
        }
        txtInHoaDon.setText(txtInHoaDon.getText() + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "                                           __________                    \n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "\n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "                                     Cảm Ơn Quý Khách            \n");
        txtInHoaDon.setText(txtInHoaDon.getText() + "                                          Hẹn gặp lại               \n");
    }

    public static String addReturns(String s, int maxLength) {
        String newString = "";
        int ind = 0;
        while (ind < s.length()) {
            String temp = s.substring(ind, Math.min(s.length(), ind + maxLength));
            int lastSpace = temp.lastIndexOf(" ");
            int firstNewline = temp.indexOf("\n");
            if (firstNewline > -1) {
                newString += temp.substring(0, firstNewline + 1);
                ind += firstNewline + 1;
            } else if (lastSpace > -1) {
                newString += temp.substring(0, lastSpace + 1) + "\n";
                ind += lastSpace + 1;
            } else {
                newString += temp + "\n";
                ind += maxLength;
            }

        }
        return newString;
    }

    private void printRecord(JTextArea label) {

        PrinterJob printerJob = PrinterJob.getPrinterJob();
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        aset.add(OrientationRequested.PORTRAIT);
        aset.add(MediaSizeName.INVOICE);
        printerJob.setJobName("Print Record");

        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                // Check If No Printable Content
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }

                // Make 2D Graphics to map content
                Graphics2D graphics2D = (Graphics2D) graphics;
                // Set Graphics Translations
                // A Little Correction here Multiplication was not working so I replaced with addition
                graphics2D.translate(pageFormat.getImageableX() + 10, pageFormat.getImageableY() + 10);
                // This is a page scale. Default should be 0.3 I am using 0.5
                graphics2D.scale(0.35, 0.35);

                // Now paint panel as graphics2D
                label.paint(graphics2D);

                // return if page exists
                return Printable.PAGE_EXISTS;
            }
        });
        // Store printerDialog as boolean
        boolean returningResult = printerJob.printDialog();
        // check if dilog is showing
        if (returningResult) {
            // Use try catch exeption for failure
            try {
                // Now call print method inside printerJob to print
                printerJob.print(aset);
            } catch (PrinterException printerException) {
                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
            }
        }
    }
    private void txtThanhToanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThanhToanKeyReleased
        double TienTra, TongTien, TienThua, No;
        DTO.DTOKhachHang khl = BLL.BLLKhachHang.GetTenKH(cbbKhachHang.getSelectedItem().toString());
        if (khl.getIdLoaiKhachHang() == 1 || khl.getIdLoaiKhachHang() == 2) {
            TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
            TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
            txtThanhToan.setText(BLL.ChuyenDoi.DinhDangTien(TienTra));
            TienThua = TienTra - TongTien;

            txtTienThua.setText(BLL.ChuyenDoi.DinhDangTien(TienThua));
            if (TienTra < TongTien) {
                txtTienThua.setText("0");
            }
        } else if (khl.getIdLoaiKhachHang() == 3) {
            TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongTien.getText());
            TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
            txtThanhToan.setText(BLL.ChuyenDoi.DinhDangTien(TienTra));
            TienThua = TienTra - TongTien;
            No = TongTien - TienTra;
            txtTienThua.setText(BLL.ChuyenDoi.DinhDangTien(TienThua));
            txtNo.setText(BLL.ChuyenDoi.DinhDangTien(No));
            if (TienThua < 0) {
                txtTienThua.setText("0");
            }
            if (No < 0) {
                txtNo.setText("0");
            }
            if (txtNo.getText().equals("0")) {
                jdcHanTraCongNo.setDate(null);
                jdcHanTraCongNo.setEnabled(false);
            } else {
                jdcHanTraCongNo.setEnabled(true);
                Date date = new Date();
                jdcHanTraCongNo.setDate(date);
                txtHanTraNo.setText(ChuyenDoi.DinhDangNgay(jdcHanTraCongNo.getDate()));
            }

        }
    }//GEN-LAST:event_txtThanhToanKeyReleased

    private void cbbSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSizeItemStateChanged
        try {

            int column = 0;
            int row = jTable1.getSelectedRow();
            String value = jTable1.getModel().getValueAt(row, column).toString();

            MyCombobox mbs = (MyCombobox) cbbSize.getSelectedItem();
            int MaSize = Integer.parseInt(mbs.Value.toString());
            BLL.BLLSanPham.MauSanPhamTheoTen(cbbMau, value, MaSize);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbbSizeItemStateChanged

    private void cbbMauItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMauItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbMauItemStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void tblChiTietHoaDonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietHoaDonMouseReleased


    }//GEN-LAST:event_tblChiTietHoaDonMouseReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getClickCount() == 1) {
            int dongduocchon = jTable1.getSelectedRow();
            if (dongduocchon >= 0) {
                cbbSize.setEnabled(true);
                cbbMau.setEnabled(true);
            }
        }

        try {

            int column = 0;
            int row = jTable1.getSelectedRow();
            String value = jTable1.getModel().getValueAt(row, column).toString();

            BLL.BLLSanPham.SizeSanPhamTheoTen(cbbSize, value);
            MyCombobox mbs = (MyCombobox) cbbSize.getSelectedItem();
            int MaSize = Integer.parseInt(mbs.Value.toString());
            System.out.println(MaSize);
            BLL.BLLSanPham.MauSanPhamTheoTen(cbbMau, value, MaSize);
            txtTimSP.setText(value);
            jPopupMenu3.setVisible(false);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void txtTimSPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimSPMouseReleased

    }//GEN-LAST:event_txtTimSPMouseReleased

    private void txtTimSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimSPKeyReleased
        if (txtTimSP.getText().equals("")) {
            jPopupMenu3.setVisible(false);
        } else {
            jPopupMenu3.show(txtTimSP, 0, txtTimSP.getHeight());
            BLLSanPham.HienThiSanPhamBanHang(jTable1, txtTimSP.getText());
        }

    }//GEN-LAST:event_txtTimSPKeyReleased

    private void txtTimSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimSPMouseClicked
        txtTimSP.setText("");
        jPopupMenu3.show(txtTimSP, 0, txtTimSP.getHeight());
        BLLSanPham.HienThiSanPhamBanHang(jTable1, txtTimSP.getText());
    }//GEN-LAST:event_txtTimSPMouseClicked

    private void cbbKhachHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhachHangItemStateChanged
        if (tblChiTietHoaDon.getRowCount() != 0) {

            for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {

                int MaSPB = Integer.parseInt(tblChiTietHoaDon.getValueAt(i, 0).toString());
                System.out.println("KHJSJSJSJS" + MaSPB + "");
                int SoLuong = (int) tblChiTietHoaDon.getValueAt(i, 6);
                double UuDai = 0;
                double TongTien = ChuyenDoi.ChuyenSangSo(tblChiTietHoaDon.getValueAt(i, 9).toString());
                DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSPB);

                double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDonTheoLoaiKH(tblChiTietHoaDon, sp, SoLuong, UuDai);
                DefaultTableModel model = (DefaultTableModel) tblChiTietHoaDon.getModel();
                model.removeRow(i);
                double TongTienCu = ChuyenDoi.ChuyenSangSo(txtTongTien.getText());
                double TongTienTru = TongTienCu - TongTien;
                double TongTienMoi = TongTienTru + tongTien;
                txtTongTien.setText(ChuyenDoi.DinhDangTien(TongTienMoi));
                txtUuDai.setText(ChuyenDoi.DinhDangTien(BLLHoaDon.TinhUuDaiKH));

            }

        }
        try {

            MyCombobox kh = (MyCombobox) cbbKhachHang.getSelectedItem();
            int MaKH = Integer.parseInt(kh.Value.toString());
            DAOKhachHang.LayLoaiKhachHang(MaKH);
            lblidkh.setText("Loại KH: " + layidkh);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbbKhachHangItemStateChanged

    private void jdcHanTraCongNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jdcHanTraCongNoKeyReleased

    }//GEN-LAST:event_jdcHanTraCongNoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if (tblChiTietHoaDon.getRowCount() >0) {
             int kq = JOptionPane.showConfirmDialog(new JFrame(), "Bạn đang order, xác nhận làm mới đơn?",
                "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {
txtTimSP.setText("Gõ để tìm sản phẩm");
        txtInHoaDon.setText("");
        txtSoHoaDon.setText("");
        txtUuDai.setText("0");
        txtThanhToan.setText("0");
        txtTienThua.setText("0");
        txtNo.setText("0");
        jdcHanTraCongNo.setDate(null);
        txtHanTraNo.setText("");
        txtTongTien.setText("0");
        cbbSize.removeAllItems();
        cbbSize.addItem("Size");
        cbbMau.removeAllItems();
        cbbMau.addItem("Màu");
        cbbSize.setEnabled(false);
        cbbMau.setEnabled(false);
        DefaultTableModel tbModel = (DefaultTableModel) tblChiTietHoaDon.getModel();
        tbModel.setRowCount(0);
        }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChonSP;
    private javax.swing.JButton btnMuaHang;
    private javax.swing.JButton btnScanner;
    public static javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbMau;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable jTable1;
    public static com.toedter.calendar.JDateChooser jdcHanTraCongNo;
    public static javax.swing.JLabel lblidkh;
    private javax.swing.JLabel lblnhomkhachhang10;
    private javax.swing.JLabel lblnhomkhachhang11;
    private javax.swing.JLabel lblnhomkhachhang12;
    private javax.swing.JLabel lblnhomkhachhang13;
    private javax.swing.JLabel lblnhomkhachhang14;
    private javax.swing.JLabel lblnhomkhachhang6;
    private javax.swing.JLabel lblnhomkhachhang7;
    private javax.swing.JLabel lblnhomkhachhang8;
    private javax.swing.JLabel lblnhomkhachhang9;
    private javax.swing.JScrollPane list;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel pnlDonHang;
    private javax.swing.JPanel pnlnennhanvienphutrach1;
    private javax.swing.JPanel pnlnennhomkhachhang10;
    private javax.swing.JPanel pnlnennhomkhachhang3;
    private javax.swing.JPanel pnlnennhomkhachhang4;
    private javax.swing.JPanel pnlnennhomkhachhang5;
    private javax.swing.JPanel pnlnennhomkhachhang6;
    private javax.swing.JPanel pnlnennhomkhachhang7;
    private javax.swing.JPanel pnlnennhomkhachhang8;
    private javax.swing.JPanel pnlnennhomkhachhang9;
    public static javax.swing.JPanel pnlnenthemdon;
    public static javax.swing.JTable tblChiTietHoaDon;
    private javax.swing.JTextField txtHanTraNo;
    private javax.swing.JTextArea txtInHoaDon;
    public static javax.swing.JTextField txtNgayTao;
    public static javax.swing.JTextField txtNo;
    public static javax.swing.JTextField txtSoHoaDon;
    public static javax.swing.JTextField txtThanhToan;
    public static javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimSP;
    public static javax.swing.JTextField txtTongTien;
    public static javax.swing.JTextField txtUuDai;
    public static javax.swing.JTextField txtsodon;
    // End of variables declaration//GEN-END:variables

}
