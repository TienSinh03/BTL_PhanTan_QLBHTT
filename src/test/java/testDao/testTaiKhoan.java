package testDao;

import fit.iuh.dao.iTaiKhoanDao;
import fit.iuh.dao.impl.Dao_TaiKhoan;
import fit.iuh.entity.NhanVien;
import fit.iuh.entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class testTaiKhoan {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPADemo_SQL");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    private Dao_TaiKhoan taiKhoanDao;

    @BeforeAll
    public void setUp() {
        taiKhoanDao = new Dao_TaiKhoan(em);
    }

    @Test
    public void testGetAllTaiKhoan() {
        System.out.println(taiKhoanDao.getAllTaiKhoan());
    }

    @Test
    public void testGetTrangThai() {
        System.out.println(taiKhoanDao.getTrangThai());
    }

    @Test
    public void addTaiKhoan() {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenTaiKhoan("admin");
        taiKhoan.setMatKhau("2222");
        taiKhoan.setTrangThai(true);
        taiKhoan.setPhanQuyen("Nhân viên");


        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNV(5L);
        taiKhoan.setNhanVien(nhanVien);


        boolean checked = taiKhoanDao.addTaiKhoan(taiKhoan);

    }

    @Test
    public void deleteTaiKhoan() {
        boolean checked = taiKhoanDao.deleteTrangThai(5L);
    }

    @Test
    public void updateTaiKhoan() {
        boolean checked = taiKhoanDao.updateTrangThai(5L);
    }

    @Test
    public void testDoiMatKhau() {
        boolean checked = taiKhoanDao.doiMtatKhau(5L, "111222");
        System.out.println(checked);
    }

    @Test
    public void kiemTraDangNhap() {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenTaiKhoan("Admin");
        taiKhoan.setMatKhau("admin");
        taiKhoan.setTrangThai(true);
        taiKhoan.setPhanQuyen("Quản lý");
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNV(1L);
        taiKhoan.setNhanVien(nhanVien);
        taiKhoanDao.kiemTraTaiKhoan(taiKhoan);

    }

    @Test
    public void testGetMatKhau() {

        taiKhoanDao.getMatKhau("admin");

    }

    @Test
    public void testGetTaiKhoanByMaNV() {
        System.out.println(taiKhoanDao.getTaiKhoanByMaNV(1L));
    }

    @Test
    public void testDatLaiMatKhau() {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenTaiKhoan("admin");
        taiKhoan.setMatKhau("333333");
        taiKhoan.setTrangThai(true);
        taiKhoan.setPhanQuyen("Nhân viên");
        taiKhoanDao.datLaiMatKhau(taiKhoan, 5L);

    }

    @AfterAll
    public void tearDown() {
        em.close();
        emf.close();
    }


}
