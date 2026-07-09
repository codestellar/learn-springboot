package com.itdc.books;

import com.itdc.books.entity.Book;

public class PrintedBook extends Book {
    private String numberOfPages;

    public PrintedBook(int id, String title, String author, String price, String numberOfPages) {
        super(id, title, author, price);
        this.numberOfPages = numberOfPages;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String getFormat() {
        return "PrintedBook"; 
    }
}
