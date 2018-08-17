package pl.mateuszgorski.myOwnArrayList;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class MyOwnArrayListTest extends TestBase {

    @Override
    public <T> List<T> getList() {
        return new MyOwnArrayList<>();
    }

    @Test
    public void shouldIncreaseMyOwnArrayListCapacity() {
        //given
        MyOwnArrayList<Integer> capacityTest = new MyOwnArrayList<>();

        //When
        for (int i = 0; i < 100; i++) {
            capacityTest.add(i);
        }
        int actualCapacity = MyOwnArrayListCapacityGetter.getArrayListCapacity(capacityTest);

        //Then
        assertThat(actualCapacity, is(160));
    }

    @Test
    public void shouldDecreaseMyOwnArrayListCapacity() {
        //given
        MyOwnArrayList<Integer> capacityTest = new MyOwnArrayList<>();

        //When
        for (int i = 0; i <= 100; i++) {
            capacityTest.add(i);
        }
        for (int i = 100; i >= 40; i--) {
            capacityTest.remove(i);
        }
        int actualCapacity = MyOwnArrayListCapacityGetter.getArrayListCapacity(capacityTest);

        //Then
        assertThat(actualCapacity, is(80));
    }
}