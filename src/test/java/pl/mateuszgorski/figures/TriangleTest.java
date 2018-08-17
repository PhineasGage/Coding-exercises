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
public class TriangleTest {

    @Test
    @Parameters(method = "sides")
    public void shouldCalculateCorrectArea(double sideA, double height, double expected) {
        //Given
        Triangle triangle = new Triangle(sideA, height);

        //When
        double actual = triangle.calculateArea();

        //Then
        assertThat(actual, is(expected));
    }

    public Object[] sides() {
        return new Double[][]{
                {1d, 2d, 1d},
                {2d, 4d, 4d},
                {3d, 6d, 9d}
        };
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Parameters(method = "negativeSidesAndHeights")
    public void shouldThrowIllegalArgumentExceptionWhenParamsAreNegativeOrZero(double sideA, double height) {
        //Given
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Height and base must be positive Integers");

        //When
        new Triangle(sideA, height);
    }

    public Object[] negativeSidesAndHeights() {
        return new Double[][]{
                {-1d, 2d},
                {-3d, -4d},
                {-5d, 0d},
                {0d, 0d}
        };
    }
}