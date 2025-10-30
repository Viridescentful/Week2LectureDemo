package com.example.localdemoenkoin;

public class BMICalculator {
    public static double calculateBMI(double weightInKg, double heightInMeters) {
        if (heightInMeters <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        return Math.round(weightInKg / Math.pow(heightInMeters, 2));
    }
}
