package com.interview.task;

class TransactionThread extends Thread
{
    private TestBank bank;
    private Account fromAccount;
    private Account toAccount;
    private int ammount;

    public TransactionThread(TestBank b, Account from, Account to, int ammount)
    {
        bank = b;
        fromAccount = from;
        toAccount = to;
        this.ammount = ammount;
    }

    public void run()
    {
//        try
//        {
//            while (!interrupted())
//            {
//                bank.transfer(this.fromAccount, this.toAccount, this.ammount);
//                sleep(1);
//            }
//        }
//        catch(InterruptedException e) {}
        try
        {

                bank.transfer(this.fromAccount, this.toAccount, this.ammount);
                sleep(1);

        }
        catch(InterruptedException e) {}
    }


}