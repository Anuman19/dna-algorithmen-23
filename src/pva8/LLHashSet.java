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

  class LinkedHash<E> {
    String key;
    E value;
    LinkedHash next;

    // constructor of linked hash
    LinkedHash(String key, E value)
    {
      this.key = key;
      this.value = value;
      this.next = null;
    }
  }

  private final int tableSize;
  private int size;
  public LinkedHash<E>[] table;
  public LLHashSet() {
    this.tableSize = 64;
    this.table = new LinkedHash[tableSize];
    size = 0;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public boolean add(E e) {

    // kein TODO??

    int hash = (hash(e) % tableSize);
    if (table[hash] == null) {
      table[hash] = new LinkedHash((String) e, e);
    }
    else {
      LinkedHash entry = table[hash];
      while (entry.next != null
          && !entry.key.equals(e)) {
        entry = entry.next;
      }
      if (entry.key.equals(e)) {
        entry.value = e;
      }
      else {
        entry.next = new LinkedHash((String) e, e);
      }
    }
    size++;
    return true;

  }

  @Override
  public boolean remove(Object o) {
    // TODO

    if (size == 0){
      return false;
    }
    int value = (hash(o) % tableSize);
    if (table[value] != null) {
      LinkedHash prev = null;
      LinkedHash current = table[value];
      while (current.next != null
          && !current.key.equals(o)) {
        prev = current;
        current = current.next;
      }
      if (current.key.equals(o)) {
        if (prev == null) {
          table[value] = current.next;
        }
        else {
          prev.next = current.next;
        }
        size--;
      }
    }
    return true;
  }

  // Definition of Hash function
  private int hash(Object x) {
    int value = x.hashCode();
    value %= tableSize;
    if (value < 0) {
      value = value + tableSize;
    }
    return value;
  }



  @Override
  public Iterator<E> iterator() {
    return new HashSetIterator(this);
  }

  private class HashSetIterator implements Iterator<E> {

    private int size = 0;
    private LinkedHash<E> node;
    private LinkedHash<E> pointer = this.node;

    private void resetIteratorPointer() {
      pointer=this.node;
    }

    public HashSetIterator(LLHashSet<E> hashSet){
      this.node = hashSet.table[0];
    }

    @Override
    // checks whether there is a next node
    public boolean hasNext() {

      if (pointer == null){
        resetIteratorPointer();
        return false;
      } else {
        return true;
      }
    }

    @Override
    // returns neighbor node
    public E next() {

      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      E data = pointer.value;
      pointer = pointer.next;
      return data;
    }}


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

    table = new LinkedHash[table.length];
    size = 0;
  }
}
