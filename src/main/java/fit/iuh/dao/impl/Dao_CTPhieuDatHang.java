/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao.impl;

import fit.iuh.dao.ICTPhieuDatHangDao;
import fit.iuh.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author phant
 */
public class Dao_CTPhieuDatHang implements ICTPhieuDatHangDao {
    //    private Dao_SanPham dao_SanPham = new Dao_SanPham();
//    private Dao_PhieuDatHang dao_PhieuDatHang = new Dao_PhieuDatHang();
//
    EntityManager em = null;
    EntityTransaction tx = null;

    public Dao_CTPhieuDatHang() {
        em = Persistence.createEntityManagerFactory("JPADemo_SQL").createEntityManager();
        tx = em.getTransaction();
    }

    /**
     * Lấy Chi tiết phieu dat hang theo mã phieu dat hang
     *
     * @param maPhieuDatHang
     * @return
     */
    @Override
    public ArrayList<CTPhieuDatHang> getAllCTPhieuDatHang(long maPhieuDatHang) {
        String query = "Select ctpdt from CTPhieuDatHang ctpdt where ctpdt.phieuDatHang.maPhieuDat = :maPhieuDatHang";
        List<CTPhieuDatHang> list = null;
        try {
            tx.begin();
            list = em.createQuery(query, CTPhieuDatHang.class).setParameter("maPhieuDatHang", maPhieuDatHang).getResultList();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return (ArrayList<CTPhieuDatHang>) list;
    }
    @Override
    public boolean themCTPDT(CTPhieuDatHang ctpdt) {
        try {
            tx.begin();
            em.persist(ctpdt);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean xoaCTPhieuDatHang(long maPhieuDatHang) {
        String url = "DELETE FROM CTPhieuDatHang ctpdh WHERE ctpdh.phieuDatHang.maPhieuDat = :maPhieuDatHang";
        try {
            tx.begin();
            em.createQuery(url).setParameter("maPhieuDatHang", maPhieuDatHang).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }
}