/**
 * @ (#) ICTPhieuDatHangDao.java      4/11/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package fit.iuh.dao;

import fit.iuh.entity.CTPhieuDatHang;

import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 4/11/2024
 */
public interface ICTPhieuDatHangDao {
    public ArrayList<CTPhieuDatHang> getAllCTPhieuDatHang(long maPhieuDatHang);
    public boolean themCTPDT(CTPhieuDatHang ctpdt);
    public boolean xoaCTPhieuDatHang(long maPhieuDatHang);
}
