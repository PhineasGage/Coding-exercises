package pl.mateuszgorski.numbersFromFile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProcessorTest {

    @Mock
    private NumberProcessor numberProcessor;

    @Mock
    private FileProcessor fileProcessor;

    @InjectMocks
    private Processor processor;

    @Test
    public void shouldProcessLines() {
        //Given
        String input = "1 2 3";
        String output = "1+2+3=6";
        String filename = "fileName.txt";
        String outputFilename = "output.txt";
        when(fileProcessor.readLinesFromFile(filename)).thenReturn(Arrays.asList(input));
        when(numberProcessor.constructsResultLine(input)).thenReturn(output);

        // When
        processor.process(filename, outputFilename);

        // Then
        verify(fileProcessor).readLinesFromFile(filename);
        verify(numberProcessor).constructsResultLine(input);
        verify(fileProcessor).writeLinesToFile(Arrays.asList(output), outputFilename);
    }
}