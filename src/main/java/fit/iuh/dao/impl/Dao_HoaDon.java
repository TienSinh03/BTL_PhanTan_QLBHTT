/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao.impl;


import fit.iuh.connectDB.Connect;
import fit.iuh.entity.HoaDon;
import fit.iuh.entity.KhachHang;
import fit.iuh.entity.NhanVien;
import fit.iuh.entity.SanPham;

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
public class Dao_HoaDon {

    private Dao_SanPham dao_SanPham = new Dao_SanPham();
    private Dao_NhanVien dao_NhanVien = new Dao_NhanVien();
    private Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
    private Dao_PhanLoai dao_PhanLoai = new Dao_PhanLoai();
    private Dao_ChatLieu dao_ChatLieu = new Dao_ChatLieu();
    private Dao_KichThuoc dao_KichThuoc = new Dao_KichThuoc();
    private Dao_MauSac dao_MauSac = new Dao_MauSac();
    private Dao_NhaCungCap dao_NhaCungCap = new Dao_NhaCungCap();

    public ArrayList<HoaDon> getAllHoaDon() {

        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "select * from HoaDon";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            while (rs.next()) {
                String maKH = rs.getString(2);
                KhachHang khachHang = dao_KhachHang.getKhachHangTheoMa(maKH);

                String maNV = rs.getString(3);
                NhanVien nhanVien = dao_NhanVien.getNhanVienTheoMa(maNV);
                listHoaDon.add(new HoaDon(rs.getString(1), khachHang, nhanVien, rs.getDate(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }
    
    public void themHoaDon(HoaDon hd) {
        Connection con  = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "insert into HoaDon values(?, ?, ?, ?)";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, hd.getMaHoaDon());
            prestmt.setString(2, hd.getKhachHang().getMaKH());
            prestmt.setString(3, hd.getNhanVien().getMaNV());
            prestmt.setDate(4, new Date(hd.getNgayNhap().getTime()));
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
     * Tính tổng tiền của 1 hóa đơn
     *
     * @param maHD
     * @return
     */
    public double tongTienHoaDon(String maHD) {
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "select hd.maHD, SUM( cthd.soLuong*sp.giaBan) as tongTien from HoaDon hd \n"
                + "   JOIN  CTHD cthd ON hd.maHD = cthd.maHD \n"
                + "   JOIN SanPham sp ON cthd.maSP = sp.maSP\n"
                + "where hd.maHD = ?\n"
                + "group by hd.maHD";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maHD);
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
     * Lấy thông tin hóa đơn theo mã
     */
    public HoaDon getHoaDonTheoMa(String maHD) {
        Connection con = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String url = "Select * from HoaDon where maHD =?";
        try {
            prestmt = con.prepareStatement(url);
            prestmt.setString(1, maHD);
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString(2);
                KhachHang khachHang = dao_KhachHang.getKhachHangTheoMa(maKH);

                String maNV = rs.getString(3);
                NhanVien nhanVien = dao_NhanVien.getNhanVienTheoMa(maNV);
                HoaDon hd = new HoaDon(rs.getString(1), khachHang, nhanVien, rs.getDate(4));
                return hd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Lấy danh sách hóa đơn theo ngày
     *
     * @return
     */
    public ArrayList<HoaDon> getAllHoaDonTheoNgay(String tuNgay, String denNgay) {

        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        Connect.getInstance();
        Connection con = Connect.getConnection();
        String url = "select * from HoaDon where ngayLap >= ? and ngayLap <= ?";
        try {
            PreparedStatement prestmt = con.prepareStatement(url);
            prestmt.setString(1, tuNgay);
            prestmt.setString(2, denNgay);
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {
                String maKH = rs.getString(2);
                KhachHang khachHang = dao_KhachHang.getKhachHangTheoMa(maKH);

                String maNV = rs.getString(3);
                NhanVien nhanVien = dao_NhanVien.getNhanVienTheoMa(maNV);
                listHoaDon.add(new HoaDon(rs.getString(1), khachHang, nhanVien, rs.getDate(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    /**
     * Tạo tự động mã
     *
     * @return
     */
    public String taoMaHoaDon() {
        Connection con = Connect.getInstance().getConnection();
        String url = "select top 1 maHD from HoaDon order by maHD desc";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(url);
            if (rs.next()) {
                String maHD = rs.getString(1);
                int so = Integer.parseInt(maHD.substring(4));
                so++;
                String maHDMoi = so + "";
                while (maHDMoi.length() < 4) {
                    maHDMoi = "0" + maHDMoi;

                }
                return "HD" + maHDMoi;
            } else {
                return "HD0001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ==============================Thống kê doanh thu=====================
     */
    /**
     * Thống kê Top 5 san pham doanh thu cao nhat
     *
     * @return
     */
    public ArrayList<SanPham> thongKeTop5SPDTCN() {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        Connect.getInstance();
        Connection conn = Connect.getConnection();
        try {
            String sql = "select  top 5 sp.maSP,sum(sp.giaBan*cthd.soLuong) as DoanhThu from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD\n" +
"						join SanPham sp on cthd.maSP=sp.maSP\n" +
"						join PhanLoai pl on pl.maPhanLoai=sp.maPhanLoai \n" +
"						join KichThuoc kc on kc.maKichThuoc=sp.maKichThuoc\n" +
"						join MauSac ms on ms.maMauSac=sp.maMauSac\n" +
"						join ChatLieu cl on cl.maChatLieu=sp.maChatLieu\n" +
"						join NhaCungCap ncc on ncc.maNCC=sp.maNhaCungCap\n" +
"			group by sp.maSP\n" +
"			order by sum(sp.giaBan*cthd.soLuong) desc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                SanPham sp = dao_SanPham.getSanPhamTheoMa(rs.getString(1));
                listSanPham.add(sp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSanPham;
    }
     /**
     * Thống kê Top 5 san pham doanh thu cao nhat
     *
     * @return
     */
    public ArrayList<SanPham> thongKeTop5SPDTTN() {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        Connect.getInstance();
        Connection conn = Connect.getConnection();
        try {
            String sql = "select  top 5 sp.maSP,sum(sp.giaBan*cthd.soLuong) as DoanhThu from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD\n" +
"						join SanPham sp on cthd.maSP=sp.maSP\n" +
"						join PhanLoai pl on pl.maPhanLoai=sp.maPhanLoai \n" +
"						join KichThuoc kc on kc.maKichThuoc=sp.maKichThuoc\n" +
"						join MauSac ms on ms.maMauSac=sp.maMauSac\n" +
"						join ChatLieu cl on cl.maChatLieu=sp.maChatLieu\n" +
"						join NhaCungCap ncc on ncc.maNCC=sp.maNhaCungCap\n" +
"			group by sp.maSP\n" +
"			order by sum(sp.giaBan*cthd.soLuong) asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                SanPham sp = dao_SanPham.getSanPhamTheoMa(rs.getString(1));
                listSanPham.add(sp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSanPham;
    }
    /**
     * Thống kê danh sách sản phẩm với số lượng bán được theo các tiêu chí
     *
     * @return
     */
    public ArrayList<SanPham> thongKeDanhSachSanPhamVoiSoLuongBanDuoc(String mauSac, String phanLoai, String kichThuoc) {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        Connect.getInstance();
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "select sp.maSP from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD\n"
                    + "						join SanPham sp on cthd.maSP=sp.maSP\n"
                    + "						join PhanLoai pl on pl.maPhanLoai=sp.maPhanLoai \n"
                    + "						join KichThuoc kt on kt.maKichThuoc=sp.maKichThuoc\n"
                    + "						join MauSac ms on ms.maMauSac=sp.maMauSac\n"
                    + "						join ChatLieu cl on cl.maChatLieu=sp.maChatLieu\n"
                    + "						join NhaCungCap ncc on ncc.maNCC=sp.maNhaCungCap\n"
                    + "	where ms.tenMauSac like ? and kt.tenKichThuoc like ? and pl.tenPhanLoai like ?\n"
                    + "			group by sp.maSP";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + mauSac + "%");
            stmt.setString(2, "%" + kichThuoc + "%");
            stmt.setString(3, "%" + phanLoai + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SanPham sp = dao_SanPham.getSanPhamTheoMa(rs.getString(1));
                listSanPham.add(sp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return listSanPham;
    }
    
    /**
     * Thống kê danh sách sản phẩm với số lượng bán được theo từ ngày và đến
     * ngày
     *
     * @return
     */
    public ArrayList<SanPham> thongKeDanhSachSanPhamVoiSoLuongBanDuoc(String mauSac, String phanLoai, String kichThuoc, String tuNgay, String denNgay) {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        Connect.getInstance();
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "select cthd.maSP from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD\n"
                    + "                   						join SanPham sp on cthd.maSP=sp.maSP\n"
                    + "                   						join PhanLoai pl on pl.maPhanLoai=sp.maPhanLoai \n"
                    + "                   						join KichThuoc kt on kt.maKichThuoc=sp.maKichThuoc\n"
                    + "                    					join MauSac ms on ms.maMauSac=sp.maMauSac\n"
                    + "                    					join ChatLieu cl on cl.maChatLieu=sp.maChatLieu\n"
                    + "                    					join NhaCungCap ncc on ncc.maNCC=sp.maNhaCungCap\n"
                    + "      	where ms.tenMauSac like ? and kt.tenKichThuoc like ? and pl.tenPhanLoai like ? and hd.ngayLap >= ? and  hd.ngayLap <= ?\n"
                    + "		group by cthd.maSP;";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + mauSac + "%");
            stmt.setString(2, "%" + kichThuoc + "%");
            stmt.setString(3, "%" + phanLoai + "%");
            stmt.setString(4, tuNgay);
            stmt.setString(5, denNgay);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SanPham sp = dao_SanPham.getSanPhamTheoMa(rs.getString(1));
                listSanPham.add(sp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSanPham;
    }
    
     /**
     * Thống kê danh sách sản phẩm đã bán theo tháng năm
     *
     * @return
     */
    public ArrayList<SanPham> thongKeDanhSachSanPhamTheoThangNam(String thangLap, String namLap) {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        Connect.getInstance();
        Connection conn = Connect.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "select sp.maSP from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD\n"
                    + "						join SanPham sp on cthd.maSP=sp.maSP\n"
                    + "						join PhanLoai pl on pl.maPhanLoai=sp.maPhanLoai \n"
                    + "						join KichThuoc kt on kt.maKichThuoc=sp.maKichThuoc\n"
                    + "						join MauSac ms on ms.maMauSac=sp.maMauSac\n"
                    + "						join ChatLieu cl on cl.maChatLieu=sp.maChatLieu\n"
                    + "						join NhaCungCap ncc on ncc.maNCC=sp.maNhaCungCap\n"
                    + "	where MONTH(hd.ngayLap) like ? and YEAR(hd.ngayLap) like ?\n"
                    + "			group by sp.maSP";

            stmt = conn.prepareStatement(sql);         
            stmt.setString(1, "%" + thangLap + "%");
            stmt.setString(2, "%" + namLap + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SanPham sp = dao_SanPham.getSanPhamTheoMa(rs.getString(1));
                listSanPham.add(sp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return listSanPham;
    }

    /**
     * ==================THỐNG KÊ KHÁCH HÀNG===============
     */
    /**
     * Thống kê thông tin khách hãng đã mua
     *
     * @return
     */
    public ArrayList<KhachHang> thongKeThongTinKhachHangDaMuaHang() {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        Connect.getInstance();
        Connection conn = Connect.getConnection();
        try {
            String sql = "select hd.maKH,kh.hoTen,kh.sdt from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD \n"
                    + "											join KhachHang kh on kh.maKH=hd.maKH\n"
                    + "											join SanPham sp on sp.maSP=cthd.maSP\n"
                    + "							group by hd.maKH,kh.hoTen,kh.sdt";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KhachHang kh = dao_KhachHang.getKhachHangTheoMa(rs.getString(1));
                listKhachHang.add(kh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listKhachHang;
    }

    /**
     * Lấy thành tiền khách hàng mua
     *
     * @param maKH
     * @return
     */
    public double getThanhTienKhachHangMua(String maKH) {

        Connection conn = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String sql = "select SUM(cthd.soLuong*sp.giaBan) as thanhTien from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD \n"
                + "	join KhachHang kh on kh.maKH=hd.maKH\n"
                + "	join SanPham sp on sp.maSP=cthd.maSP\n"
                + "where hd.maKH = ? \n"
                + "group by hd.maKH,kh.hoTen,kh.sdt";
        try {
            prestmt = conn.prepareStatement(sql);
            prestmt.setString(1, maKH);
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * lấy số lượng khách hàng mua tại cửa hàng
     *
     * @param maKH
     * @return
     */
    public int getSoLuongKhachHangMua(String maKH) {

        Connection conn = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String sql = "select SUM(cthd.soLuong) as SoLuongKHDaMua from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD \n"
                + "					join KhachHang kh on kh.maKH=hd.maKH\n"
                + "					join SanPham sp on sp.maSP=cthd.maSP\n"
                + "		where hd.maKH = ?"
                + "		group by hd.maKH,kh.hoTen,kh.sdt";
        try {
            prestmt = conn.prepareStatement(sql);
            prestmt.setString(1, maKH);
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * lấy số lượng khách hàng
     *
     * @return
     */
    public int getSoLuongKhachHang() {
        Connection conn = Connect.getInstance().getConnection();

        String sql = "select COUNT(*) as tongKH from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD ";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * Thống kê top 5 khách hàng doanh thu cao nhat
     *
     * @return
     */
    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangDTCaoNhat() {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        Connect.getInstance();
        Connection conn = Connect.getConnection();
        try {
            String sql = "select top 5 hd.maKH,kh.hoTen,kh.sdt,SUM(cthd.soLuong) as SoLuongKHDaMua,SUM(cthd.soLuong*sp.giaBan) as thanhTien from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD \n"
                    + "																	join KhachHang kh on kh.maKH=hd.maKH\n"
                    + "																	join SanPham sp on sp.maSP=cthd.maSP\n"
                    + "							group by hd.maKH,kh.hoTen,kh.sdt\n"
                    + "							order by SUM(cthd.soLuong*sp.giaBan) desc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KhachHang kh = dao_KhachHang.getKhachHangTheoMa(rs.getString(1));
                listKhachHang.add(kh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listKhachHang;
    }
      /**
     * Thống kê top 5 khách hàng thuong xuyen mua hang nhat
     *
     * @return
     */
    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangThuongXuyenMuaHang() {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        Connect.getInstance();
        Connection conn = Connect.getConnection();
        try {
            String sql = "select top 5 hd.maKH,kh.hoTen,kh.sdt,SUM(cthd.soLuong) as SoLuongKHDaMua,SUM(cthd.soLuong*sp.giaBan) as thanhTien from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD \n"
                    + "																	join KhachHang kh on kh.maKH=hd.maKH\n"
                    + "																	join SanPham sp on sp.maSP=cthd.maSP\n"
                    + "							group by hd.maKH,kh.hoTen,kh.sdt\n"
                    + "							order by count(*) desc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KhachHang kh = dao_KhachHang.getKhachHangTheoMa(rs.getString(1));
                listKhachHang.add(kh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listKhachHang;
    }
      /**
     * Thống kê top 5 khách hàng co so luong mua nhieu nhat
     *
     * @return
     */
    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangSLNhieuNhat() {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        Connect.getInstance();
        Connection conn = Connect.getConnection();
        try {
            String sql = "select top 5 hd.maKH,kh.hoTen,kh.sdt,SUM(cthd.soLuong) as SoLuongKHDaMua,SUM(cthd.soLuong*sp.giaBan) as thanhTien from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD \n"
                    + "																	join KhachHang kh on kh.maKH=hd.maKH\n"
                    + "																	join SanPham sp on sp.maSP=cthd.maSP\n"
                    + "							group by hd.maKH,kh.hoTen,kh.sdt\n"
                    + "							order by SUM(cthd.soLuong) desc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                KhachHang kh = dao_KhachHang.getKhachHangTheoMa(rs.getString(1));
                listKhachHang.add(kh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listKhachHang;
    }
    

    public int getSoLuongHoaDonKhachHangMua(String maKH) {
        Connection conn = Connect.getInstance().getConnection();
        PreparedStatement prestmt = null;
        String sql = "select maKH , COUNT(*) as tongHD from HoaDon\n"
                + "where maKH = ?\n"
                + "group by maKH";
        try {
            prestmt = conn.prepareStatement(sql);
            prestmt.setString(1, maKH);
            ResultSet rs = prestmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(2);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
