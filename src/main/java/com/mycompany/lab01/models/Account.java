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
        //this.balance += depositedAmount;
        this.balance.add(depositedAmount);
    }
    
    public void withdraw(BigDecimal withdrawedAmount){
        //this.balance -= withdrawedAmount;
        this.balance.subtract(withdrawedAmount);
    }
    
    
    public String toString(){
        String returnString = "";
        returnString += "Customer name: \t\t" + this.getCustomerName() + "\n";
        returnString += "Customer number: \t" + this.getCustomerNumber() + "\n";
        returnString += "Account number: \t" + this.getAccountNumber() + "\n";
        returnString += "Balance: \t\t" + this.getBalance() + "\n";
        return returnString;
    }
    
}
