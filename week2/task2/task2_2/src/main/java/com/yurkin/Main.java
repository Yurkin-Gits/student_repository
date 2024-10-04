package com.yurkin;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("100000000", 500.0); 
        account.deposit(1500.0);
        account.withdraw(1000.0);
        System.out.println("Текущий баланс: " + account.getBalance());
    }
}
