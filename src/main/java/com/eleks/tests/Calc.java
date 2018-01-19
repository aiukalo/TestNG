package com.eleks.tests;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Andrii.Iukalo on 17-Nov-17.
 */
public class Calc {

    public int multiply(int a, int b) {
        int result = a * b;
        return result;
    }

    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not supported by math.");
        }
        int result = a / b;
        return result;
    }

    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    public int subtract(int a, int b) {
        int result = a - b;
        return result;
    }
}
