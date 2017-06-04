/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab01;


import com.mycompany.lab01.models.*;
import com.mycompany.lab01.controllers.*;
import static com.mycompany.lab01.constants.DateFormatConstants.MYDATEFORMAT;
import static com.mycompany.lab01.constants.DateFormatConstants.MYDATEFORMATTOPARSE;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigDecimal;

/**
 *
 * @author Константин
 */
public class Main {

    public static void main(String[] args) {
        
        System.out.println("Welcome to the lab 01!");
        System.out.println("This is simplified banking system");
        
        
        
        //List <Account> accountList = getInitialAccounts();
        //printAccounts(accountList);
        List <Account> accountList = new ArrayList();
        
        String input = "Chequing Sam Jones 12343 2758 125.98 \n" +
                        "\n" +
                        "Savings Susan Welles 98457 3457 387.45 3/12/2013 \n" +
                        "\n" +
                        "Overdraft Jo-Anne Beamsley 88439 7328 23.50 500.0" + 
                        "\n" + 
                        "End";
        //Scanner scanner = new Scanner(input).useDelimiter("\\s*fish\\s*");
        
        accountList = readInitialAccountsData(input);
        System.out.println("\nList of available accounts: ");
        printAccounts(accountList);
        
        String operationsInput = "Deposit 2758 99.50\n" +
            "\n" +
            "Withdraw 3457 100.00\n" +
            "\n" +
            "Withdraw 7328 100.00\n" +
            "\n" +
            "End";
        accountList = performOperations(operationsInput, accountList);
        
        System.out.println("\nList of available accounts after operations: ");
        printAccounts(accountList);
        /*
        Boolean wantsToExit = false;
        while (!wantsToExit){
            int userSelection = -1;
            System.out.println("Please, select one of the following options: \n");
            System.out.println("1 - to deposit an amount to an account \n");
            System.out.println("2 - to withdraw an amount from an account \n");
            System.out.println("3 - to exit the system \n");
        }
        */     
    }
    
    
    public static List <Account> getInitialAccounts(){
        System.out.println("Available accounts and information about them:");
        List <Account> accountList = new ArrayList();
        accountList.add(new ChequingAccount("Bill Brown", 1, 10001, BigDecimal.valueOf(999999.99)));
        accountList.add(new ChequingAccount("Steve Green", 2, 10002, BigDecimal.valueOf(55.99)));
        accountList.add(new ChequingAccount("Marco Klein", 3, 10003, BigDecimal.valueOf(123.22)));
        
        accountList.add(new OverdraftAccount("Bill Brown", 1, 20001, BigDecimal.valueOf(999999.99), BigDecimal.valueOf(100000.00)));
        accountList.add(new OverdraftAccount("Steve Green", 2, 20002, BigDecimal.valueOf(50.0), BigDecimal.valueOf(50.0)));
        accountList.add(new OverdraftAccount("Marco Klein", 3, 20003, BigDecimal.valueOf(0.00), BigDecimal.valueOf(0.00)));
        
        SimpleDateFormat DATEFORMAT;
        DATEFORMAT = new SimpleDateFormat(MYDATEFORMAT);
        
        Date date = new Date();
        try {
            date = DATEFORMAT.parse("01/01/2015 11:56:00");
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        accountList.add(new SavingsAccount("Mary Rose", 4, 20001, BigDecimal.valueOf(999999.99), date));
        
        try {
            date = DATEFORMAT.parse("02/02/2015 11:57:00");
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        accountList.add(new SavingsAccount("Helen Ruger", 5, 20002, BigDecimal.valueOf(10.0), date));
        
        try {
            date = DATEFORMAT.parse("29/08/2010 12:10:00");
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        accountList.add(new SavingsAccount("Denis Siegel", 6, 20003, BigDecimal.valueOf(555.00), date));
        
        return accountList;
    }
    
    public static void printAccounts(List <Account> accountList){
        for (Account acc: accountList){
            System.out.println(acc.toString());
        }
    }
    
    
    public static List <Account> readInitialAccountsData(String input){
        List <Account> accountList = new ArrayList();
        Scanner scanner = new Scanner(input);
        
        String accountType = "";
        SimpleDateFormat DATEFORMAT = new SimpleDateFormat(MYDATEFORMATTOPARSE);
        
        boolean endOfSection = false;
        
        while (!endOfSection && scanner.hasNextLine()){
            accountType = scanner.next();
            
            if (accountType.equalsIgnoreCase("Chequing")){
                String name = "";
                while (!scanner.hasNextInt()){
                    name += scanner.next();
                    if (!scanner.hasNextInt()){
                        name += " ";
                    }
                }
                //String tempVar = scanner.next();
                int clientID = scanner.nextInt();
                int accountNumber = scanner.nextInt();
                //Double amount = Double.parseDouble(scanner.next());
                BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.next()));
                accountList.add(new ChequingAccount(name, clientID, accountNumber, amount));
            }
            else if (accountType.toUpperCase().equals("Savings".toUpperCase())){
                String name = "";
                while (!scanner.hasNextInt()){
                    name += scanner.next();
                    if (!scanner.hasNextInt()){
                        name += " ";
                    }
                }
                int clientID = scanner.nextInt();
                int accountNumber = scanner.nextInt();
                //double amount = Double.parseDouble(scanner.next());
                BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.next()));
                String dateString = scanner.next();
                Date passBookDateUpdated = new Date();
                try {
                    passBookDateUpdated = DATEFORMAT.parse(dateString);
                    accountList.add(new SavingsAccount(name, clientID, accountNumber, amount, passBookDateUpdated));
                } catch (ParseException ex) {
                    System.out.println("ERROR-002:" + ex.getMessage());
                }
                        
            }
            else if (accountType.toUpperCase().equals("Overdraft".toUpperCase())){
                String name = "";
                while (!scanner.hasNextInt()){
                    name += scanner.next();
                    if (!scanner.hasNextInt()){
                        name += " ";
                    }
                }
                int clientID = scanner.nextInt();
                int accountNumber = scanner.nextInt();
                //double amount = Double.parseDouble(scanner.next());
                //double overdraftMaxAmount = Double.parseDouble(scanner.next());
                BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.next()));
                BigDecimal overdraftMaxAmount = BigDecimal.valueOf(Double.parseDouble(scanner.next()));
  
