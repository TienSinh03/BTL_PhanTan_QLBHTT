/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fit.iuh.qlbhtt;


import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import fit.iuh.connectDB.Connect;
import fit.iuh.dao.impl.Dao_SanPham;
import fit.iuh.entity.SanPham;
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
public class ManHinh_NV_BieuDoThongKeSP extends javax.swing.JFrame {
    private Dao_SanPham dao_SanPham;
    private Connect connect;
    /**
     * Creates new form ManHinh_NV_BieuDoThongKeSP
     */
    public ManHinh_NV_BieuDoThongKeSP() throws SQLException {
        dao_SanPham = new Dao_SanPham();
        connect = new Connect();
        connect.connect();
        initComponents();
        setLocationRelativeTo(null);

        hienThiBieuDoTK();
    }

    public void hienThiBieuDoTK() {
        DefaultCategoryDataset dateSet = new DefaultCategoryDataset(); //Khởi tạo để chứa dữ liệu cột
        
        for(SanPham sp: dao_SanPham.getSoLuongSPTheoMaPL()) {
            String tenPL = sp.getPhanLoai().getLoaiSanPham();
            dateSet.addValue(sp.getSoLuong(), "Số lượng", tenPL);
        }

        //Tạo biểu đồ
        JFreeChart barChart = ChartFactory.createBarChart(
                "Số lượng sản phẩm theo phân loại", // Chart title
                "Phân Loại", // tên theo trục hoành (cột X)
                "Số lượng sản phẩm", // tên theo trục tung (cột Y)
                dateSet, // Dataset
                PlotOrientation.VERTICAL, // Chart orientation
                true, // Chú thích
                true, // Tooltips chú thích
                false // URLs
        );
        
        CategoryPlot cateGoryPlot = barChart.getCategoryPlot();//Quản lý hiển thị dữ liệu trên biểu đồ dưới dạng các loại hình
        cateGoryPlot.setBackgroundPaint(Color.WHITE);
        
        BarRenderer renderer = (BarRenderer) cateGoryPlot.getRenderer(); // tùy chỉnh màu của biểu đồ
        Color clr3 = new Color(204, 0, 51);
        renderer.setSeriesPaint(0, clr3); // Đặt màu cho biểu đồ đầu tiên
        
        //Cấu hình trục tung (cột Y)
        NumberAxis yAxis = (NumberAxis) cateGoryPlot.getRangeAxis();
        yAxis.setRange(1, 20); // Đặt giới hạn cho trục tung     
        
        ChartPanel barpChartPanel = new ChartPanel(barChart); // Hiển thị biểu đồ lên Jframe
        pnl_HienThiBieuDo.add(barpChartPanel, BorderLayout.CENTER);
        pnl_HienThiBieuDo.validate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_HienThiBieuDo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_HienThiBieuDo.setMinimumSize(new java.awt.Dimension(702, 516));
        pnl_HienThiBieuDo.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_HienThiBieuDo, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_HienThiBieuDo, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ManHinh_NV_BieuDoThongKeSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManHinh_NV_BieuDoThongKeSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManHinh_NV_BieuDoThongKeSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManHinh_NV_BieuDoThongKeSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManHinh_NV_BieuDoThongKeSP().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManHinh_NV_BieuDoThongKeSP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnl_HienThiBieuDo;
    // End of variables declaration//GEN-END:variables
}
