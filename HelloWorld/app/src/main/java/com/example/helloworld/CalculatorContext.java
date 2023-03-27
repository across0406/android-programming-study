package com.example.helloworld;

import java.io.Serializable;

public class CalculatorContext implements Serializable {
    private double inputA_;
    private double inputB_;
    private double result_;

    public CalculatorContext(double inputA, double inputB, double result) {
        inputA_ = inputA;
        inputB_ = inputB;
        result_ = result;
    }

    public double getInputA() {
        return inputA_;
    }

    public double getInputB() {
        return inputB_;
    }

    public double getResult() {
        return result_;
    }
}
