/*
 * @ (#) INhanVienDao.java     1.0   4/13/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package fit.iuh.dao;

import fit.iuh.entity.NhanVien;

import java.util.ArrayList;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/13/2024
 * @version:  1.0
 */
public interface INhanVienDao {
    public ArrayList<NhanVien> getAllNhanVien();
    public void themNhanVien(NhanVien nv);
    public void xoaNhanVien(long manv);
    public void capNhatNhanVien(NhanVien nv);
    public ArrayList<NhanVien> timKiemNhanVien(long maNV, String tenNV, String sdt, String email, String chucVu, String diaChi, boolean trangThai);
    public NhanVien getNhanVienTheoTen(String tenNV);
}
