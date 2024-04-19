/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fit.iuh.qlbhtt;

import fit.iuh.dao.INhanVienDao;
import fit.iuh.dao.ITaiKhoanDao;
import fit.iuh.entity.*;
import fit.iuh.util.RMIClientUtil;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author phant
 */
public class ManHinh_TimTaiKhoan extends javax.swing.JFrame {

    private INhanVienDao dao_NhanVien;
    private ITaiKhoanDao dao_TaiKhoan;
    public static NhanVien nhanVien = null;
    public static TaiKhoan taiKhoan = null;
    private boolean ngonNgu = Login.ngonNgu;

    /**
     * Creates new form ManHinh_TimTaiKhoan
     */
    public ManHinh_TimTaiKhoan() throws SQLException {
        dao_NhanVien = RMIClientUtil.getNhanVienDao();
        dao_TaiKhoan = RMIClientUtil.getTaiKhoanDao();

        initComponents();
        setLocationRelativeTo(null);
        if (!ngonNgu) {
            chuyenDoiNN();
        }
    }

    public void chuyenDoiNN() {
        lbl_TieuDeChinh.setText("SEARCH ACCOUNT");
        lbl_TieuDePhu.setText("Please enter email or phone number to find your account");
        btn_Huy.setText("Cancel");
        btn_TimKiem.setText("Search");
    }

    /**
     * Tìm kiếm tài khoản theo email hoặc sdt
     */
    public void xuLyTimKiemTaiKhoan() throws RemoteException {

        String timKiem = txt_TimKiem.getText();
        int count = 0;
        if (!timKiem.trim().equals("")) {
            for (NhanVien nv : dao_NhanVien.getAllNhanVien()) {
                if (nv.getEmail().equals(timKiem) || nv.getSdt().equals(timKiem)) {

                    nhanVien = dao_NhanVien.getNhanVienTheoMa(nv.getMaNV());
                    taiKhoan = dao_TaiKhoan.getTaiKhoanNV(nv.getMaNV());
                    new ManHinh_XacThucEmail().setVisible(true);
                    this.setVisible(false);
                    count++;
                }
            }
            if (count == 0) {
                JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại hoặc email để tìm!");

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

        lbl_panelChinh = new javax.swing.JPanel();
        lbl_TieuDeChinh = new javax.swing.JLabel();
        lbl_TieuDePhu = new javax.swing.JLabel();
        txt_TimKiem = new javax.swing.JTextField();
        btn_TimKiem = new javax.swing.JButton();
        btn_Huy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_panelChinh.setBackground(new java.awt.Color(208, 212, 202));

        lbl_TieuDeChinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_TieuDeChinh.setText("TÌM KIẾM TÀI KHOẢN");

        lbl_TieuDePhu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lbl_TieuDePhu.setText("Vui lòng nhập email hoặc số điện thoại để tìm tài khoản");

        txt_TimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btn_TimKiem.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("src/main/java/fit/iuh/imageGD/icons8-search-30.png"))); // NOI18N
        btn_TimKiem.setText("Tìm Kiếm");
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btn_TimKiemActionPerformed(evt);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btn_Huy.setBackground(new java.awt.Color(255, 153, 153));
        btn_Huy.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_Huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("src/main/java/fit/iuh/imageGD/icons8-cancel-30.png"))); // NOI18N
        btn_Huy.setText("Hủy");
        btn_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbl_panelChinhLayout = new javax.swing.GroupLayout(lbl_panelChinh);
        lbl_panelChinh.setLayout(lbl_panelChinhLayout);
        lbl_panelChinhLayout.setHorizontalGroup(
            lbl_panelChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_panelChinhLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(lbl_panelChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_TieuDePhu)
                    .addGroup(lbl_panelChinhLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(lbl_TieuDeChinh))
                    .addGroup(lbl_panelChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(lbl_panelChinhLayout.createSequentialGroup()
                            .addComponent(btn_Huy)
                            .addGap(26, 26, 26)
                            .addComponent(btn_TimKiem))
                        .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        lbl_panelChinhLayout.setVerticalGroup(
            lbl_panelChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_panelChinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_TieuDeChinh)
                .addGap(18, 18, 18)
                .addComponent(lbl_TieuDePhu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lbl_panelChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_panelChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_panelChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HuyActionPerformed
        try {
            new Login().setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(ManHinh_TimTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_HuyActionPerformed

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {//GEN-FIRST:event_btn_TimKiemActionPerformed
        xuLyTimKiemTaiKhoan();

    }//GEN-LAST:event_btn_TimKiemActionPerformed

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
            java.util.logging.Logger.getLogger(ManHinh_TimTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManHinh_TimTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManHinh_TimTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManHinh_TimTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManHinh_TimTaiKhoan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManHinh_TimTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Huy;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JLabel lbl_TieuDeChinh;
    private javax.swing.JLabel lbl_TieuDePhu;
    private javax.swing.JPanel lbl_panelChinh;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables
}
