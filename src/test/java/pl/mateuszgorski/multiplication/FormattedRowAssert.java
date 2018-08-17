package pl.mateuszgorski.multiplication;

import org.fest.assertions.*;

public class FormattedRowAssert extends GenericAssert<FormattedRowAssert, String[]> {


    public FormattedRowAssert(String[] actual) {
        super(FormattedRowAssert.class, actual);
    }

    public static FormattedRowAssert assertThat(String actual[]) {
        return new FormattedRowAssert(actual);
    }

    public FormattedRowAssert isSameRowAs(String[] expected) {
        isNotNull();
        Assertions.assertThat(actual).isEqualTo(addClassFormattingToString(expected));
        return this;
    }


    public String[] addClassFormattingToString(String[] expected) {
        for (int i = 0; i < expected.length; i++) {
            expected[i] = String.format("%7s", expected[i]);
        }
        return expected;
    }

}




