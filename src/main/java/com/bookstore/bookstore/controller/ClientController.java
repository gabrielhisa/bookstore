package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.model.Client;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*", allowedHeaders="*")
public class ClientController {

    private final ClientRepository repository;

    @Autowired
    public ClientController(ClientRepository repo){
        repository = repo;
    }


    // Basic REST methods without using the DTO classes
    // Working as intended
    @GetMapping("/all")
    public ResponseEntity<List<Client>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    // Working as intended
    @GetMapping("/{id}")
    public ResponseEntity<Client> GetById(@PathVariable long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    // Working as intended, even if it has an ID on the JSON, it'll create a new registry
    @PostMapping("/newclient")
    public ResponseEntity<Client> post(@RequestBody Client client){
        // In case an ID is passed on the JSON, setting it as zero
        client.setClientId(0);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(client));
    }

    // Working as expected, not 100%
    @PutMapping("/update/{id}")
    public ResponseEntity<Client> put(@RequestBody Client client){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(client));
    }

    // Working as intended
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        Optional<Client> temp = Optional.of(new Client());
        temp = repository.findById(id);

        if (temp.isEmpty()){
            return "ID not found: " + id;
        }
        repository.deleteById(id);
        return "Deleted registry ID " + id;
    }
}
