/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab01.controllers;

import com.mycompany.lab01.models.Account;
import com.mycompany.lab01.models.ChequingAccount;
import com.mycompany.lab01.models.OverdraftAccount;
import java.math.BigDecimal;

/**
 *
 * @author Константин
 */
public class ChequingAccountController extends AbstractAccountController{

    public ChequingAccountController(ChequingAccount account) {
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
