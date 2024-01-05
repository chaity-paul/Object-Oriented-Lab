package com.company;

import java.math.BigDecimal;

public interface IAccount {
    public void deposit(BigDecimal amount);
    public void withdraw(BigDecimal amount);
    public void transfer(IAccount to, BigDecimal amount);
    public int getAccountNumber();

}
