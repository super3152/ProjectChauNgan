/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.ChuyenDoi;
import DTO.DTOPhieuThuChi;

/**
 *
 * @author Administrator
 */
public class jdlTraNoNhaCungCap extends javax.swing.JDialog {

    /**
     * Creates new form jdlTraNoNhaCungCap
     */
    public jdlTraNoNhaCungCap(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         int dongDuocChon = pnlChiTietNhaCungCap.tblCTNCC.getSelectedRow();
        lblTenKhachHang.setText(pnlChiTietNhaCungCap.lblTenNhaCungCap.getText());
        txtNoHoaDon.setText(pnlChiTietNhaCungCap.tblCTNCC.getValueAt(dongDuocChon, 6).toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlButton = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        pnlTitle = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblTenKhachHang = new javax.swing.JLabel();
        pnlChucNang = new javax.swing.JPanel();
        lblSoLuong = new javax.swing.JLabel();
        jFileChooser1 = new javax.swing.JFileChooser();
        cbbPhuongThuc = new javax.swing.JComboBox<>();
        lblGhiChu2 = new javax.swing.JLabel();
        txtNoHoaDon = new javax.swing.JTextField();
        lblGhiChu4 = new javax.swing.JLabel();
        txtThanhToan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnOK.setBackground(new java.awt.Color(204, 255, 204));
        btnOK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOK.setForeground(new java.awt.Color(0, 153, 0));
        btnOK.setText("Trả Nợ");
        btnOK.setToolTipText("");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonLayout = new javax.swing.GroupLayout(pnlButton);
        pnlButton.setLayout(pnlButtonLayout);
        pnlButtonLayout.setHorizontalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlButtonLayout.setVerticalGroup(
            pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOK, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlTitle.setBackground(new java.awt.Color(255, 255, 255));
        pnlTitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlTitleMouseDragged(evt);
            }
        });
        pnlTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlTitleMousePressed(evt);
            }
        });

        lblTitle.setBackground(new java.awt.Color(212, 216, 225));
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText(" Thông tin thanh toán cho nhà cung cấp");

        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlTitleLayout = new javax.swing.GroupLayout(pnlTitle);
        pnlTitle.setLayout(pnlTitleLayout);
        pnlTitleLayout.setHorizontalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(36, 36, 36))
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTitleLayout.setVerticalGroup(
            pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleLayout.createSequentialGroup()
                .addGroup(pnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTitleLayout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblTenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10))
        );

        pnlChucNang.setBackground(new java.awt.Color(255, 255, 255));
        pnlChucNang.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlChucNang.setForeground(new java.awt.Color(255, 255, 255));
        pnlChucNang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pnlChucNangFocusGained(evt);
            }
        });

        lblSoLuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSoLuong.setText("Phương Thức Thanh Toán");

        jFileChooser1.setPreferredSize(new java.awt.Dimension(0, 0));

        cbbPhuongThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Quẹt Thẻ", "Chuyển Khoản", "COD", " " }));
        cbbPhuongThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbPhuongThucActionPerformed(evt);
            }
        });

        lblGhiChu2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu2.setText("Nợ Nhà Cung Cấp");

        txtNoHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNoHoaDon.setEnabled(false);

        lblGhiChu4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblGhiChu4.setText("Thanh Toán");

        txtThanhToan.setText("0");
        txtThanhToan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtThanhToan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtThanhToanFocusGained(evt);
            }
        });
        txtThanhToan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtThanhToanKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout pnlChucNangLayout = new javax.swing.GroupLayout(pnlChucNang);
        pnlChucNang.setLayout(pnlChucNangLayout);
        pnlChucNangLayout.setHorizontalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChucNangLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlChucNangLayout.createSequentialGroup()
                                .addComponent(lblSoLuong)
                                .addGap(36, 36, 36)
                                .addComponent(cbbPhuongThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlChucNangLayout.createSequentialGroup()
                                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGhiChu4)
                                    .addComponent(lblGhiChu2))
                                .addGap(89, 89, 89)
                                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnlChucNangLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbPhuongThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoLuong))
                .addGap(27, 27, 27)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGhiChu2)
                    .addComponent(txtNoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGhiChu4)
                    .addComponent(txtThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(pnlChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbPhuongThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbPhuongThucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPhuongThucActionPerformed

    private void txtThanhToanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtThanhToanFocusGained
        txtThanhToan.setText("");
    }//GEN-LAST:event_txtThanhToanFocusGained

    private void txtThanhToanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThanhToanKeyReleased
        double TienTra, CongNo;

        TienTra = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());
        CongNo = BLL.ChuyenDoi.ChuyenTien(txtNoHoaDon.getText());
        txtThanhToan.setText(BLL.ChuyenDoi.DinhDangTien(TienTra));

        if (TienTra > CongNo) {
            txtThanhToan.setText(txtNoHoaDon.getText());
        }
    }//GEN-LAST:event_txtThanhToanKeyReleased

    private void pnlChucNangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pnlChucNangFocusGained

    }//GEN-LAST:event_pnlChucNangFocusGained

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

    }//GEN-LAST:event_jLabel10MouseClicked

    private void pnlTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitleMouseDragged

    }//GEN-LAST:event_pnlTitleMouseDragged

    private void pnlTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTitleMousePressed

    }//GEN-LAST:event_pnlTitleMousePressed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        int dongDuocChon = pnlChiTietKhachHang.tblCTKH.getSelectedRow();       
        int MaPN = BLL.BLLPhieuNhap.LayMaPhieuNhapString(pnlChiTietNhaCungCap.tblCTNCC.getValueAt(dongDuocChon, 2).toString());
        DTO.DTOPhieuNhap pn = BLL.BLLPhieuNhap.GetMaPN(MaPN);
        double NoTrongBang = pn.getCongNo();
        double TienTra = ChuyenDoi.ChuyenSangSo(txtThanhToan.getText());
        double CongNoPN = NoTrongBang - TienTra;
        DTO.DTOPhieuNhap spn = new DTO.DTOPhieuNhap(MaPN, CongNoPN);
        BLL.BLLPhieuNhap.TraNoPhieuNhap(spn);
        int IDNhaCungCap = pn.getIDNhaCungCap();
        DTO.DTONhaCungCap ncc = BLL.BLLNhaCungCap.GetMaNCC(IDNhaCungCap);
        double NoTrongBangNCC = ncc.getCongNo();
        double CongNoNCC = NoTrongBangNCC - TienTra;
        DTO.DTONhaCungCap sncc = new DTO.DTONhaCungCap(IDNhaCungCap, CongNoNCC);
        BLL.BLLNhaCungCap.TraNoNhaCungCap(sncc);
        ThongBaoCanhBao.ThongBao("Trả nợ nhà cung cấp thành công", "Thông Báo");
         String MaThuChi = BLL.BLLThuChi.TaoSoHoaDon();
        String LoaiPhieu = "Phiếu Chi";
        String HangMucThuChi = "Trả Nợ";
        double TongTien = BLL.ChuyenDoi.ChuyenTien(txtThanhToan.getText());    
        String GhiChu = "Trả Nợ Nhà Cung Cấp" + ncc.getTenNhaCungCap() + "";
        DTOPhieuThuChi ptc = new DTOPhieuThuChi(MaThuChi,LoaiPhieu, IDNhaCungCap, HangMucThuChi, TongTien, GhiChu);
        BLL.BLLThuChi.ThemThuChiNCC(ptc);
        this.dispose();
        
        
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdlTraNoNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdlTraNoNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdlTraNoNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdlTraNoNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdlTraNoNhaCungCap dialog = new jdlTraNoNhaCungCap(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cbbPhuongThuc;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblGhiChu2;
    private javax.swing.JLabel lblGhiChu4;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenKhachHang;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlTitle;
    public static javax.swing.JTextField txtNoHoaDon;
    public static javax.swing.JTextField txtThanhToan;
    // End of variables declaration//GEN-END:variables
}
