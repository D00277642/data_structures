package b_list.ongoing_CA;

public class DynamicArrayString {
    private static final int EXPANSION_MULTIPLIER = 2;
    private int size = 0;
    private String[] data = new String[10];

    /**
     * Return the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Return the element at the specified index
     *
     * @param index the position of the element to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public String get(int index) {
        // Check that the index is valid
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is outside bounds of list");
        }
        return data[index];
    }

    /**
     * Find the position of an element in the list
     *
     * @param target the String to search for
     * @return the index of the element, or -1 if it is not found
     */
    public int indexOf(String target) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Expand the array when it's full
     */
    private void ensureCapacity() {
        if (size == data.length) {
            String[] temp = new String[data.length * EXPANSION_MULTIPLIER];
            //Copy the existing elements
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the String to add
     * @throws IllegalArgumentException if the element is null
     */
    public void add(String element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        ensureCapacity();
        data[size] = element;
        size++;
    }

    /**
     * Adds an element at a specific index, moving next elements right.
     *
     * @param element the String to insert
     * @param index the position at which to insert the element
     * @throws IllegalArgumentException if the element is null
     * @throws IndexOutOfBoundsException if the index is invalid
     */
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

    /**
     * Replace an element at a certain index.
     *
     * @param element the replacement String
     * @param index the position of the element to replace
     * @return the element that was replaced
     * @throws IllegalArgumentException if the element is null
     * @throws IndexOutOfBoundsException if the index is invalid
     */
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

    /**
     * remove an element at a certain index and return it.
     *
     * @param index the position of the element to remove
     * @return the removed element
     * @throws IndexOutOfBoundsException if the index is invalid
     */
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

    /**
     * Remove all occurrences of an element and return it.
     *
     * @param element the String to remove
     * @return the number of elements removed
     * @throws IllegalArgumentException if the element is null
     */
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

    /**
     * Takes no parameters and resets the list to it's og settings
     */
    public void clear() {
        size = 0;
        data = new String[10];
    }

    /**
     * Creates a new list and doesn't take in any parameters
     * The original list remains unchanged.
     *
     * @return a new list containing no duplicate elements
     */
    public DynamicArrayString deduplicate() {
        DynamicArrayString result = new DynamicArrayString();

        for (int i = 0; i < size; i++) {
            if (result.indexOf(data[i]) == -1) {
                result.add(data[i]);
            }
        }
        return result;
    }

    /**
     * Add all elements from the parameter list to the current list.
     *
     * @param other the list whose elements will be appended
     * @throws IllegalArgumentException if the supplied list is null
     */
    public void join(DynamicArrayString other) {
        if (other == null) {
            throw new IllegalArgumentException("List can't be null");
        }
        for (int i = 0; i < other.size(); i++) {
            add(other.get(i));
        }
    }

}