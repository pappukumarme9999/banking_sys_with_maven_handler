package com.pappu.banking.strategy;

public class SimpleInterestStrategy implements InterestCalculationStrategy {
    private double interestRate;

    public SimpleInterestStrategy(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest(double balance) {
        return balance * interestRate;
    }
}
