package com.pedoran.pwpbsesi14.FirebaseExample.entity;

public class Book {
    String bookId;
    String bookTitle;
    String bookDifficulty;

    public Book() {
    }

    public Book(String bookId, String bookTitle, String bookDifficulty) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookDifficulty = bookDifficulty;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookDifficulty() {
        return bookDifficulty;
    }
}
