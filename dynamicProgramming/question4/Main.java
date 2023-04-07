package dynamicProgramming.question4;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        final int quantityOfPipeSizes = scanner.nextInt();
        final int sizeOfProducedPipe = scanner.nextInt();

        int maxSolution = 0;
        HashMap<Integer, Integer> previousSolutions = new HashMap<>();

        for(int ind=0 ; ind<quantityOfPipeSizes ; ind++) {
            int length = scanner.nextInt();
            int value = scanner.nextInt();

            for(int nextLength = length; nextLength <= sizeOfProducedPipe; nextLength++) {
                int remainingLengthSolution = previousSolutions.getOrDefault(nextLength - length, 0);
                if(remainingLengthSolution == 0 && nextLength > length) continue;

                int newSolution = remainingLengthSolution + value;
                int currentSolution = previousSolutions.getOrDefault(nextLength, 0);

                previousSolutions.put(nextLength, Math.max(newSolution, currentSolution));
                maxSolution = Math.max(maxSolution, newSolution);
            }
        }

        System.out.println(maxSolution);
    }
}