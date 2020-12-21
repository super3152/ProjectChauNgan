/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLLSanPham;
import BLL.ChuyenDoi;
import DAO.DAONhaCungCap;
import DAO.DAOPhieuNhap;
import DTO.DTOKho;
import DTO.DTONhaCungCap;
import DTO.DTOPhieuNhap;
import DTO.DTOSanPham;
import DTO.MyCombobox;
import static GUI.pnlhanghoa.btnLastNCC;
import static GUI.pnlhanghoa.btnNextNCC;
import static GUI.pnlhanghoa.jPanel23;
import static GUI.pnlhanghoa.jPanel32;
import static GUI.pnlhanghoa.lblCountPage1;
import static GUI.pnlhanghoa.lblCountPageNCC;
import static GUI.pnlhanghoa.lblNumberPage1;
import static GUI.pnlhanghoa.lblNumberPageNCC;
import static GUI.pnlhanghoa.tblPhieuNhap;
import static GUI.pnlhanghoa.tblnhacungcap;
import static GUI.pnlhanghoa.txtTimKiemNCC;
import static GUI.pnlhanghoa.txtTimKiemPN;
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
import static java.lang.Thread.sleep;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.Locale;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sofaraway1604
 */
public class pnlthemphieunhap1 extends javax.swing.JPanel {

    /**
     *
     */
    public static int MaPN;
    public static String SoPhieuNhap;
    public static String NhapKho;
    public static String ThanhToan;
    public static int countPN, soTrangPN, trangPN = 1;
    public int trangPN1 = 1;
    public static int countKho, soTrangKho, trangKho = 1;
    public int trangKho1 = 1;
    public static int countNCC, soTrangNCC, trangNCC = 1;
    public int trangNCC1 = 1;
    public static int countSP, soTrangSP, trangSP = 1;
    public int trangSP1 = 1;

    public pnlthemphieunhap1() {
        initComponents();
        BLLSanPham.HienThiSanPhamBanHang(tblBangSanPham, txtTimSP.getText());
        jPopupMenu3.add(jPanel9);
        if (SoPhieuNhap == null) {
            cbbMau.setEnabled(false);
            cbbSize.setEnabled(false);
            BLL.BLLPhieuNhap.DoDuLieuVaoCBBNhaCungCap(cbbNhaCungCap);
            NgayGio();
        } else {
            DTOPhieuNhap pn = BLL.BLLPhieuNhap.GetMaPN(MaPN);
            BLL.BLLPhieuNhap.SetCBBNhaCungCap(cbbNhaCungCap, pn.getIDNhaCungCap());
            BLL.BLLPhieuNhap.HienThiChiTietPhieuNhap(tblChitietphieunhap, MaPN);
            txtCongNo.setText(ChuyenDoi.DinhDangTien(pn.getCongNo()));
            txtTongtien.setText(ChuyenDoi.DinhDangTien(pn.getThanhTien()));
            txtMaDonNhapHang.setText(pn.getSoPhieuNhap());
            txtTag.setText(pn.getTag());
            txtGhiChu.setText(pn.getGhiChu());
            tblChitietphieunhap.setEnabled(false);
            txtCongNo.setEnabled(false);
            txtTongtien.setEnabled(false);
            txtMaDonNhapHang.setEnabled(false);
            txtTag.setEnabled(false);
            txtGhiChu.setEnabled(false);
            btnDatHang.setEnabled(false);
            btnChonSP.setEnabled(false);
            cbNhapLe.setEnabled(false);
            cbNhapTheoRi.setEnabled(false);
            txtTimSP.setEnabled(false);
            jPopupMenu3.show(false);
            cbbSize.setEnabled(false);
            cbbMau.setEnabled(false);
            btnXoaHang.setEnabled(false);
            btnXoaToanBo.setEnabled(false);
            btnLamMoi.setEnabled(false);
            if (pn.getNhapKho() == 1) {
                btnNhapKho.setEnabled(false);
            }
            if (pn.getThanhToan() == 1) {
                btnThanhToan.setEnabled(false);
            }
            if (pn.getThanhToan() == 2) {
                btnThanhToan.setEnabled(false);
            }
            tblChitietphieunhap.setEnabled(false);
            NgayGio();
        }

    }

