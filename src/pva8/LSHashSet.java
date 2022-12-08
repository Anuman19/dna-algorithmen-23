package pva8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Teil-Implementierung einer HashSet Klasse. Kollisionen sollen mit linearer Sondierung behandelt
 * werden.
 *
 * @param <E>
 */
public class LSHashSet<E> extends SetBasic<E> {
  private int size = 0;
  private final int capacity;
  private final HashMap<Integer, E> hashMap;
  private ArrayList<E> vals = new ArrayList<>();

  // constructor
  public LSHashSet() {
    capacity = 64;
    hashMap = new HashMap<>(capacity);
    clear();
  }

  @Override
  public boolean contains(Object obj) {
    return hashMap.get(obj) != null;
  }

  @Override
  public boolean add(E e) {

    //add data to arraylist

    if (!vals.contains(e)) {
      vals.add(e);
    }

    // error handling
    if (contains(e)) {
      return false;
    }

    // hash
    int hash = Math.abs(e.hashCode() % capacity);

    int i = 0;
    while (hash < capacity) {
      if (hash == i) {

        // check for collision
        if (hashMap.get(hash) == null) {
          hashMap.put(hash, e);

          // increase size
          size++;
          return true;
          // if collision --> linear probing
        } else {
          hash++;
          i++;
          if (hash > (capacity)) {
            hash = 0;
            i = 0;
          }
        }
      } else i++;
    }
    return false;
  }

  @Override
  public boolean remove(Object o) {
    // error handling
    if(size==0){
      return false;
    }

    --size;

    // check if object is in list
    if (contains(o)) {

      // clear map
      clear();

      // remove val from list
      vals.remove(o);

      // add modified list
      this.addAll(vals);
      return true;
    }
    return true;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void clear() {
    size = 0;

    // set every entry to null
    for (int i = 0; i < capacity; i++) {
      hashMap.put(i, null);
    }
  }

  @Override
  public Iterator<E> iterator() {
    return new LSHashSet.HashIterator(this);
  }

  class HashIterator implements Iterator<E> {
    private final LSHashSet<E> hashSet;
    private int index;
    private E pointer;
    private ArrayList<E> list;

    public HashIterator(LSHashSet<E> set) {
      hashSet = set;
      list = hashSet.vals;
      pointer = list.get(0);
      index = -1;
    }

    @Override
    public boolean hasNext() {

      // use pointer to check if next element is null
      return list.get(list.indexOf(pointer) + 1) == null;
    }

    @Override
    // returns neighbor node
    public E next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }

      // increment pointer and retrun data
      E tmp = pointer;
      pointer = list.get(index + 1);
      return tmp;
    }


  }

}
