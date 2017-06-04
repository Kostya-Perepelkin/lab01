/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab01.controllers;

import com.mycompany.lab01.models.Account;
import com.mycompany.lab01.models.OverdraftAccount;
import java.math.BigDecimal;

/**
 *
 * @author Константин
 */
public class OverdraftAccountController extends AbstractAccountController{

    public OverdraftAccountController(OverdraftAccount account) {
        super(account);
    }

    @Override
    public String withdraw(BigDecimal amount) {
        String message = "";
        BigDecimal maxAvailableAmount = super.acc.getBalance().add(((OverdraftAccount) super.acc).getOverdraftMaxAmount());
        
        if (maxAvailableAmount.doubleValue() >= amount.doubleValue()){
            BigDecimal amountFromBalance = acc.getBalance();
            BigDecimal amountFromOverDraft = ((OverdraftAccount) acc).getOverdraftMaxAmount();

            acc.setBalance(BigDecimal.valueOf(0.0));
            ((OverdraftAccount) acc).setOverdraftMaxAmount(amountFromOverDraft.subtract(amount.subtract(amountFromBalance)));
            message = String.format("Successfully withdrawed with OVERDRAFT! $%s from account %s", amount, acc.getAccountNumber());
        }
        else{
            message = String.format("Sorry, there are not enough funds in the overdraft account %s. "
                    + "Requested amount %s, current balance is %s, availableOverdraft is ", 
                    acc.getAccountNumber(), amount, acc.getBalance(), ((OverdraftAccount) acc).getOverdraftMaxAmount()); 
        }
        
        return message;
    }
    
}
