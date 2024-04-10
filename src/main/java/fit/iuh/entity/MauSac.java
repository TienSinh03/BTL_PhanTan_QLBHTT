package fit.iuh.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MauSac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maMauSac;

    @Column(name = "tenMauSac", length = 50, nullable = false)
    private String mauSac;

//    private String auto_ID() {
//        Dao_MauSac daoMauSac = new Dao_MauSac();
//        String idPrefix = daoMauSac.taoMaMauSac();
//        return idPrefix;
//    }
//
//    public MauSac(String mauSac) {
//        this.maMauSac = auto_ID();
//        this.mauSac = mauSac;
//
//    }
//
//    public MauSac() {
//    }
//
//    public MauSac(String maMauSac, String mauSac) {
//        this.maMauSac = maMauSac;
//        this.mauSac = mauSac;
//    }
//
//    public String getMaMauSac() {
//        return maMauSac;
//    }
//
//    public void setMaMauSac(String maMauSac) {
//        this.maMauSac = maMauSac;
//    }
//
//    public String getMauSac() {
//        return mauSac;
//    }
//
//    public void setMauSac(String mauSac) {
//        this.mauSac = mauSac;
//    }
}
