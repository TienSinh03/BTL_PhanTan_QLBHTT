package fit.iuh.dao.impl;

import fit.iuh.dao.iSanPhamDao;
import fit.iuh.entity.PhanLoai;
import fit.iuh.entity.SanPham;
import jakarta.persistence.*;

import java.util.*;

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
    public ArrayList<SanPham> getAllSanPham() {
        return (ArrayList<SanPham>) em.createNamedQuery("getAllSanPham", SanPham.class)
                .getResultList();
    }

    @Override
    public ArrayList<SanPham> getAllQuanAo() {
        return (ArrayList<SanPham>) em.createNamedQuery("getAllQuaNAo", SanPham.class)
                .getResultList();
    }

    @Override
    public ArrayList<SanPham> getAllPhuKien() {
        return (ArrayList<SanPham>) em.createNamedQuery("getAllPhuKien", SanPham.class)
                .getResultList();
    }

    @Override
    public boolean themSanPham(SanPham sanPham) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(sanPham);
            tx.commit();
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
    public boolean xoaSanPham(long masp) {
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
    public boolean capNhatSanPham(SanPham sanPham) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(sanPham);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ArrayList<SanPham> timKiemQuanAo(long maSP, String tenSP, String tenPhanLoai, String tenNCC, String tenMauSac, String tenChatLieu, String tenKichThuoc) {
        return (ArrayList<SanPham>) em.createNamedQuery("timKiemQuanAo", SanPham.class)
                .setParameter("maSPCheck", maSP==0 ? "" : String.valueOf(maSP))
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
    public ArrayList<SanPham> timKiemPhuKien(long maSP, String tenSP, String tenPhanLoai, String tenNCC, String tenMauSac, String tenChatLieu, String tenKichThuoc) {

        return (ArrayList<SanPham>) em.createNamedQuery("timKiemPhuKien", SanPham.class)
                .setParameter("maSPCheck", maSP==0 ? "" : String.valueOf(maSP))
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
    public SanPham getSanPhamTheoMa(long maSP) {
        return em.createNamedQuery("getSanPhamTheoMa", SanPham.class)
                .setParameter("maSP", maSP)
                .getSingleResult();
    }

    @Override
    public ArrayList<SanPham> getAllSanPhamTheoTieuChi(String maPhanLoai, String maMauSac, String maKichThuoc) {
        return (ArrayList<SanPham>) em.createNamedQuery("getAllSanPhamTheoTieuChi", SanPham.class)
                .setParameter("maPhanLoai", "%" + maPhanLoai + "%")
                .setParameter("mauSac", "%" + maMauSac + "%")
                .setParameter("kichThuoc", "%" + maKichThuoc + "%")
                .getResultList();
    }

    @Override
    public ArrayList<SanPham> getAllSanPhamHetHang(String maPhanLoai, String maMauSac, String maKichThuoc) {
        return (ArrayList<SanPham>) em.createNamedQuery("getAllSanPhamHetHang", SanPham.class)
                .setParameter("maPhanLoai", "%" + maPhanLoai + "%")
                .setParameter("mauSac", "%" + maMauSac + "%")
                .setParameter("kichThuoc", "%" + maKichThuoc + "%")
                .getResultList();
    }

    @Override
    public ArrayList<SanPham> getSanPhamBanChay() {
        EntityTransaction tx = em.getTransaction();
        String query = "SELECT sp.maSP,  SUM(cthd.soLuong) FROM SanPham sp JOIN  CTHD cthd ON sp.maSP = cthd.sanPham.maSP GROUP BY sp.maSP ORDER BY SUM(cthd.soLuong)  DESC";
        List<SanPham> list = new ArrayList<>();
        try {
            List<Object[]> results = em.createQuery(query, Object[].class).setMaxResults(5).getResultList();
            for (Object[] result : results) {
                SanPham sanPham = em.find(SanPham.class, (Long) result[0]);
                list.add(sanPham);
            }
            return (ArrayList<SanPham>) list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<SanPham> getSanPhamBanCham() {
        EntityTransaction tx = em.getTransaction();
        String query = "SELECT sp.maSP,  SUM(cthd.soLuong) FROM SanPham sp JOIN  CTHD cthd ON sp.maSP = cthd.sanPham.maSP GROUP BY sp.maSP ORDER BY SUM(cthd.soLuong)  ASC";
        List<SanPham> list = new ArrayList<>();
        try {
            List<Object[]> results = em.createQuery(query, Object[].class).setMaxResults(5).getResultList();
            for (Object[] result : results) {
                SanPham sanPham = em.find(SanPham.class, (Long) result[0]);
                list.add(sanPham);
            }
            return (ArrayList<SanPham>) list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public ArrayList<SanPham> getSoLuongSPTheoMaPL() {
        EntityTransaction tx = em.getTransaction();
        String query = "SELECT sp.phanLoai.maPhanLoai, COUNT(sp) FROM SanPham sp GROUP BY sp.phanLoai.maPhanLoai ORDER BY sp.phanLoai.maPhanLoai";
        List<SanPham> list = new ArrayList<>();
        try {
            List<Object[]> results = em.createQuery(query, Object[].class).getResultList();
            for (Object[] result : results) {
                PhanLoai phanLoai = em.find(PhanLoai.class, (Long) result[0]);
                Long soLuong = (Long) result[1];
                SanPham sanPham = new SanPham(soLuong.intValue(), phanLoai);
                list.add(sanPham);
            }
            return (ArrayList<SanPham>) list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<SanPham> getAllSanPhamTheoNgay(String tuNgay, String denNgay) {
        Date ngayNhap = java.sql.Date.valueOf(tuNgay);
        Date ngayKetThuc = java.sql.Date.valueOf(denNgay);
        return (ArrayList<SanPham>) em.createNamedQuery("getAllSanPhamTheoNgay", SanPham.class)
                .setParameter("ngayNhap", ngayNhap)
                .setParameter("ngayKetThuc", ngayKetThuc)
                .getResultList();
    }

    @Override
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

    @Override
    public void tangSoLuongSanPham(long maSP, int soLuong) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            SanPham sanPhamToUpdate = em.find(SanPham.class, maSP);
            if (sanPhamToUpdate != null) {
                sanPhamToUpdate.setSoLuong(sanPhamToUpdate.getSoLuong() + soLuong);
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
