package question3;

import java.util.Scanner;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  public static boolean isArraySorted(Integer[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i + 1]) {
        return false;
      }
    }
    return true;
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

  public static void main(String[] args) {
    boolean marceloTurn = true;

    String values[] = sc.nextLine().split(" ");
    Integer[] sequence = new Integer[values.length];

    for (int i = 0; i < values.length; i++) {
      sequence[i] = Integer.valueOf(values[i]);
    }

    while (!isArraySorted(sequence)) {
      int index = findFirstUnsortedPair(sequence);

      if(index != -1) {
        switchNumbers(sequence, index, index + 1);
        marceloTurn = !marceloTurn;
      }
    }

    String winner = marceloTurn ? "Carlos" : "Marcelo";
    System.out.println(winner);
  }
}
