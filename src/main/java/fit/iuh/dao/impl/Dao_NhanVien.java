/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao.impl;


import fit.iuh.dao.INhanVienDao;
import fit.iuh.entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;

/**
 *
 * @author phant
 */
public class Dao_NhanVien implements INhanVienDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPADemo_SQL");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    public ArrayList<NhanVien> getAllNhanVien() {
        return (ArrayList<NhanVien>) em.createQuery("SELECT nv FROM NhanVien nv").getResultList();
    }

        public ArrayList<NhanVien> getAllNhanVienConHoaDong() {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        String url = "Select * from NhanVien where trangThai = 1";

        try {
            et.begin();
            listNhanVien = (ArrayList<NhanVien>) em.createNativeQuery(url, NhanVien.class).getResultList();
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return listNhanVien;
    }

    /**
     * Thêm dữ liệu Nhân Viên vào database
     *
     * @param nv
     */
    public void themNhanVien(NhanVien nv) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(nv);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Xóa dữ liệu Nhân viên trên database
     *
     * @param manv
     */
    public void xoaNhanVien(long manv) {
        EntityTransaction et = em.getTransaction();
        String query = "update NhanVien nv set nv.trangThai = 0 where maNV = :manv";
        try {
            et.begin();
            em.createQuery(query).setParameter("manv", manv).executeUpdate();
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Cập nhật thông tin nhân viên
     *
     * @param nv
     */
    public void capNhatNhanVien(NhanVien nv) {
        String url = "update NhanVien set hoTen = ?, chuVu = ?, email = ?, sdt = ?, diaChi = ?, gioiTinh = ?, trangThai = ? where maNV = ?";
        try {
            et.begin();
            em.createNativeQuery(url)
                    .setParameter(1, nv.getHoTen())
                    .setParameter(2, nv.getChuVu())
                    .setParameter(3, nv.getEmail())
                    .setParameter(4, nv.getSdt())
                    .setParameter(5, nv.getDiaChi())
                    .setParameter(6, nv.getGioiTinh())
                    .setParameter(7, nv.isTrangThai())
                    .setParameter(8, nv.getMaNV())
                    .executeUpdate();
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Tìm kiếm nhân viên
     * @param maNV
     * @param tenNV
     * @param sdt
     * @param email
     * @param chucVu
     * @param diaChi
     * @param trangThai
     * @return 
     */
    public ArrayList<NhanVien> timKiemNhanVien(long maNV, String tenNV, String sdt, String email, String chucVu, String diaChi, boolean trangThai) {
        ArrayList<NhanVien> listNhanVienTim = new ArrayList<>();
        String url = "SELECT * FROM NhanVien WHERE maNV LIKE ? AND hoTen LIKE ? AND sdt LIKE ? AND email LIKE ? AND chuVu LIKE ? AND diaChi LIKE ? AND trangThai = ?";
        try {
            et.begin();
            String maNVCheck = null;
            if(maNV == 0) {
                maNVCheck = "";
            } 
                
            listNhanVienTim = (ArrayList<NhanVien>) em.createNativeQuery(url, NhanVien.class)
                    .setParameter(1, "%" + maNVCheck + "%")
                    .setParameter(2, "%" + tenNV + "%")
                    .setParameter(3, "%" + sdt + "%")
                    .setParameter(4, "%" + email + "%")
                    .setParameter(5, "%" + chucVu + "%")
                    .setParameter(6, "%" + diaChi + "%")
                    .setParameter(7, trangThai)
                    .getResultList();
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return listNhanVienTim;
    }

    public static NhanVien getNhanVienTheoMa(long maNV) {
        EntityManager em = Persistence.createEntityManagerFactory("JPADemo_SQL").createEntityManager();
        return em.find(NhanVien.class, maNV);
    }

    public NhanVien getNhanVienTheoTen(String tenNV) {
        String url = "Select * from NhanVien where hoTen = ?";
        try {
            et.begin();
            NhanVien nv = (NhanVien) em.createNativeQuery(url, NhanVien.class).setParameter(1, tenNV).getSingleResult();
            et.commit();
            return nv;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Tạo tự động mã
     *
     * @return
     */
//    public String taoMaNhanVien() {
//        Connection con = Connect.getInstance().getConnection();
//        String url = "select top 1 maNV from NhanVien order by maNV desc";
//
//        try {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(url);
//            if (rs.next()) {
//                String maNV = rs.getString(1);
//                int so = Integer.parseInt(maNV.substring(3));
//                so++;
//                String maNVMoi = so + "";
//                while (maNVMoi.length() < 3) {
//                    maNVMoi = "0" + maNVMoi;
//
//                }
//                return "NV" + maNVMoi;
//            } else {
//                return "NV001";
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
