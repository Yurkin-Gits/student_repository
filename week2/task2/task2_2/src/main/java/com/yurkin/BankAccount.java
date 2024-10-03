package com.yurkin;

public class BankAccount {
    private String accountNumber;
    private double balance; 

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber; 
        this.balance = initialBalance; 
    }

    public void deposit(double amount) {
        // Метод для внесения денег на счет
        if (amount > 0) {
            balance += amount;
            System.out.println("Депозит выполнен. Новый баланс: " + balance);
        } else {
            System.out.println("Недопустимая сумма для депозита.");
        }
    }

    public void withdraw(double amount) {
        // Метод для снятия денег со счета
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Снятие выполнено. Новый баланс: " + balance);
        } else {
            System.out.println("Недопустимая сумма для снятия или недостаточно средств.");
        }
    }

    public double getBalance() {
        // Метод для получения текущего баланса
        return balance;
    }

    public String getAccountNumber() {
        // Метод для получения номера счета
        return accountNumber;
    }
    
    public static void main(String[] args) {
        // Пример использования
        BankAccount account = new BankAccount("100000000", 500.0); 
        account.deposit(1500.0);
        account.withdraw(1000.0);
        System.out.println("Текущий баланс: " + account.getBalance());
    }
}
