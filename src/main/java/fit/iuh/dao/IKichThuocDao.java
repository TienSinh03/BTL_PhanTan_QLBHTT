/**
 * @ (#) IKichThuocDao.java      4/11/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package fit.iuh.dao;

import fit.iuh.entity.KichThuoc;

import java.util.ArrayList;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 4/11/2024
 */
public interface IKichThuocDao {
    public ArrayList<KichThuoc> getAllKichThuoc();
    public KichThuoc getDLKichThuocTheoMa(long maKT);
    public KichThuoc getKichThuocTheoTen(String tenKichThuoc);
    public boolean themDLKichThuoc(KichThuoc kichThuoc);
    public boolean xoaDLKichThuoc(long maKichThuoc);
    public boolean capNhatDLKichThuoc(KichThuoc kichThuoc);
}
