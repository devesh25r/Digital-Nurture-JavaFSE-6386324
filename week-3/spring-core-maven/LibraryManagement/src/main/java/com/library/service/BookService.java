package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    // Exercise 2: DI - Add private field
    private BookRepository bookRepository;

    // Exercise 2: DI - Add setter method for injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String bookName) {
        System.out.println("Adding book: " + bookName);
        // Exercise 2: Use injected repository
        bookRepository.saveBook(bookName);
    }
}


