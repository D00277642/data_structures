package b_list.utils;

import b_list.utils.DynamicArray;

public class DynamicArrayTestBed {

    public static void main(String[] args) {

        DynamicArray myList = new DynamicArray();

        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(20);
        myList.add(40);

        System.out.println("Last index of 20: " + myList.lastIndexOf(20));
        System.out.println("Index of 20: " + myList.indexOf(20));
    }
}