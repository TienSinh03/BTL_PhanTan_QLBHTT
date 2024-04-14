/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fit.iuh.qlbhtt;


import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import fit.iuh.connectDB.Connect;
import fit.iuh.dao.impl.Dao_HoaDon;
import fit.iuh.entity.HoaDon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author phant
 */
public class ManHinh_NV_BieuDoThongKeDoanhThu extends javax.swing.JFrame {
    private Dao_HoaDon dao_HoaDon;
    private Connect connect;

    /**
     * Creates new form Form_BieuDoTKDT
     */
    public ManHinh_NV_BieuDoThongKeDoanhThu() throws SQLException {
        dao_HoaDon = new Dao_HoaDon();                
//        connect = new Connect();
//        connect.connect();
        initComponents();
        setLocationRelativeTo(null);
        loadComboxNam();
        veBieuDoNV();
    }

    public void loadComboxNam() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        ArrayList<Integer> namList = new ArrayList<>();
        int nam = 0;
        for (HoaDon hd : dao_HoaDon.getAllHoaDon()) {
            calendar.setTime(hd.getNgayNhap());

            if (namList.contains(calendar.get(Calendar.YEAR))) {
                continue;
            }
            nam = calendar.get(Calendar.YEAR);
            cmb_Nam.addItem(nam + "");
            namList.add(nam);
        }
    }

    private void veBieuDoNV() {
        int nam = Integer.parseInt(cmb_Nam.getSelectedItem().toString());

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();//Khởi tạo để chứa dữ liệu cột

        Connect.getInstance();
        Connection con = Connect.getConnection();

        try {
            //Tạo ra bảng dữ liệu tạm thời là AllMonths và dùng Union chứa dữ liệu tạm thời
            String sql = "WITH AllMonths AS (\n"
                    + "    SELECT 1 AS thang\n"
                    + "    UNION SELECT 2\n"
                    + "    UNION SELECT 3\n"
                    + "    UNION SELECT 4\n"
                    + "    UNION SELECT 5\n"
                    + "    UNION SELECT 6\n"
                    + "    UNION SELECT 7\n"
                    + "    UNION SELECT 8\n"
                    + "    UNION SELECT 9\n"
                    + "    UNION SELECT 10\n"
                    + "    UNION SELECT 11\n"
                    + "    UNION SELECT 12\n"
                    + ")\n"
                    + "SELECT allM.thang, SUM(sp.giaBan*cthd.soLuong) AS doanhThu\n"
                    + "FROM AllMonths allM\n"
                    + "LEFT JOIN HoaDon hd ON MONTH(hd.ngayLap) = allM.thang AND YEAR(hd.ngayLap) = ?\n"
                    + "LEFT JOIN CTHD cthd ON hd.maHD = cthd.maHD\n"
                    + "LEFT JOIN SanPham sp ON cthd.maSP = sp.maSP\n"
                    + "GROUP BY allM.thang";
            PreparedStatement prestmt = con.prepareStatement(sql);
            prestmt.setInt(1, nam);
            ResultSet rs = prestmt.executeQuery();

            while (rs.next()) {
                // Create SanPham objects for each category and add them to the list
                int maPL = rs.getInt(1);
                double doanhThu = rs.getDouble(2);
                dataset.addValue(doanhThu, "Tháng", "Tháng " + maPL);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //Tạo biểu đồ
        JFreeChart barChart = ChartFactory.createBarChart(
                "Doanh Thu Theo Năm", // Chart title
                "Tháng", // tên theo trục hoành (cột X)
                "Doanh Thu", // tên theo trục tung (cột Y)
                dataset, // Dataset
                PlotOrientation.VERTICAL, // Chart orientation
                true, // Chú thích
                true, // Tooltips chú thích
                false // URLs
        );

        CategoryPlot categoryPlot = barChart.getCategoryPlot(); //Quản lý hiển thị dữ liệu trên biểu đồ dưới dạng các loại hình
        categoryPlot.setBackgroundPaint(Color.WHITE);

        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer(); // tùy chỉnh màu của biểu đồ
        Color clr3 = new Color(204, 0, 51);
        renderer.setSeriesPaint(0, clr3); // Đặt màu cho biểu đồ đầu tiên

        // Cấu hình trục tung (cột Y)
        NumberAxis yAxis = (NumberAxis) categoryPlot.getRangeAxis();
        yAxis.setRange(10000, 10000000); // Đặt giới hạn cho trục tung

        pnl_ManHinhChinh.removeAll();

        ChartPanel barpChartPanel = new ChartPanel(barChart); // Hiển thị biểu đồ lên Jframe
        pnl_ManHinhChinh.add(barpChartPanel, BorderLayout.CENTER);
        pnl_ManHinhChinh.validate();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_ManHinhChinh = new javax.swing.JPanel();
        lbl_Nam = new javax.swing.JLabel();
        cmb_Nam = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_ManHinhChinh.setMinimumSize(new java.awt.Dimension(1119, 603));
        pnl_ManHinhChinh.setLayout(new java.awt.BorderLayout());

        lbl_Nam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_Nam.setText("Năm:");

        cmb_Nam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmb_Nam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_NamItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_ManHinhChinh, javax.swing.GroupLayout.DEFAULT_SIZE, 1119, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lbl_Nam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Nam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_ManHinhChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_NamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_NamItemStateChanged
        veBieuDoNV();
    }//GEN-LAST:event_cmb_NamItemStateChanged

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
            java.util.logging.Logger.getLogger(ManHinh_NV_BieuDoThongKeDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManHinh_NV_BieuDoThongKeDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManHinh_NV_BieuDoThongKeDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManHinh_NV_BieuDoThongKeDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManHinh_NV_BieuDoThongKeDoanhThu().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManHinh_NV_BieuDoThongKeDoanhThu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_Nam;
    private javax.swing.JLabel lbl_Nam;
    private javax.swing.JPanel pnl_ManHinhChinh;
    // End of variables declaration//GEN-END:variables
}
