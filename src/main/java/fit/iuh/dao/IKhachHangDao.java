/*
 * @ (#) IKhachHangDao.java     1.0   4/13/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package fit.iuh.dao;

import fit.iuh.entity.KhachHang;

import java.util.ArrayList;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/13/2024
 * @version:  1.0
 */
public interface IKhachHangDao {
    public ArrayList<KhachHang> getAllKhachHang();
    public void themKhachHang(KhachHang kh);
    public void capNhatKhachHang(KhachHang kh);
    public ArrayList<KhachHang> timKiemKhachHang(long maKhachHang,String tenKhachHang,String soDienThoai, String email);
    public KhachHang getKhachHangTheoMa(long maKH);
}
