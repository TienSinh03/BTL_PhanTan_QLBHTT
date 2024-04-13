package fit.iuh.dao;

import fit.iuh.entity.*;

import java.util.ArrayList;
import java.util.Date;

public interface IHoaDonDao {

    public ArrayList<HoaDon> getAllHoaDon();
    public Boolean themHoaDon(HoaDon hd);
    public double tongTienHoaDon(long maHD);
    public HoaDon getHoaDonTheoMa(long maHD);
    public ArrayList<HoaDon> getAllHoaDonTheoNgay(Date tuNgay, Date denNgay);
    public ArrayList<SanPham> thongKeTop5SPDTCN();
    public ArrayList<SanPham> thongKeTop5SPDTTN();
    public ArrayList<SanPham> thongKeDanhSachSanPhamVoiSoLuongBanDuocByTieuChi(MauSac mauSac, PhanLoai phanLoai, KichThuoc kichThuoc);
    public ArrayList<SanPham> thongKeDanhSachSanPhamVoiSoLuongBanDuocByTieuChiByTime(MauSac mauSac, PhanLoai phanLoai, KichThuoc kichThuoc, Date tuNgay, Date denNgay);
    public ArrayList<SanPham> thongKeDanhSachSanPhamTheoThangNam(int thangLap, int namLap);
    public ArrayList<KhachHang> thongKeThongTinKhachHangDaMuaHang();
    public double getThanhTienKhachHangMua(long maKH);
    public int getSoLuongKhachHangMua(long maKH);
    public int getSoLuongKhachHang();
    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangDTCaoNhat();
    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangThuongXuyenMuaHang();
    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangSLNhieuNhat();
    public int getSoLuongHoaDonKhachHangMua(long maKH);
}
