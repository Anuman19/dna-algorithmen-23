package pva3.greedy;

public class TSP_Greedy {
    static int[] findPath(int[][] adja, int start) {
        checkInput(adja, start);

        // array that saves the chosen path
        int[] visited = new int[adja.length];

        // saves the current location from which we search the next step
        int current = start;

        for (int i = 0; i < adja.length; i++){
            int min = Integer.MAX_VALUE;
            int minPlace = 0;

            // basic minSearch to find the shortest next step
            for (int j = 0; j < adja.length; j++){
                // checks for 0 (self to self) and already visited locations
                if (adja[current][j] != 0 && !arrayContains(visited, j)){
                    if (adja[current][j] < min){
                        min = adja[current][j];
                        minPlace = j;
                    }
                }
            }

            // store location in visited and update current to search for the next location
            visited[i] = minPlace;
            current = minPlace;
        }
        return visited;
    }

    // Helper Method to check if an array contains an int. to avoid transforming to Arraylist
    static boolean arrayContains(int[] array, int value){
        for (int i = 0; i < array.length; i++){
            if (array[i] == value){
                return true;
            }
        }
        return false;
    }

    /**
     * Test, on Input korrekt ist:
     * + Die Adjazenzmatrix muss quadratisch sein
     * + Die Matrizenelemente müssen >= 0 sein
     * + Der Startwert muss eine zulässige Knotennummer sein
     *
     * @throws IllegalArgumentException
     */

    // testInput for cases that are invalid
    static void checkInput(int[][] adja, int start) throws IllegalArgumentException {
        if (adja.length != adja[0].length) {
            throw new IllegalArgumentException("Keine quadratisch Matrix");
        } else if (start < 0 || start >= adja.length) {
            throw new IllegalArgumentException("Start value nicht valide");
        } else {
            for (int i = 0; i < adja.length; i++) {
                for (int j = 0; j < adja.length; j++) {
                    if (i == j && (adja[i][j] != 0)) {
                        throw new IllegalArgumentException("Diagonale nicht null");
                    } else if (i != j && (adja[i][j] <= 0)) {
                        throw new IllegalArgumentException("Nicht Diagonalelement ist = 0");
                    }
                }
            }
        }
    }
}
