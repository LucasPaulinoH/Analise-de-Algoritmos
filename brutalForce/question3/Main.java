package brutalForce.question3;

import java.util.Scanner;

public class Main {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int quantityOfValues;

    while((quantityOfValues = scanner.nextInt()) != 0) {
      boolean marceloTurn = true;
      int sequence[] = new int[quantityOfValues];

      for (int i = 0 ; i < quantityOfValues ; i++) {
        sequence[i] = scanner.nextInt();
      }

      int index = 0;
      while (index != -1) {
        index = findFirstUnsortedPair(sequence);

        if(index != -1) {
          switchNumbers(sequence, index, index + 1);
          marceloTurn = !marceloTurn;
        }
      }

      String winner = marceloTurn ? "Carlos" : "Marcelo";
      System.out.println(winner);
    }
  }

  private static void switchNumbers(
    int array[], int index, int nextIndex
  ) {
    int aux = array[index];
    array[index] = array[nextIndex];
    array[nextIndex] = aux;
  }

  private static int findFirstUnsortedPair(int array[]) {
    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        return i - 1;
      }
    }
    return -1;
  }
}
