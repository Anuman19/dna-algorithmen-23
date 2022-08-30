package pva1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Aufgabe 1
// Der Algo gibt den Eintrag mit dem höchsten/niedrigsten Wert zurück.

// Aufgabe 2
// Siehe Code Unten

// Aufgabe 3
// Der Algo geht zwei mal das gesamte Array durch. einmal für max und einmal für min.
// Insgesamt gibt es also 2(n-1) Vergleiche.
// (n-1) weil wir ja das erste Element nicht vergleichen, sondern direkt speichern.

// Aufgabe 4


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
      intArray[i] = random.nextInt(1, 1000);
    }

    // Startwerte für max und min auf das erste Element des Arrays setzen
    int x = intArray[0];
    int y = intArray[0];

    // Das Array einzeln durchgehen ob ein Eintrag kleiner/grösser ist.
    // Geht auch mit der foreach Schreibweise.
    // Im Beispiel/PseudoCode war eine for Schlaufe.
    for (int i = 0; i < n; i++) {
      if (x > intArray[i]) {
        x = intArray[i];
      }
      if (y < intArray[i]) {
        y = intArray[i];
      }
    }

    // Ergebnisse ausgeben
    System.out.println("Max/Min Werte für das Array \n" + Arrays.toString(intArray));
    System.out.println("Max : " + y);
    System.out.println("Min : " + x);
  }
}
