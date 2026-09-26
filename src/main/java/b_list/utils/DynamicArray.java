package b_list.utils;

public class DynamicArray {
    private int size = 0;
    private int[] data = new int[10];

    public void add(int value) {
        data[size] = value;
        size++;
    }

    public int get(int index) {
        return data[index];
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                return i;
            }
        }

        return -1;
    }
}
