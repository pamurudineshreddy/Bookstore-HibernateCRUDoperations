package com.tap.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tap.entity.BooksEntity;

import java.util.List;

public class BookListRetrieval {

    public static void main(String[] args) {
        // Create a Hibernate configuration and set properties
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        // Create a session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Create a session
        Session session = sessionFactory.openSession();

        // Retrieve all books from the database
        List<BooksEntity> bookList = session.createQuery("FROM BooksEntity", BooksEntity.class).getResultList();

        // Print the retrieved books
        System.out.println("List of Books:");
        for (BooksEntity book : bookList) {
            System.out.println(book);
        }

        // Close the session and the session factory
        session.close();
        sessionFactory.close();
    }
}

