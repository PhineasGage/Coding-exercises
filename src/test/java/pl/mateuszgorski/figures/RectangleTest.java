package pl.mateuszgorski.figures;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RectangleTest {

    @Test
    @Parameters(method = "sides")
    public void shouldCalculateCorrectArea(double sideA, double sideB, double expected) {
        //Given
        Rectangle testRectangel = new Rectangle(sideA, sideB);

        //When
        double actual = testRectangel.calculateArea();

        //Then
        assertThat(actual, is(expected));
    }

    public Object[] sides() {
        return new Double[][]{
                {2d, 3d, 6d},
                {3d, 4d, 12d},
                {1d, 1d, 1d}
        };
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Parameters(method = "negativeSides")
    public void shouldThrowIllegalArgumentExceptionWhenParamsAreNegativeOrZero(double sideA, double sideB) {
        //Given
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Sides must be positive Integers");

        //When
        new Rectangle(sideA, sideB);
    }

    public Object[] negativeSides() {
        return new Double[][]{{-2d, 0d}, {2d, -3d}};
    }
}