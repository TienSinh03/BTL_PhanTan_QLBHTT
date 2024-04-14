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
        System.out.println(taiKhoanDao.getAllTaiKhoanConHoatDong());
    }

    @Test
    public void addTaiKhoan() {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTenTaiKhoan("NV004");
        taiKhoan.setMatKhau("2222");
        taiKhoan.setTrangThai(true);
        taiKhoan.setPhanQuyen("Nhân viên");


        NhanVien nhanVien = em.find(NhanVien.class, 4);
        taiKhoan.setNhanVien(nhanVien);


        boolean checked = taiKhoanDao.themTaiKhoan(taiKhoan);

    }

    @Test
    public void deleteTaiKhoan() {
        boolean checked = taiKhoanDao.xoaTaiKhoan(4L);
    }

    @Test
    public void updateTaiKhoan() {
        boolean checked = taiKhoanDao.capNhatTaiKhoan(4L);
    }

    @Test
    public void testDoiMatKhau() {
        TaiKhoan tk = taiKhoanDao.getTaiKhoanNV(4L);
        tk.setMatKhau("1212");
        taiKhoanDao.doiMatKhauTaiKhoan(tk);
        System.out.println(tk);
//        System.out.println(checked);
    }

    @Test
    public void kiemTraDangNhap() {
        TaiKhoan taiKhoan = taiKhoanDao.dangNhapTaiKhoan("Admin", "admin");
        System.out.println(taiKhoan);
    }

    @Test
    public void testGetMatKhau() {
        System.out.println(taiKhoanDao.getMatKhau("Admin"));
    }

    @Test
    public void testGetTaiKhoanByMaNV() {
        System.out.println(taiKhoanDao.getTaiKhoanNV(1L));
    }

    @Test
    public void testDatLaiMatKhau() {
        TaiKhoan tk = taiKhoanDao.getTaiKhoanNV(4L);
        taiKhoanDao.datLaiMatKhau(tk, "1121");

    }

    @AfterAll
    public void tearDown() {
        em.close();
        emf.close();
    }


}
