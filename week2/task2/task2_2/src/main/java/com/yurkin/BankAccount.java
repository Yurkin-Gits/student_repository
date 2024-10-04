package com.yurkin;

public class BankAccount {
    private final String accountNumber;
    private double balance; 

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber; 
        this.balance = initialBalance; 
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Депозит выполнен. Новый баланс: " + balance);
        } else {
            System.out.println("Недопустимая сумма для депозита.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Снятие выполнено. Новый баланс: " + balance);
        } else {
            System.out.println("Недопустимая сумма для снятия или недостаточно средств.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    
}
