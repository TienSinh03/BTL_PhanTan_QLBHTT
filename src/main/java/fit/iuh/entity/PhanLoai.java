package fit.iuh.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PhanLoai")
public class PhanLoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maPhanLoai;

    @Column(name = "tenPhanLoai",columnDefinition = "nvarchar(100)", nullable = false)
    private String loaiSanPham;

//    private String auto_ID(){
//        Dao_PhanLoai daoPhanLoai = new Dao_PhanLoai();
//        String idPrefix = daoPhanLoai.taoMaPhanLoai();
//        return idPrefix;
//    }
//
//    public PhanLoai() {
//    }
//
//    public PhanLoai(String loaiSanPham) {
//        this.maPhanLoai = auto_ID();
//        this.loaiSanPham = loaiSanPham;
//    }
//
//    public PhanLoai(String maPhanLoai, String loaiSanPham) {
//        this.maPhanLoai = maPhanLoai;
//        this.loaiSanPham = loaiSanPham;
//    }
//
//    public String getMaPhanLoai() {
//        return maPhanLoai;
//    }
//
//    public void setMaPhanLoai(String maPhanLoai) {
//        this.maPhanLoai = maPhanLoai;
//    }
//
//    public String getLoaiSanPham() {
//        return loaiSanPham;
//    }
//
//    public void setLoaiSanPham(String loaiSanPham) {
//        this.loaiSanPham = loaiSanPham;
//    }
}