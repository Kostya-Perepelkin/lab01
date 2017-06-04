/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab01.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Константин
 */
public class AccountOperationsConstants {
    public static final List<String> ACCOUNT_OPERATIONS = Collections.unmodifiableList(
    new ArrayList<String>() {{
        add("Withdraw");
        add("Deposit");
    }});
}
