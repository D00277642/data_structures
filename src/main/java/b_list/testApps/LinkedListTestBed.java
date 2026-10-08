package b_list.testApps;

import b_list.utils.LinkedList;

public class LinkedListTestBed {
    static void main(String[]) {
        LinkedList myList = new LinkedList();

        for (int i = 0; i < 5; i++) {
            myList.add("Item " + (i+1));

        }
    }
}
