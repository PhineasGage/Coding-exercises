package pl.mateuszgorski.myOwnArrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest extends TestBase {

    @Override
    public <T> List<T> getList() {
        return new ArrayList<>();
    }
}



