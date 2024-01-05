package com.company;

import java.math.BigDecimal;
import java.util.Hashtable;

public class BankService {
   private Hashtable<Integer, IAccount> bankAccounts;

   public BankService(){
       this.bankAccounts = new Hashtable<Integer, IAccount>();
   }

   public int createNewAccount(String type, BigDecimal initAmount) {
       IAccount newAccount = null;

       switch (type) {
           case "chequing":
               newAccount = new Chequing(initAmount);
               break;

           case "saving":
               newAccount = new Saving(initAmount);
               break;

           case "investment":
               newAccount = new Investment(initAmount);
               break;

           default:
               System.out.println("Invalid Account type ");
               break;
       }

       if (newAccount != null) {
           this.bankAccounts.put(newAccount.getAccountNumber(), newAccount);
           return newAccount.getAccountNumber();
       }
       return -1;
   }

   public void transferMoney(int from, int to, BigDecimal amount){
       IAccount toAccount = this.bankAccounts.get(to);
       IAccount fromAccount = this.bankAccounts.get(from);
       fromAccount.transfer(toAccount, amount);
   }

}
