package lesson_2.task_2;

import java.util.Arrays;

public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 16;

    private Object[] elements;
    private int size;
    private int index;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(T value) {
        if (index == elements.length)
            growArray();
        elements[index] = value;
        index++;
        size++;
    }

    private void growArray() {
        Object[] newArray = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, index - 1);
        elements = newArray;
    }

    public Object get(int index) {
        checkIndex(index);
        return elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.index)
            throw new IllegalArgumentException();
    }

    public void set(int index, T value) {
        checkIndex(index);
        elements[index] = value;
    }

    public int size() {
        return size;
    }

    public Object indexOf(T value) {
        int result = -1;
        for (int i = 0; i < index; i++) {
            if (elements[i] == value) {
                result = i;
                break;
            }
        }
        return result;
    }

    public boolean add(int index, T value) {
        checkIndex(index);
        if (index == elements.length)
            growArray();

        System.arraycopy(elements, index, elements, index + 1, this.index - index);
        elements[index] = value;
        this.index++;
        size++;

        return true;
    }

    public boolean remove(int index) {
        checkIndex(index);
        System.arraycopy(elements, index + 1, elements, index, this.index - index);
        size--;
        this.index--;

        return true;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                ", index=" + index +
                '}';
    }
}
