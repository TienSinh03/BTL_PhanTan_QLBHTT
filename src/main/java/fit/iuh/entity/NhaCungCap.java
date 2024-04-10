package fit.iuh.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maNCC;

    @Column(nullable = false)
    private String tenNCC;

    private String diaChi;

    @Column(name = "sdt", length = 12, nullable = false)
    private String sdt;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

//    private String auto_ID(){
//        Dao_NhaCungCap daoNhaCungCap = new Dao_NhaCungCap();
//        String idPrefix = daoNhaCungCap.taoMaNhaCungCap();
//
//        return idPrefix;
//    }
//
//    public NhaCungCap(String tenNhaCungCap, String diaChi, String sdt, String email) {
//        this.maNCC = auto_ID();
//        this.tenNCC = tenNhaCungCap;
//        this.diaChi = diaChi;
//        this.sdt = sdt;
//        this.email = email;
//    }
//
//    public NhaCungCap() {
//    }
//    public NhaCungCap(String maNC) {
//              this.maNCC = maNCC;
//
//    }
//    public NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdt, String email) {
//        this.maNCC = maNCC;
//        this.tenNCC = tenNCC;
//        this.diaChi = diaChi;
//        this.sdt = sdt;
//        this.email = email;
//    }
//
//    public String getMaNCC() {
//        return maNCC;
//    }
//
//    public void setMaNCC(String maNCC) {
//        this.maNCC = maNCC;
//    }
//
//    public String getTenNCC() {
//        return tenNCC;
//    }
//
//    public void setTenNCC(String tenNCC) {
//        this.tenNCC = tenNCC;
//    }
//
//    public String getDiaChi() {
//        return diaChi;
//    }
//
//    public void setDiaChi(String diaChi) {
//        this.diaChi = diaChi;
//    }
//
//    public String getSdt() {
//        return sdt;
//    }
//
//    public void setSdt(String sdt) {
//        this.sdt = sdt;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
