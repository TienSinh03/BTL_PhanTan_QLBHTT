package fit.iuh.dao;


import fit.iuh.entity.TaiKhoan;

import java.util.ArrayList;
import java.util.List;

public interface iTaiKhoanDao {

    public ArrayList<TaiKhoan> getAllTaiKhoan();

    public ArrayList<TaiKhoan> getAllTaiKhoanConHoatDong();


    public boolean themTaiKhoan(TaiKhoan taiKhoan);

    public boolean xoaTaiKhoan(Long maNv);

    public boolean capNhatTaiKhoan(Long maNv);

    public void doiMatKhauTaiKhoan(TaiKhoan taiKhoan);

    public TaiKhoan dangNhapTaiKhoan(String tenTaiKhoan, String matKhau);


    public String getMatKhau(String tenTK);

    public TaiKhoan getTaiKhoanNV(Long maNV);

    public boolean datLaiMatKhau(TaiKhoan taiKhoan, String matKhau);














}
