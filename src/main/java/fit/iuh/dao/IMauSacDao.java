package fit.iuh.dao;

import fit.iuh.entity.MauSac;

import java.util.ArrayList;

public interface IMauSacDao {
    public ArrayList<MauSac> getAllMauSac() ;
    public MauSac getDLMauSacTheoMa(long maMS) ;
    public MauSac getMauSacTheoTen(String tenMauSac);
    public boolean themDLMauSac(MauSac mauSac);
    public Boolean capNhatDLMauSac(MauSac mauSac) ;
    public Boolean xoaDLMauSac(long maMauSac) ;


}
