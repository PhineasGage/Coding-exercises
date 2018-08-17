package pl.mateuszgorski.figures;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class SquareTest {

    @Test
    @Parameters(method = "side")
    public void shouldCalculateCorrectArea(double sideA) {
        //Given
        Square testSquare = new Square(sideA);

        //When
        double actual = testSquare.calculateArea();

        //Then
        assertThat(actual, is(sideA * sideA));
    }

    public Object[] side() {
        return new Double[]{2d, 3d, 1d,};
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    @Parameters(method = "negativeSide")
    public void shouldThrowIllegalArgumentExceptionWhenParamsAreNegativeOrZero(double sideA) {
        //Given
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Sides must be positive Integers");

        //When
        new Square(sideA);
    }

    public Object[] negativeSide() {
        return new Double[]{-2d, 0d, -3d};
    }
}