package dao;/*
 * @ (#) PhanLoaiImpl_Test.java     1.0   4/13/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

import fit.iuh.dao.impl.Dao_PhanLoai;
import fit.iuh.entity.PhanLoai;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/13/2024
 * @version:  1.0
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PhanLoaiImpl_Test {
    private Dao_PhanLoai phanLoaiImpl;

    @BeforeAll
    public void setUp() {
        phanLoaiImpl = new Dao_PhanLoai();
    }

    @Test
    public void testGetAllPhanLoai() {
        phanLoaiImpl.getAllPhanLoai().forEach(System.out::println);
    }

    @Test
    public void testgetAllPhanLoaiCuaPhuKien() {
        phanLoaiImpl.getAllPhanLoaiCuaPhuKien().forEach(System.out::println);
    }

    @Test
    public void testgetDLPhanLoaiSPTheoMa() {
        System.out.println(phanLoaiImpl.getDLPhanLoaiSPTheoMa(3));
    }

    @Test
    public void testgetPhanLoaiTheoTen(){
        System.out.println(phanLoaiImpl.getPhanLoaiTheoTen("Nón"));
    }

    @Test
    public void testthemLoaiSanPham(){
        phanLoaiImpl.themLoaiSanPham(new PhanLoai(6, "Ca vat"));
    }

    @Test
    public void testXoaPhanLoaiSanPham(){
        phanLoaiImpl.xoaPhanLoaiSanPham(6);
    }

    @Test
    public void testCapNhatPhanLoaiSanPham(){
        phanLoaiImpl.catNhatLoaiSanPham(new PhanLoai(5, "Ca vat"));
    }
}

