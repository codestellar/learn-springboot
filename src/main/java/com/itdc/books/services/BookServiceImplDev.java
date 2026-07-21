package com.itdc.books.services;

import com.itdc.books.entity.Book;
import com.itdc.books.models.Ebook;
import com.itdc.books.models.PrintedBook;

import java.util.ArrayList;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("upBookService")
public class BookServiceImplDev implements BookService {

    ArrayList<Book> books = new ArrayList<>();

    public BookServiceImplDev() {
        books.add(new Ebook(1, "Ebook Title 1 DEV", "Author 1", "$10.99", "2MB", "PDF"));
        books.add(new Ebook(2, "Ebook Title 2 DEV", "Author 2", "$12.99", "3MB", "EPUB"));
        books.add(new Ebook(3, "Ebook Title 3 DEV", "Author 3", "$9.99", "1.5MB", "MOBI"));
    }

    public ArrayList<Book> getBooks(String filter) {
        if (filter == null || filter.isEmpty()) {
            return books;
        }
        ArrayList<Book> filteredBooks = new ArrayList<>();

        books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(filter.toLowerCase()))
                .forEach(filteredBooks::add);

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
            var result = books.remove(id);
            return result != null;
        // return books.removeIf(book -> book.getId() == id);
        // Logic to delete the book from the database or collection
    }

}