package pva1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Aufgabe 1
// Der Algo gibt den Eintrag mit dem höchsten/niedrigsten Wert zurück.

// Aufgabe 2
// Siehe Code Unten

// Aufgabe 3
// Der Algo geht zweimal das gesamte Array durch. einmal für max und einmal für min.
// Insgesamt gibt es also 2(n-1) Vergleiche.
// (n-1) weil wir ja das erste Element nicht vergleichen, sondern direkt speichern.

// Aufgabe 4
// Ein Algorithmus, der das Problem mit max 3n/2 Vergleichen löst, führt Vergleiche auf alle Elemente in Zweierpaaren durch.
// Dadurch bilden sich 2 Arrays, welche nur die kleinen/grossen Zahlen der Paare beinhaltet.
// Dadruch ergeben sich 2 Arrays mit der Länge n/2.
// über diese Arrays iteriert man wie bei Algo1 und macht damit 2*(n/2-1) Vergleiche.
// Dadurch hat man insgesamt (n/2)+(2*(n/2-1)) = (3n/2 - 2) Vergleiche.
// Im untenstehenden Code ist dieser Algorithmus allerdings langsamer als der Erste, da das Erstellen der beiden teilarrays zu viel Zeit benötigt im Vergleich zu der gesparten Zeit.

// Aufgabe 5
// Ein Algorithmus mit weniger als n-1 vergleichen ist für das Finden von Min und Max Werten nicht möglich.
// Man kann bei jedem Schritt mit Vergleichen die Anzahl Elemente maximal halbieren.
// Diese Anzahl Vergleiche lässt sich nur erreichen, wenn man ausschliesslich das Max/Min berechnet.
// Und auch dann nur bei ständigem Halbieren der möglichen Zahlen.
// Wenn man sowohl Min und Max herausfinden möchte wird man immer über n Vergleiche haben.


public class Algorithmenanalyse {

    public static void main(String[] args) {
        // Scanner und Random erstellen für die Erstellung des Arrays.
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Array von gewünschter Länge erstellen
        System.out.println("Wie lange soll das Array sein?");
        int n = scanner.nextInt();
        int[] intArray = new int[n];

        // Das erstellte Array mit Zahlen von 1 bis 999 füllen
        for (int i = 0; i < n; i++) {
            intArray[i] = random.nextInt(1, 100);
        }

        // Startwerte für max und min auf das erste Element des Arrays setzen
        int x = intArray[0];
        int y = intArray[0];

        // Das Array einzeln durchgehen ob ein Eintrag kleiner/grösser ist.
        // Geht auch mit der foreach Schreibweise.
        // Im Beispiel/PseudoCode war eine for Schlaufe.

        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            if (x > intArray[i]) {
                x = intArray[i];
            }
            if (y < intArray[i]) {
                y = intArray[i];
            }
        }

        long finish = System.nanoTime();

        long duration1 = finish - start;

        // Ergebnisse ausgeben
        System.out.println("Max/Min Werte für das Array \nArray : " + Arrays.toString(intArray));
        System.out.println("Max : " + y);
        System.out.println("Min : " + x);
        System.out.println("Calculated in " + duration1 + "ns");
        System.out.println("------------------------------");

        /*

        // Algo that runs on 3/2n Runtime

        int[] minArray = new int[(n + 1) / 2];
        int[] maxArray = new int[(n + 1) / 2];

        start = System.nanoTime();

        if (intArray.length % 2 != 0) {
            minArray[minArray.length - 1] = intArray[intArray.length - 1];
            maxArray[maxArray.length - 1] = intArray[intArray.length - 1];
        }
        for (int i = 0; i < intArray.length - 1; i += 2) {
            if (intArray[i] < intArray[i + 1]) {
                minArray[(i / 2)] = intArray[i];
                maxArray[(i / 2)] = intArray[i + 1];
            } else {
                maxArray[(i / 2)] = intArray[i];
                minArray[(i / 2)] = intArray[i + 1];
            }
        }

        int x2 = minArray[0];
        int y2 = maxArray[0];

        for (int i = 0; i < (n + 1) / 2; i++) {
            if (x2 > minArray[i]) {
                x2 = minArray[i];
            }
            if (y2 < maxArray[i]) {
                y2 = maxArray[i];
            }
        }

        finish = System.nanoTime();

        long duration2 = finish - start;

        //System.out.println("Array : " + Arrays.toString(intArray));
        //System.out.println("MinArray : " + Arrays.toString(minArray));
        //System.out.println("MaxArray : " + Arrays.toString(maxArray));

        System.out.println("Max : " + y2);
        System.out.println("Min : " + x2);
        System.out.println("Calculated in " + duration2 + "ms");

        System.out.println("------------------------------");

        System.out.println("Second Algo was " + (duration1 - duration2) + "ms faster");

         */

    }
}
