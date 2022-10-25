package pva5.sort;

public class InsertSort 
{
	/**
	 * Sortiert ein Array durch Einfügen
	 * @param array Das zu sortierende Array.
	 */
	public static void sort(int[] array)
	{
		int n = array.length;
		for (int i = 1; i < n; ++i) {
			int key = array[i];
			int j = i - 1;

			/* Move elements of arr[0..i-1], that are
			greater than key, to one position ahead
			of their current position */
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}
	
	/**
	 * Sortiert einen durch zwei Grenzen angebenen Teil eines Arrays durch Einfügen.
	 * Arrayelemente ausserhalb der Grenzen werden nicht verschoben.
	 * @param array 
	 * @param start Index des ersten Elementes des Teils, das Sortiert werden muss.
	 * @param end   Index des letzten Elementes des Teils, das sortiert werden muss.
	 */
	public static void sort(int[] array, int start, int end)
	{
		// TODO
	}

}

