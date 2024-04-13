/**
 * @ (#) Dao_KichThuoc.java      4/11/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package fit.iuh.dao.impl;

import fit.iuh.dao.IKichThuocDao;
import fit.iuh.entity.KichThuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 4/11/2024
 */
public class Dao_KichThuoc implements IKichThuocDao {

    private EntityManager em = null;
    private EntityTransaction tx = null;

    public Dao_KichThuoc() {
        em = Persistence.createEntityManagerFactory("JPADemo_SQL").createEntityManager();
        tx = em.getTransaction();
    }

    /**
     * Lấy tất cả dữ liệu kích thước
     *
     * @return
     */
    @Override
    public ArrayList<KichThuoc> getAllKichThuoc() {
        String query = "select kt from KichThuoc kt";
        List<KichThuoc> listKichThuoc = null;
        try {
            tx.begin();
            listKichThuoc = em.createQuery(query, KichThuoc.class).getResultList();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return (ArrayList<KichThuoc>) listKichThuoc;
    }

    /**
     * Lấy dữ liệu kích thước theo mã
     *
     * @param maKT
     * @return
     */
    @Override
    public KichThuoc getDLKichThuocTheoMa(long maKT) {
        try {
            tx.begin();
            KichThuoc kichThuoc = em.find(KichThuoc.class, maKT);
            tx.commit();
            return kichThuoc;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return null;
    }

    /**
     * Lấy dữ liệu kích thước theo tên
     *
     * @param tenKichThuoc
     * @return
     */
    public KichThuoc getKichThuocTheoTen(String tenKichThuoc) {

        String sql = "select kt from KichThuoc kt where kt.kichThuoc = :tenKichThuoc";
        try {
            tx.begin();
            KichThuoc kichThuoc = em.createQuery(sql, KichThuoc.class).setParameter("tenKichThuoc", tenKichThuoc).getSingleResult();
            tx.commit();
            return kichThuoc;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }

        return null;
    }

    /**
     * Them Kichs thuoc
     *
     * @param kichThuoc
     */
    @Override
    public boolean themDLKichThuoc(KichThuoc kichThuoc) {
        try {
            tx.begin();
            em.persist(kichThuoc);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return false;
    }

    /**
     * Xóa dữ liệu Kich Thuoc trên database
     *
     * @param maKichThuoc
     */
    @Override
    public boolean xoaDLKichThuoc(long maKichThuoc) {

        String query = "delete from KichThuoc where maKichThuoc = :maKichThuoc";
        try {
            tx.begin();
            em.createQuery(query).setParameter("maKichThuoc", maKichThuoc).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return false;
    }

    /**
     * Cập nhật dữ liệu  Kich Thuoc trên database
     *
     * @param kichThuoc
     */
    @Override
    public boolean capNhatDLKichThuoc(KichThuoc kichThuoc) {
        try {
            tx.begin();
            em.merge(kichThuoc);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        return false;
    }
}
