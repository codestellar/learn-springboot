package com.itdc.books.services;

import java.util.ArrayList;

import com.itdc.books.entity.Book;
import com.itdc.books.models.Ebook;
import com.itdc.books.models.PrintedBook;

public interface BookService {
    ArrayList<Book> getBooks(String filter);
    ArrayList<Book> getBooksByFormat(String format);
    Book addEbook(Ebook ebook);
    Book addPrintedBook(PrintedBook printedBook);
    boolean deleteBook(int id);
}
