package com.company;

import java.math.BigDecimal;

public class Customer {

    public static void main(String[] args) {
	BankService myBankService = new BankService();

    int mySavings = myBankService.createNewAccount("saving", new BigDecimal(500.00));
    int myInvestment = myBankService.createNewAccount("investment", new BigDecimal(1000.00));
    myBankService.transferMoney(myInvestment, mySavings, new BigDecimal(100.00));
    }
}
