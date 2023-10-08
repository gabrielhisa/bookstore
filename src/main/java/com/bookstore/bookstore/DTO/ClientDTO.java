package com.bookstore.bookstore.DTO;

import jakarta.persistence.OneToMany;

import java.awt.print.Book;
import java.util.Date;

public class ClientDTO {

    private int clientId;
    private String name;
    private String address;
    //private Date birthDate;
    private String document;
    private Book books;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }
}
