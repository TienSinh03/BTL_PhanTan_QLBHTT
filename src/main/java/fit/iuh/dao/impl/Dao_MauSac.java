/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao.impl;

import fit.iuh.connectDB.Connect;
import fit.iuh.entity.MauSac;

import java.util.ArrayList;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author phant
 */
public class Dao_MauSac {
    
    public ArrayList<MauSac> getAllMauSac() {
        ArrayList<MauSac> listMauSac = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "select * from MauSac";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while (rs.next()) {                
                listMauSac.add(new MauSac(rs.getString(1), rs.getString(2)));                        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMauSac;
    }
    
    /**
     * Lấy dữ liệu màu sắc theo mã
     * @param maMS
     * @return 
     */
    public MauSac getDLMauSacTheoMa(String maMS) {
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "select * from MauSac where maMauSac = ?";
        
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maMS);
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {                
                MauSac ms = new MauSac();
                ms.setMaMauSac(rs.getString(1));
                ms.setMauSac(rs.getString(2));
                return ms;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Lấy dữ liệu màu sắc theo tên
     * @param tenMauSac
     * @return 
     */
    public MauSac getMauSacTheoTen(String tenMauSac){
        Connection con = Connect.getInstance().getConnection();
        
        try {
            String sql = "select * from MauSac where tenMauSac = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tenMauSac);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                MauSac mauSac = new MauSac(rs.getString(1), rs.getString(2));
                return mauSac;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Thêm màu sắc vào database
     * @param mauSac 
     */
    public void themDLMauSac(MauSac mauSac) {
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "insert into MauSac values (?, ?)";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, mauSac.getMaMauSac());
            prestmt.setString(2, mauSac.getMauSac());
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
     * Xóa dữ liệu mau Sac trên database
     * @param mauSac 
     */
    public void xoaDLMauSac(String maMauSac) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "delete from MauSac where maMauSac = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maMauSac);
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
     * Cập nhật dữ liệu Màu sắc trên database
     * @param mauSac 
     */
    public void catNhatDLMauSac(MauSac mauSac) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "Update MauSac set tenMauSac = ? where maMauSac = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, mauSac.getMauSac());
            prestmt.setString(2, mauSac.getMaMauSac());
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
    public String taoMaMauSac() {
        Connection con = Connect.getInstance().getConnection();
        String url = "select top 1 maMauSac from MauSac order by maMauSac desc";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            if(rs.next()) {
                String maMauSac = rs.getString(1);
                int so = Integer.parseInt(maMauSac.substring(4));
                so++;
                String maMauSacMoi = so + "";
                while(maMauSacMoi.length() < 4) {
                    maMauSacMoi = "0" +maMauSacMoi;
                    
                }
                return "MS" + maMauSacMoi;
            } else {
                return "MS0001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
