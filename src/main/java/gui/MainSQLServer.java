package gui;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainSQLServer {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("N8_PTJV_QuanLyLuongSanPham_2024 MSSQL");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			System.out.println("Done!!");
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
