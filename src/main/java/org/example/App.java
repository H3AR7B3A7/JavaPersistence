package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class App {
    public static void main( String[] args ) {

        // New product made by user
        Product p = new Product();
        p.setId(3);
        p.setNaam("Test Object");
        p.setBeschrijving("Test Beschrijving");
        p.setPrijs(new BigDecimal("20.00"));
        p.setProductCategorie("toy");
        p.setProductImagePath("www.example.com/img.jpg");

        // Creating EntityManagers
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence");
        EntityManager em = emf.createEntityManager();

        // Get a product from db
        Product a = em.find(Product.class,1);
        System.out.println(a);

        // Import a product to db
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        System.out.println(p);
    }
}
