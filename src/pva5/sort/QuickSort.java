package pva5.sort;

import java.util.Random;

public class QuickSort {

  /**
   * Sortiert ein Array durch Quicksort.
   *
   * @param array Zu sortierendes Array.
   */

  public static void sort(int[] array) {
    // TODO
    sort(array, 0, array.length - 1);
  }

  /**
   * Sortiert ein Teilstück eines Arrays durch Quicksort.
   *
   * @param array ZU sortierenden Array
   * @param start Index des ersten Elementes des Teils, das sortiert werden muss.
   * @param end   Index des letzten Elementes des Teils, das sortiert werden muss.
   */
  public static void sort(int[] array, int start, int end) {
    if (start < end) {

      // pi is partitioning index, arr[p]
      // is now at right place
      int pi = partition(array, start, end, findPivot(array, start, end));

      // Separately sort elements before
      // partition and after partition
      sort(array, start, pi - 1);
      sort(array, pi + 1, end);
    }
  }

  /**
   * Schwellwert, bei welcher Arraygrösse in der Rekursion InsertSort statt Quicksort aufgerufen
   * werden sollte.
   */
  static int THRESHOLD = 80; // TODO finden Sie einen sinnvollen Wert

  // testing with SortCompare.java provided 80 as a viable threshold
  // InsertSort is faster with smaller array size

  /**
   * Modifiziertes Quicksorts. Wenn die Grösse des zu sortierenden Arrays in der Rekursion einen
   * Schwellwert unterschreitet, wird InsertSort statt Quicksort aufgerufen.
   *
   * @param array Zu sortierendes Array
   */

  // The tests with SortCompare.java showed that sort+ can be twice as fast as normal quicksort for
  // an array size of 100. The difference shrinks with growing array size ->
  // n = 500
  // Quick = 0.023s
  // Quick+ = 0.022s
  public static void sortPlus(int[] array) {
    sortPlus(array, 0, array.length - 1);

  }

  /**
   * Modifiziertes Quicksorts zum Sortieren eines Teilstücks eines Arrays. Wenn die Grösse des zu
   * sortierenden Arrays in der Rekursion einen Schwellwert unterschreitet, wird InsertSort statt
   * Quicksort aufgerufen.
   *
   * @param array Zu sortierendes Array
   * @param start Index des ersten Elementes des zu sortierenden teilstücks.
   * @param end   Index des letzten Elementes des zu sortierenden teilstücks.
   */
  public static void sortPlus(int[] array, int start, int end) {
    // TODO

    // if Threshold is not met - use InsertSort, else stick with QuickSort
    if (end - start < THRESHOLD) {
      InsertSort.sort(array, start, end);
    } else {
      if (start < end) {

        // pi is partitioning index, arr[p]
        // is now at right place
        int pi = partition(array, start, end, findPivot(array, start, end));

        // Separately sort elements before
        // partition and after partition
        sortPlus(array, start, pi - 1);
        sortPlus(array, pi + 1, end);
      }
    }
  }

  public static void sortPlusIntro(int[] array) {
    sortPlus(array, 0, array.length - 1);

  }
  public static void sortPlusIntro(int[] array, int start, int end, int maxDepth) {
    // TODO

    // if Threshold is not met - use InsertSort, else stick with QuickSort
    if (end - start < THRESHOLD) {
      InsertSort.sort(array, start, end);
    } else {
      if (start < end) {

        // pi is partitioning index, arr[p]
        // is now at right place
        int pi = partition(array, start, end, findPivot(array, start, end));

        maxDepth -= 1;
        // Separately sort elements before
        // partition and after partition
        IntroSort.sort(array, start, pi - 1, maxDepth);
        IntroSort.sort(array, pi + 1, end, maxDepth);
      }
    }
  }

  /**
   * Hilfsmethode für Quicksort. Ein Teilstück eines Arrays wird geteilt, so dass alle Elemente, die
   * kleiner als ein gewisses Pivot-Elements sind, links stehen und alle Elemente, die grösser als
   * das Pivot-Element rechts stehen.
   *
   * @param array Array zum Umordnen.
   * @param start Indes des ersten Elements des Teilstücks, das geteilt werden muss.
   * @param end   Index des letztes Elements des Teilstücks, das geteilt werden muss.
   * @param piv   Index des PiotElements
   * @return Index des Piot-Element nach der Partitionierung.
   */
  static int partition(int[] array, int start, int end, int piv) {

    // get value for pivot
    int pivot = array[piv];

    // Index of smaller element and
    // indicates the right position
    // of pivot found so far
    int i = (start - 1);

    for (int j = start; j <= end - 1; j++) {

      // If current element is smaller
      // than the pivot
      if (array[j] < pivot) {

        // Increment index of
        // smaller element
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, end);
    return (i + 1);
  }

  /**
   * Hilfsmethode zum Vertauschen zweier Array-Elemente
   *
   * @param array
   * @param a
   * @param b
   */
  static void swap(int[] array, int a, int b) {
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }

  /**
   * Hilfsmethode zum Finden eines Pivot-Elementes für Quicksort. Zu einem Array und den zwei
   * Indices start und end wird der Index eines möglichen Pivot-Elementes angegeben
   *
   * @param array
   * @param start
   * @param end
   * @return Index eines Pivot-Elementes
   */
  static int findPivot(int[] array, int start, int end) {
    // TODO

    // use last element as pivot
    return end;
  }
}
