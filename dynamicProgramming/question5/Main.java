package dynamicProgramming.question5;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wallWidth = scanner.nextInt();
        int[] wallColumns = new int[wallWidth];

        for (int i = 0; i < wallWidth; i++) {
            wallColumns[i] = scanner.nextInt();
        }

        
        int[] leftSide = new int[wallWidth]; 
        leftSide[0] = 1;

        for (int i = 1; i < wallWidth; i++) {
            // Menor altura entre a altura da coluna atual ou a altura da coluna anterior + 1
            leftSide[i] = Math.min(wallColumns[i], leftSide[i - 1] + 1);
        }

        int[] rightSide = new int[wallWidth];
        rightSide[wallWidth - 1] = 1;

        for (int i = wallWidth - 2; i >= 0; i--) {
            // Menor altura entre a altura da coluna atual ou a altura da proxima coluna + 1
            rightSide[i] = Math.min(wallColumns[i], rightSide[i + 1] + 1);
        }

        int maxHeightOfTriangle = 0;

        // Verifica a altura máxima do triângulo
        for (int i = 0; i < wallWidth; i++) {
            // Compara em cada coluna qual seria a maior altura triângulo possivel
            int alturaTriangulo = Math.min(leftSide[i], rightSide[i]);

            if (alturaTriangulo > maxHeightOfTriangle) {
                maxHeightOfTriangle = alturaTriangulo;
            }
        }

        System.out.println(maxHeightOfTriangle);
    }
}
