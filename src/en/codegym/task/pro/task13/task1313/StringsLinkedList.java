package en.codegym.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public StringsLinkedList() {
        first.next = last;
        last.prev = first;
    }

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
//        1) Instantiate a new node object.
        Node node = new Node();
//        2) Store the passed value to the new node's value.
        node.value = value;
//        3) Create a temporary node variable and assign a reference to the last node's prev value.
        Node temp = last.prev;
//        4) Assign the new node object to the temporary node's next value.
        temp.next = node;
//        5) Assign the new node object to the last node's prev value.
        last.prev = node;
//        6) Assign the temporary node object to the new node's prev value.
        node.prev = temp;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}