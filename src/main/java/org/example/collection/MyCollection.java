package org.example.collection;

import java.util.Collection;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * A class for storing and working with an arbitrary number of elements.
 * Implements basic methods of working with collections, but doesn't implement the {@link Collection}
 */
public class MyCollection {
    private Node head;
    private int _size = 0;

    /**
     * Adds value to collection at the passed index
     *
     * @param index where to add value
     * @param value represents value to add
     * @throws IndexOutOfBoundsException if index is less than 0 or more than {@link MyCollection#size()}
     */
    public void addAt(int index, int value) {
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

    /**
     * Push value to collection's end
     * @param value represents value to add
     */
    public void push(int value) {
        addAt(_size, value);
    }

    /**
     * Returns collection's element at the passed index
     * @param index index of value to return
     * @throws IndexOutOfBoundsException if index is less than 0 or more or equal than {@link MyCollection#size()}
     */
    public int getAt(int index) {
        if (index < 0 || index >= _size) {
            throw new IndexOutOfBoundsException("There is no element with index " + index + " in collection");
        }

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

    /**
     * Removes value form the collection at passed index
     * @param index index of value to remove
     * @throws IndexOutOfBoundsException if index is less than 0 or more than {@link MyCollection#size()}
     */
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


    /**
     * Returns count of items in the collection
     * @return actual collection's size
     */
    public int size() {
        return _size;
    }
}
