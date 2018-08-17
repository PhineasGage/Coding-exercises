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
public class TrapezoidTest {

    @Test
    @Parameters(method = "sides")
    public void shouldCalculateCorrectArea(double sideA, double sideB, double height, double expected) {
        //Given
        Trapezoid trapezoid = new Trapezoid(sideA, sideB, height);

        //When
        double actual = trapezoid.calculateArea();

        //Then
        assertThat(actual, is(expected));
    }

    public Object[] sides() {
        return new Double[][]{
                {2d, 2d, 2d, 4d},
                {3d, 6d, 4d, 18d},
                {3d, 7d, 1d, 5d}
        };
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Parameters(method = "negativeSidesAndHeights")
    public void shouldThrowIllegalArgumentExceptionWhenParamsAreNegativeOrZero(double sideA, double sideB, double height) {
        //Given
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Sides and height must be positive Integers");

        //When
        new Trapezoid(sideA, sideB, height);
    }

    public Object[] negativeSidesAndHeights() {
        return new Double[][]{
                {-1d, 2d, 2d},
                {-3d, -4d, 3d,},
                {5d, 2d, -3d},
                {0d, 0d, 0d}
        };
    }
}