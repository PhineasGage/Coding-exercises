package pl.mateuszgorski.fiveSorts;

import static org.junit.Assert.*;

public class QuickSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new QuickSort();
    }
}