package ru.vsu.polichnoy.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntContainerTest {

    @Test
    void newContainerShouldBeEmpty() {
        IntContainer container = new IntContainer();

        assertEquals(0, container.size());
        assertTrue(container.isEmpty());
    }

    @Test
    void addShouldStoreValuesInInsertionOrder() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);
        container.add(30);

        assertEquals(3, container.size());
        assertFalse(container.isEmpty());

        assertEquals(10, container.get(0));
        assertEquals(20, container.get(1));
        assertEquals(30, container.get(2));
    }

    @Test
    void constructorShouldRejectNonPositiveCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new IntContainer(0));
        assertThrows(IllegalArgumentException.class, () -> new IntContainer(-5));
    }

    @Test
    void getShouldRejectInvalidIndex() {
        IntContainer container = new IntContainer();

        container.add(10);

        assertThrows(IndexOutOfBoundsException.class, () -> container.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> container.get(1));
    }

    @Test
    void addShouldGrowContainerWhenCapacityIsExceeded() {
        IntContainer container = new IntContainer(2);

        container.add(10);
        container.add(20);
        container.add(30);

        assertEquals(3, container.size());

        assertEquals(10, container.get(0));
        assertEquals(20, container.get(1));
        assertEquals(30, container.get(2));
    }

    @Test
    void removeAtShouldRemoveElementFromMiddle() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);
        container.add(30);
        container.add(40);

        int removedValue = container.removeAt(1);

        assertEquals(20, removedValue);
        assertEquals(3, container.size());

        assertEquals(10, container.get(0));
        assertEquals(30, container.get(1));
        assertEquals(40, container.get(2));
    }

    @Test
    void removeAtShouldRemoveFirstElement() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);
        container.add(30);

        int removedValue = container.removeAt(0);

        assertEquals(10, removedValue);
        assertEquals(2, container.size());

        assertEquals(20, container.get(0));
        assertEquals(30, container.get(1));
    }

    @Test
    void removeAtShouldRemoveLastElement() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);
        container.add(30);

        int removedValue = container.removeAt(2);

        assertEquals(30, removedValue);
        assertEquals(2, container.size());

        assertEquals(10, container.get(0));
        assertEquals(20, container.get(1));
    }

    @Test
    void removeAtShouldRejectInvalidIndex() {
        IntContainer container = new IntContainer();

        container.add(10);

        assertThrows(IndexOutOfBoundsException.class, () -> container.removeAt(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> container.removeAt(1));
    }

    @Test
    void addByIndexShouldInsertValueIntoMiddle() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(30);
        container.add(40);

        container.add(1, 20);

        assertArrayEquals(new int[]{10, 20, 30, 40}, container.toArray());
    }

    @Test
    void addByIndexShouldInsertValueAtBeginning() {
        IntContainer container = new IntContainer();

        container.add(20);
        container.add(30);

        container.add(0, 10);

        assertArrayEquals(new int[]{10, 20, 30}, container.toArray());
    }

    @Test
    void addByIndexShouldInsertValueAtEnd() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);

        container.add(2, 30);

        assertArrayEquals(new int[]{10, 20, 30}, container.toArray());
    }

    @Test
    void addByIndexShouldRejectInvalidPosition() {
        IntContainer container = new IntContainer();

        container.add(10);

        assertThrows(IndexOutOfBoundsException.class, () -> container.add(-1, 20));
        assertThrows(IndexOutOfBoundsException.class, () -> container.add(2, 20));
    }

    @Test
    void indexOfShouldReturnFirstMatchingIndex() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);
        container.add(20);
        container.add(30);

        assertEquals(1, container.indexOf(20));
        assertEquals(-1, container.indexOf(99));
    }

    @Test
    void containsShouldCheckValuePresence() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);

        assertTrue(container.contains(10));
        assertTrue(container.contains(20));
        assertFalse(container.contains(99));
    }

    @Test
    void removeValueShouldRemoveFirstOccurrence() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);
        container.add(20);
        container.add(30);

        boolean result = container.removeValue(20);

        assertTrue(result);
        assertArrayEquals(new int[]{10, 20, 30}, container.toArray());
    }

    @Test
    void removeValueShouldReturnFalseIfValueDoesNotExist() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);

        boolean result = container.removeValue(99);

        assertFalse(result);
        assertArrayEquals(new int[]{10, 20}, container.toArray());
    }

    @Test
    void clearShouldRemoveAllElements() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);

        container.clear();

        assertEquals(0, container.size());
        assertTrue(container.isEmpty());
    }

    @Test
    void toArrayShouldReturnCopyOfStoredElements() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);

        int[] array = container.toArray();
        array[0] = 999;

        assertEquals(10, container.get(0));
    }

    @Test
    void toStringShouldReturnReadableRepresentation() {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);
        container.add(30);

        assertEquals("[10, 20, 30]", container.toString());
    }
}