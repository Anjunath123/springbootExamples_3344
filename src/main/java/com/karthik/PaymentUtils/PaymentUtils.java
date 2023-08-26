package com.karthik.PaymentUtils;

import com.karthik.Exception.InsufficiantAmountException;


import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {
    private static final Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("acc1", 12000.00);
        paymentMap.put("acc2", 10000.00);
        paymentMap.put("acc3", 8000.00);
        paymentMap.put("acc4", 5000.00);
    }

    public static boolean validateCreditLimit(String accNo, Double paidAmount) {
        // Check if the account number exists in the map
        if (!paymentMap.containsKey(accNo)) {
            throw new IllegalArgumentException("Invalid account number: " + accNo);
        }

        // Check if paidAmount is null or negative
        if (paidAmount == null || paidAmount < 0) {
            throw new IllegalArgumentException("Invalid paid amount: " + paidAmount);
        }

        // Check if the paid amount exceeds the credit limit
        double creditLimit = paymentMap.get(accNo);
        if (paidAmount > creditLimit) {
            throw new InsufficiantAmountException("Insufficient Funds...");
        }

        // If all checks pass, return true
        return true;
    }
}
