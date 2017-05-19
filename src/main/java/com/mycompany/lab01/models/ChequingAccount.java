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
public class ChequingAccount extends Account{
    
    public ChequingAccount(String customerName, int customerNumber, int accountNumber, BigDecimal balance){
        this.setCustomerName(customerName);
        this.setCustomerNumber(customerNumber);
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
    }

    @Override
    public String toString(){
        String returnString = "Chequing Account: \n";
        returnString += super.toString();
        
        return returnString;
    }
    
}
