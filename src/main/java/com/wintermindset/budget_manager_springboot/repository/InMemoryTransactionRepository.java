package com.wintermindset.budget_manager_springboot.repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.wintermindset.budget_manager_springboot.domain.Transaction;

@Repository
public class InMemoryTransactionRepository {
    private final Map<BigInteger, Transaction> transactions = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    public List<Transaction> findAll() {
        return new ArrayList<>(transactions.values());
    }

    public Optional<Transaction> findById(BigInteger id) {
        return Optional.ofNullable(transactions.get(id));
    }

    public Transaction save(Transaction transaction) {
        BigInteger id = transaction.getId();
        if (id == null) {
            id = BigInteger.valueOf(idGenerator.incrementAndGet());
        }
        Transaction t = new Transaction(
                id,
                transaction.getTransactionDate(),
                transaction.getTransactionType(),
                transaction.getTransactionCategory(),
                transaction.getAmount()
        );
        transactions.put(id, t);
        return t;
    }

    public void deleteById(BigInteger id) {
        transactions.remove(id);
    }

    public void clear() {
        transactions.clear();
        idGenerator.set(0);
    }
}
