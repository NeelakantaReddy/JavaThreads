package com.example.lifecycle;

public class LoanCalculator {

    public static double calculatePrincipal(double emi, double annualRate, int months) {
        // Convert annual interest rate to monthly interest rate
        double r = annualRate / (12 * 100);
        
        // Calculate the principal amount using the formula
        double principal = (emi * (Math.pow(1 + r, months) - 1)) / (r * Math.pow(1 + r, months));
        
        return principal;
    }

    public static void main(String[] args) {
        double emi = 45627; // Monthly EMI
        double annualRate = 8.5; // Annual interest rate (12%)
        int months = 18; // Loan term in months
        
        double principal = calculatePrincipal(emi, annualRate, months);
        System.out.println("The principal amount is: " + principal);
    }
}
