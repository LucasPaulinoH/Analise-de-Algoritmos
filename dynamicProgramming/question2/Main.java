package dynamicProgramming.question2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  private static boolean findSubgroupsWithSSize(int[] array, int s) {
    boolean[] verificationArray = new boolean[s + 1];
    Arrays.fill(verificationArray, false);
    verificationArray[0] = true;

    for (int i = 0; i < array.length; i++) {
      for (int j = s; j >= array[i]; j--) {
        if (verificationArray[j - array[i]] == true)
          verificationArray[j] = true;
      }
    }
    return verificationArray[s];
  }

  public static void main(String[] args) {
    int arraySize, s;

    System.out.print("Digite o tamanho do vetor: ");
    arraySize = sc.nextInt();

    int[] array = new int[arraySize];

    System.out.print("Digite os valores do vetor: ");
    for (int i = 0; i < array.length; i++) {
      array[i] = sc.nextInt();
    }

    System.out.print("Defina o valor S: ");
    s = sc.nextInt();

    System.out.println(findSubgroupsWithSSize(array, s));

    sc.close();
  }
}
