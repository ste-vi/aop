package org.stevi;

import org.stevi.service.BookService;

public class Main {

    public static void main(String[] args) {
        var bookService = new BookService();

        System.out.println("hello");

        Integer id = bookService.insertBook("Book1");
        String book = bookService.getBook(id);
        bookService.removeBook(id);
    }
}