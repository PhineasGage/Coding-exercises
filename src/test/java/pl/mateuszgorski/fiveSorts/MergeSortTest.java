package pl.mateuszgorski.fiveSorts;

import static org.junit.Assert.*;

public class MergeSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new MergeSort();
    }
}