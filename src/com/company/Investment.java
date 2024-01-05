package com.company;

import java.math.BigDecimal;
import java.util.Random;

public class Investment implements IAccount{
    private BigDecimal currentAmount;
    private int accountNumber;

    public Investment(BigDecimal initAmount){
        currentAmount = initAmount;
        Random random = new Random();
        accountNumber = random.nextInt();
    }
    @Override
    public void deposit(BigDecimal amount) {
        currentAmount = amount.add(currentAmount);
        System.out.println("Successfully deposited money..");
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if(currentAmount.compareTo(amount) >= 0){
            currentAmount = currentAmount.subtract(amount);
            System.out.println("Successfully withdraw..");
        }
        else{
            System.out.println("Insufficient Amount..");
        }
    }

    @Override
    public void transfer(IAccount to,BigDecimal amount) {
        if(currentAmount.compareTo(amount) >= 0){
            currentAmount = currentAmount.subtract(amount);
            to.deposit(amount);
            System.out.println("Successfully transfer..");
        }
        else{
            System.out.println("Insufficient Amount..");
        }
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }
}

