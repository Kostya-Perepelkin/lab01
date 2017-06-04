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
public class OverdraftAccount extends Account{
    
    private BigDecimal overdraftMaxAmount;
    
    public OverdraftAccount(String customerName, int customerNumber, int accountNumber, BigDecimal balance, BigDecimal overdraftMaxAmount){
        this.setCustomerName(customerName);
        this.setCustomerNumber(customerNumber);
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
        this.setOverdraftMaxAmount(overdraftMaxAmount);
    }
    
    public BigDecimal getOverdraftMaxAmount() {
        return overdraftMaxAmount;
    }

    public void setOverdraftMaxAmount(BigDecimal overdraftMaxAmount) {
        this.overdraftMaxAmount = overdraftMaxAmount;
    }

    @Override
    public String toString(){
        String returnString = "Overdraft Account: \n";
        returnString += super.toString();
        returnString += "Overdraft Max Amount: \t" + this.getOverdraftMaxAmount() + "\n";
        
        return returnString;
    }
    
    @Override
    public String getAccountType(){
        return "Overdraft";
    }
}
