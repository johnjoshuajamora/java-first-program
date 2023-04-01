package com.h2;

public class MortgageCalculator {
    private static long loanAmount;
    private static int termInYears;
    private static float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        MortgageCalculator.loanAmount = loanAmount;
        MortgageCalculator.termInYears = termInYears;
        MortgageCalculator.annualRate = annualRate;
    }

    private static int getNumberOfPayments() {
        return termInYears * 12;
    }
}
