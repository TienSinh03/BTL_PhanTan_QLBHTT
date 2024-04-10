package fit.iuh.entity;

import java.util.Date;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "PhieuDatHang")
public class PhieuDatHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maPhieuDat;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "maKH")
    private KhachHang khachHang;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "maNV")
    private NhanVien nhanVien;

    @Column(columnDefinition = "date", nullable = false)
    private Date ngayLap;

    //	public PhieuDatHang() {
//		// TODO Auto-generated constructor stub
//	}
//
//        public String auto_ID() {
//            Dao_PhieuDatHang daoPhieuDatHang = new Dao_PhieuDatHang();
//            String idPrefix = daoPhieuDatHang.taoMaPhieuDatHang();
//            return idPrefix;
//        }
//
    public PhieuDatHang(KhachHang khachHang, NhanVien nhanVien, Date ngayLap) {
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.ngayLap = ngayLap;
    }

//    public String getMaPhieuDat() {
//        return maPhieuDat;
//    }
//
//    public void setMaPhieuDat(String maPhieuDat) {
//        this.maPhieuDat = maPhieuDat;
//    }
//
//    public KhachHang getKhachHang() {
//        return khachHang;
//    }
//
//    public void setKhachHang(KhachHang khachHang) {
//        this.khachHang = khachHang;
//    }
//
//    public NhanVien getNhanVien() {
//        return nhanVien;
//    }
//
//    public void setNhanVien(NhanVien nhanVien) {
//        this.nhanVien = nhanVien;
//    }
//
//    public Date getNgayLap() {
//        return ngayLap;
//    }
//
//    public void setNgayLap(Date ngayLap) {
//        this.ngayLap = ngayLap;
//    }


}
