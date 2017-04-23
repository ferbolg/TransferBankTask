package com.interview.task;

/**
 * Created by administrator on 04.04.17.
 */
public class Account {

    Integer number;
    Integer balance;

    public Account(Integer number, Integer balance) {
        this.number = number;
        this.balance = balance;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getBalance() {
        return balance;
    }

    public void withdraw (int amount){
        this.balance = balance - amount;
    }

    public void deposit(int amount){
        this.balance = balance + amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                '}';
    }
}
