package pva5.sort;

import static pva5.sort.QuickSort.partition;

public class IntroSort 
{
	/**
	 * Sortiert ein Array der Länge n mit IntroSort.
	 * Das Array wird mit Quicksort sortiert, 
	 * wenn aber die Rekursionstiefe mehr 
	 * als n * log(n) wird, wird auf HeapSort ungestellt.
	 * @param array
	 */
	public static void sort(int[] array)
	{
		int l = array.length;
		sort(array, 0, l - 1, 2 * log2(l));
	}
	
	/**
	 * Sortiert eine Teilstück eines Arrays mit IntroSort.
	 * @param array Zu sortierendes Array
	 * @param start Index des ersten Elementes des zu sortierenden Stücks.
	 * @param end   Index des letzten Elementes des zu sortierenden Stücks.
	 * @param maxDepth
	 */
	public static void sort(int[] array, int start, int end, int maxDepth)
	{

		// error-handling
		if (start >= end) return;

		// if 2n * log2(n) then use HeapSort to avoid worst-case of QuickSort
		if (maxDepth <= 0){
			HeapSort.sort(array, start, end);
		} else {

			// else, use QuickSort
			QuickSort.sort(array, start, end);
		}
	}

	/**
	 * Bestimmt den (abgerundeten) Zweierlogarithmus ohne float-Arithmetik.
	 * @param n
	 * @return
	 */
	static int log2(int n)
	{
		int log = 0;
		while (n > 1)
		{
			n >>>= 1;
			log++;
		}
		return log;
	}
}
