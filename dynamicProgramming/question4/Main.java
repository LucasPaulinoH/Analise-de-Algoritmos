package dynamicProgramming.question4;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        final int quantityOfPipeSizes = scanner.nextInt();
        final int sizeOfProducedPipe = scanner.nextInt();

        int maxSolution = 0;
        int[] maxValuesForEachLength = new int[sizeOfProducedPipe + 1];

        for(int ind=0 ; ind<quantityOfPipeSizes ; ind++) {
            int length = scanner.nextInt();
            int value = scanner.nextInt();

            for(int nextLength = length; nextLength <= sizeOfProducedPipe; nextLength++) {
                int remainingLengthSolution = maxValuesForEachLength[nextLength - length];
                if(remainingLengthSolution == 0 && nextLength > length) continue;

                int newSolution = remainingLengthSolution + value;
                int currentSolution = maxValuesForEachLength[nextLength];

                maxValuesForEachLength[nextLength] = Math.max(newSolution, currentSolution);
                maxSolution = Math.max(maxSolution, newSolution);
            }
        }

        System.out.println(maxSolution);
    }
}