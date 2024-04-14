/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao.impl;

import fit.iuh.dao.IPhanLoaiDao;
import fit.iuh.entity.PhanLoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;

/**
 *
 * @author phant
 */
public class Dao_PhanLoai implements IPhanLoaiDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPADemo_SQL");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    public ArrayList<PhanLoai> getAllPhanLoai() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPADemo_SQL");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        ArrayList<PhanLoai> listPhanLoai = new ArrayList<>();
        String url = "Select * from PhanLoai";

        try {
            et.begin();
            listPhanLoai = (ArrayList<PhanLoai>) em.createNativeQuery(url, PhanLoai.class).getResultList();
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return listPhanLoai;
    }

    public ArrayList<PhanLoai> getAllPhanLoaiCuaPhuKien() {
        EntityManager em = Persistence.createEntityManagerFactory("JPADemo_SQL").createEntityManager();
        ArrayList<PhanLoai> listPhanLoai = new ArrayList<>();
        String url = "Select * from PhanLoai WHERE maPhanLoai NOT IN ('1', '2')";
        try {
            listPhanLoai = (ArrayList<PhanLoai>) em.createNativeQuery(url, PhanLoai.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return listPhanLoai;
        }
        return listPhanLoai;
    }

    public PhanLoai getDLPhanLoaiSPTheoMa(long maPL) {
        return em.find(PhanLoai.class, maPL);
    }
    
    /**
     * lấy thông tin phân loại sản phảm theo tên
     * @param tenPhanLoai
     * @return 
     */
    public PhanLoai getPhanLoaiTheoTen(String tenPhanLoai){
        String sql = "select * from PhanLoai where tenPhanLoai = ?";
        try {
            et.begin();
            PhanLoai phanLoai = (PhanLoai) em.createNativeQuery(sql, PhanLoai.class)
                    .setParameter(1, tenPhanLoai)
                    .getSingleResult();
            et.commit();
            return phanLoai;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Thêm loai sản phẩm
     * @param phanLoai 
     */
    public void themLoaiSanPham(PhanLoai phanLoai) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(phanLoai);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }
    
    /**
     * Xóa dữ liệu loại sản phẩm trên database
     * @param maPhanLoai
     */
    public void xoaPhanLoaiSanPham(long maPhanLoai) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            PhanLoai phanLoai = em.find(PhanLoai.class, maPhanLoai);
            if (phanLoai == null) {
                return;
            }
            em.remove(phanLoai);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }
    
    /**
     * Cập nhật dữ liệu phân loại trên database
     * @param phanLoai
     */
    public void catNhatLoaiSanPham(PhanLoai phanLoai) {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            PhanLoai phanLoaiInDBS = em.find(PhanLoai.class, phanLoai.getMaPhanLoai());
            if (phanLoaiInDBS == null) {
                return;
            }
            phanLoaiInDBS = em.merge(phanLoai);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
    }
    
//    /**
//     * Tạo tự động mã
//     * @return
//     */
//    public String taoMaPhanLoai() {
//        Connection con = Connect.getInstance().getConnection();
//        String url = "select top 1 maPhanLoai from PhanLoai order by maPhanLoai desc";
//
//        try {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(url);
//            if(rs.next()) {
//                String maPhanLoai = rs.getString(1);
//                int so = Integer.parseInt(maPhanLoai.substring(4));
//                so++;
//                String maPhanLoaiMoi = so + "";
//                while(maPhanLoaiMoi.length() < 4) {
//                    maPhanLoaiMoi = "0" +maPhanLoaiMoi;
//
//                }
//                return "PL" + maPhanLoaiMoi;
//            } else {
//                return "PL0001";
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
