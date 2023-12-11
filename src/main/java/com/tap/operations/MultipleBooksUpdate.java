package com.tap.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.entity.BooksEntity;

import java.util.List;

public class MultipleBooksUpdate {

    public static void main(String[] args) {
        // Create a Hibernate configuration and set properties
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // Create a session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        Transaction transaction = session.beginTransaction();

        // Retrieve multiple books from the database based on some criteria
        List<BooksEntity> booksToUpdate = session.createQuery("FROM BooksEntity WHERE publicationYear < 2000", BooksEntity.class).getResultList();

        // Update the details of each book in the list
        for (BooksEntity bookToUpdate : booksToUpdate) {
            bookToUpdate.setGenre("Modernized Genre");
            // Add more update operations as needed
        }

        // Commit the transaction
        transaction.commit();

        // Close the session and the session factory
        session.close();
        sessionFactory.close();
    }
}
