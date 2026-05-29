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

    public void add(int index, int value) {
        checkPositionIndex(index);

        if (size == elements.length) {
            grow();
        }

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = value;
        size++;
    }

    public int get(int index) {
        checkElementIndex(index);
        return elements[index];
    }

    public int removeAt(int index) {
        checkElementIndex(index);

        int removedValue = elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;

        return removedValue;
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public boolean removeValue(int value) {
        int index = indexOf(value);

        if (index == -1) {
            return false;
        }

        removeAt(index);
        return true;
    }

    public void clear() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int[] toArray() {
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = elements[i];
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("[");

        for (int i = 0; i < size; i++) {
            builder.append(elements[i]);

            if (i < size - 1) {
                builder.append(", ");
            }
        }

        builder.append("]");

        return builder.toString();
    }

    private void grow() {
        int newCapacity = elements.length * 2;
        int[] newElements = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is out of bounds for size " + size
            );
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is out of bounds for insertion into size " + size
            );
        }
    }
}