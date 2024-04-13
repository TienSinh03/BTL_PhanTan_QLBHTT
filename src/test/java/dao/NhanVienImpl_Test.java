package dao;/*
 * @ (#) NhanVienImpl_Test.java     1.0   4/13/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

import fit.iuh.dao.impl.Dao_NhanVien;
import fit.iuh.entity.NhanVien;
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
public class NhanVienImpl_Test {
    private Dao_NhanVien nhanVienImpl;

    @BeforeAll
    public void setUp() {
        nhanVienImpl = new Dao_NhanVien();
    }

    @Test
    public void testGetAllNhanVien() {
        nhanVienImpl.getAllNhanVien().forEach(System.out::println);
    }

    @Test
    public void testGetAllNhanVienConHoaDong(){
        nhanVienImpl.getAllNhanVienConHoaDong().forEach(System.out::println);
    }

    @Test
    public void testAddNhanVien() {
        //String hoTen, String chuVu, String email, String sdt, String diaChi, String gioiTinh, boolean trangThai
        nhanVienImpl.themNhanVien(new NhanVien("Nguyen Van A", "NhanVien", "nguyenvana@gmail.com", "0123456789", "Quan 1, TP.HCM", "Nam", true));
    }

    @Test
    public void testUpdateNhanVien(){
        NhanVien nhanVien = Dao_NhanVien.getNhanVienTheoMa(4);
        nhanVien.setEmail("hehe@gmail.com");
        nhanVienImpl.capNhatNhanVien(nhanVien);
    }

    @Test
    public void testTimKiemNhanVien(){
        //Parameter: String maNV, String tenNV, String sdt, String email, String chucVu, String diaChi, boolean trangThai
//        nhanVienImpl.timKiemNhanVien(4, "Nguyen", "0123456789", "nguyenvana2222@gmail.com", "QuanLy", "Quan 1, TP.HCM", true).forEach(System.out::println);
        nhanVienImpl.timKiemNhanVien( 0, "", "", "", "", "Phú Yên", true).forEach(System.out::println);
    }

    @Test
    public void testGetNhanVienByID(){
        System.out.println(nhanVienImpl.getNhanVienTheoTen("Nguyen Van A"));
    }

    @Test
    public void testDeleteNhanVien(){
        nhanVienImpl.xoaNhanVien(4);
    }
}
