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

        int length = array.length;
        int N = end - start + 1;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            makeHeap(array, i, end);

        // One by one extract an element from heap
        for (int i = end; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            makeHeap(array, 0, i);
        }
    }

    /**
     * Erzeugt aus einem angegebenen Teilstück einen Heap.
     *
     * @param array
     * @param start Index des ersten Elementes, aus dem ein Heap erzeugt werden sollte.
     *              Das ist auch der Index der Wurzel des Heaps; die Kinder der Wurzel
     *              liegen dann an den Position start+1 und start+2.
     * @param end   Index des letzten Elementes des Stücks, aus dem ein Heap erzeugt werden sollte.
     */
    public static void makeHeap(int[] array, int start, int end) {
        // TODO
        int largest = start; // Initialize largest as root
        int l = 2 * start + 1; // left = 2*i + 1
        int r = 2 * start + 2; // right = 2*i + 2
        int N = end ;

        // If left child is larger than root

        if (l < N && array[l] > array[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < N && array[r] > array[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != start) {
            int swap = array[start];
            array[start] = array[largest];
            array[largest] = swap;

            // Recursively heapify the affected sub-tree
            makeHeap(array, largest, end);

        }
    }

    /**
     * Hilfsmethode für Heapsort:
     * Aus einem Teilstück eines Arrays mit den Grenzen start und end
     * sollte ein Heap erzeugt werden. Für Indices grösser als index
     * sei die Heap-Eigenschaft bereits erfüllt.
     * Die Methode ordnet das Stück zwischen index und end so um,
     * dass die Heapeigenschaft für alle Elemente erfüllt ist.
     *
     * @param array
     * @param start
     * @param end
     * @param index
     */
    static void sink(int[] array, int start, int end, int index) {
        // TODO	(Implementieren Sie diese Methode, wenn Sie sie für die Sort-Methoden brauchen.
    }

    /**
     * Entfernt das Wurzelelement eines Heaps, baut den Heap um,
     * so dass er nach dem Entfernen wieder ein Heap ist (mit einem Element weniger),
     * und setzt das ehemalige Wurzelelement an die vormals letzte Stelle im Heap
     * (die nun nicht mehr zum Heap gehört).
     *
     * @param array Ein Array, das als Teilstück einen heap enthält.
     * @param start Indes der Wurzel des heaps
     * @param end   Index des letzten Heap-Elements.
     */
    public static void removeHeapRoot(int[] array, int start, int end) {
        // TODO	(Implementieren Sie diese Methode, wenn Sie sie für die Sort-Methoden brauchen.
    }

    /**
     * Berechnet den Index des linken Kindelementes in einem Heap.
     *
     * @param parentIndex
     * @param offset      Offset für Heap-Eigenschaft: entspricht
     *                    dem Index der Heapwurzel - 1
     * @return Index des linken Kindes
     */
    static int leftChild(int parentIndex, int offset) {
        return 2 * parentIndex - offset;
    }

    /**
     * Berechnet den Index des rechten Kindelementes in einem Heap.
     *
     * @param parentIndex
     * @param offset      Offset für Heap-Eigenschaft: entspricht
     *                    dem Index der Heapwurzel - 1
     * @return Index des rechten Kindes
     */
    static int rightChild(int parentIndex, int offset) {
        return leftChild(parentIndex, offset) + 1;
    }


}
