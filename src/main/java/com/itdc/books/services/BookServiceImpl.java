package com.itdc.books.services;

import com.itdc.books.Ebook;
import com.itdc.books.PrintedBook;
import com.itdc.books.entity.Book;
import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    ArrayList<Book> books = new ArrayList<>();

    public BookServiceImpl() {
        books.add(new Ebook(1, "Ebook Title 1", "Author 1", "$10.99", "2MB", "PDF"));
        books.add(new Ebook(2, "Ebook Title 2", "Author 2", "$12.99", "3MB", "EPUB"));
        books.add(new Ebook(3, "Ebook Title 3", "Author 3", "$9.99", "1.5MB", "MOBI"));
    }

    public ArrayList<Book> getBooks(String filter) {
        if (filter == null || filter.isEmpty()) {
            return books;
        }
        ArrayList<Book> filteredBooks = new ArrayList<>();

        books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(filter.toLowerCase()))
                .forEach(filteredBooks::add).s;

        return filteredBooks;
    }

    public ArrayList<Book> getBooksByFormat(String format) {
        if (format == null || format.isEmpty()) {
            return books;
        }
        ArrayList<Book> filteredBooks = new ArrayList<>();

        books.stream()
                .filter(book -> book.getFormat().toLowerCase().equals(format.toLowerCase()))
                .forEach(filteredBooks::add);

        return filteredBooks;
    }

    public Book addEbook(Ebook ebook) {
        books.add(ebook);
        // Logic to add the ebook to the database or collection
        return ebook;
    }

    public Book addPrintedBook(PrintedBook printedBook) {

        books.add(printedBook);
        // Logic to add the printed book to the database or collection
        return printedBook;
    }

    public boolean deleteBook(int id) {
        return books.removeIf(book -> book.getId() == id);
        // Logic to delete the book from the database or collection
    }   
    
}