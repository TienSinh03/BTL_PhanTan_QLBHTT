package fit.iuh.dao;

import fit.iuh.entity.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public interface IHoaDonDao {

    public ArrayList<HoaDon> getAllHoaDon();
    public Boolean themHoaDon(HoaDon hd);
    public double tongTienHoaDon(long maHD);
    public HoaDon getHoaDonTheoMa(long maHD);
    public ArrayList<SanPham> thongKeDanhSachSanPhamVoiSoLuongBanDuocByTieuChi(String mauSac, String phanLoai, String kichThuoc);
    public ArrayList<SanPham> thongKeTop5SPDTCN();
    public ArrayList<SanPham> thongKeTop5SPDTTN();
    public ArrayList<HoaDon> getAllHoaDonTheoNgay(String tuNgay, String denNgay) throws ParseException;
    public  ArrayList<SanPham> thongKeDanhSachSanPhamVoiSoLuongBanDuocByTieuChiByTime(String mauSac, String phanLoai, String kichThuoc, String tuNgay, String denNgay) throws ParseException ;
    public  ArrayList<SanPham> thongKeDanhSachSanPhamTheoThangNam(String thangLap, String namLap);
    public ArrayList<KhachHang> thongKeThongTinKhachHangDaMuaHang();
    public double getThanhTienKhachHangMua(long maKH);
    public int getSoLuongKhachHangMua(long maKH);
    public int getSoLuongKhachHang();
    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangDTCaoNhat();
    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangThuongXuyenMuaHang();
    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangSLNhieuNhat();
    public int getSoLuongHoaDonKhachHangMua(long maKH);

    public HoaDon getHoaDon();
}
