package com.example.localdemoenkoin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @Test
    void calculateBMI() {
        assertEquals(22, BMICalculator.calculateBMI(70, 1.78));
        assertNotEquals(21, BMICalculator.calculateBMI(70, 1.78));
    }
}