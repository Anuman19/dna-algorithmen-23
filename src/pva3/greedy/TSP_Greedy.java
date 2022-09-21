package pva3.greedy;

public class TSP_Greedy {
    static int[] findPath(int[][] adja, int start) {
        checkInput(adja, start);
        // TODO
        return null;
    }

    /**
     * Test, on Input korrekt ist:
     * + Die Adjazenzmatrix muss quadratisch sein
     * + Die Matrizenelemente müssen >= 0 sein
     * + Der Startwert muss eine zulässige Knotennummer sein
     *
     * @throws IllegalArgumentException
     */

    static void checkInput(int[][] adja, int start) throws IllegalArgumentException {
        if (adja.length != adja[0].length) {
            throw new IllegalArgumentException("Keine quadratisch Matrix");
        } else if (start < 0 || start >= adja.length) {
            throw new IllegalArgumentException("Start nicht valide");
            // native method checkIndex testen
        } else {
            for (int i = 0; i < adja.length; i++) {
                for (int j = 0; j < adja.length; j++) {
                    if (i == j && (adja[i][j] != 0)) {
                        throw new IllegalArgumentException("Diagonale nicht null");
                    } else if (i != j && (adja[i][j] <= 0)) {
                        throw new IllegalArgumentException("Nicht Diagonalenelement ist = 0");
                    }
                }
            }
        }
        // TODO
    }
}
