package pl.mateuszgorski.pascal;

import org.fest.assertions.*;

public class FormattedRowsAssert extends GenericAssert<FormattedRowsAssert, String> {
    public FormattedRowsAssert(String actual) {
        super(FormattedRowsAssert.class, actual);
    }

    public static FormattedRowsAssert assertThat(String actual) {
        return new FormattedRowsAssert(actual);
    }

    public FormattedRowsAssert isSameRowAs(double[] expected) {
        isNotNull();
        String errorMessage = String.format(
                "Expected row to be <%s> but was <%s>",
                expected, actual);
        Assertions.assertThat(actual)
                .overridingErrorMessage(errorMessage)
                .isEqualTo(addClassFormattingToString(expected));
        return this;
    }

    public String addClassFormattingToString(double[] array) {
        String expected = "";
        for (double i : array) {
            expected += String.format("%5.0f%5s", i, " ");
        }
        return expected;
    }
}