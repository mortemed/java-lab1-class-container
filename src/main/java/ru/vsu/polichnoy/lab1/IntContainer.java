package ru.vsu.polichnoy.lab1;

public class IntContainer {

    private static final int DEFAULT_CAPACITY = 10;

    private int[] elements;
    private int size;

    public IntContainer() {
        this(DEFAULT_CAPACITY);
    }

    public IntContainer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        elements = new int[capacity];
        size = 0;
    }

    public void add(int value) {
        if (size == elements.length) {
            grow();
        }

        elements[size] = value;
        size++;
    }

    public int get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public int removeAt(int index) {
        checkIndex(index);

        int removedValue = elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;

        return removedValue;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void grow() {
        int newCapacity = elements.length * 2;
        int[] newElements = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is out of bounds for size " + size
            );
        }
    }
}