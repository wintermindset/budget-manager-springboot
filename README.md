# Budget Manager Spring Boot

Minimal REST API for managing financial transactions, implemented in Java with Spring Boot. This project uses an **in-memory repository** (for now) and is intended as a learning prototype (current version 0.0.1).

---

## Features

- CRUD operations for transactions.
- Transaction fields: `id`, `transactionDate`, `transactionType`, `transactionCategory`, `amount`.
- REST endpoints via `TransactionController`.
- In-memory storage (`InMemoryTransactionRepository`).

---

## Getting Started

1. Clone the repository:

```bash
git clone https://github.com/wintermindset/budget-manager-springboot.git
```

2. Build and run with Maven:

```bash
mvn spring-boot:run
```

3. Access endpoints:

- `GET /transactions` — list all transactions.
- `GET /transactions/{id}` — get a transaction by ID.
- `POST /transactions` — create a new transaction (JSON body).
- `DELETE /transactions/{id}` — delete a transaction by ID.

## Example JSON for POST

```JSON
{
  "transactionDate": "2026-01-01T14:00:00",
  "transactionType": "INCOME",
  "transactionCategory": "SALARY",
  "amount": 15000.00
}
```

## Version

- 0.0.1 — minimal working prototype with domain, controller, and in-memory repository.
- 0.1.0 — integration with PostgreSQL, additional features.