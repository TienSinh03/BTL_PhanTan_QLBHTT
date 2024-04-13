/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao.impl;


import fit.iuh.dao.iTaiKhoanDao;
import fit.iuh.entity.NhanVien;
import fit.iuh.entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author phant
 */
public class Dao_TaiKhoan implements iTaiKhoanDao {
    private EntityManager em;

    public Dao_TaiKhoan() {
        em = Persistence.createEntityManagerFactory("JPADemo_SQL")
                .createEntityManager();
    }

    public Dao_TaiKhoan(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<TaiKhoan> getAllTaiKhoan() {
        return em.createNamedQuery("TaiKhoan.getAll", TaiKhoan.class).getResultList();
    }

    @Override
    public List<TaiKhoan> getTrangThai() {
        return em.createNamedQuery("TaiKhoan.getTrangThai", TaiKhoan.class).getResultList();
    }

    @Override
    public boolean addTaiKhoan(TaiKhoan taiKhoan) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(taiKhoan);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTrangThai(Long maNv) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            TaiKhoan taiKhoan = em.find(TaiKhoan.class, maNv);
            taiKhoan.setTrangThai(false);
            em.merge(taiKhoan);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateTrangThai(Long maNv) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            TaiKhoan taiKhoan = em.find(TaiKhoan.class, maNv);
            taiKhoan.setTrangThai(true);
            em.merge(taiKhoan);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean doiMtatKhau(Long maNv, String matKhau) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            TaiKhoan taiKhoan = em.find(TaiKhoan.class, maNv);
            taiKhoan.setMatKhau(matKhau);
            em.merge(taiKhoan);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public TaiKhoan kiemTraTaiKhoan(TaiKhoan taiKhoan) {
        return em.createNamedQuery("TaiKhoan.kiemTraTaiKhoan", TaiKhoan.class)
                .setParameter("tenTaiKhoan", taiKhoan.getTenTaiKhoan())
                .setParameter("matKhau", taiKhoan.getMatKhau())
                .getSingleResult();
    }

    @Override
    public void getMatKhau(String tenTaiKhoan) {
        List<String> list= em.createNamedQuery("TaiKhoan.getMatKhau", String.class)
                .setParameter("ten", tenTaiKhoan)
                .getResultList();
        if(list.isEmpty()){
            System.out.println("Không tìm thấy tài khoản");
        }else {
            System.out.println(list.get(1));
        }
    }

    @Override
    public TaiKhoan getTaiKhoanByMaNV(Long maNV) {
        return em.createNamedQuery("TaiKhoan.getTaiKhoanByMaNV", TaiKhoan.class)
                .setParameter("maNV", maNV)
                .getSingleResult();

    }

    @Override
    public boolean datLaiMatKhau(TaiKhoan taiKhoan, Long maNV) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            TaiKhoan taiKhoan1 = em.find(TaiKhoan.class, maNV);
            taiKhoan1.setMatKhau(taiKhoan.getMatKhau());
            em.merge(taiKhoan1);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }


//
//
//    public TaiKhoan getTaiKhoanNV(String maNVTim) {
//        daoNhanVien = new Dao_NhanVien();
//
//        Connection con = Connect.getInstance().getConnection();
//        PreparedStatement prestmt = null;
//        String url = "select * from TaiKhoan where maNV = ?";
//        try {
//            prestmt = con.prepareStatement(url);
//            prestmt.setString(1, maNVTim);
//
//            ResultSet rs = prestmt.executeQuery();
//            while(rs.next()) {
//                String maNV = rs.getString(4);
//                NhanVien nhanVien = daoNhanVien.getNhanVienTheoMa(maNV);
//
//                TaiKhoan taiKhoan = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), nhanVien, rs.getBoolean(5));
//                return taiKhoan;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    /**
//     * Đặt lại mật khẩu tài khoản
//     * @param taiKhoan
//     */
//    public void datLaiMatKhau(TaiKhoan taiKhoan, String matKhau) {
//       Connection con = Connect.getInstance().getConnection();
//        PreparedStatement prestmt = null;
//        String url = "update TaiKhoan set matKhau = ? where tenTaiKhoan = ?";
//        try {
//            prestmt = con.prepareStatement(url);
//
//            prestmt.setString(1, matKhau);
//            prestmt.setString(2, taiKhoan.getTenTaiKhoan());
//            prestmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }  finally {
//            try {
//                 prestmt.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
