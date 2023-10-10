package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class BookController {

    private BookRepository repository;

    @Autowired
    public BookController(BookRepository repo){
        repository = repo;
    }


    // Basic REST methods without using the DTO classes
    // Working as intended
    @GetMapping("/all")
    public ResponseEntity<List<Book>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    // Working as intended
    @GetMapping("/{id}")
    public ResponseEntity<Book> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    // Working as intended, even if it has an ID on the JSON, it'll create a new registry
    @PostMapping("/newbook")
    public ResponseEntity<Book> post(@RequestBody Book book){
        // In case an ID is passed on the JSON, setting it as zero
        book.setId(0);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(book));
    }

    // Working as intended
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> put(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(book));
    }

    // Working as intended
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        Optional<Book> temp = Optional.of(new Book());
        temp = repository.findById(id);

        if (temp.isEmpty()){
            return "Book id not found - " + id;
        }

        repository.deleteById(id);
        return "Deleted registry ID " + id;
    }
}
