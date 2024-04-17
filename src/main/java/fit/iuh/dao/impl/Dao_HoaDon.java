package fit.iuh.dao.impl;

import fit.iuh.dao.IHoaDonDao;

import fit.iuh.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dao_HoaDon implements IHoaDonDao {
    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction et;

    public Dao_HoaDon() {
        emf = Persistence.createEntityManagerFactory("JPADemo_SQL");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @Override
    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> listHoaDon = null;
        try {
            et.begin();
            listHoaDon = (ArrayList<HoaDon>) em.createQuery("select hd from HoaDon hd").getResultList();
            et.commit();
            return listHoaDon;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public HoaDon getHoaDon() {
        try {
            et.begin();
            HoaDon hoaDon =  em.createQuery("select hd from HoaDon hd order by hd.maHoaDon desc", HoaDon.class).setMaxResults(1).getSingleResult();
            et.commit();
            return hoaDon;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Boolean themHoaDon(HoaDon hd) {
        String query = "Insert into HoaDon (maKH, maNV, ngayNhap) values (?, ?, ?)";
        try {
            et.begin();
            KhachHang kh = em.find(KhachHang.class, hd.getKhachHang().getMaKH());
            NhanVien nv = em.find(NhanVien.class, hd.getNhanVien().getMaNV());
            hd.setKhachHang(kh);
            hd.setNhanVien(nv);
            em.createNativeQuery(query)
                    .setParameter(1, hd.getKhachHang().getMaKH())
                    .setParameter(2, hd.getNhanVien().getMaNV())
                    .setParameter(3, hd.getNgayNhap())
                    .executeUpdate();
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public double tongTienHoaDon(long maHD) {
        String url = "select hd.maHoaDon, SUM( cthd.soLuong*sp.giaBan) as tongTien " +
                "from HoaDon hd JOIN CTHD cthd ON hd.maHoaDon = cthd.hoaDon.maHoaDon " +
                "JOIN SanPham sp ON cthd.sanPham.maSP = sp.maSP " +
                "where hd.maHoaDon = :maHD " +
                "group by hd.maHoaDon";
        try {
            et.begin();
            List<Object[]> list = em.createQuery(url).setParameter("maHD", maHD).getResultList();
            et.commit();
            for (Object[] obj : list) {
                return Double.parseDouble(obj[1].toString());
            }
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public HoaDon getHoaDonTheoMa(long maHD) {
        HoaDon hd = null;
        try {
            et.begin();
            hd = em.find(HoaDon.class, maHD);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return hd;
    }

    @Override
    public ArrayList<HoaDon> getAllHoaDonTheoNgay(String tuNgay, String denNgay) throws ParseException {
        String sql = "select hd from HoaDon hd where hd.ngayNhap >= :tuNgay and hd.ngayNhap <= :denNgay";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date tuNgayDate = dateFormat.parse(tuNgay);
        Date denNgayDate = dateFormat.parse(denNgay);
        try {
            et.begin();
            List<HoaDon> list = em.createQuery(sql, HoaDon.class)
                    .setParameter("tuNgay", tuNgayDate)
                    .setParameter("denNgay", denNgayDate)
                    .getResultList();
            et.commit();
            return (ArrayList<HoaDon>) list;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<SanPham> thongKeTop5SPDTCN() {
        String sql = "select sp.maSP,sum(sp.giaBan*cthd.soLuong) as DoanhThu from HoaDon hd " +
                "join CTHD cthd on hd.maHoaDon=cthd.hoaDon.maHoaDon " +
                "join SanPham sp on cthd.sanPham.maSP=sp.maSP " +
                "join PhanLoai pl on pl.maPhanLoai=sp.phanLoai.maPhanLoai " +
                "join KichThuoc kc on kc.maKichThuoc=sp.kichThuoc.maKichThuoc " +
                "join MauSac ms on ms.maMauSac=sp.mauSac.maMauSac " +
                "join ChatLieu cl on cl.maChatLieu=sp.chatLieu.maChatLieu " +
                "join NhaCungCap ncc on ncc.maNCC=sp.nhaCungCap.maNCC group by sp.maSP order by sum(sp.giaBan*cthd.soLuong) desc";
//        String sql = "select  top 5 sp.maSP,sum(sp.giaBan*cthd.soLuong) as DoanhThu from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD \n" +
//                "join SanPham sp on cthd.maSP=sp.maSP \n" +
//                "group by sp.maSP \n" +
//                "order by sum(sp.giaBan*cthd.soLuong) desc";
        List<SanPham> listSanPham = new ArrayList<>();
        try {
            et.begin();
            List<Object[]> results = em.createQuery(sql, Object[].class).setMaxResults(5).getResultList();
            for(Object[] item : results){
                SanPham sp = em.find(SanPham.class, Long.parseLong(item[0].toString()));
                listSanPham.add(sp);
            }

            et.commit();
            return (ArrayList<SanPham>) listSanPham;
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<SanPham> thongKeTop5SPDTTN() {
        String query = "select cthd.sanPham.maSP,sum(sp.giaBan*cthd.soLuong) as DoanhThu from HoaDon hd join CTHD cthd on hd.maHoaDon=cthd.sanPham.maSP\n" +
                "join SanPham sp on cthd.sanPham.maSP=sp.maSP\n" +
                "group by cthd.sanPham.maSP\n" +
                "order by sum(sp.giaBan*cthd.soLuong) asc";

        List<SanPham> listSanPham = new ArrayList<>();
        try {
            et.begin();
            List<Object[]> results = em.createQuery(query, Object[].class).setMaxResults(5).getResultList();
            for(Object[] item : results){
                SanPham sp = em.find(SanPham.class, Long.parseLong(item[0].toString()));
                listSanPham.add(sp);
            }

            et.commit();
            return (ArrayList<SanPham>) listSanPham;
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public ArrayList<SanPham> thongKeDanhSachSanPhamVoiSoLuongBanDuocByTieuChi(String mauSac, String phanLoai, String kichThuoc) {
        String sql = "select cthd.sanPham.maSP from HoaDon hd " + "join CTHD cthd on hd.maHoaDon=cthd.hoaDon.maHoaDon " + "join SanPham sp on cthd.sanPham.maSP=sp.maSP " + "join PhanLoai pl on pl.maPhanLoai=sp.phanLoai.maPhanLoai " + "join KichThuoc kt on kt.maKichThuoc=sp.kichThuoc.maKichThuoc " + "join MauSac ms on ms.maMauSac=sp.mauSac.maMauSac " + "join ChatLieu cl on cl.maChatLieu=sp.chatLieu.maChatLieu " + "join NhaCungCap ncc on ncc.maNCC=sp.nhaCungCap.maNCC " + "where ms.mauSac like :mauSac and kt.kichThuoc like :kichThuoc and pl.loaiSanPham like :phanLoai group by cthd.sanPham.maSP";

        List<SanPham> listSanPham = new ArrayList<>();
        try {
            et.begin();
            List<Object[]> list = em.createQuery(sql, Object[].class)
                    .setParameter("mauSac", "%"+mauSac+"%")
                    .setParameter("kichThuoc","%"+ kichThuoc+"%")
                    .setParameter("phanLoai", "%"+ phanLoai+"%")
                    .getResultList();
            for(Object[] item : list){
                SanPham sp = em.find(SanPham.class, Long.parseLong(item[0].toString()));
                listSanPham.add(sp);
            }
            et.commit();
            return (ArrayList<SanPham>) listSanPham;
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<SanPham> thongKeDanhSachSanPhamVoiSoLuongBanDuocByTieuChiByTime(String mauSac, String phanLoai, String kichThuoc, String tuNgay, String denNgay) throws ParseException {
        String sql = "select cthd.sanPham.maSP from HoaDon hd join CTHD cthd on hd.maHoaDon=cthd.hoaDon.maHoaDon\n" +
                "join SanPham sp on cthd.sanPham.maSP=sp.maSP\n" +
                "join PhanLoai pl on pl.maPhanLoai=sp.phanLoai.maPhanLoai \n" +
                "join KichThuoc kt on kt.maKichThuoc=sp.kichThuoc.maKichThuoc\n" +
                "join MauSac ms on ms.maMauSac=sp.mauSac.maMauSac\n" +
                "join ChatLieu cl on cl.maChatLieu=sp.chatLieu.maChatLieu\n" +
                "join NhaCungCap ncc on ncc.maNCC=sp.nhaCungCap.maNCC\n" +
                "where ms.mauSac like :mauSac and kt.kichThuoc like :kichThuoc and pl.loaiSanPham like :loaiSanPham and hd.ngayNhap >= :tuNgay and  hd.ngayNhap <= :denNgay\n" +
                "group by cthd.sanPham.maSP";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date tuNgayDate = dateFormat.parse(tuNgay);
        Date denNgayDate = dateFormat.parse(denNgay);
        List<SanPham> listSanPham = new ArrayList<>();
        try {
            et.begin();
            List<Object[]> list = em.createQuery(sql, Object[].class)
                    .setParameter("mauSac", "%"+mauSac+"%")
                    .setParameter("kichThuoc","%"+ kichThuoc+"%")
                    .setParameter("loaiSanPham", "%"+ phanLoai+"%")
                    .setParameter("tuNgay", tuNgayDate)
                    .setParameter("denNgay", denNgayDate)
                    .getResultList();
            for(Object[] item : list){
//                System.out.println(item.toString());
                SanPham sp = em.find(SanPham.class, Long.parseLong(item[0].toString()));
                listSanPham.add(sp);
            }
            et.commit();
            return (ArrayList<SanPham>) listSanPham;
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<SanPham> thongKeDanhSachSanPhamTheoThangNam(String thangLap, String namLap) {
//        String sql = "select sp.maSP from HoaDon hd join CTHD cthd on hd.maHoaDon=cthd.hoaDon.maHoaDon"
//                + "						join SanPham sp on cthd.sanPham.maSP=sp.maSP"
//                + "						join PhanLoai pl on pl.maPhanLoai=sp.phanLoai.maPhanLoai "
//                + "						join KichThuoc kt on kt.maKichThuoc=sp.kichThuoc.maKichThuoc"
//                + "						join MauSac ms on ms.maMauSac=sp.mauSac.maMauSac"
//                + "						join ChatLieu cl on cl.maChatLieu=sp.chatLieu.maChatLieu"
//                + "						join NhaCungCap ncc on ncc.maNCC=sp.nhaCungCap.maNCC"
//                + "	where MONTH(hd.ngayNhap) like :thangLap and YEAR(hd.ngayNhap) like :namLap"
//                + "			group by sp.maSP";
        String sql = "select sp.maSP from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD\n"
                + "						join SanPham sp on cthd.maSP=sp.maSP\n"
                + "						join PhanLoai pl on pl.maPhanLoai=sp.maPhanLoai \n"
                + "						join KichThuoc kt on kt.maKichThuoc=sp.maKichThuoc\n"
                + "						join MauSac ms on ms.maMauSac=sp.maMauSac\n"
                + "						join ChatLieu cl on cl.maChatLieu=sp.maChatLieu\n"
                + "						join NhaCungCap ncc on ncc.maNCC=sp.maNhaCungCap\n"
                + "	where MONTH(hd.ngayNhap) like :thangLap and YEAR(hd.ngayNhap) like :namLap\n"
                + "			group by sp.maSP";
        List<SanPham> listSanPham = new ArrayList<>();
        try {
            et.begin();
            List<Object[]> results = em.createNativeQuery(sql)
//                    .setParameter("thangLap", Integer.parseInt(thangLap))
//                    .setParameter("namLap", Integer.parseInt(namLap))
                    .setParameter("thangLap", "%" + thangLap + "%")
                    .setParameter("namLap", "%" + namLap + "%")
                    .getResultList();
            for (Object[] obj : results) {
                SanPham sp = em.find(SanPham.class, Long.parseLong(obj[0].toString()));
                listSanPham.add(sp);
            }
            et.commit();
            return (ArrayList<SanPham>) listSanPham;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<KhachHang> thongKeThongTinKhachHangDaMuaHang() {
        String sql = "SELECT DISTINCT hd.khachHang.maKH,kh.hoTen,kh.sdt FROM HoaDon hd" +
                "                  JOIN KhachHang kh on hd.khachHang.maKH=kh.maKH";
        try {
            et.begin();
            List<Object[]> results = em.createQuery(sql, Object[].class).getResultList();
            et.commit();
            ArrayList<KhachHang> listKhachHang = new ArrayList<>();
            for (Object[] obj : results) {
                KhachHang kh = em.find(KhachHang.class, Long.parseLong(obj[0].toString()));
                listKhachHang.add(kh);
            }
            return listKhachHang;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public double getThanhTienKhachHangMua(long maKH) {
        String url = "select SUM(cthd.soLuong*sp.giaBan) as thanhTien from HoaDon hd join CTHD cthd on hd.maHoaDon=cthd.hoaDon.maHoaDon join SanPham sp on sp.maSP=cthd.sanPham.maSP join KhachHang kh on kh.maKH=hd.khachHang.maKH where hd.khachHang.maKH = :maKH group by hd.khachHang.maKH";
        try {
            et.begin();
            List<Object> results = em.createQuery(url).setParameter("maKH", maKH).getResultList();
            et.commit();
            for (Object obj : results) {
                return (double) obj;
            }
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getSoLuongKhachHangMua(long maKH) {
        String url = "select SUM(cthd.soLuong) as soLuong from HoaDon hd join CTHD cthd on hd.maHoaDon=cthd.hoaDon.maHoaDon join SanPham sp on sp.maSP=cthd.sanPham.maSP join KhachHang kh on kh.maKH=hd.khachHang.maKH where hd.khachHang.maKH = :maKH group by hd.khachHang.maKH";
        try {
            et.begin();
            List<Long> results = em.createQuery(url, Long.class).setParameter("maKH", maKH).getResultList();
            et.commit();
            for (Long count : results) {
                return count.intValue(); // Chuyển đổi Long thành int
            }
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getSoLuongKhachHang() {
        String url = "select COUNT(*) as tongKH from HoaDon hd join CTHD cthd on hd.maHoaDon=cthd.hoaDon.maHoaDon ";
        try {
            et.begin();
            List<Long> results = em.createQuery(url, Long.class).getResultList();
            et.commit();
            for (Long count : results) {
                return count.intValue(); // Chuyển đổi Long thành int
            }
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getSoLuongHoaDonKhachHangMua(long maKH) {
        String url = "select COUNT(hd.maHoaDon) as tongHD from HoaDon hd join CTHD cthd on hd.maHoaDon=cthd.hoaDon.maHoaDon join SanPham sp on sp.maSP=cthd.sanPham.maSP join KhachHang kh on kh.maKH=hd.khachHang.maKH where hd.khachHang.maKH = :maKH group by hd.khachHang.maKH";
        try {
            et.begin();
            List<Long> results = em.createQuery(url, Long.class).setParameter("maKH", maKH).getResultList();
            et.commit();
            for (Long count : results) {
                return count.intValue(); // Chuyển đổi Long thành int
            }
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangDTCaoNhat() {
        String query = "select hd.khachHang.maKH,kh.hoTen,kh.sdt,SUM(cthd.soLuong) as SoLuongKHDaMua,SUM(cthd.soLuong*sp.giaBan) as thanhTien from HoaDon hd \n" +
                "join CTHD cthd on hd.maHoaDon=cthd.hoaDon.maHoaDon\n" +
                "join KhachHang kh on kh.maKH=hd.khachHang.maKH\n" +
                "join SanPham sp on sp.maSP=cthd.sanPham.maSP\n" +
                "group by hd.khachHang.maKH,kh.hoTen,kh.sdt\n" +
                "order by SUM(cthd.soLuong*sp.giaBan) desc";

        List<KhachHang> listKhachHang = new ArrayList<>();
        try {
            et.begin();
            List<Object[]> results = em.createQuery(query, Object[].class).setMaxResults(5).getResultList();
            for(Object[] item : results){
                KhachHang kh = em.find(KhachHang.class, Long.parseLong(item[0].toString()));
                listKhachHang.add(kh);
            }

            et.commit();
            return (ArrayList<KhachHang>) listKhachHang;
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangThuongXuyenMuaHang() {
        String query = "select hd.khachHang.maKH,kh.hoTen,kh.sdt,SUM(cthd.soLuong) as SoLuongKHDaMua from HoaDon hd \n" +
                "join CTHD cthd on hd.maHoaDon=cthd.hoaDon.maHoaDon\n" +
                "join KhachHang kh on kh.maKH=hd.khachHang.maKH\n" +
                "group by hd.khachHang.maKH,kh.hoTen,kh.sdt\n" +
                "order by count(*) desc";
        List<KhachHang> listKhachHang = new ArrayList<>();
        try {
            et.begin();
            List<Object[]> results = em.createQuery(query, Object[].class).setMaxResults(5).getResultList();
            for(Object[] item : results){
                KhachHang kh = em.find(KhachHang.class, Long.parseLong(item[0].toString()));
                listKhachHang.add(kh);
            }

            et.commit();
            return (ArrayList<KhachHang>) listKhachHang;
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangSLNhieuNhat() {
        String query = "select hd.khachHang.maKH,kh.hoTen,kh.sdt,SUM(cthd.soLuong) as SoLuongKHDaMua,SUM(cthd.soLuong*sp.giaBan) as thanhTien from HoaDon hd join CTHD cthd on hd.maHoaDon=cthd.hoaDon.maHoaDon \n" +
                "join KhachHang kh on kh.maKH=hd.khachHang.maKH\n" +
                "join SanPham sp on sp.maSP=cthd.sanPham.maSP\n" +
                "group by hd.khachHang.maKH,kh.hoTen,kh.sdt\n" +
                "order by SUM(cthd.soLuong) desc";
        List<KhachHang> listKhachHang = new ArrayList<>();
        try {
            et.begin();
            List<Object[]> results = em.createQuery(query, Object[].class).setMaxResults(5).getResultList();
            for(Object[] item : results){
                System.out.println(item[3].toString());
                KhachHang kh = em.find(KhachHang.class, Long.parseLong(item[0].toString()));
                listKhachHang.add(kh);
            }

            et.commit();
            return (ArrayList<KhachHang>) listKhachHang;
        } catch (Exception e) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

//    public void close() {
//        em.close();
//        emf.close();
//    }
}

//     * ==============================Thống kê doanh thu=====================
//     */
//    /**
//     * Thống kê Top 5 san pham doanh thu cao nhat
//     *
//     * @return
//     */
//    public ArrayList<SanPham> thongKeTop5SPDTCN() {
//        ArrayList<SanPham> listSanPham = new ArrayList<>();
//        Connect.getInstance();
//        Connection conn = Connect.getConnection();
//        try {
//            String sql = "select  top 5 sp.maSP,sum(sp.giaBan*cthd.soLuong) as DoanhThu from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD\n" +
//"						join SanPham sp on cthd.maSP=sp.maSP\n" +
//"						join PhanLoai pl on pl.maPhanLoai=sp.maPhanLoai \n" +
//"						join KichThuoc kc on kc.maKichThuoc=sp.maKichThuoc\n" +
//"						join MauSac ms on ms.maMauSac=sp.maMauSac\n" +
//"						join ChatLieu cl on cl.maChatLieu=sp.maChatLieu\n" +
//"						join NhaCungCap ncc on ncc.maNCC=sp.maNhaCungCap\n" +
//"			group by sp.maSP\n" +
//"			order by sum(sp.giaBan*cthd.soLuong) desc";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                SanPham sp = dao_SanPham.getSanPhamTheoMa(rs.getString(1));
//                listSanPham.add(sp);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return listSanPham;
//    }
//     /**
//     * Thống kê Top 5 san pham doanh thu cao nhat
//     *
//     * @return
//     */
//    public ArrayList<SanPham> thongKeTop5SPDTTN() {
//        ArrayList<SanPham> listSanPham = new ArrayList<>();
//        Connect.getInstance();
//        Connection conn = Connect.getConnection();
//        try {
//            String sql = "select  top 5 sp.maSP,sum(sp.giaBan*cthd.soLuong) as DoanhThu from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD\n" +
//"						join SanPham sp on cthd.maSP=sp.maSP\n" +
//"						join PhanLoai pl on pl.maPhanLoai=sp.maPhanLoai \n" +
//"						join KichThuoc kc on kc.maKichThuoc=sp.maKichThuoc\n" +
//"						join MauSac ms on ms.maMauSac=sp.maMauSac\n" +
//"						join ChatLieu cl on cl.maChatLieu=sp.maChatLieu\n" +
//"						join NhaCungCap ncc on ncc.maNCC=sp.maNhaCungCap\n" +
//"			group by sp.maSP\n" +
//"			order by sum(sp.giaBan*cthd.soLuong) asc";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                SanPham sp = dao_SanPham.getSanPhamTheoMa(rs.getString(1));
//                listSanPham.add(sp);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return listSanPham;
//    }


//
//    /**
//     * lấy số lượng khách hàng mua tại cửa hàng
//     *
//     * @param maKH
//     * @return
//     */
//    public int getSoLuongKhachHangMua(String maKH) {
//
//        Connection conn = Connect.getInstance().getConnection();
//        PreparedStatement prestmt = null;
//        String sql = "select SUM(cthd.soLuong) as SoLuongKHDaMua from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD \n"
//                + "					join KhachHang kh on kh.maKH=hd.maKH\n"
//                + "					join SanPham sp on sp.maSP=cthd.maSP\n"
//                + "		where hd.maKH = ?"
//                + "		group by hd.maKH,kh.hoTen,kh.sdt";
//        try {
//            prestmt = conn.prepareStatement(sql);
//            prestmt.setString(1, maKH);
//            ResultSet rs = prestmt.executeQuery();
//            while (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return 0;
//    }
//
//    /**
//     * lấy số lượng khách hàng
//     *
//     * @return
//     */
//    public int getSoLuongKhachHang() {
//        Connection conn = Connect.getInstance().getConnection();
//
//        String sql = "select COUNT(*) as tongKH from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD ";
//        try {
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return 0;
//    }
//
//    /**
//     * Thống kê top 5 khách hàng doanh thu cao nhat
//     *
//     * @return
//     */
//    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangDTCaoNhat() {
//        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
//        Connect.getInstance();
//        Connection conn = Connect.getConnection();
//        try {
//            String sql = "select top 5 hd.maKH,kh.hoTen,kh.sdt,SUM(cthd.soLuong) as SoLuongKHDaMua,SUM(cthd.soLuong*sp.giaBan) as thanhTien from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD \n"
//                    + "																	join KhachHang kh on kh.maKH=hd.maKH\n"
//                    + "																	join SanPham sp on sp.maSP=cthd.maSP\n"
//                    + "							group by hd.maKH,kh.hoTen,kh.sdt\n"
//                    + "							order by SUM(cthd.soLuong*sp.giaBan) desc";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                KhachHang kh = dao_KhachHang.getKhachHangTheoMa(rs.getString(1));
//                listKhachHang.add(kh);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return listKhachHang;
//    }
//      /**
//     * Thống kê top 5 khách hàng thuong xuyen mua hang nhat
//     *
//     * @return
//     */
//    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangThuongXuyenMuaHang() {
//        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
//        Connect.getInstance();
//        Connection conn = Connect.getConnection();
//        try {
//            String sql = "select top 5 hd.maKH,kh.hoTen,kh.sdt,SUM(cthd.soLuong) as SoLuongKHDaMua,SUM(cthd.soLuong*sp.giaBan) as thanhTien from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD \n"
//                    + "																	join KhachHang kh on kh.maKH=hd.maKH\n"
//                    + "																	join SanPham sp on sp.maSP=cthd.maSP\n"
//                    + "							group by hd.maKH,kh.hoTen,kh.sdt\n"
//                    + "							order by count(*) desc";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                KhachHang kh = dao_KhachHang.getKhachHangTheoMa(rs.getString(1));
//                listKhachHang.add(kh);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return listKhachHang;
//    }
//      /**
//     * Thống kê top 5 khách hàng co so luong mua nhieu nhat
//     *
//     * @return
//     */
//    public ArrayList<KhachHang> thongKeThongTinTop5KhachHangSLNhieuNhat() {
//        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
//        Connect.getInstance();
//        Connection conn = Connect.getConnection();
//        try {
//            String sql = "select top 5 hd.maKH,kh.hoTen,kh.sdt,SUM(cthd.soLuong) as SoLuongKHDaMua,SUM(cthd.soLuong*sp.giaBan) as thanhTien from HoaDon hd join CTHD cthd on hd.maHD=cthd.maHD \n"
//                    + "																	join KhachHang kh on kh.maKH=hd.maKH\n"
//                    + "																	join SanPham sp on sp.maSP=cthd.maSP\n"
//                    + "							group by hd.maKH,kh.hoTen,kh.sdt\n"
//                    + "							order by SUM(cthd.soLuong) desc";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                KhachHang kh = dao_KhachHang.getKhachHangTheoMa(rs.getString(1));
//                listKhachHang.add(kh);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return listKhachHang;
//    }
//
//
//    public int getSoLuongHoaDonKhachHangMua(String maKH) {
//        Connection conn = Connect.getInstance().getConnection();
//        PreparedStatement prestmt = null;
//        String sql = "select maKH , COUNT(*) as tongHD from HoaDon\n"
//                + "where maKH = ?\n"
//                + "group by maKH";
//        try {
//            prestmt = conn.prepareStatement(sql);
//            prestmt.setString(1, maKH);
//            ResultSet rs = prestmt.executeQuery();
//            while (rs.next()) {
//                return rs.getInt(2);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return 0;
//    }
//}
