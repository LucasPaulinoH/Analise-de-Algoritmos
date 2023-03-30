package divideAndConquer.question4;

import java.util.Scanner;

public class Main {
  private static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {

    while (true) {
      int quantityOfValues = sc.nextInt();
      if (quantityOfValues == 0)
        break;

      int[] sequence = new int[quantityOfValues];
      for (int i = 0; i < quantityOfValues; i++) {
        sequence[i] = sc.nextInt();
      }

      String winner = solve(sequence) ? "Carlos" : "Marcelo";
      System.out.println(winner);
    }
  }

  public static boolean solve(int[] sequence) {
    return sort(sequence, 0, sequence.length - 1) % 2 == 0;
  }

  public static int sort(int[] sequence, int left, int right) {
    if (left >= right)
      return 0;

    int middle = (left + right) / 2;
    int inversions = sort(sequence, left, middle) + sort(sequence, middle + 1, right);

    int[] aux = new int[right - left + 1];

    int i = left, j = middle + 1, k = 0;
    while (i <= middle && j <= right) {
      if (sequence[i] <= sequence[j]) {
        aux[k++] = sequence[i++];
      } else {
        inversions += middle - i + 1;
        aux[k++] = sequence[j++];
      }
    }

    while (i <= middle)
      aux[k++] = sequence[i++];
    while (j <= right)
      aux[k++] = sequence[j++];

    for (i = left, k = 0; i <= right; i++, k++) {
      sequence[i] = aux[k];
    }

    return inversions;
  }
}
