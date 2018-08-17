package pl.mateuszgorski.myOwnArrayList;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public abstract class TestBase {
    public abstract <T> List<T> getList();

    @Test
    @Parameters(method = "elementsToAdd")
    public <T> void shouldAddElement(T t) {
        //Given
        List<T> arrayList = getList();

        //When
        arrayList.add(t);

        //Then
        assertTrue(arrayList.contains(t));
    }

    public Object[] elementsToAdd() {
        return new Object[][]{{1L}, {"testString"}};
    }


    @Test
    @Parameters(method = "elementsForSizeAssert")
    public <T> void shouldReturnCorrectSize(T t, T s) {
        //Given
        List<T> arrayList = getList();
        arrayList.add(t);
        arrayList.add(s);
        int expected = 2;

        //When
        int actual = arrayList.size();

        //Then
        assertThat(actual, is(expected));
    }

    public Object[] elementsForSizeAssert() {
        return new Object[][]{{1L, 2L}, {"testString", "testStringTwo"}};
    }

    @Test
    @Parameters(method = "elementsForEmpyListCheck")
    public <T> void shouldCheckIfEmpty(T t) {
        //When
        List<T> arrayList = getList();
        boolean actual = arrayList.isEmpty();

        //Then
        assertTrue(actual);
    }

    public Object[] elementsForEmpyListCheck() {
        return new Object[][]{{1L}, {"testString"}};
    }

    @Test
    @Parameters(method = "elementsForContainsCheck")
    public <T> void shouldCheckForElement(T t, T s) {
        //Given
        List<T> arrayList = getList();
        arrayList.add(t);

        //Then
        assertTrue(arrayList.contains(t));
        assertTrue(!arrayList.contains(s));
    }

    public Object[] elementsForContainsCheck() {
        return new Object[][]{{1L, 2L}, {"testString", "testStringTwo"}};
    }

    @Test
    @Parameters(method = "elementsForContainsCheck")
    public <T> void shouldConvertToArray(T t, T s) {
        //Given
        List<T> arrayList = getList();
        T[] expected = (T[]) new Object[2];
        expected[0] = t;
        expected[1] = s;
        arrayList.add(t);
        arrayList.add(s);

        //When
        T[] longarray = (T[]) new Object[2];
        T[] actual = arrayList.toArray(longarray);

        //Then
        assertThat(actual, is(expected));
    }

    public Object[] elementsForArrayConversion() {
        return new Object[][]{{1L, 2L}, {"testString", "testStringTwo"}};
    }


    @Test
    @Parameters(method = "elementsForCollectionContainsCheck")
    public <T> void shouldCheckIfContainsAllElementsofOtherCollection(T t, T s, T r) {
        //Given
        List<T> arrayList = getList();
        T[] expectedArray = (T[]) new Object[]{t, s};
        List<T> expected = Arrays.asList(expectedArray);
        arrayList.add(t);
        arrayList.add(s);
        arrayList.add(r);

        //Then
        assertTrue(arrayList.containsAll(expected));
    }

    public Object[] elementsForCollectionContainsCheck() {
        return new Object[][]{{1L, 2L, 3L}, {"testString", "testStringTwo", "testString three"}};
    }

    @Test
    @Parameters(method = "elementsToGet")
    public <T> void getsElement(T t) {
        //Given
        List<T> arrayList = getList();
        T expected = t;
        arrayList.add(expected);

        //When
        T actual = arrayList.get(0);

        //Then
        assertThat(actual, is(expected));
    }

    public Object[] elementsToGet() {
        return new Object[][]{{1L}, {"testString"}};
    }

    @Test
    @Parameters(method = "elementsForRemovalByIndex")
    public <T> void removesElementbyIndex(T t, T s) {
        //Given
        List<T> arrayList = getList();
        arrayList.add(t);
        arrayList.add(s);

        //When
        arrayList.remove(0);
        T actual = arrayList.get(0);

        //Then
        assertThat(actual, is(s));
    }

    public Object[] elementsForRemovalByIndex() {
        return new Object[][]{{1L, 2L}, {"testString", "testStringTwo"}};
    }

    @Test
    @Parameters(method = "elementsForRemovalByObject")
    public <T> void removesElementByObject(T t, T s) {
        //Given
        List<T> arrayList = getList();
        arrayList.add(t);
        arrayList.add(s);

        //When
        arrayList.remove(t);

        //Then
        assertThat(arrayList.indexOf(s), is(0));
    }

    public Object[] elementsForRemovalByObject() {
        return new Object[][]{{1L, 2L}, {"testString", "testStringTwo"}};
    }

    @Test
    @Parameters(method = "elementsForIndexReturn")
    public <T> void returnsIndexOfElement(T t, T s) {
        //Given
        List<T> arrayList = getList();
        arrayList.add(t);
        arrayList.add(s);

        //When
        int actual = arrayList.indexOf(s);

        //Then
        assertThat(actual, is(1));
    }

    @Test
    @Parameters(method = "elementsForIndexReturn")
    public <T> void returnsLastIndexOfElement(T t, T s) {
        //Given
        List<T> arrayList = getList();
        arrayList.add(t);
        arrayList.add(s);
        arrayList.add(t);

        //When
        int actual = arrayList.lastIndexOf(t);

        //Then
        assertThat(actual, is(2));
    }

    public Object[] elementsForIndexReturn() {
        return new Object[][]{{1L, 2L}, {"testString", "testStringTwo"}};
    }

    @Test
    @Parameters(method = "elementsForIndexSet")
    public <T> void setElementAtIndex(T t, T s, T r) {
        //Given
        List<T> arrayList = getList();
        arrayList.add(t);
        arrayList.add(s);

        //When
        arrayList.set(1, r);
        T actual = arrayList.get(1);

        //Then
        assertThat(actual, is(r));
    }

    public Object[] elementsForIndexSet() {
        return new Object[][]{{1L, 2L, 3L}, {"testString", "testStringTwo", "testStringThree"}};
    }

    @Test
    @Parameters(method = "elementsForSublist")
    public <T> void returnsSublist(T p, T r, T s, T t) {
        //Given
        List<T> arrayList = getList();
        arrayList.add(p);
        arrayList.add(r);
        arrayList.add(s);
        arrayList.add(t);

        //When
        List<T> sublist = arrayList.subList(1, 3);

        //Then
        assertThat(sublist.get(0), is(r));
        assertThat(sublist.get(1), is(s));
    }

    public Object[] elementsForSublist() {
        return new Object[][]{{1L, 2L, 3L, 4L}, {"testString", "testStringTwo", "testStringthree", "testStringFour"}};
    }
}