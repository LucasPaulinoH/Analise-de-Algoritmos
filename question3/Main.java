package question3;

import java.util.Random;
import java.util.Scanner;

public class Main {
  private static Random rand = new Random();
  private static Scanner sc = new Scanner(System.in);

  public static boolean isArraySorted(Integer[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i + 1]) {
        return false;
      }
    }
    return true;
  }

  public static void printArray(Integer[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  public static void switchNumbers(Integer[] array, int index, int nextIndex) {
    int aux = array[index];
    array[index] = array[nextIndex];
    array[nextIndex] = aux;
  }

  public static int findFirstUnsortedPair(Integer[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        return i - 1;
      }
    }
    return -1;
  }

  public static int findFirstUnsortedPairAtOddIndex(Integer[] array) {
    for (int i = 1; i < array.length; i += 2) {
      if (array[i] < array[i - 1]) {
        return i - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int permutationSize;
    int moves = 0;
    boolean marceloTurn = true;

    System.out.println("Qual o tamanho do arranjo que você deseja? ");
    permutationSize = sc.nextInt();

    Integer[] sequence = new Integer[permutationSize];

    for (int i = 0; i < permutationSize; i++) {
      sequence[i] = rand.nextInt(permutationSize);
    }

    System.out.print("ARRANJO GERADO: ");
    printArray(sequence);
    System.out.println();

    while (!isArraySorted(sequence)) {
      if (marceloTurn) {
        System.out.println("==== TURNO DE MARCELO ====");
        int index = findFirstUnsortedPair(sequence);
        switchNumbers(sequence, index, index + 1);
        printArray(sequence);
      } else {
        System.out.println("==== TURNO DE CARLOS ====");
        int index = findFirstUnsortedPairAtOddIndex(sequence);
        switchNumbers(sequence, index, index + 1);
        printArray(sequence);
      }
      moves++;
      marceloTurn = !marceloTurn;
    }

    String winner = marceloTurn ? "Carlos" : "Marcelo";
    System.out.println(winner + " ganhou depois de " + moves + " movimentos.");
  }
}
