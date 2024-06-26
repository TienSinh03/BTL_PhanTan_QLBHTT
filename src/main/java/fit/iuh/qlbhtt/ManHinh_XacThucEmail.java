/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fit.iuh.qlbhtt;

import fit.iuh.dao.impl.Dao_SendMail;
import fit.iuh.entity.*;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author phant
 */
public class ManHinh_XacThucEmail extends javax.swing.JFrame {

    private int otp;
    public static String emailAdd;
    private Dao_SendMail dao_sendmail;

    private final NhanVien nhanVien = ManHinh_TimTaiKhoan.nhanVien;
    private boolean ngonNgu = Login.ngonNgu;

    /**
     * Creates new form ManHinh_XacThucEmail
     */
    public ManHinh_XacThucEmail() {
        dao_sendmail = new Dao_SendMail();
        initComponents();
        setLocationRelativeTo(null);
        if (!ngonNgu) {
            chuyenDoiNN();
        }
        //Sự kiện lắng người người dùng nhập
        txt_nhapOTP.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                btn_XacThuc.setEnabled(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (txt_nhapOTP.getText().isEmpty()) {
                    btn_XacThuc.setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

        });
        loadDuLieu();
        hienThiNhanVienNghi();
    }

    public void chuyenDoiNN() {
        lbl_TieuDeChinh.setText("SEARCH ACCOUNT");
        btn_GuiMa.setText("Send Code");
        btn_XacThuc.setText("Verify");
        lbl_TenNV.setText("Employee name");
        lbl_Email.setText("Email");
        lbl_nhapOTP.setText("Enter OTP");
        lbl_DangNhap.setText("<html><u>Log in with password</u></html>");
    }

    public void hienThiNhanVienNghi() {
        if (!nhanVien.isTrangThai()) {
            if (ngonNgu) {
                lbl_thongBaoNghi.setText("Nhân viên này đã nghỉ, không được thực hiện xác thực");

            } else {
                lbl_thongBaoNghi.setText("This employee has retired and cannot be authenticatedc");

            }
            btn_GuiMa.setEnabled(false);
        }
    }

    /**
     * Load lên JtextField
     */
    public void loadDuLieu() {
        txt_TenNhanVien.setText(nhanVien.getHoTen());
        txt_Email.setText(nhanVien.getEmail());
    }

