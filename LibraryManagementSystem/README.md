
---

## ✅ `README.md` for **Library Management System**
```markdown
# 📚 Library Management System

A simple console-based library system that allows managing books, issuing, and returning. Built using **Java**, **JDBC**, and **MySQL**.

---

## 📌 Features
- Add new books
- View all books
- Issue a book
- Return a book

---

## 🛠️ Technologies Used
- Java
- JDBC (Java Database Connectivity)
- MySQL

---

## ⚙️ MySQL Database Setup

1. Open **MySQL Workbench** or **phpMyAdmin**
2. Run the following SQL script:

```sql
CREATE DATABASE library;
USE library;

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(100),
    issued BOOLEAN
);
