/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fit.iuh.dao.impl;

import fit.iuh.dao.IKhachHangDao;
import fit.iuh.entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.ArrayList;



/**
 *
 * @author ACER
 */
public class Dao_KhachHang implements IKhachHangDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPADemo_SQL");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    public ArrayList<KhachHang> getAllKhachHang(){
        return (ArrayList<KhachHang>) em.createQuery("SELECT kh FROM KhachHang kh").getResultList();
    }
   public void themKhachHang(KhachHang kh){
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.merge(kh);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
   }
   public void capNhatKhachHang(KhachHang kh){
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            KhachHang khInDBS = em.find(KhachHang.class, kh.getMaKH());
            if(khInDBS == null){
                return;
            }
            khInDBS = em.merge(kh);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
   }
   
     public ArrayList<KhachHang> timKiemKhachHang(int maKhachHang,String tenKhachHang,String soDienThoai, String email){
        EntityTransaction et = em.getTransaction();
        ArrayList<KhachHang> listKhachHang =new ArrayList<>();
        String sql = "select * from KhachHang where maKH like ? and hoten like ? and sdt like ? and email like ?";
        try {
            et.begin();
            listKhachHang = (ArrayList<KhachHang>) em.createNativeQuery(sql, KhachHang.class)
                    .setParameter(1, "%"+maKhachHang+"%")
                    .setParameter(2, "%"+tenKhachHang+"%")
                    .setParameter(3, "%"+soDienThoai+"%")
                    .setParameter(4, "%"+email+"%")
                    .getResultList();
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return listKhachHang;
   }
     
     /**
      * Lấy thông tin khách hàng theo mã
      * @param maKH
      * @return 
      */
    public KhachHang getKhachHangTheoMa(int maKH) {
       return em.find(KhachHang.class, maKH);
    }
    
    /**
     * Tạo tự động mã
     * @return 
     */
//    public String taoMaKhachHang() {
//        Connection con = Connect.getInstance().getConnection();
//        String url = "select top 1 maKH from KhachHang order by maKH desc";
//
//        try {
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(url);
//            if(rs.next()) {
//                String maKH = rs.getString(1);
//                int so = Integer.parseInt(maKH.substring(4));
//                so++;
//                String maKHMoi = so + "";
//                while(maKHMoi.length() < 4) {
//                    maKHMoi = "0" +maKHMoi;
//
//                }
//                return "KH" + maKHMoi;
//            } else {
//                return "KH0001";
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
