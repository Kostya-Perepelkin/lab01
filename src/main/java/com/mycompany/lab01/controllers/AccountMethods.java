/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab01.controllers;

import java.math.BigDecimal;

/**
 *
 * @author Константин
 */
public interface AccountMethods {
    
    public BigDecimal getBalance();
    public String deposit(BigDecimal amount);
    public String withdraw(BigDecimal amount);
    
}
