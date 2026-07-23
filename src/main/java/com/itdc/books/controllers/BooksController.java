package com.itdc.books.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.itdc.books.entity.Book;
import com.itdc.books.models.Ebook;
import com.itdc.books.models.PrintedBook;
import com.itdc.books.services.BookService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BooksController {
    
    public BookService bookService;

    @Value("${spring.application.name}")
    private String appName;


    @Value("${springdoc.swagger-ui.path}")
    private String docsPath;

    public BooksController(@Qualifier("upBookService") BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/appName")
    public ResponseEntity<String> getAppName() {
        return ResponseEntity.ok("<h1 style='margin:auto; font-family: Arial;'>Welcome to " + appName +" </h1><a href='/docs'>Click here to access API docs.</a>");
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
