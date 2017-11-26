# TestNG
for Calc project with tesng tests included
  
------------------------------------------
package com.eleks.tests;

/**
 * Created by Andrii.Iukalo on 17-Nov-17.
 */
public class Calc {

    public int multiply(int a, int b) {
        int result = a * b;
        return result;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            System.out.println("Division impossible");
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
---------------------------------------------

package com.eleks.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Andrii.Iukalo on 17-Nov-17.
 */
public class CalcTest {


    @Test (dataProvider = "Multiplication")
    public void testMultiplyWithDataProvider(int a, int b, int expResult) throws Exception {
        int actualResult = calc.multiply(a,  b);
        Assert.assertEquals(actualResult, expResult);
    }

    @Test (dataProvider = "Division")
    public void testDivideWithDataProvider(int a, int b, int expResult) throws Exception {
        int actualResult = calc.divide(a, b);
        Assert.assertEquals(actualResult, expResult);
    }

    @Test (dataProvider = "Addition")
    public void testAddWithDataProvider(int a, int b, int expResult) throws Exception {
        int actualResult = calc.add(a, b);
    }
    @DataProvider (name = "Multiplication")
    private Object[][] getTestData() {
        return new Object[][] {
                {-878, 0, 0},
                {-800, 1, -800},
                {-1, -1, 1},
                {0, 0, 0},
                {1, 1, 1},
                {5, 5, 25},
                {100, 100, 10000}
        };
    }



    private Calc calc = new Calc();
}
