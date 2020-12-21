/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ChuyenDoi;
import DAO.DAOHoaDon;
import DAO.DAOTraHang;
import DTO.DTOChiTietTraHang;
import DTO.MyCombobox;
import static GUI.jdlDanhSachDeTraHang.tblDanhSachTraHang;
import static GUI.pnlhanghoa.lblCountPage;
import static GUI.pnlhanghoa.lblCountPage3;
import static GUI.pnlhanghoa.lblNumberPage;
import static GUI.pnlhanghoa.lblNumberPage3;
import static GUI.pnlhanghoa.tblDSTraHang;
import static GUI.pnlhanghoa.tblHoaDon;
import static GUI.pnlhanghoa.txtTimKiemHD;
import static GUI.pnlhanghoa.txttimkiem4;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sofaraway1604
 */
public class pnltrahang extends javax.swing.JPanel {

    /**
     *
     */
    public static int MaHD;
    public static String SoHoaDon;
    public static String NgayTao;
    public static String MaNV;
    public static String MaKH;
    public static String TongTien;
    public static String SoTraHang;
    public static int MaPT;
    public static int countTH, soTrangTH, trangTH = 1;
    public int trangTH1 = 1;
    public static int countHD, soTrangHD, trangHD = 1;
    public int trangHD1 = 1;
    public static int countKho, soTrangKho, trangKho = 1;
    public int trangKho1 = 1;
    public static int countSP, soTrangSP, trangSP = 1;
    public int trangSP1 = 1;

    public pnltrahang() {
        initComponents();
        if (SoTraHang == null) {

            double TongTien = BLL.BLLTraHang.HienThiChiTietHoaDon(tblPhieutra, MaHD);
            txtTongtien.setText(ChuyenDoi.DinhDangTien(TongTien));
            Date date = new Date();
            DTO.DTOHoaDon hd = BLL.BLLHoaDon.GetMaHD(MaHD);
            BLL.BLLTraHang.SetCBBKhachHang(cbbKhachHang, hd.getMaKhachHang());
            txtSoDonHang.setText(SoHoaDon);
            for (int i = 0; i < tblPhieutra.getRowCount(); i++) {
                String SoLuong = (tblPhieutra.getValueAt(i, 5).toString());
                String[] parts = SoLuong.split("/");
                String SoLuongHang = parts[0];
                txtSoLuong.setText(SoLuongHang);
            }
            txtSoLuong.setEnabled(false);
            txtTongtien.setEnabled(false);
            txtSoDonHang.setEnabled(false);
            NgayGio();

        } else {

            int SoLuong = BLL.BLLTraHang.HienThiChiTietTraHang(tblPhieutra, MaPT);
            DTO.DTOTraHang th = BLL.BLLTraHang.GetMaPT(MaPT);
            DTO.DTOHoaDon hdth = BLL.BLLHoaDon.GetMaHD(th.getMaHoaDon());
            BLL.BLLKhachHang.SetCBBKhachHang(cbbKhachHang, th.getMaKhachHang());
            txtSoLuong.setText(String.valueOf(SoLuong));
            txtTongTienTPT.setText(ChuyenDoi.DinhDangTien(BLL.BLLTraHang.TongTienTPT));
            txtTongtien.setText(ChuyenDoi.DinhDangTien(th.getTongTien()));
            txtSoDonTraHang.setText(th.getSoPhieuTra());
            txtSoDonHang.setText(hdth.getSoHoaDon());

            cbbThanhToan.setSelectedItem(th.getHinhThucThanhToan());
            txtLyDoTra.setText(th.getLyDoTra());
            cbbThanhToan.setEnabled(false);
            txtSoLuong.setEnabled(false);
            txtTongtien.setEnabled(false);
            txtSoDonHang.setEnabled(false);
            txtLyDoTra.setEnabled(false);
            btnTraHang.setEnabled(false);
            btnLamMoi.setEnabled(false);
            if (th.getTrangThai() == 1) {
                btnNhanHang.setEnabled(false);
            }
            if (th.getHoanTien() == 1) {
                btnThanhToan.setEnabled(false);
            }
            tblPhieutra.setEnabled(false);
            NgayGio();
        }

    }

