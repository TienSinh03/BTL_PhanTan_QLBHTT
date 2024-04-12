package fit.iuh.dao.impl;

import fit.iuh.dao.iSanPhamDao;
import fit.iuh.entity.SanPham;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao_SanPham implements iSanPhamDao {
    private EntityManager em;

    public Dao_SanPham() {
        em = Persistence.createEntityManagerFactory("JPADemo_SQL")
                .createEntityManager();
    }

    public Dao_SanPham(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<SanPham> getAllSanPham() {
        return em.createNamedQuery("getAllSanPham", SanPham.class)
                .getResultList();
    }

    @Override
    public List<SanPham> getAllQuanAo() {
        return em.createNamedQuery("getAllQuaNAo", SanPham.class)
                .getResultList();
    }

    @Override
    public List<SanPham> getAllPhuKien() {
        return em.createNamedQuery("getAllPhuKien", SanPham.class)
                .getResultList();
    }

    @Override
    public boolean addSanPham(SanPham sanPham) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(sanPham);
//            tx.commit();
            return true;
        } catch (RollbackException e) {
            e.printStackTrace();
            Throwable cause = e.getCause();
            if (cause != null) {
                System.err.println("Cause: " + cause);
            }
            if (tx.isActive()) {
                tx.rollback();
            }
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteSanPham(Long masp) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            SanPham sanPham = em.find(SanPham.class, masp);

//            em.detach(sanPham);
            em.remove(sanPham);

//            tx.commit();
            return true;

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<SanPham> findQuanAo(Long maSP, String tenSP, String tenPhanLoai, String tenNCC, String tenMauSac, String tenChatLieu, String tenKichThuoc) {
        return em.createNamedQuery("timKiemQuanAo", SanPham.class)
                .setParameter("maSP", maSP)
                .setParameter("tenSP", "%" + tenSP + "%")
                .setParameter("loaiSanPham", "%" + tenPhanLoai + "%")
                .setParameter("tenNCC", "%" + tenNCC + "%")
                .setParameter("mauSac", "%" + tenMauSac + "%")
                .setParameter("chatLieu", "%" + tenChatLieu + "%")
                .setParameter("kichThuoc", "%" + tenKichThuoc + "%")
                .getResultList();
    }

    @Override
    public List<SanPham> findPhuKien(Long maSP, String tenSP, String tenPhanLoai, String tenNCC, String tenMauSac, String tenChatLieu, String tenKichThuoc) {
        return em.createNamedQuery("timKiemQuanAo", SanPham.class)
                .setParameter("maSP", maSP)
                .setParameter("tenSP", "%" + tenSP + "%")
                .setParameter("loaiSanPham", "%" + tenPhanLoai + "%")
                .setParameter("tenNCC", "%" + tenNCC + "%")
                .setParameter("mauSac", "%" + tenMauSac + "%")
                .setParameter("chatLieu", "%" + tenChatLieu + "%")
                .setParameter("kichThuoc", "%" + tenKichThuoc + "%")
                .getResultList();
    }

    @Override
    public SanPham getSanPhamTheoMa(Long maSP) {
        return em.createNamedQuery("getSanPhamTheoMa", SanPham.class)
                .setParameter("maSP", maSP)
                .getSingleResult();
    }

    @Override
    public List<SanPham> getAllSanPhamTheoTieuChi(String mauSac, String chatLieu, String kichThuoc) {
        return em.createNamedQuery("getAllSanPhamTheoTieuChi", SanPham.class)
                .setParameter("mauSac", "%" + mauSac + "%")
                .setParameter("chatLieu", "%" + chatLieu + "%")
                .setParameter("kichThuoc", "%" + kichThuoc + "%")
                .getResultList();
    }

    @Override
    public List<SanPham> getAllSanPhamHetHang(String mauSac, String chatLieu, String kichThuoc) {
        return em.createNamedQuery("getAllSanPhamTheoTieuChi", SanPham.class)
                .setParameter("mauSac", "%" + mauSac + "%")
                .setParameter("chatLieu", "%" + chatLieu + "%")
                .setParameter("kichThuoc", "%" + kichThuoc + "%")
                .getResultList();
    }

    @Override
    public Map<Long, Integer> getSanPhamBanChay() {
        Map<Long, Integer> map = new HashMap<>();
        List<Object[]> list = em.createNamedQuery("getSanPhamBanChay", Object[].class)
                .getResultList();
//        Chạy end 5 for chạy tới 5
        for (int i = 0; i < 5; i++) {
            Object[] objects = list.get(i);
            Long productId = (Long) objects[0];
            Integer salesVolume = ((Number) objects[1]).intValue();
            map.put(productId, salesVolume);
        }
        return map;
//        for (Object[] objects : list) {
//            Long productId = (Long) objects[0];
//            Integer salesVolume = ((Number) objects[1]).intValue();
//            map.put(productId, salesVolume);
//        }
//        return map;
    }

    @Override
    public Map<Long, Integer> getSanPhamBanCham() {
        Map<Long, Integer> map = new HashMap<>();
        List<Object[]> list = em.createNamedQuery("getSanPhamBanCham", Object[].class)
                .getResultList();
        for (int i = 0; i < 5; i++) {
            Object[] objects = list.get(i);
            Long productId = (Long) objects[0];
            Integer salesVolume = ((Number) objects[1]).intValue();
            map.put(productId, salesVolume);
        }
        return map;
    }

    @Override
    public Map<Long, Integer> getSoLuongSPTheoMaPL() {
        Map<Long, Integer> map = new HashMap<>();
        List<Object[]> list = em.createNamedQuery("getSoLuongSPTheoMaPL", Object[].class)
                .getResultList();
        for (Object[] objects : list) {
            Long productId = (Long) objects[0];
            Integer salesVolume = ((Number) objects[1]).intValue();
            map.put(productId, salesVolume);
        }
        return map;    }

    @Override
    public List<SanPham> getAllSanPhamTheoNgay(Date ngayNhap, Date ngayKetThuc) {
        return em.createNamedQuery("getAllSanPhamTheoNgay", SanPham.class)
                .setParameter("ngayNhap", ngayNhap)
                .setParameter("ngayKetThuc", ngayKetThuc)
                .getResultList();
    }


    public void giamSoLuongSanPham(SanPham sp) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            SanPham sanPhamToUpdate = em.find(SanPham.class, sp.getMaSP());
            if (sanPhamToUpdate != null) {
                sanPhamToUpdate.setSoLuong(sanPhamToUpdate.getSoLuong() - sp.getSoLuong());
                em.merge(sanPhamToUpdate);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void tangSoLuongSanPham(SanPham sp) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            SanPham sanPhamToUpdate = em.find(SanPham.class, sp.getMaSP());
            if (sanPhamToUpdate != null) {
                sanPhamToUpdate.setSoLuong(sanPhamToUpdate.getSoLuong() + sp.getSoLuong());
                em.merge(sanPhamToUpdate);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

}
