package com.example.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.entity.Product;
import com.example.util.HibernateUtil;

public class ProductMain {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Insert data (run once, later you can comment these)
        session.save(new Product("Laptop", "Electronics", 60000, 10));
        session.save(new Product("Mouse", "Electronics", 500, 50));
        session.save(new Product("Keyboard", "Electronics", 1500, 20));
        session.save(new Product("Chair", "Furniture", 3500, 15));
        session.save(new Product("Table", "Furniture", 8000, 5));

        tx.commit();

        // -------- SORT BY PRICE ASC --------
        Query<Product> q1 =
                session.createQuery("FROM Product p ORDER BY p.price ASC", Product.class);

        System.out.println("\n--- Price Ascending ---");
        q1.list().forEach(p ->
                System.out.println(p.getName() + " " + p.getPrice()));

        // -------- SORT BY PRICE DESC --------
        Query<Product> q2 =
                session.createQuery("FROM Product p ORDER BY p.price DESC", Product.class);

        System.out.println("\n--- Price Descending ---");
        q2.list().forEach(p ->
                System.out.println(p.getName() + " " + p.getPrice()));

        // -------- SORT BY QUANTITY --------
        Query<Product> q3 =
                session.createQuery("FROM Product p ORDER BY p.quantity DESC", Product.class);

        System.out.println("\n--- Quantity High to Low ---");
        q3.list().forEach(p ->
                System.out.println(p.getName() + " " + p.getQuantity()));

        session.close();
        System.out.println("\nSUCCESS");
    }
}
