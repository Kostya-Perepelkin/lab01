/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab01.models;

import java.math.BigDecimal;

/**
 *
 * @author Константин
 */
public abstract class Account {
    private String customerName;
    private int customerNumber;
    private int accountNumber;
    private BigDecimal balance;
    

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    public void deposit(BigDecimal depositedAmount){
        balance.add(depositedAmount);
    }
    
    public void withdraw(BigDecimal withdrawedAmount){
        balance.subtract(withdrawedAmount);
    }
    
    @Override
    public String toString(){
        String returnString = "";
        returnString += "Customer name: \t\t" + getCustomerName() + "\n";
        returnString += "Customer number: \t" + getCustomerNumber() + "\n";
        returnString += "Account number: \t" + getAccountNumber() + "\n";
        returnString += "Balance: \t\t" + getBalance() + "\n";
        return returnString;
    }
    
    public abstract String getAccountType();
    
}
