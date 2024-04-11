package fit.iuh.dao;

import fit.iuh.entity.NhaCungCap;

import java.util.List;

public interface iNhaCungCap {
    public List<NhaCungCap> getAllNhaCungCap();

    public boolean addNhaCungCap(NhaCungCap nhaCungCap);
    public boolean deleteNhaCungCap(Long maNCC);
    public boolean updateNhaCungCap(Long maNCC, NhaCungCap nhaCungCap);

    //    String maNCC, String tenNCC, String sdt, String email

    public List<NhaCungCap> findNhaCungCap(Long maNCC, String tenNCC, String sdt, String email );

    public List<NhaCungCap>  getNhaCungCapTheoTen(String tenNCC);

    public List<NhaCungCap>  getNhaCungCapTheoMa(Long maNCC);

//    taoMaNhaCungCap không viết


}
