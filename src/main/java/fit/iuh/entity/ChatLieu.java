package fit.iuh.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ChatLieu")
public class ChatLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maChatLieu;

    @Column(name = "tenChatLieu", length = 50, nullable = false)
    private String chatLieu;


//    public ChatLieu() {
//    }
//
//    private String auto_ID(){
//        Dao_ChatLieu daoChatLieu = new Dao_ChatLieu();
//        String idPrefix = daoChatLieu.taoMaChatLieu();
//        return idPrefix;
//    }
//
//    public ChatLieu(String chatLieu) {
//        this.maChatLieu = auto_ID();
//        this.chatLieu = chatLieu;
//    }
//
//    public ChatLieu(String maChatLieu, String chatLieu) {
//        this.maChatLieu = maChatLieu;
//        this.chatLieu = chatLieu;
//    }
//
//
//    public String getMaChatLieu() {
//        return maChatLieu;
//    }
//
//    public void setMaChatLieu(String maChatLieu) {
//        this.maChatLieu = maChatLieu;
//    }
//
//    public String getChatLieu() {
//        return chatLieu;
//    }
//
//    public void setChatLieu(String chatLieu) {
//        this.chatLieu = chatLieu;
//    }
}
