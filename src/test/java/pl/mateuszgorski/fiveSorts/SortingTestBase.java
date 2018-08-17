package pl.mateuszgorski.fiveSorts;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnitParamsRunner.class)
public abstract class SortingTestBase {

    public abstract SortingMethod getSortingMethod();

    @Rule
    public Timeout globalTimeout = new Timeout(100);

    @Test
    public void shouldSortSimpleArray() {

        // given
        int[] given = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        // when
        float startTime = System.currentTimeMillis();
        int[] result = getSortingMethod().sort(given);
        float endTime = System.currentTimeMillis();
        System.out.println("TIME " + (endTime - startTime));

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    @Parameters(method = "provideLargeArrays")
    public void shouldSortLargeArray(int[] largeArray) {

        // When
        float startTime = System.currentTimeMillis();
        int[] result = getSortingMethod().sort(largeArray);
        float endTime = System.currentTimeMillis();
        System.out.println("TIME " + (endTime - startTime));
    }

    @Test
    public void shouldSortArrayWithElementsLesserThenZero() {

        // given
        int[] given = {-7, -5, -6, -4, -2, -1, -3};
        int[] expected = {-7, -6, -5, -4, -3, -2, -1};

        // when
        float startTime = System.currentTimeMillis();
        int[] result = getSortingMethod().sort(given);
        float endTime = System.currentTimeMillis();
        System.out.println("TIME " + (endTime - startTime));

        // then
        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnCorrectArrayWithIdenticalElements() {

        // given
        int[] given = {1, 1, 1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1, 1, 1};

        // when
        float startTime = System.currentTimeMillis();
        int[] result = getSortingMethod().sort(given);
        float endTime = System.currentTimeMillis();
        System.out.println("TIME " + (endTime - startTime));

        // then
        assertArrayEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenArrayIsNull() {

        //given
        int[] invalidArray = null;

        // when
        int[] result = getSortingMethod().sort(invalidArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenArrayIsZeroLength() {

        //given
        int[] invalidArray = new int[0];

        // when
        int[] result = getSortingMethod().sort(invalidArray);
    }


    public Object[] provideLargeArrays() {
        return new Object[]{
                createArray(100),
                createArray(1000),
                createArray(100000)
        };
    }

    public static int[] createArray(int size) {
        int[] intArray = new int[size];
        Random random = new Random();
        for (int j = 0; j < intArray.length; j++) {
            intArray[j] = random.nextInt();
        }
        return intArray;
    }

}
