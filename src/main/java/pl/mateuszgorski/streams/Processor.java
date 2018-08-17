package pl.mateuszgorski.streams;

import java.util.List;
import java.util.stream.Collectors;

public class Processor {

    private NumberProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public Processor(NumberProcessor numbersProcessor, FileProcessor fileProcessor) {
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(String fileName, String resultFileName) {
        List<String> resultLines = fileProcessor
                .readLinesFromFile(fileName)
                .stream()
                .map(numbersProcessor::constructsResultLine)
                .collect(Collectors.toList());
        fileProcessor.writeLinesToFile(resultLines, resultFileName);
    }

    public static void main(String[] args) {
        NumberProcessor numbersProcessor = new NumberProcessor();
        FileProcessor fileProcessor = new FileProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);
        processor.process("1000.txt", "result1000.txt");
    }
}