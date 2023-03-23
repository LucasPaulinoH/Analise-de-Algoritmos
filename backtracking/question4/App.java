package backtracking.question4;

import java.util.Scanner;

public class App {
  private static Scanner sc = new Scanner(System.in);

  public static boolean search(int[][] maze, boolean[][] visited, int r, int c) {
    // caso a posição atual seja inválida
    if (r < 0 || c < 0 || r >= 5 || c >= 5 || visited[r][c] || maze[r][c] == 1)
      return false;

    if (r == 4 && c == 4) // condição de vitória para os policiais
      return true;

    // passa recursivamente a verificação para as posições vizinhas
    if (search(maze, visited, r + 1, c) ||
        search(maze, visited, r - 1, c) ||
        search(maze, visited, r, c + 1) ||
        search(maze, visited, r, c - 1))
      return true;

    return false;
  }

  public static void main(String[] args) {
    int numberOfTests;
    int testsCount = 0;

    numberOfTests = sc.nextInt();

    while (testsCount < numberOfTests) {
      int[][] maze = new int[5][5];

      for (int r = 0; r < 5; r++) {
        for (int c = 0; c < 5; c++) {
          maze[r][c] = sc.nextInt();
        }
      }

      // matriz auxiliar para demarcar quais espaços já foram visitados
      boolean[][] visited = new boolean[5][5];

      // passa a posição inicial dos policiais para a função de busca
      boolean didCopsWin = search(maze, visited, 0, 0);

      if (didCopsWin)
        System.out.println("COPS");
      else
        System.out.println("ROBBERS");

      testsCount++;
    }
  }
}
