package com.interview.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    private static Integer NACCOUNTS = 1000;
    private static Integer NTHREADS = 100000;
    private static Integer AMOUNT = 10000;

    public static void main(String[] args) {

        List<Account> accountList = new ArrayList<Account>();

        for (int i = 1; i <= NACCOUNTS; i++) {
            accountList.add(new Account(i, AMOUNT));
        }

        Integer totalBalanceBeforeTransactions = getTotalBalance(accountList);

        TestBank bank = new TestBank();

        TimeWatch watch = TimeWatch.start();

        List<TransactionThread> transactionThreads = new ArrayList<TransactionThread>();
        for (int i = 0; i < NTHREADS; i++) {
            int toAccount = (int) (accountList.size() * Math.random());
            int fromAccount = (int) (accountList.size() * Math.random());
            int amount = (int) (AMOUNT * Math.random());
            TransactionThread t = new TransactionThread(bank, accountList.get(toAccount),
                    accountList.get(fromAccount), amount);
            t.setPriority(Thread.NORM_PRIORITY + i % 2);
            transactionThreads.add(t);
            t.start();
        }

        // Waiting for all threads to finish their tasks
        for (TransactionThread thread: transactionThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long passedTimeInSeconds = watch.time(TimeUnit.SECONDS);

        Integer totalBalanceAfterTransactions = getTotalBalance(accountList);
        System.out.println("passedTimeInSeconds: " + passedTimeInSeconds);
        System.out.println("Before transactions: " + totalBalanceBeforeTransactions);
        System.out.println("After Transactions : " + totalBalanceAfterTransactions);

    }

    private static Integer getTotalBalance(List<Account> accountList) {

        Integer sum = 0;
        for (Account acc : accountList) {
            sum += acc.getBalance();
        }
        return sum;
    }

}
