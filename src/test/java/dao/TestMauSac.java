package dao;

import fit.iuh.dao.impl.Dao_MauSac;
import fit.iuh.entity.MauSac;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestMauSac {
    private Dao_MauSac dao_mauSac;

    @BeforeAll
    public void init() {
        dao_mauSac = new Dao_MauSac();
    }

    /*
        * Test method for {@link fit.iuh.dao.impl.Dao_MauSac#getAllMauSac()}.
     */
    @Test
    public void testGetAllMauSac() {
        ArrayList<MauSac> list = dao_mauSac.getAllMauSac();
        for (MauSac mauSac : list) {
            System.out.println(mauSac);
        }
    }
    /*
        * Test method for {@link fit.iuh.dao.impl.Dao_MauSac#getDLMauSacTheoMa(java.lang.String)}.
     */
    @Test
    public void testGetDLMauSacTheoMa() {
        MauSac mauSac = dao_mauSac.getDLMauSacTheoMa(1);
        System.out.println(mauSac);
    }
    /*
        * Test method for {@link fit.iuh.dao.impl.Dao_MauSac#getMauSacTheoTen(java.lang.String)}.
     */
    @Test
    public void testGetMauSacTheoTen() {
        MauSac mauSac = dao_mauSac.getMauSacTheoTen("Hồng");
        System.out.println(mauSac);
    }
    /*
        * Test method for {@link fit.iuh.dao.impl.Dao_MauSac#themDLMauSac(fit.iuh.entity.MauSac)}.
     */
    @Test
    public void testThemDLMauSac() {
        MauSac mauSac = new MauSac();
        mauSac.setMauSac("Xanh");
        Boolean kq = dao_mauSac.themDLMauSac(mauSac);
        System.out.println(kq);
    }
    /*
        * Test method for {@link fit.iuh.dao.impl.Dao_MauSac#capNhatDLMauSac(fit.iuh.entity.MauSac)}.
     */
    @Test
    public void testCapNhatDLMauSac() {
        MauSac mauSac = new MauSac();
        mauSac.setMaMauSac(3);
        mauSac.setMauSac("Xanh lá");
        Boolean kq = dao_mauSac.capNhatDLMauSac(mauSac);
        System.out.println(kq);
    }
    /*
        * Test method for {@link fit.iuh.dao.impl.Dao_MauSac#xoaDLMauSac(java.lang.String)}.
     */
    @Test
    public void testXoaDLMauSac() {
        Boolean kq = dao_mauSac.xoaDLMauSac(3);
        System.out.println(kq);
    }
    @AfterAll
    public void close() {
        dao_mauSac.close();
    }
}
