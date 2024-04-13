/**
 * @ (#) TestDaoCTPhieuDat.java      4/11/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package dao;

import fit.iuh.dao.impl.Dao_CTPhieuDatHang;
import fit.iuh.dao.impl.Dao_PhieuDatHang;
import fit.iuh.entity.CTPhieuDatHang;
import fit.iuh.entity.PhieuDatHang;
import fit.iuh.entity.SanPham;
import jakarta.persistence.*;
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
public class TestDaoCTPhieuDat {
    private Dao_CTPhieuDatHang daoCTPhieuDat;
    private Dao_PhieuDatHang daoPhieuDatHang;
    EntityManager em = Persistence.createEntityManagerFactory("JPADemo_SQL").createEntityManager();
    EntityTransaction tx = em.getTransaction();

    @BeforeAll
    public void init() {
        daoCTPhieuDat = new Dao_CTPhieuDatHang();
        daoPhieuDatHang = new Dao_PhieuDatHang();
    }

    @Test
    public void testGetAllCTPhieuDatHang() {
        daoCTPhieuDat.getAllCTPhieuDatHang(1).forEach(System.out::println);
    }

    @Test
    public void testThemCTPDT() {
        PhieuDatHang pdt = daoPhieuDatHang.getPDTTheoMa(2);
        System.out.println(pdt);
        SanPham sp = em.find(SanPham.class, 3);
        CTPhieuDatHang ctpdt = new CTPhieuDatHang(sp, pdt, 10);
        System.out.println(ctpdt);
        boolean check = daoCTPhieuDat.themCTPDT(ctpdt);
        Assertions.assertTrue(check);
    }

    @Test
    public void testXoaCTPhieuDatHang() {
        boolean check = daoCTPhieuDat.xoaCTPhieuDatHang(2);
        Assertions.assertTrue(check);
    }
}
