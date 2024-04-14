package fit.iuh.dao;


import fit.iuh.entity.SanPham;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface iSanPhamDao {

    public ArrayList<SanPham> getAllSanPham();
    public ArrayList<SanPham> getAllQuanAo();
    public ArrayList<SanPham> getAllPhuKien();

    public boolean themSanPham(SanPham sanPham);
    public boolean xoaSanPham(long masp);
    public boolean capNhatSanPham(SanPham sanPham);

    public ArrayList<SanPham> timKiemQuanAo(long maSP, String tenSP, String tenPhanLoai, String tenNCC, String tenMauSac, String tenChatLieu, String tenKichThuoc);
    public ArrayList<SanPham> timKiemPhuKien(long maSP, String tenSP, String tenPhanLoai, String tenNCC, String tenMauSac, String tenChatLieu, String tenKichThuoc);

    public SanPham getSanPhamTheoMa(long maSP);

    public ArrayList<SanPham> getAllSanPhamTheoTieuChi(String maPhanLoai, String maMauSac, String maKichThuoc);
    public ArrayList<SanPham> getAllSanPhamHetHang(String maPhanLoai, String maMauSac, String maKichThuoc);

    public ArrayList<SanPham>  getSanPhamBanChay();
    public ArrayList<SanPham>  getSanPhamBanCham();

    public ArrayList<SanPham>  getSoLuongSPTheoMaPL();
    public  ArrayList<SanPham> getAllSanPhamTheoNgay(String tuNgay, String denNgay);

    public void giamSoLuongSanPham(SanPham sp);
    public void tangSoLuongSanPham(long maSP, int soLuong);
}
