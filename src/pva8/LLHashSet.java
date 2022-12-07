package pva8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Teil-Implementierung einer HashSet Klasse. Kollisionen sollen mit geketten Listen behandelt
 * werden.
 *
 * @param <E>
 */


public class LLHashSet<E> extends SetBasic<E> {

  public class DoublyLinkedListNode<E> {

    // Declaration of Nodes
    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;
    E data;

    // constructor
    DoublyLinkedListNode(E data) {
      this.data = data;
      next = null;
      prev = null;
    }
  }

  // Declaration of Hash Table
  DoublyLinkedListNode<E>[] hashTable;

  // stores the size of HashTable
  int size;

  public LLHashSet() {
    hashTable = new DoublyLinkedListNode[16];
    size = 0;
  }

  public LLHashSet(int hashTableSize) {
    hashTable = new DoublyLinkedListNode[hashTableSize];
    size = 0;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public boolean add(E e) {

    // kein TODO??

    // gets the position/index where the value should be
    // stored
    int position = hash(e);

    // creates a node for storing value
    DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(e);

    DoublyLinkedListNode<E> start = hashTable[position];

    if (hashTable[position] != null) {
      node.next = start;
      start.prev = node;
    }
    hashTable[position] = node;
    size++;
    return true;
  }

  @Override
  public boolean remove(Object o) {
    // TODO

    try {
      // gets the position where the value to
      // be deleted exists
      int position = hash(o);

      DoublyLinkedListNode<E> start = hashTable[position];

      DoublyLinkedListNode<E> end = start;

      // if value is found at start
      if (start.data == o) {
        size--;
        if (start.next == null) {
          // removing the value
          hashTable[position] = null;

        }

        start = start.next;
        start.prev = null;
        hashTable[position] = start;

        return true;
      }

      // traversing the list
      // until the value is found
      while (end.next != null && end.next.data != o) {
        end = end.next;
      }

      // if reached at the end without finding the
      // value
      if (end.next == null) {
        System.out.println("\nElement not found\n");
        return false;
      }

      size--;

      if (end.next.next == null) {
        end.next = null;
        return false;
      }

      end.next.next.prev = end;
      end.next = end.next.next;

      hashTable[position] = start;
    } catch (Exception e) {
      System.out.println("\nElement not found\n");
    }
    return false;
  }

  // Definition of Hash function
  private int hash(Object x) {
    int hashValue = x.hashCode();

    hashValue %= hashTable.length;

    if (hashValue < 0) {
      hashValue += hashTable.length;
    }

    return hashValue;
  }


  public class HashTableIterator implements Iterator<E> {

    private DoublyLinkedListNode<E> current;

    public HashTableIterator(LLHashSet<E> hashSet) {
      current = hashSet.hashTable[0];
    }

    @Override
    public boolean hasNext() {

      return current != null;
    }

    @Override
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      E tmp = current.data;
      current = current.next;
      return tmp;
    }
  }

  @Override
  public Iterator<E> iterator() {
    // TODO??

    return new HashTableIterator(this);
  }

  @Override
  public int size() {
    // TODO
    return size;
  }

  @Override
  public boolean isEmpty() {
    // TODO
    return size == 0;
  }

  @Override
  public void clear() {
    // TODO

    hashTable = new DoublyLinkedListNode[hashTable.length];
    size = 0;
  }
}
