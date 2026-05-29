package ru.vsu.polichnoy.lab1;

/**
 * Контейнер для хранения целых чисел.
 * <p>
 * Контейнер реализован на основе динамического массива.
 * Встроенные коллекции Java не используются.
 */
public class IntContainer {

    private static final int DEFAULT_CAPACITY = 10;

    private int[] elements;
    private int size;

    /**
     * Создаёт пустой контейнер со стандартной начальной вместимостью.
     */
    public IntContainer() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Создаёт пустой контейнер с указанной начальной вместимостью.
     *
     * @param capacity начальная вместимость внутреннего массива
     * @throws IllegalArgumentException если вместимость меньше или равна нулю
     */
    public IntContainer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        elements = new int[capacity];
        size = 0;
    }

    /**
     * Добавляет значение в конец контейнера.
     *
     * @param value добавляемое значение
     */
    public void add(int value) {
        if (size == elements.length) {
            grow();
        }

        elements[size] = value;
        size++;
    }

    /**
     * Вставляет значение в указанную позицию.
     * <p>
     * Все элементы, начиная с указанного индекса, сдвигаются вправо.
     *
     * @param index позиция для вставки
     * @param value добавляемое значение
     * @throws IndexOutOfBoundsException если индекс некорректен
     */
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

    /**
     * Возвращает значение по индексу без удаления из контейнера.
     *
     * @param index индекс элемента
     * @return значение, расположенное по указанному индексу
     * @throws IndexOutOfBoundsException если индекс некорректен
     */
    public int get(int index) {
        checkElementIndex(index);
        return elements[index];
    }

    /**
     * Удаляет элемент по индексу и возвращает удалённое значение.
     * <p>
     * После удаления элементы, расположенные справа от удалённого,
     * сдвигаются влево.
     *
     * @param index индекс удаляемого элемента
     * @return удалённое значение
     * @throws IndexOutOfBoundsException если индекс некорректен
     */
    public int removeAt(int index) {
        checkElementIndex(index);

        int removedValue = elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        size--;

        return removedValue;
    }

    /**
     * Возвращает индекс первого вхождения указанного значения.
     *
     * @param value искомое значение
     * @return индекс найденного значения или -1, если значение не найдено
     */
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Проверяет, содержится ли указанное значение в контейнере.
     *
     * @param value значение для проверки
     * @return true, если значение найдено, иначе false
     */
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    /**
     * Удаляет первое вхождение указанного значения.
     *
     * @param value удаляемое значение
     * @return true, если значение было найдено и удалено, иначе false
     */
    public boolean removeValue(int value) {
        int index = indexOf(value);

        if (index == -1) {
            return false;
        }

        removeAt(index);
        return true;
    }

    /**
     * Удаляет все элементы из контейнера.
     */
    public void clear() {
        size = 0;
    }

    /**
     * Возвращает количество элементов, хранящихся в контейнере.
     *
     * @return текущее количество элементов
     */
    public int size() {
        return size;
    }

    /**
     * Проверяет, является ли контейнер пустым.
     *
     * @return true, если контейнер пуст, иначе false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Возвращает копию элементов контейнера в виде массива.
     * <p>
     * Возвращается именно копия, а не внутренний массив контейнера,
     * чтобы внешний код не мог изменить внутреннее состояние объекта.
     *
     * @return массив со всеми значениями, хранящимися в контейнере
     */
    public int[] toArray() {
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = elements[i];
        }

        return result;
    }

    /**
     * Возвращает строковое представление контейнера.
     *
     * @return строка со всеми элементами контейнера
     */
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
    /**
     * Увеличивает размер массива вдвое, т.е. точнее:
     * <p>
     * Ссылка elements перепривязывается к новому массиву. Старый массив удаляется сборщиком мусора Java.
     */
    private void grow() {
        int newCapacity = elements.length * 2;
        int[] newElements = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }

        elements = newElements;
    }
    /**
     * Проверка на выход за границы индексов для удаления
     */
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is out of bounds for size " + size
            );
        }
    }
    /**
     * Проверка на выход за границы индексов для вставки
     */
    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is out of bounds for insertion into size " + size
            );
        }
    }
}