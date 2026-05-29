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
}