    public pnlthemphieunhap1(int MaPN, String SoPhieuNhap, String NhapKho, String ThanhToan) {
        pnlthemphieunhap1.MaPN = MaPN;
        pnlthemphieunhap1.SoPhieuNhap = SoPhieuNhap;
        pnlthemphieunhap1.NhapKho = NhapKho;
        pnlthemphieunhap1.ThanhToan = ThanhToan;
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

                    txtNgayNhap.setText(day);

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        txtHinhThucNhap = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBangSanPham = new javax.swing.JTable();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        txtNgayNhap = new javax.swing.JTextField();
        pnldanhsach = new javax.swing.JPanel();
        pnlthemsuakhachhang = new javax.swing.JPanel();
        pnlnenthemsuakhachhang1 = new javax.swing.JPanel();
        pnlnenngoaianhdaidienvathongtinkhac1 = new javax.swing.JPanel();
        pnlnenngoaianhdaidienvathongtinkhac = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac2 = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac1 = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac = new javax.swing.JPanel();
        pnlnenthongtinkhac = new javax.swing.JPanel();
        lblthongtinkhac = new javax.swing.JLabel();
        pnlnennhomkhachhang = new javax.swing.JPanel();
        lblnhomkhachhang = new javax.swing.JLabel();
        txtMaDonNhapHang = new javax.swing.JTextField();
        pnlnennhanvienphutrach2 = new javax.swing.JPanel();
        lblnhanvienphutrach2 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        pnlnennhomkhachhang2 = new javax.swing.JPanel();
        lblnhomkhachhang2 = new javax.swing.JLabel();
        txtTag = new javax.swing.JTextField();
        pnlnenlonthongtincoban = new javax.swing.JPanel();
        pnlnenlonngoaithongtin = new javax.swing.JPanel();
        pnlnenngoaithongtin = new javax.swing.JPanel();
        pnlnenthongtin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cbNhapTheoRi = new javax.swing.JCheckBox();
        cbNhapLe = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        pnlnennhomkhachhang8 = new javax.swing.JPanel();
        lblnhomkhachhang12 = new javax.swing.JLabel();
        txtTimSP = new javax.swing.JTextField();
        lblthongtincoban = new javax.swing.JLabel();
        pnlnenhotenkhachhang = new javax.swing.JPanel();
        lblhotenkhachhang = new javax.swing.JLabel();
        cbbNhaCungCap = new javax.swing.JComboBox<>();
        lblthongtinbosung = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtTongtien = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtCongNo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        lblthongtinbosung1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChitietphieunhap = new javax.swing.JTable();
        btnXoaHang = new javax.swing.JButton();
        btnXoaToanBo = new javax.swing.JButton();
        btnChonSP = new javax.swing.JButton();
        cbbSize = new javax.swing.JComboBox<>();
        cbbMau = new javax.swing.JComboBox<>();
        pnlnenngoaibtn = new javax.swing.JPanel();
        pnlnenbtn = new javax.swing.JPanel();
        btnDatHang = new javax.swing.JButton();
        btnNhapKho = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnDanhSach = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        FileChooser = new javax.swing.JFileChooser();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jScrollPane3.setBorder(null);

        tblBangSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBangSanPham.setRowHeight(25);
        tblBangSanPham.setShowHorizontalLines(false);
        tblBangSanPham.setShowVerticalLines(false);
        tblBangSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBangSanPham);

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

        txtNgayNhap.setText("jTextField2");

        setPreferredSize(new java.awt.Dimension(975, 586));

        pnldanhsach.setBackground(new java.awt.Color(33, 36, 51));
        pnldanhsach.setPreferredSize(new java.awt.Dimension(980, 618));

        pnlnenthemsuakhachhang1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidienvathongtinkhac1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngoaianhdaidienvathongtinkhac1.setPreferredSize(new java.awt.Dimension(275, 550));
        pnlnenngoaianhdaidienvathongtinkhac1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidienvathongtinkhac.setPreferredSize(new java.awt.Dimension(275, 300));
        pnlnenngoaianhdaidienvathongtinkhac.setLayout(new java.awt.BorderLayout());

