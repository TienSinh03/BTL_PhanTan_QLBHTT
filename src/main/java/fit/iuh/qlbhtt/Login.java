/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fit.iuh.qlbhtt;

import fit.iuh.connectDB.Connect;
import fit.iuh.dao.*;
import fit.iuh.dao.impl.*;
import fit.iuh.entity.*;
import java.awt.Cursor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author DMX
 */
public class Login extends javax.swing.JFrame {

    private final Dao_TaiKhoan daoTaiKhoan;
    private final Dao_NhanVien daoNhanVien;
    private final Connect connect;
    private Boolean hoatDongIconShow = true;
    private Boolean hoatDongIconClose = true;
    public static NhanVien nhanVien = null;

    public static boolean ngonNgu = true;

    /**
     * Creates new form Login
     */
    public Login() throws SQLException {
        daoNhanVien = new Dao_NhanVien();
        daoTaiKhoan = new Dao_TaiKhoan();
        connect = new Connect();
        connect.connect();

        setTitle("Quản Lý Bán Quần Áo Thời Trang");
        initComponents();
        setLocationRelativeTo(null);
    this.getRootPane().setDefaultButton(btn_Login);
    }

    public void chuyenDoiNN_English() {
        btn_Login.setText("Login");
        lbl_Password.setText("Passowrd");
        lbl_TaiKhoan.setText("User");
        lbl_QuenMatKhau.setText("Forgot password?");
        lbl_Title.setText("Login");
    }

    public void chuyenDoiNN_TV() {
        btn_Login.setText("Đăng nhập");
        lbl_Password.setText("Mật khẩu");
        lbl_TaiKhoan.setText("Tài khoản");
        lbl_QuenMatKhau.setText("Quên mật khẩu?");
        lbl_Title.setText("Đăng nhập");
    }

    public void xuLyDangNhap() {
        String user = txt_Username.getText();
        String pass = String.valueOf(pwd_MatKhau.getText());
        if (!user.trim().equals("") || !pass.trim().equals("")) {
            TaiKhoan taiKhoan = daoTaiKhoan.dangNhapTaiKhoan(user, pass);

            if (taiKhoan != null) {
                nhanVien = daoNhanVien.getNhanVienTheoMa(taiKhoan.getNhanVien().getMaNV());
                try {
                    HomePage homePage = new HomePage();
                    homePage.setVisible(true);
                    this.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản này không tồn tại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập dữ liệu bắt buộc!");

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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        pnl_ManHinhDangNhap = new javax.swing.JPanel();
        pnl_FormDangNhap = new javax.swing.JPanel();
        txt_Username = new javax.swing.JTextField();
        btn_Login = new javax.swing.JButton();
        lbl_Password = new javax.swing.JLabel();
        lbl_Title = new javax.swing.JLabel();
        lbl_TaiKhoan = new javax.swing.JLabel();
        pwd_MatKhau = new javax.swing.JPasswordField();
        lbl_IconPWClose = new javax.swing.JLabel();
        lbl_IconUser = new javax.swing.JLabel();
        lbl_QuenMatKhau = new javax.swing.JLabel();
        cmb_NgonNgu = new javax.swing.JComboBox<>();
        lbl_ImageLogin = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(970, 521));

        pnl_ManHinhDangNhap.setMaximumSize(new java.awt.Dimension(870, 521));
        pnl_ManHinhDangNhap.setMinimumSize(new java.awt.Dimension(870, 521));

        pnl_FormDangNhap.setBackground(new java.awt.Color(208, 212, 202));

        txt_Username.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        txt_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UsernameActionPerformed(evt);
            }
        });

