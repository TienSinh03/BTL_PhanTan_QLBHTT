package fit.iuh.dao.impl;

import fit.iuh.dao.iNhaCungCap;
import fit.iuh.entity.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Dao_NhaCungCap implements iNhaCungCap {
    private EntityManager em;

    public Dao_NhaCungCap() {
        em = Persistence.createEntityManagerFactory("JPADemo_SQL")
                .createEntityManager();
    }

    public Dao_NhaCungCap(EntityManager em) {
        this.em = em;
    }

    @Override
    public ArrayList<NhaCungCap> getAllNhaCungCap() {
        return (ArrayList<NhaCungCap>) em.createNamedQuery("NhaCungCap.getAll", NhaCungCap.class)
                .getResultList();
    }

    @Override
    public boolean themNhaCungCap(NhaCungCap nhaCungCap) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(nhaCungCap);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean xoaNhaCungCap(Long maNCC) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            NhaCungCap nhaCungCap = em.find(NhaCungCap.class, maNCC);
            em.remove(nhaCungCap);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean capNhatNhaCungCap(NhaCungCap ncc) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(ncc);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public NhaCungCap timKiemNhaCungCap(Long maNCC, String tenNCC, String sdt, String email) {
        return em.createNamedQuery("NhaCungCap.findNhaCungCap", NhaCungCap.class)
                .setParameter("maNCC", String.valueOf(maNCC)) // convert Long to String
                .setParameter("tenNCC", tenNCC)
                .setParameter("sdt", sdt)
                .setParameter("email", email)
                .getSingleResult();


    }

    @Override
    public NhaCungCap getNhaCungCapTheoTen(String tenNCC) {
        return em.createNamedQuery("NhaCungCap.findTenNhaCungCap", NhaCungCap.class)
                .setParameter("tenNCC", tenNCC)
                .getSingleResult();

    }

    @Override
    public NhaCungCap getNhaCungCapTheoMa(Long maNCC) {
        return em.createNamedQuery("NhaCungCap.findNhaCungCapTheoMa", NhaCungCap.class)
                .setParameter("maNCC", String.valueOf(maNCC))
                .getSingleResult();
    }


}
