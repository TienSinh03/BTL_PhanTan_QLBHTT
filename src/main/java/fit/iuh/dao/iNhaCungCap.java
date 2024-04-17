package fit.iuh.dao;

import fit.iuh.entity.NhaCungCap;

import java.util.ArrayList;
import java.util.List;

public interface iNhaCungCap {
    public ArrayList<NhaCungCap> getAllNhaCungCap();

    public boolean themNhaCungCap(NhaCungCap nhaCungCap);
    public boolean xoaNhaCungCap(Long maNCC);
    public boolean capNhatNhaCungCap(NhaCungCap ncc);

    //    String maNCC, String tenNCC, String sdt, String email

    public List<NhaCungCap> timKiemNhaCungCap(Long maNCC, String tenNCC, String sdt, String email );

    public NhaCungCap  getNhaCungCapTheoTen(String tenNCC);

    public NhaCungCap  getNhaCungCapTheoMa(Long maNCC);

//    taoMaNhaCungCap không viết


}
