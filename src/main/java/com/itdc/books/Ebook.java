package com.itdc.books;

import com.itdc.books.entity.Book;

public class Ebook extends Book {
    private String fileSize;
    private String fileFormat;

    public Ebook(int id, String title, String author, String price, String fileSize, String fileFormat) {
        super(id, title, author, price);
        this.fileSize = fileSize;
        this.fileFormat = fileFormat;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public String getFormat() {
        return "Ebook";
    }
    
}
