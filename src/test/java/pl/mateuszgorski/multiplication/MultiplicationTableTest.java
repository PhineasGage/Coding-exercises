package pl.mateuszgorski.multiplication;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static pl.mateuszgorski.multiplication.HamcrestFormattedRowAssert.*;
import static pl.mateuszgorski.multiplication.MultiplicationTable.*;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(JUnitParamsRunner.class)
public class MultiplicationTableTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    @Parameters(method = "invalidInputs")
    public void throwsIllegalArgumentExceptionWhenInputIsInvalid(final int invalidInput) {
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("The number is out of bounds");
        getAndValidateTableSize(invalidInput);
    }


    private Object[] invalidInputs() {
        return new Object[]{-15, 0, 13};
    }

    @Test
    @Parameters(method = "entireMultiplicationTable")
    public void createsEntireTable(int size, String[][] expected) {
        //when
        String[][] actual = createMultiplicationTableArray(size);
        //then
        for (int i = 0; i < expected.length; i++) {
            assertThat(actual[i], isSameRowAs(expected[i]));
        }
    }

    private Object[] entireMultiplicationTable() {
        return new Object[][]{
                {2, new String[][]{
                        {"1", "2"},
                        {"2", "4"}}},
                {3, new String[][]{
                        {"1", "2", "3"},
                        {"2", "4", "6"},
                        {"3", "6", "9"}}},
                {4, new String[][]{
                        {"1", "2", "3", "4"},
                        {"2", "4", "6", "8"},
                        {"3", "6", "9", "12"}}},
                {10, createExpectedTables(10)},
                {12, createExpectedTables(12)}
        };
    }

    private String[][] createExpectedTables(int size) {
        String[][] multiplicationArray = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                multiplicationArray[i][j] = "" + (i + 1) * (j + 1);
            }
        }
        return multiplicationArray;
    }


}