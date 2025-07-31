# 💰 Simple Banking System

A console-based Java application that simulates basic banking operations. Built using **Java**, **JDBC**, and **MySQL**.

---

## 📌 Features
- Create a new account
- View account balance
- Deposit funds
- Withdraw funds

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
CREATE DATABASE bank;
USE bank;

CREATE TABLE accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    balance DOUBLE
);
