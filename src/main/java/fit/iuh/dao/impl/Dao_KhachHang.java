/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao.impl;

import fit.iuh.connectDB.Connect;
import fit.iuh.entity.KhachHang;

import java.sql.Connection;

import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;



/**
 *
 * @author ACER
 */
public class Dao_KhachHang {
    public ArrayList<KhachHang> getAllKhachHang(){
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        Connect.getInstance();
        Connection con=Connect.getConnection();
        try {
            String sql= "Select * from KhachHang";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()){
                String maKH=rs.getString(1);
                String hoTen=rs.getString(2);
                String gioiTinh=rs.getString(3);
                String email=rs.getString(4);
                String SDT=rs.getString(5);
               KhachHang kh=new KhachHang(maKH, hoTen, gioiTinh,email, SDT);
               listKhachHang.add(kh);
             }
        } catch (SQLException e) {
        }
        return listKhachHang;
    }
   public void themKhachHang(KhachHang kh){
       Connect.getInstance();
       Connection con=Connect.getConnection();
       String sql = "insert into KhachHang values (?, ?, ?, ?, ?)";
       PreparedStatement stm =null;
       try {
           
            stm = con.prepareCall(sql);
            stm.setString(1, kh.getMaKH());
            stm.setString(2, kh.getHoTen());
            stm.setString(3, kh.getSdt());
            stm.setString(4, kh.getEmail());
            stm.setString(5, kh.getGioiTinh());
            stm.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
  
   }
   public void capNhatKhachHang(KhachHang kh){
       Connect.getInstance();
       Connection con=Connect.getConnection();
       String sql = "update KhachHang set hoTen = ?,"+" sdt = ?,"+" email = ?,"+" gioiTinh = ?"+" where maKH = ?";
       PreparedStatement stm =null;
       try {
            stm = con.prepareCall(sql);
            
            stm.setString(1, kh.getHoTen());
            stm.setString(2, kh.getSdt());
            stm.setString(3, kh.getEmail());
            stm.setString(4, kh.getGioiTinh());
            stm.setString(5, kh.getMaKH());
            stm.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }     
   }
   
     public ArrayList<KhachHang> timKiemKhachHang(String maKhachHang,String tenKhachHang,String soDienThoai, String email){
       ArrayList<KhachHang> listKhachHang =new ArrayList<>(); 
       Connect.getInstance();
       Connection con=Connect.getConnection();
       String sql = "select * from KhachHang where maKH like ? and hoten like ? and sdt like ? and email like ?";
       PreparedStatement stm =null;
       try {
            stm=con.prepareStatement(sql);
            stm.setString(1, "%" + maKhachHang + "%");
            stm.setString(2, "%" + tenKhachHang + "%");
            stm.setString(3, "%" + soDienThoai + "%");
            stm.setString(4, "%" + email + "%");
            ResultSet rs=stm.executeQuery();
            while (rs.next()){
                KhachHang kh=new KhachHang();
                kh.setMaKH(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setGioiTinh(rs.getString(5));
                kh.setEmail(rs.getString(4));
                kh.setSdt(rs.getString(3));
                listKhachHang.add(kh);
             }
        }catch (SQLException e) {
           e.printStackTrace();
       } finally {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listKhachHang;
   }
     
     /**
      * Lấy thông tin khách hàng theo mã
      * @param maKH
      * @return 
      */
    public KhachHang getKhachHangTheoMa(String maKH) {
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "Select * from KhachHang where maKH = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maKH);
            
            ResultSet rs = prestmt.executeQuery();
            while(rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                return khachHang;
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
    public String taoMaKhachHang() {
        Connection con = Connect.getInstance().getConnection();
        String url = "select top 1 maKH from KhachHang order by maKH desc";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            if(rs.next()) {
                String maKH = rs.getString(1);
                int so = Integer.parseInt(maKH.substring(4));
                so++;
                String maKHMoi = so + "";
                while(maKHMoi.length() < 4) {
                    maKHMoi = "0" +maKHMoi;
                    
                }
                return "KH" + maKHMoi;
            } else {
                return "KH0001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
