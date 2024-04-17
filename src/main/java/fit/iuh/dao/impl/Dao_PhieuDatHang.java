/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao.impl;

import fit.iuh.dao.IPhieuDatHangDao;
import fit.iuh.entity.*;
import fit.iuh.entity.PhieuDatHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phant
 */
public class Dao_PhieuDatHang implements IPhieuDatHangDao {

    EntityManager em = null;
    EntityTransaction tx = null;

//    private Dao_SanPham dao_SanPham = new Dao_SanPham();
//    private Dao_NhanVien dao_NhanVien = new Dao_NhanVien();
//    private Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
//    private Dao_PhanLoai dao_PhanLoai = new Dao_PhanLoai();
//    private Dao_ChatLieu dao_ChatLieu = new Dao_ChatLieu();
//    private Dao_KichThuoc dao_KichThuoc = new Dao_KichThuoc();
//    private Dao_MauSac dao_MauSac = new Dao_MauSac();
//    private Dao_NhaCungCap dao_NhaCungCap = new Dao_NhaCungCap();

    public Dao_PhieuDatHang() {
        em = Persistence.createEntityManagerFactory("JPADemo_SQL").createEntityManager();
        tx = em.getTransaction();
    }

    @Override
    public List<PhieuDatHang> getAllPhieuDatHang() {
        String query = "Select pdt from PhieuDatHang pdt";
        List<PhieuDatHang> list = null;
        try {
            tx.begin();
            list = em.createQuery(query, PhieuDatHang.class).getResultList();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return list;

    }
    @Override
    public boolean themPhieuDatHang(PhieuDatHang pdt) {
        String query = "INSERT INTO PhieuDatHang (maKH, maNV, ngayLap) VALUES (?, ?, ?)";
        try {
            tx.begin();
            em.createNativeQuery(query)
                    .setParameter(1, pdt.getKhachHang().getMaKH())
                    .setParameter(2, pdt.getNhanVien().getMaNV())
                    .setParameter(3, pdt.getNgayLap())
                    .executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            System.out.println("Error while committing transaction: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
    /*
    *@param tham số: mã phieu dat hang
    */
    @Override
    public boolean xoaPhieuDatHang(long maPhieuDatHang) {

        String url = "DELETE FROM PhieuDatHang pd WHERE pd.maPhieuDat = :maPhieuDatHang";
        try {
            tx.begin();
//            PhieuDatHang pdt = em.find(PhieuDatHang.class, maPhieuDatHang);
//            em.remove(pdt);
            em.createQuery(url).setParameter("maPhieuDatHang", maPhieuDatHang).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Lấy thông tin phiếu đặt hàng theo mã phiếu đặt hàng
     */
    @Override
    public PhieuDatHang getPDTTheoMa(long maPDT) {
        try {
            tx.begin();
            PhieuDatHang pdt = em.find(PhieuDatHang.class, maPDT);
            tx.commit();
            return pdt;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Lấy thông tin phiếu đặt hàng theo mã khách hàng
     */
    @Override
    public PhieuDatHang getPDTTheoMaKH(long maKhachHang) {

//        String url = "Select p from PhieuDatHang p where p.khachHang.maKH = :maKHachHang";
//        try {
//            tx.begin();
//            PhieuDatHang pdt = em.createQuery(url, PhieuDatHang.class).setParameter("maKHachHang", maKhachHang)
//                    .getResultList()
//                    .stream()
//                    .findFirst().orElse(null);
//            tx.commit();
//            return pdt;
//        } catch (Exception e) {
//            tx.rollback();
//            e.printStackTrace();
//        }
//
//        return null;
        String url = "Select p from PhieuDatHang p join p.khachHang kh where kh.maKH = :maKHachHang";
            List<PhieuDatHang> resultList = em.createQuery(url, PhieuDatHang.class)
                    .setParameter("maKHachHang", maKhachHang)
                    .getResultList();
            if (resultList.isEmpty()) {
                // Xử lý khi không tìm thấy kết quả, ví dụ: trả về null hoặc thông báo lỗi
                return null;
            } else {
                // Xử lý khi tìm thấy kết quả
                return resultList.get(0); // Trả về phần tử đầu tiên trong danh sách kết quả
            }
    }
   
//    public String taoMaPhieuDatHang() {
//        Connection con = Connect.getInstance().getConnection();
//        String url = "select top 1 maPhieuDatHang from PhieuDatHang order by maPhieuDatHang desc";
//
//        try {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(url);
//            if (rs.next()) {
//                String maPDT = rs.getString(1);
//                int so = Integer.parseInt(maPDT.substring(4));
//                so++;
//                String maPDTMoi = so + "";
//                while (maPDTMoi.length() < 4) {
//                    maPDTMoi = "0" + maPDTMoi;
//                }
//                return "PDT" + maPDTMoi;
//            } else {
//                return "PDT0001";
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
