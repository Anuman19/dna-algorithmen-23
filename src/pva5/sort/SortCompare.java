package pva5.sort;

// Modified SortCompare to compare two sorting algorithms
// uses the Stopwatch.java class

/******************************************************************************
 *  Compilation:  javac SortCompare.java
 *  Execution:    java SortCompare alg1 alg2 n trials
 *  Dependencies: System.out.java Stopwatch.java
 *
 *  Sort n random real numbers, trials times using the two
 *  algorithms specified on the command line.
 *
 *  % java SortCompare Insertion Selection 1000 100
 *  For 1000 random Doubles
 *    Insertion is 1.7 times faster than Selection
 *
 *  Note: this program is designed to compare two sorting algorithms with
 *  roughly the same order of growth, e,g., insertion sort vs. selection
 *  sort or mergesort vs. quicksort. Otherwise, various system effects
 *  (such as just-in-time compiliation) may have a significant effect.
 *  One alternative is to execute with "java -Xint", which forces the JVM
 *  to use interpreted execution mode only.
 *
 ******************************************************************************/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortCompare {

  public static Random random = new Random();

  public static double time(String alg, int[] a) {

    Stopwatch sw = new Stopwatch();
    if (alg.equals("Insert")) {
      InsertSort.sort(a);
    } else if (alg.equals("Quick")) {
      QuickSort.sort(a);
    } else if (alg.equals("Quick+")) {
      QuickSort.sortPlus(a);
    } else if (alg.equals("Intro")) {
      IntroSort.sort(a);
    }else if (alg.equals("Heap")) {
      HeapSort.sort(a);
    }
    return sw.elapsedTime();
  }

  // Use alg to sort trials random arrays of length n.
  public static double timeRandomInput(String alg, int n, int trials) {
    double total = 0.0;
    int[] a = new int[n];
    // Perform one experiment (generate and sort an array).
    for (int t = 0; t < trials; t++) {
      for (int i = 0; i < n; i++) {
        a[i] = random.nextInt(Integer.MAX_VALUE);
      }
      total += time(alg, a);
    }
    return total;
  }

  public static void main(String[] args) {

    int run = 1;
    while (run == 1) {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Algo 1");
      String alg1 = scanner.nextLine();

      System.out.println("Algo 2");
      String alg2 = scanner.nextLine();

      System.out.println("Array size");
      int n = scanner.nextInt();

      int trials = 1000;
      double time1, time2;

      time1 = timeRandomInput(alg1, n, trials);   // Total for alg1.
      time2 = timeRandomInput(alg2, n, trials);   // Total for alg2.

      System.out.println("Time for " + alg1 + "\t" + time1);
      System.out.println("Time for " + alg2 + "\t" + time2);

      String winner;

      if (time1 > time2) {
        winner = alg2;
      } else {
        winner = alg1;
      }

      System.out.println("Winner is " + winner);

      System.out.println("Press <1> to go again.");
      run = scanner.nextInt();
    }
  }
}


