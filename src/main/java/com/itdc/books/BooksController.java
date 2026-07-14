package com.itdc.books;

import org.springframework.web.bind.annotation.RestController;

import com.itdc.books.entity.Book;
import com.itdc.books.services.BookService;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BooksController {

    public final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ArrayList<Book> getBooks(@RequestParam(required = false) String filter) {
        return bookService.getBooks(filter);
    }

    @GetMapping("/books/{format}")
    public ArrayList<Book> getBooksByFormat(@PathVariable String format) {
        return bookService.getBooksByFormat(format.toLowerCase());
    }

    @PostMapping("/ebook")
    public Book postEbooks(@RequestBody Ebook ebook) {

        Book book = bookService.addEbook(ebook);

        return book;
    }

    @PostMapping("/printedBook")
    public Book postMethodName(@RequestBody PrintedBook printedBook) {
        Book book = bookService.addPrintedBook(printedBook);
        return book;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {

        var result = bookService.deleteBook(id);
        return result ? ResponseEntity.ok("Book with ID " + id + " deleted successfully")
                : ResponseEntity.notFound().build();
    }
}
