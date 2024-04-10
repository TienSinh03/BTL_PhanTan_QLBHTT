package fit.iuh.dao;


import fit.iuh.entity.TaiKhoan;

import java.util.List;

public interface iTaiKhoanDao {

    public List<TaiKhoan> getAllTaiKhoan();

    public List<TaiKhoan> getTrangThai();


    public boolean addTaiKhoan(TaiKhoan taiKhoan);

    public boolean deleteTrangThai(Long maNv);

    public boolean updateTrangThai(Long maNv);

    public boolean doiMtatKhau(Long maNv, String matKhau);

    public TaiKhoan kiemTraTaiKhoan(TaiKhoan taiKhoan);


    public void getMatKhau(String tenTaiKhoan);

    public TaiKhoan getTaiKhoanByMaNV(Long maNV);

    public boolean datLaiMatKhau(TaiKhoan taiKhoan, Long maNV);












}
