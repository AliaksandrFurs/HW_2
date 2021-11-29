package com.it_academy.practice.junit_basics;


import java.util.Scanner;

public class Calculator {

    private int a;
    private int b;

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
        switch(operation) {
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
                } catch (ArithmeticException e){
                    System.out.println("Divide by zero!");
                }
            }
            case '*': {
                return a * b;
            }
            case '^': {
                return (float)Math.sqrt(a);
            }
            case '#': {
                return (float)Math.pow(a,b);
            }
        }
    }


}
