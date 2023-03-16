package question3;


import java.util.Scanner;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  private static void printArray(char[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
    }
    System.out.println();
  }

  private static void swapStones(char[] array, int first, int second) {
    char aux = array[first];
    array[first] = array[second];
    array[second] = aux;
  }

  public static void main(String[] args) {
    int a = 0, b = 0, totalCost = 0;
    String stonesString = null;

    a = sc.nextInt();
    b = sc.nextInt();

    stonesString = sc.next();

    char[] stonesArray = stonesString.toCharArray();
    int sequencySize = stonesArray.length;

    for (int i = 0; i < sequencySize; i++) {
      // Caso a pedra atual seja branca
      if (stonesArray[i] == 'W') {

        // Procura a próxima pedra preta
        int j = i + 1;
        while (j < sequencySize && stonesArray[j] == 'W') {
          j++;
        }

        // Caso não haja pedras pretas, está ordenado
        if (j == sequencySize) {
          break;
        }

        swapStones(stonesArray, i, j);

        totalCost += a;

        // Caso a troca seja feita em pedras adjacentes
        if (j == i + 1) {
          totalCost -= b;
        }
      }
    }

    System.out.println(totalCost);
    sc.close();
  }
}