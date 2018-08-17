package pl.mateuszgorski.streams;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class NumberProcessorTest {

    private NumberProcessor numberProcessor = new NumberProcessor();

    @Test
    @Parameters(method = "linesToProcess")
    public void shouldReturnProcessedLine(String test, String expected) {
        //When
        String actual = numberProcessor.constructsResultLine(test);

        //Then
        assertThat(actual, is(expected));
    }

    public Object[] linesToProcess() {
        return new Object[]{
                new String[]{"1   2    4   6", "1+2+4+6=13"},
                new String[]{"   2  3    5   1", "2+3+5+1=11"},
                new String[]{"                     1", "1=1"},
                new String[]{"0     1     0", "0+1+0=1"}
        };
    }
}