    public pnltrahang(int MaHD, String SoHoaDon, String NgayTao, String MaNV, String MaKH, String TongTien) {
        pnltrahang.MaHD = MaHD;
        pnltrahang.SoHoaDon = SoHoaDon;
        pnltrahang.NgayTao = NgayTao;
        pnltrahang.MaNV = MaNV;
        pnltrahang.MaKH = MaKH;
        pnltrahang.TongTien = TongTien;
        initComponents();
    }

    public pnltrahang(int MaPT, String SoTraHang, String SoHoaDon) {
        pnltrahang.MaPT = MaPT;
        pnltrahang.SoTraHang = SoTraHang;
        pnltrahang.SoHoaDon = SoHoaDon;
        initComponents();
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

                    txtNgayTra.setText(day);

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
        ppmCTHD = new javax.swing.JPopupMenu();
        mniXoaCTHD = new javax.swing.JMenuItem();
        txtNgayTra = new javax.swing.JTextField();
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
        txtSoDonHang = new javax.swing.JTextField();
        pnlnennhanvienphutrach = new javax.swing.JPanel();
        lblnhanvienphutrach = new javax.swing.JLabel();
        txtSoDonTraHang = new javax.swing.JTextField();
        pnlnennhanvienphutrach2 = new javax.swing.JPanel();
        lblnhanvienphutrach2 = new javax.swing.JLabel();
        txtLyDoTra = new javax.swing.JTextField();
        pnlnennhomkhachhang2 = new javax.swing.JPanel();
        lblnhomkhachhang2 = new javax.swing.JLabel();
        cbbThanhToan = new javax.swing.JComboBox<>();
        pnlnenlonthongtincoban = new javax.swing.JPanel();
        pnlnenlonngoaithongtin = new javax.swing.JPanel();
        pnlnenngoaithongtin = new javax.swing.JPanel();
        pnlnenthongtin = new javax.swing.JPanel();
        lblthongtincoban = new javax.swing.JLabel();
        pnlnenhotenkhachhang = new javax.swing.JPanel();
        lblhotenkhachhang = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        lblthongtinbosung = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtTongtien = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhieutra = new javax.swing.JTable();
        txtTongTienTPT = new javax.swing.JTextField();
        pnlnenngoaibtn = new javax.swing.JPanel();
        pnlnenbtn = new javax.swing.JPanel();
        btnTraHang = new javax.swing.JButton();
        btnNhanHang = new javax.swing.JButton();
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

        mniXoaCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/delete_20px.png"))); // NOI18N
        mniXoaCTHD.setText("Xóa Sản Phẩm");
        mniXoaCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXoaCTHDActionPerformed(evt);
            }
        });
        ppmCTHD.add(mniXoaCTHD);

        txtNgayTra.setText("jTextField1");

        setPreferredSize(new java.awt.Dimension(980, 586));

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
        lblthongtinkhac.setText("Thông tin đơn trả hàng");
        lblthongtinkhac.setPreferredSize(new java.awt.Dimension(34, 20));

        pnlnennhomkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang.setText("Số đơn hàng");
        lblnhomkhachhang.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang.add(lblnhomkhachhang, java.awt.BorderLayout.PAGE_START);
        pnlnennhomkhachhang.add(txtSoDonHang, java.awt.BorderLayout.CENTER);

        pnlnennhanvienphutrach.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhanvienphutrach.setLayout(new java.awt.BorderLayout());

        lblnhanvienphutrach.setBackground(new java.awt.Color(255, 255, 255));
        lblnhanvienphutrach.setText("Số Đơn Trả Hàng");
        lblnhanvienphutrach.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhanvienphutrach.add(lblnhanvienphutrach, java.awt.BorderLayout.PAGE_START);

        txtSoDonTraHang.setEnabled(false);
        pnlnennhanvienphutrach.add(txtSoDonTraHang, java.awt.BorderLayout.CENTER);

        pnlnennhanvienphutrach2.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhanvienphutrach2.setLayout(new java.awt.BorderLayout());

        lblnhanvienphutrach2.setBackground(new java.awt.Color(255, 255, 255));
        lblnhanvienphutrach2.setText("Lý do trả hàng");
        lblnhanvienphutrach2.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhanvienphutrach2.add(lblnhanvienphutrach2, java.awt.BorderLayout.PAGE_START);
        pnlnennhanvienphutrach2.add(txtLyDoTra, java.awt.BorderLayout.CENTER);

        pnlnennhomkhachhang2.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang2.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang2.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang2.setText("Hình thức thanh toán");
        lblnhomkhachhang2.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang2.add(lblnhomkhachhang2, java.awt.BorderLayout.PAGE_START);

        cbbThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Quẹt Thẻ", "Chuyển Khoản", "COD", " " }));
        pnlnennhomkhachhang2.add(cbbThanhToan, java.awt.BorderLayout.PAGE_END);

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
                            .addComponent(pnlnennhanvienphutrach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlnennhanvienphutrach, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(pnlnennhomkhachhang2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlnennhanvienphutrach2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlnenngoaithongtinkhacLayout = new javax.swing.GroupLayout(pnlnenngoaithongtinkhac);
        pnlnenngoaithongtinkhac.setLayout(pnlnenngoaithongtinkhacLayout);
        pnlnenngoaithongtinkhacLayout.setHorizontalGroup(
            pnlnenngoaithongtinkhacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthongtinkhac, javax.swing.GroupLayout.PREFERRED_SIZE, 251, Short.MAX_VALUE)
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

        lblthongtincoban.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblthongtincoban.setText("Thông tin khách hàng");

        pnlnenhotenkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenhotenkhachhang.setLayout(new java.awt.BorderLayout());

        lblhotenkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblhotenkhachhang.setText("Tên Khách Hàng");
        lblhotenkhachhang.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnenhotenkhachhang.add(lblhotenkhachhang, java.awt.BorderLayout.PAGE_START);

        cbbKhachHang.setToolTipText("");
        cbbKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhachHangActionPerformed(evt);
            }
        });
        pnlnenhotenkhachhang.add(cbbKhachHang, java.awt.BorderLayout.CENTER);

        lblthongtinbosung.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblthongtinbosung.setText("Thông tin sản phẩm");

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new java.awt.BorderLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Số tiền phiếu trả");
        jLabel17.setPreferredSize(new java.awt.Dimension(52, 20));
        jPanel39.add(jLabel17, java.awt.BorderLayout.PAGE_START);
        jPanel39.add(txtTongtien, java.awt.BorderLayout.CENTER);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new java.awt.BorderLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Tổng số lượng");
        jLabel18.setPreferredSize(new java.awt.Dimension(31, 20));
        jPanel40.add(jLabel18, java.awt.BorderLayout.PAGE_START);
        jPanel40.add(txtSoLuong, java.awt.BorderLayout.CENTER);

        tblPhieutra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ảnh", "Tên Sản Phẩm", "Size", "Màu", "Số Lượng", "Giá Hàng", "Phí Trả", "Thành Tiền", "Mã Sản Phẩm", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhieutra.setRowHeight(40);
        tblPhieutra.setShowVerticalLines(false);
        tblPhieutra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieutraMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblPhieutraMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPhieutra);

        javax.swing.GroupLayout pnlnenthongtinLayout = new javax.swing.GroupLayout(pnlnenthongtin);
        pnlnenthongtin.setLayout(pnlnenthongtinLayout);
        pnlnenthongtinLayout.setHorizontalGroup(
            pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnenthongtinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(lblthongtincoban, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblthongtinbosung, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
                    .addComponent(pnlnenhotenkhachhang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnenthongtinLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTongTienTPT, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        pnlnenthongtinLayout.setVerticalGroup(
            pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblthongtincoban)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlnenhotenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(txtTongTienTPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblthongtinbosung, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btnTraHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/checkmark_20px.png"))); // NOI18N
        btnTraHang.setText("Trả Hàng");
        btnTraHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnTraHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraHangActionPerformed(evt);
            }
        });

        btnNhanHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/maintenance_20px.png"))); // NOI18N
        btnNhanHang.setText("Nhận Hàng");
        btnNhanHang.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNhanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanHangActionPerformed(evt);
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

        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/available_updates_20px.png"))); // NOI18N
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
                .addGap(174, 174, 174)
                .addComponent(btnDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNhanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(btnDanhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlnenbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNhanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
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
            .addGap(0, 0, Short.MAX_VALUE)
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
            .addGap(0, 989, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnldanhsach, javax.swing.GroupLayout.PREFERRED_SIZE, 983, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnldanhsach, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTraHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraHangActionPerformed
        for (int i = 0; i < tblPhieutra.getRowCount(); i++) {
            String SoLuongBang = (tblPhieutra.getValueAt(i, 5).toString());
            String[] parts = SoLuongBang.split("/");
            String SoLuongHang = parts[0];
            int SoLuongTra = Integer.parseInt(SoLuongHang);
            if (SoLuongTra == 0) {
                ThongBaoCanhBao.ThongBao("Vui lòng chọn số lượng trả hàng cho tất cả sản phẩm!", "Thông Báo");
                return;
            }
        }
        MyCombobox mbkh = (MyCombobox) cbbKhachHang.getSelectedItem();
        int MaKH = Integer.parseInt(mbkh.Value.toString());
        int MaNV = BLL.BLLHoaDon.LayMaNhanVienString(BLL.BLLlogin.nguoidung.getTenNguoiDung());
        String SoPhieuTra = txtSoDonTraHang.getText();
        int TrangThai;
        int HoanTien;

        TrangThai = 0;
        HoanTien = 0;
        double TongTien = BLL.ChuyenDoi.ChuyenSangSo(txtTongtien.getText());
        String NgayNhan = txtNgayTra.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String LyDoTra = txtLyDoTra.getText();
        String HinhThucThanhToan = cbbThanhToan.getSelectedItem().toString();

        DTO.DTOTraHang th = new DTO.DTOTraHang(MaHD, MaKH, MaNV, SoPhieuTra, TrangThai, HoanTien, TongTien, NgayNhan, LyDoTra, HinhThucThanhToan);
        BLL.BLLTraHang.ThemPhieuTraHang(th);
        int TraHang = 1;
        DTO.DTOHoaDon hdth = new DTO.DTOHoaDon(MaHD, TraHang);
        BLL.BLLHoaDon.SuaTraHangHoaDon(hdth);
        int MaPT = BLL.BLLTraHang.LayMaPhieuTraString(SoPhieuTra);
        for (int i = 0; i < tblPhieutra.getRowCount(); i++) {

            int MaCTHD = Integer.parseInt(tblPhieutra.getValueAt(i, 0).toString());
            int MaSP = Integer.parseInt(tblPhieutra.getValueAt(i, 9).toString());
            int SoLuongChon = 0;
            String SoLuongBang = (tblPhieutra.getValueAt(i, 5).toString());
            String[] parts = SoLuongBang.split("/");
            String SoLuongHang = parts[0];
            SoLuongChon = Integer.parseInt(SoLuongHang);
            double GiaHang = 0;
            GiaHang = BLL.ChuyenDoi.ChuyenTien(tblPhieutra.getValueAt(i, 6).toString());
            double PhiTra = 0;
            PhiTra = BLL.ChuyenDoi.ChuyenTien(tblPhieutra.getValueAt(i, 7).toString());
            double ThanhTien = 0;
            ThanhTien = BLL.ChuyenDoi.ChuyenTien(tblPhieutra.getValueAt(i, 8).toString());
            String GhiChu = "Mới";
            DTO.DTOChiTietTraHang ctth = new DTOChiTietTraHang(MaPT, MaCTHD, MaSP, SoLuongChon, GiaHang, PhiTra, ThanhTien, GhiChu);
            BLL.BLLTraHang.ThemCTTH(ctth);
        }
        ThongBaoCanhBao.ThongBao("Thêm phiếu trả hàng thành công", "Thông Báo");

        DAOTraHang.CountTraHang();
        if (countTH % 13 == 0) {
            soTrangTH = countTH / 13;
        } else {
            soTrangTH = countTH / 13 + 1;
        }
        BLL.BLLTraHang.HienThiTraHang(tblDSTraHang, txttimkiem4.getText(), 0);
        lblCountPage3.setText(trangTH1 + "/" + soTrangTH + "");
        lblNumberPage3.setText(trangTH1 + "");
        DAOHoaDon.CountHoaDon();

        if (countHD % 13 == 0) {
            soTrangHD = countHD / 13;
        } else {
            soTrangHD = countHD / 13 + 1;
        }
        BLL.BLLHoaDon.HienThiHoaDon(tblHoaDon, txtTimKiemHD.getText(), 0);
        lblCountPage.setText(trangHD1 + "/" + soTrangHD + "");
        lblNumberPage.setText(trangHD1 + "");

        BLL.BLLTraHang.HienThiHoaDonTheoTraHang(tblDanhSachTraHang);
        btnTraHang.setEnabled(false);
        cbbThanhToan.setEnabled(false);
        cbbKhachHang.setEnabled(false);
        tblPhieutra.setEnabled(false);
        txtSoLuong.setEnabled(false);
        txtTongtien.setEnabled(false);
        txtSoDonHang.setEnabled(false);
        txtLyDoTra.setEnabled(false);
        btnTraHang.setEnabled(false);
        btnLamMoi.setEnabled(false);

    }//GEN-LAST:event_btnTraHangActionPerformed

    private void btnNhanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanHangActionPerformed
        String SoPhieuTra = txtSoDonTraHang.getText();
        int TrangThai;
        TrangThai = 1;

        String NgayNhan = txtNgayTra.getText();
        DTO.DTOHoaDon hds = BLL.BLLHoaDon.GetSoHD(SoHoaDon);
        double TongTienSauHD = hds.getTongTien();
        double TongTienTPT = ChuyenDoi.ChuyenSangSo(txtTongTienTPT.getText());

        if (TongTienSauHD != TongTienTPT) {
            int TraHang = 0;
            DTO.DTOHoaDon hdth = new DTO.DTOHoaDon(MaHD, TraHang);
            BLL.BLLHoaDon.SuaTraHangHoaDon(hdth);
        }
        DTO.DTOTraHang th = new DTO.DTOTraHang(SoPhieuTra, TrangThai, NgayNhan);
        BLL.BLLTraHang.SuaPhieuTraHang(th);
        for (int i = 0; i < tblPhieutra.getRowCount(); i++) {
            int MaCTHD;
            int SoLuongChon;
            MaCTHD = Integer.parseInt(tblPhieutra.getValueAt(i, 0).toString());
            String SoLuongBang = (tblPhieutra.getValueAt(i, 5).toString());
            String[] parts = SoLuongBang.split("/");
            String SoLuongHang = parts[0];
            SoLuongChon = Integer.parseInt(SoLuongHang);
            double ThanhTien = ChuyenDoi.ChuyenSangSo(tblPhieutra.getValueAt(i, 6).toString());
            int MaSP = Integer.parseInt(tblPhieutra.getValueAt(i, 9).toString());
            DTO.DTOChiTietHoaDon cthdm = BLL.BLLTraHang.GetMaCTHD(MaCTHD);
            int SoLuongCTHD = cthdm.getSoLuong();

            if (SoLuongCTHD > SoLuongChon) {
                int SoLuongCTHDM = SoLuongCTHD - SoLuongChon;
                double ThanhTienSua = ThanhTien * SoLuongChon;
                DTO.DTOChiTietHoaDon cthd = new DTO.DTOChiTietHoaDon(MaCTHD, SoLuongCTHDM, ThanhTienSua);
                BLL.BLLTraHang.SuaCTHD(cthd);

                DTO.DTOSanPham spm = BLL.BLLSanPham.GetMaSP(MaSP);
                DTO.DTOKho khm = BLL.BLLKho.GetKhoTheoIDSP(MaSP);
                int SoLuongTonKho = khm.getTonKho();
                int SoLuongTonKhoSP = spm.getTonKho();
                int TonKhoSP = SoLuongTonKhoSP + SoLuongChon;
                DTO.DTOSanPham sp = new DTO.DTOSanPham(MaSP, TonKhoSP);
                BLL.BLLTraHang.SuaTonKhoSP(sp);
                int TonKhoKho = SoLuongTonKho + SoLuongChon;
                DTO.DTOKho kho = new DTO.DTOKho(MaSP, TonKhoKho);
                BLL.BLLTraHang.SuaTonKhoKho(kho);

            } else if (SoLuongCTHD == SoLuongChon) {
                DTO.DTOSanPham spm = BLL.BLLSanPham.GetMaSP(MaSP);
                DTO.DTOKho khm = BLL.BLLKho.GetKhoTheoIDSP(MaSP);
                int SoLuongTonKho = khm.getTonKho();
                int TonKhoKho = SoLuongTonKho + SoLuongChon;
                DTO.DTOKho kh = new DTO.DTOKho(MaSP, TonKhoKho);
                BLL.BLLTraHang.SuaTonKhoKho(kh);
                int SoLuongTonKhoSP = spm.getTonKho();
                int TonKhoSP = SoLuongTonKhoSP + SoLuongChon;
                DTO.DTOSanPham sp = new DTO.DTOSanPham(MaSP, TonKhoSP);
                BLL.BLLTraHang.SuaTonKhoSP(sp);
                DAO.DAOTraHang.XoaCTHD(MaSP);
            }
        }
        DTO.DTOHoaDon hd = BLL.BLLHoaDon.GetSoHD(SoHoaDon);
        double TongTienHD = hd.getTongTien();
        double TongTienTra = ChuyenDoi.ChuyenSangSo(txtTongtien.getText());
        double TongTienHDM = TongTienHD - TongTienTra;
        DTO.DTOHoaDon shd = new DTO.DTOHoaDon(SoHoaDon, TongTienHDM);
        BLL.BLLTraHang.SuaTongTienHD(shd);

        ThongBaoCanhBao.ThongBao("Nhận hàng thành công", "Thông Báo");
        DAOTraHang.CountTraHang();
        if (countTH % 13 == 0) {
            soTrangTH = countTH / 13;
        } else {
            soTrangTH = countTH / 13 + 1;
        }
        BLL.BLLTraHang.HienThiTraHang(tblDSTraHang, txttimkiem4.getText(), 0);
        lblCountPage3.setText(trangTH1 + "/" + soTrangTH + "");
        lblNumberPage3.setText(trangTH1 + "");
        DAOHoaDon.CountHoaDon();

        if (countHD % 13 == 0) {
            soTrangHD = countHD / 13;
        } else {
            soTrangHD = countHD / 13 + 1;
        }
        BLL.BLLHoaDon.HienThiHoaDon(tblHoaDon, txtTimKiemHD.getText(), 0);
        lblCountPage.setText(trangHD1 + "/" + soTrangHD + "");
        lblNumberPage.setText(trangHD1 + "");
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

        BLL.BLLTraHang.HienThiHoaDonTheoTraHang(tblDanhSachTraHang);
        btnNhanHang.setEnabled(false);

    }//GEN-LAST:event_btnNhanHangActionPerformed

    private void btnDanhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachActionPerformed
        SoTraHang = null;
        GUI.pnlhanghoa.jPanel28.remove(this);
        GUI.pnlhanghoa.jPanel27.setVisible(true);
    }//GEN-LAST:event_btnDanhSachActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        jdlThanhToanPhieuTra jdlTTPT = new jdlThanhToanPhieuTra(new javax.swing.JFrame(), true);
        jdlTTPT.setVisible(true);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void FileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileChooserActionPerformed

    private void tblPhieutraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieutraMouseClicked
        if (SoTraHang == null) {
            if (evt.getClickCount() == 2) {
                int dongDuocChon = tblPhieutra.getSelectedRow();
                double ThanhTien = BLL.ChuyenDoi.ChuyenTien(tblPhieutra.getValueAt(dongDuocChon, 8).toString());
                double TongTien = BLL.ChuyenDoi.ChuyenTien(txtTongtien.getText());
                TongTien = TongTien - ThanhTien;
                txtTongtien.setText(BLL.ChuyenDoi.DinhDangTien(TongTien));

                double ThanhTienTPT = BLL.ChuyenDoi.ChuyenTien(tblPhieutra.getValueAt(dongDuocChon, 10).toString());
                double TongTienTPT = BLL.ChuyenDoi.ChuyenTien(txtTongTienTPT.getText());
                TongTienTPT = TongTienTPT - ThanhTienTPT;
                txtTongTienTPT.setText(BLL.ChuyenDoi.DinhDangTien(TongTienTPT));

                String SoLuongBang = (tblPhieutra.getValueAt(dongDuocChon, 5).toString());
                String[] parts = SoLuongBang.split("/");
                String SoLuongHang = parts[0];
                int SoLuongCu = Integer.parseInt(txtSoLuong.getText());
                SoLuongCu = SoLuongCu - Integer.parseInt(SoLuongHang);
                txtSoLuong.setText(SoLuongCu + "");
                jdlChinhPhieuTraHang jdlCPTH = new jdlChinhPhieuTraHang(new javax.swing.JFrame(), true);
                jdlCPTH.setVisible(true);
                try {
                    DefaultTableModel tbModel = (DefaultTableModel) tblPhieutra.getModel();
                    tbModel.removeRow(dongDuocChon);
                } catch (Exception e) {
                }
            }

        }
    }//GEN-LAST:event_tblPhieutraMouseClicked

    private void cbbKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKhachHangActionPerformed

    private void tblPhieutraMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieutraMouseReleased
        if (evt.isPopupTrigger()) {
            ppmCTHD.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblPhieutraMouseReleased

    private void mniXoaCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXoaCTHDActionPerformed
        int dongDuocChon = tblPhieutra.getSelectedRow();
        try {
            DefaultTableModel tbModel = (DefaultTableModel) tblPhieutra.getModel();
            tbModel.removeRow(dongDuocChon);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_mniXoaCTHDActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed

        txtTongtien.setText("");
        txtSoDonTraHang.setText("");
        txtSoDonHang.setText("");
        txtSoLuong.setText("0");
        Date date = new Date();
        txtLyDoTra.setText("");
        DefaultTableModel tableModel = (DefaultTableModel) tblPhieutra.getModel();
        tableModel.setRowCount(0);
        btnTraHang.setEnabled(true);
        btnNhanHang.setEnabled(true);
        btnThanhToan.setEnabled(true);
    }//GEN-LAST:event_btnLamMoiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JButton btnDanhSach;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnNhanHang;
    public static javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTraHang;
    public static javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbThanhToan;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblhotenkhachhang;
    private javax.swing.JLabel lblnhanvienphutrach;
    private javax.swing.JLabel lblnhanvienphutrach2;
    private javax.swing.JLabel lblnhomkhachhang;
    private javax.swing.JLabel lblnhomkhachhang2;
    private javax.swing.JLabel lblthongtinbosung;
    private javax.swing.JLabel lblthongtincoban;
    private javax.swing.JLabel lblthongtinkhac;
    private javax.swing.JMenuItem mniXoaCTHD;
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
    private javax.swing.JPanel pnlnennhanvienphutrach;
    private javax.swing.JPanel pnlnennhanvienphutrach2;
    private javax.swing.JPanel pnlnennhomkhachhang;
    private javax.swing.JPanel pnlnennhomkhachhang2;
    private javax.swing.JPanel pnlnenthemsuakhachhang1;
    private javax.swing.JPanel pnlnenthongtin;
    private javax.swing.JPanel pnlnenthongtinkhac;
    private javax.swing.JPanel pnlthemsuakhachhang;
    private javax.swing.JPopupMenu ppmCTHD;
    public static javax.swing.JTable tblPhieutra;
    private javax.swing.JTextField txtLyDoTra;
    public static javax.swing.JTextField txtNgayTra;
    public static javax.swing.JTextField txtSoDonHang;
    public static javax.swing.JTextField txtSoDonTraHang;
    public static javax.swing.JTextField txtSoLuong;
    public static javax.swing.JTextField txtTongTienTPT;
    public static javax.swing.JTextField txtTongtien;
    // End of variables declaration//GEN-END:variables
}
