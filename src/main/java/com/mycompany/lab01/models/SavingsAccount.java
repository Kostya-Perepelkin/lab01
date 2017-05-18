/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab01.models;

import static com.mycompany.lab01.models.constants.DateFormatConstants.MYDATEFORMAT;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Константин
 */
public class SavingsAccount extends Account{
        
    private Date passBookDateUpdated;


    public SavingsAccount(){
        //initialization?
    }
    
    public SavingsAccount(String customerName, int customerNumber, int accountNumber, BigDecimal balance, Date passBookDateUpdated){
        this.setCustomerName(customerName);
        this.setCustomerNumber(customerNumber);
        this.setAccountNumber(accountNumber);
        this.setBalance(balance);
        this.setPassBookDateUpdated(passBookDateUpdated);
    }
    
    public Date getPassBookDateUpdated() {
        return passBookDateUpdated;
    }

    public void setPassBookDateUpdated(Date passBookDateUpdated) {
        this.passBookDateUpdated = passBookDateUpdated;
    }
    
    public String toString(){
        
        String returnString = "Savings Account: \n";
        returnString += super.toString();
        SimpleDateFormat DATEFORMAT= new SimpleDateFormat(MYDATEFORMAT);
        
        returnString += "Pass Book Date Updated: " + DATEFORMAT.format(this.getPassBookDateUpdated())+ "\n";
        
        return returnString;
    }
}