    /**
     * Xử lý gửi mã về gmail
     */
    public void xuLyGuiCode() {
        Random radom = new Random();
        int min = 100000;
        int max = 999999;
        otp = radom.nextInt(max - min) + min;
        emailAdd = txt_Email.getText();
        dao_sendmail.sendEmailMa(emailAdd, "Email Verification", "Mã OTP của bạn: " + Integer.toString(otp));
        JOptionPane.showMessageDialog(this, "Mã đã được gửi qua email, vui lòng kiểm tra");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_NenChinh = new javax.swing.JPanel();
        lbl_TenNV = new javax.swing.JLabel();
        txt_TenNhanVien = new javax.swing.JTextField();
        lbl_Email = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        lbl_nhapOTP = new javax.swing.JLabel();
        btn_GuiMa = new javax.swing.JButton();
        btn_XacThuc = new javax.swing.JButton();
        lbl_TieuDeChinh = new javax.swing.JLabel();
        lbl_DangNhap = new javax.swing.JLabel();
        txt_nhapOTP = new javax.swing.JTextField();
        lbl_thongBaoNghi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_NenChinh.setBackground(new java.awt.Color(208, 212, 202));

        lbl_TenNV.setBackground(new java.awt.Color(208, 212, 202));
        lbl_TenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_TenNV.setText("Tên nhân viên:");

        txt_TenNhanVien.setEditable(false);
        txt_TenNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        lbl_Email.setBackground(new java.awt.Color(208, 212, 202));
        lbl_Email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Email.setText("Địa chỉ Email:");

        txt_Email.setEditable(false);
        txt_Email.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        lbl_nhapOTP.setBackground(new java.awt.Color(208, 212, 202));
        lbl_nhapOTP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_nhapOTP.setText("Nhập OTP:");

        btn_GuiMa.setBackground(new java.awt.Color(97, 103, 122));
        btn_GuiMa.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_GuiMa.setForeground(new java.awt.Color(255, 255, 255));
        btn_GuiMa.setIcon(new javax.swing.ImageIcon(getClass().getResource("src/main/java/fit/iuh/imageGD/icons8-send-30.png"))); // NOI18N
        btn_GuiMa.setText("Gửi Mã");
        btn_GuiMa.setBorder(null);
        btn_GuiMa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_GuiMaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_GuiMaMouseExited(evt);
            }
        });
        btn_GuiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuiMaActionPerformed(evt);
            }
        });

        btn_XacThuc.setBackground(new java.awt.Color(58, 193, 80));
        btn_XacThuc.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_XacThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("src/main/java/fit/iuh/imageGD/icons8-verify-30.png"))); // NOI18N
        btn_XacThuc.setText("Xác thực");
        btn_XacThuc.setBorder(null);
        btn_XacThuc.setEnabled(false);
        btn_XacThuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_XacThucMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_XacThucMouseExited(evt);
            }
        });
        btn_XacThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XacThucActionPerformed(evt);
            }
        });

        lbl_TieuDeChinh.setBackground(new java.awt.Color(208, 212, 202));
        lbl_TieuDeChinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_TieuDeChinh.setText("XÁC THỰC TÀI KHOẢN");

        lbl_DangNhap.setBackground(new java.awt.Color(208, 212, 202));
        lbl_DangNhap.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbl_DangNhap.setForeground(new java.awt.Color(0, 0, 51));
        lbl_DangNhap.setText("<html><u>Đăng nhập bằng mật khẩu</u></html>");
        lbl_DangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_DangNhapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_DangNhapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_DangNhapMouseExited(evt);
            }
        });

        txt_nhapOTP.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        lbl_thongBaoNghi.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout pnl_NenChinhLayout = new javax.swing.GroupLayout(pnl_NenChinh);
        pnl_NenChinh.setLayout(pnl_NenChinhLayout);
        pnl_NenChinhLayout.setHorizontalGroup(
            pnl_NenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_NenChinhLayout.createSequentialGroup()
                .addGroup(pnl_NenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_NenChinhLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnl_NenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_nhapOTP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_TenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(pnl_NenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_NenChinhLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txt_TenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_NenChinhLayout.createSequentialGroup()
                                .addGroup(pnl_NenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nhapOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_thongBaoNghi))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnl_NenChinhLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(lbl_TieuDeChinh))
                    .addGroup(pnl_NenChinhLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_NenChinhLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_Email)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(pnl_NenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_GuiMa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_XacThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        pnl_NenChinhLayout.setVerticalGroup(
            pnl_NenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_NenChinhLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbl_TieuDeChinh)
                .addGroup(pnl_NenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_NenChinhLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lbl_TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_NenChinhLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(txt_TenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_thongBaoNghi)
                .addGap(18, 18, 18)
                .addGroup(pnl_NenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_NenChinhLayout.createSequentialGroup()
                        .addGroup(pnl_NenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(pnl_NenChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nhapOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nhapOTP, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_NenChinhLayout.createSequentialGroup()
                        .addComponent(btn_GuiMa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_XacThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(lbl_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_NenChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnl_NenChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GuiMaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GuiMaMouseEntered

        btn_GuiMa.setBackground(new Color(0x9EDDFF));
        btn_GuiMa.setForeground(new Color(0x141E46));
    }//GEN-LAST:event_btn_GuiMaMouseEntered

    private void btn_GuiMaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GuiMaMouseExited

        btn_GuiMa.setBackground(new Color(0x61677A));
        btn_GuiMa.setForeground(new Color(0x141E46));
    }//GEN-LAST:event_btn_GuiMaMouseExited

    private void btn_GuiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuiMaActionPerformed
        xuLyGuiCode();
    }//GEN-LAST:event_btn_GuiMaActionPerformed

    private void btn_XacThucMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XacThucMouseEntered
        if (btn_XacThuc.isEnabled()) {
            btn_XacThuc.setBackground(new Color(0x9EDDFF));
            btn_XacThuc.setForeground(new Color(0x141E46));
        }
    }//GEN-LAST:event_btn_XacThucMouseEntered

    private void btn_XacThucMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XacThucMouseExited
        if (btn_XacThuc.isEnabled()) {
            btn_XacThuc.setBackground(new Color(0x009933));
            btn_XacThuc.setForeground(new Color(0x000000));

        }

    }//GEN-LAST:event_btn_XacThucMouseExited

    private void btn_XacThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XacThucActionPerformed
        int otp2 = Integer.parseInt(txt_nhapOTP.getText());
        if (otp == otp2) {
            JOptionPane.showMessageDialog(this, "Xác thực thành công");
            try {
                new ManHinh_DatLaiMatKhau().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ManHinh_XacThucEmail.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra mã code và nhập lại!!");
            txt_nhapOTP.setText("");
        }
    }//GEN-LAST:event_btn_XacThucActionPerformed

    private void lbl_DangNhapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DangNhapMouseEntered
        lbl_DangNhap.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Thay đổi hình dạng chuột
        lbl_DangNhap.setForeground(new Color(0x0099FF));
    }//GEN-LAST:event_lbl_DangNhapMouseEntered

    private void lbl_DangNhapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DangNhapMouseExited
        lbl_DangNhap.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        lbl_DangNhap.setForeground(new Color(0x000033));
    }//GEN-LAST:event_lbl_DangNhapMouseExited

    private void lbl_DangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_DangNhapMouseClicked
        try {
            new Login().setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(ManHinh_XacThucEmail.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lbl_DangNhapMouseClicked

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
            java.util.logging.Logger.getLogger(ManHinh_XacThucEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManHinh_XacThucEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManHinh_XacThucEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManHinh_XacThucEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManHinh_XacThucEmail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_GuiMa;
    private javax.swing.JButton btn_XacThuc;
    private javax.swing.JLabel lbl_DangNhap;
    private javax.swing.JLabel lbl_Email;
    private javax.swing.JLabel lbl_TenNV;
    private javax.swing.JLabel lbl_TieuDeChinh;
    private javax.swing.JLabel lbl_nhapOTP;
    private javax.swing.JLabel lbl_thongBaoNghi;
    private javax.swing.JPanel pnl_NenChinh;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_TenNhanVien;
    private javax.swing.JTextField txt_nhapOTP;
    // End of variables declaration//GEN-END:variables
}
