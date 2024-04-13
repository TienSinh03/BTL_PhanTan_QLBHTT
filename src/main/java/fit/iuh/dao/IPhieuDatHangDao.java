/**
 * @ (#) IPhieuDatHangDao.java      4/10/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package fit.iuh.dao;

import fit.iuh.entity.PhieuDatHang;

import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 4/10/2024
 */
public interface IPhieuDatHangDao {
    public List<PhieuDatHang> getAllPhieuDatHang();
    public boolean themPhieuDatHang(PhieuDatHang pdt);
    public boolean xoaPhieuDatHang(long maPhieuDatHang);
    public PhieuDatHang getPDTTheoMa(long maPDT);
    public PhieuDatHang getPDTTheoMaKH(long maKhachHang);

}
