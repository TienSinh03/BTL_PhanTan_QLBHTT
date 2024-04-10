/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao;

import fit.iuh.connectDB.Connect;
import fit.iuh.entity.PhanLoai;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author phant
 */
public interface Dao_PhanLoai {
    
    public ArrayList<PhanLoai> getAllPhanLoai();
    
    /**
     * lấy thông tin phân loại sản phảm theo mã
     * @param maPL
     * @return 
     */

    public ArrayList<PhanLoai> getAllPhanLoaiCuaPhuKien() {
        ArrayList<PhanLoai> listPhanLoai = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "Select * from PhanLoai WHERE maPhanLoai NOT IN ('PL0001', 'PL0002')";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while (rs.next()) {                
                listPhanLoai.add(new PhanLoai(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPhanLoai;
    }
    
    public PhanLoai getDLPhanLoaiSPTheoMa(String maPL) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement prestmt = null;
        String url = "select * from PhanLoai where maPhanLoai = ?";
        
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maPL);
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {                
                PhanLoai pl = new PhanLoai();
                pl.setMaPhanLoai(rs.getString(1));
                pl.setLoaiSanPham(rs.getString(2));
                return pl;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * lấy thông tin phân loại sản phảm theo tên
     * @param tenPhanLoai
     * @return 
     */
    public PhanLoai getPhanLoaiTheoTen(String tenPhanLoai){
        Connect.getInstance();
        Connection con = Connect.getConnection();
        
        try {
            String sql = "select * from PhanLoai where tenPhanLoai = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tenPhanLoai);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                PhanLoai phanLoai = new PhanLoai(rs.getString(1), rs.getString(2));
                return phanLoai;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Thêm loai sản phẩm
     * @param phanLoai 
     */
    public void themLoaiSanPham(PhanLoai phanLoai) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "insert into PhanLoai values(?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, phanLoai.getMaPhanLoai());
            stmt.setString(2, phanLoai.getLoaiSanPham());
            stmt.executeUpdate();
          
             
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception e) {
            }
        }
    }
    
    /**
     * Xóa dữ liệu loại sản phẩm trên database
     * @param chatLieu 
     */
    public void xoaPhanLoaiSanPham(String maPhanLoai) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "delete from PhanLoai where maPhanLoai = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maPhanLoai);
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
     * Cập nhật dữ liệu phân loại trên database
     * @param chatLieu 
     */
    public void catNhatLoaiSanPham(PhanLoai phanLoai) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "Update PhanLoai set tenPhanLoai = ? where maPhanLoai = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, phanLoai.getLoaiSanPham());
            prestmt.setString(2, phanLoai.getMaPhanLoai());
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
     * Tạo tự động mã
     * @return 
     */
    public String taoMaPhanLoai() {
        Connection con = Connect.getInstance().getConnection();
        String url = "select top 1 maPhanLoai from PhanLoai order by maPhanLoai desc";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            if(rs.next()) {
                String maPhanLoai = rs.getString(1);
                int so = Integer.parseInt(maPhanLoai.substring(4));
                so++;
                String maPhanLoaiMoi = so + "";
                while(maPhanLoaiMoi.length() < 4) {
                    maPhanLoaiMoi = "0" +maPhanLoaiMoi;
                    
                }
                return "PL" + maPhanLoaiMoi;
            } else {
                return "PL0001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
