package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {

    private final long loanAmount;
    private final int termInYears;
    private final float annualRate;
    private double monthlyPayment;

    public MortgageCalculator(long loanAmount, int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.termInYears = termInYears;
        this.annualRate = annualRate;
    }

    private int getNumberOfPayments() {
        return termInYears * 12;
    }

    private float getMonthlyInterestRate() {
        float interestRate = annualRate / 100;
        return interestRate / 12;
    }

    public void calculateMonthlyPayment() {
        long P = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();

        double M = P * (((r * Math.pow(1 + r, n))) / ((Math.pow(1 + r, n)) - 1));
        this.monthlyPayment = M;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("####0.00");
        return "monthlyPayment: " + df.format(monthlyPayment);
    }

    public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("Usage: MortgageCalculator <loanAmount> <termInYears> <annualRate>");
            return;
        }

        long loanAmount = Utilities.getLongValue(args[0]);
        int termInYears = Utilities.getIntValue(args[1]);
        float annualRate = Utilities.getFloatValue(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);
        calculator.calculateMonthlyPayment();

        System.out.println(calculator.toString());
    }
}
