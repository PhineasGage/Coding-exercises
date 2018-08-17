package pl.mateuszgorski.fiveSorts;

import static org.junit.Assert.*;

public class SelectionSortTest extends SortingTestBase {


    @Override
    public SortingMethod getSortingMethod() {
        return new SelectionSort();
    }
}