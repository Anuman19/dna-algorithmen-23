package pva2;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.util.Objects.checkIndex;

public class LinkedList<E> extends ListBasic<E> implements List<E> {

    // initialising size and anchorNode of the List.
    // From the anchorNode you can reach the first and last elements of the list
    private int size = 0;
    private final Node<E> anchorNode;

    public LinkedList() {
        this.anchorNode = new Node<>();
        anchorNode.prev = anchorNode;
        anchorNode.next = anchorNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public E get(int index) {
        // native utils function to check for OutOfBoundsExceptions
        checkIndex(index, size());
        return getNode(index).element;
    }

    // Helper Function to get the Node of a specific index
    // Used for set(), add(), remove()
    private Node<E> getNode(int index) {
        Node<E> currentNode = anchorNode.next;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        // potentially go backwards to increase speed
//        for (int i = 0; i > index; i--) {
//            currentNode = currentNode.prev;
//        }

        return currentNode;
    }

    // replace element and return the replaced element
    @Override
    public E set(int index, E element) {
        checkIndex(index, size());
        Node<E> node = getNode(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }


    @Override
    public boolean add(E element) {
        return insertAfter(anchorNode.prev, element);
    }

    @Override
    public void add(int index, E element) {
        if (!(isEmpty() && index == 0)) { //add on 0 is allowed on empty List
            checkIndex(index, size());
        }
        Node<E> node = getNode(index - 1); // -1 as we want to append after the selected node
        insertAfter(node, element);
    }

    // Implementation of ListBasic Function
    @Override
    public int indexOf(Object o) {
        Node<E> node = anchorNode.next;
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(o, node.element)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    // Helper Function to add a Node after another
    // Used for add()
    private boolean insertAfter(Node<E> nodeBeforeNew, E element) {
        Node<E> noteAfterNew = nodeBeforeNew.next;

        Node<E> newNode = new Node<>();
        newNode.element = element;
        newNode.prev = nodeBeforeNew;
        newNode.next = noteAfterNew;

        noteAfterNew.prev = newNode;
        nodeBeforeNew.next = newNode;

        size++;
        return true;
    }

    public boolean contains(Object o) {
        int index = indexOf(o);
        return (index != -1);
    }

    @Override
    public E remove(int index) {
        checkIndex(index, size);
        Node<E> node = getNode(index);
        remove(node);

        return node.element;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    // Helper Function to remove a specified Node
    // Used for remove()
    private void remove(Node<E> node) {
        //get the neighbours
        Node<E> previous = node.prev;
        Node<E> next = node.next;

        //check if the current element is still in the list
        if (!node.equals(previous.next)) {
            throw new IllegalStateException();
        }

        // reassign the neighbouring nodes of the removed nodes neighbours
        previous.next = next;
        next.prev = previous;

        size--;
    }


    @Override
    public void clear() {
        anchorNode.prev = anchorNode;
        anchorNode.next = anchorNode;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    // Die anderen Methoden des List-Interfaces müssen nicht implementiert werden.

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public String toString() {
            return String.join(prev.element.toString(), "<<",
                    element.toString(), ">>",
                    next.element.toString());
        }
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = anchorNode;

        @Override
        public boolean hasNext() {
            return !(current.next.equals(anchorNode));
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current = current.next;
            return current.element;
        }

        @Override
        public void remove() {
            LinkedList.this.remove(current);
        }
    }
}
