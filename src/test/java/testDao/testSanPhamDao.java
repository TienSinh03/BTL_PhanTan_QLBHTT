package testDao;

import fit.iuh.dao.impl.Dao_NhaCungCap;
import fit.iuh.dao.impl.Dao_SanPham;
import fit.iuh.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class testSanPhamDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPADemo_SQL");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    private Dao_SanPham daoSanPham;

    @BeforeAll
    public void setUp() {
        daoSanPham = new Dao_SanPham(em);
    }

    @Test
    public void testGetAllSanPham() {

        System.out.println(daoSanPham.getAllSanPham());
    }

    @Test
    public void testGetAllQuanAo() {

        System.out.println(daoSanPham.getAllQuanAo());
    }

    @Test
    public void testGetAllPhuKien() {

        System.out.println(daoSanPham.getAllPhuKien());
    }

    @Test
    public void testAddSanPham() {
//       insert into dbo.sanPham (maSP,tenSP,soLuong,giaBan,giaNhap, ngayNhap, hinhAnh, maChatLieu, maKichThuoc, maMauSac, maPhanLoai, maNhaCungCap) values (2,N'Nón xoè teelab', 30, 150000,120000,'2023-10-16','SP0002.jpg',2,5,4,3,1);
        SanPham sanPham = new SanPham();
        sanPham.setTenSP("Nón");
        sanPham.setSoLuong(0);
        sanPham.setGiaBan(150000);
        sanPham.setGiaNhap(120000);
        sanPham.setNgayNhap(java.sql.Date.valueOf("2023-10-16"));
        sanPham.setHinhAnh("SP0002.jpg");

        ChatLieu chatLieu = em.find(ChatLieu.class, 2);

        KichThuoc kichThuoc = em.find(KichThuoc.class, 5);

        MauSac mauSac = em.find(MauSac.class, 4);

        PhanLoai phanLoai = em.find(PhanLoai.class, 3);

        NhaCungCap nhaCungCap = em.find(NhaCungCap.class, 1);

        sanPham.setChatLieu(chatLieu);
        sanPham.setKichThuoc(kichThuoc);
        sanPham.setMauSac(mauSac);
        sanPham.setPhanLoai(phanLoai);
        sanPham.setNhaCungCap(nhaCungCap);


        boolean checked = daoSanPham.themSanPham(sanPham);
        System.out.println(checked);
    }

    @Test
    public void testDeleteSanPham() {
        boolean checked = daoSanPham.xoaSanPham(2);
        System.out.println(checked);
    }

    @Test
//    updateSanPham
    public void testGiamSL(){
        SanPham sanPham = new SanPham();
        sanPham.setMaSP(1L);
        sanPham.setSoLuong(10);

        daoSanPham.giamSoLuongSanPham(sanPham);
    }
    @Test
    public void testTangSL(){
//        SanPham sanPham = new SanPham();
//        sanPham.setMaSP(1L);
//        sanPham.setSoLuong(10);

        daoSanPham.tangSoLuongSanPham(1, 10);
    }
    @Test
    public void testFindQuanAo(){
        System.out.println(daoSanPham.timKiemQuanAo(0,"","","A","Trắng","Vải","M"));
    }

    @Test
    public void testFindPhuKien(){
        System.out.println(daoSanPham.timKiemPhuKien(11,"","","","Đen","","L"));
    }

    @Test
    public void testGetSanPhamTheoMa(){
        System.out.println(daoSanPham.getSanPhamTheoMa(1L));
    }

    @Test
    public void testGetAllSanPhamTheoTieuChi(){
        System.out.println(daoSanPham.getAllSanPhamTheoTieuChi("Áo","Đen","XL"));
    }

    @Test
    public void testGetAllSanPhamHetHang(){
        System.out.println(daoSanPham.getAllSanPhamHetHang("","",""));
    }

    @Test
    public void testGetSanPhamBanChay(){
        ArrayList<SanPham> sanPhams = daoSanPham.getSanPhamBanChay();
        System.out.println(sanPhams);
    }

    @Test
    public void testGetSanPhamBanCham(){
        ArrayList<SanPham> sanPhams = daoSanPham.getSanPhamBanCham();
        System.out.println(sanPhams);
    }

    @Test
    public void testGetSoLuongSPTheoMaPL(){
        ArrayList<SanPham> sanPhams = daoSanPham.getSoLuongSPTheoMaPL();
        sanPhams.forEach(sanPham -> {
            System.out.println(sanPham.getPhanLoai().getMaPhanLoai() + " - " + sanPham.getPhanLoai().getLoaiSanPham() + " - " + sanPham.getSoLuong());
        });
    }
    @Test
    public void testGetAllSanPhamTheoNgay(){
        System.out.println(daoSanPham.getAllSanPhamTheoNgay("2023-10-16","2023-10-26"));
    }
    @AfterAll
    public void tearDown() {
        em.close();
        emf.close();
    }

}
