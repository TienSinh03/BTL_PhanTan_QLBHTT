/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao.impl;

import fit.iuh.connectDB.Connect;
import fit.iuh.entity.KichThuoc;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author phant
 */
public class Dao_KichThuoc {
    
    public ArrayList<KichThuoc> getAllKichThuoc() {
        ArrayList<KichThuoc> listKichThuoc = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "select * from KichThuoc";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while (rs.next()) {                
                listKichThuoc.add(new KichThuoc(rs.getString(1), rs.getString(2)));                        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listKichThuoc;
    }
    
    /**
     * Lấy dữ liệu kích thước theo mã
     * @param maKT
     * @return 
     */
    public KichThuoc getDLKichThuocTheoMa(String maKT) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement prestmt = null;
        String url = "select * from KichThuoc where maKichThuoc = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maKT);
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {                
                KichThuoc kt = new KichThuoc();
                kt.setMaKichThuoc(rs.getString(1));
                kt.setKichThuoc(rs.getString(2));
                return kt;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }
    
    /**
     * Lấy dữ liệu kích thước theo tên
     * @param tenKichThuoc
     * @return 
     */
    public KichThuoc getKichThuocTheoTen(String tenKichThuoc){
        Connect.getInstance();
        Connection con = Connect.getConnection();
        
        try {
            String sql = "select * from KichThuoc where tenKichThuoc = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tenKichThuoc);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                KichThuoc kichThuoc = new KichThuoc(rs.getString(1), rs.getString(2));
                return kichThuoc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Them Kichs thuoc
     * @param kichThuoc 
     */
    public void themDLKichThuoc(KichThuoc kichThuoc) {
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "insert into KichThuoc values (?, ?)";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, kichThuoc.getMaKichThuoc());
            prestmt.setString(2, kichThuoc.getKichThuoc());
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
     * Xóa dữ liệu Kich Thuoc trên database
     * @param maKichThuoc
     */
    public void xoaDLKichThuoc(String maKichThuoc) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "delete from KichThuoc where maKichThuoc = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maKichThuoc);
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
     * Cập nhật dữ liệu  Kich Thuoc trên database
     * @param kichThuoc
     */
    public void catNhatDLKichThuoc(KichThuoc kichThuoc) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "Update KichThuoc set tenKichThuoc = ? where maKichThuoc = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, kichThuoc.getKichThuoc());
            prestmt.setString(2, kichThuoc.getMaKichThuoc());
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
    public String taoMaKichThuoc() {
        Connection con = Connect.getInstance().getConnection();
        String url = "select top 1 maKichThuoc from KichThuoc order by maKichThuoc desc";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            if(rs.next()) {
                String maKichThuoc = rs.getString(1);
                int so = Integer.parseInt(maKichThuoc.substring(4));
                so++;
                String maKichThuocMoi = so + "";
                while(maKichThuocMoi.length() < 4) {
                    maKichThuocMoi = "0" +maKichThuocMoi;
                    
                }
                return "KT" + maKichThuocMoi;
            } else {
                return "KT0001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
