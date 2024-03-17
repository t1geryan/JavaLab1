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
            throw new IndexOutOfBoundsException("Индекс вне диапазона");
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

    public int size() {
        return _size;
    }
}
