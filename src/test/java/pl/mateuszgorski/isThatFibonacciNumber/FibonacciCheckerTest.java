package pl.mateuszgorski.isThatFibonacciNumber;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FibonacciCheckerTest {

    FibonacciChecker fibonacciChecker = new FibonacciChecker();

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    @Parameters(method = "invalidFibonacci")
    public void isNotFibonacciNumber(long invalidFibonacci) {
        assertFalse(fibonacciChecker.checkIfFibonacci(invalidFibonacci));
    }

    public Object[] invalidFibonacci() {
        return new Long[]{4L, 6L, 7L, 9L, 10L, 11L, Long.MAX_VALUE};
    }

    @Test
    @Parameters(method = "validFibonacci")
    public void isFibonacciNumber(long invalidFibonacci) {
        assertTrue(fibonacciChecker.checkIfFibonacci(invalidFibonacci));
    }

    public Object[] validFibonacci() {
        return new Long[]{0L, 1L, 2L, 3L, 5L, 8L, 13L, 7540113804746346429L};
    }

    @Test
    @Parameters(method = "invalidInputs")
    public void whenInvalidInputThrowsIlegalArgumentException(long invalidInput) {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("number has to be higher then zero");
        fibonacciChecker.checkIfFibonacci(invalidInput);
    }

    public Object[] invalidInputs() {
        return new Long[]{-300L, -15L, -3L};
    }
}