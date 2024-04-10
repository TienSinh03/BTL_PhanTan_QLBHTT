import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * @ (#) Main.java      4/10/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 4/10/2024
 */
public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("JPADemo_SQL").createEntityManager();

        EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

}
