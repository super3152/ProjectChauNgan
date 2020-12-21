/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.BLLChamCong;
import BLL.BLLDonHang;
import static BLL.BLLDonHang.HienThiDonHang;
import BLL.BLLNguoiDung;
import BLL.ChuyenDoi;
import DAO.DBConection;
import DTO.DTOChamCong;
import static GUI.jdlCameraScanners.jTextField13;
import static GUI.pnlbanhang.hoadon;
import static GUI.pnlbanhang.tblChiTietHoaDon;
import static GUI.pnlbanhang.txtSoHoaDon;
import static GUI.pnlbanhang.txtTongTien;
import static GUI.pnlbanhang.txtUuDai;
import static GUI.pnlnhanvien.jComboBox1;
import static GUI.pnlnhanvien.jComboBox2;
import static GUI.pnlnhanvien.jPanel7;
import static GUI.pnlnhanvien.jTextField1;
import static GUI.pnlnhanvien.tbllichsuchamcong;
import static GUI.pnlnhanvien.tblnhanvienchamcong;
import static GUI.pnlnhanvien.txtIDnhanvien;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Takemikazuchi
 */
public class frmmain extends javax.swing.JFrame implements Runnable, ThreadFactory, ActionListener {
    Timer updateTimer;
    int DELAY = 100;
    public static WebcamPanel panelcam = null;
    public static Webcam webcam = null;
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    public Date currenTime = new Date();  
    public frmmain() {
        initComponents();
        jPopupMenu2.add(jPanel4);
           int milisInAMinute = 2000;
long time = System.currentTimeMillis();

Runnable update = new Runnable() {
    public void run() {
        try {
         URL url = new URL("http://www.google.com");
         URLConnection connection = url.openConnection();
         connection.connect();        
         
      } catch (MalformedURLException e) {
        ThongBaoThongTin.ThongBao("Mất kết nối", "Thông báo");
       
      } catch (IOException e) {
        ThongBaoThongTin.ThongBao("Mất kết nối", "Thông báo");
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
        
        
        
        
        
        lbldangxuat2.setText(BLL.BLLlogin.nguoidung.getTenNguoiDung());
        
        btntongquan.addActionListener(this);
        btnbanhang.addActionListener(this);
        btnsanpham.addActionListener(this);
        btndonhang.addActionListener(this);
        btnkhachhang.addActionListener(this);
        btnhanghoa.addActionListener(this);
        btntragop.addActionListener(this);
        btnthongke.addActionListener(this);
    }
    public void dsnut() {
        btntongquan.setEnabled(true);
        btnbanhang.setEnabled(true);
        btnsanpham.setEnabled(true);
        btndonhang.setEnabled(true);
        btnkhachhang.setEnabled(true);
        btnhanghoa.setEnabled(true);
        btntragop.setEnabled(true);
        btnthongke.setEnabled(true);

    }
   
    public void nut() {
        if (LoadDatabase.tq.isVisible()) {
            dsnut();
        } else if (LoadDatabase.bh.isVisible()) {
            dsnut();
        } else if (LoadDatabase.sp.isVisible()) {
            dsnut();
        } else if (LoadDatabase.dh.isVisible()) {
            dsnut();
        } else if (LoadDatabase.kh.isVisible()) {
            dsnut();
        } else if (LoadDatabase.gh.isVisible()) {
            dsnut();
        } else if (LoadDatabase.tg.isVisible()) {
            dsnut();
        }
        else if (LoadDatabase.tk.isVisible()) {
            dsnut();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        pnlnen = new javax.swing.JPanel();
        pnlnenmenu = new javax.swing.JPanel();
        btntongquan = new javax.swing.JButton();
        btnbanhang = new javax.swing.JButton();
        btnsanpham = new javax.swing.JButton();
        btndonhang = new javax.swing.JButton();
        btnkhachhang = new javax.swing.JButton();
        btnhanghoa = new javax.swing.JButton();
        btntragop = new javax.swing.JButton();
        btnthongke = new javax.swing.JButton();
        btnwebsite = new javax.swing.JButton();
        btnfanpage = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlnendangxuat2 = new javax.swing.JPanel();
        lbldangxuat2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlnennoidung = new javax.swing.JPanel();
        pnlnoidung = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnlnenlogo = new javax.swing.JPanel();
        lbllogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbltieude = new javax.swing.JLabel();
        lblTongHoaDon = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nội dung hóa đơn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 319, 195));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Xem anh sách đơn hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 205, 321, 30));

        jMenuItem1.setText("Thông tin người dùng");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Đăng xuất");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PHẦN MỀM QUẢN LÝ SHOP QUẦN ÁO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlnenmenu.setBackground(new java.awt.Color(102, 102, 102));

        btntongquan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btntongquan.setForeground(new java.awt.Color(255, 255, 255));
        btntongquan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/home.jpg"))); // NOI18N
        btntongquan.setText("  TỔNG QUAN");
        btntongquan.setToolTipText("");
        btntongquan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btntongquan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntongquanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btntongquanMouseExited(evt);
            }
        });
        btntongquan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntongquanActionPerformed(evt);
            }
        });

        btnbanhang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnbanhang.setForeground(new java.awt.Color(255, 255, 255));
        btnbanhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/banhang.jpg"))); // NOI18N
        btnbanhang.setText("BÁN HÀNG");
        btnbanhang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbanhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbanhangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbanhangMouseExited(evt);
            }
        });
        btnbanhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbanhangActionPerformed(evt);
            }
        });

        btnsanpham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnsanpham.setForeground(new java.awt.Color(255, 255, 255));
        btnsanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/sanpham.jpg"))); // NOI18N
        btnsanpham.setText("SẢN PHẨM");
        btnsanpham.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnsanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsanphamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsanphamMouseExited(evt);
            }
        });

        btndonhang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btndonhang.setForeground(new java.awt.Color(255, 255, 255));
        btndonhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/donhang.jpg"))); // NOI18N
        btndonhang.setText(" ĐƠN HÀNG");
        btndonhang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btndonhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btndonhangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btndonhangMouseExited(evt);
            }
        });
        btndonhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndonhangActionPerformed(evt);
            }
        });

        btnkhachhang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnkhachhang.setForeground(new java.awt.Color(255, 255, 255));
        btnkhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/khachhang.jpg"))); // NOI18N
        btnkhachhang.setText("     KHÁCH HÀNG");
        btnkhachhang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnkhachhangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnkhachhangMouseExited(evt);
            }
        });

        btnhanghoa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnhanghoa.setForeground(new java.awt.Color(255, 255, 255));
        btnhanghoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/hanghoa.jpg"))); // NOI18N
        btnhanghoa.setText("HÀNG HÓA");
        btnhanghoa.setToolTipText("");
        btnhanghoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnhanghoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhanghoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhanghoaMouseExited(evt);
            }
        });

        btntragop.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btntragop.setForeground(new java.awt.Color(255, 255, 255));
        btntragop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/tragop.jpg"))); // NOI18N
        btntragop.setText("NHÂN VIÊN");
        btntragop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btntragop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntragopMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btntragopMouseExited(evt);
            }
        });
        btntragop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntragopActionPerformed(evt);
            }
        });

        btnthongke.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnthongke.setForeground(new java.awt.Color(255, 255, 255));
        btnthongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/thongke.jpg"))); // NOI18N
        btnthongke.setText("THỐNG KÊ ");
        btnthongke.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnthongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnthongkeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnthongkeMouseExited(evt);
            }
        });

        btnwebsite.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnwebsite.setForeground(new java.awt.Color(255, 255, 255));
        btnwebsite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/web.jpg"))); // NOI18N
        btnwebsite.setText("WEBSITE   ");
        btnwebsite.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnwebsite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnwebsiteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnwebsiteMouseExited(evt);
            }
        });
        btnwebsite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnwebsiteActionPerformed(evt);
            }
        });

        btnfanpage.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnfanpage.setForeground(new java.awt.Color(255, 255, 255));
        btnfanpage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/fb.jpg"))); // NOI18N
        btnfanpage.setText("FANPAGE  ");
        btnfanpage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnfanpage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnfanpageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnfanpageMouseExited(evt);
            }
        });
        btnfanpage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfanpageActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        pnlnendangxuat2.setBackground(new java.awt.Color(9, 122, 192));
        pnlnendangxuat2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlnendangxuat2.setPreferredSize(new java.awt.Dimension(200, 50));

        lbldangxuat2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbldangxuat2.setForeground(new java.awt.Color(255, 255, 255));
        lbldangxuat2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbldangxuat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/shutdown_25px.png"))); // NOI18N
        lbldangxuat2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldangxuat2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbldangxuat2lbldangxuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbldangxuat2lbldangxuatMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlnendangxuat2Layout = new javax.swing.GroupLayout(pnlnendangxuat2);
        pnlnendangxuat2.setLayout(pnlnendangxuat2Layout);
        pnlnendangxuat2Layout.setHorizontalGroup(
            pnlnendangxuat2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlnendangxuat2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbldangxuat2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
        );
        pnlnendangxuat2Layout.setVerticalGroup(
            pnlnendangxuat2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbldangxuat2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel3.add(pnlnendangxuat2, java.awt.BorderLayout.LINE_START);

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout pnlnenmenuLayout = new javax.swing.GroupLayout(pnlnenmenu);
        pnlnenmenu.setLayout(pnlnenmenuLayout);
        pnlnenmenuLayout.setHorizontalGroup(
            pnlnenmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btntongquan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnbanhang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btndonhang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnhanghoa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btntragop, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnwebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnfanpage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlnenmenuLayout.setVerticalGroup(
            pnlnenmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenmenuLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(btntongquan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnbanhang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btndonhang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnhanghoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btntragop, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnwebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnfanpage, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlnennoidung.setBackground(new java.awt.Color(225, 226, 226));

        pnlnoidung.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnlnoidungLayout = new javax.swing.GroupLayout(pnlnoidung);
        pnlnoidung.setLayout(pnlnoidungLayout);
        pnlnoidungLayout.setHorizontalGroup(
            pnlnoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlnoidungLayout.setVerticalGroup(
            pnlnoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlnennoidungLayout = new javax.swing.GroupLayout(pnlnennoidung);
        pnlnennoidung.setLayout(pnlnennoidungLayout);
        pnlnennoidungLayout.setHorizontalGroup(
            pnlnennoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnennoidungLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlnoidung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlnennoidungLayout.setVerticalGroup(
            pnlnennoidungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnennoidungLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(pnlnoidung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        pnlnenlogo.setBackground(new java.awt.Color(33, 36, 51));

        lbllogo.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lbllogo.setForeground(new java.awt.Color(255, 255, 255));
        lbllogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/logomain.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbltieude.setBackground(new java.awt.Color(33, 36, 51));
        lbltieude.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbltieude.setForeground(new java.awt.Color(33, 36, 51));
        lbltieude.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbltieude.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/chevron_right_20px.png"))); // NOI18N
        lbltieude.setText("TỔNG QUAN");

        lblTongHoaDon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTongHoaDon.setForeground(new java.awt.Color(255, 0, 0));
        lblTongHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/bell_24px_1.png"))); // NOI18N
        lblTongHoaDon.setText("Bạn có 10 Đơn hàng mới");
        lblTongHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTongHoaDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTongHoaDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTongHoaDonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltieude)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 636, Short.MAX_VALUE)
                .addComponent(lblTongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTongHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbltieude)
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlnenlogoLayout = new javax.swing.GroupLayout(pnlnenlogo);
        pnlnenlogo.setLayout(pnlnenlogoLayout);
        pnlnenlogoLayout.setHorizontalGroup(
            pnlnenlogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenlogoLayout.createSequentialGroup()
                .addComponent(lbllogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlnenlogoLayout.setVerticalGroup(
            pnlnenlogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbllogo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout pnlnenLayout = new javax.swing.GroupLayout(pnlnen);
        pnlnen.setLayout(pnlnenLayout);
        pnlnenLayout.setHorizontalGroup(
            pnlnenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(pnlnennoidung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlnenLayout.createSequentialGroup()
                .addComponent(pnlnenmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(pnlnenlogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlnenLayout.setVerticalGroup(
            pnlnenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlnenLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pnlnenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlnenmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlnennoidung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(pnlnenLayout.createSequentialGroup()
                .addComponent(pnlnenlogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlnen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
           

        jPanel2.removeAll();
        jPanel2.add(LoadDatabase.tq);
        jPanel2.validate();
        

    }//GEN-LAST:event_formWindowOpened

    private void btntongquanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntongquanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btntongquanActionPerformed

    private void btntongquanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntongquanMouseEntered
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/home2.jpg")).getImage();
        btntongquan.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btntongquanMouseEntered

    private void btntongquanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntongquanMouseExited
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/home.jpg")).getImage();
        btntongquan.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btntongquanMouseExited

    private void btnwebsiteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnwebsiteMouseEntered
        // TODO add your handling code here:
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/web2.jpg")).getImage();
        btnwebsite.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnwebsiteMouseEntered

    private void btnwebsiteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnwebsiteMouseExited
        // TODO add your handling code here:
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/web.jpg")).getImage();
        btnwebsite.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnwebsiteMouseExited

    private void btnwebsiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnwebsiteActionPerformed
        // TODO add your handling code here:

        String url = "www.shopmart.fun";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            Logger.getLogger(frmmain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnwebsiteActionPerformed

    private void btnfanpageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfanpageMouseEntered
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/fb2.jpg")).getImage();
        btnfanpage.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnfanpageMouseEntered

    private void btnfanpageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfanpageMouseExited
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/fb.jpg")).getImage();
        btnfanpage.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnfanpageMouseExited

    private void btnfanpageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfanpageActionPerformed
        String url = "https://www.facebook.com/Anh-Em-Team-%E1%BB%A8ng-D%E1%BB%A5ng-290622998371256/";
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (IOException ex) {
            Logger.getLogger(frmmain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnfanpageActionPerformed

    private void btnbanhangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbanhangMouseEntered
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/banhang2.jpg")).getImage();
        btnbanhang.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnbanhangMouseEntered

    private void btnbanhangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbanhangMouseExited
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/banhang.jpg")).getImage();
        btnbanhang.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnbanhangMouseExited

    private void btnsanphamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsanphamMouseEntered
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/sanpham2.jpg")).getImage();
        btnsanpham.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnsanphamMouseEntered

    private void btnsanphamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsanphamMouseExited
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/sanpham.jpg")).getImage();
        btnsanpham.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnsanphamMouseExited

    private void btndonhangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndonhangMouseEntered
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/donhang2.jpg")).getImage();
        btndonhang.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btndonhangMouseEntered

    private void btndonhangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndonhangMouseExited
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/donhang.jpg")).getImage();
        btndonhang.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btndonhangMouseExited

    private void btnkhachhangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkhachhangMouseEntered
        // TODO add your handling code here:
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/khachhang2.jpg")).getImage();
        btnkhachhang.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnkhachhangMouseEntered

    private void btnkhachhangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkhachhangMouseExited
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/khachhang.jpg")).getImage();
        btnkhachhang.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnkhachhangMouseExited

    private void btnhanghoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhanghoaMouseEntered
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/hanghoa2.jpg")).getImage();
        btnhanghoa.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnhanghoaMouseEntered

    private void btnhanghoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhanghoaMouseExited
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/hanghoa.jpg")).getImage();
        btnhanghoa.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnhanghoaMouseExited

    private void btntragopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntragopMouseEntered
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/tragop2.jpg")).getImage();
        btntragop.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btntragopMouseEntered

    private void btntragopMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntragopMouseExited
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/tragop.jpg")).getImage();
        btntragop.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btntragopMouseExited

    private void btnthongkeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthongkeMouseEntered
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/thongke2.jpg")).getImage();
        btnthongke.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnthongkeMouseEntered

    private void btnthongkeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthongkeMouseExited
        Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/thongke.jpg")).getImage();
        btnthongke.setIcon(new ImageIcon(photo2));
    }//GEN-LAST:event_btnthongkeMouseExited

    private void lbldangxuat2lbldangxuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldangxuat2lbldangxuatMouseEntered
        // TODO add your handling code here:
        setcolorbutton(pnlnendangxuat2);
    }//GEN-LAST:event_lbldangxuat2lbldangxuatMouseEntered

    private void lbldangxuat2lbldangxuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldangxuat2lbldangxuatMouseExited
        // TODO add your handling code here:
        resetcolorbutton(pnlnendangxuat2);
    }//GEN-LAST:event_lbldangxuat2lbldangxuatMouseExited

    private void btntragopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntragopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btntragopActionPerformed

    private void btndonhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndonhangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndonhangActionPerformed

    private void btnbanhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbanhangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbanhangActionPerformed

    private void lbldangxuat2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldangxuat2MouseClicked
       this.dispose();
           jdllogin jdl = new jdllogin();
           jdl.setVisible(true);
    }//GEN-LAST:event_lbldangxuat2MouseClicked

    private void lblTongHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTongHoaDonMouseClicked
        jPopupMenu2.show(lblTongHoaDon, 0 , lblTongHoaDon.getHeight());
        BLLDonHang.HienThiHoaDonKhachHang(jTable1);
    }//GEN-LAST:event_lblTongHoaDonMouseClicked

    private void lblTongHoaDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTongHoaDonMouseEntered
        lblTongHoaDon.setForeground(Color.blue);
    }//GEN-LAST:event_lblTongHoaDonMouseEntered

    private void lblTongHoaDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTongHoaDonMouseExited
        lblTongHoaDon.setForeground(Color.red);
    }//GEN-LAST:event_lblTongHoaDonMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        btndonhang.doClick();
        HienThiDonHang(pnlgiaohang.tblDonHang1, pnlgiaohang.txttimkiem1.getText(),0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    void setcolorbutton(JPanel panel) {
        panel.setBackground(Color.WHITE);
        lbldangxuat2.setForeground(new Color(9, 122, 192));
    }

    void resetcolorbutton(JPanel panel) {
        panel.setBackground(new Color(9, 122, 192));
        lbldangxuat2.setForeground(Color.WHITE);
    }

    void setcolor(JPanel panel) {
        panel.setBackground(new Color(33, 36, 51));

    }

    void resetcolor(JPanel panel) {
        panel.setBackground(new Color(68, 71, 82));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object evt = e.getSource();
        if (evt.equals(btntongquan)) {
             if (webcam == null) {
                
            }else{
                 webcam.close();
            }
            Image photo2 = new ImageIcon(this.getClass().getResource("/IMAGE/home2.jpg")).getImage();
            btntongquan.setIcon(new ImageIcon(photo2));
             LoadDatabase.tq.setVisible(true);
            LoadDatabase.bh.setVisible(false);
            LoadDatabase.sp.setVisible(false);
            LoadDatabase.dh.setVisible(false);
            LoadDatabase.kh.setVisible(false);
            LoadDatabase.gh.setVisible(false);
            LoadDatabase.tg.setVisible(false);
            LoadDatabase.tk.setVisible(false);

            lbltieude.setText("TỔNG QUAN");
            jPanel2.add(LoadDatabase.tq);
            jPanel2.validate();
            nut();

        } else if (evt.equals(btnbanhang)) {
             if (webcam == null) {
                
            }else{
                 webcam.close();
            }
            LoadDatabase.tq.setVisible(false);
            LoadDatabase.bh.setVisible(true);
            LoadDatabase.sp.setVisible(false);
            LoadDatabase.dh.setVisible(false);
            LoadDatabase.kh.setVisible(false);
            LoadDatabase.gh.setVisible(false);
            LoadDatabase.tg.setVisible(false);
            LoadDatabase.tk.setVisible(false);

            lbltieude.setText("BÁN HÀNG");
            jPanel2.add(LoadDatabase.bh);
            jPanel2.validate();
            
            
            
            
            nut();
            
            
            Dimension size = WebcamResolution.QVGA.getSize();
            webcam = Webcam.getWebcams().get(0);
            webcam.setViewSize(size);
            panelcam = new WebcamPanel(webcam);
            panelcam.setPreferredSize(size);
            panelcam.setFPSDisplayed(true);
            executor.execute(this);
            
            
            
            
        } else if (evt.equals(btnsanpham)) {
          if (webcam == null) {
                
            }else{
                 webcam.close();
            }
            LoadDatabase.tq.setVisible(false);
            LoadDatabase.bh.setVisible(false);
            LoadDatabase.sp.setVisible(true);
            LoadDatabase.dh.setVisible(false);
            LoadDatabase.kh.setVisible(false);
            LoadDatabase.gh.setVisible(false);
            LoadDatabase.tg.setVisible(false);
            LoadDatabase.tk.setVisible(false);

            lbltieude.setText("SẢN PHẨM");
            jPanel2.add(LoadDatabase.sp);
            jPanel2.validate();
            nut();
        } else if (evt.equals(btndonhang)) {
            if (webcam == null) {
                
            }else{
                 webcam.close();
            }
            LoadDatabase.tq.setVisible(false);
            LoadDatabase.bh.setVisible(false);
            LoadDatabase.sp.setVisible(false);
            LoadDatabase.dh.setVisible(true);
            LoadDatabase.kh.setVisible(false);
            LoadDatabase.gh.setVisible(false);
            LoadDatabase.tg.setVisible(false);
            LoadDatabase.tk.setVisible(false);

            lbltieude.setText("ĐƠN HÀNG");
            jPanel2.add(LoadDatabase.dh);
            jPanel2.validate();
            nut();
        } else if (evt.equals(btnkhachhang)) {
            if (webcam == null) {
                
            }else{
                 webcam.close();
            }
            LoadDatabase.tq.setVisible(false);
            LoadDatabase.bh.setVisible(false);
            LoadDatabase.sp.setVisible(false);
            LoadDatabase.dh.setVisible(false);
            LoadDatabase.kh.setVisible(true);
            LoadDatabase.gh.setVisible(false);
            LoadDatabase.tg.setVisible(false);
            LoadDatabase.tk.setVisible(false);

            lbltieude.setText("KHÁCH HÀNG");
            jPanel2.add(LoadDatabase.kh);
            jPanel2.validate();
            nut();
        } else if (evt.equals(btnhanghoa)) {
           if (webcam == null) {
                
            }else{
                 webcam.close();
            }
            LoadDatabase.tq.setVisible(false);
            LoadDatabase.bh.setVisible(false);
            LoadDatabase.sp.setVisible(false);
            LoadDatabase.dh.setVisible(false);
            LoadDatabase.kh.setVisible(false);
            LoadDatabase.gh.setVisible(true);
            LoadDatabase.tg.setVisible(false);
            LoadDatabase.tk.setVisible(false);

            lbltieude.setText("HÀNG HÓA");
            jPanel2.add(LoadDatabase.gh);
            jPanel2.validate();
            nut();
        } else if (evt.equals(btntragop)) {
           if (webcam == null) {
                
            }else{
                 webcam.close();
            }
            LoadDatabase.tq.setVisible(false);
            LoadDatabase.bh.setVisible(false);
            LoadDatabase.sp.setVisible(false);
            LoadDatabase.dh.setVisible(false);
            LoadDatabase.kh.setVisible(false);
            LoadDatabase.gh.setVisible(false);
            LoadDatabase.tg.setVisible(true);
            LoadDatabase.tk.setVisible(false);

            lbltieude.setText("NHÂN VIÊN");
            jPanel2.add(LoadDatabase.tg);
            jPanel2.validate();
            nut();
              Dimension size = WebcamResolution.QVGA.getSize();
            webcam = Webcam.getWebcams().get(0);
            webcam.setViewSize(size);
            panelcam = new WebcamPanel(webcam);
            panelcam.setPreferredSize(size);
            panelcam.setFPSDisplayed(true);
            executor.execute(this);
             jPanel7.add(panelcam, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, jPanel7.getWidth(), jPanel7.getHeight()));
        } else if (evt.equals(btnthongke)) {
            
            if (webcam == null) {
                
            }else{
                 webcam.close();
            }
            
            LoadDatabase.tq.setVisible(false);
            LoadDatabase.bh.setVisible(false);
            LoadDatabase.sp.setVisible(false);
            LoadDatabase.dh.setVisible(false);
            LoadDatabase.kh.setVisible(false);
            LoadDatabase.gh.setVisible(false);
            LoadDatabase.tg.setVisible(false);
            LoadDatabase.tk.setVisible(true);

            lbltieude.setText("THỐNG KÊ");
            jPanel2.add(LoadDatabase.tk);
            jPanel2.validate();
            nut();
        }
    }

    public static void main(String args[]) {
        
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {

        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmmain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbanhang;
    private javax.swing.JButton btndonhang;
    private javax.swing.JButton btnfanpage;
    private javax.swing.JButton btnhanghoa;
    private javax.swing.JButton btnkhachhang;
    private javax.swing.JButton btnsanpham;
    private javax.swing.JButton btnthongke;
    private javax.swing.JButton btntongquan;
    private javax.swing.JButton btntragop;
    private javax.swing.JButton btnwebsite;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JLabel lblTongHoaDon;
    private javax.swing.JLabel lbldangxuat2;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lbltieude;
    private javax.swing.JPanel pnlnen;
    private javax.swing.JPanel pnlnendangxuat2;
    private javax.swing.JPanel pnlnenlogo;
    private javax.swing.JPanel pnlnenmenu;
    private javax.swing.JPanel pnlnennoidung;
    private javax.swing.JPanel pnlnoidung;
    // End of variables declaration//GEN-END:variables

  @Override
    public void run() {
        try {
           if (lbltieude.getText().equals("BÁN HÀNG")) {
            System.out.println("bán hàng");
                    do {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (NullPointerException ex) {

            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
                       
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                     
            try {
                result = new MultiFormatReader().decode(bitmap);
            }
            catch(NotFoundException exx){
                
            }
            
            catch (NullPointerException ex) {

            }

          if (result != null) {
              
                   if (hoadon == 0) {
                   jTextField1.setText(result.getText());
                    String MaSanPham = result.getText();
                    int MaSP = BLL.BLLHoaDon.LayMaSanPhamString(MaSanPham);
                    DTO.DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSP);

                    ResultSet rsksp = DAO.DAOHoaDon.GetByMaSP(MaSanPham);
                    try {
                        if (!rsksp.next()) {
                            ThongBaoCanhBao.ThongBao("Không phải sản phẩm! "
                                    + "\nVui lòng quét lại mã! ", "Thông báo");

                        } else {

                            if (sp.getTonKho() <= 0) {
                                ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng!", "Thông Báo");
                            } else {
                                int MaSPB = 0;

                                for (int i = 0; i < tblChiTietHoaDon.getRowCount(); i++) {
                                    MaSPB = (int) tblChiTietHoaDon.getValueAt(i, 0);
                                    int SoLuongB = (int) tblChiTietHoaDon.getValueAt(i, 6);
                                    double UuDaiB = ChuyenDoi.ChuyenSangSo(tblChiTietHoaDon.getValueAt(i, 8).toString());
                                    double TongTien = ChuyenDoi.ChuyenSangSo(tblChiTietHoaDon.getValueAt(i, 9).toString());

                                    if (MaSP == MaSPB) {
                                        if (sp.getTonKho() == SoLuongB) {
                                            ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng vui lòng nhập thêm!", "Thông Báo");

                                        }
                                        if ((sp.getTonKho() != SoLuongB)) {
                                            DefaultTableModel model = (DefaultTableModel) tblChiTietHoaDon.getModel();
                                            model.removeRow(i);

                                            double tongTienTrung = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDonTrung(tblChiTietHoaDon, sp, SoLuongB, UuDaiB);
                                            double TongTienCu = ChuyenDoi.ChuyenSangSo(txtTongTien.getText());
                                            double TongTienTru = TongTienCu - TongTien;
                                            double TongTienMoi = TongTienTru + tongTienTrung;
                                            txtTongTien.setText(ChuyenDoi.DinhDangTien(TongTienMoi));
                                        }

                                    }
                                }
                                if (MaSP != MaSPB) {

                                    int SoLuong = 1;
                                    double UuDai = 0;

                                    double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDon(tblChiTietHoaDon, sp, SoLuong, UuDai);
                                    txtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));

                                    double TongUuDai = BLL.ChuyenDoi.ChuyenTien(txtUuDai.getText());
                                    txtUuDai.setText(ChuyenDoi.DinhDangTien(TongUuDai));

                                    if (txtSoHoaDon.getText().equals("")) {

                                        txtSoHoaDon.setText(BLL.BLLHoaDon.TaoSoHoaDon());

                                    }
                                }
                                

                            }
                        }

                    } catch (SQLException ex) {
                        ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");

                    }

                    try {

                        // Open an audio input stream.
                        URL url = this.getClass().getClassLoader().getResource("MP3/beep.wav");
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                        // Get a sound clip resource.
                        Clip clip = AudioSystem.getClip();
                        // Open audio clip and load samples from the audio input stream.
                        clip.open(audioIn);
                        clip.start();
                    } catch (UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (LineUnavailableException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }else if(hoadon == 1){
                   jTextField1.setText(result.getText());
                    String MaSanPham = result.getText();
                    int MaSP = BLL.BLLHoaDon.LayMaSanPhamString(MaSanPham);
                    DTO.DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSP);

                    ResultSet rsksp = DAO.DAOHoaDon.GetByMaSP(MaSanPham);
                    try {
                        if (!rsksp.next()) {
                            ThongBaoCanhBao.ThongBao("Không phải sản phẩm! "
                                    + "\nVui lòng quét lại mã! ", "Thông báo");

                        } else {

                            if (sp.getTonKho() <= 0) {
                                ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng!", "Thông Báo");
                            } else {
                                int MaSPB = 0;

                                for (int i = 0; i < pnlbanhangdon2.tblChiTietHoaDon.getRowCount(); i++) {
                                    MaSPB = (int) pnlbanhangdon2.tblChiTietHoaDon.getValueAt(i, 0);
                                    int SoLuongB = (int) pnlbanhangdon2.tblChiTietHoaDon.getValueAt(i, 6);
                                    double UuDaiB = ChuyenDoi.ChuyenSangSo(pnlbanhangdon2.tblChiTietHoaDon.getValueAt(i, 8).toString());
                                    double TongTien = ChuyenDoi.ChuyenSangSo(pnlbanhangdon2.tblChiTietHoaDon.getValueAt(i, 9).toString());

                                    if (MaSP == MaSPB) {
                                        if (sp.getTonKho() == SoLuongB) {
                                            ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng vui lòng nhập thêm!", "Thông Báo");

                                        }
                                        if ((sp.getTonKho() != SoLuongB)) {
                                            DefaultTableModel model = (DefaultTableModel) pnlbanhangdon2.tblChiTietHoaDon.getModel();
                                            model.removeRow(i);

                                            double tongTienTrung = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDonTrungdon2(pnlbanhangdon2.tblChiTietHoaDon, sp, SoLuongB, UuDaiB);
                                            double TongTienCu = ChuyenDoi.ChuyenSangSo(pnlbanhangdon2.txtTongTien.getText());
                                            double TongTienTru = TongTienCu - TongTien;
                                            double TongTienMoi = TongTienTru + tongTienTrung;
                                            pnlbanhangdon2.txtTongTien.setText(ChuyenDoi.DinhDangTien(TongTienMoi));
                                        }

                                    }
                                }
                                if (MaSP != MaSPB) {

                                    int SoLuong = 1;
                                    double UuDai = 0;

                                    double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDondon2(pnlbanhangdon2.tblChiTietHoaDon, sp, SoLuong, UuDai);
                                    pnlbanhangdon2.txtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));

                                    double TongUuDai = BLL.ChuyenDoi.ChuyenTien(pnlbanhangdon2.txtUuDai.getText());
                                    pnlbanhangdon2.txtUuDai.setText(ChuyenDoi.DinhDangTien(TongUuDai));

                                    if (pnlbanhangdon2.txtSoHoaDon.getText().equals("")) {

                                        pnlbanhangdon2.txtSoHoaDon.setText(BLL.BLLHoaDon.TaoSoHoaDon());

                                    }
                                }
                                

                            }
                        }

                    } catch (SQLException ex) {
                        ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");

                    }

                    try {

                        // Open an audio input stream.
                        URL url = this.getClass().getClassLoader().getResource("MP3/beep.wav");
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                        // Get a sound clip resource.
                        Clip clip = AudioSystem.getClip();
                        // Open audio clip and load samples from the audio input stream.
                        clip.open(audioIn);
                        clip.start();
                    } catch (UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (LineUnavailableException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }else if(hoadon == 2){
                   jTextField1.setText(result.getText());
                    String MaSanPham = result.getText();
                    int MaSP = BLL.BLLHoaDon.LayMaSanPhamString(MaSanPham);
                    DTO.DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSP);

                    ResultSet rsksp = DAO.DAOHoaDon.GetByMaSP(MaSanPham);
                    try {
                        if (!rsksp.next()) {
                            ThongBaoCanhBao.ThongBao("Không phải sản phẩm! "
                                    + "\nVui lòng quét lại mã! ", "Thông báo");

                        } else {

                            if (sp.getTonKho() <= 0) {
                                ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng!", "Thông Báo");
                            } else {
                                int MaSPB = 0;

                                for (int i = 0; i < pnlbanhangdon3.tblChiTietHoaDon.getRowCount(); i++) {
                                    MaSPB = (int) pnlbanhangdon3.tblChiTietHoaDon.getValueAt(i, 0);
                                    int SoLuongB = (int) pnlbanhangdon3.tblChiTietHoaDon.getValueAt(i, 6);
                                    double UuDaiB = ChuyenDoi.ChuyenSangSo(pnlbanhangdon3.tblChiTietHoaDon.getValueAt(i, 8).toString());
                                    double TongTien = ChuyenDoi.ChuyenSangSo(pnlbanhangdon3.tblChiTietHoaDon.getValueAt(i, 9).toString());

                                    if (MaSP == MaSPB) {
                                        if (sp.getTonKho() == SoLuongB) {
                                            ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng vui lòng nhập thêm!", "Thông Báo");

                                        }
                                        if ((sp.getTonKho() != SoLuongB)) {
                                            DefaultTableModel model = (DefaultTableModel) pnlbanhangdon3.tblChiTietHoaDon.getModel();
                                            model.removeRow(i);

                                            double tongTienTrung = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDonTrungdon3(pnlbanhangdon3.tblChiTietHoaDon, sp, SoLuongB, UuDaiB);
                                            double TongTienCu = ChuyenDoi.ChuyenSangSo(pnlbanhangdon3.txtTongTien.getText());
                                            double TongTienTru = TongTienCu - TongTien;
                                            double TongTienMoi = TongTienTru + tongTienTrung;
                                            pnlbanhangdon3.txtTongTien.setText(ChuyenDoi.DinhDangTien(TongTienMoi));
                                        }

                                    }
                                }
                                if (MaSP != MaSPB) {

                                    int SoLuong = 1;
                                    double UuDai = 0;

                                    double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDondon3(pnlbanhangdon3.tblChiTietHoaDon, sp, SoLuong, UuDai);
                                    pnlbanhangdon3.txtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));

                                    double TongUuDai = BLL.ChuyenDoi.ChuyenTien(pnlbanhangdon3.txtUuDai.getText());
                                    pnlbanhangdon3.txtUuDai.setText(ChuyenDoi.DinhDangTien(TongUuDai));

                                    if (pnlbanhangdon3.txtSoHoaDon.getText().equals("")) {

                                        pnlbanhangdon3.txtSoHoaDon.setText(BLL.BLLHoaDon.TaoSoHoaDon());

                                    }
                                }
                                

                            }
                        }

                    } catch (SQLException ex) {
                        ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");

                    }

                    try {

                        // Open an audio input stream.
                        URL url = this.getClass().getClassLoader().getResource("MP3/beep.wav");
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                        // Get a sound clip resource.
                        Clip clip = AudioSystem.getClip();
                        // Open audio clip and load samples from the audio input stream.
                        clip.open(audioIn);
                        clip.start();
                    } catch (UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (LineUnavailableException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }else if(hoadon == 3){
                   jTextField1.setText(result.getText());
                    String MaSanPham = result.getText();
                    int MaSP = BLL.BLLHoaDon.LayMaSanPhamString(MaSanPham);
                    DTO.DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSP);

                    ResultSet rsksp = DAO.DAOHoaDon.GetByMaSP(MaSanPham);
                    try {
                        if (!rsksp.next()) {
                            ThongBaoCanhBao.ThongBao("Không phải sản phẩm! "
                                    + "\nVui lòng quét lại mã! ", "Thông báo");

                        } else {

                            if (sp.getTonKho() <= 0) {
                                ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng!", "Thông Báo");
                            } else {
                                int MaSPB = 0;

                                for (int i = 0; i < pnlbanhangdon4.tblChiTietHoaDon.getRowCount(); i++) {
                                    MaSPB = (int) pnlbanhangdon4.tblChiTietHoaDon.getValueAt(i, 0);
                                    int SoLuongB = (int) pnlbanhangdon4.tblChiTietHoaDon.getValueAt(i, 6);
                                    double UuDaiB = ChuyenDoi.ChuyenSangSo(pnlbanhangdon4.tblChiTietHoaDon.getValueAt(i, 8).toString());
                                    double TongTien = ChuyenDoi.ChuyenSangSo(pnlbanhangdon4.tblChiTietHoaDon.getValueAt(i, 9).toString());

                                    if (MaSP == MaSPB) {
                                        if (sp.getTonKho() == SoLuongB) {
                                            ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng vui lòng nhập thêm!", "Thông Báo");

                                        }
                                        if ((sp.getTonKho() != SoLuongB)) {
                                            DefaultTableModel model = (DefaultTableModel) pnlbanhangdon4.tblChiTietHoaDon.getModel();
                                            model.removeRow(i);

                                            double tongTienTrung = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDonTrungdon4(pnlbanhangdon4.tblChiTietHoaDon, sp, SoLuongB, UuDaiB);
                                            double TongTienCu = ChuyenDoi.ChuyenSangSo(pnlbanhangdon4.txtTongTien.getText());
                                            double TongTienTru = TongTienCu - TongTien;
                                            double TongTienMoi = TongTienTru + tongTienTrung;
                                            pnlbanhangdon4.txtTongTien.setText(ChuyenDoi.DinhDangTien(TongTienMoi));
                                        }

                                    }
                                }
                                if (MaSP != MaSPB) {

                                    int SoLuong = 1;
                                    double UuDai = 0;

                                    double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDondon4(pnlbanhangdon4.tblChiTietHoaDon, sp, SoLuong, UuDai);
                                    pnlbanhangdon4.txtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));

                                    double TongUuDai = BLL.ChuyenDoi.ChuyenTien(pnlbanhangdon4.txtUuDai.getText());
                                    pnlbanhangdon4.txtUuDai.setText(ChuyenDoi.DinhDangTien(TongUuDai));

                                    if (pnlbanhangdon4.txtSoHoaDon.getText().equals("")) {

                                        pnlbanhangdon4.txtSoHoaDon.setText(BLL.BLLHoaDon.TaoSoHoaDon());

                                    }
                                }
                                

                            }
                        }

                    } catch (SQLException ex) {
                        ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");

                    }

                    try {

                        // Open an audio input stream.
                        URL url = this.getClass().getClassLoader().getResource("MP3/beep.wav");
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                        // Get a sound clip resource.
                        Clip clip = AudioSystem.getClip();
                        // Open audio clip and load samples from the audio input stream.
                        clip.open(audioIn);
                        clip.start();
                    } catch (UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (LineUnavailableException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }else if(hoadon == 4){
                   jTextField1.setText(result.getText());
                    String MaSanPham = result.getText();
                    int MaSP = BLL.BLLHoaDon.LayMaSanPhamString(MaSanPham);
                    DTO.DTOSanPham sp = BLL.BLLSanPham.GetMaSP(MaSP);

                    ResultSet rsksp = DAO.DAOHoaDon.GetByMaSP(MaSanPham);
                    try {
                        if (!rsksp.next()) {
                            ThongBaoCanhBao.ThongBao("Không phải sản phẩm! "
                                    + "\nVui lòng quét lại mã! ", "Thông báo");

                        } else {

                            if (sp.getTonKho() <= 0) {
                                ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng!", "Thông Báo");
                            } else {
                                int MaSPB = 0;

                                for (int i = 0; i < pnlbanhangdon5.tblChiTietHoaDon.getRowCount(); i++) {
                                    MaSPB = (int) pnlbanhangdon5.tblChiTietHoaDon.getValueAt(i, 0);
                                    int SoLuongB = (int) pnlbanhangdon5.tblChiTietHoaDon.getValueAt(i, 6);
                                    double UuDaiB = ChuyenDoi.ChuyenSangSo(pnlbanhangdon5.tblChiTietHoaDon.getValueAt(i, 8).toString());
                                    double TongTien = ChuyenDoi.ChuyenSangSo(pnlbanhangdon5.tblChiTietHoaDon.getValueAt(i, 9).toString());

                                    if (MaSP == MaSPB) {
                                        if (sp.getTonKho() == SoLuongB) {
                                            ThongBaoCanhBao.ThongBao("Sản phẩm đã hết hàng vui lòng nhập thêm!", "Thông Báo");

                                        }
                                        if ((sp.getTonKho() != SoLuongB)) {
                                            DefaultTableModel model = (DefaultTableModel) pnlbanhangdon5.tblChiTietHoaDon.getModel();
                                            model.removeRow(i);

                                            double tongTienTrung = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDonTrungdon5(pnlbanhangdon5.tblChiTietHoaDon, sp, SoLuongB, UuDaiB);
                                            double TongTienCu = ChuyenDoi.ChuyenSangSo(pnlbanhangdon5.txtTongTien.getText());
                                            double TongTienTru = TongTienCu - TongTien;
                                            double TongTienMoi = TongTienTru + tongTienTrung;
                                            pnlbanhangdon5.txtTongTien.setText(ChuyenDoi.DinhDangTien(TongTienMoi));
                                        }

                                    }
                                }
                                if (MaSP != MaSPB) {

                                    int SoLuong = 1;
                                    double UuDai = 0;

                                    double tongTien = BLL.BLLHoaDon.NhapSanPhamVaoChiTietHoaDondon5(pnlbanhangdon5.tblChiTietHoaDon, sp, SoLuong, UuDai);
                                    pnlbanhangdon5.txtTongTien.setText(BLL.ChuyenDoi.DinhDangTien(tongTien));

                                    double TongUuDai = BLL.ChuyenDoi.ChuyenTien(pnlbanhangdon5.txtUuDai.getText());
                                    pnlbanhangdon5.txtUuDai.setText(ChuyenDoi.DinhDangTien(TongUuDai));

                                    if (pnlbanhangdon5.txtSoHoaDon.getText().equals("")) {

                                        pnlbanhangdon5.txtSoHoaDon.setText(BLL.BLLHoaDon.TaoSoHoaDon());

                                    }
                                }
                                

                            }
                        }

                    } catch (SQLException ex) {
                        ThongBaoCanhBao.ThongBao("Lỗi lệnh SQL", "Thông báo");

                    }

                    try {

                        // Open an audio input stream.
                        URL url = this.getClass().getClassLoader().getResource("MP3/beep.wav");
                        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                        // Get a sound clip resource.
                        Clip clip = AudioSystem.getClip();
                        // Open audio clip and load samples from the audio input stream.
                        clip.open(audioIn);
                        clip.start();
                    } catch (UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (LineUnavailableException e) {
                        e.printStackTrace();
                    }

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                    }

              }
                }
        } while (true);
        }else if(lbltieude.getText().equals("NHÂN VIÊN")){
            System.out.println("nhân viên");
            
            
         do {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(NullPointerException ex){
                
            }

            Result result = null;
            BufferedImage image = null;

            
                
            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }catch(NullPointerException ex){
                
            }

            if (result != null) {
                txtIDnhanvien.setText(result.getText());              
                       try{       
        DTOChamCong cc = BLL.BLLChamCong.GetCC(Integer.parseInt(result.getText() ));
        int Socachamcong1 =  cc.getSocachamcong();
        String tennguoidung = cc.getTennguoidung();
        txtIDnhanvien.setText(tennguoidung);
        jTextField1.setText(Socachamcong1+"");
      
        String formatTimeStr = "HH:ss";
        String formatTimeStrH = "HHss";
        DateFormat formatTime = new SimpleDateFormat(formatTimeStr);
        DateFormat formatTimeH = new SimpleDateFormat(formatTimeStrH);
        String formatedTimeStr = formatTime.format(currenTime);
        String formatedTimeStH = formatTimeH.format(currenTime);
        int giohientai = Integer.parseInt(formatedTimeStH);
        System.out.println(giohientai);
        if (giohientai < 715) {
            ThongBaoCanhBao.ThongBao("Thời gian nghỉ", "Thông báo");
        }
        else if (giohientai >=715 && giohientai <= 730
        ) {

            if (Socachamcong1 == 1) {
                ThongBaoCanhBao.ThongBao("Bạn đã điểm danh ca này rồi", "Thông báo");
            }else{

                int idnhanvien = Integer.parseInt(txtIDnhanvien.getText());
                
                if (BLL.BLLChamCong.KiemTraSuaChamCong(1, 1, idnhanvien)) {
                    DTOChamCong scc = new DTOChamCong(1, 1, idnhanvien);
                    BLL.BLLChamCong.SuaChamCong(scc);
                    ThongBaoCanhBao.ThongBao("Điểm danh ca sáng thành công"+"\n"+"Nhân viên: "+tennguoidung , "Thông báo");
                    BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, String.valueOf(idnhanvien),0);
                    String formatTimeStr5 = "yyyy";
                    String formatTimeStr6 = "MM";
                    DateFormat formatTime5 = new SimpleDateFormat(formatTimeStr5);
                    DateFormat formatTime6 = new SimpleDateFormat(formatTimeStr6);
                    String formatedTimeStr5 = formatTime5.format(currenTime);
                    String formatedTimeStr6 = formatTime6.format(currenTime);
                    jComboBox1.setSelectedItem(formatedTimeStr6);
                    jComboBox2.setSelectedItem(formatedTimeStr5);

                    int thang = Integer.parseInt(jComboBox1.getSelectedItem().toString());
                    int nam = Integer.parseInt(jComboBox2.getSelectedItem().toString());
                    BLLNguoiDung.HienThiNguoiDungTheoChucVuChamCong(tblnhanvienchamcong, thang, nam);
                }
            }

        }

        else if(giohientai >0730 && giohientai <1130){
            ThongBaoCanhBao.ThongBao("Hết thời gian điểm danh ca Sáng", "Thông báo");
        }

        else if (giohientai >=1300 && giohientai <= 1315
        ) {

            if (Socachamcong1 == 1) {
                        
         int idnhanvien = Integer.parseInt(txtIDnhanvien.getText());
         if (BLL.BLLChamCong.KiemTraSuaChamCong(4, 1, idnhanvien)) {
            DTOChamCong scc = new DTOChamCong(4, 1, idnhanvien);
            BLL.BLLChamCong.SuaChamCong(scc);
            ThongBaoCanhBao.ThongBao("Điểm danh ca Chiều và ca Sáng thành công"+"\n"+"Nhân viên: "+tennguoidung, "Thông báo");
                 BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, String.valueOf(idnhanvien),0);
            String formatTimeStr5 = "yyyy";
             String formatTimeStr6 = "MM";
         DateFormat formatTime5 = new SimpleDateFormat(formatTimeStr5);
           DateFormat formatTime6 = new SimpleDateFormat(formatTimeStr6);
         String formatedTimeStr5 = formatTime5.format(currenTime);
          String formatedTimeStr6 = formatTime6.format(currenTime);
                   jComboBox1.setSelectedItem(formatedTimeStr6);
                    jComboBox2.setSelectedItem(formatedTimeStr5);

                 
                  int thang = Integer.parseInt(jComboBox1.getSelectedItem().toString());
           int nam = Integer.parseInt(jComboBox2.getSelectedItem().toString());
       BLLNguoiDung.HienThiNguoiDungTheoChucVuChamCong(tblnhanvienchamcong, thang, nam);
}
            }else if(Socachamcong1 == 2){
                ThongBaoThongTin.ThongBao("Bạn đã điểm danh ca chiều, nhưng vắng ca sáng"+"\n"+"Nhân viên: "+tennguoidung, formatTimeStr);
            }else if(Socachamcong1 == 4){
                ThongBaoThongTin.ThongBao("Bạn đã điểm danh ca Sáng và ca Chiều rồi"+"\n"+"Nhân viên: "+tennguoidung, formatTimeStr);
            }
            else{
                       
         int idnhanvien = Integer.parseInt(txtIDnhanvien.getText());
         if (BLL.BLLChamCong.KiemTraSuaChamCong(2, 1, idnhanvien)) {
            DTOChamCong scc = new DTOChamCong(2, 1, idnhanvien);
            BLL.BLLChamCong.SuaChamCong(scc);
            ThongBaoCanhBao.ThongBao("Điểm danh ca chiều thành công"+"\n"+"Nhân viên: "+tennguoidung, "Thông báo");
                 BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, String.valueOf(idnhanvien),0);
            String formatTimeStr5 = "yyyy";
             String formatTimeStr6 = "MM";
         DateFormat formatTime5 = new SimpleDateFormat(formatTimeStr5);
           DateFormat formatTime6 = new SimpleDateFormat(formatTimeStr6);
         String formatedTimeStr5 = formatTime5.format(currenTime);
          String formatedTimeStr6 = formatTime6.format(currenTime);
                   jComboBox1.setSelectedItem(formatedTimeStr6);
                    jComboBox2.setSelectedItem(formatedTimeStr5);

                 
                  int thang = Integer.parseInt(jComboBox1.getSelectedItem().toString());
           int nam = Integer.parseInt(jComboBox2.getSelectedItem().toString());
       BLLNguoiDung.HienThiNguoiDungTheoChucVuChamCong(tblnhanvienchamcong, thang, nam);
}
            }
            ///

        }else if(giohientai >1315 && giohientai < 1700){
            ThongBaoCanhBao.ThongBao("Hết thời gian điểm danh ca Chiều"+"\n"+"Nhân viên: "+tennguoidung, "Thông báo");
        }

        else if (giohientai >=1700 && giohientai <= 1715
        ) {
            if (Socachamcong1 == 1) {
                // ca 1 ok, ca 2 vắng => 6
                 int idnhanvien = Integer.parseInt(txtIDnhanvien.getText());
         if (BLL.BLLChamCong.KiemTraSuaChamCong(6, 1, idnhanvien)) {
            DTOChamCong scc = new DTOChamCong(6, 1, idnhanvien);
            BLL.BLLChamCong.SuaChamCong(scc);
            ThongBaoCanhBao.ThongBao("Điểm danh ca Tối thành công"+"\n"+"Hôm nay ca Chiều chưa điểm danh"+"\n"+"Nhân viên: "+tennguoidung, "Thông báo");
                 BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, String.valueOf(idnhanvien),0);
            String formatTimeStr5 = "yyyy";
             String formatTimeStr6 = "MM";
         DateFormat formatTime5 = new SimpleDateFormat(formatTimeStr5);
           DateFormat formatTime6 = new SimpleDateFormat(formatTimeStr6);
         String formatedTimeStr5 = formatTime5.format(currenTime);
          String formatedTimeStr6 = formatTime6.format(currenTime);
                   jComboBox1.setSelectedItem(formatedTimeStr6);
                    jComboBox2.setSelectedItem(formatedTimeStr5);

                 
                  int thang = Integer.parseInt(jComboBox1.getSelectedItem().toString());
           int nam = Integer.parseInt(jComboBox2.getSelectedItem().toString());
       BLLNguoiDung.HienThiNguoiDungTheoChucVuChamCong(tblnhanvienchamcong, thang, nam);
}
            }else if(Socachamcong1 == 2){
                // ca 1 vắng, ca 2 ok => 5
                 int idnhanvien = Integer.parseInt(txtIDnhanvien.getText());
         if (BLL.BLLChamCong.KiemTraSuaChamCong(5, 1, idnhanvien)) {
            DTOChamCong scc = new DTOChamCong(5, 1, idnhanvien);
            BLL.BLLChamCong.SuaChamCong(scc);
            ThongBaoCanhBao.ThongBao("Điểm danh ca Tối thành công"+"\n"+"Hôm nay ca Sáng chưa điểm danh"+"\n"+"Nhân viên: "+tennguoidung, "Thông báo");
                 BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, String.valueOf(idnhanvien),0);
            String formatTimeStr5 = "yyyy";
             String formatTimeStr6 = "MM";
         DateFormat formatTime5 = new SimpleDateFormat(formatTimeStr5);
           DateFormat formatTime6 = new SimpleDateFormat(formatTimeStr6);
         String formatedTimeStr5 = formatTime5.format(currenTime);
          String formatedTimeStr6 = formatTime6.format(currenTime);
                   jComboBox1.setSelectedItem(formatedTimeStr6);
                    jComboBox2.setSelectedItem(formatedTimeStr5);

                 
                  int thang = Integer.parseInt(jComboBox1.getSelectedItem().toString());
           int nam = Integer.parseInt(jComboBox2.getSelectedItem().toString());
       BLLNguoiDung.HienThiNguoiDungTheoChucVuChamCong(tblnhanvienchamcong, thang, nam);
}
                
                
            }else if(Socachamcong1 == 3){
                // đã điểm danh ca 3 nhứng vắng ca 1,2 => null3
                 ThongBaoCanhBao.ThongBao("Bạn đã điểm danh ca chiều rồi"+"\n"+" Bạn vắng ca Sáng + Ca chiều"+"\n"+"Nhân viên: "+tennguoidung, "Thông báo");
            }else if(Socachamcong1 == 4){
                // ca 1 ok, ca 2 ok => full ngày = 7
                 int idnhanvien = Integer.parseInt(txtIDnhanvien.getText());
         if (BLL.BLLChamCong.KiemTraSuaChamCong(7, 1, idnhanvien)) {
            DTOChamCong scc = new DTOChamCong(7, 1, idnhanvien);
            BLL.BLLChamCong.SuaChamCong(scc);
            ThongBaoCanhBao.ThongBao("Điểm danh ca Tối thành công"+"\n"+"Hôm nay đã điểm danh Full Ngày"+"\n"+"Nhân viên: "+tennguoidung, "Thông báo");
                 BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, String.valueOf(idnhanvien),0);
            String formatTimeStr5 = "yyyy";
             String formatTimeStr6 = "MM";
         DateFormat formatTime5 = new SimpleDateFormat(formatTimeStr5);
           DateFormat formatTime6 = new SimpleDateFormat(formatTimeStr6);
         String formatedTimeStr5 = formatTime5.format(currenTime);
          String formatedTimeStr6 = formatTime6.format(currenTime);
                   jComboBox1.setSelectedItem(formatedTimeStr6);
                    jComboBox2.setSelectedItem(formatedTimeStr5);

                 
                  int thang = Integer.parseInt(jComboBox1.getSelectedItem().toString());
           int nam = Integer.parseInt(jComboBox2.getSelectedItem().toString());
       BLLNguoiDung.HienThiNguoiDungTheoChucVuChamCong(tblnhanvienchamcong, thang, nam);
}
                
            }else if(Socachamcong1 == 5){
                // bạn đã diểm danh ca 2,3 nhưng vắng ca 1 = null5
                  ThongBaoCanhBao.ThongBao("Bạn đã điểm danh ca Chiều + ca Tối rồi"+"\n"+" Bạn vắng ca Sáng"+"\n"+"Nhân viên: "+tennguoidung, "Thông báo");
            }else if(Socachamcong1 == 6){
                // bạn đã điểm danh ca 1,3 nhưng vắng ca 2 = null6
                  ThongBaoCanhBao.ThongBao("Bạn đã điểm danh ca Sáng + ca Tối rồi"+"\n"+" Bạn vắng ca Chiều"+"\n"+"Nhân viên: "+tennguoidung, "Thông báo");
            }else{
                // ca 1 vắng, ca 2 vắng => 3 - điểm danh ca 3 thành công
                 int idnhanvien = Integer.parseInt(txtIDnhanvien.getText());
         if (BLL.BLLChamCong.KiemTraSuaChamCong(3, 1, idnhanvien)) {
            DTOChamCong scc = new DTOChamCong(3, 1, idnhanvien);
            BLL.BLLChamCong.SuaChamCong(scc);
            ThongBaoCanhBao.ThongBao("Điểm danh ca tối thành công"+"\n"+"Nhân viên: "+tennguoidung, "Thông báo");
                 BLLChamCong.HienThiLichSuChamCong(tbllichsuchamcong, String.valueOf(idnhanvien),0);
            String formatTimeStr5 = "yyyy";
             String formatTimeStr6 = "MM";
         DateFormat formatTime5 = new SimpleDateFormat(formatTimeStr5);
           DateFormat formatTime6 = new SimpleDateFormat(formatTimeStr6);
         String formatedTimeStr5 = formatTime5.format(currenTime);
          String formatedTimeStr6 = formatTime6.format(currenTime);
                   jComboBox1.setSelectedItem(formatedTimeStr6);
                    jComboBox2.setSelectedItem(formatedTimeStr5);

                 
                  int thang = Integer.parseInt(jComboBox1.getSelectedItem().toString());
           int nam = Integer.parseInt(jComboBox2.getSelectedItem().toString());
       BLLNguoiDung.HienThiNguoiDungTheoChucVuChamCong(tblnhanvienchamcong, thang, nam);
}
            }
          
        }else if(giohientai >1700 && giohientai <= 2100){
            ThongBaoCanhBao.ThongBao("Hết thời gian điểm danh ca Tối"+"\n"+"Nhân viên: "+tennguoidung, "Thông báo");
        }

        else{
            ThongBaoCanhBao.ThongBao("Thời gian nghỉ", "Thông báo");
        }

                System.out.println(result);
                
              
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(pnlkhachhang.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                } catch (Exception e) {
                     ThongBaoCanhBao.ThongBao("Không tồn tại nhân viên này", "Thông báo");
                }
            }
  
        } while (true);
   
        }else{
        
        }

      } catch (Exception e) {
            System.out.println(e);
      }
       
    }

    @Override
    public Thread newThread(Runnable r) {
        
        
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
