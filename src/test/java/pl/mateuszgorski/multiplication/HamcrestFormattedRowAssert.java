package pl.mateuszgorski.multiplication;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class HamcrestFormattedRowAssert extends TypeSafeMatcher<String[]> {

    public static Matcher<String[]> isSameRowAs(String[] expected) {
        return new HamcrestFormattedRowAssert();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("String formatting from Class added to inputs");
    }

    @Override
    protected boolean matchesSafely(String[] expected) {
        addClassFormattingToString(expected);
        return true;
    }

    public String[] addClassFormattingToString(String[] expected) {
        for (int i = 0; i < expected.length; i++) {
            expected[i] = String.format("%7s", expected[i]);
        }
        return expected;
    }
}


