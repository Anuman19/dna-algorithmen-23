package pva1.permutations;


import java.util.Arrays;
import java.util.Collections;

public class Permutations
{
	/**
	 * Erzeugt ein Array von allen Permutationen von {0,1,2,3,...,n-1}.
	 * @param n Anzahl Elemente in einer Permutation.
	 * @return  Ein Array von Permutationen; jede Zeile ist eine Permutation von {0,1,2,3,...,n-1}.
	 * Permutation ist ein Array von Integern.
	 */

	public static void main(String[] args) {
		permutations(5);
	}
	public static int[][] permutations(int n) {
		// TODO

		int[] baseArray = new int[n];

		int numberOfPermutations = 1;
		for(int i = n; i > 1; i--){
			numberOfPermutations = numberOfPermutations * i;
		}

		int[][] allPermutations = new int[numberOfPermutations][n];

		int k = n;

		for(int i = 0; i< baseArray.length; i++){
			baseArray[i] = i;
		}

		return null;
	}
	

}
