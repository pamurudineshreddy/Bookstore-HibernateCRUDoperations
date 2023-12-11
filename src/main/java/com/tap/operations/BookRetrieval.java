package com.tap.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tap.entity.BooksEntity;

public class BookRetrieval {

    public static void main(String[] args) {
        // Create a Hibernate configuration and set properties
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // Create a session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create a session
        Session session = sessionFactory.openSession();

        // Specify the bookId you want to retrieve
        int bookIdToRetrieve = 9;

        // Retrieve the book from the database
        BooksEntity retrievedBook = session.get(BooksEntity.class, bookIdToRetrieve);

        // Print the retrieved book details
        if (retrievedBook != null) {
            System.out.println("Retrieved Book: " + retrievedBook);
        } else {
            System.out.println("Book with ID " + bookIdToRetrieve + " not found.");
        }

        // Close the session and the session factory
        session.close();
        sessionFactory.close();
    }
}

