package fit.iuh.dao.impl;

import fit.iuh.dao.iNhaCungCap;
import fit.iuh.entity.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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
    public List<NhaCungCap> getAllNhaCungCap() {
        return em.createNamedQuery("NhaCungCap.getAll", NhaCungCap.class)
                .getResultList();
    }

    @Override
    public boolean addNhaCungCap(NhaCungCap nhaCungCap) {
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
    public boolean deleteNhaCungCap(Long maNCC) {
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
    public boolean updateNhaCungCap(Long maNCC, NhaCungCap nhaCungCap) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            NhaCungCap ncc = em.find(NhaCungCap.class, maNCC);
            ncc.setTenNCC(nhaCungCap.getTenNCC());
            ncc.setDiaChi(nhaCungCap.getDiaChi());
            ncc.setSdt(nhaCungCap.getSdt());
            ncc.setEmail(nhaCungCap.getEmail());
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
    public List<NhaCungCap> findNhaCungCap(Long maNCC, String tenNCC, String sdt, String email) {
        List<NhaCungCap> nhaCungCap = em.createNamedQuery("NhaCungCap.findNhaCungCap", NhaCungCap.class)
                .setParameter("maNCC", String.valueOf(maNCC)) // convert Long to String
                .setParameter("tenNCC", tenNCC)
                .setParameter("sdt", sdt)
                .setParameter("email", email)
                .getResultList();
        return nhaCungCap;

    }

    @Override
    public List<NhaCungCap> getNhaCungCapTheoTen(String tenNCC) {
        List<NhaCungCap> nhaCungCap = em.createNamedQuery("NhaCungCap.findTenNhaCungCap", NhaCungCap.class)
                .setParameter("tenNCC", tenNCC)
                .getResultList();
        return nhaCungCap;
    }

    @Override
    public List<NhaCungCap> getNhaCungCapTheoMa(Long maNCC) {
        List<NhaCungCap> nhaCungCap = em.createNamedQuery("NhaCungCap.findNhaCungCapTheoMa", NhaCungCap.class)
                .setParameter("maNCC", String.valueOf(maNCC))
                .getResultList();
        return nhaCungCap;
    }


}
