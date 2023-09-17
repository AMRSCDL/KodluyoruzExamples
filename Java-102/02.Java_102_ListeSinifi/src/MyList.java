import java.util.Arrays;

public class MyList<T> {
    private T[] array;
    private int size;
    private int capacity;

    public MyList() {
        this.capacity = 10;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T data) {
        if (size == capacity) {
            capacity *= 2;
            T[] newArray = (T[]) new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }

        array[size] = data;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T removedData = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return removedData;
    }

    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            return;
        }
        array[index] = data;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i]);
            if (i < size - 1) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T[] toArray() {
        return Arrays.copyOf(array, size);
    }

    public void clear() {
        capacity = 10;
        array = (T[]) new Object[capacity];
        size = 0;
    }

    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || finish >= size || start > finish) {
            return null;
        }

        MyList<T> subList = new MyList<>();
        for (int i = start; i <= finish; i++) {
            subList.add(array[i]);
        }
        return subList;
    }

    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }
}