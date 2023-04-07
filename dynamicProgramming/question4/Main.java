package dynamicProgramming.question4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static class PipeData {
        public int length, value;

        public PipeData(int length, int value) {
            this.length = length;
            this.value = value;
        }
    }

    public static void main(String args[]) {
        final int quantityOfPipeSizes = scanner.nextInt();
        final int sizeOfProducedPipe = scanner.nextInt();

        List<PipeData> orderedPipes = new ArrayList<>(quantityOfPipeSizes);
        int maxSolution = 0;

        for(int ind=0 ; ind<quantityOfPipeSizes ; ind++) {
            int length = scanner.nextInt();
            int value = scanner.nextInt();
            
            orderedPipes.add(new PipeData(length, value));
            maxSolution = value > maxSolution ? value : maxSolution;
        }
        
        List<PipeData> previousSolutions = orderedPipes;
        List<PipeData> currentSolutions;
        
        do {
            int previousSolutionsSize = previousSolutions.size();
            currentSolutions = new ArrayList<>(previousSolutionsSize*2);

            for(int i=0 ; i<quantityOfPipeSizes ; i++) {
                int pipeValue = orderedPipes.get(i).value;
                int pipeLength = orderedPipes.get(i).length;

                for(int j=0 ; j<previousSolutionsSize ; j++) {
                    PipeData previousSolution = previousSolutions.get(j);
                    int solutionLength = previousSolution.length + pipeLength;
                    if(solutionLength > sizeOfProducedPipe) continue;
                    
                    int solutionValue = previousSolution.value + pipeValue;
                    currentSolutions.add(new PipeData(solutionLength, solutionValue));
                    maxSolution = solutionValue > maxSolution ? solutionValue : maxSolution;
                }
            }

            previousSolutions = currentSolutions;
        } while(currentSolutions.size() > 0);

        System.out.println(maxSolution);
    }
}