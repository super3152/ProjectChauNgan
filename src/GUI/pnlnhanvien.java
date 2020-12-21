/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLLChamCong;
import BLL.BLLNguoiDung;

import BLL.BLLPhatLuong;
import BLL.ChuyenDoi;
import DAO.DAOChamCong;
import DAO.DAONguoiDung;
import DTO.DTOChamCong;
import DTO.DTONguoidung;
import DTO.DTOPhatLuong;
import DTO.DTOPhieuThuChi;
import DTO.MyCombobox;
import static GUI.frmmain.panelcam;
import static GUI.jdlLocNhanVien.GioiTinh;
import static GUI.jdlLocNhanVien.Quyen;
import static GUI.jdlLocNhanVien.TrangThai;
import static GUI.pnlkhachhang.txtTimKiem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author Takemikazuchi
 */
public class pnlnhanvien extends javax.swing.JPanel {

    public Date currenTime = new Date();
    Timer updateTimer;
    int DELAY = 100;
    public static int countNV, soTrangNV, trangNV = 1;
    public int trangNV1 = 1;
    public static String LocNhanVien;
    private void FillNhanVien() {

        pnlChucVu.removeAll();

        DefaultTableModel dtm = (DefaultTableModel) tblNguoiDung.getModel();
        dtm.setRowCount(0);

        ArrayList<DTONguoidung> chucvu = DAO.DAONguoiDung.GetChucVu();
        ArrayList<Boolean> checkclick = new ArrayList<>();
        JPanel[] pnlBan = new JPanel[chucvu.size()];
        JLabel[] lblImgBan = new JLabel[chucvu.size()];
        JLabel[] lblTenBan = new JLabel[chucvu.size()];
        int i = 0;
        final int fu = i;
        for (i = 0; i < chucvu.size(); i++) {
            checkclick.add(i, false);
            pnlBan[i] = new javax.swing.JPanel();
            lblImgBan[i] = new javax.swing.JLabel();
            lblTenBan[i] = new javax.swing.JLabel();
            lblTenBan[i].setFont(new java.awt.Font("Tahoma", 0, 14));
            lblTenBan[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            if (chucvu.get(i).getQuyen() == 0) {
                lblTenBan[i].setText("Quản Trị");
            } else if (chucvu.get(i).getQuyen() == 1) {
                lblTenBan[i].setText("Nhân Viên");
            }

            javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan[i]);
            pnlBan[i].setLayout(pnlBanLayout);
            pnlBanLayout.setHorizontalGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBanLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblImgBan[i], javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTenBan[i], javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                public void mousePressed(MouseEvent e) {
                    if (checkclick.get(j)) {
                        checkclick.set(j, false);

                        e.getComponent().setBackground(Color.yellow);
                    } else {
                        checkclick.set(j, true);
                        BLL.BLLNguoiDung.HienThiNguoiDungTheoChucVu(tblNguoiDung, chucvu.get(j).getQuyen());
                        for (int k = 0; k < chucvu.size(); k++) {
                            if (k != j) {
                                checkclick.set(k, false);
                                pnlBan[k].setBackground(new java.awt.Color(240, 240, 240));
                            }
                        }
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    e.getComponent().setBackground(Color.yellow);

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (checkclick.get(j)) {
                        e.getComponent().setBackground(Color.yellow);

                    } else {

                        e.getComponent().setBackground(new java.awt.Color(240, 240, 240));
                    }
                }
            });
            pnlChucVu.add(pnlBan[i]);
        }
        pnlChucVu.updateUI();
    }

    public pnlnhanvien() {
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

        String formatTimeStr = "yyyy-MM-dd";
        DateFormat formatTime = new SimpleDateFormat(formatTimeStr);
        String formatedTimeStr = formatTime.format(currenTime);
        System.out.println(formatedTimeStr);
        BLL.BLLNguoiDung.LayNhanVien(jTable22);
        int row = jTable22.getRowCount();
        for (int i = 0; i < row; i++) {
            int check = Integer.parseInt(jTable22.getValueAt(0, 0).toString());
            System.out.println(check);
            BLL.BLLChamCong.CheckNgayChamCong(jTable11, formatedTimeStr, check);
            if (jTable11.getRowCount() == 1) {

            } else {
                System.out.println("Chưa có chấm công id " + check);
                int idnguoidung = check;
                String ngaychamcong = formatedTimeStr;
                if (BLL.BLLChamCong.KiemTraThemChamCong(idnguoidung, ngaychamcong)) {
                    DTOChamCong cc = new DTOChamCong(idnguoidung, ngaychamcong);
                    BLL.BLLChamCong.ThemChamCong(cc);
                    System.out.println("Đã thêm chấm công nhân viên " + idnguoidung);
                }
            }
            ((DefaultTableModel) jTable22.getModel()).removeRow(0);
        }

        BLLNguoiDung.DoDuLieuVaoCBBNguoiDung(cbbNguoidung);
        updateTimer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date currenTime = new Date();
                Date d = new Date();
                int year = d.getYear();
                int month = d.getMonth();
                int day = d.getDay();
                Calendar calendar = new GregorianCalendar(year, month, day);
                int numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                String formatTimeStr = "dd/MM/yyyy" + " - " + "HH:mm:ss";
                String formatTimeStr2 = "MM/yyyy";
                String formatTimeStr3 = "HH:mm";
                String formatTimeStr4 = "HH";
                String formatTimeStr9 = "yyyy/MM/dd";
                DateFormat formatTime = new SimpleDateFormat(formatTimeStr);
                DateFormat formatTime2 = new SimpleDateFormat(formatTimeStr2);
                DateFormat formatTime3 = new SimpleDateFormat(formatTimeStr3);
                DateFormat formatTime9 = new SimpleDateFormat(formatTimeStr9);

                String formatedTimeStr = formatTime.format(currenTime);
                String formatedTimeStr2 = formatTime2.format(currenTime);
                String formatedTimeStr3 = formatTime3.format(currenTime);
                String formatedTimeStr9 = formatTime9.format(currenTime);
                txtNgayPhat.setText(formatedTimeStr9);
                txtNgayhomnay.setText(formatedTimeStr);
                jLabel8.setText(" Thông tin chấm công nhân viên ( Tháng " + formatedTimeStr2 + " ) - " + numberOfDays + " Ngày");

            }
        });
        updateTimer.start();

        int milisInAMinute = 2000;
        long time = System.currentTimeMillis();

        Runnable update = new Runnable() {
            public void run() {

                String formatTimeStr4 = "HH";
                DateFormat formatTime4 = new SimpleDateFormat(formatTimeStr4);
                int formatedTimeStr4 = Integer.parseInt(formatTime4.format(currenTime));
                if (formatedTimeStr4 < 12 && formatedTimeStr4 >= 7) {
                    txtUudai1.setText("Ca Sáng - ( 7h15 - 11h30 )");
                } else if (formatedTimeStr4 < 17 && formatedTimeStr4 >= 13) {
                    txtUudai1.setText("Ca Chiều - ( 13h00 - 17h00 )");
                } else if (formatedTimeStr4 < 21 && formatedTimeStr4 >= 17) {
                    txtUudai1.setText("Ca Tối - ( 17h00 - 21h00 )");
                } else {
                    txtUudai1.setText("Giờ nghỉ");
                }

            }

        };

        java.util.Timer timer = new java.util.Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                update.run();
            }
        }, time % milisInAMinute, milisInAMinute);
        update.run();

        String formatTimeStr5 = "yyyy";
        String formatTimeStr6 = "MM";
        DateFormat formatTime5 = new SimpleDateFormat(formatTimeStr5);
        String formatedTimeStr5 = formatTime5.format(currenTime);
        for (int i = 2000; i <= 2050; i++) {
            jComboBox2.addItem("" + i);
            jComboBox4.addItem("" + i);
            cbbNam.addItem("" + i);

        }
        jComboBox2.setSelectedItem(formatedTimeStr5);
        jComboBox4.setSelectedItem(formatedTimeStr5);
        cbbNam.setSelectedItem(formatedTimeStr5);

        DateFormat formatTime6 = new SimpleDateFormat(formatTimeStr6);
        String formatedTimeStr6 = formatTime6.format(currenTime);

        for (int i = 1; i <= 12; i++) {
            jComboBox1.addItem("" + i);
            jComboBox3.addItem("" + i);
            cbbThang.addItem("" + i);

        }
        jComboBox1.setSelectedItem(formatedTimeStr6);
        jComboBox3.setSelectedItem(formatedTimeStr6);
        cbbThang.setSelectedItem(formatedTimeStr6);

        int thang = Integer.parseInt(jComboBox1.getSelectedItem().toString());
        int nam = Integer.parseInt(jComboBox2.getSelectedItem().toString());
        BLLNguoiDung.HienThiNguoiDungTheoChucVuChamCong(tblnhanvienchamcong, thang, nam);

        Date date = new Date();
        jdcNgayVaoLam.setDate(date);
        jdcNgaySinh.setDate(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        txtNgayPhat.setText(strDate);

        FillNhanVien();
        BLL.BLLNguoiDung.DoDuLieuVaoCBBLuong(cbbLuong);
        BLL.BLLNguoiDung.DoDuLieuVaoCBBLuong(cbbLuongPL);

        DAONguoiDung.CountNhanVien();
        if (countNV % 13 == 0) {
            soTrangNV = countNV / 13;

        } else if (soTrangNV <= trangNV1) {
            btnNext6.setEnabled(false);
            btnLast6.setEnabled(false);

        } else {
            soTrangNV = countNV / 13 + 1;

        }
        BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiemNV.getText(), 0);
        System.out.println(soTrangNV + "oke" + trangNV1);
        lblCountPage6.setText(trangNV1 + "/" + soTrangNV + "");
        lblNumberPage6.setText(trangNV1 + "");

        BLL.BLLPhatLuong.Hienthiphatluong(tblPhatluong);
    }

    public static boolean saveLogo(File file) {
        File dir = new File("logos");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static ImageIcon readLogo(String fileName) {
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ppmNhanVien = new javax.swing.JPopupMenu();
        mniXoaNhanVien = new javax.swing.JMenuItem();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable22 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        txtNgayPhat = new javax.swing.JTextField();
        txtTong = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblCheckPL = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        txtsongaytrongthang = new javax.swing.JTextField();
        tbpchuyentab = new javax.swing.JTabbedPane();
        pnldanhsach = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        btnFirstNV = new javax.swing.JButton();
        btnBack6 = new javax.swing.JButton();
        lblNumberPage6 = new javax.swing.JLabel();
        btnNext6 = new javax.swing.JButton();
        btnLast6 = new javax.swing.JButton();
        lblCountPage6 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        srcdanhsach = new javax.swing.JScrollPane();
        tblNguoiDung = new javax.swing.JTable();
        txtTimKiemNV = new javax.swing.JTextField();
        pnlChucVu = new javax.swing.JPanel();
        lblloaikhachhang = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jButton11 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnlthemsuakhachhang = new javax.swing.JPanel();
        pnlnenthemsuakhachhang1 = new javax.swing.JPanel();
        pnlnenngoaianhdaidienvathongtinkhac1 = new javax.swing.JPanel();
        pnlnenngoaianhdaidienvathongtinkhac = new javax.swing.JPanel();
        pnlnenngoaianhdaidien1 = new javax.swing.JPanel();
        pnlnenngoaianhdaidien = new javax.swing.JPanel();
        pnlnenanhdaidien = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlanhdaidien = new javax.swing.JPanel();
        lblAnhDaiDien = new javax.swing.JLabel();
        lblanhdaidien = new javax.swing.JLabel();
        pnlnenngoaithongtinkhac2 = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac1 = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac = new javax.swing.JPanel();
        pnlnenthongtinkhac = new javax.swing.JPanel();
        lblthongtinkhac = new javax.swing.JLabel();
        pnlnennhomkhachhang = new javax.swing.JPanel();
        lblnhomkhachhang = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        pnlnennhanvienphutrach = new javax.swing.JPanel();
        lblnhanvienphutrach = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        pnlnenmota = new javax.swing.JPanel();
        lblmota = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextPane();
        pnlnenlonthongtincoban = new javax.swing.JPanel();
        pnlnenlonngoaithongtin = new javax.swing.JPanel();
        pnlnenngoaithongtin = new javax.swing.JPanel();
        pnlnenthongtin = new javax.swing.JPanel();
        lblthongtincoban = new javax.swing.JLabel();
        pnlnenmatkhau = new javax.swing.JPanel();
        lblmatkhau = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        pnlemail = new javax.swing.JPanel();
        lblemail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        pnlnensodienthoai = new javax.swing.JPanel();
        lblsodienthoai = new javax.swing.JLabel();
        txtsodienthoai = new javax.swing.JTextField();
        pnlnenhotenkhachhang = new javax.swing.JPanel();
        lblhotenkhachhang = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        lblthongtinbosung = new javax.swing.JLabel();
        pnlnenid = new javax.swing.JPanel();
        lblid = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        pnlnenmangxahoi = new javax.swing.JPanel();
        lblmangxahoi = new javax.swing.JLabel();
        jdcNgayVaoLam = new com.toedter.calendar.JDateChooser();
        pnlnengioitinh = new javax.swing.JPanel();
        lblgioitinh = new javax.swing.JLabel();
        cbbGioiTinh = new javax.swing.JComboBox<>();
        pnlnenngaysinh = new javax.swing.JPanel();
        lblngaysinh = new javax.swing.JLabel();
        jdcNgaySinh = new com.toedter.calendar.JDateChooser();
        lblthongtindiachi = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jPanel40 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        cbbLuong = new javax.swing.JComboBox<>();
        pnlnentinh = new javax.swing.JPanel();
        lbltinh = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        pnlnendiachi = new javax.swing.JPanel();
        lbldiachihientai = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        pnlnenngoaibtn = new javax.swing.JPanel();
        pnlnenbtn = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnlammoi = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnlammoi1 = new javax.swing.JButton();
        FileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        pnlnenthemsuakhachhang2 = new javax.swing.JPanel();
        pnlnenlonthongtincoban1 = new javax.swing.JPanel();
        pnlnenlonngoaithongtin1 = new javax.swing.JPanel();
        pnlnenngoaithongtin1 = new javax.swing.JPanel();
        pnlnenthongtin1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhatluong = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        pnlemail2 = new javax.swing.JPanel();
        lblemail2 = new javax.swing.JLabel();
        cbbNhanVienPL = new javax.swing.JComboBox<>();
        pnlnensodienthoai2 = new javax.swing.JPanel();
        lblsodienthoai2 = new javax.swing.JLabel();
        txtTienThuong = new javax.swing.JTextField();
        pnlnenhotenkhachhang2 = new javax.swing.JPanel();
        lblhotenkhachhang2 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        cbbThang = new javax.swing.JComboBox<>();
        cbbNam = new javax.swing.JComboBox<>();
        pnlnenmatkhau3 = new javax.swing.JPanel();
        lblmatkhau3 = new javax.swing.JLabel();
        txtGhichuPL = new javax.swing.JTextField();
        pnlemail3 = new javax.swing.JPanel();
        lblemail3 = new javax.swing.JLabel();
        txtSocavang = new javax.swing.JTextField();
        pnlnensodienthoai3 = new javax.swing.JPanel();
        lblsodienthoai3 = new javax.swing.JLabel();
        cbbLuongPL = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        pnlnenhotenkhachhang3 = new javax.swing.JPanel();
        lblhotenkhachhang3 = new javax.swing.JLabel();
        txtSocadilam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        pnlemail4 = new javax.swing.JPanel();
        lblemail4 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        pnlnenmatkhau4 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        txtTongtienluong = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pnldanhsach11 = new javax.swing.JPanel();
        pnlthemsuakhachhang4 = new javax.swing.JPanel();
        pnlnenthemsuakhachhang5 = new javax.swing.JPanel();
        pnlnenngoaianhdaidienvathongtinkhac8 = new javax.swing.JPanel();
        pnlnenngoaianhdaidienvathongtinkhac9 = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac12 = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac13 = new javax.swing.JPanel();
        pnlnenngoaithongtinkhac14 = new javax.swing.JPanel();
        pnlnenthongtinkhac4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        txtIDnhanvien = new javax.swing.JTextField();
        jPanel60 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txtNgayhomnay = new javax.swing.JTextField();
        jPanel61 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        txtUudai1 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnlnenlonthongtincoban4 = new javax.swing.JPanel();
        pnlnenlonngoaithongtin4 = new javax.swing.JPanel();
        pnlnenngoaithongtin4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jdcNgaySinh1 = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblnhanvienchamcong = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbllichsuchamcong = new javax.swing.JTable();
        cbbNguoidung = new javax.swing.JComboBox<>();
        jPanel23 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblCountPage = new javax.swing.JLabel();
        lblNumberPage = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        FileChooser2 = new javax.swing.JFileChooser();

        mniXoaNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/delete_20px.png"))); // NOI18N
        mniXoaNhanVien.setText("Xóa nhân viên");
        mniXoaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXoaNhanVienActionPerformed(evt);
            }
        });
        ppmNhanVien.add(mniXoaNhanVien);

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane5.setViewportView(jTable11);

        jTable22.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane6.setViewportView(jTable22);

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        txtTong.setEditable(false);
        txtTong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongActionPerformed(evt);
            }
        });

        tblCheckPL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblCheckPL);

        jButton3.setText("Thêm chức vụ");

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 620));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        tbpchuyentab.setBackground(new java.awt.Color(255, 255, 255));
        tbpchuyentab.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        pnldanhsach.setBackground(new java.awt.Color(255, 255, 255));
        pnldanhsach.setForeground(new java.awt.Color(255, 255, 255));
        pnldanhsach.setPreferredSize(new java.awt.Dimension(980, 616));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnFirstNV.setText("First");
        btnFirstNV.setEnabled(false);
        btnFirstNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstNVActionPerformed(evt);
            }
        });

        btnBack6.setText("Back");
        btnBack6.setEnabled(false);
        btnBack6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack6ActionPerformed(evt);
            }
        });

        lblNumberPage6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumberPage6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumberPage6.setText("1");

        btnNext6.setText("Next");
        btnNext6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext6ActionPerformed(evt);
            }
        });

        btnLast6.setText("Last");
        btnLast6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLast6ActionPerformed(evt);
            }
        });

        lblCountPage6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCountPage6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCountPage6.setText("1/100");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(btnFirstNV, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumberPage6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCountPage6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblNumberPage6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNext6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLast6))
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnFirstNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack6)
                .addComponent(jLabel25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel24))
            .addComponent(lblCountPage6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tblNguoiDung.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblNguoiDung.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        tblNguoiDung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", null, "", null, null, null, null, null},
                {"", "", "", "", null, "", null, null, null, null, null},
                {"", "", "", "", null, "", null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên nhân viên", "Số Điện Thoại", "Email", "Giới Tính", "Ngày Sinh", "Ngày Vào Làm", "Hình Ảnh", "Chức Vụ", "Trạng Thái", "Lương"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNguoiDung.setDragEnabled(true);
        tblNguoiDung.setFocusable(false);
        tblNguoiDung.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tblNguoiDung.setName(""); // NOI18N
        tblNguoiDung.setRowHeight(40);
        tblNguoiDung.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tblNguoiDung.setShowVerticalLines(false);
        tblNguoiDung.getTableHeader().setReorderingAllowed(false);
        tblNguoiDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNguoiDungMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblNguoiDungMouseReleased(evt);
            }
        });
        srcdanhsach.setViewportView(tblNguoiDung);

        txtTimKiemNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimKiemNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemNVKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTimKiemNVKeyTyped(evt);
            }
        });

        pnlChucVu.setBackground(new java.awt.Color(255, 255, 255));
        pnlChucVu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblloaikhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblloaikhachhang.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblloaikhachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblloaikhachhang.setText("Chức vụ");
        lblloaikhachhang.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/delete_20px_1.png"))); // NOI18N
        jButton1.setText("Xóa N.Viên");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/maintenance_20px.png"))); // NOI18N
        jButton2.setText("Sửa N.Viên");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton11.setText("Lọc nhân viên");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton4.setText("Tìm kiếm");

        javax.swing.GroupLayout pnldanhsachLayout = new javax.swing.GroupLayout(pnldanhsach);
        pnldanhsach.setLayout(pnldanhsachLayout);
        pnldanhsachLayout.setHorizontalGroup(
            pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblloaikhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnldanhsachLayout.createSequentialGroup()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiemNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(srcdanhsach)))
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnldanhsachLayout.setVerticalGroup(
            pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldanhsachLayout.createSequentialGroup()
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblloaikhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiemNV))
                .addGap(9, 9, 9)
                .addGroup(pnldanhsachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnldanhsachLayout.createSequentialGroup()
                        .addComponent(pnlChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnldanhsachLayout.createSequentialGroup()
                        .addComponent(srcdanhsach, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        tbpchuyentab.addTab("Danh sách nhân viên", new javax.swing.ImageIcon(getClass().getResource("/IMAGE/list_20px.png")), pnldanhsach); // NOI18N

        pnlthemsuakhachhang.setPreferredSize(new java.awt.Dimension(980, 618));

        pnlnenthemsuakhachhang1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidienvathongtinkhac1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngoaianhdaidienvathongtinkhac1.setPreferredSize(new java.awt.Dimension(275, 550));
        pnlnenngoaianhdaidienvathongtinkhac1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidienvathongtinkhac.setPreferredSize(new java.awt.Dimension(275, 300));
        pnlnenngoaianhdaidienvathongtinkhac.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidien1.setBackground(new java.awt.Color(0, 51, 204));
        pnlnenngoaianhdaidien1.setPreferredSize(new java.awt.Dimension(200, 260));
        pnlnenngoaianhdaidien1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidien.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngoaianhdaidien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 246, 248), 5));
        pnlnenngoaianhdaidien.setPreferredSize(new java.awt.Dimension(275, 260));

        pnlnenanhdaidien.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenanhdaidien.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("                                                                ");
        jLabel1.setPreferredSize(new java.awt.Dimension(192, 1));
        pnlnenanhdaidien.add(jLabel1);

        pnlanhdaidien.setBackground(new java.awt.Color(255, 255, 255));
        pnlanhdaidien.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblAnhDaiDien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnhDaiDienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlanhdaidienLayout = new javax.swing.GroupLayout(pnlanhdaidien);
        pnlanhdaidien.setLayout(pnlanhdaidienLayout);
        pnlanhdaidienLayout.setHorizontalGroup(
            pnlanhdaidienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhDaiDien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlanhdaidienLayout.setVerticalGroup(
            pnlanhdaidienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAnhDaiDien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlnenanhdaidien.add(pnlanhdaidien);

        lblanhdaidien.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblanhdaidien.setText("Ảnh đại diện");
        pnlnenanhdaidien.add(lblanhdaidien);

        javax.swing.GroupLayout pnlnenngoaianhdaidienLayout = new javax.swing.GroupLayout(pnlnenngoaianhdaidien);
        pnlnenngoaianhdaidien.setLayout(pnlnenngoaianhdaidienLayout);
        pnlnenngoaianhdaidienLayout.setHorizontalGroup(
            pnlnenngoaianhdaidienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenngoaianhdaidienLayout.createSequentialGroup()
                .addComponent(pnlnenanhdaidien, javax.swing.GroupLayout.PREFERRED_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlnenngoaianhdaidienLayout.setVerticalGroup(
            pnlnenngoaianhdaidienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenanhdaidien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlnenngoaianhdaidien1.add(pnlnenngoaianhdaidien, java.awt.BorderLayout.PAGE_START);

        pnlnenngoaianhdaidienvathongtinkhac.add(pnlnenngoaianhdaidien1, java.awt.BorderLayout.PAGE_START);

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
        lblthongtinkhac.setText("Thông tin khác");
        lblthongtinkhac.setPreferredSize(new java.awt.Dimension(34, 20));

        pnlnennhomkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhomkhachhang.setLayout(new java.awt.BorderLayout());

        lblnhomkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblnhomkhachhang.setText("Chức vụ");
        lblnhomkhachhang.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhomkhachhang.add(lblnhomkhachhang, java.awt.BorderLayout.PAGE_START);

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Trị", "Nhân Viên" }));
        cbbChucVu.setToolTipText("");
        pnlnennhomkhachhang.add(cbbChucVu, java.awt.BorderLayout.CENTER);

        pnlnennhanvienphutrach.setBackground(new java.awt.Color(255, 255, 255));
        pnlnennhanvienphutrach.setLayout(new java.awt.BorderLayout());

        lblnhanvienphutrach.setBackground(new java.awt.Color(255, 255, 255));
        lblnhanvienphutrach.setText("ID");
        lblnhanvienphutrach.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnennhanvienphutrach.add(lblnhanvienphutrach, java.awt.BorderLayout.PAGE_START);

        txtId.setEnabled(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        pnlnennhanvienphutrach.add(txtId, java.awt.BorderLayout.CENTER);

        pnlnenmota.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenmota.setLayout(new java.awt.BorderLayout());

        lblmota.setBackground(new java.awt.Color(255, 255, 255));
        lblmota.setText("Mô tả");
        lblmota.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnenmota.add(lblmota, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportView(txtMoTa);

        pnlnenmota.add(jScrollPane1, java.awt.BorderLayout.CENTER);

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
                            .addComponent(pnlnenmota, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlnenmota, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
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
        lblthongtincoban.setText("Thông tin cơ bản");

        pnlnenmatkhau.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenmatkhau.setLayout(new java.awt.BorderLayout());

        lblmatkhau.setBackground(new java.awt.Color(255, 255, 255));
        lblmatkhau.setText("Mật khẩu");
        lblmatkhau.setPreferredSize(new java.awt.Dimension(52, 20));
        pnlnenmatkhau.add(lblmatkhau, java.awt.BorderLayout.PAGE_START);
        pnlnenmatkhau.add(txtMatKhau, java.awt.BorderLayout.CENTER);

        pnlemail.setBackground(new java.awt.Color(255, 255, 255));
        pnlemail.setLayout(new java.awt.BorderLayout());

        lblemail.setBackground(new java.awt.Color(255, 255, 255));
        lblemail.setText("Email");
        lblemail.setPreferredSize(new java.awt.Dimension(31, 20));
        pnlemail.add(lblemail, java.awt.BorderLayout.PAGE_START);
        pnlemail.add(txtEmail, java.awt.BorderLayout.CENTER);

        pnlnensodienthoai.setBackground(new java.awt.Color(255, 255, 255));
        pnlnensodienthoai.setLayout(new java.awt.BorderLayout());

        lblsodienthoai.setBackground(new java.awt.Color(255, 255, 255));
        lblsodienthoai.setText("Số điện thoại");
        lblsodienthoai.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnensodienthoai.add(lblsodienthoai, java.awt.BorderLayout.PAGE_START);
        pnlnensodienthoai.add(txtsodienthoai, java.awt.BorderLayout.CENTER);

        pnlnenhotenkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenhotenkhachhang.setLayout(new java.awt.BorderLayout());

        lblhotenkhachhang.setBackground(new java.awt.Color(255, 255, 255));
        lblhotenkhachhang.setText("Họ tên nhân viên");
        lblhotenkhachhang.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnenhotenkhachhang.add(lblhotenkhachhang, java.awt.BorderLayout.PAGE_START);

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });
        pnlnenhotenkhachhang.add(txtHoTen, java.awt.BorderLayout.CENTER);

        lblthongtinbosung.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblthongtinbosung.setText("Thông tin bổ sung");

        pnlnenid.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenid.setLayout(new java.awt.BorderLayout());

        lblid.setBackground(new java.awt.Color(255, 255, 255));
        lblid.setText("Chứng Minh Nhân Dân");
        lblid.setPreferredSize(new java.awt.Dimension(52, 20));
        pnlnenid.add(lblid, java.awt.BorderLayout.PAGE_START);
        pnlnenid.add(txtCMND, java.awt.BorderLayout.CENTER);

        pnlnenmangxahoi.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenmangxahoi.setLayout(new java.awt.BorderLayout());

        lblmangxahoi.setBackground(new java.awt.Color(255, 255, 255));
        lblmangxahoi.setText("Ngày Vào Làm");
        lblmangxahoi.setPreferredSize(new java.awt.Dimension(31, 20));
        pnlnenmangxahoi.add(lblmangxahoi, java.awt.BorderLayout.PAGE_START);

        jdcNgayVaoLam.setDateFormatString("dd/MM/yyyy"); // NOI18N
        pnlnenmangxahoi.add(jdcNgayVaoLam, java.awt.BorderLayout.CENTER);

        pnlnengioitinh.setBackground(new java.awt.Color(255, 255, 255));
        pnlnengioitinh.setLayout(new java.awt.BorderLayout());

        lblgioitinh.setBackground(new java.awt.Color(255, 255, 255));
        lblgioitinh.setText("Giới tính");
        lblgioitinh.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnengioitinh.add(lblgioitinh, java.awt.BorderLayout.PAGE_START);

        cbbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        pnlnengioitinh.add(cbbGioiTinh, java.awt.BorderLayout.CENTER);

        pnlnenngaysinh.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngaysinh.setLayout(new java.awt.BorderLayout());

        lblngaysinh.setBackground(new java.awt.Color(255, 255, 255));
        lblngaysinh.setText("Ngày sinh");
        lblngaysinh.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnenngaysinh.add(lblngaysinh, java.awt.BorderLayout.PAGE_START);

        jdcNgaySinh.setDateFormatString("dd/MM/yyyy"); // NOI18N
        pnlnenngaysinh.add(jdcNgaySinh, java.awt.BorderLayout.CENTER);

        lblthongtindiachi.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblthongtindiachi.setText("Thông tin địa chỉ");

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new java.awt.BorderLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Trạng thái");
        jLabel17.setPreferredSize(new java.awt.Dimension(52, 20));
        jPanel39.add(jLabel17, java.awt.BorderLayout.PAGE_START);

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm việc", "Đã nghỉ làm" }));
        jPanel39.add(cbbTrangThai, java.awt.BorderLayout.CENTER);

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new java.awt.BorderLayout());

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Mức Lương");
        jLabel18.setPreferredSize(new java.awt.Dimension(31, 20));
        jPanel40.add(jLabel18, java.awt.BorderLayout.PAGE_START);

        jPanel40.add(cbbLuong, java.awt.BorderLayout.CENTER);

        pnlnentinh.setBackground(new java.awt.Color(255, 255, 255));
        pnlnentinh.setLayout(new java.awt.BorderLayout());

        lbltinh.setBackground(new java.awt.Color(255, 255, 255));
        lbltinh.setText("Tên Đăng Nhập");
        lbltinh.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnentinh.add(lbltinh, java.awt.BorderLayout.PAGE_START);
        pnlnentinh.add(txtTenDangNhap, java.awt.BorderLayout.CENTER);

        pnlnendiachi.setBackground(new java.awt.Color(255, 255, 255));
        pnlnendiachi.setLayout(new java.awt.BorderLayout());

        lbldiachihientai.setBackground(new java.awt.Color(255, 255, 255));
        lbldiachihientai.setText("Địa chỉ hiện tại (Xã, Phường - Quận, Huyện) ");
        lbldiachihientai.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnendiachi.add(lbldiachihientai, java.awt.BorderLayout.PAGE_START);
        pnlnendiachi.add(txtDiaChi, java.awt.BorderLayout.CENTER);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout pnlnenthongtinLayout = new javax.swing.GroupLayout(pnlnenthongtin);
        pnlnenthongtin.setLayout(pnlnenthongtinLayout);
        pnlnenthongtinLayout.setHorizontalGroup(
            pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnenthongtinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(pnlemail, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlnenmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(pnlnenhotenkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlnensodienthoai, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addComponent(lblthongtincoban, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(pnlnenmangxahoi, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlnenid, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(pnlnenngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlnengioitinh, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addComponent(lblthongtinbosung, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                        .addComponent(pnlnendiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlnentinh, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                    .addComponent(lblthongtindiachi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlnenthongtinLayout.setVerticalGroup(
            pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblthongtincoban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnensodienthoai, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(pnlnenhotenkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnenmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(pnlemail, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblthongtinbosung, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnengioitinh, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(pnlnenngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnenid, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(pnlnenmangxahoi, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblthongtindiachi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnentinh, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(pnlnendiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlnenngoaithongtin.add(pnlnenthongtin, java.awt.BorderLayout.CENTER);

        pnlnenlonngoaithongtin.add(pnlnenngoaithongtin, java.awt.BorderLayout.CENTER);

        pnlnenlonthongtincoban.add(pnlnenlonngoaithongtin, java.awt.BorderLayout.CENTER);

        pnlnenthemsuakhachhang1.add(pnlnenlonthongtincoban, java.awt.BorderLayout.CENTER);

        pnlnenngoaibtn.setPreferredSize(new java.awt.Dimension(975, 40));

        pnlnenbtn.setBackground(new java.awt.Color(244, 246, 248));

        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/checkmark_20px.png"))); // NOI18N
        btnthem.setText("Thêm");
        btnthem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/maintenance_20px.png"))); // NOI18N
        btnsua.setText("Sửa");
        btnsua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnlammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/available_updates_20px.png"))); // NOI18N
        btnlammoi.setText("Làm mới");
        btnlammoi.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        btnlammoi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/available_updates_20px.png"))); // NOI18N
        btnlammoi1.setText("Ngừng hoạt động");
        btnlammoi1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnlammoi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoi1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlnenbtnLayout = new javax.swing.GroupLayout(pnlnenbtn);
        pnlnenbtn.setLayout(pnlnenbtnLayout);
        pnlnenbtnLayout.setHorizontalGroup(
            pnlnenbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenbtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnlammoi1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 442, Short.MAX_VALUE)
                .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        pnlnenbtnLayout.setVerticalGroup(
            pnlnenbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenbtnLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(pnlnenbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlammoi1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(pnlnenthemsuakhachhang1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(pnlthemsuakhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlthemsuakhachhangLayout.createSequentialGroup()
                    .addGap(293, 293, 293)
                    .addComponent(FileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(307, Short.MAX_VALUE)))
        );

        tbpchuyentab.addTab("Thêm - Sửa nhân viên", new javax.swing.ImageIcon(getClass().getResource("/IMAGE/maintenancde_20px.png")), pnlthemsuakhachhang); // NOI18N

        pnlnenthemsuakhachhang2.setLayout(new java.awt.BorderLayout());

        pnlnenlonthongtincoban1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenlonthongtincoban1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 246, 248), 5));
        pnlnenlonthongtincoban1.setPreferredSize(new java.awt.Dimension(700, 550));
        pnlnenlonthongtincoban1.setLayout(new java.awt.BorderLayout());

        pnlnenlonngoaithongtin1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenlonngoaithongtin1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlnenlonngoaithongtin1.setLayout(new java.awt.BorderLayout());

        pnlnenngoaithongtin1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        pnlnenngoaithongtin1.setLayout(new java.awt.BorderLayout());

        pnlnenthongtin1.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenthongtin1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblPhatluong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên nhân viên", "Lương tháng", "Mức lương", "Ngày phát", "Số ca đi làm", "Số ca nghỉ", "Tiền thưởng", "Tiền phạt", "Tổng Lương", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPhatluong.setRowHeight(30);
        tblPhatluong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhatluongMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPhatluong);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel5");

        pnlemail2.setBackground(new java.awt.Color(255, 255, 255));
        pnlemail2.setLayout(new java.awt.BorderLayout());

        lblemail2.setBackground(new java.awt.Color(255, 255, 255));
        lblemail2.setText("Nhân viên chưa phát lương");
        lblemail2.setPreferredSize(new java.awt.Dimension(31, 20));
        pnlemail2.add(lblemail2, java.awt.BorderLayout.PAGE_START);

        cbbNhanVienPL.setToolTipText("");
        cbbNhanVienPL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNhanVienPLItemStateChanged(evt);
            }
        });
        pnlemail2.add(cbbNhanVienPL, java.awt.BorderLayout.CENTER);

        pnlnensodienthoai2.setBackground(new java.awt.Color(255, 255, 255));
        pnlnensodienthoai2.setLayout(new java.awt.BorderLayout());

        lblsodienthoai2.setBackground(new java.awt.Color(255, 255, 255));
        lblsodienthoai2.setText("Tiền thưởng");
        lblsodienthoai2.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnensodienthoai2.add(lblsodienthoai2, java.awt.BorderLayout.PAGE_START);

        txtTienThuong.setText("0");
        txtTienThuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienThuongKeyReleased(evt);
            }
        });
        pnlnensodienthoai2.add(txtTienThuong, java.awt.BorderLayout.CENTER);

        pnlnenhotenkhachhang2.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenhotenkhachhang2.setLayout(new java.awt.BorderLayout());

        lblhotenkhachhang2.setBackground(new java.awt.Color(255, 255, 255));
        lblhotenkhachhang2.setText("Chọn tháng trả lương");
        lblhotenkhachhang2.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnenhotenkhachhang2.add(lblhotenkhachhang2, java.awt.BorderLayout.PAGE_START);

        jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.LINE_AXIS));

        cbbThang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbThang.setForeground(new java.awt.Color(255, 0, 0));
        cbbThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThangItemStateChanged(evt);
            }
        });
        jPanel22.add(cbbThang);

        cbbNam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbNam.setForeground(new java.awt.Color(255, 0, 0));
        cbbNam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNamItemStateChanged(evt);
            }
        });
        jPanel22.add(cbbNam);

        pnlnenhotenkhachhang2.add(jPanel22, java.awt.BorderLayout.CENTER);

        pnlnenmatkhau3.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenmatkhau3.setLayout(new java.awt.BorderLayout());

        lblmatkhau3.setBackground(new java.awt.Color(255, 255, 255));
        lblmatkhau3.setText("Ghi chú");
        lblmatkhau3.setPreferredSize(new java.awt.Dimension(52, 20));
        pnlnenmatkhau3.add(lblmatkhau3, java.awt.BorderLayout.PAGE_START);
        pnlnenmatkhau3.add(txtGhichuPL, java.awt.BorderLayout.CENTER);

        pnlemail3.setBackground(new java.awt.Color(255, 255, 255));
        pnlemail3.setLayout(new java.awt.BorderLayout());

        lblemail3.setBackground(new java.awt.Color(255, 255, 255));
        lblemail3.setText("Số ca vắng");
        lblemail3.setPreferredSize(new java.awt.Dimension(31, 20));
        pnlemail3.add(lblemail3, java.awt.BorderLayout.PAGE_START);

        txtSocavang.setEditable(false);
        txtSocavang.setText("1");
        txtSocavang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSocavangMouseClicked(evt);
            }
        });
        txtSocavang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSocavangKeyReleased(evt);
            }
        });
        pnlemail3.add(txtSocavang, java.awt.BorderLayout.CENTER);

        pnlnensodienthoai3.setBackground(new java.awt.Color(255, 255, 255));
        pnlnensodienthoai3.setLayout(new java.awt.BorderLayout());

        lblsodienthoai3.setBackground(new java.awt.Color(255, 255, 255));
        lblsodienthoai3.setText("Mức lương");
        lblsodienthoai3.setPreferredSize(new java.awt.Dimension(75, 20));
        pnlnensodienthoai3.add(lblsodienthoai3, java.awt.BorderLayout.PAGE_START);

        cbbLuongPL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLuongPLItemStateChanged(evt);
            }
        });
        pnlnensodienthoai3.add(cbbLuongPL, java.awt.BorderLayout.CENTER);

        jButton7.setText("Thêm tiền lương");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        pnlnensodienthoai3.add(jButton7, java.awt.BorderLayout.LINE_END);

        pnlnenhotenkhachhang3.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenhotenkhachhang3.setLayout(new java.awt.BorderLayout());

        lblhotenkhachhang3.setBackground(new java.awt.Color(255, 255, 255));
        lblhotenkhachhang3.setText("Số ca đi làm");
        lblhotenkhachhang3.setPreferredSize(new java.awt.Dimension(106, 20));
        pnlnenhotenkhachhang3.add(lblhotenkhachhang3, java.awt.BorderLayout.PAGE_START);

        txtSocadilam.setEditable(false);
        txtSocadilam.setText("92");
        txtSocadilam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtSocadilamMouseReleased(evt);
            }
        });
        txtSocadilam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSocadilamActionPerformed(evt);
            }
        });
        pnlnenhotenkhachhang3.add(txtSocadilam, java.awt.BorderLayout.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText(" Số tiền 1 ca: 150,000đ/ Ca/ 4h ");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlnenhotenkhachhang3.add(jLabel2, java.awt.BorderLayout.LINE_END);

        pnlemail4.setBackground(new java.awt.Color(255, 255, 255));
        pnlemail4.setLayout(new java.awt.BorderLayout());

        lblemail4.setBackground(new java.awt.Color(255, 255, 255));
        lblemail4.setText("Lọc phát lương theo tháng");
        lblemail4.setPreferredSize(new java.awt.Dimension(31, 20));
        pnlemail4.add(lblemail4, java.awt.BorderLayout.PAGE_START);

        jPanel21.setLayout(new javax.swing.BoxLayout(jPanel21, javax.swing.BoxLayout.LINE_AXIS));

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 0, 0));
        jPanel21.add(jComboBox3);

        jComboBox4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(255, 0, 0));
        jPanel21.add(jComboBox4);

        pnlemail4.add(jPanel21, java.awt.BorderLayout.CENTER);

        pnlnenmatkhau4.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenmatkhau4.setLayout(new java.awt.BorderLayout());

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 0, 0));
        jButton8.setText(" Phát lương ");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        pnlnenmatkhau4.add(jButton8, java.awt.BorderLayout.LINE_END);

        txtTongtienluong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTongtienluong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pnlnenmatkhau4.add(txtTongtienluong, java.awt.BorderLayout.CENTER);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Tổng tiền lương nhận");
        jLabel15.setPreferredSize(new java.awt.Dimension(40, 20));
        pnlnenmatkhau4.add(jLabel15, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout pnlnenthongtin1Layout = new javax.swing.GroupLayout(pnlnenthongtin1);
        pnlnenthongtin1.setLayout(pnlnenthongtin1Layout);
        pnlnenthongtin1Layout.setHorizontalGroup(
            pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnenthongtin1Layout.createSequentialGroup()
                        .addComponent(pnlnenhotenkhachhang2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlnensodienthoai2, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
                    .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                        .addComponent(pnlemail3, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(pnlnenmatkhau4, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator6)
                    .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                        .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlemail2, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                            .addComponent(pnlnenhotenkhachhang3, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlnenmatkhau3, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                            .addComponent(pnlnensodienthoai3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)))
                    .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(286, 286, 286)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlemail4, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnenthongtin1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlnenthongtin1Layout.setVerticalGroup(
            pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnensodienthoai2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlnenhotenkhachhang2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                        .addComponent(pnlemail2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlnenhotenkhachhang3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlnenthongtin1Layout.createSequentialGroup()
                        .addComponent(pnlnensodienthoai3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlnenmatkhau3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlemail3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlnenmatkhau4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlemail4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addContainerGap())
            .addGroup(pnlnenthongtin1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnenthongtin1Layout.createSequentialGroup()
                    .addGap(356, 356, 356)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnlnenngoaithongtin1.add(pnlnenthongtin1, java.awt.BorderLayout.CENTER);

        pnlnenlonngoaithongtin1.add(pnlnenngoaithongtin1, java.awt.BorderLayout.CENTER);

        pnlnenlonthongtincoban1.add(pnlnenlonngoaithongtin1, java.awt.BorderLayout.CENTER);

        pnlnenthemsuakhachhang2.add(pnlnenlonthongtincoban1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlnenthemsuakhachhang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlnenthemsuakhachhang2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        );

        tbpchuyentab.addTab("Lương nhân viên", new javax.swing.ImageIcon(getClass().getResource("/IMAGE/get_cash_20px.png")), jPanel1); // NOI18N

        pnldanhsach11.setBackground(new java.awt.Color(33, 36, 51));
        pnldanhsach11.setPreferredSize(new java.awt.Dimension(980, 618));

        pnlnenthemsuakhachhang5.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidienvathongtinkhac8.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngoaianhdaidienvathongtinkhac8.setPreferredSize(new java.awt.Dimension(275, 550));
        pnlnenngoaianhdaidienvathongtinkhac8.setLayout(new java.awt.BorderLayout());

        pnlnenngoaianhdaidienvathongtinkhac9.setPreferredSize(new java.awt.Dimension(275, 300));
        pnlnenngoaianhdaidienvathongtinkhac9.setLayout(new java.awt.BorderLayout());

        pnlnenngoaithongtinkhac12.setBackground(new java.awt.Color(255, 255, 0));
        pnlnenngoaithongtinkhac12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(244, 246, 248), 5, true));
        pnlnenngoaithongtinkhac12.setPreferredSize(new java.awt.Dimension(275, 310));

        pnlnenngoaithongtinkhac13.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngoaithongtinkhac13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlnenngoaithongtinkhac13.setLayout(new java.awt.BorderLayout());

        pnlnenngoaithongtinkhac14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        pnlnenthongtinkhac4.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenthongtinkhac4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlnenthongtinkhac4.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Thông tin chấm công hôm nay", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel12.setPreferredSize(new java.awt.Dimension(237, 285));

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));
        jPanel59.setLayout(new java.awt.BorderLayout());

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Nhân viên điểm danh");
        jLabel37.setPreferredSize(new java.awt.Dimension(106, 20));
        jPanel59.add(jLabel37, java.awt.BorderLayout.PAGE_START);

        txtIDnhanvien.setEditable(false);
        txtIDnhanvien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel59.add(txtIDnhanvien, java.awt.BorderLayout.CENTER);

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));
        jPanel60.setLayout(new java.awt.BorderLayout());

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Hôm nay ngày");
        jLabel38.setPreferredSize(new java.awt.Dimension(106, 20));
        jPanel60.add(jLabel38, java.awt.BorderLayout.PAGE_START);

        txtNgayhomnay.setEditable(false);
        txtNgayhomnay.setBackground(new java.awt.Color(255, 255, 255));
        txtNgayhomnay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNgayhomnay.setText("28/11/2020");
        jPanel60.add(txtNgayhomnay, java.awt.BorderLayout.CENTER);

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));
        jPanel61.setLayout(new java.awt.BorderLayout());

        jLabel39.setBackground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Ca làm hiện tại");
        jLabel39.setPreferredSize(new java.awt.Dimension(106, 20));
        jPanel61.add(jLabel39, java.awt.BorderLayout.PAGE_START);

        txtUudai1.setEditable(false);
        txtUudai1.setBackground(new java.awt.Color(255, 255, 255));
        txtUudai1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUudai1.setForeground(new java.awt.Color(255, 0, 0));
        txtUudai1.setText("Ca Sáng - ( 7h15 - 11h30 )");
        jPanel61.add(txtUudai1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jPanel60, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel11.add(jPanel12, java.awt.BorderLayout.PAGE_END);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(247, 250));
        jPanel13.setLayout(new java.awt.BorderLayout());

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Quét mã QR điểm danh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel14.setPreferredSize(new java.awt.Dimension(237, 240));

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));
        jPanel63.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel63.add(jPanel7, java.awt.BorderLayout.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText(" QR Scanner Camera");
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel63.add(jLabel7, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel13.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel11.add(jPanel13, java.awt.BorderLayout.CENTER);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Lưu ý: trễ 15 phút khóa điểm danh");
        jLabel10.setPreferredSize(new java.awt.Dimension(245, 25));
        jPanel11.add(jLabel10, java.awt.BorderLayout.PAGE_START);

        pnlnenthongtinkhac4.add(jPanel11, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlnenngoaithongtinkhac14Layout = new javax.swing.GroupLayout(pnlnenngoaithongtinkhac14);
        pnlnenngoaithongtinkhac14.setLayout(pnlnenngoaithongtinkhac14Layout);
        pnlnenngoaithongtinkhac14Layout.setHorizontalGroup(
            pnlnenngoaithongtinkhac14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthongtinkhac4, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );
        pnlnenngoaithongtinkhac14Layout.setVerticalGroup(
            pnlnenngoaithongtinkhac14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthongtinkhac4, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
        );

        pnlnenngoaithongtinkhac13.add(pnlnenngoaithongtinkhac14, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlnenngoaithongtinkhac12Layout = new javax.swing.GroupLayout(pnlnenngoaithongtinkhac12);
        pnlnenngoaithongtinkhac12.setLayout(pnlnenngoaithongtinkhac12Layout);
        pnlnenngoaithongtinkhac12Layout.setHorizontalGroup(
            pnlnenngoaithongtinkhac12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenngoaithongtinkhac13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlnenngoaithongtinkhac12Layout.setVerticalGroup(
            pnlnenngoaithongtinkhac12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenngoaithongtinkhac13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlnenngoaianhdaidienvathongtinkhac9.add(pnlnenngoaithongtinkhac12, java.awt.BorderLayout.CENTER);

        pnlnenngoaianhdaidienvathongtinkhac8.add(pnlnenngoaianhdaidienvathongtinkhac9, java.awt.BorderLayout.CENTER);

        pnlnenthemsuakhachhang5.add(pnlnenngoaianhdaidienvathongtinkhac8, java.awt.BorderLayout.EAST);

        pnlnenlonthongtincoban4.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenlonthongtincoban4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(244, 246, 248), 5));
        pnlnenlonthongtincoban4.setPreferredSize(new java.awt.Dimension(700, 550));
        pnlnenlonthongtincoban4.setLayout(new java.awt.BorderLayout());

        pnlnenlonngoaithongtin4.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenlonngoaithongtin4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlnenlonngoaithongtin4.setLayout(new java.awt.BorderLayout());

        pnlnenngoaithongtin4.setBackground(new java.awt.Color(255, 255, 255));
        pnlnenngoaithongtin4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        pnlnenngoaithongtin4.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(672, 280));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText(" Thông tin chấm công nhân viên: Hiện tại ( Tháng 11/2020) - 30 Ngày");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel8.setPreferredSize(new java.awt.Dimension(87, 25));
        jPanel6.add(jLabel8, java.awt.BorderLayout.PAGE_START);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(677, 25));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.LINE_AXIS));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Tháng Năm");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 0, 0));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 0, 0));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, 0, 112, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel15.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Lọc theo ngày:");

        jdcNgaySinh1.setForeground(new java.awt.Color(255, 0, 0));
        jdcNgaySinh1.setDateFormatString("dd/MM/yyyy");
        jdcNgaySinh1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Lọc ngày");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdcNgaySinh1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addGap(0, 0, 0))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcNgaySinh1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel15.add(jPanel17);

        jPanel8.add(jPanel15, java.awt.BorderLayout.PAGE_START);

        tblnhanvienchamcong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblnhanvienchamcong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "ID Nhân viên", "Tên nhân viên", "Tổng ngày", "Tổng số ca", "Số ca đi làm", "Số ca vắng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblnhanvienchamcong.setRowHeight(25);
        jScrollPane4.setViewportView(tblnhanvienchamcong);

        jPanel8.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));

        tbllichsuchamcong.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbllichsuchamcong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tbllichsuchamcong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "ID Chấm công", "Tên nhân viên", "Ngày làm", "Ca chấm công"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbllichsuchamcong.setRowHeight(25);
        jScrollPane2.setViewportView(tbllichsuchamcong);

        jPanel19.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        cbbNguoidung.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbNguoidung.setForeground(new java.awt.Color(255, 0, 0));
        cbbNguoidung.setPreferredSize(new java.awt.Dimension(56, 25));
        cbbNguoidung.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNguoidungItemStateChanged(evt);
            }
        });
        cbbNguoidung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbbNguoidungMouseReleased(evt);
            }
        });
        cbbNguoidung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNguoidungActionPerformed(evt);
            }
        });
        jPanel19.add(cbbNguoidung, java.awt.BorderLayout.PAGE_START);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        lblCountPage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCountPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCountPage.setText("1/100");

        lblNumberPage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNumberPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNumberPage.setText("1");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblNumberPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                        .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblCountPage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumberPage, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCountPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jPanel19.add(jPanel23, java.awt.BorderLayout.LINE_END);

        jPanel5.add(jPanel19, java.awt.BorderLayout.CENTER);

        pnlnenngoaithongtin4.add(jPanel5, java.awt.BorderLayout.CENTER);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Chọn nhân viên:");
        jLabel12.setPreferredSize(new java.awt.Dimension(113, 20));
        pnlnenngoaithongtin4.add(jLabel12, java.awt.BorderLayout.PAGE_START);

        pnlnenlonngoaithongtin4.add(pnlnenngoaithongtin4, java.awt.BorderLayout.CENTER);

        pnlnenlonthongtincoban4.add(pnlnenlonngoaithongtin4, java.awt.BorderLayout.CENTER);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(690, 50));
        jPanel20.setLayout(new java.awt.BorderLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText(" Xem lịch sử chấm công nhân viên");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel13.setPreferredSize(new java.awt.Dimension(34, 25));
        jPanel20.add(jLabel13, java.awt.BorderLayout.PAGE_END);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText(" Thông tin ca: (Ca sáng: 7h15 - 11h30) - (Ca chiều: 13h00 - 17h00)- (Ca tối: 17h00 - 21h00)");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.add(jLabel14, java.awt.BorderLayout.CENTER);

        pnlnenlonthongtincoban4.add(jPanel20, java.awt.BorderLayout.PAGE_START);

        pnlnenthemsuakhachhang5.add(pnlnenlonthongtincoban4, java.awt.BorderLayout.CENTER);

        FileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileChooser2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlthemsuakhachhang4Layout = new javax.swing.GroupLayout(pnlthemsuakhachhang4);
        pnlthemsuakhachhang4.setLayout(pnlthemsuakhachhang4Layout);
        pnlthemsuakhachhang4Layout.setHorizontalGroup(
            pnlthemsuakhachhang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthemsuakhachhang5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlthemsuakhachhang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlthemsuakhachhang4Layout.createSequentialGroup()
                    .addGap(487, 487, 487)
                    .addComponent(FileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(488, Short.MAX_VALUE)))
        );
        pnlthemsuakhachhang4Layout.setVerticalGroup(
            pnlthemsuakhachhang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnenthemsuakhachhang5, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
            .addGroup(pnlthemsuakhachhang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlthemsuakhachhang4Layout.createSequentialGroup()
                    .addGap(293, 293, 293)
                    .addComponent(FileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(294, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnldanhsach11Layout = new javax.swing.GroupLayout(pnldanhsach11);
        pnldanhsach11.setLayout(pnldanhsach11Layout);
        pnldanhsach11Layout.setHorizontalGroup(
            pnldanhsach11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(pnldanhsach11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnldanhsach11Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnlthemsuakhachhang4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        pnldanhsach11Layout.setVerticalGroup(
            pnldanhsach11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnldanhsach11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnldanhsach11Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnlthemsuakhachhang4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnldanhsach11, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnldanhsach11, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 975, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tbpchuyentab.addTab("Chấm công", new javax.swing.ImageIcon(getClass().getResource("/IMAGE/add_20px_1_1.png")), jPanel2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpchuyentab, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbpchuyentab, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSocadilamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSocadilamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSocadilamActionPerformed

    private void FileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileChooserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileChooserActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        MyCombobox Luong = (MyCombobox) cbbLuong.getSelectedItem();
        String TenNguoiDung = txtHoTen.getText();
        String SoDienThoai = txtsodienthoai.getText();
        String Email = txtEmail.getText();
        int GioiTinh;
        if (cbbGioiTinh.getSelectedItem().toString().equals("Nam")) {
            GioiTinh = 1;
        } else {
            GioiTinh = 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String NgaySinh = sdf.format(jdcNgaySinh.getDate());

        String NgayVaoLam = sdf.format(jdcNgayVaoLam.getDate());
        String DiaChi = txtDiaChi.getText();
        String CMND = txtCMND.getText();
        String MatKhau = txtMatKhau.getText();
        String TenDangNhap = txtTenDangNhap.getText();
        if (lblAnhDaiDien.getIcon() == null) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn hình ảnh khách hàng", "Thông báo");
            return;
        }
        String AnhDaiDien = FILE.getName();
        int TrangThai;
        if (cbbTrangThai.getSelectedItem().toString().equals("Đang làm việc")) {
            TrangThai = 1;
        } else {
            TrangThai = 0;
        }
        int ChucVu;
        if (cbbChucVu.getSelectedItem().toString().equals("Quản trị")) {
            ChucVu = 0;
        } else {
            ChucVu = 1;
        }
        String MoTa = txtMoTa.getText();
        if (BLL.BLLNguoiDung.KiemTraThemNguoiDung(TenNguoiDung, SoDienThoai, Email, NgaySinh, NgayVaoLam, DiaChi, CMND, TenDangNhap, MatKhau, MoTa)) {
            DTONguoidung nd = new DTONguoidung(Integer.parseInt(Luong.Value.toString()), TenNguoiDung, SoDienThoai, Email, GioiTinh, NgaySinh, NgayVaoLam, DiaChi, CMND, TenDangNhap, MatKhau, AnhDaiDien, ChucVu, TrangThai, MoTa);
            BLL.BLLNguoiDung.ThemNguoiDung(nd);
            ThongBaoCanhBao.ThongBao("Thêm nhân viên thành công", "Thông báo");
            BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiemNV.getText(), 0);
            LamMoiNhanVien();

        }


    }//GEN-LAST:event_btnthemActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed
    public static File FILE;

    private void lblAnhDaiDienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnhDaiDienMouseClicked
        if (FileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            FILE = FileChooser.getSelectedFile();
            if (!FILE.getName().matches(".+(\\.png|\\.jpg|\\.gif)$")) {
                ThongBaoCanhBao.ThongBao("Không phải hình ảnh", "Thông Báo");
                return;
            }
            if (saveLogo(FILE)) {
                lblAnhDaiDien.setIcon(readLogo(FILE.getName()));
                lblAnhDaiDien.setToolTipText(FILE.getName());
            }
        }
    }//GEN-LAST:event_lblAnhDaiDienMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int kq = JOptionPane.showConfirmDialog(new JFrame(), "Bạn có chắc chắn muốn xóa nhân viên này không?",
                "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {

            int cacDong[] = tblNguoiDung.getSelectedRows();
            for (int i = 0; i < cacDong.length; i++) {
                int maND = Integer.parseInt(tblNguoiDung.getValueAt(cacDong[i], 0).toString());
                DAO.DAONguoiDung.XoaNhanVien(maND);
            }
        }
        BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiem.getText(), 0);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTimKiemNVKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNVKeyTyped

    }//GEN-LAST:event_txtTimKiemNVKeyTyped

    private void txtTimKiemNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemNVKeyPressed

    }//GEN-LAST:event_txtTimKiemNVKeyPressed

    private void tblNguoiDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNguoiDungMouseClicked
        int Dongduocchon = tblNguoiDung.getSelectedRow();
        TableModel model = tblNguoiDung.getModel();
        if (evt.getClickCount() == 2) {
            if (Dongduocchon >= 0) {
                int MaND = Integer.parseInt(tblNguoiDung.getValueAt(Dongduocchon, 0).toString());
                DTONguoidung nd = BLL.BLLNguoiDung.GetMaND(MaND);
                txtHoTen.setText(nd.getTenNguoiDung());
                txtsodienthoai.setText(nd.getSoDienThoai() + "");
                txtEmail.setText(nd.getEmail());
                txtMatKhau.setText(nd.getMatKhau());
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse((String) tblNguoiDung.getValueAt(Dongduocchon, 5));
                    jdcNgaySinh.setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse((String) tblNguoiDung.getValueAt(Dongduocchon, 6));
                    jdcNgayVaoLam.setDate(date);
                } catch (ParseException ex) {
                    Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (nd.getGioiTinh() == 1) {
                    cbbGioiTinh.setSelectedItem("Nam");
                } else {
                    cbbGioiTinh.setSelectedItem("Nữ");
                }
                txtCMND.setText(nd.getCMND());
                txtDiaChi.setText(nd.getDiaChi());
                txtTenDangNhap.setText(nd.getTenDangNhap());
                DefaultComboBoxModel cbc = (DefaultComboBoxModel) cbbLuong.getModel();
                for (int i = 0; i < cbbLuong.getItemCount(); i++) {
                    MyCombobox mL = (MyCombobox) cbc.getElementAt(i);
                    String tenloai = (mL.Text.toString());
                    if (tenloai.equals(tblNguoiDung.getValueAt(Dongduocchon, 10).toString())) {
                        cbbLuong.setSelectedIndex(i);
                    }
                }
                if (nd.getTrangThai() == 1) {
                    cbbTrangThai.setSelectedItem("Đang làm việc");
                } else {
                    cbbTrangThai.setSelectedItem("Đã nghỉ làm");
                }
                lblAnhDaiDien.setIcon(readLogo(model.getValueAt(Dongduocchon, 7).toString()));
                lblAnhDaiDien.setToolTipText(model.getValueAt(Dongduocchon, 7).toString());
                if (nd.getQuyen() == 0) {
                    cbbChucVu.setSelectedItem("Quản Trị");
                } else {
                    cbbChucVu.setSelectedItem("Nhân Viên");
                }
                txtId.setText(nd.getIdNguoiDung() + "");
                txtMoTa.setText(nd.getMoTa());
                tbpchuyentab.setSelectedIndex(1);

            }
        }
    }//GEN-LAST:event_tblNguoiDungMouseClicked

    private void txtTongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongActionPerformed

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:for
    }//GEN-LAST:event_txtIdActionPerformed

    private void mniXoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXoaNhanVienActionPerformed
        int kq = JOptionPane.showConfirmDialog(new JFrame(), "Bạn có chắc chắn muốn xóa nhân viên này không?",
                "Thông báo xác nhận", JOptionPane.YES_NO_OPTION);
        if (kq == JOptionPane.YES_OPTION) {

            int cacDong[] = tblNguoiDung.getSelectedRows();
            for (int i = 0; i < cacDong.length; i++) {
                int maND = Integer.parseInt(tblNguoiDung.getValueAt(cacDong[i], 0).toString());
                DAO.DAONguoiDung.XoaNhanVien(maND);
            }
        }
        BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiem.getText(), 0);
    }//GEN-LAST:event_mniXoaNhanVienActionPerformed

    private void tblNguoiDungMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNguoiDungMouseReleased
        if (evt.isPopupTrigger()) {
            ppmNhanVien.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblNguoiDungMouseReleased

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        LamMoiNhanVien();
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        int MaNguoiDung = Integer.parseInt(txtId.getText());
        MyCombobox Luong = (MyCombobox) cbbLuong.getSelectedItem();
        String TenNguoiDung = txtHoTen.getText();
        String SoDienThoai = txtsodienthoai.getText();
        String Email = txtEmail.getText();
        int GioiTinh;
        if (cbbGioiTinh.getSelectedItem().toString().equals("Nam")) {
            GioiTinh = 1;
        } else {
            GioiTinh = 0;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String NgaySinh = sdf.format(jdcNgaySinh.getDate());

        String NgayVaoLam = sdf.format(jdcNgayVaoLam.getDate());
        String DiaChi = txtDiaChi.getText();
        String CMND = txtCMND.getText();
        String MatKhau = txtMatKhau.getText();
        String TenDangNhap = txtTenDangNhap.getText();
        if (lblAnhDaiDien.getIcon() == null) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn hình ảnh khách hàng", "Thông báo");
            return;
        }
        String AnhDaiDien = lblAnhDaiDien.getToolTipText();
        int TrangThai;
        if (cbbTrangThai.getSelectedItem().toString().equals("Đang làm việc")) {
            TrangThai = 1;
        } else {
            TrangThai = 0;
        }
        int ChucVu;
        if (cbbChucVu.getSelectedItem().toString().equals("Quản trị")) {
            ChucVu = 0;
        } else {
            ChucVu = 1;
        }
        String MoTa = txtMoTa.getText();
        if (BLL.BLLNguoiDung.KiemTraSuaNguoiDung(TenNguoiDung, SoDienThoai, Email, NgaySinh, NgayVaoLam, DiaChi, CMND, TenDangNhap, MatKhau, MoTa)) {
            DTONguoidung nd = new DTONguoidung(MaNguoiDung, Integer.parseInt(Luong.Value.toString()), TenNguoiDung, SoDienThoai, Email, GioiTinh, NgaySinh, NgayVaoLam, DiaChi, CMND, TenDangNhap, MatKhau, AnhDaiDien, ChucVu, TrangThai, MoTa);
            BLL.BLLNguoiDung.SuaNguoiDung(nd);
            ThongBaoCanhBao.ThongBao("Sửa nhân viên thành công", "Thông báo");
            BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiemNV.getText(), 0);
            LamMoiNhanVien();

        }
    }//GEN-LAST:event_btnsuaActionPerformed

    private void tblPhatluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhatluongMouseClicked

    }//GEN-LAST:event_tblPhatluongMouseClicked

    private void txtSocavangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSocavangKeyReleased


    }//GEN-LAST:event_txtSocavangKeyReleased
    double Luong, tienThuong, tongLuong;
    private void txtTienThuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienThuongKeyReleased

        try {
            String luong = cbbLuongPL.getSelectedItem().toString();
            Double luong1 = ChuyenDoi.ChuyenTien(luong);
            int socadilam = Integer.parseInt(txtSocadilam.getText());
            int socadivang = Integer.parseInt(txtSocavang.getText());
            Double sotien1ca = luong1 / (socadilam + socadivang);

            Double tienthuong = ChuyenDoi.ChuyenTien(txtTienThuong.getText());

            jLabel2.setText(" Số tiền 1 ca: " + ChuyenDoi.DinhDangTien(sotien1ca) + "đ/ Ca/ 4h ");

            Double tongtien = ((sotien1ca * socadilam) + tienthuong);

            txtTienThuong.setText(BLL.ChuyenDoi.DinhDangTien(tienthuong));
            txtTongtienluong.setText(ChuyenDoi.DinhDangTien(tongtien));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_txtTienThuongKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        try {
            int thang = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            int nam = Integer.parseInt(jComboBox2.getSelectedItem().toString());
            BLLNguoiDung.HienThiNguoiDungTheoChucVuChamCong(tblnhanvienchamcong, thang, nam);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        try {
            int thang = Integer.parseInt(jComboBox1.getSelectedItem().toString());
            int nam = Integer.parseInt(jComboBox2.getSelectedItem().toString());
            BLLNguoiDung.HienThiNguoiDungTheoChucVuChamCong(tblnhanvienchamcong, thang, nam);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            String date = dcn.format(jdcNgaySinh.getDate());
            System.out.println(date.toString());

            BLLNguoiDung.HienThiNguoiDungTheoChucVuChamCongFull(tblnhanvienchamcong, date);

        } catch (Exception e) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn thời gian cần lọc", "Thông báo");
        }

    }//GEN-LAST:event_jButton6ActionPerformed
    public static int countCC, soTrangCC, trangCC = 1;
    public int trangCC1 = 1;

    private void cbbNguoidungItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNguoidungItemStateChanged

        try {
            countCC = 1;
            soTrangCC = 1;
            trangCC = 1;
            trangCC1 = 1;
            btnFirst.setEnabled(false);
            btnBack.setEnabled(false);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            MyCombobox mbs = (MyCombobox) cbbNguoidung.getSelectedItem();
            int nv = Integer.parseInt(mbs.Value.toString());
            String nvien = String.valueOf(nv);
            DAOChamCong.CountChamCong(nv);
            if (countCC % 7 == 0) {
                soTrangCC = countCC / 7;
            } else {
                soTrangCC = countCC / 7 + 1;
            }
            BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, nvien, 0);
            lblCountPage.setText(trangCC1 + "/" + soTrangCC + "");
            lblNumberPage.setText(trangCC1 + "");

        } catch (Exception e) {
        }

    }//GEN-LAST:event_cbbNguoidungItemStateChanged

    private void cbbNguoidungMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNguoidungMouseReleased

    }//GEN-LAST:event_cbbNguoidungMouseReleased

    private void cbbNguoidungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNguoidungActionPerformed

    }//GEN-LAST:event_cbbNguoidungActionPerformed

    private void FileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileChooser2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FileChooser2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jdlthemluong luong = new jdlthemluong(new javax.swing.JFrame(), true);
        luong.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed
    public static int idnv;
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        MyCombobox mb = (MyCombobox) cbbNhanVienPL.getSelectedItem();
        int MaLoaiNV = Integer.parseInt(mb.Value.toString());
        DTONguoidung nd = BLL.BLLNguoiDung.GetMaND(MaLoaiNV);
        String tennv = cbbNhanVienPL.getSelectedItem().toString();
        DAONguoiDung.LayTenNV(tennv);
        String NgayPhat = txtNgayPhat.getText();
        int SoCaDiLam = Integer.parseInt(txtSocadilam.getText());
        int SoCaNghi = Integer.parseInt(txtSocavang.getText());
        Double TienThuong = ChuyenDoi.ChuyenTien(txtTienThuong.getText());

        String GhiChu = txtGhichuPL.getText();
        MyCombobox mb1 = (MyCombobox) cbbLuong.getSelectedItem();
        int MaLuong = Integer.parseInt(mb1.Value.toString());
        Double Tongtien = ChuyenDoi.ChuyenTien(txtTongtienluong.getText());
        if (BLL.BLLNguoiDung.KiemTraPhatLuong(idnv, MaLuong, NgayPhat, SoCaDiLam, SoCaNghi, TienThuong, 0.0, GhiChu, Tongtien)) {
            DTO.DTOPhatLuong pl = new DTO.DTOPhatLuong(idnv, MaLuong, NgayPhat, SoCaDiLam, SoCaNghi, TienThuong, 0.0, GhiChu, Tongtien);
            BLL.BLLNguoiDung.PhatLuong(pl);
            ThongBaoCanhBao.ThongBao("Phát lương thành công", "Thông Báo");
            String MaThuChi = BLL.BLLThuChi.TaoSoHoaDon();
            String LoaiPhieu = "Phiếu Chi";
            String HangMucThuChi = "Phát Lương";
            double TongTien = ChuyenDoi.ChuyenTien(txtTongtienluong.getText());
            String GhiChuC = "Phát Lương Nhân Viên " + nd.getTenNguoiDung() + "";
            DTOPhieuThuChi ptc = new DTOPhieuThuChi(MaThuChi, MaLoaiNV, LoaiPhieu, HangMucThuChi, TongTien, GhiChuC);
            BLL.BLLThuChi.ThemThuChiNV(ptc);
            BLL.BLLPhatLuong.Hienthiphatluong(tblPhatluong);
            BLLNguoiDung.DoDuLieuVaoCBBNguoiDung(cbb);
            try {
                int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
                int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());

                int size = cbb.getItemCount();
                DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbNhanVienPL.getModel();
                cbbModel.removeAllElements();
                for (int i = 0; i < size; i++) {
                    String a = cbb.getItemAt(i).toString();

                    DAONguoiDung.CountNhanVien(a, thang, nam);
                    if (countnv == 0) {

                        cbbModel.addElement(a);
                    } else {
                    }
                    countnv = 0;
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txtSocadilamMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSocadilamMouseReleased

    }//GEN-LAST:event_txtSocadilamMouseReleased

    private void cbbLuongPLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLuongPLItemStateChanged

        try {
            String luong = cbbLuongPL.getSelectedItem().toString();
            Double luong1 = ChuyenDoi.ChuyenTien(luong);
            int socadilam = Integer.parseInt(txtSocadilam.getText());
            int socadivang = Integer.parseInt(txtSocavang.getText());
            Double sotien1ca = luong1 / (socadilam + socadivang);

            Double tienthuong = ChuyenDoi.ChuyenTien(txtTienThuong.getText());

            jLabel2.setText(" Số tiền 1 ca: " + ChuyenDoi.DinhDangTien(sotien1ca) + "đ/ Ca/ 4h ");

            Double tongtien = ((sotien1ca * socadilam) + tienthuong);

            txtTongtienluong.setText(ChuyenDoi.DinhDangTien(tongtien));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbbLuongPLItemStateChanged
    public JComboBox cbb = new JComboBox();
    private void cbbThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbThangItemStateChanged
        BLLNguoiDung.DoDuLieuVaoCBBNguoiDung(cbb);
        try {
            int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
            int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
            int size = cbb.getItemCount();
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbNhanVienPL.getModel();
            cbbModel.removeAllElements();
            for (int i = 0; i < size; i++) {
                String a = cbb.getItemAt(i).toString();

                DAONguoiDung.CountNhanVien(a, thang, nam);
                if (countnv == 0) {

                    cbbModel.addElement(a);
                } else {
                }
                countnv = 0;
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_cbbThangItemStateChanged

    private void cbbNamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNamItemStateChanged
        BLLNguoiDung.DoDuLieuVaoCBBNguoiDung(cbb);
        try {
            int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
            int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());

            int size = cbb.getItemCount();
            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbNhanVienPL.getModel();
            cbbModel.removeAllElements();
            for (int i = 0; i < size; i++) {
                String a = cbb.getItemAt(i).toString();

                DAONguoiDung.CountNhanVien(a, thang, nam);
                if (countnv == 0) {

                    cbbModel.addElement(a);
                } else {
                }
                countnv = 0;
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbbNamItemStateChanged

    private void cbbNhanVienPLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNhanVienPLItemStateChanged

        try {
            String tennv = cbbNhanVienPL.getSelectedItem().toString();
            int thang = Integer.parseInt(cbbThang.getSelectedItem().toString());
            int nam = Integer.parseInt(cbbNam.getSelectedItem().toString());
            DAONguoiDung.CheckLayNguoiDungChamCongThangNam(tennv, thang, nam);

            String luong = cbbLuongPL.getSelectedItem().toString();
            Double luong1 = ChuyenDoi.ChuyenTien(luong);
            int socadilam = Integer.parseInt(txtSocadilam.getText());
            int socadivang = Integer.parseInt(txtSocavang.getText());
            Double sotien1ca = luong1 / (socadilam + socadivang);

            Double tienthuong = ChuyenDoi.ChuyenTien(txtTienThuong.getText());

            jLabel2.setText(" Số tiền 1 ca: " + ChuyenDoi.DinhDangTien(sotien1ca) + "đ/ Ca/ 4h ");

            Double tongtien = ((sotien1ca * socadilam) + tienthuong);

            txtTienThuong.setText(BLL.ChuyenDoi.DinhDangTien(tienthuong));

            txtTongtienluong.setText(ChuyenDoi.DinhDangTien(tongtien));

        } catch (Exception e) {

        }


    }//GEN-LAST:event_cbbNhanVienPLItemStateChanged

    private void txtSocavangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSocavangMouseClicked

    }//GEN-LAST:event_txtSocavangMouseClicked

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        trangCC = 0;
        MyCombobox mbs = (MyCombobox) cbbNguoidung.getSelectedItem();
        int nv = Integer.parseInt(mbs.Value.toString());
        String nvien = String.valueOf(nv);
        BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, nvien, trangCC);
        trangCC1 = 1;
        btnNext.setEnabled(true);
        btnLast.setEnabled(true);
        btnFirst.setEnabled(false);
        btnBack.setEnabled(false);
        lblCountPage.setText(trangCC1 + "/" + soTrangCC + "");
        lblNumberPage.setText(trangCC1 + "");
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        if (trangCC1 == 2) {

            trangCC = trangCC - 7;
            MyCombobox mbs = (MyCombobox) cbbNguoidung.getSelectedItem();
            int nv = Integer.parseInt(mbs.Value.toString());
            String nvien = String.valueOf(nv);
            BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, nvien, trangCC);
            lblNumberPage.setText("" + (trangCC1 = (trangCC1 - 1)));
            lblCountPage.setText("" + trangCC1 + "/" + soTrangCC);
            btnBack.setEnabled(false);
            btnFirst.setEnabled(false);
            btnNext.setEnabled(true);

            btnLast.setEnabled(true);

        } else {
            btnBack.setEnabled(true);
            btnNext.setEnabled(true);

            btnLast.setEnabled(true);
            trangCC = trangCC - 7;
            MyCombobox mbs = (MyCombobox) cbbNguoidung.getSelectedItem();
            int nv = Integer.parseInt(mbs.Value.toString());
            String nvien = String.valueOf(nv);
            BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, nvien, trangCC);
            lblNumberPage.setText("" + (trangCC1 = (trangCC1 - 1)));
            lblCountPage.setText("" + trangCC1 + "/" + soTrangCC);
        }

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (trangCC1 == soTrangCC - 1) {
            trangCC = trangCC + 7;
            MyCombobox mbs = (MyCombobox) cbbNguoidung.getSelectedItem();
            int nv = Integer.parseInt(mbs.Value.toString());
            String nvien = String.valueOf(nv);
            BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, nvien, trangCC);
            lblNumberPage.setText("" + (trangCC1 = (trangCC1 + 1)));
            lblCountPage.setText("" + trangCC1 + "/" + soTrangCC);

            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
            btnBack.setEnabled(true);
            btnFirst.setEnabled(true);
        } else {
            btnNext.setEnabled(true);
            btnBack.setEnabled(true);
            btnFirst.setEnabled(true);
            trangCC = trangCC + 7;
            MyCombobox mbs = (MyCombobox) cbbNguoidung.getSelectedItem();
            int nv = Integer.parseInt(mbs.Value.toString());
            String nvien = String.valueOf(nv);
            BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, nvien, trangCC);
            lblNumberPage.setText("" + (trangCC1 = (trangCC1 + 1)));
            lblCountPage.setText("" + trangCC1 + "/" + soTrangCC);
        }
        System.out.println(lblNumberPage.getText());
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        btnNext.setEnabled(false);
        btnLast.setEnabled(false);
        btnFirst.setEnabled(true);
        btnBack.setEnabled(true);
        trangCC = (7 * soTrangCC) - 7;
        MyCombobox mbs = (MyCombobox) cbbNguoidung.getSelectedItem();
        int nv = Integer.parseInt(mbs.Value.toString());
        String nvien = String.valueOf(nv);
        BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, nvien, trangCC);
        trangCC1 = soTrangCC;
        lblCountPage.setText(trangCC1 + "/" + soTrangCC + "");
        lblNumberPage.setText(trangCC1 + "");
    }//GEN-LAST:event_btnLastActionPerformed

    public static int countnv;

    private void btnlammoi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlammoi1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jdlLocNhanVien lnv = new jdlLocNhanVien(new javax.swing.JFrame(), true);
        lnv.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btnFirstNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstNVActionPerformed
        if (LocNhanVien.equals("Đang Lọc")) {
             trangNV = 0;
        BLL.BLLNguoiDung.HienThiNguoiDungLoc(tblNguoiDung, GioiTinh, Quyen, TrangThai, trangNV);
        trangNV1 = 1;
        btnNext6.setEnabled(true);
        btnLast6.setEnabled(true);
        btnFirstNV.setEnabled(false);
        btnBack6.setEnabled(false);
        lblCountPage6.setText(trangNV1 + "/" + soTrangNV + "");
        lblNumberPage6.setText(trangNV1 + "");
        }else{
        trangNV = 0;
        BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiemNV.getText(), trangNV);
        trangNV1 = 1;
        btnNext6.setEnabled(true);
        btnLast6.setEnabled(true);
        btnFirstNV.setEnabled(false);
        btnBack6.setEnabled(false);
        lblCountPage6.setText(trangNV1 + "/" + soTrangNV + "");
        lblNumberPage6.setText(trangNV1 + "");
        }
    }//GEN-LAST:event_btnFirstNVActionPerformed

    private void btnBack6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack6ActionPerformed
         if (LocNhanVien.equals("Đang Lọc")) {
              if (trangNV1 == 2) {

            trangNV = trangNV - 13;
            BLL.BLLNguoiDung.HienThiNguoiDungLoc(tblNguoiDung, GioiTinh, Quyen, TrangThai, trangNV);
            lblNumberPage6.setText("" + (trangNV1 = (trangNV1 - 1)));
            lblCountPage6.setText("" + trangNV1 + "/" + soTrangNV);
            btnBack6.setEnabled(false);
            btnFirstNV.setEnabled(false);
            btnNext6.setEnabled(true);

            btnLast6.setEnabled(true);

        } else {
            btnBack6.setEnabled(true);
            btnNext6.setEnabled(true);

            btnLast6.setEnabled(true);
            trangNV = trangNV - 13;
             BLL.BLLNguoiDung.HienThiNguoiDungLoc(tblNguoiDung, GioiTinh, Quyen, TrangThai, trangNV);
            lblNumberPage6.setText("" + (trangNV1 = (trangNV1 - 1)));
            lblCountPage6.setText("" + trangNV1 + "/" + soTrangNV);
        }
         }else{
        if (trangNV1 == 2) {

            trangNV = trangNV - 13;
            BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiemNV.getText(), trangNV);
            lblNumberPage6.setText("" + (trangNV1 = (trangNV1 - 1)));
            lblCountPage6.setText("" + trangNV1 + "/" + soTrangNV);
            btnBack6.setEnabled(false);
            btnFirstNV.setEnabled(false);
            btnNext6.setEnabled(true);

            btnLast6.setEnabled(true);

        } else {
            btnBack6.setEnabled(true);
            btnNext6.setEnabled(true);

            btnLast6.setEnabled(true);
            trangNV = trangNV - 13;
            BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiemNV.getText(), trangNV);
            lblNumberPage6.setText("" + (trangNV1 = (trangNV1 - 1)));
            lblCountPage6.setText("" + trangNV1 + "/" + soTrangNV);
        }
         }
    }//GEN-LAST:event_btnBack6ActionPerformed

    private void btnNext6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext6ActionPerformed
       
        if (LocNhanVien.equals("Đang Lọc")) {
            if (trangNV1 == soTrangNV - 1) {
            trangNV = trangNV + 13;
            BLL.BLLNguoiDung.HienThiNguoiDungLoc(tblNguoiDung, GioiTinh, Quyen, TrangThai, trangNV);
            lblNumberPage6.setText("" + (trangNV1 = (trangNV1 + 1)));
            lblCountPage6.setText("" + trangNV1 + "/" + soTrangNV);

            btnNext6.setEnabled(false);
            btnLast6.setEnabled(false);
            btnBack6.setEnabled(true);
            btnFirstNV.setEnabled(true);
        } else {
            btnNext6.setEnabled(true);
            btnBack6.setEnabled(true);
            btnFirstNV.setEnabled(true);
            trangNV = trangNV + 13;
            BLL.BLLNguoiDung.HienThiNguoiDungLoc(tblNguoiDung, GioiTinh, Quyen, TrangThai, trangNV);
            lblNumberPage6.setText("" + (trangNV1 = (trangNV1 + 1)));
            lblCountPage6.setText("" + trangNV1 + "/" + soTrangNV);
        }
        }else{
        
        if (trangNV1 == soTrangNV - 1) {
            trangNV = trangNV + 13;
            BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiemNV.getText(), trangNV);
            lblNumberPage6.setText("" + (trangNV1 = (trangNV1 + 1)));
            lblCountPage6.setText("" + trangNV1 + "/" + soTrangNV);

            btnNext6.setEnabled(false);
            btnLast6.setEnabled(false);
            btnBack6.setEnabled(true);
            btnFirstNV.setEnabled(true);
        } else {
            btnNext6.setEnabled(true);
            btnBack6.setEnabled(true);
            btnFirstNV.setEnabled(true);
            trangNV = trangNV + 13;
            BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiemNV.getText(), trangNV);
            lblNumberPage6.setText("" + (trangNV1 = (trangNV1 + 1)));
            lblCountPage6.setText("" + trangNV1 + "/" + soTrangNV);
        }
        }

    }//GEN-LAST:event_btnNext6ActionPerformed

    private void btnLast6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLast6ActionPerformed
        if (LocNhanVien.equals("Đang Lọc")) {
              btnNext6.setEnabled(false);
        btnLast6.setEnabled(false);
        btnFirstNV.setEnabled(true);
        btnBack6.setEnabled(true);
        trangNV = (13 * soTrangNV) - 13;
         BLL.BLLNguoiDung.HienThiNguoiDungLoc(tblNguoiDung, GioiTinh, Quyen, TrangThai, trangNV);
        trangNV1 = soTrangNV;
        lblCountPage6.setText(trangNV1 + "/" + soTrangNV + "");
        lblNumberPage6.setText(trangNV1 + "");
        }else{
        btnNext6.setEnabled(false);
        btnLast6.setEnabled(false);
        btnFirstNV.setEnabled(true);
        btnBack6.setEnabled(true);
        trangNV = (13 * soTrangNV) - 13;
        BLL.BLLNguoiDung.HienThiNguoiDung(tblNguoiDung, txtTimKiemNV.getText(), trangNV);
        trangNV1 = soTrangNV;
        lblCountPage6.setText(trangNV1 + "/" + soTrangNV + "");
        lblNumberPage6.setText(trangNV1 + "");
        }
    }//GEN-LAST:event_btnLast6ActionPerformed
    private void LamMoiNhanVien() {
        txtHoTen.setText("");
        txtsodienthoai.setText("");
        txtEmail.setText("");
        txtMatKhau.setText("");
        Date date = new Date();
        jdcNgaySinh.setDate(date);
        jdcNgayVaoLam.setDate(date);
        cbbGioiTinh.setSelectedIndex(0);
        txtCMND.setText("");
        txtDiaChi.setText("");
        txtTenDangNhap.setText("");
        cbbTrangThai.setSelectedIndex(0);
        lblAnhDaiDien.setIcon(null);
        cbbChucVu.setSelectedIndex(0);
        txtId.setText("");
        txtMoTa.setToolTipText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JFileChooser FileChooser2;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack6;
    private javax.swing.JButton btnFirst;
    public static javax.swing.JButton btnFirstNV;
    private javax.swing.JButton btnLast;
    public static javax.swing.JButton btnLast6;
    private javax.swing.JButton btnNext;
    public static javax.swing.JButton btnNext6;
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnlammoi1;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbbGioiTinh;
    private javax.swing.JComboBox<String> cbbLuong;
    public static javax.swing.JComboBox<String> cbbLuongPL;
    public static javax.swing.JComboBox<String> cbbNam;
    public static javax.swing.JComboBox<String> cbbNguoidung;
    public static javax.swing.JComboBox<String> cbbNhanVienPL;
    public static javax.swing.JComboBox<String> cbbThang;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    public static javax.swing.JComboBox<String> jComboBox1;
    public static javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel63;
    public static javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable22;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    private com.toedter.calendar.JDateChooser jdcNgaySinh;
    public static com.toedter.calendar.JDateChooser jdcNgaySinh1;
    private com.toedter.calendar.JDateChooser jdcNgayVaoLam;
    private javax.swing.JLabel lblAnhDaiDien;
    private javax.swing.JLabel lblCountPage;
    public static javax.swing.JLabel lblCountPage6;
    private javax.swing.JLabel lblNumberPage;
    public static javax.swing.JLabel lblNumberPage6;
    private javax.swing.JLabel lblanhdaidien;
    private javax.swing.JLabel lbldiachihientai;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblemail2;
    private javax.swing.JLabel lblemail3;
    private javax.swing.JLabel lblemail4;
    private javax.swing.JLabel lblgioitinh;
    private javax.swing.JLabel lblhotenkhachhang;
    private javax.swing.JLabel lblhotenkhachhang2;
    private javax.swing.JLabel lblhotenkhachhang3;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblloaikhachhang;
    private javax.swing.JLabel lblmangxahoi;
    private javax.swing.JLabel lblmatkhau;
    private javax.swing.JLabel lblmatkhau3;
    private javax.swing.JLabel lblmota;
    private javax.swing.JLabel lblngaysinh;
    private javax.swing.JLabel lblnhanvienphutrach;
    private javax.swing.JLabel lblnhomkhachhang;
    private javax.swing.JLabel lblsodienthoai;
    private javax.swing.JLabel lblsodienthoai2;
    private javax.swing.JLabel lblsodienthoai3;
    private javax.swing.JLabel lblthongtinbosung;
    private javax.swing.JLabel lblthongtincoban;
    private javax.swing.JLabel lblthongtindiachi;
    private javax.swing.JLabel lblthongtinkhac;
    private javax.swing.JLabel lbltinh;
    private javax.swing.JMenuItem mniXoaNhanVien;
    private javax.swing.JPanel pnlChucVu;
    private javax.swing.JPanel pnlanhdaidien;
    private javax.swing.JPanel pnldanhsach;
    private javax.swing.JPanel pnldanhsach11;
    private javax.swing.JPanel pnlemail;
    private javax.swing.JPanel pnlemail2;
    private javax.swing.JPanel pnlemail3;
    private javax.swing.JPanel pnlemail4;
    private javax.swing.JPanel pnlnenanhdaidien;
    private javax.swing.JPanel pnlnenbtn;
    private javax.swing.JPanel pnlnendiachi;
    private javax.swing.JPanel pnlnengioitinh;
    private javax.swing.JPanel pnlnenhotenkhachhang;
    private javax.swing.JPanel pnlnenhotenkhachhang2;
    private javax.swing.JPanel pnlnenhotenkhachhang3;
    private javax.swing.JPanel pnlnenid;
    private javax.swing.JPanel pnlnenlonngoaithongtin;
    private javax.swing.JPanel pnlnenlonngoaithongtin1;
    private javax.swing.JPanel pnlnenlonngoaithongtin4;
    private javax.swing.JPanel pnlnenlonthongtincoban;
    private javax.swing.JPanel pnlnenlonthongtincoban1;
    private javax.swing.JPanel pnlnenlonthongtincoban4;
    private javax.swing.JPanel pnlnenmangxahoi;
    private javax.swing.JPanel pnlnenmatkhau;
    private javax.swing.JPanel pnlnenmatkhau3;
    private javax.swing.JPanel pnlnenmatkhau4;
    private javax.swing.JPanel pnlnenmota;
    private javax.swing.JPanel pnlnenngaysinh;
    private javax.swing.JPanel pnlnenngoaianhdaidien;
    private javax.swing.JPanel pnlnenngoaianhdaidien1;
    private javax.swing.JPanel pnlnenngoaianhdaidienvathongtinkhac;
    private javax.swing.JPanel pnlnenngoaianhdaidienvathongtinkhac1;
    private javax.swing.JPanel pnlnenngoaianhdaidienvathongtinkhac8;
    private javax.swing.JPanel pnlnenngoaianhdaidienvathongtinkhac9;
    private javax.swing.JPanel pnlnenngoaibtn;
    private javax.swing.JPanel pnlnenngoaithongtin;
    private javax.swing.JPanel pnlnenngoaithongtin1;
    private javax.swing.JPanel pnlnenngoaithongtin4;
    private javax.swing.JPanel pnlnenngoaithongtinkhac;
    private javax.swing.JPanel pnlnenngoaithongtinkhac1;
    private javax.swing.JPanel pnlnenngoaithongtinkhac12;
    private javax.swing.JPanel pnlnenngoaithongtinkhac13;
    private javax.swing.JPanel pnlnenngoaithongtinkhac14;
    private javax.swing.JPanel pnlnenngoaithongtinkhac2;
    private javax.swing.JPanel pnlnennhanvienphutrach;
    private javax.swing.JPanel pnlnennhomkhachhang;
    private javax.swing.JPanel pnlnensodienthoai;
    private javax.swing.JPanel pnlnensodienthoai2;
    private javax.swing.JPanel pnlnensodienthoai3;
    private javax.swing.JPanel pnlnenthemsuakhachhang1;
    private javax.swing.JPanel pnlnenthemsuakhachhang2;
    private javax.swing.JPanel pnlnenthemsuakhachhang5;
    private javax.swing.JPanel pnlnenthongtin;
    private javax.swing.JPanel pnlnenthongtin1;
    private javax.swing.JPanel pnlnenthongtinkhac;
    private javax.swing.JPanel pnlnenthongtinkhac4;
    private javax.swing.JPanel pnlnentinh;
    private javax.swing.JPanel pnlthemsuakhachhang;
    private javax.swing.JPanel pnlthemsuakhachhang4;
    private javax.swing.JPopupMenu ppmNhanVien;
    private javax.swing.JScrollPane srcdanhsach;
    public static javax.swing.JTable tblCheckPL;
    public static javax.swing.JTable tblNguoiDung;
    private javax.swing.JTable tblPhatluong;
    public static javax.swing.JTable tbllichsuchamcong;
    public static javax.swing.JTable tblnhanvienchamcong;
    private javax.swing.JTabbedPane tbpchuyentab;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGhichuPL;
    private javax.swing.JTextField txtHoTen;
    public static javax.swing.JTextField txtIDnhanvien;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextPane txtMoTa;
    private javax.swing.JTextField txtNgayPhat;
    public static javax.swing.JTextField txtNgayhomnay;
    public static javax.swing.JTextField txtSocadilam;
    public static javax.swing.JTextField txtSocavang;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtTienThuong;
    public static javax.swing.JTextField txtTimKiemNV;
    private javax.swing.JTextField txtTong;
    private javax.swing.JTextField txtTongtienluong;
    public static javax.swing.JTextField txtUudai1;
    private javax.swing.JTextField txtsodienthoai;
    public static javax.swing.JTextField txtsongaytrongthang;
    // End of variables declaration//GEN-END:variables
}
