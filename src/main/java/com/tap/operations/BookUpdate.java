package com.tap.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.entity.BooksEntity;

public class BookUpdate {

    public static void main(String[] args) {
        // Create a Hibernate configuration and set properties
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // Create a session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create a session
        Session session = sessionFactory.openSession();

        // Specify the bookId you want to update
        int bookIdToUpdate = 1;

        // Begin a transaction
        Transaction transaction = session.beginTransaction();

        // Retrieve the book to update
        BooksEntity bookToUpdate = session.get(BooksEntity.class, bookIdToUpdate);

        // Update the book details
        if (bookToUpdate != null) {

            bookToUpdate.setTitle("The Lord of the Rings");
            bookToUpdate.setAuthor("J.R.R. Tolkien");
            bookToUpdate.setGenre("Fantasy");
            bookToUpdate.setPublicationYear(1954);
            bookToUpdate.setAvailableCopies(9);
            bookToUpdate.setTotalCopies(22);

            // Save the updated book to the database
            session.update(bookToUpdate);

            System.out.println("Book with ID " + bookIdToUpdate + " updated successfully.");
        } else {
            System.out.println("Book with ID " + bookIdToUpdate + " not found.");
        }

        // Commit the transaction
        transaction.commit();

        // Close the session and the session factory
        session.close();
        sessionFactory.close();
    }
}
