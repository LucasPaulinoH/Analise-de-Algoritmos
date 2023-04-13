package dynamicProgramming.question6;

import java.util.Scanner;

public class Main {
  private static final int MOD = 1000000007;

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int exerciseMinutes = sc.nextInt();
      int minDificulty = sc.nextInt();
      int maxDificulty = sc.nextInt();
      sc.close();

      long[] quantityOfPossibleSequences = new long[maxDificulty - minDificulty + 1];
      for (int i = 0; i < quantityOfPossibleSequences.length; i++) {
          quantityOfPossibleSequences[i] = 1;
      }

      for (int i = 2; i <= exerciseMinutes; i++) {
          long[] updateValues = new long[maxDificulty - minDificulty + 1];
          for (int j = 0; j < updateValues.length; j++) {
              updateValues[j] = 0;
              if (j > 0) {
                  updateValues[j] += quantityOfPossibleSequences[j - 1];
              }
              if (j < updateValues.length - 1) {
                  updateValues[j] += quantityOfPossibleSequences[j + 1];
              }
              updateValues[j] %= MOD;
          }
          quantityOfPossibleSequences = updateValues;
      }

      long totalOfPrograms = 0;
      for (int i = 0; i < quantityOfPossibleSequences.length; i++) {
          if (i + minDificulty <= maxDificulty) {
              totalOfPrograms += quantityOfPossibleSequences[i];
              totalOfPrograms %= MOD;
          }
      }

      System.out.println(totalOfPrograms);
  }
}