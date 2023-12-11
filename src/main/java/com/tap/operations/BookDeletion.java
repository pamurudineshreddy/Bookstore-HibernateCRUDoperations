package com.tap.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.entity.BooksEntity;

public class BookDeletion {

    public static void main(String[] args) {
        // Create a Hibernate configuration and set properties
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // Create a session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create a session
        Session session = sessionFactory.openSession();

        // Specify the bookId you want to delete
        int bookIdToDelete = 1;

        // Begin a transaction
        Transaction transaction = session.beginTransaction();

        // Retrieve the book to delete
        BooksEntity bookToDelete = session.get(BooksEntity.class, bookIdToDelete);

        // Delete the book from the database
        if (bookToDelete != null) {
            session.delete(bookToDelete);
            System.out.println("Book with ID " + bookIdToDelete + " deleted successfully.");
        } else {
            System.out.println("Book with ID " + bookIdToDelete + " not found.");
        }

        // Commit the transaction
        transaction.commit();

        // Close the session and the session factory
        session.close();
        sessionFactory.close();
    }
}

