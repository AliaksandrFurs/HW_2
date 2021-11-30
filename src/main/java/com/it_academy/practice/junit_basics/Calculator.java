package com.it_academy.practice.junit_basics;


import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    private int a;
    private int b;
    private String strError;

    public String getStrError() {
        return strError;
    }

    public void setStrError(String strError) {
        this.strError = strError;
    }

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public float getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public float calculate(char operation) {
        switch (operation) {
            default: {
                return 0;
            }
            case '-': {
                return a - b;
            }
            case '+': {
                return a + b;
            }
            case '/': {
                try {
                    return a / b;
                } catch (ArithmeticException e) {
                    System.out.println("Divide by zero!");
                    this.setStrError("Divide by zero!");
                }
            }
            case '*': {
                return a * b;
            }
            case '^': {
                return (int) Math.sqrt(a);
            }
            case '#': {
                return (int) Math.pow(a, b);
            }
        }
    }

    public static float calcVar(char operation, int... numbers){

        switch (operation) {
            default: {
                return 0;
            }
            case '-': {
                int temp = numbers[0];
                for (int i = 1; i < numbers.length ; i++) {
                    temp -= numbers[i];
                }
                return temp;
            }
            case '+': {
                int temp = 0;
                return temp = Arrays.stream(numbers).sum();
            }
            case '/': {
                try {
                    int temp = numbers[0];
                    for (int i = 1; i < numbers.length; i++) {
                        temp /= numbers[i];
                    }
                    return temp;
                }catch (ArithmeticException e){
                    System.out.println("Divide by zero!");
                }
            }
            case '*': {
                int temp = numbers[0];
                for (int i = 1; i < numbers.length; i++) {
                    temp *= numbers[i];
                }
                return temp;
            }
        }
    }
}

