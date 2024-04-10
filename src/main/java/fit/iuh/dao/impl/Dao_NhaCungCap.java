package fit.iuh.dao.impl;

import fit.iuh.connectDB.Connect;
import fit.iuh.entity.NhaCungCap;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phant
 */
public class Dao_NhaCungCap {
    /**
     * Phương thức lấy dữ liệu của Nhà Cung Câp từ database
     * @return listNhaCungCap
     */    
    public ArrayList<NhaCungCap> getAllNhaCungCap() {
        ArrayList<NhaCungCap> listNhaCungCap = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "Select * from NhaCungCap";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while (rs.next()) {                
                listNhaCungCap.add(new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNhaCungCap;
    }
    
    /**
     * Thêm dữ liệu Nhà Cung Cấp vào database
     * @param ncc 
     */
    public void themNhaCungCap(NhaCungCap ncc) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "insert into NhaCungCap values(?, ?, ?, ?, ?)";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, ncc.getMaNCC());
            prestmt.setString(2, ncc.getTenNCC());
            prestmt.setString(3, ncc.getDiaChi());
            prestmt.setString(4, ncc.getSdt());
            prestmt.setString(5, ncc.getEmail());
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
     * Xóa dữ liệu Nhà Cung Cấp trên database
     * @param ncc 
     */
    public void xoaNhaCungCap(String maNCC) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "delete from NhaCungCap where maNCC = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maNCC);
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
     * Cập nhật dữ liệu Nhà Cung Cấp trên database
     * @param ncc 
     */
    public void capNhatNhaCungCap(NhaCungCap ncc) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "update NhaCungCap set tenNCC = ?, diaChi = ?, sdt = ?, email = ? where maNCC = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, ncc.getTenNCC());
            prestmt.setString(2, ncc.getDiaChi());
            prestmt.setString(3, ncc.getSdt());
            prestmt.setString(4, ncc.getEmail());
            prestmt.setString(5, ncc.getMaNCC());
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
     * Tìm kiếm nhà cung cấp 
     */
    public NhaCungCap timKiemNhaCungCap(String maNCC, String tenNCC, String sdt, String email) {
        NhaCungCap ncc = null;
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "Select * from NhaCungCap where maNCC = ? or tenNCC = ? or sdt = ? or email = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maNCC);
            prestmt.setString(2, tenNCC);
            prestmt.setString(3, sdt);
            prestmt.setString(4, email);
            ResultSet rs = prestmt.executeQuery();
            while(rs.next()){
                ncc = new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                prestmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ncc;
    }
    
    /**
     * Lấy dữ liệu nhà cung cấp theo tên nhà cung cấp
     * @param tenNhaCungCap
     * @return 
     */
    public NhaCungCap getNhaCungCapTheoTen(String tenNhaCungCap){
        Connect.getInstance();
        Connection con = Connect.getConnection();
        
        try {
            String sql = "select * from NhaCungCap where tenNCC = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tenNhaCungCap);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                NhaCungCap nhaCungCap = new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                return nhaCungCap;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Lấy dữ liệu nhà cung cấp theo mã nhà cung cấp
     * @param maNCC
     * @return 
     */
    public NhaCungCap getNhaCungCapTheoMa(String maNCC) {
        NhaCungCap ncc = null;
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "Select * from NhaCungCap where maNCC = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maNCC);
            ResultSet rs = prestmt.executeQuery();
            
            while(rs.next()){
                ncc = new NhaCungCap(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                prestmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ncc;
    }
    
    /**
     * Tạo tự động mã
     * @return 
     */
    public String taoMaNhaCungCap() {
        Connection con = Connect.getInstance().getConnection();
        String url = "select top 1 maNCC from NhaCungCap order by maNCC desc";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            if(rs.next()) {
                String maNCC = rs.getString(1);
                int so = Integer.parseInt(maNCC.substring(3));
                so++;
                String maNCCMoi = so + "";
                while(maNCCMoi.length() < 3) {
                    maNCCMoi = "0" +maNCCMoi;
                    
                }
                return "NCC" + maNCCMoi;
            } else {
                return "NCC001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
