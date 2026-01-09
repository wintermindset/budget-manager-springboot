package com.wintermindset.budget_manager_springboot.domain;

public enum TransactionType {
    INCOME,
    EXPENSE;

    public boolean isIncome() {
        return this == INCOME;
    }

    public boolean isExpense() {
        return this == EXPENSE;
    }
}
