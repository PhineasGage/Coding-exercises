package pl.mateuszgorski.figures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PolymorphismTest {

    @Test
    public void rectangleImplementsFigure() {
        //Given
        Figure rectangle = new Rectangle(2, 3);

        //When
        Double actual = rectangle.calculateArea();

        //Then
        assertThat(actual, is(6d));
    }

    @Test
    public void SquareIsRectangle() {
        //Given
        Rectangle square = new Square(2);

        //When
        Double actual = square.calculateArea();

        //Then
        assertThat(actual, is(4d));
    }
}
