package ru.vsu.polichnoy.lab1;

public class Main {

    public static void main(String[] args) {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);
        container.add(30);
        container.add(40);

        System.out.println("Container size before removing: " + container.size());
        System.out.println("Element at index 1 before removing: " + container.get(1));

        int removedValue = container.removeAt(1);

        System.out.println("Removed value: " + removedValue);
        System.out.println("Container size after removing: " + container.size());
        System.out.println("Element at index 1 after removing: " + container.get(1));
    }
}