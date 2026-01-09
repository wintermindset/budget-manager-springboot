package com.wintermindset.budget_manager_springboot.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class Transaction {
    private final BigInteger id;
    private final LocalDateTime transactionDate;
    public final TransactionType transactionType;
    public final TransactionCategory transactionCategory;
    private final BigDecimal amount;

    public Transaction(
            BigInteger id,
            LocalDateTime transactionDate,
            TransactionType transactionType,
            TransactionCategory transactionCategory,
            BigDecimal amount
    ) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.transactionCategory = transactionCategory;
        this.amount = amount;
    }

    public BigInteger getId() {
        return id;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public boolean isIncome() {
        return transactionType.isIncome();
    }

    public boolean isExpense() {
        return transactionType.isExpense();
    }
}