        pnlnenngoaithongtinkhac2.setBackground(new java.awt.Color(255, 255, 0));
        pnlnenngoaithongtinkhac2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(244, 246, 248), 5, true));
        pnlnenngoaithongtinkhac2.setPreferredSize(new java.awt.Dimension(275, 310));

        pnlnenngoaithongtinkhac1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngoaithongtinkhac1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlnenngoaithongtinkhac1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaithongtinkhac.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        pnlnenthongtinkhac.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenthongtinkhac.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblthongtinkhac.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblthongtinkhac.setText("Thông tin đơn nhập hàng");
        lblthongtinkhac.setPreferredSize(new java.awt.Dimension(34, 20));

        pnlnennhomkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang.setText("Mã đơn nhập hàng");
        lblnhomkhachhang.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang.add(lblnhomkhachhang, java.awt.BorderLayout.PAGE_START);

        txtMaDonNhapHang.setEnabled(false);
        pnlnennhomkhachhang.add(txtMaDonNhapHang, java.awt.BorderLayout.CENTER);

        pnlnennhanvienphutrach2.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhanvienphutrach2.setLayout(new java.awt.BorderLayout());

        lblnhanvienphutrach2.setBackground(new java.awt.Color(255, 255, 255));
        lblnhanvienphutrach2.setText("Ghi chú");
        lblnhanvienphutrach2.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhanvienphutrach2.add(lblnhanvienphutrach2, java.awt.BorderLayout.PAGE_START);
        pnlnennhanvienphutrach2.add(txtGhiChu, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang2.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang2.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang2.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang2.setText("Tag");
        lblnhomkhachhang2.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang2.add(lblnhomkhachhang2, java.awt.BorderLayout.PAGE_START);
        pnlnennhomkhachhang2.add(txtTag, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlnenthongtinkhacLayout = new javax.swing.GroupLayout(pnlnenthongtinkhac);
        pnlnenthongtinkhac.setLayout(pnlnenthongtinkhacLayout);
        pnlnenthongtinkhacLayout.setHorizontalGroup(
            pnlnenthongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtinkhacLayout.createSequentialGroup()
                .addGroup(pnlnenthongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblthongtinkhac, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlnenthongtinkhacLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlnenthongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlnennhomkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlnennhomkhachhang2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlnennhanvienphutrach2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlnenthongtinkhacLayout.setVerticalGroup(
            pnlnenthongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtinkhacLayout.createSequentialGroup()
                .addComponent(lblthongtinkhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlnennhomkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(pnlnennhomkhachhang2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlnennhanvienphutrach2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlnenngoaithongtinkhacLayout = new javax.swing.GroupLayout(pnlnenngoaithongtinkhac);
        pnlnenngoaithongtinkhac.setLayout(pnlnenngoaithongtinkhacLayout);
        pnlnenngoaithongtinkhacLayout.setHorizontalGroup(
            pnlnenngoaithongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthongtinkhac, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        pnlnenngoaithongtinkhacLayout.setVerticalGroup(
            pnlnenngoaithongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthongtinkhac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlnenngoaithongtinkhac1.add(pnlnenngoaithongtinkhac, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlnenngoaithongtinkhac2Layout = new javax.swing.GroupLayout(pnlnenngoaithongtinkhac2);
        pnlnenngoaithongtinkhac2.setLayout(pnlnenngoaithongtinkhac2Layout);
        pnlnenngoaithongtinkhac2Layout.setHorizontalGroup(
            pnlnenngoaithongtinkhac2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenngoaithongtinkhac1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlnenngoaithongtinkhac2Layout.setVerticalGroup(
            pnlnenngoaithongtinkhac2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenngoaithongtinkhac1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlnenngoaianhdaidienvathongtinkhac.add(pnlnenngoaithongtinkhac2, java.awt.BorderLayout.CENTER);

        pnlnenngoaianhdaidienvathongtinkhac1.add(pnlnenngoaianhdaidienvathongtinkhac, java.awt.BorderLayout.CENTER);

        pnlnenthemsuakhachhang1.add(pnlnenngoaianhdaidienvathongtinkhac1, java.awt.BorderLayout.EAST);

        pnlnenlonthongtincoban.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenlonthongtincoban.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 246, 248), 5));
        pnlnenlonthongtincoban.setPreferredSize(new java.awt.Dimension(700, 550));
        pnlnenlonthongtincoban.setLayout(new java.awt.BorderLayout());

        pnlnenlonngoaithongtin.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenlonngoaithongtin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlnenlonngoaithongtin.setLayout(new java.awt.BorderLayout());

        pnlnenngoaithongtin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        pnlnenngoaithongtin.setLayout(new java.awt.BorderLayout());

        pnlnenthongtin.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenthongtin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbNhapTheoRi.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(cbNhapTheoRi);
        cbNhapTheoRi.setText("Nhập theo ri");
        cbNhapTheoRi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNhapTheoRiActionPerformed(evt);
            }
        });

        cbNhapLe.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(cbNhapLe);
        cbNhapLe.setSelected(true);
        cbNhapLe.setText("Nhập lẻ");
        cbNhapLe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNhapLeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chọn hình thức nhập");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cbNhapLe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbNhapTheoRi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbNhapLe, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cbNhapTheoRi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlnennhomkhachhang8.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnlnennhomkhachhang8.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang12.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblnhomkhachhang12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnhomkhachhang12.setText("  Chọn sản phẩm");
        lblnhomkhachhang12.setPreferredSize(new java.awt.Dimension(75, 35));
        pnlnennhomkhachhang8.add(lblnhomkhachhang12, java.awt.BorderLayout.PAGE_START);

        txtTimSP.setText("Gõ để tìm sản phẩm");
        txtTimSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimSPMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtTimSPMouseReleased(evt);
            }
        });
        txtTimSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimSPActionPerformed(evt);
            }
        });
        txtTimSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimSPKeyReleased(evt);
            }
        });
        pnlnennhomkhachhang8.add(txtTimSP, java.awt.BorderLayout.CENTER);

        lblthongtincoban.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblthongtincoban.setText("Tạo phiếu nhập hàng");

        pnlnenhotenkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenhotenkhachhang.setLayout(new java.awt.BorderLayout());

        lblhotenkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblhotenkhachhang.setText("Nhà cung cấp");
        lblhotenkhachhang.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnenhotenkhachhang.add(lblhotenkhachhang, java.awt.BorderLayout.PAGE_START);

        pnlnenhotenkhachhang.add(cbbNhaCungCap, java.awt.BorderLayout.CENTER);

        lblthongtinbosung.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblthongtinbosung.setText("Thông tin chi tiết phiếu kiểm");

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new java.awt.BorderLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Số tiền thanh toán");
        jLabel17.setPreferredSize(new java.awt.Dimension(52, 20));
        jPanel39.add(jLabel17, java.awt.BorderLayout.PAGE_START);

        txtTongtien.setEnabled(false);
        jPanel39.add(txtTongtien, java.awt.BorderLayout.CENTER);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new java.awt.BorderLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Công Nợ");
        jLabel18.setPreferredSize(new java.awt.Dimension(31, 20));
        jPanel40.add(jLabel18, java.awt.BorderLayout.PAGE_START);
        jPanel40.add(txtCongNo, java.awt.BorderLayout.CENTER);

        lblthongtinbosung1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblthongtinbosung1.setText("Thanh toán");

        tblChitietphieunhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ảnh", "Mã Sản Phẩm", "Tên Sản Phẩm", "Size", "Màu", "Số lượng", "Đơn giá", "Đơn Vị Tính", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChitietphieunhap.setRowHeight(40);
        tblChitietphieunhap.setShowVerticalLines(false);
        tblChitietphieunhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChitietphieunhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChitietphieunhap);
        if (tblChitietphieunhap.getColumnModel().getColumnCount() > 0) {
            tblChitietphieunhap.getColumnModel().getColumn(0).setMinWidth(0);
            tblChitietphieunhap.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblChitietphieunhap.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        btnXoaHang.setText("Xóa hàng");
        btnXoaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHangActionPerformed(evt);
            }
        });

        btnXoaToanBo.setText("Xóa toàn bộ");
        btnXoaToanBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaToanBoActionPerformed(evt);
            }
        });

        btnChonSP.setText("Chọn SP");
        btnChonSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSPActionPerformed(evt);
            }
        });

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Size" }));
        cbbSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSizeItemStateChanged(evt);
            }
        });

        cbbMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Màu" }));

        javax.swing.GroupLayout pnlnenthongtinLayout = new javax.swing.GroupLayout(pnlnenthongtin);
        pnlnenthongtin.setLayout(pnlnenthongtinLayout);
        pnlnenthongtinLayout.setHorizontalGroup(
            pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblthongtincoban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblthongtinbosung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlnenhotenkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(lblthongtinbosung1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlnennhomkhachhang8, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbMau, 0, 83, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(btnXoaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaToanBo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        pnlnenthongtinLayout.setVerticalGroup(
            pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblthongtincoban)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnenhotenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbbSize, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbbMau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlnennhomkhachhang8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnChonSP, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblthongtinbosung, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaHang)
                    .addComponent(btnXoaToanBo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblthongtinbosung1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlnenngoaithongtin.add(pnlnenthongtin, java.awt.BorderLayout.CENTER);

        pnlnenlonngoaithongtin.add(pnlnenngoaithongtin, java.awt.BorderLayout.CENTER);

        pnlnenlonthongtincoban.add(pnlnenlonngoaithongtin, java.awt.BorderLayout.CENTER);

        pnlnenthemsuakhachhang1.add(pnlnenlonthongtincoban, java.awt.BorderLayout.CENTER);

        pnlnenngoaibtn.setPreferredSize(new java.awt.Dimension(975, 40));

        pnlnenbtn.setBackground(new java.awt.Color(244, 246, 248));

        btnDatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/checkmark_20px.png"))); // NOI18N
        btnDatHang.setText("Đặt hàng và duyệt");
        btnDatHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatHangActionPerformed(evt);
            }
        });

        btnNhapKho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/maintenance_20px.png"))); // NOI18N
        btnNhapKho.setText("Nhập Kho");
        btnNhapKho.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNhapKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapKhoActionPerformed(evt);
            }
        });

        btnDanhSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/list_20px.png"))); // NOI18N
        btnDanhSach.setText("Danh sách");
        btnDanhSach.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnDanhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachActionPerformed(evt);
            }
        });

        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/get_cash_20px.png"))); // NOI18N
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/available_updates_20px.png"))); // NOI18N
        btnLamMoi.setText("Làm Mới");
        btnLamMoi.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlnenbtnLayout = new javax.swing.GroupLayout(pnlnenbtn);
        pnlnenbtn.setLayout(pnlnenbtnLayout);
        pnlnenbtnLayout.setHorizontalGroup(
            pnlnenbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenbtnLayout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(btnDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhapKho, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        pnlnenbtnLayout.setVerticalGroup(
            pnlnenbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenbtnLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(pnlnenbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlnenbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlnenbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNhapKho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout pnlnenngoaibtnLayout = new javax.swing.GroupLayout(pnlnenngoaibtn);
        pnlnenngoaibtn.setLayout(pnlnenngoaibtnLayout);
        pnlnenngoaibtnLayout.setHorizontalGroup(
            pnlnenngoaibtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlnenngoaibtnLayout.setVerticalGroup(
            pnlnenngoaibtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlnenthemsuakhachhang1.add(pnlnenngoaibtn, java.awt.BorderLayout.PAGE_END);

        FileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlthemsuakhachhangLayout = new javax.swing.GroupLayout(pnlthemsuakhachhang);
        pnlthemsuakhachhang.setLayout(pnlthemsuakhachhangLayout);
        pnlthemsuakhachhangLayout.setHorizontalGroup(
            pnlthemsuakhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthemsuakhachhang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlthemsuakhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlthemsuakhachhangLayout.createSequentialGroup()
                    .addGap(487, 487, 487)
                    .addComponent(FileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(488, Short.MAX_VALUE)))
        );
        pnlthemsuakhachhangLayout.setVerticalGroup(
            pnlthemsuakhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthemsuakhachhang1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
            .addGroup(pnlthemsuakhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlthemsuakhachhangLayout.createSequentialGroup()
                    .addGap(293, 293, 293)
                    .addComponent(FileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(294, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnldanhsachLayout = new javax.swing.GroupLayout(pnldanhsach);
        pnldanhsach.setLayout(pnldanhsachLayout);
        pnldanhsachLayout.setHorizontalGroup(
            pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
            .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnldanhsachLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnlthemsuakhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        pnldanhsachLayout.setVerticalGroup(
            pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnldanhsachLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnlthemsuakhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnldanhsach, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnldanhsach, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatHangActionPerformed
        int dongDuocChon = tblChitietphieunhap.getRowCount();
        if (dongDuocChon == 0) {
            ThongBaoCanhBao.ThongBao("Bàn chưa có sản phẩm không thể tạo phiếu nhập!", "Thông Báo !");
            return;
        }
        if (txtMaDonNhapHang.getText() != null) {

            int MaNCC;
            int MaNV;
            int TonKho = 0;
            String SoPhieuNhap;
            String HinhThucThanhToan;
            String HinhThucNhap = null;
            double TongTien;
            int TrangThai;
            int NhapKho;
            int ThanhToan;
            int TrangThaiKho;
            String Tag;
            String GhiChu;

            MyCombobox cbbNCC = (MyCombobox) cbbNhaCungCap.getSelectedItem();
            MaNCC = (int) cbbNCC.Value;
            MaNV = BLL.BLLHoaDon.LayMaNhanVienString(BLL.BLLlogin.nguoidung.getTenNguoiDung());
            SoPhieuNhap = txtMaDonNhapHang.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String NgayNhap = txtNgayNhap.getText();
            TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongtien.getText());
            HinhThucThanhToan = "";
            if (cbNhapLe.isSelected()) {
                HinhThucNhap = "Nhập Lẻ";
            } else if (cbNhapTheoRi.isSelected()) {
                HinhThucNhap = "Nhập Ri";
            }
            TrangThai = 0;
            NhapKho = 0;
            ThanhToan = 0;
            TrangThaiKho = 0;
            double CongNo = BLL.ChuyenDoi.ChuyenSangSo(txtCongNo.getText());
            Tag = txtTag.getText();
            GhiChu = txtGhiChu.getText();
            DTONhaCungCap ncc = BLL.BLLNhaCungCap.GetMaNCC(MaNCC);
            double TongTienTrongNCC = ncc.getTongTienHang();
            double TongTienHang = TongTienTrongNCC + TongTien;

            DTONhaCungCap sncc = new DTONhaCungCap(MaNCC, NgayNhap, TongTienHang, CongNo);
            BLL.BLLNhaCungCap.SuaNhapHangNCC(sncc);
            DTOPhieuNhap PN = new DTOPhieuNhap(MaNCC, MaNV, SoPhieuNhap, NgayNhap, TongTien, HinhThucThanhToan, HinhThucNhap, TrangThai, NhapKho, ThanhToan, CongNo, Tag, GhiChu);
            BLL.BLLPhieuNhap.ThemPhieuNhap(PN);

            ThongBaoCanhBao.ThongBao("Thêm phiếu nhập thành công !", "Thông Báo !");

            int MaPN = BLL.BLLPhieuNhap.LayMaPhieuNhapString(SoPhieuNhap);
            for (int i = 0; i < tblChitietphieunhap.getRowCount(); i++) {
                int MaSP = Integer.parseInt(tblChitietphieunhap.getValueAt(i, 0).toString());
                String DonVi = tblChitietphieunhap.getValueAt(i, 8).toString();
                int SoLuong = Integer.parseInt(tblChitietphieunhap.getValueAt(i, 6).toString());
                double GiaNhap = BLL.ChuyenDoi.ChuyenTien(tblChitietphieunhap.getValueAt(i, 7).toString());
                double ThanhTien = BLL.ChuyenDoi.ChuyenTien(tblChitietphieunhap.getValueAt(i, 9).toString());
                String GhiChuCT = "Mới";

                DTO.DTOChiTietPhieuNhap ctpn = new DTO.DTOChiTietPhieuNhap(MaPN, MaSP, DonVi, SoLuong, GiaNhap, ThanhTien, GhiChuCT, MaNCC, HinhThucNhap);

                BLL.BLLPhieuNhap.ThemChiTietPhieuNhap(ctpn);

                ResultSet rsidsp = DAO.DAOPhieuNhap.LayKhoTheoIDSP(MaSP);
                try {
                    DTOKho kh = BLL.BLLKho.GetKhoTheoIDSP(MaSP);

                    if (rsidsp.next()) {
                        int HangDangVeTrongKho = kh.getHangDangVe();
                        int HangDangVe = HangDangVeTrongKho + SoLuong;
                        int TonKhoBang = kh.getTonKho();
                        DTOKho K = new DTOKho(MaSP, TonKhoBang, HangDangVe, TrangThaiKho);
                        BLL.BLLKho.SuaHangDangVeKho(K);
                    } else {
                        DTOKho KH = new DTOKho(MaSP, MaPN, TonKho, SoLuong, TrangThaiKho);
                        BLL.BLLKho.ThemKho(KH);
                    }
                } catch (SQLException ex) {
                    ThongBaoCanhBao.ThongBao("Lỗi sử kho!", "Thông Báo !");
                }

            }
            DAOPhieuNhap.CountPN();

            if (countPN % 13 == 0) {
                soTrangPN = countPN / 13;
            } else {
                soTrangPN = countPN / 13 + 1;
            }
            BLL.BLLPhieuNhap.HienThiPhieuNhap(tblPhieuNhap, txtTimKiemPN.getText(), 0);
            lblCountPage1.setText(trangPN1 + "/" + soTrangPN + "");
            lblNumberPage1.setText(trangPN1 + "");

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

            DAONhaCungCap.CountNCC();

            if (countNCC % 13 == 0) {
                soTrangNCC = countNCC / 13;
            } else if (soTrangNCC <= trangNCC1) {
                btnNextNCC.setEnabled(false);
                btnLastNCC.setEnabled(false);

            } else {
                soTrangNCC = countNCC / 13 + 1;
            }
            BLL.BLLNhaCungCap.HienThiNhaCungCap(tblnhacungcap, txtTimKiemNCC.getText(), 0);
            lblCountPageNCC.setText(trangNCC1 + "/" + soTrangNCC + "");
            lblNumberPageNCC.setText(trangNCC1 + "");
            btnDatHang.setEnabled(false);
            tblChitietphieunhap.setEnabled(false);

            txtCongNo.setEnabled(false);
            txtTag.setEnabled(false);
            txtGhiChu.setEnabled(false);
            btnChonSP.setEnabled(false);
            cbNhapLe.setEnabled(false);
            cbNhapTheoRi.setEnabled(false);
            txtTimSP.setEnabled(false);
            jPopupMenu3.show(false);
            cbbSize.setEnabled(false);
            cbbMau.setEnabled(false);
            btnXoaHang.setEnabled(false);
            btnXoaToanBo.setEnabled(false);
            btnLamMoi.setEnabled(false);
        }


    }//GEN-LAST:event_btnDatHangActionPerformed

    private void btnNhapKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapKhoActionPerformed
        if (txtMaDonNhapHang.getText().equals("")) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn phiếu nhập để nhập kho", "Thông báo");
            return;
        }
        if (txtMaDonNhapHang.getText() != null) {
            for (int i = 0; i < tblChitietphieunhap.getRowCount(); i++) {
                int MaSP = Integer.parseInt(tblChitietphieunhap.getValueAt(i, 0).toString());
                double GiaNhap = ChuyenDoi.ChuyenSangSo(tblChitietphieunhap.getValueAt(i, 7).toString());
                int SoLuong = Integer.parseInt(tblChitietphieunhap.getValueAt(i, 6).toString());
                DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSP);
                DTOKho kh = BLL.BLLKho.GetKhoTheoIDSP(MaSP);
                int SoLuongTrongSanPham = sp.getTonKho();
                int HangDangVeSQL = kh.getHangDangVe();
                int TonKho = SoLuongTrongSanPham + HangDangVeSQL;
                int NhapKho = 1;
                int HangDangVe = 0;
                int TrangThai = 1;
                String SoPhieuNhap = txtMaDonNhapHang.getText();
                String NgayNhap = txtNgayNhap.getText();
                DTOPhieuNhap udpn = new DTOPhieuNhap(SoPhieuNhap, NgayNhap, NhapKho);

                DTOKho udk = new DTOKho(MaSP, TonKho, HangDangVe, TrangThai);

                DTOSanPham udsp = new DTOSanPham(MaSP, GiaNhap, TonKho);

                BLL.BLLPhieuNhap.SuaTonKhoGia(udk);

                BLL.BLLPhieuNhap.SuaNhapKhoPN(udpn);

                BLL.BLLPhieuNhap.SuaTonKhoSP(udsp);

            }
            ThongBaoCanhBao.ThongBao("Nhập kho thành công!", "Thông Báo !");
            btnNhapKho.setEnabled(false);
            DAOPhieuNhap.CountPN();

            if (countPN % 13 == 0) {
                soTrangPN = countPN / 13;
            } else {
                soTrangPN = countPN / 13 + 1;
            }
            BLL.BLLPhieuNhap.HienThiPhieuNhap(tblPhieuNhap, txtTimKiemPN.getText(), 0);
            lblCountPage1.setText(trangPN1 + "/" + soTrangPN + "");
            lblNumberPage1.setText(trangPN1 + "");
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
        }


    }//GEN-LAST:event_btnNhapKhoActionPerformed

    private void btnDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachActionPerformed
        SoPhieuNhap = null;
        jPanel23.remove(this);
        jPanel32.setVisible(true);
    }//GEN-LAST:event_btnDanhSachActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        jdlThanhToanPhieu jdlTTPN = new jdlThanhToanPhieu(new javax.swing.JFrame(), true);
        jdlTTPN.setVisible(true);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void FileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileChooserActionPerformed

    private void tblChitietphieunhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChitietphieunhapMouseClicked
        if (cbNhapLe.isSelected()) {
            if (SoPhieuNhap == null) {
                if (evt.getClickCount() == 2) {
                    int dongDuocChon = tblChitietphieunhap.getSelectedRow();
                    double ThanhTien = BLL.ChuyenDoi.ChuyenTien(tblChitietphieunhap.getValueAt(dongDuocChon, 9).toString());
                    double TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongtien.getText());
                    TongTien = TongTien - ThanhTien;
                    txtTongtien.setText(BLL.ChuyenDoi.DinhDangTien(TongTien));
                    jdlChinhSanPhamPhieuNhap jdlCTHD = new jdlChinhSanPhamPhieuNhap(new javax.swing.JFrame(), true);
                    jdlCTHD.setVisible(true);
                    try {
                        DefaultTableModel tbModel = (DefaultTableModel) tblChitietphieunhap.getModel();
                        tbModel.removeRow(dongDuocChon);
                    } catch (Exception e) {
                    }

                }
            }
        }
    }//GEN-LAST:event_tblChitietphieunhapMouseClicked

    private void btnChonSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSPActionPerformed

        if (cbNhapLe.isSelected()) {

            if (cbbMau.getSelectedItem().equals("Size")) {
                ThongBaoCanhBao.ThongBao("Vui lòng chọn size sản phẩm để nhập hàng", "Thông Báo");
                return;
            }
            if (cbbMau.getSelectedItem().equals("Màu")) {
                ThongBaoCanhBao.ThongBao("Vui lòng chọn màu sản phẩm để nhập hàng", "Thông Báo");
                return;
            }

            int column = 0;
            int row = tblBangSanPham.getSelectedRow();

            String TenSP = tblBangSanPham.getModel().getValueAt(row, column).toString();
            MyCombobox mbs = (MyCombobox) cbbSize.getSelectedItem();
            int MaSize = Integer.parseInt(mbs.Value.toString());
            MyCombobox mbm = (MyCombobox) cbbMau.getSelectedItem();
            int MaMau = Integer.parseInt(mbm.Value.toString());
            int MaSP = BLL.BLLSanPham.LayMaSanPhamString(TenSP, MaSize, MaMau);
            DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSP);

            for (int i = 0; i < tblChitietphieunhap.getRowCount(); i++) {
                int MaSPB = (int) tblChitietphieunhap.getValueAt(i, 0);
                int SoLuong = (int) tblChitietphieunhap.getValueAt(i, 6);
                double TongTien = ChuyenDoi.ChuyenSangSo(tblChitietphieunhap.getValueAt(i, 9).toString());

                if (MaSP == MaSPB) {
                    DefaultTableModel model = (DefaultTableModel) tblChitietphieunhap.getModel();
                    model.removeRow(i);
                    double tongTien = BLL.BLLPhieuNhap.NhapSanPhamVaoPhieuNhapTrung(tblChitietphieunhap, sp, SoLuong);
                    double TongTienCu = ChuyenDoi.ChuyenSangSo(txtTongtien.getText());
                    double TongTienTru = TongTienCu - TongTien;
                    double TongTienMoi = TongTienTru + tongTien;
                    txtTongtien.setText(ChuyenDoi.DinhDangTien(TongTienMoi));
                    cbbSize.removeAllItems();
                    cbbSize.addItem("Size");
                    cbbMau.removeAllItems();
                    cbbMau.addItem("Màu");
                    return;
                }
            }
            int slmoi = 0;
            double tongTien = BLL.BLLPhieuNhap.NhapSanPhamVaoPhieuNhap(tblChitietphieunhap, sp, slmoi);
            txtTongtien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));

            if (txtMaDonNhapHang.getText().equals("")) {

                txtMaDonNhapHang.setText(BLL.BLLPhieuNhap.TaoMaPhieuNhap());

            }
            cbbSize.removeAllItems();
            cbbSize.addItem("Size");
            cbbMau.removeAllItems();
            cbbMau.addItem("Màu");
        } else if (cbNhapTheoRi.isSelected()) {
            if (txtHinhThucNhap.getText().equals("")) {
                ThongBaoCanhBao.ThongBao("Vui lòng chọn hình thức nhập hàng theo ri!", "Thông Báo");
                jdlHinhThucNhap jdlHTN = new jdlHinhThucNhap(new javax.swing.JFrame(), true);
                jdlHTN.setVisible(true);
                return;
            }
            if (txtHinhThucNhap.getText().equals("0")) {
                int column = 0;
                int row = tblBangSanPham.getSelectedRow();

                String TenSP = tblBangSanPham.getModel().getValueAt(row, column).toString();
                MyCombobox mbs = (MyCombobox) cbbSize.getSelectedItem();
                int MaSize = Integer.parseInt(mbs.Value.toString());
                double tongTien = BLL.BLLPhieuNhap.NhapSanPhamRiSizeVaoPhieuNhap(tblChitietphieunhap, TenSP, MaSize);
                txtTongtien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));
                if (txtMaDonNhapHang.getText().equals("")) {

                    txtMaDonNhapHang.setText(BLL.BLLPhieuNhap.TaoMaPhieuNhap());

                }
                cbbSize.removeAllItems();
                cbbSize.addItem("Size");
                cbbMau.removeAllItems();
                cbbMau.addItem("Màu");

            } else if (txtHinhThucNhap.getText().equals("1")) {
                int column = 0;
                int row = tblBangSanPham.getSelectedRow();

                String TenSP = tblBangSanPham.getModel().getValueAt(row, column).toString();
                MyCombobox mbm = (MyCombobox) cbbMau.getSelectedItem();
                int MaMau = Integer.parseInt(mbm.Value.toString());
                double tongTien = BLL.BLLPhieuNhap.NhapSanPhamRiMauVaoPhieuNhap(tblChitietphieunhap, TenSP, MaMau);
                txtTongtien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));
                if (txtMaDonNhapHang.getText().equals("")) {

                    txtMaDonNhapHang.setText(BLL.BLLPhieuNhap.TaoMaPhieuNhap());

                }
                cbbSize.removeAllItems();
                cbbSize.addItem("Size");
                cbbMau.removeAllItems();
                cbbMau.addItem("Màu");

            }
        }

    }//GEN-LAST:event_btnChonSPActionPerformed

    private void cbNhapTheoRiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNhapTheoRiActionPerformed
        jdlHinhThucNhap jdlHTN = new jdlHinhThucNhap(new javax.swing.JFrame(), true);
        jdlHTN.setVisible(true);
    }//GEN-LAST:event_cbNhapTheoRiActionPerformed

    private void btnXoaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHangActionPerformed
        int dongDuocChon = tblChitietphieunhap.getSelectedRow();
        if (dongDuocChon < 0) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn sản phẩm cần xóa!", "Thông Báo");
            return;
        }
        try {
            DefaultTableModel tbModel = (DefaultTableModel) tblChitietphieunhap.getModel();
            tbModel.removeRow(dongDuocChon);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnXoaHangActionPerformed

    private void btnXoaToanBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaToanBoActionPerformed
        DefaultTableModel tableModel = (DefaultTableModel) tblChitietphieunhap.getModel();
        tableModel.setRowCount(0);
    }//GEN-LAST:event_btnXoaToanBoActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        btnLamMoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed
    public void btnLamMoi() {
        cbNhapLe.setSelected(true);
        txtCongNo.setText("0");
        txtTongtien.setText("");
        txtMaDonNhapHang.setText("");
        txtTag.setText("");
        txtGhiChu.setText("");
        DefaultTableModel tableModel = (DefaultTableModel) tblChitietphieunhap.getModel();
        tableModel.setRowCount(0);
        cbbSize.removeAllItems();
        cbbSize.addItem("Size");
        cbbMau.removeAllItems();
        cbbMau.addItem("Màu");
        cbbSize.setEnabled(false);
        cbbMau.setEnabled(false);
        btnDatHang.setEnabled(true);
        btnNhapKho.setEnabled(true);
        btnThanhToan.setEnabled(true);
        btnChonSP.setEnabled(true);
        txtTimSP.setText("Gõ để tìm sản phẩm");
    }
    private void txtTimSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimSPMouseClicked
        txtTimSP.setText("");
        jPopupMenu3.show(txtTimSP, 0, txtTimSP.getHeight());
        BLLSanPham.HienThiSanPhamBanHang(tblBangSanPham, txtTimSP.getText());
    }//GEN-LAST:event_txtTimSPMouseClicked

    private void txtTimSPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimSPMouseReleased

    }//GEN-LAST:event_txtTimSPMouseReleased

    private void txtTimSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimSPKeyReleased
        if (txtTimSP.getText().equals("")) {
            jPopupMenu3.setVisible(false);
        } else {
            jPopupMenu3.show(txtTimSP, 0, txtTimSP.getHeight());
            BLLSanPham.HienThiSanPhamBanHang(tblBangSanPham, txtTimSP.getText());
        }
    }//GEN-LAST:event_txtTimSPKeyReleased

    private void cbbSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSizeItemStateChanged
        try {
            if (cbNhapLe.isSelected()) {
                int column = 0;
                int row = tblBangSanPham.getSelectedRow();
                String value = tblBangSanPham.getModel().getValueAt(row, column).toString();

                MyCombobox mbs = (MyCombobox) cbbSize.getSelectedItem();
                int MaSize = Integer.parseInt(mbs.Value.toString());
                BLL.BLLSanPham.MauSanPhamTheoTen(cbbMau, value, MaSize);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbbSizeItemStateChanged

    private void tblBangSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangSanPhamMouseClicked
        if (evt.getClickCount() == 1) {
            int dongduocchon = tblBangSanPham.getSelectedRow();
            if (dongduocchon >= 0) {
                cbbSize.setEnabled(true);
                cbbMau.setEnabled(true);
                btnChonSP.setEnabled(true);
            }
        }
        try {
            if (cbNhapLe.isSelected()) {
                int column = 0;
                int row = tblBangSanPham.getSelectedRow();
                String value = tblBangSanPham.getModel().getValueAt(row, column).toString();

                BLL.BLLSanPham.SizeSanPhamTheoTen(cbbSize, value);
                MyCombobox mbs = (MyCombobox) cbbSize.getSelectedItem();
                int MaSize = Integer.parseInt(mbs.Value.toString());
                System.out.println(MaSize);
                BLL.BLLSanPham.MauSanPhamTheoTen(cbbMau, value, MaSize);
                txtTimSP.setText(value);
                jPopupMenu3.setVisible(false);
            } else if (cbNhapTheoRi.isSelected()) {
                if (txtHinhThucNhap.getText().equals("0")) {
                    int column = 0;
                    int row = tblBangSanPham.getSelectedRow();
                    String value = tblBangSanPham.getModel().getValueAt(row, column).toString();
                    BLL.BLLSanPham.SizeSanPhamTheoTen(cbbSize, value);
                    txtTimSP.setText(value);
                    jPopupMenu3.setVisible(false);
                    cbbSize.setEnabled(true);
                    cbbMau.setEnabled(false);
                    cbbMau.removeAllItems();
                    cbbMau.addItem("Màu");

                } else if (txtHinhThucNhap.getText().equals("1")) {
                    int column = 0;
                    int row = tblBangSanPham.getSelectedRow();
                    String value = tblBangSanPham.getModel().getValueAt(row, column).toString();
                    BLL.BLLSanPham.MauSanPhamTheoTenRi(cbbMau, value);
                    txtTimSP.setText(value);
                    jPopupMenu3.setVisible(false);
                    cbbSize.setEnabled(false);
                    cbbMau.setEnabled(true);
                    cbbSize.removeAllItems();
                    cbbSize.addItem("Size");

                }
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblBangSanPhamMouseClicked

    private void cbNhapLeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNhapLeActionPerformed
        txtTimSP.setText("Gõ để tìm sản phẩm");
        cbbMau.removeAllItems();
        cbbMau.addItem("Màu");
        cbbSize.removeAllItems();
        cbbSize.addItem("Size");
    }//GEN-LAST:event_cbNhapLeActionPerformed

    private void txtTimSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimSPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    public static javax.swing.JButton btnChonSP;
    private javax.swing.JButton btnDanhSach;
    public static javax.swing.JButton btnDatHang;
    public static javax.swing.JButton btnLamMoi;
    public static javax.swing.JButton btnNhapKho;
    public static javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoaHang;
    private javax.swing.JButton btnXoaToanBo;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JCheckBox cbNhapLe;
    private javax.swing.JCheckBox cbNhapTheoRi;
    public static javax.swing.JComboBox<String> cbbMau;
    public static javax.swing.JComboBox<String> cbbNhaCungCap;
    public static javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblhotenkhachhang;
    private javax.swing.JLabel lblnhanvienphutrach2;
    private javax.swing.JLabel lblnhomkhachhang;
    private javax.swing.JLabel lblnhomkhachhang12;
    private javax.swing.JLabel lblnhomkhachhang2;
    private javax.swing.JLabel lblthongtinbosung;
    private javax.swing.JLabel lblthongtinbosung1;
    private javax.swing.JLabel lblthongtincoban;
    private javax.swing.JLabel lblthongtinkhac;
    private javax.swing.JPanel pnldanhsach;
    private javax.swing.JPanel pnlnenbtn;
    private javax.swing.JPanel pnlnenhotenkhachhang;
    private javax.swing.JPanel pnlnenlonngoaithongtin;
    private javax.swing.JPanel pnlnenlonthongtincoban;
    private javax.swing.JPanel pnlnenngoaianhdaidienvathongtinkhac;
    private javax.swing.JPanel pnlnenngoaianhdaidienvathongtinkhac1;
    private javax.swing.JPanel pnlnenngoaibtn;
    private javax.swing.JPanel pnlnenngoaithongtin;
    private javax.swing.JPanel pnlnenngoaithongtinkhac;
    private javax.swing.JPanel pnlnenngoaithongtinkhac1;
    private javax.swing.JPanel pnlnenngoaithongtinkhac2;
    private javax.swing.JPanel pnlnennhanvienphutrach2;
    private javax.swing.JPanel pnlnennhomkhachhang;
    private javax.swing.JPanel pnlnennhomkhachhang2;
    private javax.swing.JPanel pnlnennhomkhachhang8;
    private javax.swing.JPanel pnlnenthemsuakhachhang1;
    private javax.swing.JPanel pnlnenthongtin;
    private javax.swing.JPanel pnlnenthongtinkhac;
    private javax.swing.JPanel pnlthemsuakhachhang;
    public static javax.swing.JTable tblBangSanPham;
    public static javax.swing.JTable tblChitietphieunhap;
    public static javax.swing.JTextField txtCongNo;
    public static javax.swing.JTextField txtGhiChu;
    public static javax.swing.JTextField txtHinhThucNhap;
    public static javax.swing.JTextField txtMaDonNhapHang;
    public static javax.swing.JTextField txtNgayNhap;
    public static javax.swing.JTextField txtTag;
    public static javax.swing.JTextField txtTimSP;
    public static javax.swing.JTextField txtTongtien;
    // End of variables declaration//GEN-END:variables
}
