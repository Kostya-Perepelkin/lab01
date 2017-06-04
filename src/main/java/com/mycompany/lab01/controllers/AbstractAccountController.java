/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab01.controllers;

import com.mycompany.lab01.models.Account;
import java.math.BigDecimal;

/**
 *
 * @author Константин
 */
public abstract class AbstractAccountController implements AccountMethods{
    
    Account acc;
    
    AbstractAccountController(Account account){
        acc = account;
    }

    @Override
    public BigDecimal getBalance() {
        return acc.getBalance();
    }

    @Override
    public String deposit(BigDecimal amount) {
        String result = "";
        try{
            acc.deposit(amount);
            result = (String.format("Successfully withdrawed $%s from account %s", amount, acc.getAccountNumber()));
        }
        catch (Exception ex){
            result = ex.getMessage();
        }
        return result;
    }

    @Override
    public abstract String withdraw(BigDecimal amount);
    
    
    
}
