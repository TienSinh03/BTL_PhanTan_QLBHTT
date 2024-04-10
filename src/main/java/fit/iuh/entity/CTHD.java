package fit.iuh.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CTHD")
public class CTHD {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "maSP")
    @Id
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "maHD")
    @Id
    private HoaDon hoaDon;

    private int soLuong;

//    public CTHD() {
//    }

    public CTHD(SanPham sanPham, HoaDon hoaDon, int soLuong) {
        this.sanPham = sanPham;
        this.hoaDon = hoaDon;
        this.soLuong = soLuong;
    }

//    public SanPham getSanPham() {
//        return sanPham;
//    }
//
//    public void setSanPham(SanPham sanPham) {
//        this.sanPham = sanPham;
//    }
//
//    public HoaDon getHoaDon() {
//        return hoaDon;
//    }
//
//    public void setHoaDon(HoaDon hoaDon) {
//        this.hoaDon = hoaDon;
//    }
//
//    public int getSoLuong() {
//        return soLuong;
//    }
//
//    public void setSoLuong(int soLuong) {
//        this.soLuong = soLuong;
//    }

}
