package com.wintermindset.budget_manager_springboot.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wintermindset.budget_manager_springboot.domain.Transaction;
import com.wintermindset.budget_manager_springboot.repository.InMemoryTransactionRepository;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final InMemoryTransactionRepository repository;

    public TransactionController(InMemoryTransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Transaction> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Transaction> getById(@PathVariable BigInteger id) {
        return repository.findById(id);
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return repository.save(transaction);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable BigInteger id) {
        repository.deleteById(id);
    }
}
