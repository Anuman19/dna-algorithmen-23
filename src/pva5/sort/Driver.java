package pva5.sort;

import java.util.Arrays;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        Random random = new Random();
        int[] test100000 = new int[100_000];
        int[] test1000000 = new int[1_000_000];
        int[] test100000000 = new int[100_000_000];

        for (int i = 0; i < test100000000.length; i++) {
            test100000000[i] = random.nextInt(100_000_000);
        }
        for (int i = 0; i < test100000.length; i++) {
            test100000[i] = random.nextInt(100_000_000);
        }
        for (int i = 0; i < test1000000.length; i++) {
            test1000000[i] = random.nextInt(100_000_000);
        }

        long start = System.currentTimeMillis();
        QuickSort.sort(test100000000);
        long duration = System.currentTimeMillis() - start;
        System.out.println("To sort test100000000 Quicksort used " + duration + "ms");

        start = System.currentTimeMillis();
        Arrays.sort(test100000000);
        duration = System.currentTimeMillis() - start;
        System.out.println("To sort test100000000 DualQuicksort used " + duration + "ms");

        start = System.currentTimeMillis();
        InsertSort.sort(test100000000);
        duration = System.currentTimeMillis() - start;
        System.out.println("To sort test100000000 Insertionsort used " + duration + "ms");

        System.out.println();

        start = System.currentTimeMillis();
        QuickSort.sort(test100000);
        duration = System.currentTimeMillis() - start;
        System.out.println("To sort test100000 Quicksort used " + duration + "ms");

        start = System.currentTimeMillis();
        InsertSort.sort(test100000);
        duration = System.currentTimeMillis() - start;
        System.out.println("To sort test100000 Insertionsort used " + duration + "ms");

        System.out.println();

        start = System.currentTimeMillis();
        QuickSort.sort(test1000000);
        duration = System.currentTimeMillis() - start;
        System.out.println("To sort test1000000 Quicksort used " + duration + "ms");

        start = System.currentTimeMillis();
        InsertSort.sort(test1000000);
        duration = System.currentTimeMillis() - start;
        System.out.println("To sort test1000000 Insertionsort used " + duration + "ms");

    }
}
