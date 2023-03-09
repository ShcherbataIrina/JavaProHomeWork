package ua.ithillel.lesson13;

import java.util.Objects;

public class HillelArrayList<T> implements GenericHillelList<T> {
    private T[] array;
    public HillelArrayList() {
        array = (T[]) new Object[0];
    }

    public HillelArrayList(T[] array) {
        this.array =  (T[]) new Object[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    @Override
    public void add(T item) {
        T[] newArray =(T[]) new Object[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = item;
        array = newArray;

    }

    @Override
    public T remove(int index) {
        T deleteWord = array[index];
        T[] newArray = (T[]) new Object[array.length - 1];
        if (index > 0) {
            System.arraycopy(array, 0, newArray, 0, index);
        }
        System.arraycopy(array, index + 1, newArray, index, array.length - 1 - index);

        array = newArray;
        return deleteWord;
        // return null;
    }

    @Override
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(T item) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], item)) {
                index = i;
                break;
            }
            //else   index=-1;
        }
        return index;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public Object[] getAll() {
        return array;
    }

}
