/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.pnlthongke.tblThuChi;

/**
 *
 * @author Administrator
 */
public class jdlLocThuChi extends javax.swing.JDialog {

    /**
     * Creates new form jdlLocThuChi
     */
    public jdlLocThuChi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnLoc2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbbNhaCungCap = new javax.swing.JComboBox<>();
        cbbKhachHang = new javax.swing.JComboBox<>();
        cbbNhanVien = new javax.swing.JComboBox<>();
        cbbLoaiPhieu = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        cbbHangMuc = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LỌC THU CHI");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnLoc2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGE/filter_edit_20px.png"))); // NOI18N
        btnLoc2.setText("     Lọc ngay");
        btnLoc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoc2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Lọc Phiếu Nhập");

        cbbNhaCungCap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả Nhà Cung Cấp" }));
        cbbNhaCungCap.setToolTipText("");
        cbbNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbNhaCungCapMouseClicked(evt);
            }
        });

        cbbKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả Khách Hàng" }));
        cbbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbKhachHangMouseClicked(evt);
            }
        });

        cbbNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả Nhân Viên" }));
        cbbNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbNhanVienMouseClicked(evt);
            }
        });
        cbbNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNhanVienActionPerformed(evt);
            }
        });

        cbbLoaiPhieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả Loại Phiếu" }));
        cbbLoaiPhieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbLoaiPhieuMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nhà Cung Cấp");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Khách Hàng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Loại Phiếu");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nhân Viên");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Hạng Mục");

        cbbHangMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hạng Mục Thu Chi" }));
        cbbHangMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbHangMucMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbNhaCungCap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(cbbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbbLoaiPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbHangMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoc2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbbNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbLoaiPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbHangMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLoc2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoc2ActionPerformed
        if (cbbNhaCungCap.getSelectedItem().equals("Tất Cả Nhà Cung Cấp") && cbbKhachHang.getSelectedItem().equals("Tất Cả Khách Hàng") && cbbNhanVien.getSelectedItem().equals("Tất Cả Nhân Viên")
                && cbbLoaiPhieu.getSelectedItem().equals("Tất Cả Loại Phiếu") && cbbHangMuc.getSelectedItem().equals("Hạng Mục Thu Chi")) {
            ThongBaoCanhBao.ThongBao("Vui lòng chọn kiểu lọc thu chi!", "Thông Báo");
            return;

        }

        String NhaCungCap;
        String MaKhachHang;
        String MaNhanVien;
        String LoaiPhieu;
        String HangMuc;

        if (cbbNhaCungCap.getSelectedItem().equals("Tất Cả Nhà Cung Cấp")) {
            NhaCungCap = "";
        } else {
            int IDNhaCungCap = BLL.BLLNhaCungCap.LayMaNhaCungCapString(cbbNhaCungCap.getSelectedItem().toString());
            NhaCungCap = "idnhacungcap like '"+String.valueOf(IDNhaCungCap)+"' and" ;
        }
        if (cbbKhachHang.getSelectedItem().equals("Tất Cả Khách Hàng")) {
            MaKhachHang = "";
        } else {
            int IDKhachHang = BLL.BLLHoaDon.LayMaKhachHangString(cbbKhachHang.getSelectedItem().toString());           
            MaKhachHang = "idkhachhang like '"+String.valueOf(IDKhachHang)+"' and" ;
        }
        if (cbbNhanVien.getSelectedItem().equals("Tất Cả Nhân Viên")) {
            MaNhanVien = "";
        } else {
            int IDNhanVien = BLL.BLLHoaDon.LayMaNhanVienString(cbbNhanVien.getSelectedItem().toString());
            MaNhanVien = "idnguoidung like '"+String.valueOf(IDNhanVien)+"' and" ;
        }
        if (cbbLoaiPhieu.getSelectedItem().equals("Tất Cả Loại Phiếu")) {
            LoaiPhieu = "";
        } else {
            if (cbbLoaiPhieu.getSelectedItem().equals("Phiếu Thu")) {
                LoaiPhieu = "Phiếu Thu";
            } else {
                LoaiPhieu = "Phiếu Chi";
            }
        }
        if (cbbHangMuc.getSelectedItem().equals("Hạng Mục Thu Chi")) {
            HangMuc = "";
        } else {
            HangMuc =cbbHangMuc.getSelectedItem().toString();
        }

        BLL.BLLThuChi.HienThiPhieuThuChiLoc(tblThuChi, NhaCungCap, MaKhachHang, MaNhanVien, LoaiPhieu, HangMuc);
        if (tblThuChi.getRowCount() == 0) {
            ThongBaoCanhBao.ThongBao("Không tìm thấy phiếu thu chi phù hợp!", "Thông Báo");
        } else {
            ThongBaoCanhBao.ThongBao("Đã tìm thấy " + tblThuChi.getRowCount() + " phiếu thu chi phù hợp!", "Thông Báo");
            this.dispose();
        }
    }//GEN-LAST:event_btnLoc2ActionPerformed

    private void cbbNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNhaCungCapMouseClicked
        BLL.BLLThuChi.DoDuLieuVaoCBBTenNhaCungCapTC(cbbNhaCungCap);
        cbbKhachHang.removeAllItems();
        cbbKhachHang.addItem("Tất Cả Khách Hàng");
        cbbNhanVien.removeAllItems();
        cbbNhanVien.addItem("Tất Cả Nhân Viên");
    }//GEN-LAST:event_cbbNhaCungCapMouseClicked

    private void cbbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbKhachHangMouseClicked
        BLL.BLLThuChi.DoDuLieuVaoCBBTenKhachHangTC(cbbKhachHang);
        cbbNhaCungCap.removeAllItems();
        cbbNhaCungCap.addItem("Tất Cả Nhà Cung Cấp");
        cbbNhanVien.removeAllItems();
        cbbNhanVien.addItem("Tất Cả Nhân Viên");
    }//GEN-LAST:event_cbbKhachHangMouseClicked

    private void cbbNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNhanVienMouseClicked
        BLL.BLLThuChi.DoDuLieuVaoCBBTenNguoiDungTC(cbbNhanVien);
        cbbKhachHang.removeAllItems();
        cbbKhachHang.addItem("Tất Cả Khách Hàng");
        cbbNhaCungCap.removeAllItems();
        cbbNhaCungCap.addItem("Tất Cả Nhà Cung Cấp");
    }//GEN-LAST:event_cbbNhanVienMouseClicked

    private void cbbLoaiPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbLoaiPhieuMouseClicked
        cbbLoaiPhieu.removeAllItems();
        cbbLoaiPhieu.addItem("Phiếu Thu");
        cbbLoaiPhieu.addItem("Phiếu Chi");
    }//GEN-LAST:event_cbbLoaiPhieuMouseClicked

    private void cbbHangMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbHangMucMouseClicked
        BLL.BLLThuChi.DoCBBHangMuc(cbbHangMuc);
    }//GEN-LAST:event_cbbHangMucMouseClicked

    private void cbbNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNhanVienActionPerformed

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
            java.util.logging.Logger.getLogger(jdlLocThuChi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdlLocThuChi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdlLocThuChi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdlLocThuChi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdlLocThuChi dialog = new jdlLocThuChi(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnLoc1;
    private javax.swing.JButton btnLoc2;
    private javax.swing.JComboBox<String> cbbHangMuc;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JComboBox<String> cbbLoaiPhieu;
    private javax.swing.JComboBox<String> cbbNhaCungCap;
    private javax.swing.JComboBox<String> cbbNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
