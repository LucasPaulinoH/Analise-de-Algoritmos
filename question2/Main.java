package question2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  public static double getDistance(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }

  public static void printPointHeader(int i) {
    System.out.println((i + 1) + "° Ponto");
    System.out.println("========");
  }

  public static void main(String[] args) {
    double minimumDistance = Double.MAX_VALUE;
    double testingDistance;
    List<int[]> pairs = new ArrayList<int[]>();

    System.out.print("Quantos pontos deseja criar? ");
    int quantityOfPoints = sc.nextInt();

    System.out.println();

    int[][] points = new int[quantityOfPoints][2];

    for (int i = 0; i < quantityOfPoints; i++) {
      printPointHeader(i);

      System.out.print("x: ");
      points[i][0] = sc.nextInt();

      System.out.print("y: ");
      points[i][1] = sc.nextInt();

      System.out.println();
    }

    for (int i = 0; i < quantityOfPoints; i++) {
      for (int j = i + 1; j < quantityOfPoints; j++) {
        testingDistance = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);

        if (testingDistance < minimumDistance) {
          minimumDistance = testingDistance;
          pairs.clear();
          pairs.add(new int[] { i, j });
        } else if (testingDistance == minimumDistance) {
          pairs.add(new int[] { i, j });
        }
      }
    }

    System.out.println("A distância mínima entre os pontos é: " + minimumDistance);
    System.out.println("Pares de pontos com a menor distância:");

    for (int[] pair : pairs) {
      System.out.println("(" + points[pair[0]][0] + "," + points[pair[0]][1] + ") e (" + points[pair[1]][0] + ","
          + points[pair[1]][1] + ")");
    }
  }
}
