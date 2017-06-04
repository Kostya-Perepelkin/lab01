/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab01.controllers;

import com.mycompany.lab01.models.Account;
import com.mycompany.lab01.models.SavingsAccount;
import java.math.BigDecimal;

/**
 *
 * @author Константин
 */
public class SavingsAccountController extends AbstractAccountController{

    public SavingsAccountController(SavingsAccount account) {
        super(account);
    }

    @Override
    public String withdraw(BigDecimal amount) {
        String message = "";
        if (acc.getBalance().doubleValue() >= amount.doubleValue() ){
            super.acc.withdraw(amount);
            message = String.format("Successfully withdrawed $%s from account %s", amount, acc.getAccountNumber());
        }
        else{
            message = String.format("Sorry, there are not enough funds in the account %s. "
                    + "Requested amount %s, current balance is %s", 
                    acc.getAccountNumber(), amount, acc.getBalance());
        }        
        return message;
    }
    
}
