/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao;

import fit.iuh.connectDB.Connect;
import fit.iuh.entity.ChatLieu;

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
public class Dao_ChatLieu {
    /**
     * Lấy tất cả chất liệu trong database
     * @return 
     */
    public ArrayList<ChatLieu> getAllChatLieu() {
        ArrayList<ChatLieu> listChatLieu = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "select * from ChatLieu";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while (rs.next()) {                
                listChatLieu.add(new ChatLieu(rs.getString(1), rs.getString(2)));                        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listChatLieu;
    }
    
    /**
     * Thêm chất liệu vào database
     * @param chatLieu 
     */
    public void themDLChatLieu(ChatLieu chatLieu) {
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "insert into ChatLieu values (?, ?)";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, chatLieu.getMaChatLieu());
            prestmt.setString(2, chatLieu.getChatLieu());
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
     * Xóa dữ liệu Chất Liệu trên database
     * @param chatLieu 
     */
    public void xoaDLChatLieu(String maChatLieu) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "delete from ChatLieu where maChatLieu = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maChatLieu);
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
     * Cập nhật dữ liệu Chất Liệu trên database
     * @param chatLieu 
     */
    public void catNhatDLChatLieu(ChatLieu chatLieu) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "Update ChatLieu set tenChatLieu = ? where maChatLieu = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, chatLieu.getChatLieu());
            prestmt.setString(2, chatLieu.getMaChatLieu());
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
     * Tìm dữ liệu Chất Liệu theo mã trên database
     * @param chatLieu 
     */
    public ChatLieu getDLChatLieuTheoMa(String id){
        Connect.getInstance();
        Connection con = Connect.getConnection();
        
        try {
            String sql = "select * from ChatLieu where maChatLieu = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ChatLieu chatLieu = new ChatLieu();
                chatLieu.setMaChatLieu(rs.getString(1));
                chatLieu.setChatLieu(rs.getString(2));
                return chatLieu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * Lấy dữ liệu Chất liệu theo tên
     * @param tenChatLieu
     * @return 
     */
    public ChatLieu getChatLieuTheoTen(String tenChatLieu){
        Connect.getInstance();
        Connection con = Connect.getConnection();
        
        try {
            String sql = "select * from ChatLieu where tenChatLieu = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tenChatLieu);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ChatLieu chatLieu = new ChatLieu();
                chatLieu.setMaChatLieu(rs.getString(1));
                chatLieu.setChatLieu(rs.getString(2));
                return chatLieu;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Tạo tự động mã
     * @return 
     */
    public String taoMaChatLieu() {
        Connection con = Connect.getInstance().getConnection();
        String url = "select top 1 maChatLieu from ChatLieu order by maChatLieu desc";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            if(rs.next()) {
                String maChatLieu = rs.getString(1);
                int so = Integer.parseInt(maChatLieu.substring(4));
                so++;
                String maChatLieuMoi = so + "";
                while(maChatLieuMoi.length() < 4) {
                    maChatLieuMoi = "0" +maChatLieuMoi;
                    
                }
                return "CL" + maChatLieuMoi;
            } else {
                return "CL0001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