        btn_Login.setBackground(new java.awt.Color(97, 103, 122));
        btn_Login.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_Login.setForeground(new java.awt.Color(242, 242, 242));
        btn_Login.setText("Đăng nhập");
        btn_Login.setBorder(null);
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });
        btn_Login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_LoginKeyPressed(evt);
            }
        });

        lbl_Password.setBackground(new java.awt.Color(216, 217, 218));
        lbl_Password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Password.setForeground(new java.awt.Color(97, 103, 122));
        lbl_Password.setText("Mật khẩu");

        lbl_Title.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        lbl_Title.setForeground(new java.awt.Color(97, 103, 122));
        lbl_Title.setText("Đăng nhập");

        lbl_TaiKhoan.setBackground(new java.awt.Color(216, 217, 218));
        lbl_TaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_TaiKhoan.setForeground(new java.awt.Color(97, 103, 122));
        lbl_TaiKhoan.setText("Tài khoản");

        pwd_MatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwd_MatKhauActionPerformed(evt);
            }
        });

        lbl_IconPWClose.setIcon(new javax.swing.ImageIcon("src/main/java/fit/iuh/imageGD/icons8-password-30-1.png")); // NOI18N
        lbl_IconPWClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_IconPWCloseMouseClicked(evt);
            }
        });

        lbl_IconUser.setIcon(new javax.swing.ImageIcon("src/main/java/fit/iuh/imageGD/icons8-user-30.png")); // NOI18N
        lbl_IconUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_IconUserMouseClicked(evt);
            }
        });

        lbl_QuenMatKhau.setBackground(new java.awt.Color(208, 212, 202));
        lbl_QuenMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_QuenMatKhau.setForeground(new java.awt.Color(51, 0, 51));
        lbl_QuenMatKhau.setText("Quên mật khẩu?");
        lbl_QuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_QuenMatKhauMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_QuenMatKhauMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_QuenMatKhauMouseExited(evt);
            }
        });

        cmb_NgonNgu.setBackground(new java.awt.Color(204, 255, 255));
        cmb_NgonNgu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmb_NgonNgu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiếng Việt", "English" }));
        cmb_NgonNgu.setBorder(null);
        cmb_NgonNgu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_NgonNguItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnl_FormDangNhapLayout = new javax.swing.GroupLayout(pnl_FormDangNhap);
        pnl_FormDangNhap.setLayout(pnl_FormDangNhapLayout);
        pnl_FormDangNhapLayout.setHorizontalGroup(
            pnl_FormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_FormDangNhapLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnl_FormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_FormDangNhapLayout.createSequentialGroup()
                        .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_IconUser))
                    .addGroup(pnl_FormDangNhapLayout.createSequentialGroup()
                        .addGroup(pnl_FormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_QuenMatKhau)
                            .addComponent(pwd_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_IconPWClose))
                    .addComponent(lbl_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_FormDangNhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_FormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_FormDangNhapLayout.createSequentialGroup()
                        .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_FormDangNhapLayout.createSequentialGroup()
                        .addComponent(lbl_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_FormDangNhapLayout.createSequentialGroup()
                        .addComponent(cmb_NgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );
        pnl_FormDangNhapLayout.setVerticalGroup(
            pnl_FormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_FormDangNhapLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lbl_Title, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbl_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_FormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_IconUser))
                .addGap(18, 18, 18)
                .addComponent(lbl_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_FormDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pwd_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_IconPWClose))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_QuenMatKhau)
                .addGap(17, 17, 17)
                .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(cmb_NgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

//        lbl_ImageLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("src/main/java/fit/iuh/imageGD/Login1.jpg"))); // NOI18N
        lbl_ImageLogin.setIcon(new javax.swing.ImageIcon("src/main/java/fit/iuh/imageGD/Login1.jpg")); // NOI18N

        javax.swing.GroupLayout pnl_ManHinhDangNhapLayout = new javax.swing.GroupLayout(pnl_ManHinhDangNhap);
        pnl_ManHinhDangNhap.setLayout(pnl_ManHinhDangNhapLayout);
        pnl_ManHinhDangNhapLayout.setHorizontalGroup(
            pnl_ManHinhDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ManHinhDangNhapLayout.createSequentialGroup()
                .addComponent(lbl_ImageLogin)
                .addGap(0, 0, 0)
                .addComponent(pnl_FormDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnl_ManHinhDangNhapLayout.setVerticalGroup(
            pnl_ManHinhDangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_FormDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbl_ImageLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_ManHinhDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_ManHinhDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UsernameActionPerformed

    private void pwd_MatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwd_MatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwd_MatKhauActionPerformed

    private void lbl_IconPWCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_IconPWCloseMouseClicked

        if (hoatDongIconShow) {
//            lbl_IconPWClose.setIcon(new ImageIcon(getClass().getResource("src/main/java/fit/iuh/imageGD/icons8-show-password-30.png")));
            pwd_MatKhau.setEchoChar((char) 0);
            hoatDongIconShow = false;
        } else if (hoatDongIconClose) {
            pwd_MatKhau.setEchoChar('*');
//            lbl_IconPWClose.setIcon(new ImageIcon(getClass().getResource("src/main/java/fit/iuh/imageGD/icons8-password-30-1.png")));
            hoatDongIconShow = true;
        }
    }//GEN-LAST:event_lbl_IconPWCloseMouseClicked

    private void lbl_IconUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_IconUserMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_IconUserMouseClicked

    private void lbl_QuenMatKhauMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_QuenMatKhauMouseEntered
        lbl_QuenMatKhau.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lbl_QuenMatKhauMouseEntered

    private void lbl_QuenMatKhauMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_QuenMatKhauMouseExited
        lbl_QuenMatKhau.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lbl_QuenMatKhauMouseExited

    private void lbl_QuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_QuenMatKhauMouseClicked
        try {
            new ManHinh_TimTaiKhoan().setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lbl_QuenMatKhauMouseClicked

    private void cmb_NgonNguItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_NgonNguItemStateChanged
        if (cmb_NgonNgu.getSelectedItem().equals("English")) {
            ngonNgu = false;
            chuyenDoiNN_English();
        } else {
            ngonNgu = true;
            chuyenDoiNN_TV();
        }
    }//GEN-LAST:event_cmb_NgonNguItemStateChanged

    private void btn_LoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_LoginKeyPressed
        if(evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            xuLyDangNhap();
        }
    }//GEN-LAST:event_btn_LoginKeyPressed

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        xuLyDangNhap();
    }//GEN-LAST:event_btn_LoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Login;
    private javax.swing.JComboBox<String> cmb_NgonNgu;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lbl_IconPWClose;
    private javax.swing.JLabel lbl_IconUser;
    private javax.swing.JLabel lbl_ImageLogin;

    private javax.swing.JLabel lbl_Password;
    private javax.swing.JLabel lbl_QuenMatKhau;
    private javax.swing.JLabel lbl_TaiKhoan;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JPanel pnl_FormDangNhap;
    private javax.swing.JPanel pnl_ManHinhDangNhap;
    private javax.swing.JPasswordField pwd_MatKhau;
    private javax.swing.JTextField txt_Username;
    // End of variables declaration//GEN-END:variables
}
