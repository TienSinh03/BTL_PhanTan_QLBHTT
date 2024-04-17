/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fit.iuh.qlbhtt;


import fit.iuh.connectDB.Connect;
import fit.iuh.dao.impl.Dao_NhaCungCap;
import fit.iuh.entity.NhaCungCap;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 * @author DMX
 */
public class ManHinh_NCC_TimKiem extends javax.swing.JPanel {
    private DefaultTableModel modelNhaCungCap;
    private Dao_NhaCungCap daoNhaCungCap;
    private Connect connect;

    /**
     * Creates new form quanly
     */
    public ManHinh_NCC_TimKiem() throws SQLException {
        daoNhaCungCap = new Dao_NhaCungCap();
        connect = new Connect();
//        connect.connect();
        initComponents();

        tbl_NhaCungCap.setDefaultEditor(Object.class, null); //Không cho chỉnh sửa cột
        tbl_NhaCungCap.getTableHeader().setReorderingAllowed(false); //Không cho di chuyển cột

//      Lần đầu chạy chương trình, load dữ liệu vào bảng
        docDuLieuNhaCungCap();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_DanhSachNCC = new javax.swing.JPanel();
        scr_DanhSachNCC = new javax.swing.JScrollPane();
        tbl_NhaCungCap = new javax.swing.JTable();
        pnl_NCC_TimKiem = new javax.swing.JPanel();
        lbl_TieuDe = new javax.swing.JLabel();
        pnl_ThongTin = new javax.swing.JPanel();
        txt_TenNCC = new javax.swing.JTextField();
        txt_MaNCC = new javax.swing.JTextField();
        lbl_MaNCC = new javax.swing.JLabel();
        lbl_TenNCC = new javax.swing.JLabel();
        lbl_DiaChi = new javax.swing.JLabel();
        lbl_SoDienThoai = new javax.swing.JLabel();
        lbl_Email = new javax.swing.JLabel();
        txt_SoDienThoai = new javax.swing.JTextField();
        txt_Email = new javax.swing.JTextField();
        txt_DiaChi = new javax.swing.JTextField();
        pnl_NutChucNang = new javax.swing.JPanel();
        btn_TimKiem = new javax.swing.JButton();
        btn_XoaTrang = new javax.swing.JButton();

        setBackground(new java.awt.Color(199, 210, 213));
        setMinimumSize(new java.awt.Dimension(1000, 550));
        setPreferredSize(new java.awt.Dimension(1000, 550));

        scr_DanhSachNCC.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhà cung cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbl_NhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_NhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Mã nhà cung cấp", "Tên nhà cung cấp", "SDT", "Email", "Địa chỉ"
                }
        ) {
            Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        tbl_NhaCungCap.setRowHeight(35);
        tbl_NhaCungCap.setShowGrid(true);
        tbl_NhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NhaCungCapMouseClicked(evt);
            }
        });
        scr_DanhSachNCC.setViewportView(tbl_NhaCungCap);

        lbl_TieuDe.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        lbl_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TieuDe.setText("TÌM KIẾM NHÀ CUNG CẤP");
        lbl_TieuDe.setMaximumSize(new java.awt.Dimension(32767, 32767));
        lbl_TieuDe.setPreferredSize(new java.awt.Dimension(181, 40));

        javax.swing.GroupLayout pnl_NCC_TimKiemLayout = new javax.swing.GroupLayout(pnl_NCC_TimKiem);
        pnl_NCC_TimKiem.setLayout(pnl_NCC_TimKiemLayout);
        pnl_NCC_TimKiemLayout.setHorizontalGroup(
                pnl_NCC_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_NCC_TimKiemLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        pnl_NCC_TimKiemLayout.setVerticalGroup(
                pnl_NCC_TimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_DanhSachNCCLayout = new javax.swing.GroupLayout(pnl_DanhSachNCC);
        pnl_DanhSachNCC.setLayout(pnl_DanhSachNCCLayout);
        pnl_DanhSachNCCLayout.setHorizontalGroup(
                pnl_DanhSachNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scr_DanhSachNCC)
                        .addComponent(pnl_NCC_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_DanhSachNCCLayout.setVerticalGroup(
                pnl_DanhSachNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_DanhSachNCCLayout.createSequentialGroup()
                                .addComponent(pnl_NCC_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scr_DanhSachNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
        );

        pnl_ThongTin.setBackground(new java.awt.Color(199, 210, 213));
        pnl_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhà cung cấp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txt_TenNCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_MaNCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbl_MaNCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_MaNCC.setText("Mã nhà cung cấp");

        lbl_TenNCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_TenNCC.setText("Tên nhà cung cấp");

        lbl_DiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_DiaChi.setText("Địa chỉ");

        lbl_SoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_SoDienThoai.setText("Số điện thoại");

        lbl_Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Email.setText("Email");

        txt_SoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_DiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnl_ThongTinLayout = new javax.swing.GroupLayout(pnl_ThongTin);
        pnl_ThongTin.setLayout(pnl_ThongTinLayout);
        pnl_ThongTinLayout.setHorizontalGroup(
                pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_ThongTinLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_MaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_TenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_MaNCC)
                                        .addComponent(lbl_TenNCC))
                                .addGap(50, 50, 50)
                                .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnl_ThongTinLayout.createSequentialGroup()
                                                .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbl_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbl_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(50, 50, 50)
                                                .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbl_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_ThongTinLayout.setVerticalGroup(
                pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_ThongTinLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_MaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_MaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_TenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_TenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(171, Short.MAX_VALUE))
        );

        pnl_NutChucNang.setBackground(new java.awt.Color(199, 210, 213));
        pnl_NutChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btn_TimKiem.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btn_TimKiem.setIcon(new javax.swing.ImageIcon("src/main/java/fit/iuh/imageGD/icons8-search-30.png")); // NOI18N
        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.setBorder(null);
        btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_TimKiemMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_TimKiemMouseExited(evt);
            }
        });
        btn_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiemActionPerformed(evt);
            }
        });

        btn_XoaTrang.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btn_XoaTrang.setIcon(new javax.swing.ImageIcon("src/main/java/fit/iuh/imageGD/icons8-delete-30.png")); // NOI18N
        btn_XoaTrang.setText("Xóa Trắng");
        btn_XoaTrang.setBorder(null);
        btn_XoaTrang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_XoaTrangMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_XoaTrangMouseExited(evt);
            }
        });
        btn_XoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaTrangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_NutChucNangLayout = new javax.swing.GroupLayout(pnl_NutChucNang);
        pnl_NutChucNang.setLayout(pnl_NutChucNangLayout);
        pnl_NutChucNangLayout.setHorizontalGroup(
                pnl_NutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_NutChucNangLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnl_NutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btn_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_XoaTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                                .addContainerGap(89, Short.MAX_VALUE))
        );
        pnl_NutChucNangLayout.setVerticalGroup(
                pnl_NutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_NutChucNangLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btn_XoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(pnl_DanhSachNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnl_ThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl_NutChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnl_DanhSachNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pnl_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(pnl_NutChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiemActionPerformed
        xuLyTimKiemNhaCungCap();
    }//GEN-LAST:event_btn_TimKiemActionPerformed

    private void btn_TimKiemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseEntered
        btn_TimKiem.setBackground(new Color(0x9EDDFF));
        btn_TimKiem.setForeground(new Color(0x141E46));
    }//GEN-LAST:event_btn_TimKiemMouseEntered

    private void btn_TimKiemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseExited
        btn_TimKiem.setBackground(UIManager.getColor("Menu.background"));
        btn_TimKiem.setForeground(UIManager.getColor("Menu.foreground"));
    }//GEN-LAST:event_btn_TimKiemMouseExited

    private void btn_XoaTrangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaTrangMouseEntered
        btn_XoaTrang.setBackground(new Color(0x9EDDFF));
        btn_XoaTrang.setForeground(new Color(0x141E46));
    }//GEN-LAST:event_btn_XoaTrangMouseEntered

    private void btn_XoaTrangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaTrangMouseExited
        btn_XoaTrang.setBackground(UIManager.getColor("Menu.background"));
        btn_XoaTrang.setForeground(UIManager.getColor("Menu.foreground"));
    }//GEN-LAST:event_btn_XoaTrangMouseExited

    private void btn_XoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaTrangActionPerformed
        xoaTrangTxt();
        docDuLieuNhaCungCap();
    }//GEN-LAST:event_btn_XoaTrangActionPerformed

    private void tbl_NhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhaCungCapMouseClicked
        int row = tbl_NhaCungCap.getSelectedRow();
        if (row != -1) {
            txt_MaNCC.setText(tbl_NhaCungCap.getValueAt(row, 0).toString());
            txt_TenNCC.setText(tbl_NhaCungCap.getValueAt(row, 1).toString());
            txt_SoDienThoai.setText(tbl_NhaCungCap.getValueAt(row, 2).toString());
            txt_Email.setText(tbl_NhaCungCap.getValueAt(row, 3).toString());
            txt_DiaChi.setText(tbl_NhaCungCap.getValueAt(row, 4).toString());
        }
    }//GEN-LAST:event_tbl_NhaCungCapMouseClicked

    /**
     * Xóa trắng các Jtext filed
     */
    public void xoaTrangTxt() {
        txt_TenNCC.setText("");
        txt_DiaChi.setText("");
        txt_SoDienThoai.setText("");
        txt_Email.setText("");
        txt_MaNCC.setText("");
        xoaDongBang();
    }

    /**
     * Xóa các dòng trong table
     */
    public void xoaDongBang() {
        modelNhaCungCap = (DefaultTableModel) tbl_NhaCungCap.getModel();
        modelNhaCungCap.setRowCount(0);
    }

    /**
     * Load dữ liệu vào bảng
     */
    public void docDuLieuNhaCungCap() {
        xoaDongBang();
        modelNhaCungCap = (DefaultTableModel) tbl_NhaCungCap.getModel();
        for (NhaCungCap ncc : daoNhaCungCap.getAllNhaCungCap()) {
            Object[] object = new Object[5];
            object[0] = ncc.getMaNCC();
            object[1] = ncc.getTenNCC();
            object[2] = ncc.getSdt();
            object[3] = ncc.getEmail();
            object[4] = ncc.getDiaChi();
            modelNhaCungCap.addRow(object);
        }
    }

    /**
     * Xử lý tìm kiếm nhà cung cấp theo các tiêu chí
     */
    public void xuLyTimKiemNhaCungCap() {
        String msConvert = null;
        if (txt_MaNCC.getText().equals("")) {
            msConvert = "0";
        } else {
            msConvert = txt_MaNCC.getText();
        }
        long tuKhoaMaNCC = Long.parseLong(msConvert);
        String tuKhoaTenNCC = txt_TenNCC.getText();
        String tuKhoaSdt = txt_SoDienThoai.getText();
        String tuKhoaEmail = txt_Email.getText();

        List<NhaCungCap> list = daoNhaCungCap.timKiemNhaCungCap(tuKhoaMaNCC, tuKhoaTenNCC, tuKhoaSdt, tuKhoaEmail);
        modelNhaCungCap = (DefaultTableModel) tbl_NhaCungCap.getModel();
        if (list != null) {
            for (NhaCungCap ncc : list) {
                xoaDongBang();
                Object[] object = new Object[5];
                object[0] = ncc.getMaNCC();
                object[1] = ncc.getTenNCC();
                object[2] = ncc.getSdt();
                object[3] = ncc.getEmail();
                object[4] = ncc.getDiaChi();
                modelNhaCungCap.addRow(object);
                JOptionPane.showMessageDialog(this, "Tìm thấy");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy");
        }
        xoaTrangTxt();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.JButton btn_XoaTrang;
    private javax.swing.JLabel lbl_DiaChi;
    private javax.swing.JLabel lbl_Email;
    private javax.swing.JLabel lbl_MaNCC;
    private javax.swing.JLabel lbl_SoDienThoai;
    private javax.swing.JLabel lbl_TenNCC;
    private javax.swing.JLabel lbl_TieuDe;
    private javax.swing.JPanel pnl_DanhSachNCC;
    private javax.swing.JPanel pnl_NCC_TimKiem;
    private javax.swing.JPanel pnl_NutChucNang;
    private javax.swing.JPanel pnl_ThongTin;
    private javax.swing.JScrollPane scr_DanhSachNCC;
    private javax.swing.JTable tbl_NhaCungCap;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_MaNCC;
    private javax.swing.JTextField txt_SoDienThoai;
    private javax.swing.JTextField txt_TenNCC;
    // End of variables declaration//GEN-END:variables
}
