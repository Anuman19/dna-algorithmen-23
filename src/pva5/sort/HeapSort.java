package pva5.sort;

public class HeapSort {

    /**
     * Sortiert ein Array mit Heapsort.
     *
     * @param array
     */
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    /**
     * Sortiert ein Teilstück eines Array s mit Heapsort.
     *
     * @param array
     * @param start Index des ersten Elementes des zu sortierenden Teils.
     * @param start Index des letzten Elementes des zu sortierenden Teils.
     */
    public static void sort(int[] array, int start, int end) {
        // TODO

        // error-handling
        if (array == null || array.length < 2) {
            return;
        }

        // build heap of array
        makeHeap(array, start, end);


        // loop through heap and extract an element
        for (int i = end - start; i >= 0; i--) {

            // swap current root node to end
            swap(array, 0, i);

            // build heap of sub-array
            sink(array, start, i, 0);
        }


    }

    /**
     * Erzeugt aus einem angegebenen Teilstück einen Heap.
     *
     * @param array
     * @param start Index des ersten Elementes, aus dem ein Heap erzeugt werden sollte. Das ist auch
     *              der Index der Wurzel des Heaps; die Kinder der Wurzel liegen dann an den Position
     *              start+1 und start+2.
     * @param end   Index des letzten Elementes des Stücks, aus dem ein Heap erzeugt werden sollte.
     */
    public static void makeHeap(int[] array, int start, int end) {
        // TODO

        //error-handling
        if (start > end) {
            return;
        }

        // get size of sub-array
        int N = end - start + 1;

        // rearrange array -> build heap
        for (int i = N / 2 - 1; i >= 0; i--) {
            sink(array, start, end + 1, i);
        }


    }


    // utility-function
    static void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    /**
     * Hilfsmethode für Heapsort: Aus einem Teilstück eines Arrays mit den Grenzen start und end
     * sollte ein Heap erzeugt werden. Für Indices grösser als index sei die Heap-Eigenschaft bereits
     * erfüllt. Die Methode ordnet das Stück zwischen index und end so um, dass die Heapeigenschaft
     * für alle Elemente erfüllt ist.
     *
     * @param array
     * @param start
     * @param end
     * @param index
     */
    static void sink(int[] array, int start, int end, int index) {
        // TODO	(Implementieren Sie diese Methode, wenn Sie sie für die Sort-Methoden brauchen.

        // root node
        int max = index;

        // left and right child of root
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // if left child is larger than max -> change
        if (left + start< end && array[left + start] > array[max + start]) {
            max = left;
        }

        // if right child is larger than max -> change
        if ( right + start < end && array[right + start] > array[max + start]) {
            max = right;
        }

        // if max is not root -> change has occurred
        if (max != index) {

            // swap root
            swap(array, index + start, max + start);

            // build heap of sub-tree recursively
            sink(array, start, end, max);
        }

    }

    /**
     * Entfernt das Wurzelelement eines Heaps, baut den Heap um, so dass er nach dem Entfernen wieder
     * ein Heap ist (mit einem Element weniger), und setzt das ehemalige Wurzelelement an die vormals
     * letzte Stelle im Heap (die nun nicht mehr zum Heap gehört).
     *
     * @param array Ein Array, das als Teilstück einen heap enthält.
     * @param start Indes der Wurzel des heaps
     * @param end   Index des letzten Heap-Elements.
     */
    public static void removeHeapRoot(int[] array, int start, int end) {
        // TODO	(Implementieren Sie diese Methode, wenn Sie sie für die Sort-Methoden brauchen.

        // swap root with last child
        swap(array, start, end);

        // build heap of sub-array -> without last element which is now root-node
        makeHeap(array, start, end - 1);
    }

    /**
     * Berechnet den Index des linken Kindelementes in einem Heap.
     *
     * @param parentIndex
     * @param offset      Offset für Heap-Eigenschaft: entspricht dem Index der Heapwurzel - 1
     * @return Index des linken Kindes
     */
    static int leftChild(int parentIndex, int offset) {
        return 2 * parentIndex - offset;
    }

    /**
     * Berechnet den Index des rechten Kindelementes in einem Heap.
     *
     * @param parentIndex
     * @param offset      Offset für Heap-Eigenschaft: entspricht dem Index der Heapwurzel - 1
     * @return Index des rechten Kindes
     */
    static int rightChild(int parentIndex, int offset) {
        return leftChild(parentIndex, offset) + 1;
    }


}
