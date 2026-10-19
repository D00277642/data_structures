package b_list.ongoing_CA;

public class DynamicArrayString {
    private static final int EXPANSION_MULTIPLIER = 2;
    private int size = 0;
    private String[] data = new String[10];

    //Return the number of elements in the list.
    public int size() {
        return size;
    }

     //return the element at the specified index
    public String get(int index) {
        // Check that the index is valid
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is outside bounds of list");
        }
        return data[index];
    }

    //find the position of an element in the list
    public int indexOf(String target) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    //Expand the array when it's full
    private void ensureCapacity() {
        if (size == data.length) {
            String[] temp = new String[data.length * EXPANSION_MULTIPLIER];
            //Copy the existing elements
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
    }

    //Adds an element to the end of the list.
    public void add(String element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        ensureCapacity();
        data[size] = element;
        size++;
    }

    //add an element at a specific index
    public void add(String element, int index) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is outside bounds of list");
        }

        ensureCapacity();

        //Move elements to make space
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        size++;
    }

    //Replace an element at a certain index
    public String set(String element, int index) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is outside bounds of list");
        }
        String oldElement = data[index];
        data[index] = element;

        return oldElement;
    }

    //remove an element at a certain index and return it
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is outside bounds of list");
        }

        String removedElement = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        return removedElement;
    }

    //Remove all occurrences of an element and return it.
    public int removeAll(String element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }

        int removedCount = 0;
        int i = 0;

        while (i < size) {
            if (data[i].equals(element)) {
                remove(i);
                removedCount++;
            } else {
                i++;
            }
        }
        return removedCount;
    }

    //takes no parameters and resets the list to it's og settings
    public void clear() {
        size = 0;
        data = new String[10];
    }

    //Creates a new list without duplicating elements and doesn't take in any parameters
    public DynamicArrayString deduplicate() {
        DynamicArrayString result = new DynamicArrayString();

        for (int i = 0; i < size; i++) {
            if (result.indexOf(data[i]) == -1) {
                result.add(data[i]);
            }
        }
        return result;
    }

}