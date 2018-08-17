package pl.mateuszgorski.numbersFromFile;

import java.util.ArrayList;
import java.util.List;

public class Processor {

    private NumberProcessor numbersProcessor;
    private FileProcessor fileProcessor;

    public Processor(NumberProcessor numbersProcessor, FileProcessor fileProcessor) {
        this.numbersProcessor = numbersProcessor;
        this.fileProcessor = fileProcessor;
    }

    public void process(String fileName, String resultFileName) {
        List<String> linesFromFile = fileProcessor.readLinesFromFile(fileName);
        List<String> resultLines = new ArrayList<>();
        for (String line : linesFromFile) {
            resultLines.add(numbersProcessor.constructsResultLine(line));
        }
        fileProcessor.writeLinesToFile(resultLines, resultFileName);
    }

    public static void main(String[] args) {
        NumberProcessor numbersProcessor = new NumberProcessor();
        FileProcessor fileProcessor = new FileProcessor();
        Processor processor = new Processor(numbersProcessor, fileProcessor);
        processor.process("1000.txt", "result1000.txt");
    }
}