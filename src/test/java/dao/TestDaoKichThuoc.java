/**
 * @ (#) TestDaoKichThuoc.java      4/11/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package dao;

import fit.iuh.dao.impl.Dao_KichThuoc;
import fit.iuh.entity.KichThuoc;
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
public class TestDaoKichThuoc {
    private Dao_KichThuoc dao_kichThuoc;

    @BeforeAll
    public void init(){
        dao_kichThuoc = new Dao_KichThuoc();
    }

    @Test
    public void testGetAllKichThuoc(){
        dao_kichThuoc.getAllKichThuoc().forEach(System.out::println);
    }

    @Test
    public void testGetDLKichThuocTheoMa(){
        System.out.println(dao_kichThuoc.getDLKichThuocTheoMa(1));
    }

    @Test
    public void testGetKichThuocTheoTen(){
        System.out.println(dao_kichThuoc.getKichThuocTheoTen("M"));
    }

    @Test
    public void testThemDLKichThuoc(){
        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setKichThuoc("3XL");
        boolean check = dao_kichThuoc.themDLKichThuoc(kichThuoc);
        Assertions.assertTrue(check);
    }

    @Test
    public void testXoaDLKichThuoc(){
        boolean check = dao_kichThuoc.xoaDLKichThuoc(6);
        Assertions.assertTrue(check);
    }

    @Test
    public void testCapNhatDLKichThuoc(){
        KichThuoc kichThuoc = dao_kichThuoc.getDLKichThuocTheoMa(6);
        kichThuoc.setKichThuoc("4XL");
        boolean check = dao_kichThuoc.capNhatDLKichThuoc(kichThuoc);
        Assertions.assertTrue(check);
    }
}
