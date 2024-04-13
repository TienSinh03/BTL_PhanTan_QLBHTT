package fit.iuh.dao;


import fit.iuh.entity.SanPham;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface iSanPhamDao {

    public List<SanPham> getAllSanPham();
    public List<SanPham> getAllQuanAo();
    public List<SanPham> getAllPhuKien();

    public boolean addSanPham(SanPham sanPham);
    public boolean deleteSanPham(Long masp);


    public List<SanPham> findQuanAo(Long maSP, String tenSP, String tenPhanLoai, String tenNCC, String tenMauSac, String tenChatLieu, String tenKichThuoc);
    public List<SanPham> findPhuKien(Long maSP, String tenSP, String tenPhanLoai, String tenNCC, String tenMauSac, String tenChatLieu, String tenKichThuoc);

    public SanPham getSanPhamTheoMa(Long maSP);

    public List<SanPham> getAllSanPhamTheoTieuChi(String mauSac, String chatLieu, String kichThuoc);
    public List<SanPham> getAllSanPhamHetHang(String mauSac, String chatLieu, String kichThuoc);

    public Map<Long, Integer> getSanPhamBanChay();
    public Map<Long, Integer> getSanPhamBanCham();

    public Map<Long, Integer> getSoLuongSPTheoMaPL();
    public List<SanPham> getAllSanPhamTheoNgay(Date ngayNhap, Date ngayKetThuc);


}
