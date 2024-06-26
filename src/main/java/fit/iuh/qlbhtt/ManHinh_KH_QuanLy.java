/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package fit.iuh.qlbhtt;


import fit.iuh.dao.impl.Dao_KhachHang;
import fit.iuh.entity.*;
import fit.iuh.connectDB.Connect;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
/**
 *
 * @author DMX
 */
public class ManHinh_KH_QuanLy extends javax.swing.JPanel {
    private Dao_KhachHang dao_KhachHang;
    private DefaultTableModel modelKhachHang;
    private Connect connect;
    private boolean kiemTraThem=false;
    private boolean kiemTraCapNhat=false;
    
    /**
     * Creates new form quanly
     */
    public ManHinh_KH_QuanLy() throws SQLException {
        dao_KhachHang = new Dao_KhachHang();
//        connect = new Connect();
//        connect.connect();
        initComponents();
        tbl_KhachHang.setDefaultEditor(Object.class, null); //Không cho chỉnh sửa cột
        tbl_KhachHang.getTableHeader().setReorderingAllowed(false); //Không cho di chuyển cột
        docDuLieuKhachHang();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnl_DanhSachKhachHang = new javax.swing.JPanel();
        scr_DanhSachKhachHang = new javax.swing.JScrollPane();
        tbl_KhachHang = new javax.swing.JTable();
        pnl_KH_TieuDe = new javax.swing.JPanel();
        lbl_TieuDe = new javax.swing.JLabel();
        pnl_ThongTin = new javax.swing.JPanel();
        txt_TenKH = new javax.swing.JTextField();
        txt_MaKH = new javax.swing.JTextField();
        lbl_MaKH = new javax.swing.JLabel();
        lbl_TenKH = new javax.swing.JLabel();
        lbl_GioiTinh = new javax.swing.JLabel();
        lbl_SoDienThoai = new javax.swing.JLabel();
        lbl_Email = new javax.swing.JLabel();
        rad_Nam = new javax.swing.JRadioButton();
        rad_Nu = new javax.swing.JRadioButton();
        txt_SoDienThoai = new javax.swing.JTextField();
        txt_Email = new javax.swing.JTextField();
        pnl_NutChucNang = new javax.swing.JPanel();
        btn_Them = new javax.swing.JButton();
        btn_CapNhat = new javax.swing.JButton();
        btn_Luu = new javax.swing.JButton();
        btn_XoaTrang = new javax.swing.JButton();
        btn_TaoNgauNhien = new javax.swing.JButton();

        setBackground(new java.awt.Color(199, 210, 213));
        setMinimumSize(new java.awt.Dimension(1000, 550));
        setPreferredSize(new java.awt.Dimension(1000, 550));

        pnl_DanhSachKhachHang.setPreferredSize(new java.awt.Dimension(2000, 324));
        pnl_DanhSachKhachHang.setVerifyInputWhenFocusTarget(false);

        scr_DanhSachKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbl_KhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Họ tên", "Giới tính", "Email", "SDT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_KhachHang.setMaximumSize(new java.awt.Dimension(2147483647, 196));
        tbl_KhachHang.setPreferredSize(new java.awt.Dimension(750, 600));
        tbl_KhachHang.setRowHeight(35);
        tbl_KhachHang.setShowGrid(true);
        tbl_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhachHangMouseClicked(evt);
            }
        });
        scr_DanhSachKhachHang.setViewportView(tbl_KhachHang);

        lbl_TieuDe.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        lbl_TieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_TieuDe.setText("QUẢN LÝ KHÁCH HÀNG");
        lbl_TieuDe.setMaximumSize(new java.awt.Dimension(32767, 32767));
        lbl_TieuDe.setPreferredSize(new java.awt.Dimension(181, 40));

        javax.swing.GroupLayout pnl_KH_TieuDeLayout = new javax.swing.GroupLayout(pnl_KH_TieuDe);
        pnl_KH_TieuDe.setLayout(pnl_KH_TieuDeLayout);
        pnl_KH_TieuDeLayout.setHorizontalGroup(
            pnl_KH_TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_KH_TieuDeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        pnl_KH_TieuDeLayout.setVerticalGroup(
            pnl_KH_TieuDeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_DanhSachKhachHangLayout = new javax.swing.GroupLayout(pnl_DanhSachKhachHang);
        pnl_DanhSachKhachHang.setLayout(pnl_DanhSachKhachHangLayout);
        pnl_DanhSachKhachHangLayout.setHorizontalGroup(
            pnl_DanhSachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_KH_TieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scr_DanhSachKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 1113, Short.MAX_VALUE)
        );
        pnl_DanhSachKhachHangLayout.setVerticalGroup(
            pnl_DanhSachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_DanhSachKhachHangLayout.createSequentialGroup()
                .addComponent(pnl_KH_TieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scr_DanhSachKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
        );

        pnl_ThongTin.setBackground(new java.awt.Color(199, 210, 213));
        pnl_ThongTin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnl_ThongTin.setPreferredSize(new java.awt.Dimension(945, 285));

        txt_TenKH.setEditable(false);
        txt_TenKH.setMinimumSize(new java.awt.Dimension(64, 30));
        txt_TenKH.setPreferredSize(new java.awt.Dimension(64, 30));

        txt_MaKH.setEditable(false);
        txt_MaKH.setMinimumSize(new java.awt.Dimension(64, 30));
        txt_MaKH.setPreferredSize(new java.awt.Dimension(64, 30));

        lbl_MaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_MaKH.setText("Mã khách hàng");

        lbl_TenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_TenKH.setText("Tên khách hàng");

        lbl_GioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_GioiTinh.setText("Giới tính");

        lbl_SoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_SoDienThoai.setText("Số điện thoại");

        lbl_Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Email.setText("Email");

        rad_Nam.setBackground(new java.awt.Color(199, 210, 213));
        buttonGroup1.add(rad_Nam);
        rad_Nam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rad_Nam.setForeground(new java.awt.Color(242, 242, 242));
        rad_Nam.setSelected(true);
        rad_Nam.setText("Nam");
        rad_Nam.setEnabled(false);

        rad_Nu.setBackground(new java.awt.Color(199, 210, 213));
        buttonGroup1.add(rad_Nu);
        rad_Nu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rad_Nu.setForeground(new java.awt.Color(242, 242, 242));
        rad_Nu.setText("Nữ");
        rad_Nu.setEnabled(false);

        txt_SoDienThoai.setEditable(false);
        txt_SoDienThoai.setMinimumSize(new java.awt.Dimension(64, 30));
        txt_SoDienThoai.setPreferredSize(new java.awt.Dimension(64, 30));

        txt_Email.setEditable(false);
        txt_Email.setMinimumSize(new java.awt.Dimension(64, 30));
        txt_Email.setPreferredSize(new java.awt.Dimension(64, 30));

        javax.swing.GroupLayout pnl_ThongTinLayout = new javax.swing.GroupLayout(pnl_ThongTin);
        pnl_ThongTin.setLayout(pnl_ThongTinLayout);
        pnl_ThongTinLayout.setHorizontalGroup(
            pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ThongTinLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_MaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(txt_TenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(106, 106, 106)
                .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_ThongTinLayout.createSequentialGroup()
                        .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_ThongTinLayout.createSequentialGroup()
                                .addComponent(rad_Nam)
                                .addGap(18, 18, 18)
                                .addComponent(rad_Nu))))
                    .addComponent(lbl_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_ThongTinLayout.setVerticalGroup(
            pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ThongTinLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_ThongTinLayout.createSequentialGroup()
                        .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_ThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rad_Nam)
                            .addComponent(rad_Nu)
                            .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(lbl_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_ThongTinLayout.createSequentialGroup()
                        .addComponent(lbl_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lbl_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pnl_NutChucNang.setBackground(new java.awt.Color(199, 210, 213));
        pnl_NutChucNang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btn_Them.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btn_Them.setIcon(new javax.swing.ImageIcon("src/main/java/fit/iuh/imageGD/icons8-add-30.png")); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ThemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ThemMouseExited(evt);
            }
        });
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_CapNhat.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btn_CapNhat.setIcon(new javax.swing.ImageIcon("src/main/java/fit/iuh/imageGD/icons8-update-30.png")); // NOI18N
        btn_CapNhat.setText("Cập nhật");
        btn_CapNhat.setBorder(null);
        btn_CapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_CapNhatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CapNhatMouseExited(evt);
            }
        });
        btn_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatActionPerformed(evt);
            }
        });

        btn_Luu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btn_Luu.setIcon(new javax.swing.ImageIcon("src/main/java/fit/iuh/imageGD/icons8-save-30.png")); // NOI18N
        btn_Luu.setText("Lưu");
        btn_Luu.setBorder(null);
        btn_Luu.setEnabled(false);
        btn_Luu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_LuuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_LuuMouseExited(evt);
            }
        });
        btn_Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LuuActionPerformed(evt);
            }
        });

        btn_XoaTrang.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btn_XoaTrang.setIcon(new javax.swing.ImageIcon("src/main/java/fit/iuh/imageGD/icons8-delete-30.png")); // NOI18N
        btn_XoaTrang.setText("Xóa trắng");
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

        btn_TaoNgauNhien.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btn_TaoNgauNhien.setText("Tạo ngẫu nhiên");
        btn_TaoNgauNhien.setBorder(null);
        btn_TaoNgauNhien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TaoNgauNhienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_NutChucNangLayout = new javax.swing.GroupLayout(pnl_NutChucNang);
        pnl_NutChucNang.setLayout(pnl_NutChucNangLayout);
        pnl_NutChucNangLayout.setHorizontalGroup(
            pnl_NutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_NutChucNangLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnl_NutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_CapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Luu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_XoaTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(btn_TaoNgauNhien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnl_NutChucNangLayout.setVerticalGroup(
            pnl_NutChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_NutChucNangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Luu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_XoaTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_TaoNgauNhien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_ThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnl_NutChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnl_DanhSachKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1009, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_DanhSachKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_ThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_NutChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatActionPerformed
        if(btn_CapNhat.getText().equalsIgnoreCase("Cập nhật")){
            btn_CapNhat.setText("Hủy");
            btn_Them.setEnabled(false);
            btn_Luu.setEnabled(true);
            kiemTraCapNhat=true;
            kiemTraTextNhap(true);
        }else if(btn_CapNhat.getText().equalsIgnoreCase("Hủy")){
            btn_CapNhat.setText("Cập nhật");
            huyThaoTacNhap();
        }
    }//GEN-LAST:event_btn_CapNhatActionPerformed

    private void btn_LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LuuActionPerformed
        if(kiemTraThem){
            xuLyThemKhachHang();
        }else if(kiemTraCapNhat){
            xuLyCapNhatKhachHang();
        }
    }//GEN-LAST:event_btn_LuuActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        if(btn_Them.getText().equalsIgnoreCase("Thêm")){
            xoaTrang();
            btn_Them.setText("Hủy");
            btn_CapNhat.setEnabled(false);
            btn_Luu.setEnabled(true);
            kiemTraThem=true;
            kiemTraTextNhap(true);

        }else if(btn_Them.getText().equalsIgnoreCase("Hủy")){
            btn_Them.setText("Thêm");
            huyThaoTacNhap();   
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void tbl_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhachHangMouseClicked
        int row = tbl_KhachHang.getSelectedRow();
        if (row != -1) {
            txt_MaKH.setText(tbl_KhachHang.getValueAt(row, 0).toString());
            txt_TenKH.setText(tbl_KhachHang.getValueAt(row, 1).toString());
            if (tbl_KhachHang.getValueAt(row, 2).toString().equalsIgnoreCase("Nam")) {
                rad_Nam.setSelected(true);
                rad_Nu.setSelected(false);
            } else {
                rad_Nam.setSelected(false);
                rad_Nu.setSelected(true);
            }
            txt_Email.setText(tbl_KhachHang.getValueAt(row, 3).toString());
            txt_SoDienThoai.setText(tbl_KhachHang.getValueAt(row, 4).toString());
    } 
    }//GEN-LAST:event_tbl_KhachHangMouseClicked

    private void btn_XoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaTrangActionPerformed
        xoaTrang();
    }//GEN-LAST:event_btn_XoaTrangActionPerformed

    private void btn_ThemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemMouseEntered
        if(btn_Them.isEnabled()){
            btn_Them.setBackground(new Color(0x9EDDFF));
            btn_Them.setForeground(new Color(0x141E46));
        }
    }//GEN-LAST:event_btn_ThemMouseEntered

    private void btn_ThemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemMouseExited
        if(btn_Them.isEnabled()){
            btn_Them.setBackground(UIManager.getColor("Menu.background"));
            btn_Them.setForeground(UIManager.getColor("Menu.foreground"));
        }
    }//GEN-LAST:event_btn_ThemMouseExited

    private void btn_CapNhatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CapNhatMouseEntered
        if(btn_CapNhat.isEnabled()) {
            btn_CapNhat.setBackground(new Color(0x9EDDFF));
            btn_CapNhat.setForeground(new Color(0x141E46));
        }
        
    }//GEN-LAST:event_btn_CapNhatMouseEntered

    private void btn_CapNhatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CapNhatMouseExited
        if(btn_CapNhat.isEnabled()) {
            btn_CapNhat.setBackground(UIManager.getColor("Menu.background"));
            btn_CapNhat.setForeground(UIManager.getColor("Menu.foreground"));
        }
        
    }//GEN-LAST:event_btn_CapNhatMouseExited

    private void btn_LuuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LuuMouseEntered
        if(btn_Luu.isEnabled()) {
            btn_Luu.setBackground(new Color(0x9EDDFF));
            btn_Luu.setForeground(new Color(0x141E46));
        }
        
    }//GEN-LAST:event_btn_LuuMouseEntered

    private void btn_LuuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LuuMouseExited
        if(btn_Luu.isEnabled()) {
            btn_Luu.setBackground(UIManager.getColor("Menu.background"));
            btn_Luu.setForeground(UIManager.getColor("Menu.foreground"));
        }
        
    }//GEN-LAST:event_btn_LuuMouseExited

    private void btn_XoaTrangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaTrangMouseEntered
        btn_XoaTrang.setBackground(new Color(0x9EDDFF));
        btn_XoaTrang.setForeground(new Color(0x141E46));
    }//GEN-LAST:event_btn_XoaTrangMouseEntered

    private void btn_XoaTrangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaTrangMouseExited
        btn_XoaTrang.setBackground(UIManager.getColor("Menu.background"));
        btn_XoaTrang.setForeground(UIManager.getColor("Menu.foreground"));
    }//GEN-LAST:event_btn_XoaTrangMouseExited

    private void btn_TaoNgauNhienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TaoNgauNhienActionPerformed
        xuLyThemKHNgauNhien();
    }//GEN-LAST:event_btn_TaoNgauNhienActionPerformed
    /**
     * Huy thao tac hoat dong cua componet
     */
    private void huyThaoTacNhap(){
        kiemTraCapNhat=false;
        kiemTraThem=false;
        btn_CapNhat.setText("Cập nhật");
        btn_Them.setText("Thêm");
        btn_Luu.setEnabled(false);
        btn_CapNhat.setEnabled(true);
        btn_Them.setEnabled(true);
        kiemTraTextNhap(false);
        xoaTrang();
    }
    /**
     * Kiem tra hoat dong cua cac JtextField
     */
    public void kiemTraTextNhap(boolean kiemTra){
        txt_TenKH.setEditable(kiemTra);
        txt_Email.setEditable(kiemTra);
        txt_SoDienThoai.setEditable(kiemTra);
        rad_Nam.setEnabled(kiemTra);
        rad_Nu.setEnabled(kiemTra);
    }
   
    public void xoaTrang() {
        txt_MaKH.setText("");
        txt_TenKH.setText("");
        txt_Email.setText("");
        txt_SoDienThoai.setText("");
        rad_Nam.setSelected(false);
        rad_Nu.setSelected(false);
        tbl_KhachHang.clearSelection();
        modelKhachHang = (DefaultTableModel) tbl_KhachHang.getModel();
        modelKhachHang.setRowCount(0);
    }

    public void docDuLieuKhachHang() {
        modelKhachHang = (DefaultTableModel) tbl_KhachHang.getModel();
        modelKhachHang.setRowCount(0);
        for (KhachHang kh : dao_KhachHang.getAllKhachHang()) {
            Object[] object = new Object[5];
            object[0] = kh.getMaKH();
            object[1] = kh.getHoTen();
            object[2] = kh.getGioiTinh();
            object[3] = kh.getEmail();
            object[4] = kh.getSdt();
            
            modelKhachHang.addRow(object);
        }
    }

    public boolean isValidateData() {
        String gt="";
        String tenKhachHang=txt_TenKH.getText();
        if(rad_Nam.isSelected()){
            gt=rad_Nam.getText();
        }
        if(rad_Nu.isSelected()){
            gt=rad_Nu.getText();
        }
        String email = txt_Email.getText();
        String sdt = txt_SoDienThoai.getText();

        String regexSDT = "^[0-9]{10}$"; //0367494954
        String regexEmail = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)$"; //vana@gmail.com

        if (txt_TenKH.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "Tên khách hàng không được để trống.");
            return false;

        }
        if (!email.matches(regexEmail)) {
            JOptionPane.showMessageDialog(null, "Email không đúng định dạng!");
            return false;
        }
        if (!sdt.matches(regexSDT)) {
            JOptionPane.showMessageDialog(null, "Số điện thoại phải đủ 10 số!");
            return false;
        }
        
        if (tenKhachHang.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Tên Khách hàng không chứa số!");
            return false;
        }
        return true;
    }

    public void xuLyThemKhachHang() {
        if (!isValidateData()) {
            return;
        }
        String gt = "";
        String maKH = txt_MaKH.getText();
        String tenKhachHang = txt_TenKH.getText();
        if (rad_Nam.isSelected()) {
            gt = rad_Nam.getText();
        }
        if (rad_Nu.isSelected()) {
            gt = rad_Nu.getText();
        }
        String email = txt_Email.getText();
        String sdt = txt_SoDienThoai.getText();

        KhachHang kh = new KhachHang(tenKhachHang,sdt, email,  gt);
        dao_KhachHang.themKhachHang(kh);

        modelKhachHang =(DefaultTableModel) tbl_KhachHang.getModel();
        Object[] object = new Object[5];
        object[0] = kh.getMaKH();
        object[1] = kh.getHoTen();
        object[2] = kh.getGioiTinh();
        object[3] = kh.getEmail();
        object[4] = kh.getSdt();
        
        modelKhachHang.addRow(object);
        docDuLieuKhachHang();
        xoaTrang();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }
    public void xuLyThemKHNgauNhien() {
        String gt = "";
        String maKH = "KH0000";
        String tenKhachHang = "Người mua";
        String email = "muahang@gmail.com";
        String sdt = "0712345689";
        KhachHang kh = new KhachHang(tenKhachHang,sdt, email,  gt);
        dao_KhachHang.themKhachHang(kh);

        modelKhachHang =(DefaultTableModel) tbl_KhachHang.getModel();
        Object[] object = new Object[5];
        object[0] = kh.getMaKH();
        object[1] = kh.getHoTen();
        object[2] = kh.getGioiTinh();
        object[3] = kh.getEmail();
        object[4] = kh.getSdt();
        
        modelKhachHang.addRow(object);
        xoaTrang();
        JOptionPane.showMessageDialog(this, "Thêm thành công");
    }
    public void xuLyCapNhatKhachHang(){
        if (!isValidateData()) {
            return;
        }
        String gt="";
        if (rad_Nam.isSelected()) {
            gt = rad_Nam.getText();
        }
        if (rad_Nu.isSelected()) {
            gt = rad_Nu.getText();
        }
        long maKH= Long.parseLong(txt_MaKH.getText());
        String hoTen=txt_TenKH.getText();
        String email=txt_Email.getText();
        String soDienThoai=txt_SoDienThoai.getText();
        
        KhachHang kh=new KhachHang(maKH, hoTen, soDienThoai,email, gt);
       
        int row=tbl_KhachHang.getSelectedRow();
        if(row!=-1){
            dao_KhachHang.capNhatKhachHang(kh);
            for (int i = 0; i < tbl_KhachHang.getRowCount(); i++) {
                long maKH_update= Long.parseLong(tbl_KhachHang.getValueAt(row, 0).toString());
                if(maKH_update == maKH){
                    tbl_KhachHang.setValueAt(hoTen, row, 1);
                    tbl_KhachHang.setValueAt(gt, row, 2);
                    tbl_KhachHang.setValueAt(email, row, 3);
                    tbl_KhachHang.setValueAt(soDienThoai, row, 4);
                }
                
            }
            JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
            xoaTrang();
        }
        else{
            JOptionPane.showMessageDialog(null, "Cập nhật không thành công");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CapNhat;
    private javax.swing.JButton btn_Luu;
    private javax.swing.JButton btn_TaoNgauNhien;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_XoaTrang;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lbl_Email;
    private javax.swing.JLabel lbl_GioiTinh;
    private javax.swing.JLabel lbl_MaKH;
    private javax.swing.JLabel lbl_SoDienThoai;
    private javax.swing.JLabel lbl_TenKH;
    private javax.swing.JLabel lbl_TieuDe;
    private javax.swing.JPanel pnl_DanhSachKhachHang;
    private javax.swing.JPanel pnl_KH_TieuDe;
    private javax.swing.JPanel pnl_NutChucNang;
    private javax.swing.JPanel pnl_ThongTin;
    private javax.swing.JRadioButton rad_Nam;
    private javax.swing.JRadioButton rad_Nu;
    private javax.swing.JScrollPane scr_DanhSachKhachHang;
    private javax.swing.JTable tbl_KhachHang;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_MaKH;
    private javax.swing.JTextField txt_SoDienThoai;
    private javax.swing.JTextField txt_TenKH;
    // End of variables declaration//GEN-END:variables
}
