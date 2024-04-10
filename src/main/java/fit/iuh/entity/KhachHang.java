package fit.iuh.entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KhachHang")
public class KhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long maKH;
	@Column(length = 50, nullable = false)
	private String hoTen;
	@Column(length = 12, nullable = false, unique = true)
	private String sdt;
	@Column(length = 30, nullable = false, unique = true)
	private String email;
	@Column(length = 10, nullable = false)
	private String gioiTinh;
	
//	public KhachHang() {
//		// TODO Auto-generated constructor stub
//	}
//	private String auto_ID(){
//        Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
//        String idPrefix = "KH";
//        int length = dao_KhachHang.getAllKhachHang().size();
//        String finalId = idPrefix + String.format("%04d", length + 1);
//        return finalId;
//    }
//        public KhachHang(String hoVaTen, String sdt, String email, String gioiTinh) {
//        this.maKH = auto_ID();
//        this.hoTen = hoVaTen;
//        this.email = email;
//        this.sdt = sdt;
//        this.gioiTinh = gioiTinh;
//    }
//
//	public KhachHang(String maKH, String hoTen, String sdt, String email, String gioiTinh) {
//
//		this.maKH = maKH;
//		this.hoTen = hoTen;
//		this.email = email;
//		this.sdt = sdt;
//		this.gioiTinh = gioiTinh;
//	}
//
//	public String getMaKH() {
//		return maKH;
//	}
//
//	public void setMaKH(String maKH) {
//		this.maKH = maKH;
//	}
//
//	public String getHoTen() {
//		return hoTen;
//	}
//
//	public void setHoTen(String hoTen) {
//		this.hoTen = hoTen;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getSdt() {
//		return sdt;
//	}
//
//	public void setSdt(String sdt) {
//		this.sdt = sdt;
//	}
//
//	public String getGioiTinh() {
//		return gioiTinh;
//	}
//
//	public void setGioiTinh(String gioiTinh) {
//		this.gioiTinh = gioiTinh;
//	}
	
	
	
}
