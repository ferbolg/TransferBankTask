package com.interview.task;


/**
 * Created by administrator on 04.04.17.
 */
public class TestBank {
    public void transfer(Account from, Account to, int amount) {

        Account temp1;
        Account temp2;
        if (from.getNumber() < to.getNumber()) {
            temp1 = from;
            temp2 = to;
        } else {
            temp1 = to;
            temp2 = from;
        }
        synchronized (temp1) {
            synchronized (temp2) {

                // Debug output, uncomment if needed
                // System.out.println("Debug info: from = " + from + ", to = " + to + " amount=" + amount);

                if (from.getBalance() < amount) {
                    // Here we could throw exception or log it as error. For demo purposes, we simply write to sout
                    System.out.println("Abort transaction:insufficient amount on account " + from.toString());
                } else {
                    from.withdraw(amount);
                    to.deposit(amount);
                }

            }
        }
    }


}
