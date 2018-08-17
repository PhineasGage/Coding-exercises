package pl.mateuszgorski.streams;

import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FileProcessorTest {

    private FileProcessor fileProcessor = new FileProcessor();

    @Test
    public void shoudlReadLinesFromFile() {
        //Given
        List<String> expected = Arrays.asList(
                "1             ",
                "1 6      4  2     1",
                "9 8      7         3",
                "1239 82 9234"
        );

        //When
        List<String> actual = fileProcessor.readLinesFromFile("test.txt");

        //Then
        assertThat(actual, is(expected));
    }
}