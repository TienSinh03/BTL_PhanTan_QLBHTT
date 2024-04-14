/**
 * @ (#) IChatLieuDao.java      4/10/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package fit.iuh.dao;

import fit.iuh.entity.CTPhieuDatHang;
import fit.iuh.entity.ChatLieu;

import java.util.ArrayList;
import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 4/10/2024
 */
public interface IChatLieuDao {
    public ArrayList<ChatLieu> getAllChatLieu();
    public boolean themDLChatLieu(ChatLieu chatLieu);
    public boolean xoaDLChatLieu(long maChatLieu);
    public boolean catNhatDLChatLieu(ChatLieu chatLieu);
    public ChatLieu getDLChatLieuTheoMa(long id);
    public ChatLieu getChatLieuTheoTen(String tenChatLieu);

}
