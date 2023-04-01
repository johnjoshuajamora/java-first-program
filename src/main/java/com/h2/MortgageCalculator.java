package com.h2;

import java.text.DecimalFormat;

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

    private static float getMonthlyInterestRate() {
        float interestRate = (annualRate / 100) / 12;

        return interestRate;
    }

    public void calculateMonthlyPayment() {
        long p = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();
        double M = p * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));

        this.monthlyPayment = M;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");

        return "monthlyPayment: " + df.format(monthlyPayment);
    }

    public static void main(String[] args) {

    }
}
