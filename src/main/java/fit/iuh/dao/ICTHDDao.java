package fit.iuh.dao;

import fit.iuh.entity.CTHD;

import java.util.ArrayList;
import java.util.Date;

public interface ICTHDDao {
    public ArrayList<CTHD> getAllCTHD(long maHD);
    public  Boolean themCTHD(CTHD cthd);
    public  double tinhThanhTienSanPham(long maHD, long maSP);
    public  double getTongDoanhThu(long maSP, int thangLap, int namLap);
    public  int getSoLuongSanPhamBanDuoc(long maSP, int thangLap, int namLap);
    public  double getDoanhThuSanPhamBanDuoc(long maSP, int thangLap, int namLap);

}
