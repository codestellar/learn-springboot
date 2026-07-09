package com.itdc.books.services;

import java.util.ArrayList;

import com.itdc.books.Ebook;
import com.itdc.books.PrintedBook;
import com.itdc.books.entity.Book;

public interface BookService {
    ArrayList<Book> getBooks(String filter);
    ArrayList<Book> getBooksByFormat(String format);
    Book addEbook(Ebook ebook);
    Book addPrintedBook(PrintedBook printedBook);
    boolean deleteBook(int id);
}
