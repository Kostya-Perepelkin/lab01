/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab01.controllers;

import com.mycompany.exceptions.AccountException;
import static com.mycompany.lab01.constants.AccountOperationsConstants.ACCOUNT_OPERATIONS;
import com.mycompany.lab01.models.Account;
import com.mycompany.lab01.models.ChequingAccount;
import com.mycompany.lab01.models.OverdraftAccount;
import com.mycompany.lab01.models.SavingsAccount;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Константин
 */
public class OperationsController {
    
    List <Account> accountList;
    
    public OperationsController(List <Account> accountList){
        this.accountList= accountList;
    }
    
    public String performOperation(String operationType, int accountNumber, BigDecimal amount){
        String message = "";
        int counter =0;
        
        try{
            Account acc = findAccount(accountNumber);
            AbstractAccountController accountController = getAccountController(acc);
            
            
            switch(operationType.toUpperCase()){
                case "DEPOSIT":
                    message = accountController.deposit(amount);
                    break;
                    
                case "WITHDRAW":
                    message = accountController.withdraw(amount);
                    break;
                    
                default:
                    message = "ERROR-008: Incorrect operation";
            }
            
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return message;
    }
    
    private boolean checkOperationType(String operationType){
        boolean IsCorrectOperation = false;
        
        if (ACCOUNT_OPERATIONS.contains(operationType)){
            IsCorrectOperation = true;
        }
        return IsCorrectOperation;
    }
    
    private Account findAccount(int accountNumber) throws Exception{
        int counter = 0;
        Account foundAccount = null;
        
        if (accountList.size() > 0){
            for (Account acc: accountList){
                counter++;
                if (acc.getAccountNumber() == accountNumber){
                    return acc;
                }
                else {
                    if (counter == accountList.size()){
                        throw new AccountException(String.format("ERROR-004: Acccount not found- %s", accountNumber));
                    }
                }
            }
        }
        else{
            throw new AccountException("ERROR-005: Account list is empty");
        }
        
        return foundAccount;
    }
    
    private AbstractAccountController getAccountController(Account acc){
        AbstractAccountController accountController = null;
            
            switch(acc.getAccountType()){
                case "Chequing":
                    accountController = new ChequingAccountController((ChequingAccount) acc);
                    break;
                    
                case "Savings":
                    accountController = new SavingsAccountController((SavingsAccount)acc);
                    break;
                    
                case "Overdraft":
                    accountController = new OverdraftAccountController((OverdraftAccount)acc);
                    break;
                    
                default:
                    System.out.println("ERROR-007: Account type not ");
            }
        return accountController;
    }
    
}
