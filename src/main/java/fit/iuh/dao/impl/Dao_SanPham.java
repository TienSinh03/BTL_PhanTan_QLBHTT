/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao.impl;


import fit.iuh.connectDB.Connect;
import fit.iuh.entity.*;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author DMX
 */
public class Dao_SanPham {

    private Dao_ChatLieu daoChatLieu = new Dao_ChatLieu();
    private Dao_KichThuoc daoKichThuoc = new Dao_KichThuoc();
    private Dao_MauSac daoMauSac = new Dao_MauSac();
    private Dao_PhanLoai daoPhanLoai = new Dao_PhanLoai();
    private Dao_NhaCungCap daoNhaCungCap = new Dao_NhaCungCap();
    private Dao_NhanVien dao_NhanVien = new Dao_NhanVien();
    private Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
    
    /**
     * 
     * @return listSanPham
     */    
    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        ChatLieu chatLieu;
        KichThuoc kichThuoc;
        MauSac mauSac;
        PhanLoai phanLoai;
        NhaCungCap nhaCungCap;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "SELECT SanPham.maSP, SanPham.tenSP, SanPham.soLuong, SanPham.giaBan, SanPham.giaNhap, SanPham.ngayNhap,SanPham.hinhAnh,ChatLieu.maChatLieu, ChatLieu.tenChatLieu, KichThuoc.maKichThuoc, KichThuoc.tenKichThuoc, MauSac.maMauSac, MauSac.tenMauSac, PhanLoai.maPhanLoai, PhanLoai.tenPhanLoai, NhaCungCap.maNCC, NhaCungCap.tenNCC, NhaCungCap.diaChi, NhaCungCap.sdt, NhaCungCap.email FROM SanPham JOIN ChatLieu ON SanPham.maChatLieu = ChatLieu.maChatLieu JOIN KichThuoc ON SanPham.maKichThuoc = KichThuoc.maKichThuoc JOIN MauSac ON SanPham.maMauSac = MauSac.maMauSac JOIN PhanLoai ON SanPham.maPhanLoai = PhanLoai.maPhanLoai JOIN NhaCungCap ON SanPham.maNhaCungCap = NhaCungCap.maNCC;";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while (rs.next()) {
                chatLieu = new ChatLieu(rs.getString(8), rs.getString(9));
                kichThuoc = new KichThuoc(rs.getString(10), rs.getString(11));
                mauSac = new MauSac(rs.getString(12), rs.getString(13));
                phanLoai = new PhanLoai(rs.getString(14), rs.getString(15));
                nhaCungCap = new NhaCungCap(rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20));
                listSanPham.add(new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5),rs.getDate(6) ,rs.getString(7),
                chatLieu, kichThuoc, mauSac, phanLoai, nhaCungCap));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
    
    public ArrayList<SanPham> getAllQuanAo() {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        ChatLieu chatLieu;
        KichThuoc kichThuoc;
        MauSac mauSac;
        PhanLoai phanLoai;
        NhaCungCap nhaCungCap;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "SELECT SanPham.maSP, SanPham.tenSP, SanPham.soLuong, SanPham.giaBan, SanPham.giaNhap, SanPham.ngayNhap,SanPham.hinhAnh,ChatLieu.maChatLieu, ChatLieu.tenChatLieu, KichThuoc.maKichThuoc, KichThuoc.tenKichThuoc, MauSac.maMauSac, MauSac.tenMauSac, PhanLoai.maPhanLoai, PhanLoai.tenPhanLoai, NhaCungCap.maNCC, NhaCungCap.tenNCC, NhaCungCap.diaChi, NhaCungCap.sdt, NhaCungCap.email FROM SanPham JOIN ChatLieu ON SanPham.maChatLieu = ChatLieu.maChatLieu JOIN KichThuoc ON SanPham.maKichThuoc = KichThuoc.maKichThuoc JOIN MauSac ON SanPham.maMauSac = MauSac.maMauSac JOIN PhanLoai ON SanPham.maPhanLoai = PhanLoai.maPhanLoai JOIN NhaCungCap ON SanPham.maNhaCungCap = NhaCungCap.maNCC WHERE PhanLoai.maPhanLoai IN ('PL0001', 'PL0002');";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while (rs.next()) {
                chatLieu = new ChatLieu(rs.getString(8), rs.getString(9));
                kichThuoc = new KichThuoc(rs.getString(10), rs.getString(11));
                mauSac = new MauSac(rs.getString(12), rs.getString(13));
                phanLoai = new PhanLoai(rs.getString(14), rs.getString(15));
                nhaCungCap = new NhaCungCap(rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20));
                listSanPham.add(new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5),rs.getDate(6) ,rs.getString(7),
                chatLieu, kichThuoc, mauSac, phanLoai, nhaCungCap));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
    
    public ArrayList<SanPham> getAllPhuKien() {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        ChatLieu chatLieu;
        KichThuoc kichThuoc;
        MauSac mauSac;
        PhanLoai phanLoai;
        NhaCungCap nhaCungCap;
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "SELECT SanPham.maSP, SanPham.tenSP, SanPham.soLuong, SanPham.giaBan, SanPham.giaNhap, SanPham.ngayNhap,SanPham.hinhAnh,ChatLieu.maChatLieu, ChatLieu.tenChatLieu, KichThuoc.maKichThuoc, KichThuoc.tenKichThuoc, MauSac.maMauSac, MauSac.tenMauSac, PhanLoai.maPhanLoai, PhanLoai.tenPhanLoai, NhaCungCap.maNCC, NhaCungCap.tenNCC, NhaCungCap.diaChi, NhaCungCap.sdt, NhaCungCap.email FROM SanPham JOIN ChatLieu ON SanPham.maChatLieu = ChatLieu.maChatLieu JOIN KichThuoc ON SanPham.maKichThuoc = KichThuoc.maKichThuoc JOIN MauSac ON SanPham.maMauSac = MauSac.maMauSac JOIN PhanLoai ON SanPham.maPhanLoai = PhanLoai.maPhanLoai JOIN NhaCungCap ON SanPham.maNhaCungCap = NhaCungCap.maNCC WHERE PhanLoai.maPhanLoai NOT IN ('PL0001', 'PL0002');";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while (rs.next()) {
                chatLieu = new ChatLieu(rs.getString(8), rs.getString(9));
                kichThuoc = new KichThuoc(rs.getString(10), rs.getString(11));
                mauSac = new MauSac(rs.getString(12), rs.getString(13));
                phanLoai = new PhanLoai(rs.getString(14), rs.getString(15));
                nhaCungCap = new NhaCungCap(rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20));
                listSanPham.add(new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5),rs.getDate(6) ,rs.getString(7),
                chatLieu, kichThuoc, mauSac, phanLoai, nhaCungCap));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
    
    public void themSanPham(SanPham sp) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "insert into SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, sp.getMaSP());
            prestmt.setString(2, sp.getTenSP());
            prestmt.setInt(3, sp.getSoLuong());
            prestmt.setDouble(4, sp.getGiaBan());
            prestmt.setDouble(5, sp.getGiaNhap());
            prestmt.setDate(6, new Date(sp.getNgayNhap().getTime()));
            prestmt.setString(7, sp.getHinhAnh());
            prestmt.setString(8, sp.getChatLieu().getMaChatLieu());
            prestmt.setString(9, sp.getKichThuoc().getMaKichThuoc());
            prestmt.setString(10, sp.getMauSac().getMaMauSac());
            prestmt.setString(11, sp.getPhanLoai().getMaPhanLoai());
            prestmt.setString(12, sp.getNhaCungCap().getMaNCC());
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
    
    public void xoaSanPham(String maSanPham) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "delete from SanPham where maSP = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maSanPham);
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
    
    public void capNhatSanPham(SanPham sp) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "update SanPham set tenSP = ?, soLuong = ?, giaBan = ?, giaNhap = ?, ngayNhap = ?, hinhAnh = ?,"
                + " maChatLieu = ?, maKichThuoc = ?, maMauSac = ?, maPhanLoai = ?, maNhaCungCap = ? where maSP = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, sp.getTenSP());
            prestmt.setInt(2, sp.getSoLuong());
            prestmt.setDouble(3, sp.getGiaBan());
            prestmt.setDouble(4, sp.getGiaNhap());
            prestmt.setDate(5, new Date(sp.getNgayNhap().getTime()));
            prestmt.setString(6, sp.getHinhAnh());
            prestmt.setString(7, sp.getChatLieu().getMaChatLieu());
            prestmt.setString(8, sp.getKichThuoc().getMaKichThuoc());
            prestmt.setString(9, sp.getMauSac().getMaMauSac());
            prestmt.setString(10, sp.getPhanLoai().getMaPhanLoai());
            prestmt.setString(11, sp.getNhaCungCap().getMaNCC());
            prestmt.setString(12, sp.getMaSP());
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
    
    public void giamSoLuongSanPham(SanPham sp) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "UPDATE SanPham SET soLuong = soLuong - ? WHERE maSP = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setInt(1, sp.getSoLuong());
            prestmt.setString(2, sp.getMaSP());
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
    
    public void tangSoLuongSanPham(String maSP, int soLuong) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "UPDATE SanPham SET soLuong = soLuong + ? WHERE maSP = ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setInt(1, soLuong);
            prestmt.setString(2, maSP);
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
    
    public ArrayList<SanPham> timKiemQuanAo(String maSP, String tenSP, String tenPhanLoai, String tenNCC, String tenMauSac, String tenChatLieu, String tenKichThuoc) {
        ArrayList<SanPham> listQuanAo = new ArrayList<>();
        ChatLieu chatLieu;
        KichThuoc kichThuoc;
        MauSac mauSac;
        PhanLoai phanLoai;
        NhaCungCap nhaCungCap;
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "Select SanPham.maSP, SanPham.tenSP, SanPham.soLuong, SanPham.giaBan, SanPham.giaNhap, SanPham.ngayNhap,SanPham.hinhAnh,ChatLieu.maChatLieu, ChatLieu.tenChatLieu, KichThuoc.maKichThuoc, KichThuoc.tenKichThuoc, MauSac.maMauSac, MauSac.tenMauSac, PhanLoai.maPhanLoai, PhanLoai.tenPhanLoai, NhaCungCap.maNCC, NhaCungCap.tenNCC, NhaCungCap.diaChi, NhaCungCap.sdt, NhaCungCap.email from SanPham JOIN ChatLieu ON SanPham.maChatLieu = ChatLieu.maChatLieu JOIN KichThuoc ON SanPham.maKichThuoc = KichThuoc.maKichThuoc JOIN MauSac ON SanPham.maMauSac = MauSac.maMauSac JOIN PhanLoai ON SanPham.maPhanLoai = PhanLoai.maPhanLoai JOIN NhaCungCap ON SanPham.maNhaCungCap = NhaCungCap.maNCC where PhanLoai.maPhanLoai IN ('PL0001', 'PL0002') and SanPham.maSP like ? and SanPham.tenSP like ? and PhanLoai.tenPhanLoai like ? and NhaCungCap.tenNCC like ? and MauSac.tenMauSac like ? and ChatLieu.tenChatLieu like ? and KichThuoc.tenKichThuoc like ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, "%"+maSP+"%");
            prestmt.setString(2, "%"+tenSP+"%");
            prestmt.setString(3, "%"+tenPhanLoai+"%");
            prestmt.setString(4, "%"+tenNCC+"%");
            prestmt.setString(5, "%"+tenMauSac+"%");
            prestmt.setString(6, "%"+tenChatLieu+"%");
            prestmt.setString(7, "%"+tenKichThuoc+"%");
            ResultSet rs = prestmt.executeQuery();
            while(rs.next()){
                chatLieu = new ChatLieu(rs.getString(8), rs.getString(9));
                kichThuoc = new KichThuoc(rs.getString(10), rs.getString(11));
                mauSac = new MauSac(rs.getString(12), rs.getString(13));
                phanLoai = new PhanLoai(rs.getString(14), rs.getString(15));
                nhaCungCap = new NhaCungCap(rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20));
                listQuanAo.add(new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5),rs.getDate(6) ,rs.getString(7),
                chatLieu, kichThuoc, mauSac, phanLoai, nhaCungCap));
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
        return listQuanAo;
    }
    
    public ArrayList<SanPham> timKiemPhuKien(String maSP, String tenSP, String tenPhanLoai, String tenNCC, String tenMauSac, String tenChatLieu, String tenKichThuoc) {
        ArrayList<SanPham> listPhuKien = new ArrayList<>();
        ChatLieu chatLieu;
        KichThuoc kichThuoc;
        MauSac mauSac;
        PhanLoai phanLoai;
        NhaCungCap nhaCungCap;
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "Select SanPham.maSP, SanPham.tenSP, SanPham.soLuong, SanPham.giaBan, SanPham.giaNhap, SanPham.ngayNhap,SanPham.hinhAnh,ChatLieu.maChatLieu, ChatLieu.tenChatLieu, KichThuoc.maKichThuoc, KichThuoc.tenKichThuoc, MauSac.maMauSac, MauSac.tenMauSac, PhanLoai.maPhanLoai, PhanLoai.tenPhanLoai, NhaCungCap.maNCC, NhaCungCap.tenNCC, NhaCungCap.diaChi, NhaCungCap.sdt, NhaCungCap.email from SanPham JOIN ChatLieu ON SanPham.maChatLieu = ChatLieu.maChatLieu JOIN KichThuoc ON SanPham.maKichThuoc = KichThuoc.maKichThuoc JOIN MauSac ON SanPham.maMauSac = MauSac.maMauSac JOIN PhanLoai ON SanPham.maPhanLoai = PhanLoai.maPhanLoai JOIN NhaCungCap ON SanPham.maNhaCungCap = NhaCungCap.maNCC where PhanLoai.maPhanLoai NOT IN ('PL0001', 'PL0002') and SanPham.maSP like ? and SanPham.tenSP like ? and PhanLoai.tenPhanLoai like ? and NhaCungCap.tenNCC like ? and MauSac.tenMauSac like ? and ChatLieu.tenChatLieu like ? and KichThuoc.tenKichThuoc like ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, "%"+maSP+"%");
            prestmt.setString(2, "%"+tenSP+"%");
            prestmt.setString(3, "%"+tenPhanLoai+"%");
            prestmt.setString(4, "%"+tenNCC+"%");
            prestmt.setString(5, "%"+tenMauSac+"%");
            prestmt.setString(6, "%"+tenChatLieu+"%");
            prestmt.setString(7, "%"+tenKichThuoc+"%");
            ResultSet rs = prestmt.executeQuery();
            while(rs.next()){
                chatLieu = new ChatLieu(rs.getString(8), rs.getString(9));
                kichThuoc = new KichThuoc(rs.getString(10), rs.getString(11));
                mauSac = new MauSac(rs.getString(12), rs.getString(13));
                phanLoai = new PhanLoai(rs.getString(14), rs.getString(15));
                nhaCungCap = new NhaCungCap(rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20));
                listPhuKien.add(new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5),rs.getDate(6) ,rs.getString(7),
                chatLieu, kichThuoc, mauSac, phanLoai, nhaCungCap));
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
        return listPhuKien;
    }
    
    public SanPham getSanPhamTheoMa(String maSP) {
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement statement = null;
        SanPham sanPham;
        ChatLieu chatLieu;
        KichThuoc kichThuoc;
        MauSac mauSac;
        PhanLoai phanLoai;
        NhaCungCap nhaCungCap;
        try {
            String sql = "Select SanPham.maSP, SanPham.tenSP, SanPham.soLuong, SanPham.giaBan, SanPham.giaNhap, SanPham.ngayNhap, SanPham.hinhAnh,ChatLieu.maChatLieu,\n" +
"       ChatLieu.tenChatLieu, KichThuoc.maKichThuoc, KichThuoc.tenKichThuoc, MauSac.maMauSac, MauSac.tenMauSac, PhanLoai.maPhanLoai,\n" +
"	   PhanLoai.tenPhanLoai, NhaCungCap.maNCC, NhaCungCap.tenNCC, NhaCungCap.diaChi, NhaCungCap.sdt, NhaCungCap.email from SanPham JOIN ChatLieu ON SanPham.maChatLieu = ChatLieu.maChatLieu JOIN KichThuoc ON SanPham.maKichThuoc = KichThuoc.maKichThuoc JOIN MauSac ON SanPham.maMauSac = MauSac.maMauSac JOIN PhanLoai ON SanPham.maPhanLoai = PhanLoai.maPhanLoai JOIN NhaCungCap ON SanPham.maNhaCungCap = NhaCungCap.maNCC where SanPham.maSP = ? ";
            statement = con.prepareStatement(sql);
            statement.setString(1, maSP);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                                
                 chatLieu = new ChatLieu(rs.getString(8), rs.getString(9));
                kichThuoc = new KichThuoc(rs.getString(10), rs.getString(11));
                mauSac = new MauSac(rs.getString(12), rs.getString(13));
                phanLoai = new PhanLoai(rs.getString(14), rs.getString(15));
                nhaCungCap = new NhaCungCap(rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20));
                sanPham = new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6), rs.getString(7),
                        chatLieu, kichThuoc, mauSac, phanLoai, nhaCungCap);
                return sanPham;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        } finally {
            try {
                statement.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return null;
    }
    
//===============THỐNG KÊ SẢN PHẨM===========//
    /**
     * Lấy danh sách tất cả sản phẩm theo các tiêu chí mã phân loại, mã màu sắc, mã kích thước
     * @param maPhanLoai
     * @param maMauSac
     * @param maKichThuoc
     * @return 
     */
    public ArrayList<SanPham> getAllSanPhamTheoTieuChi(String maPhanLoai, String maMauSac, String maKichThuoc) {
        
        
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement prestmt = null;
        String url = "select * from SanPham sp JOIN PhanLoai pl ON sp.maPhanLoai = pl.maPhanLoai \n" +
                                            "  JOIN MauSac ms ON sp.maMauSac = ms.maMauSac\n" +
                                            "  JOIN KichThuoc kt ON sp.maKichThuoc = kt.maKichThuoc\n" +
                        "where pl.tenPhanLoai like ? and ms.tenMauSac like ? and kt.tenKichThuoc like ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, "%"+maPhanLoai+"%");
            prestmt.setString(2, "%"+maMauSac+"%");
            prestmt.setString(3, "%"+maKichThuoc+"%");
            ResultSet rs = prestmt.executeQuery();
            
            while (rs.next()) {                
                String maCL = rs.getString(8);
                ChatLieu chatLieu  = daoChatLieu.getDLChatLieuTheoMa(maCL);
                
                String maKT = rs.getString(9);
                KichThuoc kichThuoc = daoKichThuoc.getDLKichThuocTheoMa(maKT);
                
                String maMS = rs.getString(10);
                MauSac mauSac = daoMauSac.getDLMauSacTheoMa(maMS);
                
                String maPL = rs.getString(11);
                PhanLoai phanLoaiSP = daoPhanLoai.getDLPhanLoaiSPTheoMa(maPL);
                
                String maNCC = rs.getString(12);
                NhaCungCap nhaCungCap = daoNhaCungCap.getNhaCungCapTheoMa(maNCC);
                
                SanPham sanPham = new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6),rs.getString(7),chatLieu , kichThuoc, mauSac, phanLoaiSP, nhaCungCap);
                listSanPham.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
    
    /**
     * Lấy danh sách sản phẩm hết hàng trong kho
     * @param maPhanLoai
     * @param maMauSac
     * @param maKichThuoc
     * @return 
     */
    public  ArrayList<SanPham> getAllSanPhamHetHang(String maPhanLoai, String maMauSac, String maKichThuoc) {
        
        
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement prestmt = null;
        String url = "select * from SanPham sp JOIN PhanLoai pl ON sp.maPhanLoai = pl.maPhanLoai \n" +
                                            "  JOIN MauSac ms ON sp.maMauSac = ms.maMauSac\n" +
                                            "  JOIN KichThuoc kt ON sp.maKichThuoc = kt.maKichThuoc\n" +
                        "where pl.tenPhanLoai like ? and ms.tenMauSac like ? and kt.tenKichThuoc like ? and sp.soLuong = 0";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, "%"+maPhanLoai+"%");
            prestmt.setString(2, "%"+maMauSac+"%");
            prestmt.setString(3, "%"+maKichThuoc+"%");
            ResultSet rs = prestmt.executeQuery();
            
            while (rs.next()) {                
                String maCL = rs.getString(8);
                ChatLieu chatLieu  = daoChatLieu.getDLChatLieuTheoMa(maCL);
                
                String maKT = rs.getString(9);
                KichThuoc kichThuoc = daoKichThuoc.getDLKichThuocTheoMa(maKT);
                
                String maMS = rs.getString(10);
                MauSac mauSac = daoMauSac.getDLMauSacTheoMa(maMS);
                
                String maPL = rs.getString(11);
                PhanLoai phanLoaiSP = daoPhanLoai.getDLPhanLoaiSPTheoMa(maPL);
                
                String maNCC = rs.getString(12);
                NhaCungCap nhaCungCap = daoNhaCungCap.getNhaCungCapTheoMa(maNCC);
                
                SanPham sanPham = new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6),rs.getString(7),chatLieu , kichThuoc, mauSac, phanLoaiSP, nhaCungCap);
                listSanPham.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
    
    /**
     * Lấy danh sách sản phẩm bán chạy
     * @return 
     */
    public ArrayList<SanPham> getSanPhamBanChay() {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "select top 5 sp.maSP, SUM(cthd.soLuong) as tongSoLuongBan from SanPham sp "
                                    + "JOIN CTHD cthd ON sp.maSP = cthd.maSP\n" +
                                      "JOIN HoaDon hd ON cthd.maHD = hd.maHD\n" +
                    "group by sp.maSP\n" +
                    "order by tongSoLuongBan desc";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while(rs.next()) {
                SanPham sp = this.getSanPhamTheoMa(rs.getString(1)); //Lấy dữ liệu thông sản phẩm theo mã đã lấy trong sql
                sp.setSoLuong(rs.getInt(2)); //set tổng số lượng
                listSanPham.add(sp);
                        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
    
    /**
     * Lấy danh sách sản phẩm bán chậm
     * @return 
     */
    public ArrayList<SanPham> getSanPhamBanCham() {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "select top 5 sp.maSP, SUM(cthd.soLuong) as tongSoLuongBan from SanPham sp "
                                    + "JOIN CTHD cthd ON sp.maSP = cthd.maSP\n" +
                                      "JOIN HoaDon hd ON cthd.maHD = hd.maHD\n" +
                    "group by sp.maSP\n" +
                    "order by tongSoLuongBan asc";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while(rs.next()) {
                SanPham sp = this.getSanPhamTheoMa(rs.getString(1)); //Lấy dữ liệu thông sản phẩm theo mã đã lấy trong sql
                sp.setSoLuong(rs.getInt(2)); //set tổng số lượng
                listSanPham.add(sp);
                        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
    
    public ArrayList<SanPham> getSoLuongSPTheoMaPL() {
        ArrayList<SanPham> listSP = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "SELECT maPhanLoai, COUNT(*) AS SoLuongSanPham\n" +
                            "FROM sanPham\n" +
                            "GROUP BY maPhanLoai\n" +
                            "ORDER BY maPhanLoai;";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while(rs.next()) {
                PhanLoai phanLoai = daoPhanLoai.getDLPhanLoaiSPTheoMa(rs.getString(1));
                listSP.add(new SanPham(rs.getInt(2), phanLoai));                      
                        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      return listSP;
              
    }
    
    /**
     * Lấy danh sách sản phẩm theo ngày nhập
     * @param maPhanLoai
     * @param maMauSac
     * @param maKichThuoc
     * @return 
     */
    public  ArrayList<SanPham> getAllSanPhamTheoNgay(String tuNgay, String denNgay) {
        
        
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        PreparedStatement prestmt = null;
        String url = "select * from SanPham sp "+
                        "where sp.ngayNhap >= ? and sp.ngayNhap <= ?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, tuNgay);
            prestmt.setString(2, denNgay);
            ResultSet rs = prestmt.executeQuery();
            
            while (rs.next()) {                
                String maCL = rs.getString(8);
                ChatLieu chatLieu  = daoChatLieu.getDLChatLieuTheoMa(maCL);
                
                String maKT = rs.getString(9);
                KichThuoc kichThuoc = daoKichThuoc.getDLKichThuocTheoMa(maKT);
                
                String maMS = rs.getString(10);
                MauSac mauSac = daoMauSac.getDLMauSacTheoMa(maMS);
                
                String maPL = rs.getString(11);
                PhanLoai phanLoaiSP = daoPhanLoai.getDLPhanLoaiSPTheoMa(maPL);
                
                String maNCC = rs.getString(12);
                NhaCungCap nhaCungCap = daoNhaCungCap.getNhaCungCapTheoMa(maNCC);
                
                SanPham sanPham = new SanPham(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6),rs.getString(7),chatLieu , kichThuoc, mauSac, phanLoaiSP, nhaCungCap);
                listSanPham.add(sanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
}
