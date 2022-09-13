package pva1.permutations;


import java.util.Arrays;

public class Permutations {

    static int rowNumber = 0;

    /**
     * Erzeugt ein Array von allen Permutationen von {0,1,2,3,...,n-1}.
     *
     * @param n Anzahl Elemente in einer Permutation.
     * @return Ein Array von Permutationen; jede Zeile ist eine Permutation von {0,1,2,3,...,n-1}.
     * Permutation ist ein Array von Integern.
     *
     *
     * testPerm4 and testPerm5 work independently but not when all tests are executed simultaneously
     */

    public static int[][] permutations(int n) {
        // TODO

        // baseArray erstellen und mit Werten initiieren.
        if (n == 0){
            return new int[0][];
        }

        int[] baseArray = new int[n];
        for (int i = 0; i < baseArray.length; i++) {
            baseArray[i] = i;
        }

        int numberOfPermutations = factorial(n);

        int[][] allPermutations = new int[numberOfPermutations][n];

        calcPermutations(n, baseArray, allPermutations);

        System.out.println(Arrays.toString(allPermutations));
        return allPermutations;
    }

    private static void calcPermutations(int n, int[] baseArray, int[][] allPermutations) {
        if (n == 1) {
			allPermutations[rowNumber++] = baseArray.clone();
        } else {
            for (int i = 0; i < n - 1; i++) {
                calcPermutations(n - 1, baseArray, allPermutations);
                if (n % 2 == 0) { // gerade
                    swap(baseArray, i, n - 1); // i-te Element und letzte austauschen
                } else { // ungerade
                    swap(baseArray, 0, n - 1); // erste und letzte Element austauschen
                }
            }
            calcPermutations(n - 1, baseArray, allPermutations); // solange wiederholen, bis i < n
        }
    }

    // Calculate factorial of n, to get Dimension of Array
    private static int factorial(int n) {
        for (int i = n - 1; i > 0; i--) {
            n = n * i;
        }
        return n;
    }

    // Swap two Elements of an array
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void printPermutations(int[][] a, char delimiter) {
        final String delimiterSpace =
                delimiter + " "; // zur Erkennung, einzelne Zahlen mit Zeichen getrennt
        for (int[] row : a) {
            for (int col : row) {
                System.out.print(col + delimiterSpace);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int p = 3;
        char delimiter = ',';
        System.out.println("Permutations of " + p + " are: \n");
        int[][] n = permutations(p);
        printPermutations(n, delimiter);

    }


}
