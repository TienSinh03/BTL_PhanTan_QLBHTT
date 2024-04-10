/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao;

import fit.iuh.connectDB.Connect;
import fit.iuh.entity.*;
import fit.iuh.entity.PhieuDatHang;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author phant
 */
public class Dao_PhieuDatHang {

    private Dao_SanPham dao_SanPham = new Dao_SanPham();
    private Dao_NhanVien dao_NhanVien = new Dao_NhanVien();
    private Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
    private Dao_PhanLoai dao_PhanLoai = new Dao_PhanLoai();
    private Dao_ChatLieu dao_ChatLieu = new Dao_ChatLieu();
    private Dao_KichThuoc dao_KichThuoc = new Dao_KichThuoc();
    private Dao_MauSac dao_MauSac = new Dao_MauSac();
    private Dao_NhaCungCap dao_NhaCungCap = new Dao_NhaCungCap();

    public ArrayList<PhieuDatHang> getAllPhieuDatHang() {

        ArrayList<PhieuDatHang> listPhieuDatHang = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "select * from PhieuDatHang";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while (rs.next()) {
                String maKH = rs.getString(2);
                KhachHang khachHang = dao_KhachHang.getKhachHangTheoMa(maKH);

                String maNV = rs.getString(3);
                NhanVien nhanVien = dao_NhanVien.getNhanVienTheoMa(maNV);
                listPhieuDatHang.add(new PhieuDatHang(rs.getString(1), khachHang, nhanVien, rs.getDate(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPhieuDatHang;
    }
    
    public void themPhieuDatHang(PhieuDatHang pdt) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "insert into PhieuDatHang values(?, ?, ?, ?)";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, pdt.getMaPhieuDat());
            prestmt.setString(2, pdt.getKhachHang().getMaKH());
            prestmt.setString(3, pdt.getNhanVien().getMaNV());
            prestmt.setDate(4, new Date(pdt.getNgayLap().getTime()));
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
    /*
    *@param tham số: mã phieu dat hang
    */
    public void xoaPhieuDatHang(String maPhieuDatHang) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "DELETE FROM PhieuDatHang WHERE maPhieuDatHang = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maPhieuDatHang);
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
     * Lấy thông tin phiếu đặt hàng theo mã phiếu đặt hàng
     */
    public PhieuDatHang getPDTTheoMa(String maPDT) {
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "Select * from PhieuDatHang where maPhieuDatHang =?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maPDT);
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString(2);
                KhachHang khachHang = dao_KhachHang.getKhachHangTheoMa(maKH);

                String maNV = rs.getString(3);
                NhanVien nhanVien = dao_NhanVien.getNhanVienTheoMa(maNV);
                PhieuDatHang pdt = new PhieuDatHang(rs.getString(1), khachHang, nhanVien, rs.getDate(4));
                return pdt;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Lấy thông tin phiếu đặt hàng theo mã khách hàng
     */
    public PhieuDatHang getPDTTheoMaKH(String maKhachHang) {
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "Select * from PhieuDatHang where maKH =?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maKhachHang);
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString(2);
                KhachHang khachHang = dao_KhachHang.getKhachHangTheoMa(maKH);

                String maNV = rs.getString(3);
                NhanVien nhanVien = dao_NhanVien.getNhanVienTheoMa(maNV);
                PhieuDatHang pdt = new PhieuDatHang(rs.getString(1), khachHang, nhanVien, rs.getDate(4));
                return pdt;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
   
    public String taoMaPhieuDatHang() {
        Connection con = Connect.getInstance().getConnection();
        String url = "select top 1 maPhieuDatHang from PhieuDatHang order by maPhieuDatHang desc";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            if (rs.next()) {
                String maPDT = rs.getString(1);
                int so = Integer.parseInt(maPDT.substring(4));
                so++;
                String maPDTMoi = so + "";
                while (maPDTMoi.length() < 4) {
                    maPDTMoi = "0" + maPDTMoi;
                }
                return "PDT" + maPDTMoi;
            } else {
                return "PDT0001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
