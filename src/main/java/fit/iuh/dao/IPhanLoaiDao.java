/*
 * @ (#) IPhanLoaiDao.java     1.0   4/13/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package fit.iuh.dao;

import fit.iuh.entity.PhanLoai;

import java.util.ArrayList;

/*
 * @description:
 * @author: Le Tan Phat
 * @code: 21004661
 * @date: 4/13/2024
 * @version:  1.0
 */
public interface IPhanLoaiDao {
    public ArrayList<PhanLoai> getAllPhanLoai();
    public ArrayList<PhanLoai> getAllPhanLoaiCuaPhuKien();
    public PhanLoai getDLPhanLoaiSPTheoMa(String maPL);
    public PhanLoai getPhanLoaiTheoTen(String tenPhanLoai);
    public void themLoaiSanPham(PhanLoai phanLoai);
    public void xoaPhanLoaiSanPham(int maPhanLoai);
    public void catNhatLoaiSanPham(PhanLoai phanLoai);

}
