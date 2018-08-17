package pl.mateuszgorski.christmas;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static pl.mateuszgorski.christmas.ChristmasTree.*;

@RunWith(JUnitParamsRunner.class)
public class ChristmasTreeTest {

    String[] testString = growChristmasTree(3);


    @Test
    @Parameters(method = "provideInputforChristmasTreeTip")
    public void createsChristmasTreeTip(int size, String expected) {
        //When
        String actual = growChristmasTree(size)[0];
        //Then
        assertThat(actual, is(expected));
    }

    private Object[] provideInputforChristmasTreeTip() {
        return new Object[][]{
                {3, "  *"},
                {5, "    *"},
                {10, "         *"}
        };
    }

    @Test
    @Parameters(method = "inputsforChristmasTreeLowestBranch")
    public void createsChristmasTreeLowestBranch(int size, String expected) {
        //When
        String actual = growChristmasTree(size)[size - 1];
        //Then
        assertThat(actual, is(expected));
    }

    private Object[] inputsforChristmasTreeLowestBranch() {
        return new Object[][]{
                {3, "*****"},
                {5, "*********"},
                {10, "*******************"}
        };
    }

    @Test
    @Parameters(method = "inputsForChristmasTreeTrunk")
    public void ChristmasTreeTrunkHasCorrectWidth(int size, String expected) {
        //When
        String actual = growChristmasTree(size)[size];
        //Then
        assertThat(countHowThick(actual), is(countHowThick(expected)));
    }

    private Object[] inputsForChristmasTreeTrunk() {
        return new Object[][]{
                {9, "*"},
                {10, "***"},
                {30, "*****"}
        };
    }

    private int countHowThick(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                score++;
            }
        }
        return score;
    }

    @Test
    @Parameters(method = "inputsForChristmasTreeTrunkHeight")
    public void ChristmasTreeTrunkHasCorrectHeight(int size, int expected) {
        //When
        int actual = growChristmasTree(size).length - size;
        //Then
        assertThat(actual, is(expected));
    }

    private Object[] inputsForChristmasTreeTrunkHeight() {
        return new Integer[][]{{9, 1}, {10, 2}, {50, 3}};
    }


}