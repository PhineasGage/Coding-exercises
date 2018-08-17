package pl.mateuszgorski.fiveSorts;

import static org.junit.Assert.*;

public class ArraysSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new ArraysSort();
    }
}