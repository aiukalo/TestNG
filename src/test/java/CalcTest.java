import com.eleks.tests.Calc;
import org.testng.Assert;
import org.testng.annotations.*;

// This code will implement TestNG listeners

@Listeners(Listener.class)
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
        Assert.assertEquals(actualResult, expResult);
    }

    @Test (dataProvider = "Subtraction")
    public void restSubtractWithDataProvider(int a, int b, int expResult) throws Exception {
        int actualResult = calc.subtract(a, b);
        Assert.assertEquals(actualResult, expResult);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divisionByZero() throws Exception {
        calc.divide(10, 0);
    }

    @Parameters({"dividedNumber", "dividerNumber", "expRes"})
    @Test
    public void testWithParameters(@Optional("20") int divided, @Optional("10") int divider, @Optional("2") int expected) {
        int actualResult = calc.divide(divided, divider);
        Assert.assertEquals(actualResult, expected);
    }

    @DataProvider (name = "Multiplication")
    private Object[][] getTestMultiplyData() {
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

    @DataProvider (name = "Division")
    private Object[][] getTestDivideData() {
        return new Object[][] {
                {-500, -5, 100},
                {500, -5, -100},
                {500, 5, 100},
                {-500, 5, -100},
                {0, 1, 0},
                {0, -1, 0},

        };
    }

    @DataProvider (name = "Addition")
    private Object[][] getTestAddData() {
        return new Object[][] {
                {0, 0, 0},
                {0, 1, 1},
                {1, 0, 1},
                {-2, 1, -1},
                {2, -1, 1},
                {-1, -1, -2},
                {1, 1, 2}
        };
    }

    @DataProvider (name = "Subtraction")
    private Object[][] getTestSubtrData() {
        return new Object[][] {
                {0, 1, -1},
                {-1, -1, 0},
                {0, 0, 0},
                {1, 1, 0},
                {1, 2, -1}
        };
    }

    private Calc calc = new Calc();
}