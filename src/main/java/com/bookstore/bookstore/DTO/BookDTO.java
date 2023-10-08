package com.bookstore.bookstore.DTO;

import com.bookstore.bookstore.model.Book;

import java.util.Date;

public class BookDTO {

    private long bookId;
    private String name;
    private String author;
    //private int year;
    private String publisher;
    private String genre;
    private String status;
    private double weight;
    private int pages;
    private double price;
    private Date entryDate;

    // Method to bring DTO Book information
    public static BookDTO mapToDto(Book book){
        BookDTO dto = new BookDTO();
        dto.setBookId(book.getId());
        dto.setName(book.getName());
        dto.setAuthor(book.getAuthor());
        dto.setPublisher(book.getPublisher());
        dto.setGenre(book.getGenre());
        dto.setStatus(book.getStatus());
        dto.setWeight(book.getWeight());
        dto.setPages(book.getPages());
        dto.setPrice(book.getPrice());

        return dto;
    }




    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
