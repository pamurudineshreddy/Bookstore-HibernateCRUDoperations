package com.tap.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.entity.BooksEntity;

public class BookInsertion {

    public static void main(String[] args) {
        // Create a Hibernate configuration and set properties
        Configuration configuration = new Configuration();
        
        configuration.configure("hibernate.cfg.xml");

        // Create a session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create a session
        Session session = sessionFactory.openSession();

        // Create a new book to insert
         BooksEntity newBook = new BooksEntity("The Fault in Our Stars", "John Green", "Young Adult", 2012, 10, 15);
         System.out.println(newBook);

        // Begin a transaction
        Transaction transaction = session.beginTransaction();

        // Save the book to the database
        session.save(newBook);

        // Commit the transaction
        transaction.commit();

        // Close the session and the session factory
        session.close();
        sessionFactory.close();
    }
}

