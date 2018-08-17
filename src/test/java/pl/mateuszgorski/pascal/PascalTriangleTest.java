package pl.mateuszgorski.pascal;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static pl.mateuszgorski.pascal.FormattedRowsAssert.assertThat;
import static pl.mateuszgorski.pascal.PascalTriangle.*;

@RunWith(JUnitParamsRunner.class)
public class PascalTriangleTest {

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "invalidInputs")
    public void throwsIAEwhenInputisInvalid(int invalidInput) {
        createPascalTriangleArray(invalidInput);
    }

    public Object[] invalidInputs() {
        return new Object[]{-300, -15, 0};
    }

    @Test
    @Parameters(method = "lastRowsOfPascalTriangleTest")
    public void createLastRowOfPascalTriangle(int size, double[] expected) {
        //When
        String actual = createPascalTriangleArray(size)[size - 1];
        //Then
        assertThat(actual).isSameRowAs(expected);
    }

    public Object[] lastRowsOfPascalTriangleTest() {
        return new Object[][]{
                {3, new double[]{1, 2, 1}},
                {4, new double[]{1, 3, 3, 1}},
                {5, new double[]{1, 4, 6, 4, 1}}
        };
    }
}