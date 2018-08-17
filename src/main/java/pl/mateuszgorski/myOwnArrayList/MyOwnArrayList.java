package pl.mateuszgorski.myOwnArrayList;

import java.util.*;

public class MyOwnArrayList<T> implements List<T> {
    private Object[] internalArray = new Object[10];
    private int firstAvailableIndex = 0;

    private void extendInternalArrayIfRequired() {
        if (firstAvailableIndex >= internalArray.length - 1) {
            int newSize = internalArray.length * 2;
            internalArray = Arrays.copyOf(internalArray, newSize);
        }
    }

    private void shrinkInternalArrayIfRequired() {
        if (firstAvailableIndex <= 0.25 * internalArray.length) {
            int newSize = internalArray.length / 2;
            internalArray = Arrays.copyOf(internalArray, newSize);
        }
    }

    private boolean isValidIndex(int index) {
        return index >= firstAvailableIndex || index < 0;
    }

    @Override
    public T get(int index) {
        if (isValidIndex(index)) {
            throw new IndexOutOfBoundsException("element is out of scope, first available Index was " + firstAvailableIndex + " while input index was " + index);
        }
        return (T) internalArray[index];
    }

    @Override
    public boolean add(T element) {
        extendInternalArrayIfRequired();
        internalArray[firstAvailableIndex] = element;
        firstAvailableIndex++;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index > firstAvailableIndex || index < 0) {
            throw new IndexOutOfBoundsException("element is out of scope, first available Index was " + firstAvailableIndex + " while input index was " + index);
        }
        if (index > firstAvailableIndex) {
            firstAvailableIndex = index;
        }
        extendInternalArrayIfRequired();
        for (int i = firstAvailableIndex; i >= index; i--) {
            internalArray[i + 1] = internalArray[i];
        }
        internalArray[index] = element;
    }

    @Override
    public int indexOf(Object element) {
        int maxIndex = -1;
        for (int i = 0; i < firstAvailableIndex; i++) {
            if (element == internalArray[i] || element.equals(internalArray[i])) {
                return i;
            }
        }
        return maxIndex;
    }

    @Override
    public int lastIndexOf(Object element) {
        int maxIndex = -1;
        for (int i = 0; i < firstAvailableIndex; i++) {
            if (element == internalArray[i] || element.equals(internalArray[i])) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @Override
    public T set(int index, T element) {
        if (isValidIndex(index)) {
            throw new IndexOutOfBoundsException("index is out of scope");
        }
        T oldValue = (T) internalArray[index];
        internalArray[index] = element;
        return oldValue;
    }

    @Override
    public int size() {
        return firstAvailableIndex;
    }

    @Override
    public boolean isEmpty() {
        return firstAvailableIndex == 0;
    }

    @Override
    public boolean remove(Object element) {

        if (contains(element)) {
            for (int i = indexOf(element); i < firstAvailableIndex; i++) {
                internalArray[i] = internalArray[i + 1];
            }
            --firstAvailableIndex;
            internalArray[firstAvailableIndex] = null;
            shrinkInternalArrayIfRequired();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T remove(int index) {
        if (isValidIndex(index)) {
            throw new IndexOutOfBoundsException("element is out of scope, first available Index was " + firstAvailableIndex + " while input index was " + index);
        }
        T oldvalue = (T) internalArray[index];
        for (int i = index; i < firstAvailableIndex; i++) {
            internalArray[i] = internalArray[i + 1];
        }

        --firstAvailableIndex;
        internalArray[firstAvailableIndex] = null;
        shrinkInternalArrayIfRequired();
        return oldvalue;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length >= firstAvailableIndex) {
            for (int i = 0; i < firstAvailableIndex; i++) {
                a[i] = (T) internalArray[i];
            }
            return a;
        } else {
            return (T[]) Arrays.copyOf(internalArray, firstAvailableIndex, a.getClass());
        }
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(internalArray, firstAvailableIndex);
    }

    @Override
    public boolean contains(Object element) {
        if (element == null) {
            throw new NullPointerException("element is null");
        }
        for (int i = 0; i <= firstAvailableIndex; i++) {
            if (element == internalArray[i] || element.equals(internalArray[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean isElementPresent = false;
        for (Object element : c) {
            for (int i = 0; i <= firstAvailableIndex; i++) {
                if (element == internalArray[i] || element.equals(internalArray[i])) {
                    isElementPresent = true;
                }
            }
            if (!isElementPresent) {
                return false;
            }
            isElementPresent = false;
        }
        return true;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        T[] tempArray = (T[]) Arrays.copyOfRange(internalArray, fromIndex, toIndex + 1);
        List<T> myOwnSubList = new MyOwnArrayList<>();
        for (T element : tempArray) {
            myOwnSubList.add(element);
        }
        return myOwnSubList;
    }

//**NOT IMPLEMENTED**//

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new NotImplementedYetException("Not implemented yet!");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new NotImplementedYetException("Not implemented yet!");
    }

    @Override
    public void clear() {
        throw new NotImplementedYetException("Not implemented yet!");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new NotImplementedYetException("Not implemented yet!");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new NotImplementedYetException("Not implemented yet!");
    }
}