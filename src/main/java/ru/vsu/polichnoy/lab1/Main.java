package ru.vsu.polichnoy.lab1;

public class Main {

    public static void main(String[] args) {
        IntContainer container = new IntContainer();

        container.add(10);
        container.add(20);
        container.add(30);

        System.out.println("Container size: " + container.size());
        System.out.println("First element: " + container.get(0));
        System.out.println("Second element: " + container.get(1));
        System.out.println("Third element: " + container.get(2));
    }
}