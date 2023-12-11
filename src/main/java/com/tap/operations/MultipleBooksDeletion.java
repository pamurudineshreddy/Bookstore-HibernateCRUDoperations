package com.tap.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.entity.BooksEntity;

import java.util.List;

public class MultipleBooksDeletion {

    public static void main(String[] args) {
        // Create a Hibernate configuration and set properties
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // Create a session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        Transaction transaction = session.beginTransaction();

        // Retrieve multiple books to delete based on some criteria
        List<BooksEntity> booksToDelete = session.createQuery("FROM BooksEntity WHERE genre = 'Mystery'", BooksEntity.class).getResultList();

        // Delete each book from the database
        for (BooksEntity bookToDelete : booksToDelete) {
            session.delete(bookToDelete);
            System.out.println("Book with ID " + bookToDelete.getBookId() + " deleted successfully.");
        }

        // Commit the transaction
        transaction.commit();

        // Close the session and the session factory
        session.close();
        sessionFactory.close();
    }
}

