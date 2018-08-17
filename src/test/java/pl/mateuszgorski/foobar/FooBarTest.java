package pl.mateuszgorski.foobar;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FooBarTest {

    String[] testArray = FooBar.createFooBarArray(100);

    private static final Object[] wrongInputs() {
        return new Object[]{-300, -15, 0};
    }

    private static final Object[] rightInputs() {
        return new Object[][]{{3, "3 Foo"}, {5, "5 Bar"}, {9, "9 Foo"}, {12, "12 Foo"}, {20, "20 Bar"}, {45, "45 FooBar"}};
    }

    @Test
    @Parameters(method = "rightInputs")
    public void correctlyAddsFooAndBar(int input, String expected) {
        //when
        String actual = testArray[input - 1];
        //then
        assertThat(actual, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "wrongInputs")
    public void whileWrongInputThrowIAE(int wrongInput) {
        FooBar.createFooBarArray(wrongInput);
    }
}