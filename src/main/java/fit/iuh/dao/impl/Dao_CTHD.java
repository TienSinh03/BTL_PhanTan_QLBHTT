package fit.iuh.dao.impl;

import fit.iuh.dao.ICTHDDao;
import fit.iuh.dao.ICTHDDao;
import fit.iuh.entity.CTHD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dao_CTHD implements ICTHDDao {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction et;

    public Dao_CTHD() {
        emf = Persistence.createEntityManagerFactory("JPADemo_SQL");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @Override
    public ArrayList<CTHD> getAllCTHD(long maHD) {
        ArrayList<CTHD> listCTHD = new ArrayList<>();
        String sql = "select cthd from CTHD cthd where cthd.hoaDon.maHoaDon = :maHD";
        try {
            et.begin();
            listCTHD = (ArrayList<CTHD>) em.createQuery(sql).setParameter("maHD", maHD).getResultList();
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return listCTHD;
    }

    @Override
    public Boolean themCTHD(CTHD cthd) {
        try {
            et.begin();
            em.persist(cthd);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public double tinhThanhTienSanPham(long maHD, long maSP) {
        String url = "select hd.maHoaDon, cthd.soLuong*sp.giaBan as thanhTien from HoaDon hd JOIN CTHD cthd ON hd.maHoaDon = cthd.hoaDon.maHoaDon JOIN SanPham sp ON cthd.sanPham.maSP = sp.maSP where hd.maHoaDon = :maHD and cthd.sanPham.maSP = :maSP";
        try {
            et.begin();
            List<Object[]> list = em.createQuery(url, Object[].class).setParameter("maHD", maHD).setParameter("maSP", maSP).getResultList();
            et.commit();
            for (Object[] obj : list) {
                return (double) obj[1];
            }
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public double getTongDoanhThu(long maSP, String thangLap, String namLap) {
        String url = "SELECT SUM(cthd.soLuong * sp.giaBan) AS DoanhThu FROM CTHD cthd JOIN SanPham sp on cthd.sanPham.maSP=sp.maSP JOIN HoaDon hd on cthd.hoaDon.maHoaDon=hd.maHoaDon WHERE sp.maSP = :maSP and month(hd.ngayNhap) = :thangLap and year(hd.ngayNhap) = :namLap";
        try {
            et.begin();
            List<Object> results = em.createQuery(url,Object.class).setParameter("maSP", maSP)
                    .setParameter("thangLap", Integer.parseInt(thangLap))
                    .setParameter("namLap", Integer.parseInt(namLap))
                    .getResultList();
            et.commit();
            for (Object obj : results) {
                return (double) obj;
            }
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return 0.0;
    }

    @Override
    public int getSoLuongSanPhamBanDuoc(long maSP, String thangLap, String namLap) {
        String url = "SELECT sp.maSP, SUM(cthd.soLuong) as tongSoLuongBan from SanPham sp JOIN CTHD cthd ON sp.maSP = cthd.sanPham.maSP JOIN HoaDon hd ON cthd.hoaDon.maHoaDon = hd.maHoaDon WHERE sp.maSP = :maSP and month(hd.ngayNhap) = :thangLap and year(hd.ngayNhap) = :namLap group by sp.maSP";
        try {
            et.begin();
            List<Object[]> results = em.createQuery(url, Object[].class)
                    .setParameter("maSP", maSP)
                    .setParameter("thangLap", Integer.parseInt(thangLap))
                    .setParameter("namLap", Integer.parseInt(namLap))
                    .getResultList();
            et.commit();
            for (Object[] obj : results) {
                Long tongSoLuongBan = (Long) obj[1];
                return tongSoLuongBan.intValue(); // Chuyển đổi Long thành int
            }

        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return 0;
    }

    @Override
    public double getDoanhThuSanPhamBanDuoc(long maSP, String thangLap, String namLap) {
        String url = "SELECT sum(cthd.soLuong*sp.giaBan) as doanhThu from HoaDon hd join CTHD cthd on hd.maHoaDon=cthd.hoaDon.maHoaDon join SanPham sp on cthd.sanPham.maSP=sp.maSP WHERE sp.maSP = :maSP and month(hd.ngayNhap) = :thangLap and year(hd.ngayNhap) = :namLap group by sp.maSP";
        try {
            et.begin();
            List<Object> results = em.createQuery(url, Object.class)
                    .setParameter("maSP", maSP)
                    .setParameter("thangLap", Integer.parseInt(thangLap))
                    .setParameter("namLap", Integer.parseInt(namLap))
                    .getResultList();
            et.commit();
            for (Object obj : results) {return (double) obj;
            }
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
        return 0;
    }

    public void close() {
        em.close();
        emf.close();
    }
}

