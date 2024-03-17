package org.example.collection;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MyCollection {
    private Node head;
    private int _size = 0;

    public void add(int index, int value) {
        if (index < 0 || index > _size) {
            throw new IndexOutOfBoundsException("There is no element with index " + index + " in collection");
        }

        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; ++i) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        ++_size;
    }

    public void push(int value) {
        add(_size, value);
    }

    public int getAt(int index) {
        Node current = head;
        for (int i = 0; i < index; ++i) {
            if (current == null) {
                throw new IndexOutOfBoundsException("There is no element with index " + index + " in collection");
            }
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("There is no element with index " + index + " in collection");
        }
        return current.data;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= _size) {
            throw new IndexOutOfBoundsException("There is no element with index " + index + " in collection");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; ++i) {
                if (current == null || current.next == null) {
                    throw new IndexOutOfBoundsException("There is no element with index " + index + " in collection");
                }
                current = current.next;
            }
            current.next = current.next.next;
        }
        --_size;
    }

    public int size() {
        return _size;
    }
}
