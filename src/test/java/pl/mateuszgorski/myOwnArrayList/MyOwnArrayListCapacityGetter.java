package pl.mateuszgorski.myOwnArrayList;

import java.lang.reflect.Field;

public class MyOwnArrayListCapacityGetter {

    private static final Field field;

    static {
        try {
            field = MyOwnArrayList.class.getDeclaredField("internalArray");
            field.setAccessible(true);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <E> int getArrayListCapacity(MyOwnArrayList<E> arrayList) {
        try {
            final E[] elementData = (E[]) field.get(arrayList);
            return elementData.length;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}