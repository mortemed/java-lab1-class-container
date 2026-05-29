package ru.vsu.polichnoy.lab1;

public class IntContainer {

    private static final int DEFAULT_CAPACITY = 10;

    private final int[] elements;
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
            throw new IllegalStateException("Container is full");
        }

        elements[size] = value;
        size++;
    }

    public int get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is out of bounds for size " + size
            );
        }
    }
}