/**
 * @ (#) TestDaoPhieuDatHang.java      4/11/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package dao;

import fit.iuh.dao.impl.Dao_PhieuDatHang;
import fit.iuh.entity.KhachHang;
import fit.iuh.entity.NhanVien;
import fit.iuh.entity.PhieuDatHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 4/11/2024
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDaoPhieuDatHang {
    EntityManager em = Persistence.createEntityManagerFactory("JPADemo_SQL").createEntityManager();
    EntityTransaction tx = em.getTransaction();
    private Dao_PhieuDatHang daoPhieuDatHang;

    @BeforeAll
    public void init() {
        daoPhieuDatHang = new Dao_PhieuDatHang();
    }

    @Test
    public void testGetAllPhieuDatHang() {
        daoPhieuDatHang.getAllPhieuDatHang().forEach(System.out::println);
    }

    @Test
    public void testThemPhieuDatHang() {
        KhachHang kh = em.find(KhachHang.class, 4);
        NhanVien nv = em.find(NhanVien.class, 1);

        PhieuDatHang pdt = new PhieuDatHang();
        pdt.setKhachHang(kh);
        pdt.setNhanVien(nv);
        pdt.setNgayLap(java.sql.Date.valueOf("2024-04-10"));
        boolean result = daoPhieuDatHang.themPhieuDatHang(pdt);
        Assertions.assertTrue(result);
    }

    @Test
    public void testXoaPhieuDatHang() {
        boolean result = daoPhieuDatHang.xoaPhieuDatHang(4);
        Assertions.assertTrue(result);
    }

    @Test
    public void testGetPDTTheoMa() {
        PhieuDatHang pdt = daoPhieuDatHang.getPDTTheoMa(1);
        System.out.println(pdt);
    }

    @Test
    public void testGetPDTTheoMaKH() {
        PhieuDatHang pdt = daoPhieuDatHang.getPDTTheoMaKH(3);
        System.out.println(pdt);
    }

}