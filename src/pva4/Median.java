package pva4;

import java.awt.RadialGradientPaint;
import java.util.ArrayList;
import java.util.Random;

public class Median {

  private Median() {
  }

  /**
   * Bestimmt auf effiziente Art das der Größe nach n-te Element, ohne das Array zu sortieren. el =
   * n_tesElement(array, n) liefert also das selbe wie
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

		System.out.println("We're looking for " + newN);

		Random random = new Random();

		ArrayList<Integer> newArray = new ArrayList<>();
		ArrayList<Integer> minList = new ArrayList<>();
    ArrayList<Integer> maxList = new ArrayList<>();

		for (int i : array) {
			newArray.add(i);
		}
    while (minList.size() != (newN - 1)) {
			maxList.clear();
			minList.clear();
			int randomPivot = random.nextInt(newArray.size());
      pivot = newArray.get(randomPivot);
			newArray.remove(randomPivot);
      for (int num : newArray) {
        if (num < pivot) {
          minList.add(num);
        } else {
          maxList.add(num);
        }
      }

			System.out.println("");
			System.out.println("Pivot = " + pivot);
			System.out.println("Array = " + newArray);
			System.out.println("Min = " + minList);
			System.out.println("Max = " + maxList);

			if (minList.size() < (newN - 1)){
				newArray.clear();
				newArray.addAll(maxList);
				newN = newN - minList.size() - 1;
			} else if (minList.size() > (newN - 1)){
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
