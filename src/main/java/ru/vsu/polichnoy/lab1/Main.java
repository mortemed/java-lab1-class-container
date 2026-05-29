package ru.vsu.polichnoy.lab1;

/**
 * Демонстрационный класс для проверки основных операций контейнера.
 */

public class Main {

    public static void main(String[] args) {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);
        container.add(40);
        container.add(2, 30);

        System.out.println("Initial container:");
        System.out.println(container);

        System.out.println("Container size: " + container.size());
        System.out.println("Element at index 1: " + container.get(1));

        int removedByIndex = container.removeAt(0);
        System.out.println("Removed by index: " + removedByIndex);
        System.out.println("After removeAt(0): " + container);

        boolean removedByValue = container.removeValue(30);
        System.out.println("Was value 30 removed? " + removedByValue);
        System.out.println("After removeValue(30): " + container);

        System.out.println("Contains 40: " + container.contains(40));

        container.clear();
        System.out.println("After clear: " + container);
        System.out.println("Is empty: " + container.isEmpty());
    }
}