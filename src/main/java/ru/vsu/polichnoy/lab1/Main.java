package ru.vsu.polichnoy.lab1;
import java.util.Scanner;

/**
 * Консольная программа для демонстрации работы контейнера целых чисел.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntContainer container = new IntContainer();

        boolean running = true;

        while (running) {
            printMenu();

            int command = readInt(scanner, "Выберите команду: ");

            try {
                switch (command) {
                    case 1:
                        addValue(scanner, container);
                        break;
                    case 2:
                        insertValue(scanner, container);
                        break;
                    case 3:
                        getValue(scanner, container);
                        break;
                    case 4:
                        removeByIndex(scanner, container);
                        break;
                    case 5:
                        removeByValue(scanner, container);
                        break;
                    case 6:
                        checkContains(scanner, container);
                        break;
                    case 7:
                        printContainer(container);
                        break;
                    case 8:
                        printSize(container);
                        break;
                    case 9:
                        clearContainer(container);
                        break;
                    case 0:
                        running = false;
                        System.out.println("Работа программы завершена.");
                        break;
                    default:
                        System.out.println("Неизвестная команда.");
                }
            } catch (IndexOutOfBoundsException | IllegalArgumentException exception) {
                System.out.println("Ошибка: " + exception.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("=== Контейнер целых чисел ===");
        System.out.println("1. Добавить число в конец");
        System.out.println("2. Вставить число по индексу");
        System.out.println("3. Получить число по индексу");
        System.out.println("4. Удалить число по индексу");
        System.out.println("5. Удалить число по значению");
        System.out.println("6. Проверить наличие значения");
        System.out.println("7. Вывести контейнер");
        System.out.println("8. Вывести размер контейнера");
        System.out.println("9. Очистить контейнер");
        System.out.println("0. Выйти");
    }

    private static void addValue(Scanner scanner, IntContainer container) {
        int value = readInt(scanner, "Введите значение: ");
        container.add(value);
        System.out.println("Значение добавлено.");
    }

    private static void insertValue(Scanner scanner, IntContainer container) {
        int index = readInt(scanner, "Введите индекс: ");
        int value = readInt(scanner, "Введите значение: ");

        container.add(index, value);

        System.out.println("Значение вставлено.");
    }

    private static void getValue(Scanner scanner, IntContainer container) {
        int index = readInt(scanner, "Введите индекс: ");

        int value = container.get(index);

        System.out.println("Значение по индексу " + index + ": " + value);
    }

    private static void removeByIndex(Scanner scanner, IntContainer container) {
        int index = readInt(scanner, "Введите индекс: ");

        int removedValue = container.removeAt(index);

        System.out.println("Удалённое значение: " + removedValue);
    }

    private static void removeByValue(Scanner scanner, IntContainer container) {
        int value = readInt(scanner, "Введите значение: ");

        boolean removed = container.removeValue(value);

        if (removed) {
            System.out.println("Значение удалено.");
        } else {
            System.out.println("Такого значения в контейнере нет.");
        }
    }

    private static void checkContains(Scanner scanner, IntContainer container) {
        int value = readInt(scanner, "Введите значение: ");

        if (container.contains(value)) {
            System.out.println("Контейнер содержит значение " + value + ".");
        } else {
            System.out.println("Контейнер не содержит значение " + value + ".");
        }
    }

    private static void printContainer(IntContainer container) {
        System.out.println("Контейнер: " + container);
    }

    private static void printSize(IntContainer container) {
        System.out.println("Размер контейнера: " + container.size());
    }

    private static void clearContainer(IntContainer container) {
        container.clear();
        System.out.println("Контейнер очищен.");
    }

    private static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);

            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Ошибка: нужно ввести целое число.");
            }
        }
    }
}