                accountList.add(new OverdraftAccount(name, clientID, accountNumber, amount, overdraftMaxAmount));
            }
            else if (accountType.toUpperCase().equals("END")) {
                endOfSection = true;
            }
            else {
                System.out.println("ERROR-001: Unknown type of account- " + accountType);
            }
        }
        scanner.close(); 
        return accountList;
    }
    
    public static List <Account> performOperations(String operationsInput, List <Account> accountList){
        String message = "";
        Scanner scanner = new Scanner(operationsInput);
        String accountType = "";
        SimpleDateFormat DATEFORMAT = new SimpleDateFormat(MYDATEFORMATTOPARSE);
        
        boolean endOfSection = false;
        String operationType = "";
        
        OperationsController controller = new OperationsController(accountList);
        
        
        while (!endOfSection & scanner.hasNextLine()){
            
            operationType = scanner.next();
            if (operationType.toUpperCase().equals("Deposit".toUpperCase()) || 
                    operationType.toUpperCase().equals("Withdraw".toUpperCase())){
                
                int accountNumber = scanner.nextInt();
                //double amount = Double.parseDouble(scanner.next());
                BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(scanner.next()));
                
                message = controller.performOperation(operationType, accountNumber, amount);
                System.out.println(message);
            }
            else if(operationType.toUpperCase().equals("END")){
                endOfSection = true; 
                break;
            }
            else{
                System.out.println(String.format("ERROR-005: operation type wan not found- %s", operationType));
            }
            
        }
        
        return accountList;
    }
    
    

}
