package pva8;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Teil-Implementierung einer HashSet Klasse. Kollisionen sollen mit linearer Sondierung behandelt
 * werden.
 *
 * @param <E>
 */
public class LSHashSet<E> extends SetBasic<E> {

  private int size = 0;
  private int M = 16;
  private final ArrayList<Object> keys;
  private final ArrayList<Object> values;


  public LSHashSet(int size) {
    keys = new ArrayList<>(size);
    values = new ArrayList<>(size);
    this.size = size;
  }

  public LSHashSet() {
    keys = new ArrayList<>(M);
    values = new ArrayList<>(M);
  }

  private int hash(Object o) {
    return (o.hashCode() & 0x7fffffff) % M;
  }

  @Override
  public boolean contains(Object obj) {
    // TODO

    for (Object elem : values) {
      if (elem.equals(obj)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean add(E e) {
    // TODO

    /*
    for (int i = hash(e); keys.get(i) != null; i = (i + 1) % M) {
      if (keys.get(i).equals(e)) {
        break;
      } else {
        values.add(e);
      }
      keys.set(i, e);
      size++;
      return true;
    }
    return false;

    */
    return false;
  }

  @Override
  public boolean remove(Object o) {
    // TODO

    if (!contains(o)) {
      return false;
    }

    values.remove(o);
    keys.remove(o);
    size--;
    return true;


  }

  @Override
  public Iterator<E> iterator() {
    // TODO
    return (Iterator<E>) values.iterator();
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
    values.clear();
  }

}
