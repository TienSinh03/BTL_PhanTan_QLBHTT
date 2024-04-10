/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao.impl;

import fit.iuh.connectDB.Connect;
import fit.iuh.entity.CTHD;
import fit.iuh.entity.HoaDon;
import fit.iuh.entity.SanPham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phant
 */
public class Dao_CTHD {

    private Dao_SanPham dao_SanPham = new Dao_SanPham();
    private Dao_HoaDon dao_HoaDon = new Dao_HoaDon();

    /**
     * Lấy Chi tiết hóa đơn theo mã hóa đơn
     *
     * @param maHD
     * @return
     */
    public ArrayList<CTHD> getAllCTHD(String maHD) {

        ArrayList<CTHD> listCTHD = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "select * from CTHD where maHD = ?";
        try {
            PreparedStatement prestmt = con.prepareStatement(url);
            prestmt.setString(1, maHD);
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString(2);
                SanPham sanPham = dao_SanPham.getSanPhamTheoMa(maSP);

                HoaDon hoaDon = dao_HoaDon.getHoaDonTheoMa(maHD);
                listCTHD.add(new CTHD(sanPham, hoaDon, rs.getInt(3)));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCTHD;
    }

    public void themCTHD(CTHD cthd) {
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "insert into CTHD values(?, ?, ?)";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, cthd.getHoaDon().getMaHoaDon());
            prestmt.setString(2, cthd.getSanPham().getMaSP());
            prestmt.setInt(3, cthd.getSoLuong());
            prestmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                prestmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Tính tổng tiền của 1 sản phẩm ứng với hóa đơn
     *
     * @param maHD
     * @return
     */
    public double tinhThanhTienSanPham(String maHD, String maSP) {
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "select hd.maHD, cthd.soLuong*sp.giaBan as thanhTien from HoaDon hd \n"
                + "   JOIN  CTHD cthd ON hd.maHD = cthd.maHD \n"
                + "   JOIN SanPham sp ON cthd.maSP = sp.maSP\n"
                + "where hd.maHD = ? and cthd.maSP = ?\n";

        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maHD);
            prestmt.setString(2, maSP);
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {
                double tongTien = rs.getDouble(2);
                return tongTien;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Lấy tổng doanh thu
     *
     * @return
     */
    public double getTongDoanhThu(String maSP, String thangLap, String namLap) {
        Connect.getConnection();
        Connection conn = Connect.getConnection();
        String sql = "SELECT  SUM(cthd.soLuong*sp.giaBan) as DoanhThu\n"
                + "FROM  CTHD cthd join SanPham sp on sp.maSP=cthd.maSP JOIN HoaDon hd ON hd.maHD = cthd.maHD where sp.maSP = ? and MONTH(hd.ngayLap) like ? and YEAR(hd.ngayLap) like ?";
        try {
            PreparedStatement prestmt = conn.prepareStatement(sql);
            prestmt.setString(1, maSP);
            prestmt.setString(2, "%" + thangLap + "%");
            prestmt.setString(3, "%" + namLap + "%");
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

//   ====================THỐNG KÊ DOANH THU==================
    //so luong ban duoc cua tung san pham
    public int getSoLuongSanPhamBanDuoc(String maSP, String thangLap, String namLap) {
        Connection conn = Connect.getInstance().getConnection();
        PreparedStatement pre = null;
        String sql = "select sp.maSP, SUM(cthd.soLuong) as tongSoLuongBan from SanPham sp \n"
                + "                                     JOIN CTHD cthd ON sp.maSP = cthd.maSP\n"
                + "                                      JOIN HoaDon hd ON cthd.maHD = hd.maHD\n"
                + "where sp.maSP = ? and MONTH(hd.ngayLap) like ? and YEAR(hd.ngayLap) like ? \n"
                + "                    group by sp.maSP";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, maSP);
            pre.setString(2, "%" + thangLap + "%");
            pre.setString(3, "%" + namLap + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return rs.getInt(2);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
//doanh thu theo tung san pham ban duoc

    public double getDoanhThuSanPhamBanDuoc(String maSP, String thangLap, String namLap) {
        Connect.getConnection();
        Connection conn = Connect.getConnection();
        PreparedStatement pre = null;
        String sql = "select sum(cthd.soLuong*sp.giaBan) as doanhThu from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD\n"
                + "						join SanPham sp on cthd.maSP=sp.maSP\n"
                + "		where sp.maSP=? and MONTH(hd.ngayLap) like ? and YEAR(hd.ngayLap) like ? \n"
                + "			group by sp.maSP";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, maSP);
            pre.setString(2, "%" + thangLap + "%");
            pre.setString(3, "%" + namLap + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
