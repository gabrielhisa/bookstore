package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
