package pva4;

import java.util.ArrayList;
import java.util.Random;

public class Median {

  private Median() {
  }

  /**
   * Bestimmt auf effiziente Art das der Größe nach n-te Element, ohne das Array zu sortieren. el =
   * n_tesElement(array, n) liefert also dasselbe wie
   * <pre>
   *     Arrays.sort(array);
   *     el = array[n];
   * </pre>
   *
   * @param array
   * @param n
   * @return Das der Größe nach n-te Element des Arrays
   */
  public static int n_tesElement(int[] array, int n) {
    // TODO
    int pivot = 0;
    int newN = n;

    Random random = new Random();

    ArrayList<Integer> newArray = new ArrayList<>();
    ArrayList<Integer> minList = new ArrayList<>();
    ArrayList<Integer> maxList = new ArrayList<>();

    // copy original array into ArrayList
    for (int i : array) {
      newArray.add(i);
    }

    while (true) {
      maxList.clear();
      minList.clear();

      // select random pivot from list
      int randomPivot = random.nextInt(0, newArray.size());
      pivot = newArray.get(randomPivot);

      // remove pivot from list
      newArray.remove(randomPivot);

      // partition list into greater than and smaller than pivot element
      for (int num : newArray) {
        if (num < pivot) {
          minList.add(num);
        } else {
          maxList.add(num);
        }
      }

      // break loop if pivot is the element searched for
      if (minList.size() == newN) {
        break;
      }

      // if size of minList is smaller than the position of n
      // then the element has to be in maxList
      else if (minList.size() < newN) {
        newArray.clear();
        newArray.addAll(maxList);

        // error handling for duplicate numbers

        // adjust index for each smaller deleted element
        newN = newN - minList.size() - 1;
      }

      // if size of minList is larger than the position of n
      // then the element has to be in minList
      else {
        newArray.clear();
        newArray.addAll(minList);
      }
    }

    return pivot;
  }

  /**
   * Bestimmt den Median eines Arrays. (Besitzt das Array eine gerade Anzahl Elemente, wird das
   * größere der beiden mittleren Elemente zurückgegeben, nicht der Mittelwert dieser beiden
   * mittleren Element.)
   *
   * @param array
   * @return
   */
  public static int median(int[] array) {
    return n_tesElement(array, array.length / 2);
  }
}
